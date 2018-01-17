/**  
 * @Title: UserBizImpl.java  
 * @Package com.yc.biz.impl  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月17日  
 * @version V1.0  
*/  
package com.yc.biz.impl;

import java.sql.SQLException;

import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.dao.UserDao;
import com.yc.dao.impl.UserDaoImpl;

/**  
 * @ClassName: UserBizImpl  
 * @Description: 用户业务实现  
 * @author admin  
 * @date 2018年1月17日  
 *    
*/
public class UserBizImpl implements UserBiz {

	private static UserDao udi = new UserDaoImpl();
	
	/* (非 Javadoc)  
	 * <p>Title: checkName</p>  
	 * <p>Description: </p>  
	 * @param userName
	 * @return  
	 * @see com.yc.biz.UserBiz#checkName(java.lang.String)  
	*/  
	@Override
	public boolean checkName(String userName) {
		User u = null;
		try {
			u = udi.getUserByName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(u==null){
			return false;
		}else{
			return true;
		}		
	}

}
