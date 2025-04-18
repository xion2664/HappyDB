<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>메인 페이지</title>
<style type="text/css">
.container-fluid{
	padding-top: 10em;
	padding-bottom: 13em;
}
.bg{
	background-image: url('img/background.png');
	height: 100%;
	width: 100%;
	background-position: center;
  	background-repeat: no-repeat;
  	background-size: cover;
}
</style>
<%
	request.setCharacterEncoding("utf-8");
	String userId = (String)request.getAttribute("userId");
%>
<link rel="stylesheet" href="css/font.css">
<!-- 부트스트랩  css 사용 -->
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="home">해피명함</a>
      	<div class="collapse navbar-collapse">
        	 <ul class="navbar-nav mr-auto">
        	 	<li class="nav-item active d-none d-sm-block">
       	 			<a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
       	 		</li>
       	 		<li class="nav-item">
       	 			<%
						if(userId != null) {
					%>
       	 		 	<a class="nav-link" href="userCard">명함관리</a>
       	 		 	<%} %>
       	 		</li>
       	 	</ul>
      	</div>
      	<form class="form-inline">
      		<%
				if(userId == null) {
			%>
      		<a class="nav-link text-light" href="loginForm">로그인</a>
      		<input type="button" class="btn btn-light" value="회원가입" onclick="location.href='joinForm'"/>
      		<%
				}
				else {
					session.setAttribute("userId", userId);
			%>
			<h6><span class="navbar-text text-light mx-1 mt-2"><%=userId %>님</span></h6>
			<input type="button" class="btn btn-outline-danger" value="로그아웃 " onclick="location.href='logout'"/>
			<%} %>
      	</form>
    </nav>
	<div class="container-fluid bg">
		<h2 class="text-center text-white" style="padding-top: 4em;">해피 명함과 함께 명함관리를 시작해보세요.</h2>
		<%
			if(userId == null) {
		%>
			<div class="text-center">
				<button type="button" class="btn btn-primary btn-lg" onclick="location.href='joinForm'">시작하기→</button>
			</div>
		<%} %>
	</div>
	<hr class="my-2">
	<footer>
		<div class="row" style="margin-left: 1em;">
			<div class="col-3">
				<h5>Team</h5>
				<ul class="list-unstyled text-small text-muted">
            		<li>팀명: 해피</li>
            		<li>20184040 장기원</li>
            		<li>20184048 박시연</li>
          		</ul>
			</div>
			<div class="col-3">
				<h5>Using</h5>
				<ul class="list-unstyled text-small text-muted">
            		<li>Bootstrap</li>
            		<li>Java</li>
            		<li>JSP</li>
            		<li>Tomcat</li>
            		<li>MySQL</li>
          		</ul>
          	</div>
		</div>
	</footer>
<!-- 부트스트랩  js 사용 -->
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>