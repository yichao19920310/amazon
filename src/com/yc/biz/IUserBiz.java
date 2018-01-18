/**  
 * @Title: UserBiz.java  
 * @Package com.yc.biz  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月17日  
 * @version V1.0  
*/  
package com.yc.biz;

import com.yc.bean.User;

/**  
 * @ClassName: UserBiz  
 * @Description: 用户业务接口  
 * @author admin  
 * @date 2018年1月17日  
 *    
*/
public interface IUserBiz {

	/**  
	 * @Title: checkName  
	 * @Description: 检查用户名是否存在  
	 * @param userName
	 * @return 返回类型boolean 存在返回true 不存在返回false        
	 * @throws  
	 */  
	boolean checkName(String userName);

	/**  
	 * @Title: login  
	 * @Description: 用户登录业务  
	 * @param user
	 * @return 返回类型User 成功返回当前登录成功user,失败返回null      
	 * @throws  
	 */  
	User login(User user);

	/**  
	 * @Title: checkEmail  
	 * @Description: 检查email是否已被使用 
	 * @param email
	 * @return 返回类型boolean 存在返回true 不存在返回false;       
	 * @throws  
	 */  
	boolean checkEmail(String email);

	/**  
	 * @Title: register  
	 * @Description: 用户注册业务 
	 * @param user
	 * @return 返回类型boolean  成功返回true 失败返回false      
	 * @throws  
	 */  
	boolean register(User user);

}
