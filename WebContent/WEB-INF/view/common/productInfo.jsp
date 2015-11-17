<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>

<div id="page-wrapper">
	<!-- Header -->
	<div id="header">
	<!-- Logo -->
		<h1><a href="<c:url value="/web/home"/>" id="logo">Company Name</a></h1>		
		<%@include file="homeNav.jsp"%>
	</div>
</div>

<br/>

<form:form id="product_form" enctype="multipart/form-data" action="/Oris/web/view/product/info" method="get" commandName="productCommand">
	<div class="container">		
		<div class="form-group">
	        <div class="row">
	            <div class="col-xs-6">
	                <img class="img-responsive" src="<c:out value="${productCommand.imageContent}"/>" />
	            </div>
	        </div>
	    </div>
	    
	    <div class="form-group">
	        <div class="row">
	            <div class="col-xs-12">
	            	<c:out value="${productCommand.name}"/>
	            </div>
			</div>
		</div>
		
		<div class="form-group">
			<div class="row">
	            <div class="col-xs-12">
			        <c:out value="${productCommand.description}"/>
				</div>
			</div>
	    </div>
    </div>
</form:form>
<br><br>