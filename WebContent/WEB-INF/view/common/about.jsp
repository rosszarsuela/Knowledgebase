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

<!-- <section class="wrapper style2">
	<div class="container">
		<div class="rowAbout">
			<section class="col-md-6">
				<div class="mission">
					<h2>Our Mission</h2>
					<p class="text-justify">It is a paradisematic country, in which
						roasted parts of sentences fly into your mouth. Even the
						all-powerful Pointing has no control about the blind texts it is an
						almost unorthographic life One day however a small line of blind
						text by the name of Lorem Ipsum decided to leave for the far World
						of Grammar.</p>
				</div>
			</section>
	
			<section class="col-md-5 coloffset-md-1">
				<div class="vision">
					<h2>Our Vision</h2>
					<p class="text-justify">To position Oris Oral Implant Solutions as a company of
						professionals that provides accessible and dependable quality
						dental products, services and solutions that promote advancement in
						the dental field.</p>
				</div>
			</section>
		</div>
	</div>
</section> -->

<section class="wrapper style2">
	<div class="rowAbout">		
		<header class="major">
			<h2>Our Story</h2>
		</header>
		
		<div id="major-body">
			<p class="text-justify">Oris Oral Implant Solutions Inc. was
							established September of 2008 as a trading company engaged in
							promoting, training, marketing, and sales of dental products, devices
							and supplies specifically but not limited on dental implants. It’s an
							all-Filipino company; the stockholders are composed of dental/medical
							practitioners and entrepreneurs.</p>
				
				<p class="text-justify">Oris Oral Implant Solutions Inc. aims to
							offer not just products but solutions – processes, skills and
							training to enhance dentists’ abilities and confidence in their
							practice. The company wouldn’t merely push products, but rather focus
							on providing solutions. Specifically, it wishes to empower dentists
							to develop their own implant practice through knowledge, skills and
							capabilities coming from our training and sustainability programs.</p>
				
				<p class="text-justify">In 2009, as pursuant to its
							mission/vision, Oris spearheaded the first University-based dental
							implant training program at University of the Philippines College of
							Dentistry – Manila. This Post-Graduate course is open to all dental
							practitioners who wish to gain knowledge and skills on how to
							properly insert and restore dental implants. Needless to say, the
							expertise and products promoted by Oris were being utilized in the
							program.</p>
							
				<p class="text-justify">In 2011, due to the growing need for
						credible and reputable provider of dental implant training courses,
						Oris offered and conducted short yet powerful training modules on
						dental implants with emphasis and focus not only in surgical
						insertion but more on prosthodontics aspect. This makes Oris as the
						only training provider with Prosthodontically Driven modules with
						impeccable mentors and offers high quality yet affordable implant
						materials. In the same year, Oris was converted to a corporation.
						Also the company moved to a bigger space at Comfoods building right
						at the heart of Makati business district, which became known as Oris
						Implant Center. The center holds not only the office, but also three
						dental operatories and conference / training room as well. These new
						facilities significantly uplift Oris level of service and commitment
						in providing the best teaching and skill enhancement center in the
						field of dental implants.</p>
						
				<p class="text-justify">Moreover, Oris collaborated with a big
						hospital in Manila to offer the first hospital based implant training
						program. This new program is held at Metropolitan Medical Center and
						targeted for participants seeking more intensive and advanced
						surgical training in implant dentistry. This further strengthens Oris
						position as a significant provider of different types of implant
						trainings to suit customer needs. Implant training participants can
						now select from a variety of training programs which could either be
						comprehensive module or practical module or maybe an advanced module
						in order to meet their specific needs.</p>
						
				<p class="text-justify">Also Oris further broaden its product
						offering by getting distributorship of Dexcowin, Rhein 83 and Mesa.
						Oris added to sell dental hand-held radiograph devices, oral x-ray
						sensor, prosthodontics attachments, regenerative, and augmentative
						biomaterials. These products are sourced in Seoul, Korea, Italy and
						Germany. Recently, Oris signed up to distribute RayScan Digital
						Radiographic Imaging System in the Philippines. The company
						manufactures Panoramic, Cephalometeric and Cone Beam Computed
						Topography (CBCT) dental imaging system. This will further strengthen
						product portfolio of Oris and demonstrate our vision to be the “top
						of mind choice” in providing dental products and services. Oris is
						still looking into having more new products to introduce and offer
						new skill building training modules to the local market scene.
						Ultimately, Oris is geared towards making the next wave of tools and
						technology accessible, accelerating innovation and advancement in the
						field of dentistry.</p>
		</div>
	</div>
</section>

<%@include file="footer.jsp"%>