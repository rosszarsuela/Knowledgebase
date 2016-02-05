<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<%@include file="../mis/misNav.jsp"%>

<li id="main-nav-list">
	<img src="<c:url value="/images/icon/mis.png"/>" height="20px" width="20px" style="vertical-align: middle;">
	<a href="#" id="main-nav-a" rel="personnel">MIS</a>
	
	<ul class="sub-nav">
		<security:authorize ifAnyGranted="SYSTEM_ADMIN">
			<li id="sub-nav-list">
				<a href="<c:url value="/web/secured/admin/user/view"/>" id="sub-nav-a">User</a>
			</li>
			<li id="sub-nav-list">
				<a href="<c:url value="/web/secured/admin/doctor/view"/>" id="sub-nav-a">Educators</a>
			</li>
			<li id="sub-nav-list">
				<a href="<c:url value="/web/secured/admin/consultant/view"/>" id="sub-nav-a">Consultants</a>
			</li>
			<li id="sub-nav-list">
				<a href="<c:url value="/web/secured/admin/customer/view"/>" id="sub-nav-a">Customer</a>
			</li>
			<li id="sub-nav-list">
				<a href="<c:url value="/web/secured/admin/solution/view"/>" id="sub-nav-a">Solution</a>
			</li>
			<li id="sub-nav-list">
				<a href="<c:url value="/web/secured/admin/solution/category/view"/>" id="sub-nav-a">Solution's Category</a>
			</li>
			<li id="sub-nav-list">
				<a href="<c:url value="/web/secured/admin/brand/view"/>" id="sub-nav-a">Brand</a>
			</li>
			<li id="sub-nav-list">
				<a href="<c:url value="/web/secured/admin/product/view"/>" id="sub-nav-a">Product</a>
			</li>
			<li id="sub-nav-list">
				<a href="<c:url value="/web/secured/admin/event/view"/>" id="sub-nav-a">Event</a>
			</li>
		</security:authorize>
	</ul>
</li>