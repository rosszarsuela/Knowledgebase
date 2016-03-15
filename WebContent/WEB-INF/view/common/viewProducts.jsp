<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/productNav/styles.css"/>">
<script src="<c:url value="/js/productNav/script.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/common/productTable.js"/>"></script>

<style>
#imgOr {
	margin: auto !important;
	width: 30% !important;
	padding-bottom: 3px !important;
}

#manual-name {
	/* margin: -125px 490px 69px 149px !important; */
	margin: 150px 535px -135px 150px !important;
	font-size: 85% !important;
	
}

#manual-Neo {
	margin: -125px 490px 69px 149px !important;
	font-size: 85% !important;
	
}

#manual-dex {
	margin: 60px 543px -38px 149px !important;
	font-size: 85% !important;
}

#manual-name1 {
	margin: 107px 0px -95px 145px !important;
	font-size: 85% !important;
}

#manual-ritter {
	margin: 248px 541px -132px 152px !important;
	font-size: 85% !important;
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

#rayEvent {
	margin: 20px 0px 0px 400px !important;
}

#eventDesc {
	width: 250%;
	margin: -75px 0px 0px 100px !important;
}

#eventDesc1 {
	width: 100%;
	margin: -55px 0px 0px -14px !important;
}

#eventDesc2 {
	width: 130%;
	margin: -28px 0px 0px -15px !important;
}

#event-pic {
	margin: 30px 0px 0px 60px !important;
}

.rowProducts {
	margin: -15px 0 25px 90px !important;
}

.page-headerBrand {
	margin: 0px 0px 30px 0px !important;
}

.product-brand {
	width: 45% !important;
	float: right;
	margin: 0px 0px 0px 20px !important;
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

.product-image-tech b {
	width: 50% !important;
    float: left;
    margin: 0px 0px 0px 160px !important;
    font-size: small;
    font-style: italic;
}

.page-headerProduct-tech {
	width: 24% !important;
    margin: -80px 0 -35px -25px !important;
}

.table th {
    text-align: center;
    color: black;
    background-color: #BCC0C1;
    font-color: #fff;
}

.table > tbody > tr > td {
    border-top: 1px solid #BFB7B7 !important;
}

.table-striped > tbody > tr:nth-child(odd) > td, .table-striped > tbody > tr:nth-child(odd) > th {
    background-color: rgba(206, 195, 195, 0.14) !important;
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
	margin: 0px 0px 0px 0px !important;
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
	margin: 35px 0px 10px 40px !important;
}

.product-imageNorm {
	width: 45% !important;
	float: right;
	margin: 35px 0px 19px 38px !important;
}

.product-single {
	width: 90% !important;
	margin: 0px 0px 0px 0px !important;
}

.info-prod {
	padding: 69px 0px 140px 0px;
	margin: -39px 100px -100px -100px;
}

.info-prod-cat {
	padding: 120px 0px 140px 0px;
	margin: -39px 100px -100px -100px;
}


#neoImg {
	width: 10% !important;
	margin: -226px 0px 0px 520px !important;
}

#eventDescNeo {
	width: 25%;
	margin: -56px -2px 56px 618px !important;
}

#eventDesc3 {
	width: 70%;
	margin: -81px 0px 0px -14px !important;
}

#neoItems {
	width: 103% !important;
}

#ritterItem {
	width: 108% !important;
    margin: 2px 0px 0px 0px !important;
}

#rit {
	margin: 0px 0px 0px 0px !important;
}

#rhe {
	margin: 0px 0px 0px 0px !important;
}

#rheImg{
	width: 6% !important;
    margin: -160px 0px 0px 665px !important;
}

#eventDescRhe{
	width: 26%;
    margin: -56px -2px 56px 618px !important;
}

#eventDescR1 {
	width: 89%;
    margin: -77px 0px 0px 92px !important;
}

#eventDescR2 {
	font-size: smaller;
    margin: -3px 0px 0px 91px !important;
}

.back-button {
	margin: 0px 0px 0px 0px !important;
}

</style>

