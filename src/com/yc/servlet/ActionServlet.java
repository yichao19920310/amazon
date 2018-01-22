package com.yc.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Cart;
import com.yc.bean.Category;
import com.yc.bean.News;
import com.yc.bean.Pager;
import com.yc.bean.Product;
import com.yc.bean.User;
import com.yc.biz.ICartBiz;
import com.yc.biz.ICategoryBiz;
import com.yc.biz.INewsBiz;
import com.yc.biz.IProductBiz;
import com.yc.biz.IUserBiz;
import com.yc.biz.impl.CartBizImpl;
import com.yc.biz.impl.CategoryBizImpl;
import com.yc.biz.impl.NewsBizImpl;
import com.yc.biz.impl.ProductBizImpl;
import com.yc.biz.impl.UserBizImpl;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/doAction")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static IUserBiz iUserB = new UserBizImpl();
	private static ICategoryBiz iCateB = new CategoryBizImpl();
	private static IProductBiz iProdB = new ProductBizImpl();
	private static INewsBiz iNewsB = new NewsBizImpl();
	private static ICartBiz iCartB = new CartBizImpl();
	private static final String USERNAME_IS_EXIST = "1";
	private static final String USERNAME_IS_NOT_EXIST = "0";
	private static final String CATE_PARENT = "parent";
	private static final String CATE_CHILD = "child";
	private static final String CATE_ALL = "";
	private static final String SUCCESS = "1";
	private static final String FAILED = "0";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action==null){
			initIndex(request,response);
		}else{
			switch(action){
			case "login":
				login(request,response);
				break;
			case "register":
				try {
					register(request,response);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case "checkName":
				checkName(request,response);
				break;
			case "checkOut":
				checkOut(request,response);
				break;
			case "readNews":
				readNews(request,response);
				break;
			case "productView":
				productView(request,response);
				break;
			case "showCart":
				showCart(request,response);
				break;	
			case "buyProduct":
				buyProduct(request,response);
				break;
			case "shoppingCart":
				shoppingCart(request,response);
				break;
			case "changeCartCount":
				changeCartCount(request,response);
			default:
				break;
			}
		}
		
	}

	/**
	 * @throws IOException   
	 * @Title: changeCartCount  
	 * @Description: 修改购物车商品数 
	 * @param request
	 * @param response 返回类型void        
	 * @throws  
	 */  
	private void changeCartCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cid = request.getParameter("cid");
		String count = request.getParameter("count");
		int cartId = 0;
		int quantity = 0;
		if(cid!=null && !"".equals(cid)){
			cartId = Integer.parseInt(cid);
		}
		if(count!=null && !"".equals(count)){
			quantity = Integer.parseInt(count);
		}
		boolean isSuccess = iCartB.changeCartCount(cartId,quantity);
		if(isSuccess){
			response.getWriter().write(SUCCESS);
		}else{
			response.getWriter().write(FAILED);
		}
	}

	/**
	 * @throws IOException   
	 * @Title: shoppingCart  
	 * @Description: 添加到购物车 
	 * @param request
	 * @param response 返回类型void        
	 * @throws  
	 */  
	private void shoppingCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pid = request.getParameter("pid");
		int pId = 0;
		if(pid!=null && !"".equals(pid)){
			pId = Integer.parseInt(pid);
		}
		String count = request.getParameter("count");
		int counts = 0;
		if(count!=null && !"".equals(count)){
			counts = Integer.parseInt(count);
		}
		User user = (User)(request.getSession().getAttribute("user"));		
		boolean isSuccess = false;
		if(user!=null){
			Cart cart = new Cart(pId,counts,user.getHu_user_id());
			isSuccess = iCartB.addCart(cart);
		}
		if(isSuccess){
			response.getWriter().write(SUCCESS);
		}else{
			response.getWriter().write(FAILED);
		}
	}

	/**  
	 * @Title: buyProduct  
	 * @Description: 购买单个商品 
	 * @param request
	 * @param response 返回类型void        
	 * @throws  
	 */  
	private void buyProduct(HttpServletRequest request, HttpServletResponse response) {
		String pid = request.getParameter("pid");
		int pId = 0;
		if(pid!=null && !"".equals(pid)){
			pId = Integer.parseInt(pid);
		}
		String count = request.getParameter("count");
		int counts = 0;
		if(count!=null && !"".equals(count)){
			counts = Integer.parseInt(count);
		}
		User user = (User)(request.getSession().getAttribute("user"));		
		Cart cart = null;
		if(user!=null){
			//unfinished
		}
		
		
	}

	/**
	 * @throws IOException 
	 * @throws ServletException   
	 * @Title: showCart  
	 * @Description: 显示购物车 
	 * @param request
	 * @param response 返回类型void        
	 * @throws  
	 */  
	private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)(request.getSession().getAttribute("user"));
		List<Cart> cart = null;
		if(user!=null){
			cart = iCartB.showCart(user);
		}
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("shopping.jsp").forward(request, response);
		
	}

	/**
	 * @throws IOException 
	 * @throws ServletException   
	 * @Title: productView  
	 * @Description: 浏览商品详情 
	 * @param request
	 * @param response     
	 * @throws  
	 */  
	
	private void productView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//又要显示上方热卖
		List<Product> hotProducts = iProdB.showHotProduct();
		request.setAttribute("hotProducts", hotProducts);
		//主体
		String pId = request.getParameter("pId");
		int pid = 0;
		if(pId!=null && !"".equals(pId)){
			pid = Integer.parseInt(pId);
		}
		Product prod = iProdB.showProductById(pid);
		request.setAttribute("pro", prod);
		LinkedHashMap<Product,Product> historyMap = (LinkedHashMap<Product,Product>)(request.getSession().getAttribute("historyMap"));
		if(historyMap==null){
			historyMap = new LinkedHashMap<Product,Product>(){
				private static final long serialVersionUID = 1L;  
		        @Override  
		        protected boolean removeEldestEntry(Map.Entry<Product,Product> eldest) {  
		            return size() > 4;  
		        }  
			};
		}
		historyMap.put(prod, prod);
		request.getSession().setAttribute("historyMap", historyMap);
		request.getRequestDispatcher("product_view.jsp").forward(request, response);
		
	}

	/**
	 * @throws IOException 
	 * @throws ServletException   
	 * @Title: readNews  
	 * @Description: 查看新闻内容  
	 * @param request
	 * @param response 返回类型void        
	 * @throws  
	 */  
	private void readNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//又要显示新闻列表
		List<News> newsList = iNewsB.getAllNews();
		request.setAttribute("newsList", newsList);
		//主体
		String nid = request.getParameter("nid");
		int nId = 0;
		if(nid!=null && !"".equals(nid)){
			nId = Integer.parseInt(nid);
		}
		News news = iNewsB.getNewsById(nId);
		System.out.println(news);
		request.setAttribute("newsInfo", news);
		request.getRequestDispatcher("news_view.jsp").forward(request, response);
	}

	/**
	 * @throws IOException 
	 * @throws ServletException   
	 * @Title: initIndex  
	 * @Description: 为首次访问初始化主页相关页面数据  
	 * @param request
	 * @param response 返回类型void        
	 * @throws  
	 */  
	private void initIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//商品类别
		Map<Category,List<Category>> cMap = iCateB.getCategoryMap();
		request.getSession().setAttribute("cMap", cMap);
		//新闻
		List<News> newsList = iNewsB.getAllNews();
		request.setAttribute("newsList", newsList);
		//热卖
		List<Product> hotProducts = iProdB.showHotProduct();
		request.setAttribute("hotProducts", hotProducts);
		//商品列表
		String cate = request.getParameter("cate");
		if(cate==null||CATE_ALL.equals(cate)){
			//查询类别为空,即查询全部
			showAllProduct(request);
		}else if(CATE_PARENT.equals(cate)){
			//查询类别为大类
			showProductByParent(request);
		}else if(CATE_CHILD.equals(cate)){
			//查询类别为小类
			showProductByChild(request);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	/**  
	 * @Title: showProductByChild  
	 * @Description: 查询指定子类商品
	 * @param request 返回类型void        
	 * @throws  
	 */  
	private void showProductByChild(HttpServletRequest request) {
		String hpcId = request.getParameter("hpcId");
		int childId = 0;
		if(hpcId!=null && !"".equals(hpcId)){
			childId = Integer.parseInt(hpcId);
		}
		
		int pageNum = 1;// 默认下标页为第一页
		String page = request.getParameter("page");
		if (page != null && !"".equals(page)) {
			pageNum = Integer.parseInt(page);
		}
		Pager pager = new Pager(pageNum);// 构建一个分页对象Pager
		// 2.调用业务层完成数据的查询
		List<Product> pList = iProdB.showProductByChild(pager,childId);
		// 7.将page和List存入request域中
		request.setAttribute("pList", pList);
		request.setAttribute("pager", pager);
		
		
	}

	/**  
	 * @Title: showProductByParent  
	 * @Description: 查询指定父类商品
	 * @param request 返回类型void        
	 * @throws  
	 */  
	private void showProductByParent(HttpServletRequest request) {
		String hpcId = request.getParameter("hpcId");
		int parentId = 0;
		if(hpcId!=null && !"".equals(hpcId)){
			parentId = Integer.parseInt(hpcId);
		}
		
		int pageNum = 1;// 默认下标页为第一页
		String page = request.getParameter("page");
		if (page != null && !"".equals(page)) {
			pageNum = Integer.parseInt(page);
		}
		Pager pager = new Pager(pageNum);// 构建一个分页对象Pager
		// 2.调用业务层完成数据的查询
		List<Product> pList = iProdB.showProductByParent(pager,parentId);
		// 7.将page和List存入request域中
		request.setAttribute("pList", pList);
		request.setAttribute("pager", pager);
		
		
	}

	/**  
	 * @Title: showAllProduct  
	 * @Description: 查询所有商品  
	 * @param request 返回类型void        
	 * @throws  
	 */  
	private void showAllProduct(HttpServletRequest request) {
		int pageNum = 1;// 默认下标页为第一页
		String page = request.getParameter("page");
		if (page != null && !"".equals(page)) {
			pageNum = Integer.parseInt(page);
		}
		Pager pager = new Pager(pageNum);// 构建一个分页对象Pager
		// 2.调用业务层完成数据的查询
		List<Product> pList = iProdB.showAllProduct(pager);
		// 7.将page和List存入request域中
		request.setAttribute("pList", pList);
		request.setAttribute("pager", pager);
	}

	/**
	 * @throws IOException 
	 * @throws ParseException   
	 * @Title: register  
	 * @Description: 执行注册操作  
	 * @param request
	 * @param response 返回类型void        
	 * @throws  
	 */  
	private void register(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		//String rePassWord = request.getParameter("rePassWord");
		String sex = request.getParameter("sex");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(request.getParameter("birthday"));
		Date birthday = new Date(date.getTime());
		String identity = request.getParameter("identity");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		User user = new User(userName,passWord,sex,birthday,identity,email,mobile,address);
		boolean isSuccess = iUserB.register(user);
		if(isSuccess){
			response.getWriter().write("<script>alert('注册成功!');document.location.href='doAction';</script>");
		}else{
			response.getWriter().write("<script>alert('注册失败!');document.location.href='register.jsp';</script>");
		}
	}

	/**
	 * @throws IOException   
	 * @Title: checkOut  
	 * @Description: 用户退出,销毁session  
	 * @param request
	 * @param response 返回类型void        
	 * @throws  
	 */  
	private void checkOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("doAction");
		
	}

	/**
	 * @throws IOException   
	 * @Title: checkName  
	 * @Description: 验证用户名是否存在  
	 * @param request
	 * @param response 返回类型void        
	 * @throws  
	 */  
	private void checkName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userName = request.getParameter("userName");
		boolean isExist = iUserB.checkName(userName);
		if(isExist){
			response.getWriter().write(USERNAME_IS_EXIST);
		}else{
			response.getWriter().write(USERNAME_IS_NOT_EXIST);
		}
		
	}

	/**
	 * @throws IOException   
	 * @Title: login  
	 * @Description: 执行登陆操作  
	 * @param request
	 * @param response 返回类型void        
	 * @throws  
	 */  
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userName = request.getParameter("logUserName");
		String passWord = request.getParameter("logPassWord");
		User user = new User(userName,passWord); 
		user = iUserB.login(user);
		if(user==null){
			//登录失败
			
			//response.sendRedirect("login.jsp");
			response.getWriter().write("<script>alert('登录失败!');document.location.href='login.jsp';</script>");
		}else{
			//登录成功
			request.getSession().setAttribute("user", user);
			
			//response.sendRedirect("index.jsp");
			response.getWriter().write("<script>alert('登录成功!');document.location.href='doAction';</script>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
