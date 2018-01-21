/**  
 * @Title: IProductBiz.java  
 * @Package com.yc.biz  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.biz;

import java.util.List;

import com.yc.bean.Pager;
import com.yc.bean.Product;

/**  
 * @ClassName: IProductBiz  
 * @Description: 商品业务接口 
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public interface IProductBiz {

	/**  
	 * @Title: showAllProduct  
	 * @Description: 查看所有商品 
	 * @param pager 页面对象
	 * @return 返回类型List<Product>        
	 * @throws  
	 */  
	List<Product> showAllProduct(Pager pager);

	/**  
	 * @Title: showProductByParent  
	 * @Description: 查看对应父类的商品  
	 * @param pager
	 * @param parentId
	 * @return 返回类型List<Product>        
	 * @throws  
	 */  
	List<Product> showProductByParent(Pager pager, int parentId);

	/**  
	 * @Title: showProductByChild  
	 * @Description: 查看对应子类的商品 
	 * @param pager
	 * @param childId
	 * @return 返回类型List<Product>        
	 * @throws  
	 */  
	List<Product> showProductByChild(Pager pager, int childId);

	/**  
	 * @Title: showHotProduct  
	 * @Description: 查看热卖商品  
	 * @return 返回类型List<Product>        
	 * @throws  
	 */  
	List<Product> showHotProduct();

	/**  
	 * @Title: showProductById  
	 * @Description: 根据id查看商品详情
	 * @param pid
	 * @return  Product   
	 * @throws  
	 */  
	
	Product showProductById(int pid);

	/**  
	 * @Title: searchProductByName  
	 * @Description: 根据关键字模糊查询商品集合
	 * @param qname
	 * @param pager
	 * @return  返回类型List<Product>   
	 * @throws  
	 */  
	
	List<Product> searchProductByName(String qname, Pager pager);

}
