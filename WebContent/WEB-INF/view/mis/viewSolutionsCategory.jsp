<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>

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

<br>

<div class="container">	
	<form:form id="view_brand" action="/Oris/web/secured/admin/solution/category/view" method="post" commandName="solutionCommand">
			
		<div class="form-group">
	        	<div class="col-lg-4">
	      			<input type="text" class="form-control" name="name" placeholder="Search Solutions Category"/>
	      		</div>
			</div>
			
		<div class="form-group">
			<div class="col-lg-8">
	      		<a class="btn btn-primary" href="<c:url value="/web/secured/admin/solution/category/form"/>">CREATE CATEGORY</a>
	      		<%-- <a class="btn btn-primary" href="<c:url value="/web/secured/admin/solution/category/pdf">
					<c:if test="${not empty solutionCommand.name}">
						<c:param name="username" value="${solutionCommand.name}" />
					</c:if>
					<c:param name="orderBy" value="${solutionCommand.orderBy}"/>
					<c:param name="sortBy" value="${solutionCommand.sortBy}"/>
				</c:url>">GENERATE PDF</a> --%>
	    	</div>
	    </div>
    <br>
	</form:form>
	<br>


		<div class="form-group">
			<div class="col-lg-12">
				<table class="table table-striped table-bordered table-responsive table-condensed">
				<thead>
					<tr>
						<th>
							<a href="<c:url value="/web/secured/admin/solution/category/view">
									<c:if test="${not empty solutionCommand.name}">
										<c:param name="search" value="${solutionCommand.name}" />
									</c:if>
										<c:param name="begin" value="${page.currentPage}" />
										<c:param name="orderBy" value="sc.solution.name"/>
										<c:param name="sortBy" value="asc"/>
								</c:url>" > <img src="<c:url value="/images/up.png"/>" height="10px" width="10px" title="Asc">
							</a>
							Solution
							<a href="<c:url value="/web/secured/admin/solution/category/view">
									<c:if test="${not empty solutionCommand.name}">
										<c:param name="search" value="${solutionCommand.name}" />
									</c:if>
										<c:param name="begin" value="${page.currentPage}" />
										<c:param name="orderBy" value="sc.solution.name"/>
									<c:param name="sortBy" value="desc"/>
								</c:url>" > <img src="<c:url value="/images/down.png"/>" height="10px" width="10px" title="Desc">
							</a>
						</th>
						<th>
							<a href="<c:url value="/web/secured/admin/solution/category/view">
									<c:if test="${not empty solutionCommand.name}">
										<c:param name="search" value="${solutionCommand.name}" />
									</c:if>
										<c:param name="begin" value="${page.currentPage}" />
										<c:param name="orderBy" value="sc.name"/>
										<c:param name="sortBy" value="asc"/>
								</c:url>" > <img src="<c:url value="/images/up.png"/>" height="10px" width="10px" title="Asc">
							</a>
							Name
							<a href="<c:url value="/web/secured/admin/solution/category/view">
									<c:if test="${not empty solutionCommand.name}">
										<c:param name="search" value="${solutionCommand.name}" />
									</c:if>
										<c:param name="begin" value="${page.currentPage}" />
										<c:param name="orderBy" value="sc.name"/>
										<c:param name="sortBy" value="desc"/>
								</c:url>" > <img src="<c:url value="/images/down.png"/>" height="10px" width="10px" title="Desc">
							</a>
						</th>
						<th>
							<a href="<c:url value="/web/secured/admin/solution/category/view">
									<c:if test="${not empty solutionCommand.name}">
										<c:param name="search" value="${solutionCommand.name}" />
									</c:if>
										<c:param name="begin" value="${page.currentPage}" />
										<c:param name="orderBy" value="sc.description"/>
										<c:param name="sortBy" value="asc"/>
								</c:url>" > <img src="<c:url value="/images/up.png"/>" height="10px" width="10px" title="Asc">
							</a>
							Description
							<a href="<c:url value="/web/secured/admin/solution/category/view">
									<c:if test="${not empty solutionCommand.name}">
										<c:param name="search" value="${solutionCommand.name}" />
									</c:if>
										<c:param name="begin" value="${page.currentPage}" />
										<c:param name="orderBy" value="sc.description"/>
										<c:param name="sortBy" value="desc"/>
								</c:url>" > <img src="<c:url value="/images/down.png"/>" height="10px" width="10px" title="Desc">
							</a>
						</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty page.content }">
							<c:forEach items="${page.content }" var="obj" varStatus="index">
								<c:choose>
									<c:when test="${index.count%2 ne 0}">
										<tr class="oddrowcolor">
									</c:when>
									
									<c:otherwise>
										<tr class="evenrowcolor">
									</c:otherwise>
								</c:choose>
			
								<td class="td-left">${obj.solution.name}</td>
								<td class="td-left">${obj.name}</td>
								<td class="td-left">${obj.description}</td>
								<td class="td-center">
									<a href="<c:url value="/web/secured/admin/solution/category/edit">
				   							<c:param name="id" value="${obj.id}"/>
				   						</c:url>" id="edit"><img src="<c:url value="/images/icon/edit_icon.png"/>" height="20px" width="20px">
									</a>
								</td>
							</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="8" style="color: red; text-align: center;">No records found</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		
			<div align="left" style="padding-top: 0px; margin-left: 0px;">
				<c:if test="${not empty page.content}"><div>${page.currentPage}&nbsp;&nbsp;&nbsp;of&nbsp;&nbsp;&nbsp;${page.totalPages}</div></c:if>
				<div style="display: inline;">
					<c:if test="${page.currentPage gt 1}">
						<a href="<c:url value="/web/secured/admin/solution/category/view">
							<c:if test="${not empty solutionCommand.name}">
								<c:param name="search" value="${solutionCommand.name}" />
							</c:if>
								<c:param name="begin" value="1" />
								<c:param name="orderBy" value="${orderBy}"/>
								<c:param name="sortBy" value="${sortBy}"/>										    							
							</c:url>">First&nbsp;
						</a>
						<a href="<c:url value="/web/secured/admin/solution/category/view">
								<c:if test="${not empty solutionCommand.name}">
									<c:param name="search" value="${solutionCommand.name}" />
								</c:if>
		  							<c:param name="begin" value="${page.currentPage - 1}" />
		  							<c:param name="orderBy" value="${orderBy}"/>
		  							<c:param name="sortBy" value="${sortBy}"/>										    							
		  						</c:url>">
							&lt;&lt; Previous
						</a>
						&nbsp;
					</c:if>
				</div>
				<div style="display: inline;">
					<c:if test="${page.currentPage lt page.totalPages}">
						<a href="<c:url value="/web/secured/admin/solution/category/view">
								<c:if test="${not empty solutionCommand.name}">
									<c:param name="search" value="${solutionCommand.name}" />
								</c:if>
		  							<c:param name="begin" value="${page.currentPage + 1}" />
		  							<c:param name="orderBy" value="${orderBy}"/>
		  							<c:param name="sortBy" value="${sortBy}"/>										    							
		  						</c:url>">
							Next &gt;&gt;
						</a>&nbsp;
						<a href="<c:url value="/web/secured/admin/solution/category/view">
							<c:if test="${not empty solutionCommand.name}">
								<c:param name="search" value="${solutionCommand.name}" />
							</c:if>
								<c:param name="begin" value="${page.totalPages}" />
								<c:param name="orderBy" value="${orderBy}"/>
								<c:param name="sortBy" value="${sortBy}"/>										    							
							</c:url>">
							Last
						</a>&nbsp;
					</c:if>
				</div>
					<div>
						<c:if test="${page.totalRecords gt 0}">
							<div>Total Records: <c:out value="${page.totalRecords}"></c:out></div>
						</c:if>		
					</div>
				</div>
			</div>
		</div>
</div>