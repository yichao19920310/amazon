/**  
 * @Title: ICategoryDao.java  
 * @Package com.yc.dao  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.dao;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Category;

/**  
 * @ClassName: ICategoryDao  
 * @Description: 商品类别数据接口  
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public interface ICategoryDao {



	/**  
	 * @Title: getParentCategory  
	 * @Description: 获取所有商品大类别  
	 * @return 返回类型List<Category>        
	 * @throws  SQLException
	 */  
	List<Category> getParentCategory() throws SQLException;

	/**
	 * @throws SQLException   
	 * @Title: getChildCategory  
	 * @Description: 通过类别对象获取子类别列表  
	 * @param category
	 * @return 返回类型List<Category>        
	 * @throws  
	 */  
	List<Category> getChildCategory(Category category) throws SQLException;

	/**
	 * @throws SQLException   
	 * @Title: getCategoryById  
	 * @Description: 通过id获取商品类别对象
	 * @param hpc_id
	 * @return  返回类型Category   
	 * @throws  
	 */  
	
	Category getCategoryById(int hpc_id) throws SQLException;

}
