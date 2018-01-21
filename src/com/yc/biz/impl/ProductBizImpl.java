/**  
 * @Title: ProductBizImpl.java  
 * @Package com.yc.biz.impl  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.biz.impl;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Category;
import com.yc.bean.Pager;
import com.yc.bean.Product;
import com.yc.biz.IProductBiz;
import com.yc.dao.ICategoryDao;
import com.yc.dao.IProductDao;
import com.yc.dao.impl.CategoryDaoImpl;
import com.yc.dao.impl.ProductDaoImpl;

/**  
 * @ClassName: ProductBizImpl  
 * @Description: 商品业务实现
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public class ProductBizImpl implements IProductBiz {

	private static IProductDao ipd = new ProductDaoImpl();
	private static ICategoryDao icd = new CategoryDaoImpl();
	/* (非 Javadoc)  
	 * <p>Title: showAllProduct</p>  
	 * <p>Description: </p>  
	 * @param pager
	 * @return  
	 * @see com.yc.biz.IProductBiz#showAllProduct(com.yc.bean.Pager)  
	*/  
	@Override
	public List<Product> showAllProduct(Pager pager) {
		List<Product> pList = null;
		try {
			//3.获取记录总数
			int count = ipd.getAllProductQueryCount();
			//4.将总数设置到pager对象中
			pager.setRecordCount(count);
			//5.根据当前用户选择的页码算出区间  
			int start = (pager.getCurrentPage()-1)*Pager.PAGE_RECORD;
			int end = start+Pager.PAGE_RECORD;
			//6.调用dao，传入start&end，查询区间集合
			pList = ipd.getProductQueryList(start,end);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;		
	}
	/* (非 Javadoc)  
	 * <p>Title: showProductByParent</p>  
	 * <p>Description: </p>  
	 * @param pager
	 * @param parentId
	 * @return  
	 * @see com.yc.biz.IProductBiz#showProductByParent(com.yc.bean.Pager, int)  
	*/  
	@Override
	public List<Product> showProductByParent(Pager pager, int parentId) {
		List<Product> pList = null;
		try {
			//3.获取记录总数
			int count = ipd.getAllProductQueryCountByParent(parentId);
			//4.将总数设置到pager对象中
			pager.setRecordCount(count);
			//5.根据当前用户选择的页码算出区间  
			int start = (pager.getCurrentPage()-1)*Pager.PAGE_RECORD;
			int end = start+Pager.PAGE_RECORD;
			//6.调用dao，传入start&end，查询区间集合
			pList = ipd.getProductQueryListByParent(start,end,parentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;	
	}
	/* (非 Javadoc)  
	 * <p>Title: showProductByChild</p>  
	 * <p>Description: </p>  
	 * @param pager
	 * @param childId
	 * @return  
	 * @see com.yc.biz.IProductBiz#showProductByChild(com.yc.bean.Pager, int)  
	*/  
	@Override
	public List<Product> showProductByChild(Pager pager, int childId) {
		List<Product> pList = null;
		try {
			//3.获取记录总数
			int count = ipd.getAllProductQueryCountByParent(childId);
			//4.将总数设置到pager对象中
			pager.setRecordCount(count);
			//5.根据当前用户选择的页码算出区间  
			int start = (pager.getCurrentPage()-1)*Pager.PAGE_RECORD;
			int end = start+Pager.PAGE_RECORD;
			//6.调用dao，传入start&end，查询区间集合
			pList = ipd.getProductQueryListByChild(start,end,childId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;	
	}
	/* (非 Javadoc)  
	 * <p>Title: showHotProduct</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.yc.biz.IProductBiz#showHotProduct()  
	*/  
	@Override
	public List<Product> showHotProduct() {
		List<Product> pList = null;
		try {
			pList = ipd.getHotProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}
	/* (non-Javadoc)
	 * @see com.yc.biz.IProductBiz#showProductById(int)
	 */
	@Override
	public Product showProductById(int pid) {
		Product prod = null;
		Category parent_category = null;
		Category child_category = null;
		try {
			prod = ipd.getProductById(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(prod!=null){
			try {
				parent_category = icd.getCategoryById(prod.getHpc_id());
				child_category = icd.getCategoryById(prod.getHpc_child_id());
				prod.setParent_category(parent_category);
				prod.setChild_category(child_category);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return prod;
	}
	/* (non-Javadoc)
	 * @see com.yc.biz.IProductBiz#searchProductByName(java.lang.String, com.yc.bean.Pager)
	 */
	@Override
	public List<Product> searchProductByName(String qname, Pager pager) {
		List<Product> pList = null;
		try {
			//3.获取记录总数
			int count = ipd.getAllProductQueryCountByName(qname);
			//4.将总数设置到pager对象中
			pager.setRecordCount(count);
			//5.根据当前用户选择的页码算出区间  
			int start = (pager.getCurrentPage()-1)*Pager.PAGE_RECORD;
			int end = start+Pager.PAGE_RECORD;
			//6.调用dao，传入start&end，查询区间集合
			pList = ipd.getProductQueryListByName(start,end,qname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;	
	}

}
