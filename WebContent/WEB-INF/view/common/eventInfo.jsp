<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/taglibs.jsp" %>
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
	
<form:form id="event_form" action="/Oris/web/view/event/info" method="get" commandName="eventCommand">
		<div class="container">	
			
			<%-- <div class="form-group control-label">
		            <div class="center">
		                <img class="img-responsive" src="<c:out value="${eventCommand.imageContent}"/>" />
		            </div>
	        </div> --%>
	       
	       <div class="info-reg"> 
		        <div class="panel panel-info">
		            <div class="panel-heading">
		           		<img src="<c:url value="/images/icon/info_trans.png"/>" height="20px" width="20px">&emsp;INFORMATION
		           	</div>
			           	<div class="panel-body">
			           		<b><font face="Arial" size="3">
		            		<p> Please Fill out the Fields for registration & you will receive an e-mail 
		            		shortly confirming your registration status	</p></font></b>
		           		</div>
		       </div>
	       </div>
		    
		    <div class="control-label">
	            <div class="t">
	            	<b><font face="Arial" size="5"><c:out value="${eventCommand.name}"/></font></b>
	            	
	            </div>
			</div>
			
			<div class="form-group">
				<div class="control-label">
		            <div class="t">
				      <font face="Arial" size="4"><c:out value="${eventCommand.description}"/></font>
	            	</div>
				</div>
		    </div>
		</div>
</form:form>   
	 
<form:form id="eventRegistration_form" enctype="multipart/form-data" class="form-horizontal" action="/Oris/web/view/event/info/registration" method="post" commandName="registerCommand">
	<form:hidden path="event.id" value="${eventCommand.id}"/>
		<c:if test="${not empty participantId}">
			<form:hidden path="id" />
		</c:if>
		
	<div class="container">	
		<div class="rowReg">
			<div class="rowReg-content">
				<ul id="myTab" class="nav nav-tabs">
					 <li class="active"><a href="#step-1" data-toggle="tab">Step 1</a></li>
					 <li><a href="#step-2" data-toggle="tab">Step 2</a></li>
					 <li><a href="#step-3" data-toggle="tab">Step 3</a></li>
				</ul>
			</div>
			
			<div id="myTabContent" class="tab-content">
				 <div class="tab-pane fade in active" id="step-1">
						<div class="col-lg-12">
				                <div class="page-headerRegister">
				                    <h2>EVENT & TRAINING PROGRAM REGISTRATION</h2>
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
			    
			 <div class="tab-pane fade" id="step-2">	   
					   <div class="col-lg-12">
				                <div class="page-headerClinical">
				                    <h2>CLINICAL ADDRESS INFORMATION</h2>
				                </div>
			           </div>
	           
			            <div class="col-lg-10">
							    <div class="form-group">
							        <label class="col-lg-4 control-label">No./Unit#/Building</label>
					                <div class="col-lg-7">
						               <form:input path="building" cssClass="form-control"/>
						            </div>
							   	</div>
					    </div>
					    
					     <div class="col-lg-10">
							    <div class="form-group">
							        <label class="col-lg-4 control-label">Street</label>
					                <div class="col-lg-7">
						               <form:input path="street" cssClass="form-control"/>
						            </div>
							   	</div>
					    </div>
					    
					     <div class="col-lg-10">
							    <div class="form-group">
							        <label class="col-lg-4 control-label">City</label>
					                <div class="col-lg-7">
						               <form:input path="city" cssClass="form-control"/>
						            </div>
							   	</div>
					    </div>
					    
					     <div class="col-lg-10">
							    <div class="form-group">
							        <label class="col-lg-4 control-label">Province</label>
					                <div class="col-lg-7">
						               <form:input path="province" cssClass="form-control"/>
						            </div>
							   	</div>
					    </div>
					    
					    <div class="col-lg-10">
							    <div class="form-group">
							        <label class="col-lg-4 control-label">Landline</label>
					                <div class="col-lg-7">
						               <form:input path="landline" cssClass="form-control"/>
						            </div>
							   	</div>
					    </div>
				</div>
			    
		     	<div class="tab-pane fade" id="step-3">
				    <%-- <c:if test="${not empty participantId}"> --%>
				    	<div class="col-lg-12">
			                <div class="page-headerCharges">
			                   <h2>SUMMARY OF CHARGES</h2>
			                </div>
			            </div>
			        
				        <div class="col-lg-10">
							    <div class="col-lg-9 col">
					                <div class="col-lg-12 regMessage">
									<b><c:out value="${paymentMessage}"/><br>
										<c:out value="${accountName}"/><br>
										<c:out value="${accountNo}"/></b>
						            </div>
							   	</div>
					    </div>
				    	
				    	<div class="col-lg-9 depositBox">
							<div class="form-group">
				    			<label class="col-lg-5 control-label" for="name">Deposit Slip</label> 
				    			<input type="file" class="filestyle" id="image" name="image" data-buttonName="btn-primary"/><br>
							</div>
						</div>
				    <%-- </c:if> --%>
		
				    <div class="col-lg-12">
			                <div class="page-headerCoupon">
			                    <h2>COUPON</h2>
			                </div>
		            </div>
		            
		            <div class="col-lg-11">
						    <div class="form-group">
						        <label class="col-lg-4 control-label">Coupon</label>
				                <div class="col-lg-5">
					               <form:input path="coupon" cssClass="form-control"/>
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
	       	</div>
       	</div>
   	</div> 
</form:form>
<br><br><br>


