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
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.open("GET","<c:url value='/AjaxProvince'/>",true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = callback
}; 

function callback(){
	if (this.readyState==4 && this.status==200) {
		var text = this.responseText;
		var proNames = text.split(",");
		for (var i = 0; i < proNames.length; i++) {
			addProvince(proNames[i]);
		}	
		document.getElementById("province").onchange = loadCities;
		/* var h1 = document.getElementById("h1");
		h1.innerHTML = text; */
	}
} 

function addProvince(proName){
	var option = document.createElement("option");
	var textNode = document.createTextNode(proName);
	option.appendChild(textNode);
	option.setAttribute("value", proName);
	document.getElementById("province").appendChild(option);
}

function addCities(cityName){
	var option = document.createElement("option");
	var textNode = document.createTextNode(cityName);
	option.appendChild(textNode);
	option.setAttribute("value", cityName);
	document.getElementById("city").appendChild(option);
}

function loadCities(){
	var proName = this.value; 
	var xmlHttp = createXMLHttpRequest();
	xmlHttp.open("POST","<c:url value='/AjaxCity'/>",true);
	xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlHttp.send("province="+proName);
	xmlHttp.onreadystatechange = function(){
		if (xmlHttp.readyState==4 && xmlHttp.status==200) {
			var city = document.getElementById("city");
			removeChildNodes(city);
			var option = document.createElement("option");
			var textNode = document.createTextNode("==请选择==");
			option.appendChild(textNode);
			city.appendChild(option);
			var text = xmlHttp.responseText;
			var cities = text.split(",");
			for (var i = 0; i < cities.length; i++) {
				addCities(cities[i]);
			}
		}
	}   
}; 

function removeChildNodes(ele){
	var nodes = ele.childNodes;
	while(nodes.length > 0){
		ele.removeChild(nodes[0]);
	}
}


</script>
</head>
<body>
	<div>这是ajax-city.jsp</div>
	<div>省份</div>
	<select name="province" id="province">
		<option>==请选择==</option>
	</select>
	<div>城市</div>
	<select name="city" id="city">
		<option>==请选择==</option>
	</select>
	<h1 id="h1"></h1>
</body>
</html>