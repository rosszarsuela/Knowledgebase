<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>

<script type="text/javascript" src="<c:url value="/js/mis/forms/customerCmsValidation.js"/>"></script>

<style>
	#imgOr {
	    margin: auto;
   		width: 30%;
   		padding-bottom: 9px;
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

<form:form  id="customer_form" action="/Oris/web/secured/admin/customer/registration" method="post" commandName="customerCommand">
	<div class="container">
		<div class="col-lg-10 col-lg-offset-1">
			<c:choose>
				<c:when test="${not empty customerCommand.id}">
					<div class="page-header">
					<h2>
						<font face="Arial"><b>CUSTOMER PROFILE</b></font>
					</h2>
					</div>
					<form:hidden path="id" />
					<form:hidden path="createdDate" />
					<form:hidden path="createdBy.username" />
				</c:when>
				<c:otherwise>
					<div class="page-header">
						<h2>
						<font face="Arial"><b>REGISTER CUSTOMER PROFILE</b></font>
						</h2>
					</div>
				</c:otherwise>
			</c:choose>
			
			
			<div class="form-group control-label">
	      		<label for="name">Name</label>
				<form:input path="name" cssClass="form-control"/>
      		</div>
	    	
	    	<div class="form-group control-label">
      			<label class="control-label">Address</label>
      			<form:textarea path="address" cssClass="form-control" rows="5"></form:textarea>
	      	</div>
	    	
	    	<div class="form-group control-label">
		      			<label class="control-label">Contact No</label>
		      			<form:input path="contactNo" cssClass="form-control" required="" />
      		</div>
	      	
	      	
	      	<div class="form-group control-label">
		      			<label class="control-label">Email</label>
	      				<form:input path="email" cssClass="form-control"/>
      		</div>
	      	
	    	<div class="form-group control-label">
		      			<label class="control-label">Status</label>
	      				<form:select path="status" items="${status}" cssClass="form-control"/><br>
	      	</div>
	    	
	    	<div class="form-group">
				 <div class="control-label">
					<button type="submit" class="btn btn-primary three columns btn-md" value="SAVE">SAVE</button>
				</div>
	   		</div>
		</div>
	</div>
</form:form>
<br><br><br>