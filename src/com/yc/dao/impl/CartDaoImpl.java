/**  
 * @Title: CartDaoImpl.java  
 * @Package com.yc.dao.impl  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月22日  
 * @version V1.0  
*/  
package com.yc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yc.bean.Cart;
import com.yc.dao.ICartDao;
import com.yc.tools.JDBCUtils;

/**  
 * @ClassName: CartDaoImpl  
 * @Description: 购物车数据实现 
 * @author admin  
 * @date 2018年1月22日  
 *    
*/
public class CartDaoImpl implements ICartDao {

	/* (非 Javadoc)  
	 * <p>Title: getCartByUser</p>  
	 * <p>Description: </p>  
	 * @param hu_user_id
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.ICartDao#getCartByUser(int)  
	*/  
	@Override
	public List<Cart> getCartByUser(int hu_user_id) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT ID, PID, QUANTITY, USERID "
				+ "FROM HWUA_CART "
				+ "WHERE USERID = ?";
		return run.query(sql, new BeanListHandler<>(Cart.class), hu_user_id);
	}

	/* (非 Javadoc)  
	 * <p>Title: getCartByUserAndProd</p>  
	 * <p>Description: </p>  
	 * @param userId
	 * @param getpId
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.ICartDao#getCartByUserAndProd(int, int)  
	*/  
	@Override
	public Cart getCartByUserAndProd(int userId, int pid) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT ID, PID, QUANTITY, USERID "
				+ "FROM HWUA_CART "
				+ "WHERE USERID = ? AND PID = ?";
		return run.query(sql, new BeanHandler<>(Cart.class), userId,pid);
	}

	/* (非 Javadoc)  
	 * <p>Title: InsertCart</p>  
	 * <p>Description: </p>  
	 * @param cart
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.ICartDao#InsertCart(com.yc.bean.Cart)  
	*/  
	@Override
	public int insertCart(Cart cart) throws SQLException {
		QueryRunner run =  new QueryRunner();//事务用这个
		String sql = "INSERT INTO HWUA_CART "
				+ "(ID, PID, QUANTITY, USERID) "
				+ "VALUES(SEQ_HWUA_CART.NEXTVAL,?,?,?)";
		return run.update(JDBCUtils.getConnection(),sql,cart.getPid(),cart.getQuantity(),cart.getUserId());
	}

	/* (非 Javadoc)  
	 * <p>Title: updateCart</p>  
	 * <p>Description: </p>  
	 * @param cart
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.ICartDao#updateCart(com.yc.bean.Cart)  
	*/  
	@Override
	public int updateCart(Cart cart) throws SQLException {
		QueryRunner run =  new QueryRunner();//事务用这个
		String sql = "UPDATE HWUA_CART "
				+ "SET QUANTITY = QUANTITY + ? "
				+ "WHERE PID = ? AND USERID = ?";
		return run.update(JDBCUtils.getConnection(),sql,cart.getQuantity(),cart.getPid(),cart.getUserId());
	}

	/* (非 Javadoc)  
	 * <p>Title: getCartById</p>  
	 * <p>Description: </p>  
	 * @param cartId
	 * @return  
	 * @see com.yc.dao.ICartDao#getCartById(int)  
	*/  
	@Override
	public Cart getCartById(int cartId) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT ID, PID, QUANTITY, USERID "
				+ "FROM HWUA_CART "
				+ "WHERE ID = ?";
		return run.query(sql, new BeanHandler<>(Cart.class), cartId);
	}

	/* (非 Javadoc)  
	 * <p>Title: updateCartById</p>  
	 * <p>Description: </p>  
	 * @param cartId
	 * @param quantity
	 * @return  
	 * @see com.yc.dao.ICartDao#updateCartById(int, int)  
	*/  
	@Override
	public int updateCartById(int cartId, int quantity) throws SQLException {
		QueryRunner run =  new QueryRunner();//事务用这个
		String sql = "UPDATE HWUA_CART "
				+ "SET QUANTITY = ? "
				+ "WHERE ID = ?";
		return run.update(JDBCUtils.getConnection(),sql,quantity,cartId);
	}

}
