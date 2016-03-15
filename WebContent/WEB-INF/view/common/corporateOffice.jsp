<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>

<style>
		h2{
			text-align:left;
			color: blue;
			margin-bottom: -6px !important;
			padding-left: 468px !important;
		}
		.infocall{
			margin-left:35%;
		}
		.infocall img{
			width:50% !important;
			height: 50% !important;
		}
		.infocall a{
			text-decoration:underline;
		}
		.link1{
			font-size: 10px;
   			font-family: Calibri Light;
		}
		.first{
			font-size: 25px;
   			font-family: Calibri Light;
    		font-style: italic;
    		font-weight: 500;
    		margin-bottom: -8px;
		}
		.second{
			font-size: 25px;
   			font-family: Calibri Light;
    		font-style: italic;
   			 font-weight: 500;
    		margin-bottom: -8px;
		}
		.third{
			font-size: 25px;
   			font-family: Calibri Light;
    		font-style: italic;
    		font-weight: 500;
    		margin-bottom: -8px;
		}
		.fourth{
			font-size: 25px;
   			font-family: Calibri Light;
    		font-style: italic;
    		font-weight: 500;
    		margin-bottom: -8px;
		}
		.fifth{
   			font-size: 21px;
   			font-family: calibri light;
    		font-style: italic;
    		font-weight: 500;
    		margin-bottom: -8px;
		}
		.sixth{
   			font-size: 21px;
    		font-family: calibri light;
    		font-style: italic;
    		font-weight: 500;
    		margin-bottom: -8px;
		}
		.seventh{
			color: #000;
			position: absolute;
    		top: 619px;
    		right: 76px;
		}
		.map{
			 margin-left: 118px !important;
		}
		#header{
			padding:.5em 0 0 0 !important;
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
		<h2> Corporate Office</h2>
	</div>
	

		 <div class="infocall"> 
					<img class="img-responsive" src="<c:url value="/images/Corporate Office_160216.jpg"/>" />
					<label class="link1">You can contact us through the form below. Come and visit us to our Corporate Center. call us, email us or get in contact through  <a href="<c:url value="https://www.facebook.com/OrisOralImplantSolutionsInc.Ph/"/>">Facebook</a></label>
					<br>
			<div class="text">
				<label class="first">Oris Oral Implant Solutions Inc.</label>
				<label class="second"> Comfoods Annex B Bldg., Senator Gil Puyat Avenue </label>
				<label class="third"> Comer Chino Roces Avenue, Makati City 1200</label>
				<label class="fourth"> Philippines</label>
				<label class="fifth"> Telephone Number: 822-9858 &</label>
				<label class="sixth"> Email address: </label>
				<label class="seventh">(632)822-9858</label>
				
			</div>
		</div>
		<br><br><br>
		<div class="map">
					<iframe width="90%" height="250" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/place?q=Comfoods%20Building%2C%20Makati%2C%20Metro%20Manila%2C%20Philippines&key=AIzaSyAvFz1LTIXomjnVoQYNProO1C1WXZLGF08" allowfullscreen></iframe>
		</div>
<br>




<%@include file="footer.jsp"%>