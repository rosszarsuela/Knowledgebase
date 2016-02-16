<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>

<style>
		h2{
			text-align:center;
			color: #37c0fb;
		}
		.infocall{
			margin-left:35%;
		}
		.infocall img{
			width:50% !important;
			height: 50% !important;
		}
		.text{
			text-align:left;
		}
		.text .second
		{
			font-style:italic;
		}
		#header{
			padding:1.5em 0 0 0 !important;
		}	
		#header >h3{
			margin-bottom: .6em !important;
		}
		#imgOr {
		    margin: auto !important;
	   		width: 30% !important;
	   		padding-bottom: 3px !important;
	   	}
		
</style>

<div id="page-wrapper">
		<!-- Header -->
		<div id="header">
			<!-- Logo -->
			<h3>
				<a href="<c:url value="/web/home"/>" id="logo">
				<img class="img-responsive" id="imgOr" src="<c:url value="/images/oris_logo.png"/>" /></a>
			</h3>
			<%@include file="homeNav.jsp"%>
		</div>
</div>

<br>

<div class="heading">
		<h2> Call Us</h2>
	</div>
	

		 <div class="infocall"> 
					<img class="img-responsive" src="<c:url value="/images/Call Us_7482.jpg"/>" />

			
			<div class="text">
				
				<label><h1> Call Oris Implant Solutions Inc. </h1></label>
				<label class="second"> We are here to help you. </label>
				<br>
				<label> For questions on our products and services. </label>
				<label> (Call Mondays to Fridays 9:00am to 5:00pm)</label>
				<label> (632)822-9858</label> 
				
			</div>
		</div>
<br>




<%@include file="footer.jsp"%>