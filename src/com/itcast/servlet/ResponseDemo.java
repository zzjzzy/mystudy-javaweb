package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Response中的方法测试
 * Servlet implementation class VisitCount
 */
//@WebServlet("/visitCount")
public class ResponseDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ResponseDemo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().print("aaa");
//		response.flushBuffer();
//		response.getWriter().print("bbb");
		
//		ServletOutputStream out = response.getOutputStream();
//		out.print("aaa");;
		
//		response.sendError(404,"出错啦！");
		response.sendRedirect("http://www.baidu.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
