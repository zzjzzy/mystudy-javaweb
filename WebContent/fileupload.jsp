<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="uft-8">
<title>Insert title here</title>
</head>
<body>
<div>这是index.jsp</div>
<form action="${pageContext.request.contextPath }/FileUploadServlet" method="post" 
enctype="multipart/form-data">
	<input type="text" name="username"/>
	文件1：<input type="file" name="file1"/>
	文件2：<input type="file" name="file2"/>
	<input type="text" name="password"/>
<input type="submit" value="提交"/>
</form>
</body>
</html>