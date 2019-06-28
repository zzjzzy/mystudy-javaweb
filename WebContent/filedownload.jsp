<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="uft-8">
<title>Insert title here</title>
</head>
<body>
<div>这是文件下载页面</div>
<a href="${pageContext.request.contextPath }/FileDownloadServlet?path=day22-第22天.doc">
day22.doc
</a>
<br/>
<a href="${pageContext.request.contextPath }/FileDownloadServlet?path=el.jsp">
el.jsp
</a>
</body>
</html>