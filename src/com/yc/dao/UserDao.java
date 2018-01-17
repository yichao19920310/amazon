/**  
 * @Title: UserDao.java  
 * @Package com.yc.dao  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月17日  
 * @version V1.0  
*/  
package com.yc.dao;

import java.sql.SQLException;

import com.yc.bean.User;

/**  
 * @ClassName: UserDao  
 * @Description: 用户数据接口 
 * @author admin  
 * @date 2018年1月17日  
 *    
*/
public interface UserDao {

	/**
	 * @throws SQLException 
	 * 
	 * @Title: getUserByName  
	 * @Description: 通过用户名查找用户  
	 * @param userName
	 * @return 返回类型User      未找到返回null  
	 * @throws
	 */
	User getUserByName(String userName) throws SQLException;

}
