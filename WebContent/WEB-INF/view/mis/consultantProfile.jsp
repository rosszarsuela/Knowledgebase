<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>

<script type="text/javascript" src="<c:url value="/js/mis/forms/consultantCmsValidation.js"/>"></script>

<script type="text/javascript">
	$(document).ready(function() {
		var valid_ext = /(jpg|jpeg|png)$/;

		$('#image').change(function() {
			var file = $(this)[0].files[0].name.split('.').pop();

			if (file) {
				if (!valid_ext.test(file)) {
					alert('Invalid file format. Please upload file extension .png/.jpg/.jpeg');
					$(this).val('');
				}
			}
		});

		function checkFileSize() {
			var size = 0;

			$('.file').each(function(index) {
				if ($(this)[0].files[0]) {
					size += $(this)[0].files[0].size;
				}
			});
			return size;
		}
		
		/* $("#address").keypress(function(event) {
	       if (event.which == 13) {        
	    	   event.preventDefault();
	       }
		}); */
	});
</script>

<style>
	div.center{
			margin-right:-20%;
			margin-left: 80%;
		}
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
			
<form:form id="consultant_form" enctype="multipart/form-data" action="/Oris/web/secured/admin/consultant/registration" method="post" commandName="consultantCommand">
	<div class="container">
		<div class="col-lg-10 col-lg-offset-1">
			<c:choose>
				<c:when test="${not empty consultantCommand.id}">
					<div class="page-header">
						<h2>
							<font face="Arial"><b>CONSULTANT PROFILE</b></font>
						</h2>
					</div>
					<form:hidden path="id" />
					<form:hidden path="picture" />
					<form:hidden path="contentType" />
					<form:hidden path="createdDate" />
					<form:hidden path="createdBy.username" />
				</c:when>
				<c:otherwise>
					<div class="page-header">
					<h2>
						<font face="Arial"><b>REGISTER CONSULTANT PROFILE</b></font>
					</h2>
					</div>
				</c:otherwise>
			</c:choose>
			
			<c:if test="${not empty consultantCommand.id}">
				<div class="form-group">
			        <div class="row">
			             <div class="col-md-6 col-xs-6 col-sm-6">
			                <div class="center">
			                <c:choose>
								<c:when test="${empty consultantCommand.contentType}">
									<img class="img-responsive" src="<c:url value="/images/no_image_available.jpg"/>" />
								</c:when>
								<c:otherwise>
									<img class="img-responsive" src="<c:url value="${consultantCommand.imageContent}"/>" />
								</c:otherwise>
							</c:choose>
							</div>
			            </div>
			        </div>
			    </div>
			</c:if>
			
		<div class="form-group control-label">
					<label class="control-label">Image</label>
		    			<input type="file" class="filestyle" id="image" name="image" data-buttonName="btn-primary" />
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
					<label class="control-label">Profession</label>
	      			<form:input path="profession" cssClass="form-control"></form:input>
			</div>
		            
			<div class="form-group control-label">
					<label class="control-label">Schools</label>
	      			<form:textarea path="address" cssClass="form-control" rows="5"></form:textarea>
			</div>
			
    	   <div class="form-group control-label">
					<label class="control-label">Contact No.</label>
					<form:input path="contactNo" cssClass="form-control" maxlength="11"/>
			</div>
	    	  	
    	   <div class="form-group control-label">
					<label class="control-label">Email</label>
					<form:input path="email" cssClass="form-control"/>
			</div>
	    	
			<div class="form-group control-label">
		      		<label class="control-label">Status</label>
		      		<form:select path="status" items="${status}" cssClass="form-control" /><br>
		   </div>
			
		   	      	
	    	<div class="form-group">
				 <div class="control-label">
					<button type="submit" class="btn btn-primary btn-md">Submit</button>
				</div>
	   		</div>
		</div>
	</div>
</form:form>
<br><br><br>