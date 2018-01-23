/**  
 * @Title: IOrderBiz.java  
 * @Package com.yc.biz  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月23日  
 * @version V1.0  
*/  
package com.yc.biz;

import java.util.List;

import com.yc.bean.Order;
import com.yc.bean.OrderDetail;

/**  
 * @ClassName: IOrderBiz  
 * @Description: 订单业务接口  
 * @author admin  
 * @date 2018年1月23日  
 *    
*/
public interface IOrderBiz {

	/**
	 * 
	 * @Title: createOrder  
	 * @Description: 生成订单 
	 * @param order 订单对象
	 * @param odList 订单详情对象列表
	 * @return 返回类型int  生成后的订单id,如果失败返回-1    
	 * @throws
	 */
	int createOrder(Order order, List<OrderDetail> odList);

	/**  
	 * @Title: getOrder  
	 * @Description: 通过订单id获取order对象  
	 * @param oId
	 * @return 返回类型Order        
	 * @throws  
	 */  
	Order getOrder(int oId);

	/**  
	 * @Title: getOrderDetailList  
	 * @Description: 通过订单id获取orderdetail对象集合 
	 * @param oId
	 * @return 返回类型List<OrderDetail>        
	 * @throws  
	 */  
	List<OrderDetail> getOrderDetailList(int oId);

}
