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

<br/>

<div class="container">
	<form:form id="view_users" action="/Oris/web/secured/admin/user/view" method="post">
		<div class="form-group">
        	<div class="col-lg-4">
      			<input type="text" class="form-control" name="username" placeholder="Search User"/>
      		</div>
		</div>
		<div class="form-group">
			<div class="col-lg-8">
				<a class="btn btn-primary" href="<c:url value="/web/secured/admin/user/form"/>">CREATE USER</a>
				<%-- <a class="btn btn-primary" href="<c:url value="/web/secured/admin/user/pdf">
					<c:if test="${not empty username}">
						<c:param name="username" value="${username}" />
					</c:if>
					<c:param name="orderBy" value="${orderBy}"/>
					<c:param name="sortBy" value="${sortBy}"/>
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
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:if test="${not empty username}">
										<c:param name="username" value="${username}" />
									</c:if>
										<c:param name="begin" value="${page.currentPage}" />
										<c:param name="orderBy" value="username"/>
										<c:param name="sortBy" value="asc"/>
								</c:url>" > <img src="<c:url value="/images/up.png"/>" height="10px" width="10px" title="Asc">
							</a>
							Username
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:if test="${not empty username}">
										<c:param name="username" value="${username}" />
									</c:if>
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="orderBy" value="username"/>
									<c:param name="sortBy" value="desc"/>
								</c:url>" > <img src="<c:url value="/images/down.png"/>" height="10px" width="10px" title="Desc">
							</a>
						</th>
						<th>
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:if test="${not empty username}">
										<c:param name="username" value="${username}" />
									</c:if>
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="orderBy" value="role.description"/>
									<c:param name="sortBy" value="asc"/>
								</c:url>" > <img src="<c:url value="/images/up.png"/>" height="10px" width="10px" title="Asc">
							</a>
							Role
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:if test="${not empty username}">
										<c:param name="username" value="${username}" />
									</c:if>
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="orderBy" value="role.description"/>
									<c:param name="sortBy" value="desc"/>
								</c:url>" > <img src="<c:url value="/images/down.png"/>" height="10px" width="10px" title="Desc">
							</a>
						</th>
						<th>
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:if test="${not empty username}">
										<c:param name="username" value="${username}" />
									</c:if>
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="orderBy" value="firstName"/>
									<c:param name="sortBy" value="asc"/>
								</c:url>" > <img src="<c:url value="/images/up.png"/>" height="10px" width="10px" title="Asc">
							</a>
							First Name
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:if test="${not empty username}">
										<c:param name="username" value="${username}" />
									</c:if>
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="orderBy" value="firstName"/>
									<c:param name="sortBy" value="desc"/>
								</c:url>" > <img src="<c:url value="/images/down.png"/>" height="10px" width="10px" title="Desc">
							</a>
						</th>
						<th>
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:if test="${not empty username}">
										<c:param name="username" value="${username}" />
									</c:if>
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="orderBy" value="middleName"/>
									<c:param name="sortBy" value="asc"/>
								</c:url>" > <img src="<c:url value="/images/up.png"/>" height="10px" width="10px" title="Asc">
							</a>
							Middle Name
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:if test="${not empty username}">
										<c:param name="username" value="${username}" />
									</c:if>
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="orderBy" value="middleName"/>
									<c:param name="sortBy" value="desc"/>
								</c:url>" > <img src="<c:url value="/images/down.png"/>" height="10px" width="10px" title="Desc">				
							</a>
						</th>
						<th>
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:if test="${not empty username}">
										<c:param name="username" value="${username}" />
									</c:if>
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="orderBy" value="lastName"/>
									<c:param name="sortBy" value="asc"/>
								</c:url>" > <img src="<c:url value="/images/up.png"/>" height="10px" width="10px" title="Asc">
							</a>
							Last Name
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="username" value="${username}"/>
									<c:param name="orderBy" value="lastName"/>
									<c:param name="sortBy" value="desc"/>
								</c:url>" > <img src="<c:url value="/images/down.png"/>" height="10px" width="10px" title="Desc">
							</a>
						</th>
						<th>
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="username" value="${username}"/>
									<c:param name="orderBy" value="email"/>
									<c:param name="sortBy" value="asc"/>
								</c:url>" > <img src="<c:url value="/images/up.png"/>" height="10px" width="10px" title="Asc">
							</a>
							Email
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="username" value="${username}"/>
									<c:param name="orderBy" value="email"/>
									<c:param name="sortBy" value="desc"/>
								</c:url>" > <img src="<c:url value="/images/down.png"/>" height="10px" width="10px" title="Desc">
							</a>
						</th>
						<th>
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="username" value="${username}"/>
									<c:param name="orderBy" value="status"/>
									<c:param name="sortBy" value="asc"/>
								</c:url>" > <img src="<c:url value="/images/up.png"/>" height="10px" width="10px" title="Asc">
							</a>
							Status
							<a href="<c:url value="/web/secured/admin/user/view">
									<c:param name="begin" value="${page.currentPage}" />
									<c:param name="username" value="${username}"/>
									<c:param name="orderBy" value="status"/>
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
			
								<td class="td-left">${obj.username}</td>
								<td class="td-left">${obj.roleDesc}</td>
								<td class="td-left">${obj.firstName }</td>
								<td class="td-left">${obj.middleName}</td>
								<td class="td-left">${obj.lastName}</td>
								<td class="td-left">${obj.email}</td>
								<td class="td-center">${obj.statusDesc}</td>
								<td class="td-center">
									<a href="<c:url value="/web/secured/admin/user/edit">
				   							<c:param name="id" value="${obj.username}"/>
				   						</c:url>" id="edit"><img src="<c:url value="/images/icon/edit_icon.png"/>" height="20px" width="20px">
									</a>
								</td>
							</tr>
							</c:forEach>
						</c:when>				
						<c:otherwise>
							<tr>
								<td colspan="8" style="color: red; text-align: center;">No records found.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
	
			<div>
				<c:if test="${not empty page.content}"><div>${page.currentPage}&nbsp;&nbsp;&nbsp;of&nbsp;&nbsp;&nbsp;${page.totalPages}</div></c:if>
				<div style="display: inline;">
					<c:if test="${page.currentPage gt 1}">
						<a href="<c:url value="/web/secured/admin/user/view">
							<c:if test="${not empty search}">
								<c:param name="search" value="${search}" />
							</c:if>
								<c:param name="begin" value="1" />
								<c:param name="orderBy" value="${orderBy}"/>
								<c:param name="sortBy" value="${sortBy}"/>										    							
							</c:url>">First&nbsp;
						</a>
						<a href="<c:url value="/web/secured/admin/user/view">
								<c:if test="${not empty search}">
									<c:param name="search" value="${search}" />
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
						<a href="<c:url value="/web/secured/admin/user/view">
								<c:if test="${not empty search}">
									<c:param name="search" value="${search}" />
								</c:if>
			 							<c:param name="begin" value="${page.currentPage + 1}" />
			 							<c:param name="orderBy" value="${orderBy}"/>
			 							<c:param name="sortBy" value="${sortBy}"/>										    							
			 						</c:url>">
							Next &gt;&gt;
						</a>&nbsp;
						<a href="<c:url value="/web/secured/admin/user/view">
							<c:if test="${not empty search}">
								<c:param name="search" value="${search}" />
							</c:if>
								<c:param name="begin" value="${page.totalPages}" />
								<c:param name="orderBy" value="${orderBy}"/>
								<c:param name="sortBy" value="${sortBy}"/>										    							
							</c:url>">
							Last
						</a>&nbsp;
					</c:if>
				</div>
					<c:if test="${page.totalRecords gt 0}">
						<div>Total Records: <c:out value="${page.totalRecords}"></c:out></div>
					</c:if>		
			</div>
		</div>
	</div>
</div>