/**  
 * @Title: ICartDao.java  
 * @Package com.yc.dao  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月22日  
 * @version V1.0  
*/  
package com.yc.dao;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Cart;

/**  
 * @ClassName: ICartDao  
 * @Description: 购物车数据接口
 * @author admin  
 * @date 2018年1月22日  
 *    
*/
public interface ICartDao {

	/**  
	 * @Title: getCartByUser  
	 * @Description: 通过用户id查询购物车集合 
	 * @param hu_user_id
	 * @return 返回类型List<Cart>        
	 * @throws  SQLException
	 */  
	List<Cart> getCartByUser(int hu_user_id) throws SQLException;

	/**  
	 * @Title: getCartByUserAndProd  
	 * @Description: 通过用户id和商品id查询对应购物车对象
	 * @param userId
	 * @param pid
	 * @return 返回类型Cart        
	 * @throws SQLException 
	 */  
	Cart getCartByUserAndProd(int userId, int pid) throws SQLException;

	/**  
	 * @Title: InsertCart  
	 * @Description: 插入购物车 
	 * @param cart
	 * @return 返回类型int        
	 * @throws SQLException 
	 */  
	int insertCart(Cart cart) throws SQLException;

	/**  
	 * @Title: updateCart  
	 * @Description: 更新合并相同商品的购物车 
	 * @param cart
	 * @return 返回类型int        
	 * @throws SQLException 
	 */  
	int updateCart(Cart cart) throws SQLException;

	/**
	 * @throws SQLException   
	 * @Title: getCartById  
	 * @Description: 通过id获得购物车对象
	 * @param cartId
	 * @return 返回类型Cart        
	 * @throws  
	 */  
	Cart getCartById(int cartId) throws SQLException;

	/**
	 * @throws SQLException   
	 * @Title: updateCartById  
	 * @Description: 通过id更新购物车商品数
	 * @param cartId
	 * @param quantity
	 * @return 返回类型int        
	 * @throws  
	 */  
	int updateCartById(int cartId, int quantity) throws SQLException;

	/**
	 * @throws SQLException   
	 * @Title: deleteCartById  
	 * @Description: 通过id删除购物车
	 * @param cartId
	 * @return 返回类型int        
	 * @throws  
	 */  
	int deleteCartById(int cartId) throws SQLException;

	/**  
	 * @Title: deleteCartByUser  
	 * @Description: 结算后清空用户购物车  
	 * @param ho_user_id 用户id
	 * @return 返回类型int        
	 * @throws SQLException 
	 */  
	int deleteCartByUser(int ho_user_id) throws SQLException;

}
