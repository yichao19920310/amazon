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

import com.yc.bean.Pager;
import com.yc.bean.Product;
import com.yc.biz.IProductBiz;
import com.yc.dao.IProductDao;
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

}
