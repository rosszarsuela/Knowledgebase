<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/common/eventAddButton.js"/>"></script>
<%-- <script type="text/javascript" src="<c:url value="/js/mis/forms/eventCmsValidation.js"/>"></script> --%>

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
		
		$("#description").keypress(function(event) {
	       if (event.which == 13) {        
	    	   event.preventDefault();
	       }
		});
		
		$(":file").filestyle({buttonName: "btn-primary"});
	});
</script>



	<style>
		
		label {
			text-align: left !important;
		}
		
		div.center{
			margin-right:-50%;
			margin-left: 50%;
		}
		#imgOr {
	    margin: auto;
   		width: 30%;
   		padding-bottom: 3px;
		}
		h1, h2, h3 {
			margin-top:10px;
			margin-bottom:10px;
		}
		
		#header > h3 {
			margin-bottom:.6em !important;
		}
		
		#header {
			padding:1em 0 0 0;
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

<form:form id="event_form" class ="form-horizontal" enctype="multipart/form-data" action="/Oris/web/secured/admin/event/registration" method="post" commandName="eventCommand">
	<div class="container">
		<div class="col-lg-10 col-lg-offset-1">
			<c:choose>
				<c:when test="${not empty eventCommand.id}">
					<div class="page-header">
						<h2>
							<font face="Arial"><b>EVENT</b></font>
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
							<font face="Arial"><b>CREATE EVENT</b></font>
						</h2>
					</div>
				</c:otherwise>
			</c:choose>
			
			<c:if test="${not empty eventCommand.id}">
				<div class="form-group">
			        <div class="row">
			            <div class="col-md-6 col-xs-6 col-sm-6">
							<div class="center">	              
				                <c:choose>
									<c:when test="${empty eventCommand.contentType}">
										<img class="img-responsive" src="<c:url value="/images/no_image_available.jpg"/>" />
									</c:when>
									<c:otherwise>
										<img class="img-responsive" src="<c:url value="${eventCommand.imageContent}"/>" />
									</c:otherwise>
								</c:choose>
							</div>
			            </div>
			        </div>
			    </div>
			</c:if>
	
			<div class="form-group">
		      <div class="col-lg-12">
		      			<label class="control-label">Image</label>
						<input type="file" class="filestyle" id="image" name="image" data-buttonName="btn-primary" />
			  </div>
	    	</div>
	    	
	    	<div class="form-group">
		      <div class="col-lg-12">
	    			<label class="control-label">PDF Brochure</label>
	    			<input type="file" class="filestyle" id="pdf" name="pdf" data-buttonName="btn-primary"/><br>
			  </div>
			</div>
		    
		    <div class="form-group">
				<div class="col-md-12 col-xs-12 col-sm-12">
				      <label class="control-label">Name</label>
				      <form:input path="name" cssClass="form-control"/>
				</div>
	        </div>
			
			<div class="form-group">
		        <div class="col-md-12 col-xs-12 col-sm-12">
	                <label class="control-label">Description</label>
	                <form:textarea path="description" cssClass="form-control" rows="5"/>
		        </div>
	        </div>
			
			<div class="form-group">
		         <div class="col-md-12 col-xs-12 col-sm-12">
	                <label class="control-label">Date From</label>
	                <form:input path="dateFrom" cssClass="form-control" />
		         </div>
			</div>
			
			<div class="form-group">
		        <div class="col-md-12 col-xs-12 col-sm-12">
	                <label class="control-label">Date To</label>
	                <form:input path="dateTo" cssClass="form-control" />
		        </div>	
			</div>
			
			<div class="form-group">
				<div class="col-md-12 col-xs-12 col-sm-12">
					  <label class="control-label">Slot</label>
				      <form:input path="slot" cssClass="form-control" />
				</div>
			</div>
			
		 	<div class="form-group">
		 		<div class="col-md-12 col-xs-12 col-sm-12">
	                <label class="control-label">Brand</label>
	                <form:select path="brand.id" items="${brandsList}" itemLabel="name" itemValue="id" cssClass="form-control"/>
                </div>
            </div>
			
			<div class="form-group">
		        <div class="col-md-12 col-xs-12 col-sm-12">
	                <label class="control-label">Status</label>
	                <form:select path="status" items="${status}" cssClass="form-control" />
	            </div>
			</div>
			
			<div class="col-md-12 col-xs-12 col-sm-12">
		        <div class="page-header">
		          	<h2>SPEAKERS</h2>
		        </div>
			</div>
	       
	       <c:choose>
	       		<c:when test="${not empty eventCommand.speakers}">
		       		<c:forEach items="${eventCommand.speakers}" var="speaker" varStatus="i" >
		       			<div class="form-group speaker">
	       					<form:hidden cssClass="speaker-id" path="speakers[${i.count-1}].id"/>
			       			<div class="col-lg-offset-1 col-lg-3">
			       				<form:input class="form-control speaker-name" path="speakers[${i.count-1}].name" placeholder="Name" />
			       			</div>
			       			<div class="col-lg-3">
			       				<form:input class="form-control speaker-subject" path="speakers[${i.count-1}].subject" placeholder="Subject" />
			       			</div>
			       			<div class="col-lg-3">
			       				<form:input class="form-control speaker-time" path="speakers[${i.count-1}].time" placeholder="Time" />
			       			</div>
			       			<c:choose>
			       				<c:when test="${i.count-1 eq 0}">
			       					<div class="col-lg-2">
						                <button type="button" class="btn btn-default btn-sm btn-block addButton" data-template="textbox">Add</button>
						            </div>
			       				</c:when>
			       				<c:otherwise>
			       					<div class="col-lg-2">
					               	<button type="button" class="btn btn-default btn-sm btn-block removeButton">Remove</button>
					            	 </div>
			       				</c:otherwise>
			       			</c:choose>
		       			</div>
		       		</c:forEach>
	       		</c:when>       	
		       	<c:otherwise>
		       		<div class="form-group speaker">
						
				           <div class="col-lg-offset-1 col-lg-3">
				                <form:input class="form-control speaker-name" path="speakers[0].name" placeholder="Name" />
				             </div>
				             <div class="col-lg-3">
				                <form:input class="form-control speaker-subject" path="speakers[0].subject" placeholder="Subject" />
				             </div>
			                <div class="col-lg-3">
				                <form:input class="form-control speaker-time" path="speakers[0].time" placeholder="Time" />
			            	</div>
			                <div class="col-lg-2">
				                <button type="button" class="btn btn-default btn-sm btn-block addButton" data-template="textbox">Add</button>
				            </div>
		           </div>
		       	</c:otherwise>
	       </c:choose>
	       
			<div class="form-group speaker hide" id="textboxTemplate">			
				<div class="col-lg-offset-1 col-lg-3">
					<input class="form-control speaker-name" type="text" placeholder="Name" />
				</div>
				<div class="col-lg-3">
					<input class="form-control speaker-subject" type="text" placeholder="Subject" />
				</div>
				<div class="col-lg-3">
					<input class="form-control speaker-time" type="text" placeholder="Time" />
				</div>
				<div class="col-lg-2">
					<button type="button" class="btn btn-default btn-sm btn-block removeButton">Remove</button>
				</div>			
			</div>
	
			<div class="form-group">
		        	<div class="col-lg-offset-1 col-lg-3">
		        		<button type="submit" class="btn btn-primary has-spinner"><span class="spinner"><i class="icon-spin icon-refresh"></i></span>Submit</button>
	    			</div>
	    	</div>
		</div>
	</div>
</form:form>
<br><br>