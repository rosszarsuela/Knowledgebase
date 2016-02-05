<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/productNav/styles.css"/>">
<script src="<c:url value="/js/productNav/script.js"/>"></script>

<style>
	div.imgBrand {
    margin: 5px;
    padding: 5px;
    border: 2px solid #0000ff;
    height: auto;
    width: auto;
    text-align: center;
}

	#imgOr {
	    margin: auto;
   		width: 30%;
   		padding-bottom: 9px;
		}
		
		span.row-label {
		font-size: 17px;
		}
		

</style>

<div id="page-wrapper">
		<!-- Header -->
		<div id="header">
			<!-- Logo -->
			<h3>
				<a href="<c:url value="/web/home"/>" id="logo">
				<img class="img-responsive" id ="imgOr" src="<c:url value="/images/oris_logo.png"/>" /></a>
			</h3>
			<%@include file="homeNav.jsp"%>
		</div>
</div>

<div class="container col-lg-5">	
	<section class="container">
		<div class="container">
			<div class="row">
				<div class="rowMenu">
					<div id="sidebar">
						<section>
							<div id='cssmenu'>
								<ul>
									<c:forEach items="${solutionList}" var="solutionName" varStatus="index">				
										<li class='has-sub'><a href='#'><span>${solutionName}</span></a>
											<ul>
												<c:forEach items="${brandList}" var="obj" varStatus="index">
													<c:if test="${solutionName eq obj.solutionName}">
														<li>
															<a href="<c:url value="/web/view/portfolio">
										   							<c:param name="brand.id" value="${obj.brandId}"/>
										   						</c:url>"><span><c:out value="${obj.brandName}"/></span>
															</a>
														</li>
													</c:if>
												</c:forEach>
											</ul>
										</li>
									</c:forEach>
								</ul>
							</div>
						</section>
					</div>
				</div>
				
				<!-- PRODUCT AND SERVICES MENU W/O ID -->
				<div class="rowProducts"><br>
						<c:choose>
							<c:when test="${empty product.id and empty product.brand.id and product.category.solution.id ne null}">
								<div class="rowBoxes col-lg-12">
									<div class="content ">
										<c:if test="${not empty page.content}">
											 <div class="row">
												<c:forEach items="${page.content}" var="obj" varStatus="index">									
													<c:choose>
													   <c:when test="${empty obj.contentType}">
															<div class="col-md-3 portfolio-item width50-rick">
																<a href="<c:url value="/web/view/portfolio">
											   							<c:param name="brand.id" value="${obj.brand.id}"/>
											   							<c:param name="id" value="${obj.id}"/>
											   						</c:url>" data-toggle="tooltip" title="${obj.name}"><img class="img-responsive" src="<c:url value="/images/no_image_available.jpg"/>" />
																	<div class="row-label">
																		<c:out value="${obj.name}"/>
																	</div>
																</a>
															</div>
														</c:when> 
														<c:otherwise>
															<div class="col-md-3 portfolio-item width50-rick">
																<a href="<c:url value="/web/view/portfolio">
											   							<c:param name="brand.id" value="${obj.brand.id}"/>
											   							<c:param name="id" value="${obj.id}"/>
											   						</c:url>" data-toggle="tooltip" title="${obj.name}"><img class="img-responsive" src="<c:out value="${obj.imageContent}"/>" />
																	<div class="row-label">	
																		<c:out value="${obj.name}"/>
																	</div>
																</a>
															</div>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</div>					
										</c:if>
										<c:if test="${empty page.content}">
											<div class="col-lg-8">
												<h3>No Products available at this time</h3>
											</div>
										</c:if>
									</div>
								</div>
							</c:when>
							<c:when test="${empty product.id and empty product.brand and empty product.category.solution.id}">
								<div class="rowBoxes">
									<div class="content ">
										<c:if test="${not empty page.content}">
											<div class="row">
												<c:forEach items="${page.content}" var="obj" varStatus="index">
													<div class="col-md-3 portfolio-item width-rick">
														<a href="<c:url value="/web/view/portfolio">
											   							<c:param name="brand.id" value="${obj.id}"/>
															</c:url>" data-toggle="tooltip" title="${obj.name}"><img class="img-responsive" src="<c:out value="${obj.brandContent}"/>" />
															<div class="row-label">
																<c:out value="${obj.name}"/>
															</div>
														</a>
													</div>
												</c:forEach>
											</div>
										</c:if>
									</div>
								</div>
							</c:when>
							<c:when test="${empty product.id and not empty product.brand.id}">
								<div class="rowBoxes">
									<div class="content">
										<c:if test="${not empty page.content}">
											 <div class="row"><br>
												<c:forEach items="${page.content}" var="obj" varStatus="index">									
													<c:choose>
													   <c:when test="${empty obj.contentType}">
															<div class="col-md-3 portfolio-item width50-rick">
																<a href="<c:url value="/web/view/portfolio">
											   							<c:param name="brand.id" value="${obj.brand.id}"/>
											   							<c:param name="id" value="${obj.id}"/>
											   						</c:url>" data-toggle="tooltip" title="${obj.name}"><img class="img-responsive" src="<c:url value="/images/no_image_available.jpg"/>" />
																	<div class="row-label">
																		<c:out value="${obj.name}"/>
																	</div>
																</a>
															</div>
														</c:when> 
														<c:otherwise>
															<div class="col-md-3 portfolio-item width50-rick">
																<a href="<c:url value="/web/view/portfolio">
											   							<c:param name="brand.id" value="${obj.brand.id}"/>
											   							<c:param name="id" value="${obj.id}"/>
											   						</c:url>" data-toggle="tooltip" title="${obj.name}"><img class="img-responsive" src="<c:out value="${obj.imageContent}"/>" />
																	<div class="row-label">
																		<c:out value="${obj.name}"/>
																	</div>
																</a>
															</div>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</div>					
										</c:if>
										<c:if test="${empty page.content}">
											<div class="col-lg-8">
												<h3>No Products available at this time</h3>
											</div>
										</c:if>
									</div>
								</div>
							</c:when>
							<c:otherwise>
							
						<!-- 	<div class="form-group">			
								<div class="rowReg">
									<div class="col-lg-12">
										<ul id="myTab" class="nav nav-tabs">
											 <li class="active"><a href="#step-1" data-toggle="tab">Personal information</a></li>
										</ul>
									</div>
									 -->
								<div class="content product-detail">
									<div class="page-headerProduct">
										<img class="img-responsive" src="<c:out value="${product.brand.imageContent}"/>" />
									</div>											
							        <div class="rowWide">
							        	<div class="col-lg-13 product-details width50-rick">
							        		<div class="product-image">
							        			<img class="img-responsive" src="<c:out value="${product.imageContent}"/>" />
							        		</div>
							        		<br>
							            	<div class="product-description" id="step-1">
							            		<h3><b>Description</b></h3>
								            	<p class="text-justify" style="white-space: pre-wrap;">${product.description}</p>
								            	<%-- <c:if test="${empty product.brand.pdfimage}">
								            		<p>Testing testing</p>
								            	</c:if> --%>
								            	<c:if test="${not empty product.manual}">
								            	<b>Manual</b>
								            	<br>
						            			<p>	
						            				<img width="10%" src="<c:out value="${product.brand.pimageContent}"/>">
								            		<a href="<c:url value="/web/view/manualPdf">
								            		<c:param name="id" value="${product.id}"/>
								   					</c:url>"><img src="<c:url value="/images/icon/icon_pdf.png"/>" width="5%"></a></c:if>
								   					&emsp;&emsp; 
								   				<c:if test="${not empty product.brand.website}">
								   				<!-- <b>Website Link:</b>  -->
										    	<a href="<c:url value="${product.brand.website}"></c:url>">${product.brand.website}</a></c:if>
							            	</div>
							            </div>
								    </div>
								</div>
							  </div>
						<!-- 	</div> -->
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
	</section>
</div>
<br style="clear: both;"/>
<%@include file="footer.jsp"%>