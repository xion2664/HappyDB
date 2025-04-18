<%@page import="DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	request.setCharacterEncoding("utf-8");
	String id = (String)request.getAttribute("id");
%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>회원가입</title>
<link rel="stylesheet" href="css/font.css">
<!-- 부트스트랩  css 사용 -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<style type="text/css">
html, body {
  height: 100%;
}
.container{
	padding-top: 10em;
}
.form-group, .label{
	margin: 4px;
}
.bg{
	background-image: url('img/background.png');
	background-position: center;
  	background-repeat: no-repeat;
  	background-attachment: fixed;
  	background-size: cover;
}
</style>
<script type="text/javascript">
	function valueCheck() {
		if (document.joinForm.pwd.value != document.joinForm.rePwd.value) {
			alert("비밀번호가 일치하지않습니다.");
			document.joinForm.pwd.value = '';
			document.joinForm.rePwd.value = '';
			document.joinForm.pwd.focus();
			return false;
		}
	}
</script>
</head>
<body class="bg">
	<nav class="navbar navbar-expand navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="home">해피명함</a>
      	<div class="collapse navbar-collapse">
        	 <ul class="navbar-nav mr-auto">
        	 	<li class="nav-item active d-none d-sm-block">
       	 			<a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
       	 		</li>
       	 	</ul>
      	</div>
      	<form class="form-inline">
      		<a class="nav-link text-light" href="loginForm">로그인</a>
      		<input type="button" class="btn btn-light" value="회원가입" onclick="location.href='joinForm'"/>
      	</form>
      </nav>
	<div class="container h-50">
		<h1 class="h3 mb-3 font-weight-normal text-center">회원가입</h1>
		<div class="row justify-content-center">
			<div class="card w-50 shadow">
				<div class="card-body">
					<form name="joinForm" action="join" method="post" onsubmit="return valueCheck()">
						<div class="form-group">
							<label for="inputName">이름</label>
							<input type="text" id="inputName" class="form-control" name="name" placeholder="Enter Name" required autofocus>
						</div>
						<div class="form-group">
							<label for="inputId">아이디</label>
							<input type="text" id="inputId" class="form-control" name="id" placeholder="Enter ID" required>
						</div>
						<div class="form-group">
							<label for="inputRePassword">비밀번호</label>
							<input type="password" id="inputRePassword" class="form-control" placeholder="Enter Password" name="pwd" required>
						</div>
						<div class="form-group">
							<label for="inputPassword">비밀번호 확인</label>
							<input type="password" id="inputPassword" class="form-control" placeholder="Enter Password" name="rePwd" required>
						</div>
						<button class="btn btn-lg btn-dark btn-block" type="submit">회원가입</button>
					</form>
				</div>
			</div>
		</div>
	</div>
<!-- 부트스트랩  js 사용 -->
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>