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
@WebServlet("/AjaxCity")
public class AjaxCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AjaxCity() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String province = request.getParameter("province");
		if ("山东省".equals(province)) {
			response.getWriter().write("聊城市,济南市");
		} else if ("北京市".equals(province)) {
			response.getWriter().write("朝阳区,东城区,西城区");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
