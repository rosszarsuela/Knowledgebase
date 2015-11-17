<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>

<script type="text/javascript" src="<c:url value="/js/mis/forms/productCmsValidation.js"/>"></script>

<script type="text/javascript">
$(document).ready(function() {
	var valid_ext = /(jpg|jpeg|png)$/;
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
	div.center{
			margin-right:-20%;
			margin-left: 80%;
		}
</style>

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

<br/>

<form:form id="product_form" enctype="multipart/form-data" action="/Oris/web/secured/admin/product/registration" method="post" commandName="productCommand">
	<div class="container">
		<div class="col-lg-10 col-lg-offset-1">
			<c:choose>
				<c:when test="${not empty productCommand.id}">
					<div class="page-header">
						<h2>
							<font face="Arial"><b>PRODUCTS</b></font>
						</h2>
					</div>
					<form:hidden path="id" />
					<form:hidden path="picture" />
					<form:hidden path="manual" />
					<form:hidden path="contentType" />
					<form:hidden path="createdDate" />
					<form:hidden path="createdBy.username" />
				</c:when>
				<c:otherwise>
					<div class="page-header">
					<h2>
						<font face="Arial"><b>PRODUCTS</b></font>
					</h2>
					</div>
				</c:otherwise>
			</c:choose>
			
			<c:if test="${not empty productCommand.id}">	
				<div class="form-group">
			        <div class="row">
			            <div class="col-md-6 col-xs-6 col-sm-6">
			                <div class="center">
			                <c:choose>
								<c:when test="${empty productCommand.contentType}">
									<img class="img-responsive" src="<c:url value="/images/no_image_available.jpg"/>" />
								</c:when>
								<c:otherwise>
									<img class="img-responsive" src="<c:out value="${productCommand.imageContent}"/>" />
								</c:otherwise>
							</c:choose>
							</div>
			            </div>
			        </div>
			    </div>
			</c:if>
			    
		    <div class="form-group control-label">
	    			<label for="name">Image</label> 
	    			<input type="file" class="filestyle" id="image" name="image" data-buttonName="btn-primary"/><br>
			</div>
			
			<div class="form-group control-label">
	    			<label for="name">Manual</label> 
	    			<input type="file" class="filestyle" id="pdf" name="pdf" data-buttonName="btn-primary"/><br>
			</div>
	        
		    <div class="form-group control-label">
	            	<label class="control-label">Name</label>
	      			<form:input path="name" cssClass="form-control"/>
            </div>
	      
			
			<div class="form-group control-label">
			        <label class="control-label">Description</label>
			        <form:textarea path="description" cssClass="form-control" rows="5"/>
			</div>
			
		    <div class="form-group control-label">
	                <label class="control-label">Solution's Category</label>
	                <form:select path="category.id" items="${categoryList}" itemLabel="name" itemValue="id" cssClass="form-control"/>
            </div>
	                
	       	<div class="form-group control-label">
	                <label class="control-label">Brand</label>
	                <form:select path="brand.id" items="${brandsList}" itemLabel="name" itemValue="id" cssClass="form-control"/>
            </div>
	                
			<div class="form-group control-label">
		            <label class="control-label">Status</label>
		            <form:select path="status" items="${status}" cssClass="form-control"/>
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