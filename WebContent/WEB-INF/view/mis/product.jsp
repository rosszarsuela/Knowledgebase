<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>
<script type="text/javascript" src="<c:url value="/js/mis/forms/productCmsValidation.js"/>"></script>
<script type="text/javascript" src="<c:url value="/dwr/interface/productDWRService.js"/>"></script>

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

	/* $("#description").keypress(function(event) {
       if (event.which == 13) {        
    	   event.preventDefault();
       }
	}); */


$(document).on('change', '.productImage', function() {
	var valid_ext_img = /(jpg|jpeg|png|JPEG|PNG|JPG)$/;
	var file = $(this)[0].files[0].name
	.split('.').pop();
	if(file) {
		if(!valid_ext_img.test(file)) {
			$('#modal-error-message').text('Invalid file format. Please select file with extension .png/.jpg/.jpeg.');
			$('#errorModal').modal('show');
			$(this).parent().parent().remove();
			$('#images-table').find('tbody').append(
				'<tr>' +	
				'<td><input type="text" class="imgDesc form-control" data-buttonName="btn-primary"/></td>' +
				'<td>' +
					'<input type="hidden" class="img-name">' +
					'<input type="file" class="filestyle productImage" data-buttonname="btn-primary" tabindex="-1" style="display: none; position: absolute; clip: rect (0px 0px 0px 0px);">' +
					'<div class="bootstrap-filestyle input-group">' +
						'<input type="text" class="fake-filename form-control" disabled>' +
						'<span class="group-span-filestyle input-group-btn" tabindex="0">' +
							'<label class="image-label btn btn-primary">' +
								'<span class="glyphicon glyphicon-folder-open">' +
								'</span>' +
								'<span class="buttonText">Choose file</span>' +
							'</label>' +
						'</span>' +
					'</div>' +
				'</td>' +
				'<td>' +
					'<button type="button" class="btn btn-danger dlt-image">X</button>' +
				'</td>' +
				'</tr>'	
			);
			initImages();
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
	
	$(":file").filestyle({buttonName: "btn-primary"});
});

</script>

<style>
	div.center{
			margin-right:-20%;
			margin-left: 80%;
		}
		
	#pro-img {
		padding-top: 30px;
	}
	
	#pan {
		color: white;
		background-color: #00B7D2;
	}
	
	table th {
    text-align: center;
    color: white;
    background-color: #00B7D2;
	}
	
	#imgOr {
	    margin: auto;
   		width: 30%;
   		padding-bottom: 9px;
		}
		
	#header {
		padding: 0.9em 0 0 0 !important;	
	}
	#header >h3 {
		margin-bottom: -0.9em !important;
		margin-left: 8em !important;
	}
	
	#pan {
	color: white;
	background-image: #179EB1;
	background-color: #179EB1;
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
	    			<label for="name">Main Image</label> 
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
			        <label class="control-label">Remarks</label>
			        <form:input path="remarks" cssClass="form-control"/>
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
		    
		    
		  	<div class="col-md-12 col-xs-12 col-sm-12">
		        <div class="page-header">
		          	<h2>TECHNICAL SPECIFICATIONS</h2>
		        </div>
		
	       
		       <c:choose>
		       		<c:when test="${not empty productCommand.specs}">
			       		<c:forEach items="${productCommand.specs}" var="specifications" varStatus="i" >
			       			<div class="form-group specifications">
		       					<form:hidden cssClass="specification-id" path="specs[${i.count-1}].id"/>
				       			<div class="col-lg-2">
				       				<form:input class="form-control specs-specification" path="specs[${i.count-1}].specification" placeholder="Specifications" />
				       			</div>
				       			<div class="col-lg-3">
				       				<form:input class="form-control specs-spec1" path="specs[${i.count-1}].spec1" placeholder="Description 1" />
				       			</div>
				       			<div class="col-lg-3">
				       				<form:input class="form-control specs-spec2" path="specs[${i.count-1}].spec2" placeholder="Description 2" />
				       			</div>
				       			<div class="col-lg-3">
				       				<form:input class="form-control specs-spec3" path="specs[${i.count-1}].spec3" placeholder="Description 3" />
				       			</div>
				       			<c:choose>
				       				<c:when test="${i.count-1 eq 0}">
				       					<div class="col-lg-1">
							                <button type="button" class="btn btn-primary btn-sm btn-block addButton" data-template="textbox">Add</button>
							            </div>
				       				</c:when>
				       				<c:otherwise>
				       					<div class="col-lg-1">
						               		<button type="button" class="btn btn-danger btn-sm btn-block removeButton">X</button>
						            	 </div>
				       				</c:otherwise>
				       			</c:choose>
			       			</div>
			       		</c:forEach>
		       		</c:when>       	
			       	<c:otherwise>
			       		<div class="form-group specifications">
							   	 <div class="col-lg-2">
					                <form:input class="form-control specs-specification" path="specs[0].specification" placeholder="Specifications" />
					             </div>
					             <div class="col-lg-3">
					                <form:input class="form-control specs-spec1" path="specs[0].spec1" placeholder="Description 1" />
					             </div>
				                <div class="col-lg-3">
					                <form:input class="form-control specs-spec2" path="specs[0].spec2" placeholder="Description 2" />
				            	</div>
				            	<div class="col-lg-3">
					                <form:input class="form-control specs-spec3" path="specs[0].spec3" placeholder="Description 3" />
				            	</div>
				                <div class="col-lg-1">
					                <button type="button" class="btn btn-primary btn-sm btn-block addButton" data-template="textbox">Add</button>
					            </div>
			           </div>
			       	</c:otherwise>
		       </c:choose>
	       
				<div class="form-group specifications hide" id="textboxTemplate">			
					<div class="col-lg-2">
						<input class="form-control specs-specification" type="text" placeholder="Specification" />
					</div>
					<div class="col-lg-3">
						<input class="form-control specs-spec1" type="text" placeholder="Description 1" />
					</div>
					<div class="col-lg-3">
						<input class="form-control specs-spec2" type="text" placeholder="Description 2" />
					</div>
					<div class="col-lg-3">
						<input class="form-control specs-spec3" type="text" placeholder="Description 3" />
					</div>
					<div class="col-lg-1">
						<button type="button" class="btn btn-danger btn-sm btn-block removeButton">X</button>
					</div>
				</div>
			</div>
		
			<div class="col-md-12 col-xs-12 col-sm-12" id="pro-img">
	   			<div class="form-group speaker">
			           <div class="col-lg-12">
			               <div class="panel panel-default">
			                   <div class="panel-heading" id="pan">
			                     	Product Images
			                   </div>
			                   <div class="panel-body">           
			                   
						    	<div class="form-group">
									<div class="col-md-10"></div>	
									<div class="col-md-2">
										<button type="button" class="btn btn-primary add-image">Add Image</button>	
									</div>		
									<div class="col-md-12">					      			
										<div class="table-responsive">
							        		<table id="images-table" class="table table-striped table-bordered table-condensed" style="margin-top: 1px;">
							        			<thead>
							        				<tr>
								        				<th class="col-lg-6">Name/Description</th>
								        				<th class="col-lg-4">Upload File</th>									        				
								        				<th class="col-lg-2">Action</th>
							        				</tr>
							        			</thead>
							        			<tbody>
							        				<c:choose>
														<c:when test="${not empty productCommand.id and not empty productCommand.productImages}">
															<c:forEach items="${productCommand.productImages}" var="obj" varStatus="index">
								                                    <tr>
									                                  	<td>
																			<form:input path="productImages[${index.count-1}].imgDesc" />
																			<form:hidden path="productImages[${index.count-1}].contentType" />
																		</td>
											        					<td>
											        						<form:hidden cssClass="img-name img1" path="productImages[${index.count-1}].fileName" />
											        						<input type="file" id="productImages" name="productImages[${index.count-1}].pImg" class="filestyle productImages" data-buttonName="btn-primary"/>
										        						</td>
											        					<td>
											        						<form:hidden path="productImages[${index.count-1}].id" />
											        						<button type="button" class="btn btn-primary view-image">View</button>
																			<button type="button" class="btn btn-danger dlt-image">Delete</button>
																		</td>
											        				</tr>
															</c:forEach>
														</c:when>
														<c:otherwise>
															
														</c:otherwise>
													</c:choose>
							        			</tbody>
							        		</table>
						        		</div>
						        	</div>
					      		</div>
				    		</div>
			    		</div>
			   		</div>
		   		</div>
		    		
    			<div class="form-group">
		        	<div class="col-lg-2">
		        		<br>
		        		<button type="submit" class="btn btn-primary btn-sm btn-block"><span><i class="icon-spin icon-refresh"></i></span>Submit</button>
	    			</div>
	    		</div>
			</div>	
	 	</div>
 	</div>
</form:form>
<br><br><br>