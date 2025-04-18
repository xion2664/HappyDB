<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%
	request.setCharacterEncoding("utf-8");
	String msg = (String)request.getAttribute("msg");
%>
<title></title>
<script type="text/javascript">
	var Emsg = "<%=msg%>";
	if(Emsg == "비밀번호가 틀립니다."){
		alert(Emsg);
		location.replace("login.jsp");
	}
	else if(Emsg == "존재하지않는 아이디입니다. 회원가입하시겠습니까?"){
		var con = confirm(Emsg)
		if(con == true){ // 확인
			location.replace("join.jsp");
		}else{ // 취소
			location.replace("login.jsp");
		}
	}
</script>
</head>
<body>
</body>
</html>