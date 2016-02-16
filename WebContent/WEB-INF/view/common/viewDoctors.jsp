<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<%-- <script type="text/javascript" src="<c:url value="/js/doctors/educators.js"/>"></script> --%>

<style>
	div.header {
		text-align: center;
	}
	a.btn-info {
		width: 10em;
	}
	
	.glyphicon-chevron-right {
		top: 200px;
		right: -530px; 
		font-size: 50px;
		color: #337ab7;
	}
	.glyphicon-chevron-left {
		top: 200px;
		left: -530px; 
		font-size: 50px;
		color: #337ab7;
	}
	#imgOr {
	    margin: auto;
   		width: 30%;
   		padding-bottom: 9px;
	}
	 h1, h2, h3, h4, h5 {
    color: inherit;
    font-weight: 600;
    line-height: 1.75em;
    margin-bottom: 1em;
    }
    h6 {
    margin-bottom: 7%;
    margin-top: -4%;
    font-weight: 400;
    font-size: 15px;
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

		<div class="header">
			 <h2>EDUCATORS</h2>
		</div>


	<div align="center" style="padding-top: 0px; margin: -45px; ">
				<c:if test="${not empty page.content}"></c:if>
				<div style="display: inline;">
					<c:if test="${page.currentPage gt 1}">
						<a class="glyphicon glyphicon-chevron-left" href="<c:url value="/web/view/mentors">
		  							<c:param name="begin" value="${page.currentPage - 1}" />
		  						</c:url>">						
						</a>
						&nbsp;
					</c:if>
				</div>
				<div style="display: inline;">
					<c:if test="${page.currentPage lt page.totalPages}">
						<a class="glyphicon glyphicon-chevron-right" href="<c:url value="/web/view/mentors">
		  							<c:param name="begin" value="${page.currentPage + 1}" />
		  						</c:url>">
						</a>&nbsp;
					</c:if>
				</div>	
	</div>

	<c:choose>
		<c:when test="${not empty page.content}">
			<c:forEach items="${page.content}" var="obj" varStatus="index">
				<div id="content"><br>
					<div class="container">
						<div class="rowEducators">
							<c:choose>							
								<c:when test="${page.currentPage%2==0}">
								<div class="col-md-4 col-md-offset-2 width50-educ">
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
									</div>
									<div class="col-md-5 width50-educ">
										<div class = "educ-prof">
											<h7>${obj.completeName}</h7>
											<h1><c:out value="${obj.profession}"/></h1>
											
											<h1 class="text-justify" style="white-space: pre-wrap;"><c:out value="${obj.school1}"/></h1>
											<h6><c:out value="${obj.fullCourse1}"/></h6>
											
											<h1 class="text-justify" style="white-space: pre-wrap;"><c:out value="${obj.school2}"/></h1>
											<h6><c:out value="${obj.fullCourse2}"/></h6>
										</div>
									</div>
									
								</c:when>
								
								<c:otherwise>
									<div class="col-md-5 col-md-offset-2 width50-educ">
										<div class = "educ-prof">
											<h7>${obj.completeName}</h7>
											<h1><c:out value="${obj.profession}"/></h1>
											
											<h1 class="text-justify" style="white-space: pre-wrap;"><c:out value="${obj.school1}"/></h1>
											<h6><c:out value="${obj.fullCourse1}"/></h6>
											
											<h1 class="text-justify" style="white-space: pre-wrap;"><c:out value="${obj.school2}"/></h1>
											<h6><c:out value="${obj.fullCourse2}"/></h6>
											
										</div>
									</div>
									<div class="col-md-4 width50-educ">
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
									</div>
								</c:otherwise>
							</c:choose>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:when>
	</c:choose>
<br><br>
<%@include file="footer.jsp"%>