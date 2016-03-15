<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <title></title>

        <!-- DESIGN #1 -->
        <%-- <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/nav.css"/>" media="all"/> --%>
        
        <!-- DESIGN #2 -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
        <script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery.dropotron.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/skel.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/util.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/main.js"/>"></script>
        <%-- <script type="text/javascript" src="<c:url value="/js/bootstrap-filestyle.js"/>"></script> --%>
        <script type="text/javascript" src="<c:url value="/js/validator.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/validator.min.js"/>"></script>
        
        <!-- CAROUSEL -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        
		<%-- <link rel="stylesheet" href="<c:url value="/css/carousel/bootstrap.min.css"/>">
		<link rel="stylesheet" href="<c:url value="/css/carousel/bootstrap-theme.min.css"/>">
		<script src="<c:url value="/js/carousel/jquery.min.js"/>"></script>
		<script src="<c:url value="/js/carousel/bootstrap.min.js"/>"></script> --%>

		<%--jQuery Core Library --%>
        <%-- <script type="text/javascript" src="<c:url value="/js/jquery/jquery-1.7.1.min.js"/>"></script> --%>

        <%--jQuery UI Library --%>
        <script type="text/javascript" src="<c:url value="/js/jquery/jquery-ui-1.8.18.custom.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery/date.js"/>"></script>
        
        <!-- Load Javascript -->
		<%-- <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery.query-2.1.7.js"/>"></script> --%>
		
        <%-- <script type="text/javascript" src="<c:url value="/js/common/maskingAndValidation.js"/>"></script> --%>

        <%-- Oris Library --%>
        <script type="text/javascript" src="<c:url value="/js/common/common.js"/>"></script>
        
        <%--DWR Javascript --%>
        <script type="text/javascript" src="<c:url value="/dwr/engine.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/dwr/util.js"/>"></script>
        
        <%-- <script type="text/javascript" src="<c:url value="/dwr/engine.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/dwr/util.js"/>"></script> --%>
        <%-- <script type="text/javascript" src="<c:url value="/dwr/interface/dwrService.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/dwr/dwr.js"/>"></script> --%>
        
        <%-- Responsive JS --%>
        <%-- <script src="<c:url value="/js/jquery-1.11.1.min.js"/>"></script> --%>
        <script src="<c:url value="/js/jquery.easydropdown.js"/>"></script>
        <script src="<c:url value="/js/move-top.js"/>"></script>
        <script src="<c:url value="/js/easing.js"/>"></script>
        
        <script type="text/javascript" src="<c:url value="/js/bootstrap-filestyle.js"/>"></script>
        
        <!-- HOME ICON DESIGN -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <%-- <link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css"/>"> --%>
        <%-- <link rel="stylesheet" type="text/css" href="<c:url value="/productNav/css.css"/>"> --%>
        
        
        <!-- FORM VALIDATION -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/forms/formValidation.css"/>">
		<script type="text/javascript" src="<c:url value="/js/forms/formValidation.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/forms/bootstrap.js"/>"></script>
		
		<!-- DESIGN #2 -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>">
		 <link rel="stylesheet" type="text/css" href="<c:url value="/css/fonts.css"/>">
		
        <script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});

				$().UItoTop({ easingType: 'easeOutQuart' });
				
				$("span.menu").click(function() {
					$(" ul.nav").slideToggle("fast", function() {
					});
				});
			});
		</script>
    </head>

    <body>
        <div id="errorDialog" title="Error Message" style="display: none;">
            <p id="message" style="color: red; font-weight: bold; font-size: 15px;"></p>
        </div>
        <div id="infoDialog" title="Info Message" style="display: none;">
            <p id="message" style="color: red; font-weight: bold; font-size: 15px;"></p>
        </div>
        <div id="confirmDialog" title="Confirm Message" style="display: none;">
            <p id="message" style="color: red; font-weight: bold; font-size: 15px;"></p>
            <div id="detail"></div>
        </div>
        
        <div id="confirmThis-dialog" title="Confirm"></div>
        
        <div id="pleaseWaitContainer" style="opacity:0.1; filter: alpha(opacity=0); /* ie */ -moz-opacity: 0.0; /* mozilla */background: #000000; width: 100%;height: 100%;position:absolute;z-index: 99998;display: none;" >
		</div>
		
		<%-- <div id="pleaseWaitGif" style="position: absolute;top:-20px;left:50%;margin-left: -177px;z-index: 99999;display: none;">
			<img alt="Loading" src="<c:url value='/images/icon/loading.gif'/>">
		</div> --%>
		
		 <!-- IMAGE MODAL -->
        <div class="modal fade" id="imagemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                
              </div>
              <div class="modal-body">
                <img class="img-responsive">
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>
          </div>
        </div>
		
        <noscript>Your browser does not support JavaScript! Some functions will not work properly.</noscript>
		
		<input type="hidden" id="principalUser" value="${principalUser}"/>
		<input type="hidden" id="roleName" value="${roleName}"/>
		<input type="hidden" id="activeMenu" value="${activeMenu}"/>
		<input type="hidden" id="notif"/>
		
        <%--General Messages --%>
        <c:if test="${message ne null and message ne ''}">
            <script type="text/javascript">
           		promptErrorMessage(<c:out value="${message}"/>);
            </script>
        </c:if>

        <%--Header --%>
        <div id="header_wrap">
            <div class="top_bar">                
                <div class="logout_bar" style="float: right; color: black;">
                	  <security:authorize ifNotGranted="ANONYMOUS">
				            <c:out value="${loggedUser} "/>
                            &nbsp;|&nbsp;
                            <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>&nbsp;&nbsp;
                        </security:authorize>
                        
                        <span id="sysDate" style="color: white;">&nbsp;</span>&nbsp;
                        <span id="clock" style="color: white;">&nbsp;</span>
            	</div>
            </div>
        </div>
		<tiles:insertAttribute name="body" />		
    </body>
</html>