<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>
<%-- <script type="text/javascript" src="<c:url value="/js/mis/forms/brandsCmsValidation.js"/>"></script> --%>
<style>
	#header {
		padding: 0.9em 0 0 0 !important;	
	}
	#header >h3{
		margin-bottom: -0.9em !important;
		margin-left: 8em !important;
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
				<img class="img-responsive" id ="imgOr" src="<c:url value="/images/oris_logo.png"/>" />
			</a>
			</h3><br>
			<%@include file="../mis/misNav.jsp"%>
		</div>
</div>

<form:form  id="video_form" action="/Oris/web/secured/admin/videos/registration" method="post" commandName="videoCommand">
	<div class="container">
		<div class="col-lg-10 col-lg-offset-1">
			<c:choose>
				<c:when test="${not empty videoCommand.id}">
					<div class="page-header">
						<h2>
							<font face="Arial"><b>UPDATE VIDEOS</b></font>
						</h2>
					</div>
					<form:hidden path="id" />
					<form:hidden path="createdDate" />
					<form:hidden path="createdBy.username" />
				</c:when>
				<c:otherwise> 
					<div class="page-header">
						<h2>
							<font face="Arial"><b>ADD VIDEO LINKS</b></font>
						</h2>
					</div>
				</c:otherwise>
			</c:choose>
			
			<div class="form-group control-label">
                <label class="control-label">Video Link 1</label>
                <form:input path="link1" cssClass="form-control"/>
	       	</div>
			
			<div class="form-group control-label">
                <label class="control-label">Video Title 1</label>
                <form:input path="title1" cssClass="form-control"/>
           </div>
			
			<div class="form-group control-label">
                <label class="control-label">Description of Video Link 1</label>
                <form:textarea path="description1" cssClass="form-control"  rows="5"></form:textarea>
            </div>
			
			<div class="form-group control-label">
                <label class="control-label">Video Link 2</label>
                <form:input path="link2" cssClass="form-control"/>
	       	</div>
			
			<div class="form-group control-label">
                <label class="control-label">Video Title 2</label>
                <form:input path="title2" cssClass="form-control"/>
           </div>
			
			<div class="form-group control-label">
                <label class="control-label">Description of Video Link 2</label>
                <form:textarea path="description2" cssClass="form-control"  rows="5"></form:textarea>
            </div>
			
			<div class="form-group control-label">
                <label class="control-label">Video Link 3</label>
                <form:input path="link3" cssClass="form-control"/>
	       	</div>
			
			<div class="form-group control-label">
                <label class="control-label">Video Title 3</label>
                <form:input path="title3" cssClass="form-control"/>
           </div>
			
			<div class="form-group control-label">
                <label class="control-label">Description of Video Link 3</label>
                <form:textarea path="description3" cssClass="form-control"  rows="5"></form:textarea>
            </div>
			
			<div class="form-group">
			 	<div class="control-label">
	   				<button type="submit" class="btn btn-primary btn-md" value="SAVE">Save</button>
	   			</div>
	   		</div>
	   	</div>
  	</div>
</form:form>
<br><br>