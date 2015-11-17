<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>

<script type="text/javascript" src="<c:url value="/js/mis/forms/solutionCmsValidation.js"/>"></script>

<div id="page-wrapper">
		<!-- Header -->
		<div id="header">
			<!-- Logo -->
			<h3>
				<a href="<c:url value="/web/home"/>" id="logo">
				<font face="Arial"><b>ORIS Oral Implant Solutions Inc</b></font></a>
			</h3><br>
			<%@include file="../mis/misNav.jsp"%>
		</div>
</div>

<form:form  id="solution_form" action="/Oris/web/secured/admin/solution/category/registration" method="post" commandName="solutionCommand">
	<div class="container">
	<div class="col-lg-10 col-lg-offset-1">
		<c:choose>
			<c:when test="${not empty solutionCommand.id}">
				<div class="page-header">
					<h2>
						<font face="Arial"><b>SOLUTION'S CATEGORY</b></font>
					</h2>
					</div>
				<form:hidden path="id" />
				<form:hidden path="createdDate" />
				<form:hidden path="createdBy.username" />
			</c:when>
			<c:otherwise>
				<div class="page-header">
				<h2>
				<font face="Arial"><b>CREATE SOLUTION'S CATEGORY</b></font>
				</h2>
				</div>
			</c:otherwise>
		</c:choose>
    	
   		<div class="form-group control-label">
      		<label for="solution">Solution</label>
      		<form:select path="solution.id" items="${solutionsList}" itemLabel="name" itemValue="id" cssClass="form-control"/>
    		</div>
   		
    	<div class="form-group control-label">
                <label class="control-label">Name</label>
                <form:input path="name" cssClass="form-control"/>
           
		</div>
    	
   		 <div class="form-group control-label">
	                <label class="control-label">Description</label>
	                <form:textarea path="description" cssClass="form-control" rows="5"/>
	        </div>
           	
		<div class="form-group">
			 <div class="control-label">
    		<label for="space"></label>
    		<button class="btn btn-primary btn-md" type="submit" value="SAVE">SAVE</button>
    		</div>
   		 </div>
	</div>
</div>
</form:form>
<br><br><br>