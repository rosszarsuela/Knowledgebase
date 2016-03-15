<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>
<script type="text/javascript" src="<c:url value="/js/mis/forms/brandsCmsValidation.js"/>"></script>

<script type="text/javascript">
$(document).ready(function() {
	var valid_ext = /(jpg|jpeg|png|)$/;
	var valid_ext_pdf = /(pdf)$/;

	$('#image').change(function() {
		var file = $(this)[0].files[0].name
				.split('.').pop();

		if (file) {
			if (!valid_ext.test(file)) {
				alert('Invalid file format. Please upload file extension .png/.jpg/.jpeg');
				$(this).val('');
			}
		}
	});
	
	$('#bimage').change(function() {
		var file = $(this)[0].files[0].name
				.split('.').pop();

		if (file) {
			if (!valid_ext.test(file)) {
				alert('Invalid file format. Please upload file extension .png/.jpg/.jpeg');
				$(this).val('');
			}
		}
	});
	
	$('#pdf').change(function() {
		var file = $(this)[0].files[0].name
				.split('.').pop();

		if (file) {
			if (!valid_ext_pdf.test(file)) {
				alert('Invalid file format. Please upload file extension .pdf');
				$(this).val('');
			}
		}
	});
	

	$('#pdfimage').change(function() {
		var file = $(this)[0].files[0].name
				.split('.').pop();

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
	
	/* $("#description").keypress(function(event) {
       if (event.which == 13) {        
    	   event.preventDefault();
       }
	}); */
	
	$(":file").filestyle({buttonName: "btn-primary"});
});
</script>
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

<form:form  id="brand_form" enctype="multipart/form-data" action="/Oris/web/secured/admin/brand/registration" method="post" commandName="brandCommand">
	<div class="container">
		<div class="col-lg-10 col-lg-offset-1">
			<c:choose>
				<c:when test="${not empty brandCommand.id}">
					<div class="page-header">
						<h2>
							<font face="Arial"><b>BRANDS</b></font>
						</h2>
					</div>
					<form:hidden path="id" />
					<form:hidden path="picture" />
					<form:hidden path="bpicture"/>
					<form:hidden path="manual"/>
					<form:hidden path="pimage"/>
					<form:hidden path="contentType" />
					<form:hidden path="createdDate" />
					<form:hidden path="createdBy.username" />
				</c:when>
				<c:otherwise> 
					<div class="page-header">
						<h2>
							<font face="Arial"><b>CREATE BRAND</b></font>
						</h2>
					</div>
				</c:otherwise>
			</c:choose>
			
			<c:if test="${not empty brandCommand.id}">	
				<div class="form-group">
			        <div class="row">
			            <div class="col-md-6 col-xs-6 col-sm-6">
			                <div class="center">
			                <c:choose>
								<c:when test="${empty brandCommand.contentType}">
									<img class="img-responsive" src="<c:url value="/images/no_image_available.jpg"/>" />
								</c:when>
								<c:otherwise>
									<img class="img-responsive" src="<c:out value="${brandCommand.imageContent}"/>" />
								</c:otherwise>
							</c:choose>
							</div>
			            </div>
			        </div>
			    </div>
			</c:if>
			
			<c:if test="${not empty brandCommand.id}">	
				<div class="form-group">
			        <div class="row">
			            <div class="col-md-6 col-xs-6 col-sm-6">
			                <div class="center">
			                <c:choose>
								<c:when test="${empty brandCommand.contentType}">
									<img class="img-responsive" src="<c:url value="/images/no_image_available.jpg"/>" />
								</c:when>
								<c:otherwise>
									<img class="img-responsive" src="<c:out value="${brandCommand.brandContent}"/>" />
								</c:otherwise>
							</c:choose>
							</div>
			            </div>
			        </div>
			    </div>
			</c:if>
			    
		    <div class="form-group control-label">
	    			<label for="name">LOGO</label> 
	    			<input type="file" class="filestyle" id="image" name="image" data-buttonName="btn-primary"/><br>
			</div>
			
			<div class="form-group control-label">
	    			<label for="name">BRAND PICTURE</label> 
	    			<input type="file" class="filestyle" id="bimage" name="bimage" data-buttonName="btn-primary"/><br>
			</div>
			
			<div class="form-group control-label">
	    			<label for="name">BRAND MANUAL</label> 
	    			<input type="file" class="filestyle" id="pdf" name="pdf" data-buttonName="btn-primary"/><br>
			</div>
			
			<div class="form-group control-label">
	    			<label for="name">PDF IMAGE</label> 
	    			<input type="file" class="filestyle" id="pdfimage" name="pdfimage" data-buttonName="btn-primary"/><br>
			</div>
			
			<div class="form-group control-label">
                <label class="control-label">Code</label>
                <form:input path="code" cssClass="form-control"/>
	       	</div>
			
			
			<div class="form-group control-label">
                <label class="control-label">Name</label>
                <form:input path="name" cssClass="form-control"/>
           </div>
			
			
			<div class="form-group control-label">
                <label class="control-label">Description</label>
                <form:textarea path="description" cssClass="form-control"  rows="5"></form:textarea>
            </div>
            
            <div class="form-group control-label">
                <label class="control-label">Manual Name</label>
                <form:input path="manualName" cssClass="form-control"/>
	       	</div>
	       
	       <div class="form-group control-label">
                <label class="control-label">Website</label>
                <form:input path="website" cssClass="form-control"/>
	       	</div>
			
	    	<div class="form-group">
			 	<div class="control-label">
	   				<label for="space"></label>
	        		<button type="submit" class="btn btn-primary btn-md">Submit</button>
	   			</div>
	   		</div>
	   	</div>
  	</div>
</form:form>
<br><br><br>