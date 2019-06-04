package com.itcast.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxDemo
 */
@WebServlet("/AjaxRegistered")
public class AjaxRegistered extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AjaxRegistered() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		System.out.println(username);
		if (username.equals("张")) {
			response.getWriter().write("true");
		}else {
			response.getWriter().write(username);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
