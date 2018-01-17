/**  
* @Title: EncodingFilter.java  
* @Package com.hwua.servlet  
* @Description: TODO(用一句话描述该文件做什么)  
* @author admin  
* @date 2018年1月8日  
* @version V1.0  
*/  
package com.yc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**  
* @ClassName: EncodingFilter  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author admin  
* @date 2018年1月8日  
*    
*/
@WebFilter("/*")
public class EncodingFilter implements Filter{

	/* (非 Javadoc)  
	* <p>Title: destroy</p>  
	* <p>Description: </p>    
	* @see javax.servlet.Filter#destroy()  
	*/  
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (非 Javadoc)  
	* <p>Title: doFilter</p>  
	* <p>Description: </p>  
	* @param arg0
	* @param arg1
	* @param arg2
	* @throws IOException
	* @throws ServletException  
	* @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)  
	*/  
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		chain.doFilter(req, resp);
		
	}

	/* (非 Javadoc)  
	* <p>Title: init</p>  
	* <p>Description: </p>  
	* @param arg0
	* @throws ServletException  
	* @see javax.servlet.Filter#init(javax.servlet.FilterConfig)  
	*/  
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
