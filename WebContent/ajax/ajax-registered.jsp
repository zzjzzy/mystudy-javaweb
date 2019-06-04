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
function createXMLHttpRequest() {
	var xmlHttp;
	// 适用于大多数浏览器，以及IE7和IE更高版本
	try{
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// 适用于IE6
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			// 适用于IE5.5，以及IE更早版本
			try{
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e){}
		}
	}			
	return xmlHttp;
}

window.onload = function(){
	var username = document.getElementById("username"); 
	username.onblur = function(){
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.open("POST","<c:url value='/AjaxRegistered'/>",true);
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		var username = document.getElementById("username")
		xmlHttp.send("username="+username.value);
		xmlHttp.onreadystatechange = function(){
			if (xmlHttp.readyState==4 && xmlHttp.status==200) {
				var text = xmlHttp.responseText;
				var h1 = document.getElementById("h1");
				if (text == "true") {
					h1.innerHTML = "用户名已注册";
				} else{
					h1.innerHTML = "用户名可用";
				}
				

			}
		} 
	}; 
}; 


</script>
</head>
<body>
	<div>这是ajax-registered.jsp</div>
	<form action="">
		用户名：<input type="text" id="username" name="username"/>
	</form>
	<h1 id="h1"></h1>
</body>
</html>