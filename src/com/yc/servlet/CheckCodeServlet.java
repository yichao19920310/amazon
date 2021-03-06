package com.yc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VERY_CODE_RIGHT = "1";
	private static final String VERY_CODE_WRONG = "0";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String validateCode = request.getSession().getAttribute("validateCode").toString();
		String veryCode = request.getParameter("veryCode");
		if(veryCode==null||validateCode==null||"".equals(veryCode)||"".equals(validateCode)){
			response.getWriter().write(VERY_CODE_WRONG);
		}else if(veryCode.equals(validateCode)){
			response.getWriter().write(VERY_CODE_RIGHT);
		}else{
			response.getWriter().write(VERY_CODE_WRONG);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
