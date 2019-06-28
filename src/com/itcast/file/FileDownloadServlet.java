package com.itcast.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class AjaxDemo
 */
@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FileDownloadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		String fileName = request.getParameter("path");
//		fileName = new String(fileName.getBytes("UTF-8"), "UTF-8");
//		System.out.println(fileName);
		String filepath = this.getServletContext().getRealPath("/WEB-INF/uploads/") + fileName;
		File file = new File(filepath);
		if (!file.exists()) {
			response.getWriter().write("下载文件不存在");
			return;
		}
//		response.getOutputStream().write();
		fileName = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
		response.setHeader("content-disposition", "attachment;filename="+fileName);
		IOUtils.copy(new FileInputStream(file), response.getOutputStream());
//		response.getWriter().write("文件下载成功");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
