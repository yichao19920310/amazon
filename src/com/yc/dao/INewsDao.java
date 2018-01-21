/**  
 * @Title: INewsDao.java  
 * @Package com.yc.dao  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.dao;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.News;

/**  
 * @ClassName: INewsDao  
 * @Description: 新闻数据接口
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public interface INewsDao {

	/**  
	 * @Title: getAllNews  
	 * @Description: 获取所有新闻集合
	 * @return 返回类型List<News>        
	 * @throws SQLException 
	 */  
	List<News> getAllNews() throws SQLException;

	/**  
	 * @Title: getNewsById  
	 * @Description: 根据id获取指定新闻对象 
	 * @param nId
	 * @return  News   
	 * @throws SQLException 
	 */  
	
	News getNewsById(int nId) throws SQLException;

}
