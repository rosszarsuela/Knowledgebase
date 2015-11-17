<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/dwr/interface/productDWRService.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/mis/forms/products.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/common/bootstrap-tabcollapse.js"/>"></script>

<style>
	img {max-width:500%}
</style>

<div id="page-wrapper">
		<!-- Header -->
		<div id="header">
			<!-- Logo -->
			<h3>
				<a href="<c:url value="/web/home"/>" id="logo">
				<font face="Arial"><b>ORIS Oral Implant Solutions Inc</b></font></a>
			</h3>
			<%@include file="homeNav.jsp"%>
		</div>
</div>

<form:form id="solution_form" action="/Oris/web/view/solutions" method="get" commandName="solutionsCommand">
	<section class="wrapper solution">
		<div class="container">
			<div class="page-header">
				<h3>${solution.name}</h3>
			</div>
			
			<div class="row 200%">
				<div class="3u 10u(narrower)">
					<div id="sidebar">
						<!-- Sidebar -->
						<section>
							<!-- <h4>SOLUTIONS CATEGORY</h4> -->
							<form:select path="categoryId" items="${solution.solutions}" cssClass="form-control" itemLabel="name" itemValue="id"/>
						</section>
					</div>
				</div>
				
				<div class="9u 10u(narrower) important(narrower)">
					<div class="content grid-product">
						<!-- Content -->
						<article>
							<c:if test="${not empty products}">
								<div class="row">
									<c:forEach var="obj" items="${products}">									
										<c:choose>
											<c:when test="${empty obj.contentType}">
												<div class="col-md-3 portfolio-item">
													<a href="#" data-toggle="tooltip" title="${obj.name}">
														<input type="hidden" class="product-id" value="${obj.id}" />
														<img class="img-responsive" src="<c:url value="/images/no_image_available.jpg"/>" />
													</a>
												</div>
											</c:when>
											<c:otherwise>
												<div class="col-md-3 portfolio-item">
													<a href="#" data-toggle="tooltip" title="${obj.name}">
														<input type="hidden" class="product-id" value="${obj.id}" />
														<img class="img-responsive" src="<c:out value="${obj.imageContent}"/>" />
													</a>
												</div>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</div>					
							</c:if>
						</article>
					</div>
				
					<div class="content product-detail" style="display: none;">
						<article>
						
							<div class="page-header">
								<h3 id="product-name"></h3>
							</div>
															
					        <div class="row">
					            <div class="col-xs-2">
					                <img id="product-image" src="">
					            </div>
					        </div>
					        
							<br>
						 		<ul id="myTab" class="nav nav-tabs">
								  <li class="active"><a href="#overview" data-toggle="tab">Overview</a></li>
								  <li><a href="#description" data-toggle="tab">Description</a></li>
								  <li><a href="#features" data-toggle="tab">Features</a></li>
								  <li><a href="#specs" data-toggle="tab">Specs</a></li>
								  <li><a href="#brochure" data-toggle="tab">Brochure</a></li>
								</ul>
								
								<div id="myTabContent" class="tab-content">
								    <div class="tab-pane fade in active" id="overview">
								       	<h3 id="product-nameOverview"></h3>
								    </div>
								    
								    <div class="tab-pane fade" id="description">
								    	<br>
								    	<p id="product-description"></p>
								    </div>
								    
								     <div class="tab-pane fade" id="features">
								    	<h3>${solution.name}</h3>
								        <p>Food truck fixie locavore, accus</p>
								    </div>
								    
								     <div class="tab-pane fade" id="specs">
								    	<h3>${solution.name}</h3>
								        <p>Food truck fixie locavore, accus</p>
								    </div>
								  
								  	 <div class="tab-pane fade" id="brochure">
								    	<p>
								    		<a href="<c:url value="/Oris/web/view/downloadPdf">
					   							<c:param name="id" value=""/>
					   						</c:url>" id="download-pdf" target="_blank"><img src="<c:url value="/images/icon/pdf.png"/>" height="50px" width="50px">
										</a>
								    	</p>
								    </div>
								</div>
						</article>
					</div>
			   </div>
			</div>
		</div> 
	</section>
</form:form>
<br><br>
<%@include file="footer.jsp"%>