<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>
<script type="text/javascript" src="<c:url value="/js/mis/forms/userCmsValidation.js"/>"></script>
<script type="text/javascript" src="<c:url value="/dwr/interface/misDWRService.js"/>"></script>

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

<form:form  id="user_form" action="/Oris/web/secured/admin/user/registration" method="post" commandName="userCommand" >
	<div class="container">
  		<div class="col-lg-10 col-lg-offset-1">
			<div class="page-header">
				<h2>
				<font face="Arial"><b>CREATE NEW USER</b></font>
				</h2>
			</div>
			
				<div class="form-group control-label">
			        <label class="control-label">First Name</label>
		            <form:input path="firstName" cssClass="form-control"/>
	         	</div>
			
			<div class="form-group control-label">
					<label class="control-label">Middle Name</label>
					<form:input path="middleName" cssClass="form-control"/>
			</div>
			
				
			<div class="form-group control-label">
				<label class="control-label">Last Name</label>
				<form:input path="lastName" cssClass="form-control"/>
			</div>
			 
		    <div class="form-group control-label">
				<label class="control-label">Email</label>
				<form:input path="email" cssClass="form-control"/>
			</div>
		    
		    <div class="form-group control-label">
		    	<c:choose>
					<c:when test="${not empty userCommand.username}">
						<label for="username">Username</label>
		      			<form:input path="username" cssClass="form-control" readonly="true"/>
					</c:when>
					<c:otherwise>
						<label for="username">Username</label>
						<form:input path="username" cssClass="form-control"/>
					</c:otherwise>
				</c:choose>
			</div>
			
			 <div class="form-group control-label">
				<label for="password">Password</label>
	      		<form:password path="password" cssClass="form-control"/>
		    </div>
		    
		     <div class="form-group control-label">
		      		<label for="confirm-password">Confirm Password</label>
		      		<form:password path="confirmPassword" cssClass="form-control"/>
	    	</div>
		   	
		   	 <div class="form-group control-label">
		      		<label for="role">Role</label>
		      		<form:select path="role.id" cssClass="form-control" items="${rolesList}" itemValue="id" itemLabel="description"/>
		    </div>
		    
		     <div class="form-group control-label">
		      		<label for="role">Status</label>
		      		<form:select path="status" cssClass="form-control" items="${userStatus}"/><br>
		  	</div>
		    
		    <div class="form-group">
				 <div class="control-label">
		    		<label for="role"></label>
		    		<button class="btn btn-primary btn-md" type="submit" value="SAVE">Save</button>
		    	</div>
		    </div>
		</div>
	</div>
</form:form>
<br><br><br><br>