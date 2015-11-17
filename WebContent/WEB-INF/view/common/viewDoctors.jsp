<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>

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
		<br>
	
	<c:choose>
		<c:when test="${not empty page.content}">
			<c:forEach items="${page.content}" var="obj" varStatus="index">
				<div id="testimonialWrapper"><br>
					<div class="container">
						<div class="row">
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
								<h7>${obj.completeName}</h7>
								<h1><c:out value="${obj.profession}"/></h1>
								<p style="white-space: pre-wrap;"><b>SCHOOL:</b><br><c:out value="${obj.address}" /></p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:when>
	</c:choose>
</div>
<br><br>
<%@include file="footer.jsp"%>