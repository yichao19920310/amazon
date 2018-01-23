/**  
 * @Title: OrderDaoImpl.java  
 * @Package com.yc.dao.impl  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月23日  
 * @version V1.0  
*/  
package com.yc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yc.bean.Order;
import com.yc.bean.OrderDetail;
import com.yc.dao.IOrderDao;
import com.yc.tools.JDBCUtils;

/**  
 * @ClassName: OrderDaoImpl  
 * @Description: 订单数据实现  
 * @author admin  
 * @date 2018年1月23日  
 *    
*/
public class OrderDaoImpl implements IOrderDao {

	/* (非 Javadoc)  
	 * <p>Title: insertOrder</p>  
	 * <p>Description: </p>  
	 * @param order
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.IOrderDao#insertOrder(com.yc.bean.Order)  
	*/  
	@Override
	public int insertOrder(Order order) throws SQLException {
		QueryRunner run =  new QueryRunner();//事务用这个
		String sql = "INSERT INTO HWUA_ORDER "
				+ "(HO_ID,HO_USER_ID,HO_USER_NAME,HO_USER_ADDRESS,"
				+ "HO_CREATE_TIME,HO_COST,HO_STATUS,HO_TYPE) "
				+ "VALUES(SEQ_ORDER.NEXTVAL,?,?,?,SYSDATE,?,1,1)";
		return run.update(JDBCUtils.getConnection(), sql, order.getHo_user_id(),
				order.getHo_user_name(),order.getHo_user_address(),
				order.getHo_cost());
	}

	/* (非 Javadoc)  
	 * <p>Title: getLastOrderByUser</p>  
	 * <p>Description: </p>  
	 * @param ho_user_id
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.IOrderDao#getLastOrderByUser(int)  
	*/  
	@Override
	public Order getLastOrderByUser(int ho_user_id) throws SQLException {
		QueryRunner run =  new QueryRunner();//事务用这个
		String sql = "SELECT M.* "
				+ "FROM(SELECT T.* "
				+ "FROM(SELECT HO_ID,HO_USER_ID,HO_USER_NAME,HO_USER_ADDRESS,"
				+ "HO_CREATE_TIME,HO_COST,HO_STATUS,HO_TYPE "
				+ "FROM HWUA_ORDER "
				+ "WHERE HO_USER_ID = ?) T "
				+ "ORDER BY (HO_CREATE_TIME) DESC) M "
				+ "WHERE ROWNUM = 1";
		return run.query(JDBCUtils.getConnection(), sql, new BeanHandler<>(Order.class), ho_user_id);
	}

	/* (非 Javadoc)  
	 * <p>Title: insertOrderDetail</p>  
	 * <p>Description: </p>  
	 * @param od
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.IOrderDao#insertOrderDetail(com.yc.bean.OrderDetail)  
	*/  
	@Override
	public int insertOrderDetail(OrderDetail od) throws SQLException {
		QueryRunner run =  new QueryRunner();//事务用这个
		String sql = "INSERT INTO HWUA_ORDER_DETAIL "
				+ "(HOD_ID,HO_ID,HP_ID,HOD_QUANTITY,HOD_COST) "
				+ "VALUES(SEQ_DETAIL.NEXTVAL,?,?,?,?)";
		return run.update(JDBCUtils.getConnection(), sql, od.getHo_id(),od.getHp_id(),
				od.getHod_quantity(),od.getHod_cost());
	}

	/* (非 Javadoc)  
	 * <p>Title: getOrderById</p>  
	 * <p>Description: </p>  
	 * @param oId
	 * @return  
	 * @see com.yc.dao.IOrderDao#getOrderById(int)  
	*/  
	@Override
	public Order getOrderById(int oId) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HO_ID,HO_USER_ID,HO_USER_NAME,HO_USER_ADDRESS,"
				+ "HO_CREATE_TIME,HO_COST,HO_STATUS,HO_TYPE "
				+ "FROM HWUA_ORDER "
				+ "WHERE HO_ID = ?";
		return run.query(sql, new BeanHandler<>(Order.class),oId);
	}

	/* (非 Javadoc)  
	 * <p>Title: getOrderDetailByOrderId</p>  
	 * <p>Description: </p>  
	 * @param oId
	 * @return  
	 * @see com.yc.dao.IOrderDao#getOrderDetailByOrderId(int)  
	*/  
	@Override
	public List<OrderDetail> getOrderDetailByOrderId(int oId) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HOD_ID,HO_ID,HP_ID,HOD_QUANTITY,HOD_COST "
				+ "FROM HWUA_ORDER_DETAIL "
				+ "WHERE HO_ID = ?";
		return run.query(sql, new BeanListHandler<>(OrderDetail.class),oId);
	}

	
}
