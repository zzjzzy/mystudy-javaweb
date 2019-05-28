package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 随便的练习
 * Servlet implementation class ServletDemo2
 */
//@WebServlet("/servletDemo2")
public class ServletDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletDemo2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("utf8");
		ServletContext context = this.getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		if (count == null) {
			count = 1;
		} else {
			count++;
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("被访问了"+count+"次<br>");
		context.setAttribute("count", count);

//		System.out.println(context.getResourcePaths("/WEB-INF"));
		String path = context.getRealPath("/index.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<br>index.jsp在这个目录下 "+path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
