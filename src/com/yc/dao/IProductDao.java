/**  
 * @Title: IProductDao.java  
 * @Package com.yc.dao  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.dao;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Product;

/**  
 * @ClassName: IProductDao  
 * @Description: 商品数据接口  
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public interface IProductDao {

	/**
	 * @throws SQLException   
	 * @Title: getAllproductQueryCount  
	 * @Description: 获取所有商品的数量  
	 * @return 返回类型int        
	 * @throws  
	 */  
	int getAllProductQueryCount() throws SQLException;

	/**
	 * @throws SQLException   
	 * @Title: getProductQueryList  
	 * @Description: 获取页面区间要显示的商品集合  
	 * @param start
	 * @param end
	 * @return 返回类型List<Product>        
	 */  
	List<Product> getProductQueryList(int start, int end) throws SQLException;

	/**  
	 * @Title: getAllProductQueryCountByParent  
	 * @Description: 获取指定大类别的商品总数
	 * @param parentId
	 * @return 返回类型int        
	 * @throws  SQLException
	 */  
	int getAllProductQueryCountByParent(int parentId) throws SQLException;

	/**  
	 * @Title: getProductQueryListByParent  
	 * @Description:获取页面区间要显示的指定大类的商品集合
	 * @param start
	 * @param end
	 * @param parentId
	 * @return 返回类型List<Product>        
	 * @throws  SQLException
	 */  
	List<Product> getProductQueryListByParent(int start, int end, int parentId) throws SQLException;

	/**  
	 * @Title: getProductQueryListByChild  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param start
	 * @param end
	 * @param childId
	 * @return 返回类型List<Product>        
	 * @throws  SQLException
	 */  
	List<Product> getProductQueryListByChild(int start, int end, int childId) throws SQLException;

	/**  
	 * @Title: getHotProduct  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @return 返回类型List<Product>        
	 * @throws  SQLException
	 */  
	List<Product> getHotProduct() throws SQLException;

}
