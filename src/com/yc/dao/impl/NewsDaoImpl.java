/**  
 * @Title: NewsDaoImpl.java  
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
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yc.bean.News;
import com.yc.dao.INewsDao;
import com.yc.tools.JDBCUtils;

/**  
 * @ClassName: NewsDaoImpl  
 * @Description: 新闻数据实现  
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public class NewsDaoImpl implements INewsDao {

	/* (非 Javadoc)  
	 * <p>Title: getAllNews</p>  
	 * <p>Description: </p>  
	 * @return
	 * @throws SQLException  
	 * @see com.yc.dao.INewsDao#getAllNews()  
	*/  
	@Override
	public List<News> getAllNews() throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HN_ID,HN_TITLE,HN_CONTENT,HN_CREATE_TIME "
				+ "FROM HWUA_NEWS";
		return run.query(sql, new BeanListHandler<>(News.class));
	}

	/* (non-Javadoc)
	 * @see com.yc.dao.INewsDao#getNewsById(int)
	 */
	@Override
	public News getNewsById(int nId) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		System.out.println(nId);
		String sql = "SELECT HN_ID,HN_TITLE,HN_CONTENT,HN_CREATE_TIME "
				+ "FROM HWUA_NEWS WHERE HN_ID = ?";
		return run.query(sql, new BeanHandler<>(News.class), nId);
	}

}
