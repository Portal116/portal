<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<script src="${contextPath}/js/scriptTest.js" type="text/javascript"></script>
<meta charset="utf-8">
<title>hellop.jsp 페이지</title>
</head>
<body>
	안녕하세요
	<br>
	<h2>${message}</h2>
	<img src="${contextPath}/image/duke.png" width="200" height="200" />
	<br>
	<input type="button" name="테스트" value="테스트" onclick="test()">
</body>
</html>