package com.yc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.biz.IUserBiz;
import com.yc.biz.impl.UserBizImpl;

/**
 * Servlet implementation class CheckEmailServlet
 */
@WebServlet("/CheckEmail")
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static IUserBiz iUserB = new UserBizImpl();
	private static final String EMAIL_IS_EXSIT = "1";
	private static final String EMAIL_IS_NOT_EXSIT = "0";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		boolean isExist = iUserB.checkEmail(email);
		if(isExist){			
			response.getWriter().write(EMAIL_IS_EXSIT);
		}else{
			response.getWriter().write(EMAIL_IS_NOT_EXSIT);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
