/**  
 * @Title: UserDaoImpl.java  
 * @Package com.yc.dao.impl  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月17日  
 * @version V1.0  
*/  
package com.yc.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.yc.bean.User;
import com.yc.dao.UserDao;
import com.yc.tools.JDBCUtils;

/**  
 * @ClassName: UserDaoImpl  
 * @Description: 用户数据实现 
 * @author admin  
 * @date 2018年1月17日  
 *    
*/
public class UserDaoImpl implements UserDao {

	/* (非 Javadoc)  
	 * <p>Title: getUserByName</p>  
	 * <p>Description: </p>  
	 * @param userName
	 * @return  
	 * @see com.yc.dao.UserDao#getUserByName(java.lang.String)  
	*/  
	@Override
	public User getUserByName(String userName) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT HU_USER_ID,HU_USER_NAME,HU_PASSWORD,HU_SEX,"
				+ "HU_BIRTHDAY,HU_IDENTITY_CODE,HU_EMAIL,HU_MOBILE,HU_ADDRESS,"
				+ "HU_STATUS "
				+ "FROM HWUA_USER "
				+ "WHERE HU_USER_NAME = ?";
		return run.query(sql, new BeanHandler<>(User.class),userName);		
	}

}
