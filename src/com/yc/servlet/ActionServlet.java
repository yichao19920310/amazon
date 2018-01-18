package com.yc.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.User;
import com.yc.biz.IUserBiz;
import com.yc.biz.impl.UserBizImpl;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/doAction")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static IUserBiz iub = new UserBizImpl();
	
	private static final String USERNAME_IS_EXSIT = "1";
	private static final String USERNAME_IS_NOT_EXSIT = "0";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
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
		}
	}

	/**
	 * @throws IOException 
	 * @throws ParseException   
	 * @Title: register  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
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
		boolean isSuccess = iub.register(user);
		if(isSuccess){
			response.getWriter().write("<script>alert('注册成功!');document.location.href='index.jsp';</script>");
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
		response.sendRedirect("index.jsp");
		
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
		boolean isExist = iub.checkName(userName);
		if(isExist){
			response.getWriter().write(USERNAME_IS_EXSIT);
		}else{
			response.getWriter().write(USERNAME_IS_NOT_EXSIT);
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
		user = iub.login(user);
		if(user==null){
			//登录失败
			
			//response.sendRedirect("login.jsp");
			response.getWriter().write("<script>alert('登录失败!');document.location.href='login.jsp';</script>");
		}else{
			//登录成功
			request.getSession().setAttribute("user", user);
			
			//response.sendRedirect("index.jsp");
			response.getWriter().write("<script>alert('登录成功!');document.location.href='index.jsp';</script>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
