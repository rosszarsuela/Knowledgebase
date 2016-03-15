<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>

<style>
		.first {
			font-family: calibri;
			font-style: italic;
			font-size: 33px;
			font-weight: bolder;
    		margin-bottom: 5px;
    		margin-top: 30px;
		}
		
		.third {
			    font-family: calibri;
   				font-weight: bold;
   				font-size: 20px;
    			margin-top: 10px;
    			margin-bottom: -5px;
		}
		
		.fourth {
			    font-size: 15px;
    			padding-left: 5px;
    			font-weight: 500;
		}
		
		.fifth {
				float: right;
   	 			font-size: 20px;
    			margin-top: -63px;
    			margin-right: 150px;
		}
		h2{
			text-align: left;
    		padding-left: 460px;
   			color: blue;
   			margin-bottom: 0px;
   			font-size: 40px;
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
			font-family: georgia;
			font-style: italic;
			font-weight: 500;
    		font-size: 18px;
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
				
				<label class="first">Call Oris Implant Solutions Inc. </label>
				<label class="second"> We are here to help you. </label>
				<br>
				<label class="third"> For questions on our products and services. </label>
				<label class="fourth"> (Call Mondays to Fridays 9:00am to 5:00pm)</label>
				<label class="fifth"> (632)822-9858</label> 
				
			</div>
		</div>
<br>




<%@include file="footer.jsp"%>