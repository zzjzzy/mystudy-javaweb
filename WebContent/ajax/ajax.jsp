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
	var btn1 = document.getElementById("btn1");
	btn1.onclick = function(){
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.open("GET","<c:url value='/AjaxDemo?name=张'/>",true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = function(){
			if (xmlHttp.readyState==4 && xmlHttp.status==200) {
				var text = xmlHttp.responseText;
				var h1 = document.getElementById("h1");
				h1.innerHTML = text;
			}
		} 
	}; 
}; 


</script>
</head>
<body>
	<div>这是ajax.jsp</div>
	<button id="btn1">点击</button>
	<h1 id="h1"></h1>
</body>
</html>