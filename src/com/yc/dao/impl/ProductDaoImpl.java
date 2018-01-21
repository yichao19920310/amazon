/**  
 * @Title: ProductDaoImpl.java  
 * @Package com.yc.dao.impl  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yc.bean.Product;
import com.yc.dao.IProductDao;
import com.yc.tools.JDBCUtils;

/**  
 * @ClassName: ProductDaoImpl  
 * @Description: 商品数据实现
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public class ProductDaoImpl implements IProductDao {

	/* (非 Javadoc)  
	 * <p>Title: getAllproductQueryCount</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.yc.dao.IProductDao#getAllproductQueryCount()  
	*/  
	@Override
	public int getAllProductQueryCount() throws SQLException {
		int count = -1;
		//贾琏
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT COUNT(HP_ID) FROM HWUA_PRODUCT";
		//欲
		PreparedStatement ps = conn.prepareStatement(sql);
		//执
		ResultSet rs = ps.executeQuery();
		//事
		if(rs.next()){
			count = rs.getInt(1);
		}
		//毙
		rs.close();
		ps.close();
		conn.close();
		return count;
	}

	/* (非 Javadoc)  
	 * <p>Title: getProductQueryList</p>  
	 * <p>Description: </p>  
	 * @param start
	 * @param end
	 * @return  
	 * @see com.yc.dao.IProductDao#getProductQueryList(int, int)  
	*/  
	@Override
	public List<Product> getProductQueryList(int start, int end) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HP_ID,HP_NAME,HP_DESCRIPTION,HP_PRICE,"
				+ "HP_STOCK,HPC_ID,HPC_CHILD_ID,HP_FILE_NAME "
				+ "FROM (SELECT ROWNUM R,HWUA_PRODUCT.* FROM HWUA_PRODUCT) T "
				+ "WHERE T.R>? AND T.R<=?";
		return run.query(sql, new BeanListHandler<>(Product.class),start,end);
	}

	/* (非 Javadoc)  
	 * <p>Title: getAllProductQueryCountByParent</p>  
	 * <p>Description: </p>  
	 * @param parentId
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.IProductDao#getAllProductQueryCountByParent(int)  
	*/  
	@Override
	public int getAllProductQueryCountByParent(int parentId) throws SQLException {
		int count = -1;
		//贾琏
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT COUNT(HP_ID) FROM HWUA_PRODUCT WHERE HPC_ID = ?";
		//欲
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, parentId);
		//执
		ResultSet rs = ps.executeQuery();
		//事
		if(rs.next()){
			count = rs.getInt(1);
		}
		//毙
		rs.close();
		ps.close();
		conn.close();
		return count;
	}

	/* (非 Javadoc)  
	 * <p>Title: getProductQueryListByParent</p>  
	 * <p>Description: </p>  
	 * @param start
	 * @param end
	 * @param parentId
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.IProductDao#getProductQueryListByParent(int, int, int)  
	*/  
	@Override
	public List<Product> getProductQueryListByParent(int start, int end, int parentId) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HP_ID,HP_NAME,HP_DESCRIPTION,HP_PRICE,"
				+ "HP_STOCK,HPC_ID,HPC_CHILD_ID,HP_FILE_NAME "
				+ "FROM (SELECT ROWNUM R,HWUA_PRODUCT.* FROM HWUA_PRODUCT WHERE HPC_ID = ?) T "
				+ "WHERE T.R>? AND T.R<=?";
		return run.query(sql, new BeanListHandler<>(Product.class),parentId,start,end);
	}

	/* (非 Javadoc)  
	 * <p>Title: getProductQueryListByChild</p>  
	 * <p>Description: </p>  
	 * @param start
	 * @param end
	 * @param childId
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.IProductDao#getProductQueryListByChild(int, int, int)  
	*/  
	@Override
	public List<Product> getProductQueryListByChild(int start, int end, int childId) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HP_ID,HP_NAME,HP_DESCRIPTION,HP_PRICE,"
				+ "HP_STOCK,HPC_ID,HPC_CHILD_ID,HP_FILE_NAME "
				+ "FROM (SELECT ROWNUM R,HWUA_PRODUCT.* FROM HWUA_PRODUCT WHERE HPC_CHILD_ID = ?) T "
				+ "WHERE T.R>? AND T.R<=?";
		return run.query(sql, new BeanListHandler<>(Product.class),childId,start,end);
	}

	/* (非 Javadoc)  
	 * <p>Title: getHotProduct</p>  
	 * <p>Description: </p>  
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.IProductDao#getHotProduct()  
	*/  
	@Override
	public List<Product> getHotProduct() throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HP_ID,HP_NAME,HP_DESCRIPTION,HP_PRICE,"
				+ "HP_STOCK,HPC_ID,HPC_CHILD_ID,HP_FILE_NAME "
				+ "FROM (SELECT HWUA_PRODUCT.* FROM HWUA_PRODUCT ORDER BY HWUA_PRODUCT.HP_PRICE DESC) "
				+ "WHERE ROWNUM <= 10";
		return run.query(sql, new BeanListHandler<>(Product.class));
	}

	/* (non-Javadoc)
	 * @see com.yc.dao.IProductDao#getProductById(int)
	 */
	@Override
	public Product getProductById(int pid) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HP_ID,HP_NAME,HP_DESCRIPTION,HP_PRICE,"
				+ "HP_STOCK,HPC_ID,HPC_CHILD_ID,HP_FILE_NAME "
				+ "FROM HWUA_PRODUCT WHERE HP_ID = ?";
		return run.query(sql, new BeanHandler<>(Product.class), pid);
	}

	/* (non-Javadoc)
	 * @see com.yc.dao.IProductDao#getAllProductQueryCountByName(java.lang.String)
	 */
	@Override
	public int getAllProductQueryCountByName(String qname) throws SQLException {
		int count = -1;
		//贾琏
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT COUNT(HP_ID) FROM HWUA_PRODUCT "
				+ "WHERE HP_NAME LIKE '%'||?||'%' "
				+ "OR HP_DESCRIPTION LIKE '%'||?||'%'";
		//欲
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, qname);
		ps.setString(2, qname);
		//执
		ResultSet rs = ps.executeQuery();
		//事
		if(rs.next()){
			count = rs.getInt(1);
		}
		//毙
		rs.close();
		ps.close();
		conn.close();
		return count;
	}

	/* (non-Javadoc)
	 * @see com.yc.dao.IProductDao#getProductQueryListByName(int, int, java.lang.String)
	 */
	@Override
	public List<Product> getProductQueryListByName(int start, int end, String qname) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HP_ID,HP_NAME,HP_DESCRIPTION,HP_PRICE,"
				+ "HP_STOCK,HPC_ID,HPC_CHILD_ID,HP_FILE_NAME "
				+ "FROM (SELECT ROWNUM R,HWUA_PRODUCT.* FROM HWUA_PRODUCT "
				+ "WHERE HP_NAME LIKE '%'||?||'%' OR HP_DESCRIPTION LIKE '%'||?||'%') T "
				+ "WHERE T.R>? AND T.R<=?";
		return run.query(sql, new BeanListHandler<>(Product.class),qname,qname,start,end);
	}

}
