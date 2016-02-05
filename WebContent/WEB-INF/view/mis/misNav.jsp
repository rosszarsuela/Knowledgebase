<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/common/common.js"/>"></script>
<%-- <div class="logo">
	<a href="index.html"> <img src="<c:url value="/images/logo.png"/>" alt=""></a>
	Oris Oral Implant Solutions
</div>

<span class="menu"> Menu</span>
<div class="banner-top">
	<ul class="nav banner-nav">
		<li><a href="<c:url value="/web/secured/admin/user/view"/>">USER</a></li>
		<li><a href="<c:url value="/web/secured/admin/doctor/view"/>">MENTOR</a></li>
		<li><a href="<c:url value="/web/secured/admin/customer/view"/>">CUSTOMER</a></li>
		<li><a href="<c:url value="/web/secured/admin/solution/view"/>">SOLUTION</a></li>
		<li><a href="<c:url value="/web/secured/admin/solution/category/view"/>">SOLUTION'S CATEGORY</a></li>
		<li><a href="<c:url value="/web/secured/admin/brand/view"/>">BRAND</a></li>
		<li><a href="<c:url value="/web/secured/admin/product/view"/>">PRODUCT</a></li>
		<li><a href="<c:url value="/web/secured/admin/event/view"/>">EVENT</a></li>
	</ul>
</div>
<div class="clearfix"></div> --%>

<%-- <nav id="nav">
	<ul>
		<li id="training">
			<a href="#">MIS</a>
			<ul>
				<li><a href="<c:url value="/web/secured/admin/user/view"/>">USERS</a></li>
				<li><a href="<c:url value="/web/secured/admin/doctor/view"/>">MENTORS</a></li>
				<li><a href="<c:url value="/web/secured/admin/customer/view"/>">CUSTOMER</a></li>
				<li><a href="<c:url value="/web/secured/admin/solution/view"/>">SOLUTION</a></li>
				<li><a href="<c:url value="/web/secured/admin/solution/category/view"/>">SOLUTION'S CATEGORY</a></li>
				<li><a href="<c:url value="/web/secured/admin/brand/view"/>">BRAND</a></li>
				<li><a href="<c:url value="/web/secured/admin/product/view"/>">PRODUCT</a></li>
				<li><a href="<c:url value="/web/secured/admin/event/view"/>">EVENT</a></li>
			</ul>
		</li>
		<li id="logout">
			<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>			
		</li>
	</ul>
</nav> --%>

<nav id="nav">
	<ul>
		<li id="training">
				<li><a href="<c:url value="/web/secured/admin/user/view"/>">USERS</a></li>
				<li><a href="<c:url value="/web/secured/admin/doctor/view"/>">MENTORS</a></li>
				<li><a href="<c:url value="/web/secured/admin/consultant/view"/>">CONSULTANTS</a></li>
				<li><a href="<c:url value="/web/secured/admin/customer/view"/>">CUSTOMER</a></li>
				<li><a href="<c:url value="/web/secured/admin/solution/view"/>">SOLUTION</a></li>
				<li><a href="<c:url value="/web/secured/admin/solution/category/view"/>">SOLUTION'S CATEGORY</a></li>
				<li><a href="<c:url value="/web/secured/admin/brand/view"/>">BRAND</a></li>
				<li><a href="<c:url value="/web/secured/admin/product/view"/>">PRODUCT</a></li>
				<li><a href="<c:url value="/web/secured/admin/event/view"/>">EVENT</a></li>
				<li><a href="<c:url value="/web/secured/admin/videos/form"/>">VIDEO LINKS</a></li>
		</li>
		<li id="logout">
		<%-- 	<a href="<c:url value="/j_spring_security_logout"/>">LOGOUT</a>			 --%>
		</li>
	</ul>
</nav>
