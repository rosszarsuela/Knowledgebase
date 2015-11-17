<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>
<script type="text/javascript" src="<c:url value="/dwr/interface/productDWRService.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/mis/forms/products.js"/>"></script>

<div id="page-wrapper">
		<!-- Header -->
		<div id="header">
			<!-- Logo -->
			<h3>
				<a href="<c:url value="/web/home"/>" id="logo">
				<font face="Arial"><b>ORIS Oral Implant Solutions Inc</b></font></a>
			</h3><br><br>
			<%@include file="homeNav.jsp"%>
		</div>
</div>

<div class="9u 10u(narrower) important(narrower)">
				<div id="content">
					<c:if test="${not empty products}">
						<div class="row">
							<c:forEach var="obj" items="${products}">									
								<c:choose>
									<c:when test="${empty obj.contentType}">
										<div class="col-md-3 portfolio-item">
											<a href="#" data-toggle="tooltip" title="${obj.name}">
												<img class="img-responsive" src="<c:url value="/images/no_image_available.jpg"/>" />
											</a>
										</div>
									</c:when>
									<c:otherwise>
										<div class="col-md-3 portfolio-item">
											<a href="#" data-toggle="tooltip" title="${obj.name}">
												<img class="img-responsive" src="<c:out value="${obj.imageContent}"/>" />
											</a>
										</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>					
					</c:if>
				</div>
				
					<form:form id="product_detail_form" action="/Oris/web/view/solution/info" method="get" commandName="productDetailCommand">
						<div class="container">		
							<div class="form-group control-label">
						            <div class="center">
						                <img class="img-responsive" src="<c:out value="${obj.imageContent}"/>" />
						            </div>
					        </div>
						    
						    <div class="control-label">
					            <div class="t">
					            	<font face="Arial" size="4"><c:out value="${obj.name}"/></font>
					            	
					            </div>
							</div>
							
							<div class="form-group">
								<div class="control-label">
						            <div class="t">
								      <font face="Arial" size="3"><c:out value="${obj.description}"/></font>
					            	</div>
								</div>
						    </div>
					   </div>
					   
					   <div>
						   <p class="product-detail">
			        			</p><ul class="nav nav-tabs accordion">
									<li class="active"><a href="http://www.leddental.com/#overview">Overview</a></li>
									<li><a href="http://www.leddental.com/#benefits">Benefits</a></li>
									<li><a href="http://www.leddental.com/#features">Features</a></li>
									<li><a href="http://www.leddental.com/#specifications">Specs</a></li>
									<li><a href="http://www.leddental.com/#dimensions">Dimensions</a></li>
									<li><a href="http://www.leddental.com/#brochure">Brochure</a></li>
								</ul>
							<div class="tab-content accordion"></div>
						</div>
				   </form:form>
			</div>