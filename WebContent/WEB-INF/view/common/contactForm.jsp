 <%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/productNav/styles.css"/>">
<script src="<c:url value="/js/productNav/script.js"/>"></script>

<script>
	$('#contact-form').validator();
</script>

	<style>
		h1,h2 {
		 	 margin-top:10px;
		 	 margin-bottom:30px;
			}
			
		.event-header {
		    margin: -53px 167px 0px 100px;
		    padding: 0px 0px 0 397px;
		    font-size: 1.15em;
		    letter-spacing: -0.025em;
		}
		
		.rowProducts {
		    margin: -183px 0 0 135px !important;
		    padding: 36px !important;
		}
		#header{
			padding:1em 0 0 0 !important;
		}	
		#header >h3{
			margin-bottom: .6em !important;
		}
		#imgOr {
		    margin: auto !important;
	   		width: 30% !important;
	   		padding-bottom: 3px !important;
	   	}
		
		span.row-label {
		font-size: 17px;
		}
	</style>
	
<div id="page-wrapper">
		<!-- Header -->
		<div id="header">
			<!-- Logo -->
			<h3>
				<a href="<c:url value="/web/home"/>" id="logo">
				<img class="img-responsive" id ="imgOr" src="<c:url value="/images/oris_logo.png"/>" /></a>
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
									<li class='has-sub'><a href="<c:url value="/web/view/contact/form"/>"><span>EMAIL US</span></a></li>
									<li class='has-sub'><a href="<c:url value="/web/view/contact/callUs"/>"><span>CALL US</span></a></li>
									<li class='has-sub'><a href="<c:url value="/web/view/contact/corporateOffice"/>"><span>CORPORTATE OFFICE</span></a></li>
								</ul>
							</div>
						</section>
					</div>
				</div>
				
<form:form id="contactSend_form"  class="form-horizontal" action="/Oris/web/view/contact/form/send" method="post" commandName="sendCommand">				
				<!-- PRODUCT AND SERVICES MENU W/O ID -->
				<div class="rowProducts"><br>
					
					<div class="event-header">
						<h2> What can we do for you?</h2>
					</div>
					
					<div class="col-lg-12">
	         				<div class="form-group">
								<label class="col-lg-4 control-label"></label>
								<div class="col-lg-7">
									<textarea name="message" id="message" rows="5"></textarea>
								</div>
							</div>
						</div>
					
					<div class="event-header">
						<h2>Contact Information</h2>
					</div>
					
					<br>
					
					<div class ="col-lg-12">
				 		
						<div class="col-lg-12">
								<div class="form-group">
							        <label class="col-lg-4 control-label">First Name</label>
						            <div class="col-lg-7">	               
						                <form:input path="firstName" cssClass="form-control" required="" />
						         	</div>			
								</div>
						</div>
						<div class="col-lg-12">
								<div class="form-group">
							         <label class="col-lg-4 control-label">Middle Name</label>   
						            <div class="col-lg-7">
						                <form:input path="middleName" cssClass="form-control" required="" />
						            </div>
					            </div>
					    </div>
					    <div class="col-lg-12">
							    <div class="form-group">
							        <label class="col-lg-4 control-label">Last Name</label>
					                <div class="col-lg-7">
						               <form:input path="lastName" cssClass="form-control" required="" />
						            </div>
							   	</div>
					    </div>
						   
				         <div class="col-lg-12">
			         			<div class="form-group">
							        <label class="col-lg-4 control-label">Email</label>
					      			<div class="col-lg-7">
						      			<form:input path="email" cssClass="form-control" required="" />
						      		</div>
						     	 </div>
						 </div> 	
						 <div class="col-lg-12">
					         	<div class="form-group">
							        <label class="col-lg-4 control-label">Contact Number</label>
						        	<div class="col-lg-7">
						      			<form:input path="contactNo" cssClass="form-control" maxlength="11" required=""  />
						      		</div>
					      		</div>
			      		 </div>
			      		  <div class="col-lg-12">
					         	<div class="form-group">
							        <label class="col-lg-4 control-label">Alternative Contact Number</label>
						        	<div class="col-lg-7">
						      			<form:input path="alcontactNo" cssClass="form-control" maxlength="11" />
						      		</div>
					      		</div>
			      		 </div>
			      		 
			      		
			    	</div>
			    
		
			    	<div class="form-group">
			    		<br><br>
			    		<label class="col-lg-3 control-label">&nbsp;</label>
		      			<div class="col-lg-10 regButton">
			                <button type="submit" class="btn btn-primary" value ="send">Submit</button>
			         	</div>
		        	</div>
				</div>
				</form:form>
			</div>
		</div>
	</section>
</div>
<br style="clear: both;"/>

	<!-- </section>
			<div class="container col-lg-5">	
				<section class="container">
					<div class="container">
						<div class="row">
							<div class="rowMenu">
								<div id="sidebar">
									<section>
										<div id='cssmenu'>
											<ul>
											<label>Email Us</label>
											<br>
											<label> Call Us</label>
											<br>
											<label> Corporate Office</label>
											</ul>
										</div>
									</section>
								</div>
							</div>        
				        </div>
			       </div>
			  </section>
			</div> -->
<%-- </form:form>
<form:form id="contactSend_form"  class="form-horizontal" action="/Oris/web/view/contact/form/send" method="post" commandName="sendCommand">
		<div class="container">	
			<div id="myTabContent" class="tab-content">
				 <div class="tab-pane fade in active" id="step-1">
						<div class="col-lg-12">
				                
				         </div>
				         
				    <div class="col-lg-10">
					<div class="form-group">
					<label class="col-lg-4 control-label"> What can we do for you?</label>
						<textarea class="col-lg-7"  name="message" id="message"
							rows="5"></textarea>
							</div>
					</div>
				</div>				   
				         <div class="col-lg-10">
			         			<div class="form-group">
							        <label class="col-lg-4 control-label">Email</label>
					      			<div class="col-lg-7">
						      			<form:input path="email" cssClass="form-control" required="" />
						      		</div>
						     	 </div>
						 </div> 	
						 <div class="col-lg-10">
					         	<div class="form-group">
							        <label class="col-lg-4 control-label">Mobile Phone #</label>
						        	<div class="col-lg-7">
						      			<form:input path="contactNo" cssClass="form-control" maxlength="11" />
						      		</div>
					      		</div>
			      		 </div>
			      		<div class="col-lg-10">
								<div class="form-group">
							        <label class="col-lg-4 control-label">First Name</label>
						            <div class="col-lg-7">	               
						                <form:input path="firstName" cssClass="form-control"/>
						         	</div>			
								</div>
						</div>
						<div class="col-lg-10">
								<div class="form-group">
							         <label class="col-lg-4 control-label">Middle Name</label>   
						            <div class="col-lg-7">
						                <form:input path="middleName" cssClass="form-control"/>
						            </div>
					            </div>
					    </div>
					    <div class="col-lg-10">
							    <div class="form-group">
							        <label class="col-lg-4 control-label">Last Name</label>
					                <div class="col-lg-7">
						               <form:input path="lastName" cssClass="form-control"/>
						            </div>
							   	</div>
					    </div>
			    	</div>
			    
		
			    	<div class="form-group">
			    		<br><br>
			    		<label class="col-lg-3 control-label">&nbsp;</label>
		      			<div class="col-lg-10 regButton">
			                <button type="submit" class="btn btn-primary" value ="send">Submit</button>
			         	</div>
		        	</div>
		     	</div>
		</form:form>
</div> --%>

<%@include file="footer.jsp"%>