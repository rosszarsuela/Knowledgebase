<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<style>
	hr { 
	    display: block;
	    margin-top: 0.5em;
	    margin-bottom: 0.5em;
	    margin-left: auto;
	    margin-right: auto;
	    border-style: inset;
	    border-width: 1px;
    	background-color: #fff;
		background-image: url("../images/bg02.png"), url("../images/bg03.png"), url("../images/bg01.png");
		background-position: top left, bottom left, top left;
		background-size: 100% 6em, 100% 6em, auto;
		background-repeat: no-repeat, no-repeat, repeat;
		size: 2px;
		}
		#header{
		padding:1em 0 0 0 !important;
		}	
		#header >h3{
			margin-bottom: .6em !important;
		}
		#imgOr {
		    margin: auto !important;
	   		width: 30% !important;
	   		padding-bottom: 3px !important;
	   	}
	   	
	   	body {
	   		background: #f7f7f7 url("images/bg01.png") !important; 
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
		<div class="container-eventop">
			<div class="event-header">
				 <h2>Trainings / Events / Seminars / Workshop</h2>
			</div>
		</div>
	<c:choose>
		<c:when test="${not empty page.content }">
			<c:forEach items="${page.content}" var="obj" varStatus="index">
				
				<section class="wrapper style4">
					<div class="container">
						<div class="row">
							<section class="col-md-3 col-md-offset-2 event-style">
								<div class="event-picture">
									<c:choose>
										<c:when test="${empty obj.contentType}">
											<img class="img-responsive" src="<c:url value="/images/no_image_available.jpg"/>" />
										</c:when>
										<c:otherwise>
											<img class="img-responsive" src="<c:url value="${obj.imageContent}"/>" />
										</c:otherwise>
									</c:choose>
								</div>
							</section>
					
							<section class="col-md-6 event-style">
								<div class="event-page-header">
									<h2>${obj.name}</h2>
								</div>
								<div class="event-page-desc">
								<h3>${obj.description}</h3>
								</div>
								<c:if test="${not empty obj.eventContentPDF}">
							 	<a class="button" href="<c:url value="/web/view/downloadPdf">
			   							 <c:param name="id" value="${obj.id}"/>
				   						 </c:url>">Download PDF File<%-- <img src="<c:url value="/images/icon/pdf.png"/>" height="60px" width="60px"> --%>
								</a></c:if>
								&emsp;&emsp; 
				        		<a class="button" href="<c:url value="/web/view/event/info">
										<c:param name="id" value="${obj.id}"/></c:url>">Register for Event</a>
			    								
								<%-- <table class="table table-striped table-bordered table-responsive table-condensed" >
									<thead>
										<tr>
											<th><b>Date From:</b></th>
											<th><b>Date To:</b></th>
											<th><b>Slots Available</b></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><fmt:formatDate value="${obj.dateFrom}" pattern="MMMM dd, yyyy" /></td>
											<td><fmt:formatDate value="${obj.dateTo}" pattern="MMMM dd, yyyy" /></td>
											<td><fmt:formatNumber pattern="#,###" value="${obj.slot}"/></td>
										</tr>
									</tbody>
								</table>  --%>
									
							<%-- <c:if test="${not empty obj.speakers}">
								<table class="table table-striped table-bordered table-responsive table-condensed" >
									<thead>
									<tr>
										<th><b>Speakers</b></th>
										<th><b>Topic</b></th>
										<th><b>Time</b></th>
									</tr>
									</thead>
									<tbody>
										<c:forEach var="speaker" items="${obj.speakers}">
											<tr>
												<td><c:out value="${speaker.name}"/></td>
												<td><c:out value="${speaker.subject}"/></td>
												<td><c:out value="${speaker.time}"/></td>
											
										</c:forEach>	
									</tbody>
								</table>
							</c:if> --%>
							</section>
						</div>
					</div>
				</section>
				<c:if test="${index.count lt page.totalRecords}"><hr/></c:if>
			</c:forEach>
		</c:when>
	</c:choose>
</div>
<br><br>
<%@include file="footer.jsp"%>