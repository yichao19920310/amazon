/**  
 * @Title: IOrderDao.java  
 * @Package com.yc.dao  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月23日  
 * @version V1.0  
*/  
package com.yc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.wrappers.SqlNullCheckedResultSet;

import com.yc.bean.Order;
import com.yc.bean.OrderDetail;

/**  
 * @ClassName: IOrderDao  
 * @Description: 订单数据接口  
 * @author admin  
 * @date 2018年1月23日  
 *    
*/
public interface IOrderDao {

	/**  
	 * @Title: insertOrder  
	 * @Description: 向数据库插入订单  
	 * @param order
	 * @return 返回类型int        
	 * @throws SQLException 
	 */  
	int insertOrder(Order order) throws SQLException;

	/**  
	 * @Title: getLastOrderByUser  
	 * @Description: 通过用户id获取最近的一条订单对象
	 * @param ho_user_id
	 * @return 返回类型Order        
	 * @throws SQLException 
	 */  
	Order getLastOrderByUser(int ho_user_id) throws SQLException;

	/**  
	 * @Title: insertOrderDetail  
	 * @Description: 数据库插入订单详情 
	 * @param od
	 * @return 返回类型int        
	 * @throws  
	 */  
	int insertOrderDetail(OrderDetail od) throws SQLException;

	/**
	 * @throws SQLException   
	 * @Title: getOrderById  
	 * @Description: 通过id获取order对象 
	 * @param oId
	 * @return 返回类型Order        
	 * @throws  
	 */  
	Order getOrderById(int oId) throws SQLException;

	/**
	 * @throws SQLException   
	 * @Title: getOrderDetailByOrderId  
	 * @Description: 通过订单id获取订单详情对象列表
	 * @param oId
	 * @return 返回类型List<OrderDetail>        
	 * @throws  
	 */  
	List<OrderDetail> getOrderDetailByOrderId(int oId) throws SQLException;

}
