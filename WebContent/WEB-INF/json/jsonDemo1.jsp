<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="uft-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var json = ${requestScope.json};
		var h1 = document.getElementById("h1");
		h1.innerHTML = json.name;
	}

</script>
</head>
<body>
	<div>这是jsondemo1.jsp</div>
	<div>
		${requestScope.json }
	</div>
	<h1 id="h1"></h1>
	

</body>
</html>