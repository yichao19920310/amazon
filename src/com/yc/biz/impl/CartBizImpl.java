/**  
 * @Title: CartBizImpl.java  
 * @Package com.yc.biz.impl  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月22日  
 * @version V1.0  
*/  
package com.yc.biz.impl;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Cart;
import com.yc.bean.Product;
import com.yc.bean.User;
import com.yc.biz.ICartBiz;
import com.yc.dao.ICartDao;
import com.yc.dao.IProductDao;
import com.yc.dao.impl.CartDaoImpl;
import com.yc.dao.impl.ProductDaoImpl;
import com.yc.tools.JDBCUtils;

/**  
 * @ClassName: CartBizImpl  
 * @Description: 购物车业务实现  
 * @author admin  
 * @date 2018年1月22日  
 *    
*/
public class CartBizImpl implements ICartBiz {

	private ICartDao iCartD = new CartDaoImpl();
	private IProductDao iProdD = new ProductDaoImpl();
	/* (非 Javadoc)  
	 * <p>Title: showCart</p>  
	 * <p>Description: </p>  
	 * @param user
	 * @return  
	 * @see com.yc.biz.ICartBiz#showCart(com.yc.bean.User)  
	*/  
	@Override
	public List<Cart> showCart(User user) {
		List<Cart> cartList = null;
		try {
			cartList = iCartD.getCartByUser(user.getHu_user_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(cartList!=null){
			for (Cart cart : cartList) {
				try {
					Product pro = iProdD.getProductById(cart.getPid());
					cart.setProduct(pro);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
		return cartList;
	}
	/* (非 Javadoc)  
	 * <p>Title: addCart</p>  
	 * <p>Description: </p>  
	 * @param cart
	 * @return  
	 * @see com.yc.biz.ICartBiz#addCart(com.yc.bean.Cart)  
	*/  
	@Override
	public boolean addCart(Cart cart) {
		if(cart==null){
			return false;
		}
		Cart temp = null;
		try {
			temp = iCartD.getCartByUserAndProd(cart.getUserId(),cart.getPid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(temp==null){
			int row = 0;			
			try {
				JDBCUtils.beginTransaction();//开启事务
				row += iProdD.minusProductStock(cart.getPid(),cart.getQuantity());				
				row += iCartD.insertCart(cart);
				JDBCUtils.commitTransaction();//提交事务
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					JDBCUtils.rollbackTransaction();//回滚事务
				} catch (SQLException e1) {
				}
			}
			if(row==2){
				return true;
			}
		}else{
			int row = 0;			
			try {
				JDBCUtils.beginTransaction();//开启事务
				row += iProdD.minusProductStock(cart.getPid(),cart.getQuantity());				
				row += iCartD.updateCart(cart);
				JDBCUtils.commitTransaction();//提交事务
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					JDBCUtils.rollbackTransaction();//回滚事务
				} catch (SQLException e1) {
				}
			}
			if(row==2){
				return true;
			}
		}
		
		return false;
	}
	/* (非 Javadoc)  
	 * <p>Title: changeCartCount</p>  
	 * <p>Description: </p>  
	 * @param cartId
	 * @param quantity
	 * @return  
	 * @see com.yc.biz.ICartBiz#changeCartCount(int, int)  
	*/  
	@Override
	public boolean changeCartCount(int cartId, int quantity) {
		Cart cart = null;
		try {
			cart = iCartD.getCartById(cartId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(cart==null){
			return false;
		}
		int change = quantity - cart.getQuantity();
		int row = 0;			
		try {
			JDBCUtils.beginTransaction();//开启事务
			row += iProdD.minusProductStock(cart.getPid(),change);				
			row += iCartD.updateCartById(cartId,quantity);
			JDBCUtils.commitTransaction();//提交事务
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				JDBCUtils.rollbackTransaction();//回滚事务
			} catch (SQLException e1) {
			}
		}
		if(row==2){
			return true;
		}
		return false;
	}
	
}
