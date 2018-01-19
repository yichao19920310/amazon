/**  
 * @Title: CategoryDaoImpl.java  
 * @Package com.yc.dao.impl  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yc.bean.Category;
import com.yc.dao.ICategoryDao;
import com.yc.tools.JDBCUtils;

/**  
 * @ClassName: CategoryDaoImpl  
 * @Description: 商品类别数据实现    
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public class CategoryDaoImpl implements ICategoryDao {

	/* (非 Javadoc)  
	 * <p>Title: getParentCategory</p>  
	 * <p>Description: </p>  
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.ICategoryDao#getParentCategory()  
	*/  
	@Override
	public List<Category> getParentCategory() throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HPC_ID,HPC_NAME,HPC_PARENT_ID "
				+ "FROM HWUA_PRODUCT_CATEGORY "
				+ "WHERE HPC_ID = HPC_PARENT_ID";
		return run.query(sql, new BeanListHandler<>(Category.class));
	}

	/* (非 Javadoc)  
	 * <p>Title: getChildCategory</p>  
	 * <p>Description: </p>  
	 * @param category
	 * @return  
	 * @see com.yc.dao.ICategoryDao#getChildCategory(com.yc.bean.Category)  
	*/  
	@Override
	public List<Category> getChildCategory(Category category) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HPC_ID,HPC_NAME,HPC_PARENT_ID "
				+ "FROM HWUA_PRODUCT_CATEGORY "
				+ "WHERE HPC_PARENT_ID = ? "
				+ "AND HPC_ID != HPC_PARENT_ID";
		return run.query(sql, new BeanListHandler<>(Category.class),category.getHpc_parent_id());
	}

	
}
