<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="uft-8">
<title>Insert title here</title>
</head>
<body>
	<div>这是index.jsp</div>
	<div><%=900 %></div>
	<%String name="张中建";
	pageContext.setAttribute("name", "李四");
	%>
	${pageScope.name }<br/>
	${fn:toLowerCase("HELLO") }
	<c:set var="aaa" value="AAA"/>
	<c:if test="true">
		<c:out value="aaa"></c:out>
	</c:if>
</body>
</html>