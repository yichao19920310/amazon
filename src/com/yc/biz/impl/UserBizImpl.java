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
import com.yc.biz.IUserBiz;
import com.yc.dao.IUserDao;
import com.yc.dao.impl.UserDaoImpl;

/**  
 * @ClassName: UserBizImpl  
 * @Description: 用户业务实现  
 * @author admin  
 * @date 2018年1月17日  
 *    
*/
public class UserBizImpl implements IUserBiz {

	private static IUserDao iud = new UserDaoImpl();
	
	/* (非 Javadoc)  
	 * <p>Title: checkName</p>  
	 * <p>Description: </p>  
	 * @param userName
	 * @return  
	 * @see com.yc.biz.UserBiz#checkName(java.lang.String)  
	*/  
	@Override
	public boolean checkName(String userName) {
		if(userName==null||"".equals(userName)){
			return false;
		}
		User u = null;
		try {
			u = iud.getUserByName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(u==null){
			return false;
		}else{
			return true;
		}		
	}

	/* (非 Javadoc)  
	 * <p>Title: login</p>  
	 * <p>Description: </p>  
	 * @param user
	 * @return  
	 * @see com.yc.biz.UserBiz#login(com.yc.bean.User)  
	*/  
	@Override
	public User login(User user) {
		String userName = user.getHu_user_name();
		String passWord = user.getHu_password();
		if(userName==null||passWord==null||"".equals(userName)||"".equals(passWord)){
			return null;
		}
		User tempUser = null;
		try {
			tempUser = iud.getUserByName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(tempUser == null){
			//用户名不存在
			return null;
		}
		if(passWord.equals(tempUser.getHu_password())){
			//密码匹配
			return tempUser;
		}else{
			//密码不匹配
			return null;
		}
		
	}

	/* (非 Javadoc)  
	 * <p>Title: checkEmail</p>  
	 * <p>Description: </p>  
	 * @param email
	 * @return  
	 * @see com.yc.biz.UserBiz#checkEmail(java.lang.String)  
	*/  
	@Override
	public boolean checkEmail(String email) {
		if(email==null||"".equals(email)){
			throw new IllegalArgumentException();
		}
		User user = null;
		try {
			user = iud.getUserByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user==null){
			return false;
		}else{
			return true;
		}
		
	}

	/* (非 Javadoc)  
	 * <p>Title: register</p>  
	 * <p>Description: </p>  
	 * @param user
	 * @return  
	 * @see com.yc.biz.IUserBiz#register(com.yc.bean.User)  
	*/  
	@Override
	public boolean register(User user) {
		if(user==null){
			return false;
		}
		int row = 0;
		try {
			row = iud.insertUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(row==0){
			return false;
		}else{
			return true;
		}
		
	}

}
