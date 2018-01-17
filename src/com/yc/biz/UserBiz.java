/**  
 * @Title: UserBiz.java  
 * @Package com.yc.biz  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月17日  
 * @version V1.0  
*/  
package com.yc.biz;

/**  
 * @ClassName: UserBiz  
 * @Description: 用户业务接口  
 * @author admin  
 * @date 2018年1月17日  
 *    
*/
public interface UserBiz {

	/**  
	 * @Title: checkName  
	 * @Description: 检查用户名是否存在  
	 * @param userName
	 * @return 返回类型boolean 存在返回true 不存在返回false        
	 * @throws  
	 */  
	boolean checkName(String userName);

}