<div id="page-wrapper">
	<!-- Header -->
	<div id="header">
		<!-- Logo -->
		<h3>
			<a href="<c:url value="/web/home"/>" id="logo"> <img
				class="img-responsive" id="imgOr"
				src="<c:url value="/images/oris_logo.png"/>" /> </a>
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
																value="${obj.brandName}" /> </span> </a></li>
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
									<div class="info-prod-cat">
										<div class="panel panel-info">
											<div class="panel-heading">
												<img src="<c:url value="/images/icon/tool_sign.png"/>"
													height="20px" width="20px">&emsp;INFORMATION
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

									<div id="event-pic">
										<div class="col-md-2 portfolio-item width50-rick"
											id="rayEvent">
											<c:if test="${not empty page.content && brand eq 'RayScan'}">
												<a href="<c:url value="/web/view/events"/>"> <img
													class="img-responsive"
													src="<c:url value="/images/raidio.png"/>" />
													<div class="col-md-12" id="eventDesc">
														<div class="col-md-12" id="eventDesc1">Click to
															attend</div>
														<div class="col-md-12" id="eventDesc2">
															<b>Radiograph Forum @ Oris</b>
														</div>
														CBCT Manipulation & Interpretation Workshop
													</div> </a>
											</c:if>
										</div>
									</div>
								</c:if>

								<c:if test="${empty page.content}">
									<div class="info-prod">
										<div class="panel panel-info">
											<div class="panel-heading">
												<img src="<c:url value="/images/icon/tool_sign.png"/>"
													height="20px" width="20px">&emsp;INFORMATION
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

						<%-- <div class="rowWide-tabs">
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
						</div> --%>

						<div class="rowWide-tabs">
							<div class="content product-detail">
								<div class="col-lg-13 product-details width50-rick">
									<c:if
										test="${not empty product.description && empty product.specs && not empty product.productImages}">
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
											<h3>
												<b>Description</b>
											</h3>
											<p class="text-justify" style="white-space: pre-wrap;">${product.description}</p>

											<c:if test="${not empty product.manual}">
												<c:choose>
													<c:when test="${brand eq 'Dexcowin'}">
														<div id="manual-dex">
															<b>${product.brand.manualName}</b>
														</div>
													</c:when>
													<c:otherwise>
														<div id="manual-name1">
															<b>${product.brand.manualName}</b>
														</div>
													</c:otherwise>
												</c:choose>
												<p>

													<img width="15%"
														src="<c:out value="${product.brand.pimageContent}"/>">
													<a
														href="<c:url value="/web/view/manualPdf">
								            			<c:param name="id" value="${product.id}"/>
								   							</c:url>"><img
														src="<c:url value="/images/icon/icon_pdf.png"/>"
														width="6%"> </a>
											</c:if>
											&emsp;&emsp;

										</div>
									</c:if>

									<c:if
										test="${not empty product.description  && empty product.productImages && empty product.specs}">
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
											<h3>
												<b>Description</b>
											</h3>
											<p class="text-justify" style="white-space: pre-wrap;">${product.description}</p>

											<c:if test="${not empty product.manual}">
												<c:choose>
													<c:when test="${brand eq 'Ritter'}">
														<div id="manual-ritter">
															<b>${product.brand.manualName}</b>
														</div>
													</c:when>
													<c:otherwise>
														<div id="manual-name">
															<b>${product.brand.manualName}</b>
														</div>
													</c:otherwise>
												</c:choose>
												
												<img width="15%"
													src="<c:out value="${product.brand.pimageContent}"/>">
												<a
													href="<c:url value="/web/view/manualPdf">
								            			<c:param name="id" value="${product.id}"/>
								   							</c:url>"><img
													src="<c:url value="/images/icon/icon_pdf.png"/>" width="6%">
												</a>
											</c:if>&emsp;&emsp;
											<br>
												<c:if test="${not empty product.brand.website}">
													<c:choose>
														<c:when test="${brand eq 'Ritter'}">
															<a id ="rit" href="<c:url value="${product.brand.website}"></c:url>"> Website link: ${product.brand.website}</a>
														</c:when>
														<c:otherwise>
															<c:choose>
																<c:when test="${brand eq 'Rhein 83'}">
																	<a id ="rhe" href="<c:url value="${product.brand.website}"></c:url>">Website link: ${product.brand.website}</a>
																</c:when>
																<c:otherwise>
																	<a href="<c:url value="${product.brand.website}"></c:url>">Website link: ${product.brand.website}</a>
																</c:otherwise>
															</c:choose>
														</c:otherwise>
													</c:choose>
												</c:if>
												
											<c:if test="${brand eq 'Ritter'}">
												<div class="portfolio-item" id="ritterItem">
													<a href="<c:url value="/web/view/events"/>"> <img
														class="img-responsive" id="neoImg"
														src="<c:url value="/images/dev.png"/>" />
														<div class="col-md-12" id="eventDescNeo">
															<div class="col-md-12" id="eventDesc3">Click to
																know more about</div>
															<div class="col-md-12" id="eventDesc2">
																<b>Oris Dental Implant Education & Skill
																	Development Program</b>
															</div>
														</div> </a>
												</div>
											</c:if>
										</div>
									</c:if>

									<c:if
										test="${not empty product.imageContent && empty product.description && empty product.productImages}">
										<c:choose>
											<c:when test="${brand eq 'Neobiotech'}">
												<div class="page-headerBrand">
													<img class="img-responsive"
														src="<c:out value="${product.brand.imageContent}"/>" />
												</div>

												<div class="product-brand">
													<img class="img-responsive" id=""
														src="<c:url value="/images/neobiotech.png"/>" />
												</div>

												<div class="product-description">
													<br>
													<h3>
														<b>Description</b>
													</h3>
													<p class="text-justify"
														style="white-space: pre-wrap; margin-bottom: 175px;">${product.brand.description}</p>

													<c:if test="${not empty product.manual}">

														<img width="15%" id="manual-pdf"
															src="<c:out value="${product.brand.pimageContent}"/>">
														<a
															href="<c:url value="/web/view/manualPdf">
														            			<c:param name="id" value="${product.id}"/>
														   							</c:url>"><img
															src="<c:url value="/images/icon/icon_pdf.png"/>"
															width="6%"> </a>

														<c:choose>
															<c:when test="${brand eq 'Neobiotech' }">
																<div id="manual-Neo">
																	<b>${product.brand.manualName}</b>
																</div>
															</c:when>
															<c:otherwise>
																<div id="manual-name">
																	<b>${product.brand.manualName}</b>
																</div>
															</c:otherwise>
														</c:choose>
													</c:if>
													&emsp;&emsp;

													<div class="portfolio-item" id="neoItem">
														<a href="<c:url value="/web/view/events"/>"> <img
															class="img-responsive" id="neoImg"
															src="<c:url value="/images/dev.png"/>" />
															<div class="col-md-12" id="eventDescNeo">
																<div class="col-md-12" id="eventDesc3">Click to
																	know more about</div>
																<div class="col-md-12" id="eventDesc2">
																	<b>Oris Dental Implant Education & Skill
																		Development Program</b>
																</div>
															</div> </a>
													</div>

												</div>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${brand eq 'MESA'}">
														<div class="page-headerProduct1">
															<img class="img-responsive"
																src="<c:out value="${product.brand.imageContent}"/>" />
														</div>

														<div class="product-image3">
															<img class="img-responsive" id=""
																src="<c:url value="/images/mesa.png"/>" />
														</div>

														<div class="product-description">
															<br>
															<h3>
																<b>Description</b>
															</h3>
															<p class="text-justify" style="white-space: pre-wrap;">${product.brand.description}</p>

															<c:if test="${not empty product.manual}">
																<div id="manual-name">
																	<b>${product.brand.manualName}</b>
																</div>

																<p>
																	<img width="15%"
																		src="<c:out value="${product.brand.pimageContent}"/>">
																	<a
																		href="<c:url value="/web/view/manualPdf">
														            			<c:param name="id" value="${product.id}"/>
														   							</c:url>"><img
																		src="<c:url value="/images/icon/icon_pdf.png"/>"
																		width="6%"> </a>
															</c:if>
															&emsp;&emsp;
														</div>
													</c:when>

													<c:otherwise>
														<div class="product-single">
															<img class="img-responsive"
																src="<c:out value="${product.imageContent}"/>" />
														</div>
														
														<c:if test="${brandEvent eq 'PIVOT FOR DIRECT OVERDENTURE'}">
															<div class="portfolio-item" id="ritterItem">
																<a href="<c:url value="/web/view/events"/>"> <img
																	class="img-responsive" id="rheImg"
																	src="<c:url value="/images/lose.png"/>" />
																	<div class="col-md-12" id="eventDescRhe">
																		<div class="col-md-12" id="eventDescR1">
																		<b>Root-Retained Overdenture Seminar Workshop</b></div>
																		<div class="col-md-12" id="eventDescR2">
																			Click for more Info.
																		</div>
																	</div> </a>
															</div>
														</c:if>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
									</c:if>

									<c:if
										test="${not empty product.specs && empty product.description}">
										<div class="page-headerProduct-tech">
											<img class="img-responsive"
												src="<c:out value="${product.brand.imageContent}"/>" />
										</div>

										<div class="product-image-tech">
											<img class="img-responsive"
												src="<c:out value="${product.imageContent}"/>" />
												<b>${product.remarks}</b>
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
										
										<div class="button-back">
											<button type="button" class="back-button">Back</button>
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
