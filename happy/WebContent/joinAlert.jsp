<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%
	request.setCharacterEncoding("utf-8");
	String msg = (String)request.getAttribute("msg");
	System.out.println(msg);
%>
<title></title>
<script type="text/javascript">
	var Emsg = "<%=msg%>";
	alert(Emsg);
	
	if(Emsg == "회원가입 성공"){
		location.replace("login.jsp");
	}
	else{
		location.replace("join.jsp");	
	}
</script>
</head>
<body>
</body>
</html>