<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>
<script type="text/javascript">

</script>

<div id="page-wrapper">
	<!-- Header -->
	<div id="header">
	<!-- Logo -->
		<h1><a href="index.html" id="logo">Company Name</a></h1>		
		<%@include file="../mis/misNav.jsp"%>
	</div>
</div>

<br/>

<form:form id="eventRegistration_form" enctype="multipart/form-data" action="/web/view/event/info/registration" method="post" commandName="registerCommand">
	<div class="container">
		
				<h1>REGISTRATION</h1>
			
	   <div class="form-group">
	        <div class="row">
	            <div class="center">
	                <label class="control-label">First Name</label>
	                <form:input path="lastName" cssClass="form-control"/>
	            </div>
			</div>
		</div>

		<div class="form-group">
	        <div class="row">
	            <div class="col-xs-12">
	                <label class="control-label">Middle Name</label>
	                <form:input path="middleName" cssClass="form-control"/>
	            </div>
			</div>
		</div>
	            
		<div class="form-group">
	        <div class="row">
	            <div class="col-xs-12">
	                <label class="control-label">Last Name</label>
	                <form:input path="firstName" cssClass="form-control"/>
	            </div>
	        </div>
	    </div>
    
    	<div class="form-group">
	        <div class="row">
	        	<div class="col-xs-6">
	      			<label class="control-label">Contact No.</label>
	      			<form:input path="contactNo" cssClass="form-control" required="" />
	      		</div>
	      	</div>
		</div>	      	

		<div class="form-group">
	        <div class="row">
	      		<div class="col-xs-12">
	      			<label class="control-label">Email</label>
      				<form:input path="email" cssClass="form-control"/>
	      		</div>
	      	</div>
		</div>
	      		   	
    	<div class="form-group">
	        <div class="row">
	        	<div class="col-xs-12">
	        		<button type="submit" class="btn btn-primary">Submit</button>
    			</div>
    		</div>
    	</div>
    </div>
</form:form>