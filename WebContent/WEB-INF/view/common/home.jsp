<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<style type="text/css">
	.item {
		background: #333;
		text-align: center;
		max-width: 100%;
		max-height: auto; 
		}
	
	.carousel {
		width: auto;
		margin-top: 0px;
		}
	
	.bs-example {
		margin: 20px;
		}
	
	.carousel-indicators {
		margin-bottom: 0% !important;
		}
		
	h1,h2 {
	 	 margin-top:10px;
	 	 margin-bottom: 10px;
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

	<!-- <section id="banner"> 
		<header>
			<h2>Description: <em>Duis neque nisi, dapibus sed mattis et quis, nibh. Sed et dapibus nisl amet mattis, sed a rutrum accumsan sed....</em></h2>
			<a href="#" class="button">Learn More</a>
		</header>
	</section> -->

	<%-- <c:choose>
		<c:when test="${not empty eventPage.content}">
			<div id="event-carousel" class="carousel slide" data-interval="5500"
				data-ride="carousel">
				
				<!-- Carousel indicators -->
				<ol class="carousel-indicators">
					<c:forEach items="${eventPage.content}" var="obj" varStatus="index">
						<c:choose>
							<c:when test="${index.count-1 eq 0}">
								<li data-target="#event-carousel" data-slide-to="${index.count-1}" class="active"></li>
							</c:when>
							<c:otherwise>
								<li data-target="#event-carousel" data-slide-to="${index.count-1}"></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ol>
				
				<!-- Wrapper for carousel items -->
				<div class="carousel-inner">
					<c:forEach items="${eventPage.content}" var="obj" varStatus="index">
						<c:choose>
							<c:when test="${index.count-1 eq 0}">
								<div class="active item">
							</c:when>
							<c:otherwise>
								<div class="item">
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${not empty obj.contentType}">
								<img class="img-responsive center-block" src="<c:url value="${obj.imageContent}"/>" />
							</c:when>
							<c:otherwise>
								<img class="img-responsive center-block" src="<c:url value="/images/no_image_available.jpg"/>" />
							</c:otherwise>
						</c:choose>
						<div class="carousel-caption">
							<p>${obj.name}</p>
							<p>${obj.description}</p>
							<a class="button btn-md" href="<c:url value="/web/view/event/info">
								<c:param name="id" value="${obj.id}"/></c:url>">Read More</a>
						</div>
					</div>
				</c:forEach>
			</div>
	
				<!-- Carousel controls -->
				<a class="carousel-control left" href="#event-carousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> </a>
				<a class="carousel-control right" href="#event-carousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> </a>
			</div>
		</c:when>
	</c:choose> --%>

	<%-- <br/>
		
		<c:choose>
			<c:when test="${not empty productPage.content}">
				<div id="product-carousel" class="carousel slide" data-interval="3000" data-ride="carousel">
			    	
			    <!-- Carousel indicators -->
					<ol class="carousel-indicators">
			        	<c:forEach items="${productPage.content}" var="obj" varStatus="index">
			        		<c:choose>
								<c:when test="${index.count-1 eq 0}">
									<li data-target="#product-carousel" data-slide-to="${index.count-1}" class="active"></li>
								</c:when>
								<c:otherwise>
									<li data-target="#product-carousel" data-slide-to="${index.count-1}"></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
			        </ol>   
			       
			       <!-- Wrapper for carousel items -->
					<div class="carousel-inner">		            
						<c:forEach items="${productPage.content}" var="obj" varStatus="index">
							<c:choose>
								<c:when test="${index.count-1 eq 0}">
									<div class="active item">
								</c:when>
								<c:otherwise>
									<div class="item">
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${not empty obj.contentType}">
									<img class="img-responsive center-block" src="<c:url value="${obj.imageContent}"/>" />
								</c:when>
								<c:otherwise>
									<img class="img-responsive center-block" src="<c:url value="/images/no_image_available.jpg"/>" />
								</c:otherwise>
							</c:choose>
								<div class="carousel-caption">
										<p>${obj.name}</p>
										<p>${obj.description}</p>
										<a class="button" href="<c:url value="/web/view/product/info">
			   													<c:param name="id" value="${obj.id}"/></c:url>">Read More</a>
								</div>
							</div>
						</c:forEach>
					</div>
					
				<!-- Carousel controls -->
					<a class="carousel-control left" href="#product-carousel" data-slide="prev">
		            	<span class="glyphicon glyphicon-chevron-left"></span></a>
			        <a class="carousel-control right" href="#product-carousel" data-slide="next">
			            <span class="glyphicon glyphicon-chevron-right"></span></a>
					</div>						
			</c:when>
		</c:choose>
	</div>  --%>
	
	
	
<c:choose>
	<c:when test="${not empty solutionPage.content}">
		<div id="event-carousel" class="carousel slide" data-interval="5500" data-ride="carousel">
			<!-- Carousel indicators -->
			<ol class="carousel-indicators">
				<c:forEach items="${solutionPage.content}" var="obj" varStatus="index">
					<c:choose>
						<c:when test="${index.count-1 eq 0}">
							<li data-target="#event-carousel" data-slide-to="${index.count-1}" class="active"></li>
						</c:when>
						<c:otherwise>
							<li data-target="#event-carousel" data-slide-to="${index.count-1}"></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ol>
			
			<!-- Wrapper for carousel items -->
			<div class="carousel-inner">
				<c:forEach items="${solutionPage.content}" var="obj" varStatus="index">
					<c:choose>
						<c:when test="${index.count-1 eq 0}">
							<div class="active item">
						</c:when>
						<c:otherwise>
							<div class="item">
						</c:otherwise>
					</c:choose>
					<c:choose>
					<c:when test="${not empty obj.contentType}">
						<img class="img-responsive center-block" src="<c:url value="${obj.imageContent}"/>" />
					</c:when>
					<c:otherwise>
						<img class="img-responsive center-block" src="<c:url value="/images/no_image_available.jpg"/>" />
					</c:otherwise>
					</c:choose>
						<div class="carousel-caption">
							<%-- <p>${obj.name}</p>
							<p>${obj.description}</p>	 --%>		
							<a class="button btn-md" href="<c:url value="/web/view/portfolio">
								<c:param name="category.solution.id" value="${obj.id}"/></c:url>">Read More</a>
						</div>
					</div>
				</c:forEach>
			</div>
			

			<!-- Carousel controls -->
			<a class="carousel-control left" href="#event-carousel"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left"></span></a>
			<a class="carousel-control right" href="#event-carousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span></a>
		</div>
	</c:when>
</c:choose>


	<!-- Highlights -->
<section class="wrapper style1">
	<div class="container">
		<div class="row 200%">
			<section class="4u 12u(narrower)">
				<div class="box highlight">
					
					<iframe frameborder="0" src="${videoLink1}" frameborder="0" allowfullscreen>"</iframe>
					<h3><c:out value="${video.title1}"/></h3>
					<p class="text-justify"><c:out value="${video.description1}"/></p>
				</div>
			</section>
			
			<section class="4u 12u(narrower)">
				<div class="box highlight">
				
					<iframe src="${videoLink2}" frameborder="0" allowfullscreen></iframe>
					<h3><c:out value="${video.title2}"/></h3>
					<p class="text-justify"><c:out value="${video.description2}"/></p>
				</div>
			
			</section>
			
			<section class="4u 12u(narrower)">
			<div class="box highlight">
				
				<iframe src="${videoLink3}" frameborder="0" allowfullscreen>"</iframe>
					<h3><c:out value="${video.title3}"/></h3>
					<p class="text-justify"><c:out value="${video.description3}"/></p>
				</div>
			</section>
		</div>
	</div>
</section>

<!-- Gigantic Heading -->
<section class="wrapper style2">
	<div class="container">
		<header class="major">
			<h2>A gigantic heading you can use for whatever</h2>
			<p>With a much smaller subtitle hanging out just below it</p>
		</header>
	</div>
</section>

<!-- Posts -->
<section class="wrapper style1">
	<div class="container">
		<div class="rowHome">
			<section class="col-lg-6 width50-rick">
				<div class="box post">
					<a href="#" class="image left"><img src="<c:url value="/images/pic01.jpg"/>"/></a>
					<div class="inner">
						<h3>The First Thing</h3>
						<p>Duis neque nisi, dapibus sed mattis et quis, nibh. Sed et
							dapibus nisl amet mattis, sed a rutrum accumsan sed. Suspendisse
							eu.</p>
					</div>
				</div>
			</section>
			
			<section class="col-lg-6 width50-rick">
				<div class="box post">
					<a href="#" class="image left"><img src="<c:url value="/images/pic02.jpg"/>"/></a>
					<div class="inner">
						<h3>The Second Thing</h3>
						<p>Duis neque nisi, dapibus sed mattis et quis, nibh. Sed et
							dapibus nisl amet mattis, sed a rutrum accumsan sed. Suspendisse
							eu.</p>
					</div>
				</div>
			</section>
		</div>
		
		<div class="rowHome">
			<section class="col-lg-6 width50-rick">
				<div class="box post">
					<a href="#" class="image left"><img src="<c:url value="/images/pic03.jpg"/>"/></a>
					<div class="inner">
						<h3>The Third Thing</h3>
						<p>Duis neque nisi, dapibus sed mattis et quis, nibh. Sed et
							dapibus nisl amet mattis, sed a rutrum accumsan sed. Suspendisse
							eu.</p>
					</div>
				</div>
			</section>
		
			<section class="col-lg-6 width50-rick">
				<div class="box post">
					<a href="#" class="image left"><img src="<c:url value="/images/pic04.jpg"/>"/></a>
					<div class="inner">
						<h3>The Fourth Thing</h3>
						<p>Duis neque nisi, dapibus sed mattis et quis, nibh. Sed et
							dapibus nisl amet mattis, sed a rutrum accumsan sed. Suspendisse
							eu.</p>
					</div>
				</div>
			</section>
		</div>
	</div>
</section>

<%@include file="footer.jsp"%>