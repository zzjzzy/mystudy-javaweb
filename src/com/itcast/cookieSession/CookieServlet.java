package com.itcast.cookieSession;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie实现上次登录时间纪录
 * Servlet implementation class CookieServlet
 */
//@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		Cookie cookie = new Cookie("lasttime",new Date().toString().replace(" ", "-"));
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		
		Cookie[] cs = request.getCookies();
		String s = "第一次访问吧，小老弟";
		if (cs!=null) {
			for (Cookie c : cs) {
				if (c.getName().equals("lasttime")) {
					s = "上一次访问时间是："+c.getValue();
				}
			}
		}
		
		response.getWriter().print(s);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
