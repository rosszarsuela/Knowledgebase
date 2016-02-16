<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/productNav/styles.css"/>">
<script src="<c:url value="/js/productNav/script.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/common/productTable.js"/>"></script>

<style>
#imgOr {
	margin: auto !important;
	width: 30% !important;
	padding-bottom: 3px !important;
}

span.row-label {
	font-size: 17px;
}

.col-lg-8 h3 {
	position: absolute;
	top: 120px;
}

.row-label {
	position: absolute;
}

.row>* {
	margin: 50px 0 25px 0px;
	padding: 50px 0 30px 50px;
}

.rowProducts {
	margin: -15px 0 25px 90px !important;
}

div.imgBrand {
	margin: 5px;
	padding: 5px;
	border: 2px solid #0000ff;
	height: auto;
	width: auto;
	text-align: center;
}

#header {
	padding: 1em 0 0 0 !important;
}

#header>h3 {
	margin-bottom: .6em !important;
}

span.row-label {
	font-size: 17px;
}

.product-image-tech {
	width: 40% !important;
	height: 20% !important;
	float: left;
	/* margin: -20px 10px 0px 0px !important; */
	margin: 30px 30px 0px -30px !important;
}

.page-headerProduct-tech {
	width: 40% !important;
	margin: -40px 0 0 -25px !important;
}

.rowWide-tabs {
	margin: 60px 0px 0px -60px !important;
}

.table-responsive {
	min-height: .01%;
	overflow-x: auto;
}

.table {
	width: 65%;
	max-width: 100%;
	margin-bottom: 20px;
	font-size: 80%;
}

.product-Table {
	margin: 0px -60px 0px 60px !important;
}

.product-images {
	width: 57% !important;
	height: 20% !important;
	float: left;
	margin: -70px 0px 0px 0px !important;
}

.product-image {
	width: 45% !important;
	height: 20% !important;
	float: right;
	margin: 0px 0px 0px 46px !important;
}

.layout {
	position: relative;
	top: 50px;
	right: -20px;
}

.page-headerProduct1 {
	padding-bottom: 0px !important;
	width: 450px;
	margin: 0px 0px 0px 145px !important;
}

.product-image1 {
	width: 45% !important;
	float: right;
	margin: 35px 0px 125px 46px !important;
}

.product-images2 {
	width: 45% !important;
	float: right;
	margin: -116px 0px 100px 43px !important;
}

.product-image3 {
	width: 45% !important;
	float: right;
	margin: 35px 0px 270px 46px !important;
}

.product-single {
	width: 90% !important;
	margin: 0px 0px 0px 0px !important;
}

.info-prod {
    padding: 69px 0px 140px 0px;
    margin: -39px 100px -100px -100px;
}

</style>

