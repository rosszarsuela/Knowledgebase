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

<%@include file="footer.jsp"%>