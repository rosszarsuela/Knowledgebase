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
		#imgOr {
		    margin: auto;
	   		width: 30%;
	   		padding-bottom: 9px;
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

			
			<div class="text">
				
				<label><h1>Oris Oral Implant Solutions Inc. </h1></label>
				<label> Comfoods Annex B Bldg., Senator Gil Puyat Avenue </label>
				<label> Comer Chino Roces Avenue, Makati City 1200</label>
				<label> Philippines</label>
				<label> Telephone Number: 822-9858</label>
				<label> Email address: </label> 
				
			</div>
		</div>
<br>




<%@include file="footer.jsp"%>