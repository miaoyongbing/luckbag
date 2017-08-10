<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check11(){
	if(document.getElementById("itcode").value.length==0){
		//alert("用户名不能为空");
		document.getElementById("afteritcode").innerText="请输入itcode";
		return false;
	}else{
		document.getElementById("afteritcode").innerText="";
		return true;
	}
}
function check12(){
	if(document.getElementById("username").value.length==0){
		//alert("用户名不能为空");
		document.getElementById("afterusername").innerText="请输入用户名";
		return false;
	}else{
		document.getElementById("afterusername").innerText="";
		return true;
	}
}
function check13(){
	if(document.getElementById("date").value.length==0){
		//alert("用户名不能为空");
		document.getElementById("afterdate").innerText="请输入日期";
		return false;
	}else{
		document.getElementById("afterdate").innerText="";
		return true;
	}
}

</script>
</head>
<body>
欢迎来到钱的世界,<a href="balance_add">充值</a>
<hr>
您可以查看某天您的交易记录：<hr>
<form name="from1" action="trade_check">

<table>
<tr><td>输入itcode</td><td><input id="itcode" name="itcode" onblur="check11()"></td><td><span id="afteritcode" style="color:red"></span></td></tr>
<tr><td>输入用户姓名</td><td><input id="username" name="username" onblur="check12()"></td><td><span id="afterusername" style="color:red"></span></td></tr>
<tr><td>输入日期</td><td><input id="date" name="date" type="date" onblur="check13()"><td><span id="afterdate" style="color:red"></span></td></td></tr>
<tr><td><input type="submit" value="提交"></td></tr>
</table>
</form>
<hr>
开启红包雨<a href="luckyadmin">进入红包雨界面</a><hr>
<a href="luck">进入抢红包界面</a><hr>
<a href="program">进入打赏界面</a><hr>
现在服务器的时间是<c:out value="${serverTime }"></c:out>

<a href="perform">测试进入节目界面</a><hr>
<a href="luckymoney">测试进入红包界面</a><hr>
</body>
</html>