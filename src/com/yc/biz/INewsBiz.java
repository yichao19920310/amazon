/**  
 * @Title: INewsBiz.java  
 * @Package com.yc.biz  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.biz;

import java.util.List;

import com.yc.bean.News;

/**  
 * @ClassName: INewsBiz  
 * @Description: 新闻业务接口  
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public interface INewsBiz {

	/**  
	 * @Title: getAllNews  
	 * @Description: 获取所有新闻集合 
	 * @return 返回类型List<News>        
	 * @throws  
	 */  
	List<News> getAllNews();

}
