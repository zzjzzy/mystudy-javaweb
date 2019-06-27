package com.itcast.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;


/**
 * Servlet implementation class AjaxDemo
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FileUploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		try {
			List<FileItem> list = sfu.parseRequest(request);
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					response.getWriter().print(fileItem.getFieldName()+"："+fileItem.getString("utf-8")+"<br/>");
				} else {
					String name = fileItem.getName();
					if (name == null || name.trim().isEmpty()) {
						continue;
					}
					String path = this.getServletContext().getRealPath("/uploads");
					File file = new File(path, name);
					fileItem.write(file);
					response.getWriter().print("文件名" + name + "<br/>");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
