<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>

<style>
	div.mission h1,h2 {
 	 	margin-top:10px;
 	 	margin-bottom: 10px;
 	 	font-size: 30px;
	}
	
	div.vision h1,h2 {
 	 	margin-top:10px;
 	 	margin-bottom: 10px;
 	 	font-size: 30px;
	}
	
	.wrapper {
		padding: 1em 0 1em 0;
	}
	#header{
		padding: 1em 0 0 0 !important;	
	}
	#header >h3{
		margin-bottom: .6em !important;
	}
	#imgOr {
	    margin: auto !important; 
   		width: 30% !important;
   		padding-bottom: 3px !important;
	}
	
	h2 {
  margin-top: 40px;
  font-weight: 200;
  color: #333;
}



.quote {
  background: #ebf3f5;
  padding: 15px 20px 5px 15px;
  border-radius: 5px;
  margin-bottom: 30px;
}
.quote:after {
  content: '';
  width: 0px;
  height: 0px;
  border-style: solid;
  border-width: 20px 18px 0 18px;
  border-color: #ebf3f5 transparent transparent transparent;
  position: relative;
  top: 37px;
  left: 20px;
}

.student {
  margin-left: 25px;
  margin-bottom: 80px;
}
.student .photo {
  background-color: #ccc;
  border-radius: 100px;
  width: 60px;
  height: 60px;
  float: left;
  margin-right: 10px;
}
.student p {
  position: relative;
  top: 5px;
  text-transform: uppercase;
}
.student p:nth-child(2) {
  font-size: 16px;
  font-weight: 600;
  margin-bottom: 0;
}
.student p:nth-child(3) {
  font-size: 14px;
  color: #777;
}
	
	.centered-text {
  text-align: center;
}

.page-wrapper2 {
	margin: 40px 100px 4px 135px;
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

<div class="testimonial-wrap">

	<div class="large-12 columns centered-text">
		<h2>What these awesome people have to say!</h2>
	</div>
	
	
	<div class="page-wrapper2">
	
			<h2 class="global__section-title">Clients say</h2>
			<div class="colspan12-10 colspan4-4 push12-1 as-grid">
				<ul class="clients__quote-list" style="height: 162px;">
				
					<li class="clients__quote-item" data-duration="15" style="display: list-item;">
							<p>“Throw your preconceptions of web design and development out of the window; fffunction do it different and they do it better. fffunction didn’t just pay lip service to the user-centred approach, they lived and breathed it to ensure our site would allow users to quickly find what they want – and enjoy the&nbsp;journey.”</p>
							<footer>
								<cite>— <b>Alex Smalley,</b> Communications &amp; Outreach Manager ECEHH</cite>
							</footer>
					</li>
				
					<li class="clients__quote-item" data-duration="12" style="display: none;">
						<!-- <blockquote> -->
							<p>“Throughout the project the team at fffunction were excellent. They took our brief and brand on board quickly and were able to accuralty reflect this in initial designs. Both creative input and systems exceptionally good and the final website is everything we hoped for. ”</p>
							<footer>
								<cite>— <b>Jon Lanyon,</b> Creative director, Hurricane</cite>
							</footer>
						<!-- </blockquote> -->
					</li>
				
					<li class="clients__quote-item" data-duration="10" style="display: none;">
						<blockquote>
							<p>“We had already started to adopt an end-user led approach to our marketing but fffunction have taken this forward ten-fold with a truly user centric design aimed at optimising the customer journey.”</p>
							<footer>
								<cite>— <b>Helen Whitten,</b> Marketing Director, Roland UK</cite>
							</footer>
						</blockquote>
					</li>
				
					<li class="clients__quote-item" data-duration="8" style="display: none;">
						<blockquote>
							<p>“fffunction have turned our brand around from ‘good enough’ to ‘best of breed’ with a clean, professional and creative new&nbsp;style.”</p>
							<footer>
								<cite>— <b>Luke Marsden,</b> CEO, ClusterHQ</cite>
							</footer>
						</blockquote>
					</li>
				
					<li class="clients__quote-item" data-duration="10" style="display: none;">
						<blockquote>
							<p>“What shines through is their enthusiasm. fffunction have made the goals of the project their goals, and worked their socks off to achieve them.”</p>
							<footer>
								<cite>— <b>Jim Hinks,</b> Digital Editor, CommaPress</cite>
							</footer>
						</blockquote>
					</li>
				
					<li class="clients__quote-item" data-duration="10" style="display: none;">
						<blockquote>
							<p>“The front-end agency of the moment – an unstoppable force of vision and creativity. Working with fffunction has been super easy and very rewarding, simply a great team with a fantastic&nbsp;attitude.”</p>
							<footer>
								<cite>— <b>Neil Kinnish &amp; Pete Nelson,</b> Mixture</cite>
							</footer>
						</blockquote>
					</li>
				
				</ul>
			</div>
		</div>

	
	<!-- <section class="page">
		<div class="page-wrapper2">
			<div class="large-3 columns testimonial">
				<div class="quote">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultrices, elit sed faucibus pharetra, diam mauris bibendum orci, sit amet ullamcorper purus dui sit amet augue. Donec aliquet diam ut neque mattis, eu tristique sem rutrum.</p>
				</div>
				<div class="student">
					<div class="photo"> </div>
					<p>John Doe</p>
					<p>Important person, some Company</p>
				</div>
			</div>
			<div class="large-3 columns testimonial">
				<div class="quote">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultrices, elit sed faucibus pharetra, diam mauris bibendum orci, sit amet ullamcorper purus dui sit amet augue. Donec aliquet diam ut neque mattis, eu tristique sem rutrum.  </p>
				</div>
				<div class="student">
					<div class="photo"> </div>
					<p>John Doe</p>
					<p>Important person, some Company</p>
				</div>
			</div>
		</div>
	</section> -->
</div>

<%@include file="footer.jsp"%>