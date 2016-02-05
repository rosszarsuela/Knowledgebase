<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<script type="text/javascript" src="<c:url value="/js/common/eventRegValidator.js"/>"></script>
	<style>
		h1,h2,h3 {
		 	 margin-top:10px;
		 	 margin-bottom:10px;
			}
			
		div.center {
			margin-left: 31%;
			margin-right: -20%;
			}
			
		div.t {
			text-align: center;
			}
		
		img		{
		    max-width:400px;
		    max-height:250px;
		    
		}
		
	</style>
	
	<div id="page-wrapper">
			<!-- Header -->
			<div id="header">
				<!-- Logo -->
				<h3>
					<a href="<c:url value="/web/home"/>" id="logo">
					<font face="Arial"><b>ORIS Oral Implant Solutions Inc</b></font></a>
				</h3><br>
				<%@include file="homeNav.jsp"%>
			</div>
	</div>
	
	<br><br>
	
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
</div>
	 
<form:form id="contact_form"  class="form-horizontal" action="/Oris/web/view/contact/form" method="get" commandName="sendCommand">
	
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
<br><br><br>
 --%>
 
 <%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="taglibs.jsp"%>
<script>
	$('#contact-form').validator();
</script>

	<style>
		h1,h2,h3 {
		 	 margin-top:10px;
		 	 margin-bottom:30px;
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
				<%@include file="homeNav.jsp"%>
			</div>
	<br><br>
<form:form id="contact_form"  class="form-horizontal" action="/Oris/web/view/contact/form" method="get" commandName="sendCommand">	
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
			</div>
</form:form>
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
</div>

<%@include file="footer.jsp"%>