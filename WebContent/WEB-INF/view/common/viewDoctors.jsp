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
		<br>

		<div class="header">
			 <h2>EDUCATORS</h2>
		</div>


	<div align="center" style="padding-top: 0px; margin-left: 0px; ">
				<c:if test="${not empty page.content}"></c:if><%-- <div>${page.currentPage}&nbsp;&nbsp;&nbsp;of&nbsp;&nbsp;&nbsp;${page.totalPages}</div> --%>
				<div style="display: inline;">
					<c:if test="${page.currentPage gt 1}">
						<%-- <a class="btn btn-info" href="<c:url value="/web/view/mentors">
							<c:if test="${not empty doctorCommand.lastName}">
								<c:param name="search" value="${doctorCommand.lastName}" />
							</c:if>
								<c:param name="begin" value="1" />
								<c:param name="orderBy" value="${orderBy}"/>
								<c:param name="sortBy" value="${sortBy}"/>										    							
							</c:url>">First&nbsp;
						</a> --%>
						<a class="glyphicon glyphicon-chevron-left" href="<c:url value="/web/view/mentors">
								<c:if test="${not empty doctorCommand.lastName}">
									<c:param name="search" value="${doctorCommand.lastName}" />
								</c:if>
		  							<c:param name="begin" value="${page.currentPage - 1}" />
		  							<c:param name="orderBy" value="${orderBy}"/>
		  							<c:param name="sortBy" value="${sortBy}"/>										    							
		  						</c:url>">
						
						</a>
						&nbsp;
					</c:if>
				</div>
				<div style="display: inline;">
					<c:if test="${page.currentPage lt page.totalPages}">
						<a class="glyphicon glyphicon-chevron-right" href="<c:url value="/web/view/mentors">
								<c:if test="${not empty doctorCommand.lastName}">
									<c:param name="search" value="${doctorCommand.lastName}" />
								</c:if>
		  							<c:param name="begin" value="${page.currentPage + 1}" />
		  							<c:param name="orderBy" value="${orderBy}"/>
		  							<c:param name="sortBy" value="${sortBy}"/>										    							
		  						</c:url>">
						
							<%-- 	<div style="display: inline;">
					<c:if test="${page.currentPage lt page.totalPages}">
						<a class="btn btn-info" href="<c:url value="/web/view/mentors">
								<c:if test="${not empty doctorCommand.lastName}">
									<c:param name="search" value="${doctorCommand.lastName}" />
								</c:if>
		  							<c:param name="begin" value="${page.currentPage + 1}" />
		  							<c:param name="orderBy" value="${orderBy}"/>
		  							<c:param name="sortBy" value="${sortBy}"/>										    							
		  						</c:url>">
							Next --%>
						</a>&nbsp;
						<%-- <a class="btn btn-info" href="<c:url value="/web/view/mentors">
							<c:if test="${not empty doctorCommand.lastName}">
								<c:param name="search" value="${doctorCommand.lastName}" />
							</c:if>
								<c:param name="begin" value="${page.totalPages}" />
								<c:param name="orderBy" value="${orderBy}"/>
								<c:param name="sortBy" value="${sortBy}"/>										    							
							</c:url>">
							Last
						</a>&nbsp; --%>
					</c:if>
				</div>
				<%-- 	<c:if test="${page.totalRecords gt 0}">
						<div>Total Records: <c:out value="${page.totalRecords}"></c:out></div>
					</c:if>		 --%>
	</div>

	<c:choose>
		<c:when test="${not empty page.content}">
			<c:forEach items="${page.content}" var="obj" varStatus="index">
				<div id="content"><br>
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
								<div class = "educ-prof">
									<h7>${obj.completeName}</h7>
									<h1><c:out value="${obj.profession}"/></h1>
									<p style="white-space: pre-wrap;"><b>SCHOOL:</b><br><c:out value="${obj.address}" /></p>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:when>
	</c:choose>
	
	<!-- <div class="col-md-4 col-md-offset-2 width50-educ">
		<div id="pagin">
            <a id='previous' class="btn btn-info current" href="#">Previous</a>
            <a id='next' class="btn btn-info" href="#">Next</a>
		</div>
	</div> -->
	
</div>
<br><br>
<%@include file="footer.jsp"%>