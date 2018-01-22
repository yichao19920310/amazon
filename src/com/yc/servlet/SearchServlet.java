package com.yc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.News;
import com.yc.bean.Pager;
import com.yc.bean.Product;
import com.yc.biz.INewsBiz;
import com.yc.biz.IProductBiz;
import com.yc.biz.impl.NewsBizImpl;
import com.yc.biz.impl.ProductBizImpl;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/query")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static INewsBiz iNewsB = new NewsBizImpl();
	private static IProductBiz iProdB = new ProductBizImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 新闻
		List<News> newsList = iNewsB.getAllNews();
		request.setAttribute("newsList", newsList);
		// 热卖
		List<Product> hotProducts = iProdB.showHotProduct();
		request.setAttribute("hotProducts", hotProducts);
		// 商品列表
		int pageNum = 1;// 默认下标页为第一页
		String page = request.getParameter("page");
		if (page != null && !"".equals(page)) {
			pageNum = Integer.parseInt(page);
		}
		Pager pager = new Pager(pageNum);// 构建一个分页对象Pager
		String qname = request.getParameter("qname");
		List<Product> pList = iProdB.searchProductByName(qname,pager);
		request.setAttribute("pList", pList);
		request.setAttribute("searchPager", pager);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
