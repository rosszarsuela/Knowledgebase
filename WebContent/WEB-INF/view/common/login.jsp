<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>

<style>
	/* @import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
	@import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300); */
	
	body{
		background: rgba(0,0,0,.8); /* Chrome,Safari4+ */
	}

	.login-header div{
		color: white;
		font-family: 'Exo', sans-serif;
		font-size: 35px;
		font-weight: 200;
		text-align: center;
		vertical-align: middle;
		font-weight: bolder;
	}
	
	div.login-forgot {
		color: #fff;
		font-family: 'Exo', sans-serif;
		font-size: 15px;
		font-weight: 200;
		text-align: center;
		vertical-align: middle;
	}
	
	div.login-forgot a {
		color: white;
		text-decoration: none;
		font-family: 'Exo', sans-serif;
	}
	
	div.login-forgot a:hover {
		color: #1BBC9B;
	}
	
	.login-header div span{
		color: #1BBC9B !important;
	}
	
	.login {
		height: 150px;
		padding: 10px;
		text-align: center !important;
		vertical-align: middle !important;
	}
	
	.login input[type=text]{
		width: 250px;
		height: 30px;
		background: transparent;
		border: 1px solid rgba(255,255,255,0.6);
		border-radius: 2px;
		margin: auto;
		color: #fff;
		font-family: 'Exo', sans-serif;
		font-size: 16px;
		font-weight: 400;
		padding: 4px;
	}
	
	.login input[type=password]{
		width: 250px;
		height: 30px;
		background: transparent;
		border: 1px solid rgba(255,255,255,0.6);
		border-radius: 2px;
		margin: auto;
		color: #fff;
		font-family: 'Exo', sans-serif;
		font-size: 16px;
		font-weight: 400;
		padding: 4px;
		margin-top: 10px;
	}
	
	.button{
		width: 250px;
		height: 35px;
		background: #fff;
		border: 1px solid #fff;
		cursor: pointer;
		border-radius: 2px;
		color: #a18d6c;
		font-family: 'Exo', sans-serif;
		font-size: 16px;
		font-weight: 400;
		padding: 6px;
		margin-top: 10px;
	}
	
	.button:hover{
		opacity: 0.8;
	}
	
	.button:active{
		opacity: 0.6;
	}
	
	.login input[type=text]:focus{
		outline: none;
		border: 1px solid rgba(255,255,255,0.9);
	}
	
	.login input[type=password]:focus{
		outline: none;
		border: 1px solid rgba(255,255,255,0.9);
	}
	
	.button:focus{
		outline: none;
	}
	
	::-webkit-input-placeholder{
	   color: rgba(255,255,255,0.6);
	}
	
	::-moz-input-placeholder{
	   color: rgba(255,255,255,0.6);
	}
</style>

<div id="page-wrapper">
	<!-- Header -->
	<div id="header">
		<!-- Logo -->
		<h3>
			<a href="<c:url value="/web/home"/>" id="logo">
			<font face="Arial"><b>ORIS Oral Implant Solutions Inc</b></font></a>
		</h3><br>
		<%@include file="homeNav.jsp"%>
	</div>
</div>

<br><br>

<div class="login-form">
	<div class="container">
	  	
			<div class="col-xs-12">
				<div class="login-header">
					<div>Sign-In</div>
				</div>
			</div>
		
		
		
			<div class="col-xs-12">
				<div class="login">
					<form action="<c:url value="/j_spring_security_check"/>" method="post">
						<input type="text" placeholder="username" name="j_username">
						<input type="password" placeholder="password" name="j_password">
						<input class="button" type="submit" value="Login">
					</form>
				</div>
					
			</div>
		
		
			<div class="col-xs-12">
				<div class="login-forgot"><a href="<c:url value="/web/forgot"/>">Forgot Password?</a></div>
			</div>
	
	</div>
</div>