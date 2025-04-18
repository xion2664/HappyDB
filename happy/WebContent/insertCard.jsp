<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>명함 추가 페이지</title>
<link rel="stylesheet" href="css/font.css">
<!-- 부트스트랩  css 사용 -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<%
	request.setCharacterEncoding("utf-8");
	String userId = (String)request.getAttribute("userId");
%>
<style type="text/css">
.container{
	padding-top: 10em;
}
.form-group, .label{
	margin: 1px;
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
        	 	<li class="nav-item d-none d-sm-block">
       	 			<a class="nav-link" href="home">Home</a>
       	 		</li>
       	 		<li class="nav-item active">
       	 		 	<a class="nav-link" href="userCard">명함관리 <span class="sr-only">(current)</span></a>
       	 		</li>
       	 	</ul>
      	</div>
      	<form class="form-inline">
			<h6><span class="navbar-text text-light mx-1 mt-2"><%=userId %>님</span></h6>
			<input type="button" class="btn btn-outline-danger" value="로그아웃 " onclick="location.href='logout'"/>
      	</form>
      </nav>
      	<div class="container h-50">
      		<div class="card shadow">
      			<div class="card-body">
      				<h4 class="card-title font-weight-normal" style="text-align: center;">명함추가</h4>
      				<form name="cardForm" action="insertCard" method="post" onsubmit="return valueCheck()">
						<div class="form-row justify-content-center">
							<div class="form-group col-md-5">
								<label for="inputName">Name</label>
								<input type="text" id="inputName" class="form-control" name="name" placeholder="Enter Name" required autofocus>
							</div>
							<div class="form-group col-md-5">
								<label for="inputMobile">Mobile</label>
								<input type="text" id="inputMobile" class="form-control" name="mobile" placeholder="Enter Mobile">
							</div>
						</div>
						<div class="form-row justify-content-center">
							<div class="form-group col-md-5">
								<label for="inputTel">Tel</label>
								<input type="text" id="inputTel" class="form-control" name="tel" placeholder="Enter Tel">
							</div>
							<div class="form-group col-md-5">
								<label for="inputAddress">Address</label>
								<input type="text" id="inputAddress" class="form-control" placeholder="Enter Address" name="address">
							</div>
						</div>
						<div class="form-row justify-content-center">
							<div class="form-group col-md-5">
								<label for="inputEmail">Email</label>
								<input type="email" id="inputEmail" class="form-control" placeholder="Enter Email" name="email">
							</div>
							<div class="form-group col-md-5">
								<label for="inputCompany">Company</label>
								<input type="text" id="inputCompany" class="form-control" placeholder="Enter Company" name="company">
							</div>
						</div>
						<div class="form-row justify-content-center">
							<div class="form-group col-md-5">
								<label for="inputstaff">Staff</label>
								<input type="text" id="inputstaff" class="form-control" placeholder="Enter Staff" name="staff">
							</div>
							<div class="form-group col-md-5">
							</div>
						</div>
						<div class="form-row justify-content-center">
							<button class="btn btn-lg btn-dark btn-block" type="submit" style="margin-top: 5px; width: 30%;">등록</button>
						</div>
					</form>
      			</div>
      		</div>
		</div>
<!-- 부트스트랩  js 사용 -->
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>