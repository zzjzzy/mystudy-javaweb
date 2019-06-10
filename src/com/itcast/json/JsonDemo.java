package com.itcast.json;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AjaxDemo
 */
@WebServlet("/JsonDemo1")
public class JsonDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JsonDemo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		JSONObject jo = new JSONObject();
		jo.put("name","张三");
		jo.put("age", "20");
		System.out.println(jo.toString());
		request.setAttribute("json", jo);
		request.getRequestDispatcher("/WEB-INF/json/jsonDemo1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
