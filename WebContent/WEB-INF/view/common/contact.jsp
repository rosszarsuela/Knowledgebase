<%-- <%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>
<script>
	$('#contact-form').validator();
</script>

	<style>
		h1,h2,h3 {
		 	 margin-top:10px;
		 	 margin-bottom:30px;
			}
	</style>
	
	<div id="page-wrapper">
			<!-- Header -->
			<div id="header">
				<!-- Logo -->
				<h3>
					<a href="<c:url value="/web/home"/>" id="logo">
					<font face="Arial"><b>ORIS Oral Implant Solutions Inc</b></font></a>
				</h3>
				<%@include file="homeNav.jsp"%>
			</div>
	<br><br>
	<div class="container">
		<div class="rowContact">
			<div class="col-md-10 col-md-offset-1">
				<div class="map">
					<h4>GET IN TOUCH</h4>
					<iframe width="100%" height="250" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/place?q=Comfoods%20Building%2C%20Makati%2C%20Metro%20Manila%2C%20Philippines&key=AIzaSyAvFz1LTIXomjnVoQYNProO1C1WXZLGF08" allowfullscreen></iframe>
				</div>
			</div>
		</div>
		<br>
		<div class="rowContact">
			<div class="col-md-10 col-md-offset-1">
				<div class="contact-infom">
					<h4>CONTACT INFO</h4>
					<p class="text-justify">Lorem ipsum dolor sit amet, consectetur adipisicing elit,sheets containing Lorem Ipsum passages, 
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.It was popularised in the 1960s with the release of Letraset
						and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
					</p>
				</div>
			</div>
		</div>
		<div class="rowContact">
			<div class="col-md-4 col-md-offset-1">
				<div class="address">
					<div class="address-left">
						<h4>ADDRESS:</h4>
						<p class="text-justify">Comfoods Annex Building Gil Puyat Ave.</p>
						<p class="text-justify">cor. Chino Roces St. Makati City</p>
						<p class="text-justify">Telephone : 822 9858 / 552 4598</p>
						<p class="text-justify">FAX : 822 9858 / 552 4598</p>
						<p class="text-justify">Email : <a href="mailto:orisoralimplantsolution@gmail.com">orisoralimplantsolution@gmail.com</a></p>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%> --%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>
<script>
	$('#contact-form').validator();
</script>

	<style>
		h1,h2,h3 {
		 	 margin-top:10px;
		 	 margin-bottom:30px;
			}
				.Write
				{
					width: 30% !important;
					height: 60% !important;
					border: 2px solid white !important;
					box-shadow: 0 1px 1px 1px #CCC;
					margin: 0 0 0 40px !important;
				}
				.Write img
				{
					width: 80% !important;
					height: 80% !important;
					position: relative;
					left:30px !important;
					
				}
				.Call
				{
					width: 30% !important;
					height: 60% !important;
					border: 2px solid white !important;
					box-shadow: 0 1px 1px 1px #CCC;
					margin: 0 0 0 40px !important;
				}
				.Call img 
				{
					width: 300px !important;
					height: 203px !important;
					position: relative;
					padding: 0 0 0 20px !important;
					left:30px !important;
				}
				.Corporate
				{
					width: 30% !important;
					height: 70% !important;
					border: 2px solid white !important;
					box-shadow: 0 1px 1px 1px #CCC;
					margin: 0 0 0 40px !important;
				}
				.Corporate img 
				{
					width: 300px !important;
					height: 203px !important;
					position: relative;
					padding: 0 0 0 20px !important;
					left:30px !important;
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
				<img class="img-responsive" id ="imgOr" src="<c:url value="/images/oris_logo.png"/>" />
			</h3>
			<%@include file="homeNav.jsp"%>
		</div>
</div>
			
	<br><br>		
	<div class="container">
			<div class="Write col-sm-4 col-md-4">
				<img class="img-responsive" src="<c:url value="/images/Write Us_7408.jpg"/>" />
					<h1>Write Us</h1>
						<p>Read to Us through mail</p>
						<a class="button" href="<c:url value="/web/view/contact/form"/>">Register for Event</a>
							<a href="<c:url value="/web/view/contact/form"/>">See more</a>
			</div>
			
			<div class="Call col-sm-4 col-md-4" >
				<img class="img-responsive" src="<c:url value="/images/Call Us_7482.jpg"/>" />
					<h1>Call Us</h1>
						<p>We are here to help you!</p>
						<a href="<c:url value="#"/>">See more</a>
							<!-- <a href="/Oris/web/view/common/callUs.jsp">Link</a> -->
			</div>
			
			<div class="Corporate col-sm-4 col-md-4">
				<img class="img-responsive" src="<c:url value="/images/Corporate Office_160216.jpg"/>" />
					<h1>Corporate Office</h1>
						<p>You can contact us</p>
							<a href="contactForm.jsp">See more</a>
			</div> <br><br>
	</div>

	<br><br>
</div>

<%@include file="footer.jsp"%>