package com.yc.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.yc.bean.Product;
import com.yc.biz.IProductBiz;
import com.yc.biz.impl.ProductBizImpl;
import com.yc.tools.JDBCUtils;

/**
 * Servlet Filter implementation class InitIndexFilter
 */
@WebFilter("/*")
public class InitIndexFilter implements Filter {

	IProductBiz iProdB = new ProductBizImpl();

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//HttpServletRequest req = (HttpServletRequest) request;
		List<Product> hotProducts = iProdB.showHotProduct();
		request.setAttribute("hotProducts", hotProducts);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