<div id="page-wrapper">
	<!-- Header -->
	<div id="header">
		<!-- Logo -->
		<h3>
			<a href="<c:url value="/web/home"/>" id="logo"> <img
				class="img-responsive" id="imgOr"
				src="<c:url value="/images/oris_logo.png"/>" />
			</a>
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
							<c:forEach items="${solutionList}" var="solutionName"
								varStatus="index">
								<li class='has-sub'><a href='#'><span>${solutionName}</span>
								</a>
									<ul>
										<c:forEach items="${brandList}" var="obj" varStatus="index">
											<c:if test="${solutionName eq obj.solutionName}">
												<li><a
													href="<c:url value="/web/view/portfolio">
										   							<c:param name="brand.id" value="${obj.brandId}"/>
										   						</c:url>"><span><c:out
																value="${obj.brandName}" />
													</span> </a></li>
											</c:if>
										</c:forEach>
									</ul></li>
							</c:forEach>
						</ul>
					</div>
					</section>
				</div>
			</div>

			<!-- PRODUCT AND SERVICES MENU W/O ID -->
			<div class="rowProducts">
				<br>
				<c:choose>
					<c:when
						test="${empty product.id and empty product.brand.id and product.category.solution.id ne null}">
						<div class="rowBoxes col-lg-12">
							<div class="content ">
								<c:if test="${not empty page.content}">
									<div class="row">
										<c:forEach items="${page.content}" var="obj" varStatus="index">
											<c:choose>
												<c:when test="${empty obj.contentType}">
													<div class="col-md-3 portfolio-item width50-rick">
														<a
															href="<c:url value="/web/view/portfolio">
											   							<c:param name="brand.id" value="${obj.brand.id}"/>
											   							<c:param name="id" value="${obj.id}"/>
											   						</c:url>"
															data-toggle="tooltip" title="${obj.name}"><img
															class="img-responsive"
															src="<c:url value="/images/no_image_available.jpg"/>" />
															<div class="row-label">
																<c:out value="${obj.name}" />
															</div> </a>
													</div>
												</c:when>
												<c:otherwise>
													<div class="col-md-3 portfolio-item width50-rick">
														<a
															href="<c:url value="/web/view/portfolio">
											   							<c:param name="brand.id" value="${obj.brand.id}"/>
											   							<c:param name="id" value="${obj.id}"/>
											   						</c:url>"
															data-toggle="tooltip" title="${obj.name}"><img
															class="img-responsive"
															src="<c:out value="${obj.imageContent}"/>" />
															<div class="row-label">
																<c:out value="${obj.name}" />
															</div> </a>
													</div>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</div>
								</c:if>
								
								<c:if test="${empty page.content}">
									<div class="info-prod"> 
								        <div class="panel panel-info">
								            <div class="panel-heading">
								           		<img src="<c:url value="/images/icon/tool_sign.png"/>" height="20px" width="20px">&emsp;INFORMATION
								           	</div>
											<div class="panel-body">
								           			<h3>Sorry no products available at this time</h3>
											</div>
		           					   </div>
							       	</div>
					       		</c:if>
					       		
			                </div>
						</div>
					</c:when>
					<c:when
						test="${empty product.id and empty product.brand and empty product.category.solution.id}">
						<div class="rowBoxes">
							<div class="content ">
								<c:if test="${not empty page.content}">
									<div class="row">
										<c:forEach items="${page.content}" var="obj" varStatus="index">
											<div class="col-md-3 portfolio-item width-rick">
												<a
													href="<c:url value="/web/view/portfolio">
											   							<c:param name="brand.id" value="${obj.id}"/>
															</c:url>"
													data-toggle="tooltip" title="${obj.name}"><img
													class="img-responsive"
													src="<c:out value="${obj.brandContent}"/>" />
													<div class="row-label">
														<c:out value="${obj.name}" />
													</div> </a>
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

									<div class="layout">
										<c:if test="${not empty page.content && brand eq 'RayScan'}">
											<img class="img-responsive" id=""
												src="<c:url value="/images/rayscan.png"/>" />
										</c:if>
									</div>

									<div class="row">
										<c:forEach items="${page.content}" var="obj" varStatus="index">
											<c:choose>
												<c:when test="${empty obj.contentType}">
													<div class="col-md-3 portfolio-item width50-rick">
														<a
															href="<c:url value="/web/view/portfolio">
											   							<c:param name="brand.id" value="${obj.brand.id}"/>
											   							<c:param name="id" value="${obj.id}"/>
											   						</c:url>"
															data-toggle="tooltip" title="${obj.name}"><img
															class="img-responsive"
															src="<c:url value="/images/no_image_available.jpg"/>" />
															<div class="row-label">
																<c:out value="${obj.name}" />
															</div> </a>
													</div>
												</c:when>
												<c:otherwise>
													<div class="col-md-3 portfolio-item width50-rick">
														<a
															href="<c:url value="/web/view/portfolio">
											   							<c:param name="brand.id" value="${obj.brand.id}"/>
											   							<c:param name="id" value="${obj.id}"/>
											   						</c:url>"
															data-toggle="tooltip" title="${obj.name}"><img
															class="img-responsive"
															src="<c:out value="${obj.imageContent}"/>" />
															<div class="row-label">
																<c:out value="${obj.name}" />
															</div> </a>
													</div>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</div>
								</c:if>
								
								<c:if test="${empty page.content}">
									<div class="info-prod"> 
								        <div class="panel panel-info">
								            <div class="panel-heading">
								           		<img src="<c:url value="/images/icon/tool_sign.png"/>" height="20px" width="20px">&emsp;INFORMATION
								           	</div>
							               	<div class="panel-body">
								           			<h3>Sorry no products available at this time</h3>
											</div>
		           					   </div>
							       	</div>
						       	</c:if>
						       	
				           </div>
						</div>
					</c:when>
					<c:otherwise>

						<div class="rowWide-tabs">
							<div class="content product-detail">
								<div class="col-lg-13 product-details width50-rick">
									<div id="myTabContent" class="tab-content">
									
										<c:if test="${not empty product.description && not empty product.specs}">
											<div class="col-lg-12">
												<ul id="myTab" class="nav nav-tabs">
													<li class="active"><a href="#step-1" data-toggle="tab">Description</a>
													</li>
													<li><a href="#step-2" data-toggle="tab">Technical Specifications</a>
													</li>
												</ul>
											</div>

											<div class="tab-pane fade in active" id="step-1">
												<div class="page-headerProduct">
													<img class="img-responsive"
														src="<c:out value="${product.brand.imageContent}"/>" />
												</div>

												<div class="product-image">
													<img class="img-responsive"
														src="<c:out value="${product.imageContent}"/>" />
												</div>

												<div class="product-description">
													<p class="text-justify" style="white-space: pre-wrap;">${product.description}</p>
													<c:if test="${not empty product.manual}">
														<b>Manual</b>
														<br>
														<img width="10%"
															src="<c:out value="${product.brand.pimageContent}"/>">
														<a
															href="<c:url value="/web/view/manualPdf">
									            		<c:param name="id" value="${product.id}"/>
									   						</c:url>"><img
															src="<c:url value="/images/icon/icon_pdf.png"/>"
															width="5%">
														</a>
													</c:if>
													&emsp;&emsp;
													<c:if test="${not empty product.brand.website}">

														<a href="<c:url value="${product.brand.website}"></c:url>">${product.brand.website}</a>
													</c:if>
												</div>
											</div>


											<div class="tab-pane fade" id="step-2">
												<div class="page-headerProduct-tech">
													<img class="img-responsive"
														src="<c:out value="${product.brand.imageContent}"/>" />
												</div>

												<div class="product-image-tech">
													<img class="img-responsive"
														src="<c:out value="${product.imageContent}"/>" />
												</div>

												<div class="product-images">
													<center>
														<table>
															<tbody>
																<c:forEach var="obj" items="${product.productImages}">
																	<td><img class="img-responsive"
																		src="<c:out value="${obj.imageContent}"/>">
																	</td>
																	<br>
																</c:forEach>
															</tbody>
														</table>
													</center>
												</div>

												<h3>Technical Specifications</h3>

												<div class="product-Table">
													<table
														class="table table-striped table-responsive table-condensed "
														id="myTable">
														<thead>
															<tr>
																<th colspan="4"><b>${product.name}</b>
																</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach var="obj" items="${product.specs}">
																<tr>
																	<td><c:out value="${obj.specification}" />
																	</td>
																	<td><c:out value="${obj.spec1}" />
																	</td>
																	<td><c:out value="${obj.spec2}" />
																	</td>
																	<td><c:out value="${obj.spec3}" />
																	</td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
										</c:if>
									</div>
								</div>
							</div>
						</div>

						<div class="rowWide-tabs">
							<div class="content product-detail">
								<div class="col-lg-13 product-details width50-rick">
									<c:if test="${not empty product.description && empty product.specs && not empty product.productImages}">
										<div class="page-headerProduct1">
											<img class="img-responsive"
												src="<c:out value="${product.brand.imageContent}"/>" />
										</div>

										<div class="product-image1">
											<img class="img-responsive"
												src="<c:out value="${product.imageContent}"/>" />
										</div>

										<div class="product-images2">
											<center>
												<table>
													<tbody>
														<c:forEach var="obj" items="${product.productImages}">
															<td><img class="img-responsive"
																src="<c:out value="${obj.imageContent}"/>">
															</td>
															<br>
														</c:forEach>
													</tbody>
												</table>
											</center>
										</div>

										<div class="product-description">
											<br>
											<h3><b>Description</b></h3>
											<p class="text-justify" style="white-space: pre-wrap;">${product.description}</p>

											<c:if test="${not empty product.manual}">
												<b>Manual</b>
												<br>
												<p>

													<img width="15%"
														src="<c:out value="${product.brand.pimageContent}"/>">
													<a
														href="<c:url value="/web/view/manualPdf">
								            			<c:param name="id" value="${product.id}"/>
								   							</c:url>"><img
														src="<c:url value="/images/icon/icon_pdf.png"/>"
														width="6%">
													</a>
											</c:if>
											&emsp;&emsp;

										</div>
									</c:if>
									
									<c:if test="${not empty product.description  && empty product.productImages && empty product.specs}">
										<div class="page-headerProduct1">
											<img class="img-responsive"
												src="<c:out value="${product.brand.imageContent}"/>" />
										</div>

										<div class="product-image3">
											<img class="img-responsive"
												src="<c:out value="${product.imageContent}"/>" />
										</div>

										<div class="product-description">
											<br>
											<h3><b>Description</b></h3>
											<p class="text-justify" style="white-space: pre-wrap;">${product.description}</p>

											<c:if test="${not empty product.manual}">
												<b>Manual</b>
												<br>
												<p>

													<img width="15%"
														src="<c:out value="${product.brand.pimageContent}"/>">
													<a
														href="<c:url value="/web/view/manualPdf">
								            			<c:param name="id" value="${product.id}"/>
								   							</c:url>"><img
														src="<c:url value="/images/icon/icon_pdf.png"/>"
														width="6%">
													</a>
											</c:if>
											&emsp;&emsp;

										</div>
									</c:if>
									
									<c:if test="${not empty product.imageContent  && empty product.description && empty product.productImages}">
										<div class="product-single">
											<img class="img-responsive"
												src="<c:out value="${product.imageContent}"/>" />
										</div>
									</c:if>
			
			
									<c:if test="${not empty product.specs && empty product.description}">
										<div class="page-headerProduct-tech">
											<img class="img-responsive"
												src="<c:out value="${product.brand.imageContent}"/>" />
										</div>

										<div class="product-image-tech">
											<img class="img-responsive"
												src="<c:out value="${product.imageContent}"/>" />
										</div>

										<div class="product-images">
											<center>
												<table>
													<tbody>
														<c:forEach var="obj" items="${product.productImages}">
															<td><img class="img-responsive"
																src="<c:out value="${obj.imageContent}"/>">
															</td>
															<br>
														</c:forEach>
													</tbody>
												</table>
											</center>
										</div>

										<h3>Technical Specifications</h3>

										<div class="product-Table">
											<table
												class="table table-striped table-responsive table-condensed "
												id="myTable">
												<thead>
													<tr>
														<th colspan="4"><b>${product.name}</b>
														</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="obj" items="${product.specs}">
														<tr>
															<td><c:out value="${obj.specification}" />
															</td>
															<td><c:out value="${obj.spec1}" />
															</td>
															<td><c:out value="${obj.spec2}" />
															</td>
															<td><c:out value="${obj.spec3}" />
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	</section>
</div>
<br style="clear: both;" />
<%@include file="footer.jsp"%>
