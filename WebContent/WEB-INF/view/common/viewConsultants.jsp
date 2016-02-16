<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/doctors/consultants.js"/>"></script>

<style>
	div.header {
		text-align:center;
	}
	h1 {
	    color: inherit;
	    font-weight: 600;
	    line-height: 1.75em;
	    margin-bottom: 0em;
	}
	#header{
	padding:1em 0 0 0;
	}
	#imgOr {
	    margin: auto;
   		width: 30%;
   		padding-bottom: 5px;
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
		
		<div class="container">
			<div class="header">
				 <h2>Professional Service Consultants</h2>
			</div>
		</div>
		
	<div class="container">
		<c:choose>
			<c:when test="${not empty page.content}">
				<c:forEach items="${page.content}" var="obj" varStatus="index">
					<div class="col-md-6">
						<div id="content"><br>
							<section class="col-md-8 col-md-offset-2">
								<div class="educators-picture">
									<c:choose>
										<c:when test="${empty obj.contentType}">
											<img class="img-responsive" src="<c:url value="/images/no_image_available.jpg"/>" />
										</c:when>
										<c:otherwise>
											<img class="img-responsive" src="<c:url value="${obj.imageContent}"/>" />
										</c:otherwise>
									</c:choose>
								</div>
							
								<div class="col-md-12 educ-prof col-md-offset-1">
									<h1>${obj.completeName} , <c:out value="${obj.profession}"/></h1>
									<p style="white-space: pre-wrap;"><c:out value="${obj.address}" /></p>
								</div>
							<div class="clearfix"></div>
							</section>
						</div>
					</div>
				</c:forEach>
			</c:when>
		</c:choose>
	</div>
	
</div>
<br><br>
<%@include file="footer.jsp"%>