package com.yc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.biz.UserBiz;
import com.yc.biz.impl.UserBizImpl;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/doAction")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UserBiz ubi = new UserBizImpl();
	
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
			break;
		case "checkName":
			checkName(request,response);
			break;
		case "":
			break;
		}
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
		boolean isExist = ubi.checkName(userName);
		if(isExist){
			response.getWriter().write(USERNAME_IS_EXSIT);
		}else{
			response.getWriter().write(USERNAME_IS_NOT_EXSIT);
		}
		
	}

	/**  
	 * @Title: login  
	 * @Description: 执行登陆操作  
	 * @param request
	 * @param response 返回类型void        
	 * @throws  
	 */  
	private void login(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
