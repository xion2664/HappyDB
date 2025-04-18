<%@page import="DTO.CardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title></title>
<link rel="stylesheet" href="css/font.css">
<!-- 부트스트랩  css 사용 -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<style type="text/css">
html, body {
  height: 100%;
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
<%
	request.setCharacterEncoding("utf-8");
	List<CardDTO> userCard = (List)request.getAttribute("userCard");
	String userId = (String)request.getAttribute("userId");
	String msg = (String)request.getAttribute("msg");
%>
<body class="bg">
<% session.setAttribute("userId", userId); %>
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
			<input type="button" class="btn btn-outline-danger mr-1" value="로그아웃 " onclick="location.href='logout'"/>
      	</form>
    </nav>
    <div class="pt-3" align="center" style="margin:0; margin-top: 80px;">
    	<input type="button" class="btn btn-success" value="명함추가하기" style="margin-left: 5px;" onclick="location.href='cardForm'">
    </div>
    <div class="row mt-2 mx-1 d-flex justify-content-end">
    	<div class="col-lg-4">
    		<form class="form-row" action="searchCard" method="post">
    			<div class="form-group col-lg-3">
    				<select class="form-control" name="cri">
						<option value="name" selected>이름</option>
						<option value="company">회사</option>
					</select>
				</div>
				<div class="form-group col-lg-5">
					<input type="text" class="form-control" name="key" required>
				</div>
				<div class="form-group col-lg-3">
					<button class="btn btn-info" type="submit">검색</button>
				</div>
			</form>
    	</div>
    </div>
    <div class="center-block p-4 p-sm-2" style="margin-top: 10px; margin-left: 10px; margin-right:10px;">
    	<div class="row card-group">
    		<% if(!userCard.isEmpty()) {%>
				<%for(CardDTO list : userCard) {%>
					<div class="card mx-1 col-lg-3 md-4 sm-12 shadow-lg" style="padding-left: 0;">
						<div class="card-body d-flex flex-column h-100" style="padding-bottom: 5px;">
							<div class="mb-auto">
								<div class="d-flex flex-row">
									<h5 class="card-title mr-auto font-weight-normal"><%=list.getName() %></h5>
								<%if(!list.getCompany().isEmpty()) { %>
									<h5 class="card-text text-right"><%=list.getCompany() %></h5>
								<%} %>
								</div>
								<%if(!list.getStaff().isEmpty()) { %>
									<h6 class="card-text mt-0 pt-0" ><%=list.getStaff() %></h6>
								<%} else{%>
									<p class="card-text" style="margin: 0;">&nbsp</p>
								<%} %>
								<hr class="ml-0 mr-1" style="color:black; background-color: black; width: 10%; height: 2px; text-align: left;"/>
							</div>
							<%if(!list.getAddress().isEmpty()) { %>
								<p class="card-text" style="margin: 0;"><%=list.getAddress() %></p>
							<%} %>
							<%if(!list.getTel().isEmpty()) { %>
								<p class="card-text" style="margin: 0;">Tel. <%=list.getTel() %></p>
							<%} %>
							<%if(!list.getMobile().isEmpty()) { %>
								<p class="card-text" style="margin: 0;">mobile. <%=list.getMobile() %></p>
							<%} %>
							<%if(!list.getEmail().isEmpty()) { %>
								<p class="card-text" style="margin: 0;">Email. <%=list.getEmail() %></p>
							<%} %>
						</div>
						<div class="card-footer text-right border-0 bg-white" style="opacity: ;">
							<a href="updateForm?num=<%=list.getId()%>" class="text-primary" style="margin-top: 10px;">보기</a>
							<a>|</a>
							<a href="delete?num=<%=list.getId()%>" class="text-danger" style="margin-top: 10px;" onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</a>
						</div>
					</div>
				<%} %>
    	</div>
    </div>
    	<%}
	else{%>
		<div class="container text-center">
				<%if(msg == null){%>
			<h2>등록한 명함이 없어요 명함을 등록해주세요</h2>
		<%}else{%>
				<h2><%=msg %></h2>
		<%} %>
		</div>
	<%} %>
	
<!-- 부트스트랩  js 사용 -->
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>