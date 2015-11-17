<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>
<style>
	
	body{
		background: rgba(0,0,0,.8); /* Chrome,Safari4+ */
	}

</style>


<div id="page-wrapper">
	<!-- Header -->
	<div id="header">
		<!-- Logo -->
		<h3>
			<a href="<c:url value="/web/home"/>" id="logo">
			<font face="Arial"><b>ORIS Oral Implant Solutions Inc</b></font></a>
		</h3>
		<%@include file="../mis/misNav.jsp"%>
	</div>
</div>


<%-- <div id="header" style="text-align: center">REMINDERS</div>
<br />
<table align="center" class="tablecat" style="color: white;"
	width="100%">
	<tr>
		<th><a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="1" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="fromUser.username"/>
										    							<c:param name="sortBy" value="asc"/>
										    						</c:url>">
				<img src="<c:url value="/images/up.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a> From <a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="${page.currentPage}" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="fromUser.username"/>
										    							<c:param name="sortBy" value="desc"/>
										    						</c:url>">
				<img src="<c:url value="/images/down.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a></th>
		<th><a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="1" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="toUser.username"/>
										    							<c:param name="sortBy" value="asc"/>
										    						</c:url>">
				<img src="<c:url value="/images/up.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a> To <a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="${page.currentPage}" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="toUser.username"/>
										    							<c:param name="sortBy" value="desc"/>
										    						</c:url>">
				<img src="<c:url value="/images/down.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a></th>
		<th><a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="1" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="module"/>
										    							<c:param name="sortBy" value="asc"/>
										    						</c:url>">
				<img src="<c:url value="/images/up.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a> Module <a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="${page.currentPage}" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="module"/>
										    							<c:param name="sortBy" value="desc"/>
										    						</c:url>">
				<img src="<c:url value="/images/down.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a></th>
		<th><a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="1" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="description"/>
										    							<c:param name="sortBy" value="asc"/>
										    						</c:url>">
				<img src="<c:url value="/images/up.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a> Description <a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="${page.currentPage}" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="description"/>
										    							<c:param name="sortBy" value="desc"/>
										    						</c:url>">
				<img src="<c:url value="/images/down.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a></th>
		<th><a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="1" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="startDate"/>
										    							<c:param name="sortBy" value="asc"/>
										    						</c:url>">
				<img src="<c:url value="/images/up.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a> Start Date <a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="${page.currentPage}" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="startDate"/>
										    							<c:param name="sortBy" value="desc"/>
										    						</c:url>">
				<img src="<c:url value="/images/down.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a></th>

		<th><a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="1" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="endDate"/>
										    							<c:param name="sortBy" value="asc"/>
										    						</c:url>">
				<img src="<c:url value="/images/up.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a> End Date <a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="${page.currentPage}" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="endDate"/>
										    							<c:param name="sortBy" value="desc"/>
										    						</c:url>">
				<img src="<c:url value="/images/down.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a></th>

		<th><a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="1" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="status"/>
										    							<c:param name="sortBy" value="asc"/>
										    						</c:url>">
				<img src="<c:url value="/images/up.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a> Status <a
			href="<c:url value="/hmo/secured/tat/view">
										    							<c:param name="begin" value="${page.currentPage}" />
										    							<c:param name="username" value="${username}"/>
										    							<c:param name="orderBy" value="status"/>
										    							<c:param name="sortBy" value="desc"/>
										    						</c:url>">
				<img src="<c:url value="/images/down.png"/>" height="10px"
				width="10px" title="Edit"> &nbsp; </a></th>

		<th>Action</th>
	</tr>

	<c:choose>
		<c:when test="${not empty reminderList }">
			<c:forEach items="${reminderList }" var="obj" varStatus="index">
				<c:choose>
					<c:when test="${index.count%2 ne 0}">
						<tr class="oddrowcolor">
					</c:when>

					<c:otherwise>
						<tr class="evenrowcolor">
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${obj.moduleDesc eq 'HOTLINE'}">
						<c:if test="${obj.status == 1}">
							<td>${obj.fromUser.username}</td>
							<td>${obj.toUser.username}</td>
							<td>${obj.moduleDesc}</td>
							<td>${obj.description}</td>
							<td><fmt:formatDate value="${obj.startDate}" type="date" />
							</td>
							<td><fmt:formatDate value="${obj.endDate}" type="date" /></td>
							<td><c:choose>
									<c:when test="${obj.status eq 1 }">
											ACTIVE
										</c:when>

									<c:otherwise>
											INACTIVE
										</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${fn:contains(obj.description, 'DPC')}">
										<a
											href="<c:url value="/hmo/secured/hotline/search/all">
													<c:param name="module" value="dpc"/>
													<c:param name="search" value="${obj.transactionNo}"/>
					    							<c:param name="begin" value="1" />
					    							<c:param name="orderBy" value="id"/>
					    							<c:param name="sortBy" value="asc"/>
					    						</c:url>"
											title="View Pending"><img
											src="<c:url value="/images/search.png"/>" height="20px"
											width="20px"> </a>
									</c:when>
									<c:otherwise>
										<a
											href="<c:url value="/hmo/secured/hotline/search/all">
					    							<c:param name="module" value="loa"/>
													<c:param name="search" value="${obj.transactionNo}"/>
					    							<c:param name="begin" value="1" />
					    							<c:param name="orderBy" value="id"/>
					    							<c:param name="sortBy" value="asc"/>
					    						</c:url>"
											id="edit"><img src="<c:url value="/images/search.png"/>"
											height="20px" width="20px"> </a>
									</c:otherwise>
								</c:choose></td>
						</c:if>
					</c:when>
					<c:when test="${obj.moduleDesc ne 'HOTLINE'}">
						<td>${obj.fromUser.username}</td>
						<td>${obj.toUser.username}</td>
						<td>${obj.moduleDesc}</td>
						<td>${obj.description}</td>
						<td><fmt:formatDate value="${obj.startDate}" type="date" /></td>
						<td><fmt:formatDate value="${obj.endDate}" type="date" /></td>
						<td><c:choose>
								<c:when test="${obj.status eq 1 }">
										ACTIVE
									</c:when>

								<c:otherwise>
										INACTIVE
									</c:otherwise>
							</c:choose></td>
						<td><a
							href="<c:url value="/hmo/secured/tat/edit">
		    							<c:param name="begin" value="${page.totalPages}" />
		    							<c:param name="orderBy" value="${orderBy}"/>
		    							<c:param name="sortBy" value="${sortBy}"/>
		    							<c:param name="id" value="${obj.id}"/>
		    							<c:param name="username" value="${username}"/>
		    						</c:url>"
							id="edit"><img
								src="<c:url value="/images/icon/edit_icon.png"/>" height="20px"
								width="20px"> </a></td>
					</c:when>
				</c:choose>
				</tr>
			</c:forEach>
		</c:when>

		<c:otherwise>
			<tr>
				<td colspan="8">No Reminders</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table> --%>
