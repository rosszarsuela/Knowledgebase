<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/common/common.js"/>"></script>

<nav id="nav">
	<ul>
		<li id="home"><a href="<c:url value="/web/home"/>">HOME</a></li>
		<li id="about"><a href="<c:url value="/web/about"/>">ABOUT US</a></li>
		<li id="product"><a href="<c:url value="/web/view/portfolio"/>">PRODUCT &amp; SERVICES</a></li>
		
		<li id="educators"><a class="dropdown-toggle" data-toggle="dropdown">EDUCATORS
				<span class="caret"><span></span></a>
			 
			 <ul class="dropdown-menu">
			 	<%--  <li><a class="dropdown-toggle" data-toggle="dropdown" href="<c:url value="/web/view/mentors"/>">test</a></li> --%>
			 	 	<c:forEach items="${educatorList}" var="obj" varStatus="index">
						<li>
							<a class="dropdown-toggle" data-toggle="dropdown" href="<c:url value="/web/view/mentors">
		   							<c:param name="doctor.id" value="${obj.id}"/>
		   						</c:url>"><span><c:out value="${obj.completeName}"/></span>
							</a>
						</li>
					</c:forEach>
				
		      	<li><a href="<c:url value="/web/view/consultants"/>">CONSULTANTS</a></li>
	        </ul>
        </li>
		
		<li id="events"><a href="<c:url value="/web/view/events"/>">TRAINING & EVENTS</a></li>
		<li id="contact"><a href="<c:url value="/web/contact"/>">CONTACT US</a></li>
		<li id="faq"><a href="<c:url value="#"/>">FAQ</a></li>
	</ul>
</nav>

<!-- <li id="training"><a href="#">TRAINING</a></li> -->
<%--<li id="solutions"><a href="<c:url value="/web/view/solutions"/>">SOLUTIONS</a></li> --%>
		