/**  
 * @Title: ICategoryBiz.java  
 * @Package com.yc.biz  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.Category;

/**  
 * @ClassName: ICategoryBiz  
 * @Description: 商品类别业务接口 
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public interface ICategoryBiz {

	/**  
	 * @Title: getCategoryMap  
	 * @Description: 获取商品类别Map 
	 * @return 返回类型Map<Category,List<Category>>        
	 * @throws  
	 */  
	Map<Category, List<Category>> getCategoryMap();
}
