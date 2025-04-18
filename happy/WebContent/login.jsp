<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	request.setCharacterEncoding("utf-8");
%>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/font.css">
<!-- 부트스트랩  css 사용 -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta charset="utf-8">
<title>로그인 페이지</title>
<style type="text/css">
html, body {
  height: 100%;
}
.container{
	padding-top: 13em;
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
      		<input type="button" class="btn btn-light" value="회원가입" onclick="location.href='joinForm'"/>
      	</form>
      </nav>
	<div class="container h-50">
		<h1 class="h3 mb-3 font-weight-normal text-center">로그인</h1>
		<div class="row mb-0 justify-content-center">
			<div class="card w-50 shadow">
				<div class="card-body">
					<form name="loginForm" action="login" method="post">
						<div class="form-group">
							<label for="inputId">ID</label>
							<input type="text" id="inputId" class="form-control" name="id" placeholder="ID" required autofocus>
						</div>
						<div class="form-group">
							<label for="inputPassword">Password</label>
							<input type="password" id="inputPassword" class="form-control" placeholder="Password" name="pwd" required>
						</div>
						<button class="btn btn-lg btn-dark btn-block" type="submit">로그인</button>
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