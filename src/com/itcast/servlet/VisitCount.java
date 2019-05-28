package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问量统计
 * Servlet implementation class VisitCount
 */
//@WebServlet("/visitCount")
public class VisitCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VisitCount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		if (count == null) {
			context.setAttribute("count", 1);
		} else {
			count++;
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("被访问了"+count+"次");
		context.setAttribute("count", count);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
