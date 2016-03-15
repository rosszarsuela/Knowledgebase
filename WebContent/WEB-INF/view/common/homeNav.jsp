<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/common/common.js"/>"></script>
<style>

	.dropdown-menu>li> a:hover {
		background-color: #262626;
	}
	.dropdown-menu>li>a:hover{
	background-color:#e8e8e8 !important;
	background-image:-webkit-linear-gradient(top,#262626 0,#262626 100%) !important;
	background-image:-o-linear-gradient(top,#262626 0,#262626 100%) !important;
	background-image:-webkit-gradient(linear,left top,left bottom,from(#262626),to(#262626)) !important;
	background-image:linear-gradient(to bottom,#262626 0,#262626 100%) !important;
</style>

<nav id="nav">
	<ul>
		<li id="home"><a href="<c:url value="/web/home"/>">HOME</a></li>
		<li id="about"><a href="<c:url value="/web/about"/>">ABOUT US</a></li>
		<li id="product"><a href="<c:url value="/web/view/portfolio"/>">PRODUCT &amp; SERVICES</a></li>
		
		<li id="educators"><a class="dropdown-toggle" data-toggle="dropdown">EDUCATORS<span class="caret"></span><span></span></a>
			<ul class="dropdown-menu">
			 	
			 	 	<c:forEach items="${educatorList}" var="obj" varStatus="index">
						<li>
							<a class="dropdown-toggle" data-toggle="dropdown" style="text-align: left" href="<c:url value="/web/view/mentors">
								<c:param name="begin" value="${index.count}"/>
		   						</c:url>"><span><c:out value="${obj.completeName}"/></span>
							</a>
						</li>
					</c:forEach>
				
		      	<li><a style="text-align: left" href="<c:url value="/web/view/consultants"/>">Professional Service Consultants</a></li>
	        </ul>
        </li>
		
		<li id="events"><a href="<c:url value="/web/view/events" />"> TRAINING & EVENTS</a></li>
		<li id="contact"><a href="<c:url value="/web/contact"/>">CONTACT US</a></li>
		<li id="testimonials"><a href="<c:url value="/web/testimonials"/>">TESTIMONIALS</a></li>
	</ul>
</nav>
		