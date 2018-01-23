/**  
 * @Title: OrderBizImpl.java  
 * @Package com.yc.biz.impl  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月23日  
 * @version V1.0  
*/  
package com.yc.biz.impl;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Order;
import com.yc.bean.OrderDetail;
import com.yc.bean.Product;
import com.yc.biz.IOrderBiz;
import com.yc.dao.ICartDao;
import com.yc.dao.IOrderDao;
import com.yc.dao.IProductDao;
import com.yc.dao.impl.CartDaoImpl;
import com.yc.dao.impl.OrderDaoImpl;
import com.yc.dao.impl.ProductDaoImpl;
import com.yc.tools.JDBCUtils;

/**  
 * @ClassName: OrderBizImpl  
 * @Description: 订单业务实现
 * @author admin  
 * @date 2018年1月23日  
 *    
*/
public class OrderBizImpl implements IOrderBiz {

	private static IOrderDao iOrdeD = new OrderDaoImpl();
	private static ICartDao iCartD = new CartDaoImpl();
	private static IProductDao iProdD = new ProductDaoImpl();
	/* (非 Javadoc)  
	 * <p>Title: createOrder</p>  
	 * <p>Description: </p>  
	 * @param order
	 * @param odList
	 * @return  
	 * @see com.yc.biz.IOrderBiz#createOrder(com.yc.bean.Order, java.util.List)  
	*/  
	@Override
	public int createOrder(Order order, List<OrderDetail> odList) {
		int row = 0;	
		int oId = 0;
		try {
			JDBCUtils.beginTransaction();//开启事务
			row += iOrdeD.insertOrder(order);
			//System.out.println("row="+row);
			oId = iOrdeD.getLastOrderByUser(order.getHo_user_id()).getHo_id();
			for (OrderDetail od : odList) {
				od.setHo_id(oId);
				row += iOrdeD.insertOrderDetail(od);
				//System.out.println("row="+row);
			}
			row += iCartD.deleteCartByUser(order.getHo_user_id());
			//System.out.println("row="+row);
			JDBCUtils.commitTransaction();//提交事务
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				JDBCUtils.rollbackTransaction();//回滚事务
			} catch (SQLException e1) {
			}
		}
		//System.out.println("row="+row);
		//System.out.println(odList.size());
		if(row == 1 + odList.size()*2){
			return oId;
		}
		return -1;		
	}
	/* (非 Javadoc)  
	 * <p>Title: getOrder</p>  
	 * <p>Description: </p>  
	 * @param oId
	 * @return  
	 * @see com.yc.biz.IOrderBiz#getOrder(int)  
	*/  
	@Override
	public Order getOrder(int oId) {
		Order order = null;
		try {
			order = iOrdeD.getOrderById(oId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	/* (非 Javadoc)  
	 * <p>Title: getOrderDetailList</p>  
	 * <p>Description: </p>  
	 * @param oId
	 * @return  
	 * @see com.yc.biz.IOrderBiz#getOrderDetailList(int)  
	*/  
	@Override
	public List<OrderDetail> getOrderDetailList(int oId) {
		List<OrderDetail> odList = null;
		try {
			odList = iOrdeD.getOrderDetailByOrderId(oId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(odList!=null){
			for (OrderDetail od : odList) {
				try {
					Product product = iProdD.getProductById(od.getHp_id());
					od.setProduct(product);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return odList;
	}

}
