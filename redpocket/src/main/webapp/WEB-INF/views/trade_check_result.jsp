<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 使用标准标签库的语句 -->
<%@ page import="com.dcone.dtss.model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这里是交易记录查询结果</title>
</head>
<!-- int tid, int wid, int volume, String tradetime -->
${result}
<table>
<tr><td>${str1 }</td><td>${str2 }</td><td>${str3 }</td><td>${str4 }</td><td>${str5 }</td></tr>
<c:forEach items="${list}" var="temp">
<tr><td>${temp.getTid()}</td><td>${temp.getWid()}</td><td>${temp.getVolume()}</td><td>${temp.getTradetime()}</td><td>${temp.getTip() }</tr>
</c:forEach>
</table>
<body>
<a href="/dtss">返回主页</a>
</body>
</html>