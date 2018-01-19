/**  
 * @Title: CategoryBizImpl.java  
 * @Package com.yc.biz.impl  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.biz.impl;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.yc.bean.Category;
import com.yc.biz.ICategoryBiz;
import com.yc.dao.ICategoryDao;
import com.yc.dao.impl.CategoryDaoImpl;

/**  
 * @ClassName: CategoryBizImpl  
 * @Description: 商品类别业务实现 
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public class CategoryBizImpl implements ICategoryBiz {

	private static ICategoryDao icd = new CategoryDaoImpl();
	/* (非 Javadoc)  
	 * <p>Title: getCategoryMap</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.yc.biz.ICategoryBiz#getCategoryMap()  
	*/
	@Override
	public Map<Category, List<Category>> getCategoryMap() {
		List<Category> parentList = null;
		try {
			parentList = icd.getParentCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Map<Category,List<Category>> cMap = new LinkedHashMap<>();
		for (Category category : parentList) {
			List<Category> childList = null;
			try {
				childList = icd.getChildCategory(category);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			cMap.put(category, childList);			
		}
		return cMap;
	}

}
