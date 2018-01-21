/**  
 * @Title: NewsBizImpl.java  
 * @Package com.yc.biz.impl  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.biz.impl;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.News;
import com.yc.biz.INewsBiz;
import com.yc.dao.INewsDao;
import com.yc.dao.impl.NewsDaoImpl;

/**  
 * @ClassName: NewsBizImpl  
 * @Description: 新闻业务实现
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public class NewsBizImpl implements INewsBiz {

	private static INewsDao ind = new NewsDaoImpl();
	/* (非 Javadoc)  
	 * <p>Title: getAllNews</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.yc.biz.INewsBiz#getAllNews()  
	*/  
	@Override
	public List<News> getAllNews() {
		List<News> newsList = null;
		try {
			newsList = ind.getAllNews();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsList;
	}
	/* (non-Javadoc)
	 * @see com.yc.biz.INewsBiz#getNewsById(int)
	 */
	@Override
	public News getNewsById(int nId) {
		News news = null;
		try {
			news = ind.getNewsById(nId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(news);
		return news;
	}

}
