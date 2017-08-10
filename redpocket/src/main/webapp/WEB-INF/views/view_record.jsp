<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所有红包记录</title>
</head>
<body>
<table>
<tr><td>${str1 }</td><td>${str2 }</td><td>${str3 }</td><td>${str4 }</td><td>${str5 }</td></tr>
<c:forEach items="${record }" var="temp">
<tr><td>${temp.getRid() }</td><td>${temp.getRound() }</td><td>${temp.getWid() }
</td><td>${temp.getLucky_number() }</td><td>${temp.getTradetime() }</td></tr>
</c:forEach>
<a href="admin">返回红包雨界面</a><br>
<a href="/dtss">返回主页</a>

</table>
</body>
</html>