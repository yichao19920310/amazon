/**  
 * @Title: ICartBiz.java  
 * @Package com.yc.biz  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月22日  
 * @version V1.0  
*/  
package com.yc.biz;

import java.util.List;

import com.yc.bean.Cart;
import com.yc.bean.User;

/**  
 * @ClassName: ICartBiz  
 * @Description: 购物车业务接口
 * @author admin  
 * @date 2018年1月22日  
 *    
*/
public interface ICartBiz {

	/**
	 * 
	 * @Title: showCart  
	 * @Description: 根据用户显示购物车    
	 * @param user
	 * @return 返回类型List<Cart>        
	 * @throws
	 */
	List<Cart> showCart(User user);

	/**
	 * 
	 * @Title: addCart  
	 * @Description: 添加购物车  
	 * @param cart
	 * @return 返回类型boolean        
	 * @throws
	 */
	boolean addCart(Cart cart);

	/**  
	 * @Title: changeCartCount  
	 * @Description: 更改购物车商品数量
	 * @param cartId
	 * @param quantity
	 * @return 返回类型boolean        
	 * @throws  
	 */  
	boolean changeCartCount(int cartId, int quantity);

}
