<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="taglibs.jsp" %>

<c:choose>
	<c:when test="${mode eq 'changePassword' }">
		<c:choose>
			<c:when test="${not empty errorMsg1 or not empty errorMsg2 or not empty errorMsg3 or not empty errorMsg4}">
				<div class="error changePassword" style="text-align: left;">
					<ul>
					<c:if test="${not empty errorMsg1}">
						<li>${errorMsg1}</li>
					</c:if>
					<c:if test="${not empty errorMsg2}">
						<li>${errorMsg2}</li>
					</c:if>
					<c:if test="${not empty errorMsg3}">
						<li>${errorMsg3}</li>
					</c:if>
					<c:if test="${not empty errorMsg4}">
						<li>${errorMsg4}</li>
					</c:if>
					</ul>
				</div>
			</c:when>
		</c:choose>
		
		<div class="form-bg changePassword">
			<form id="springForm" class="forgotForm changePassword" action="/Oris/web/forgotChangeSubmit" method="post" autocomplete="off">				
				<input type="hidden" name="i" value="${param.i}" />			
				<h2>Change lost password</h2>
				<div class="instructions">
					For security reasons lost passwords cannot be retrieved, but you can set a new password instead. 
					<br/>
					After filling out this form, a confirmation email will be sent to your email address.
					<br/>
					Fill out the following form, and then press submit. All fields are required.
					<div class="formBody changePassword">
						<input class="inputtext inl" name="uname" type="text" placeholder="Username" value="${uname}" />
						<br/><br/>	
						<input class="inputtext inl" name="pword" type="password" placeholder="New Password"/>
						<br/><br/>	
						<input class="inputtext inl" name="confPword" type="password" placeholder="Confirm New Password" />
						<br/><br/>	
						 <div align="center" style="padding-top: 5px;"><a id="btn_forgot" href="#" class="s3d light-blue" style="text-align: center;">SUBMIT</a></div>
					</div>
				</div>
			</form>
		</div>
	</c:when>
	<c:otherwise>
		<div class="error">
			<b>${errorMessage}</b>
		</div>
		<div class="form-bg">
			<form id="springForm" class="forgotForm"  action="/Oris/web/forgotValidate" method="get" autocomplete="off">
				<h2>RESET PASSWORD</h2>
				<div class="instructions">
				To reset your password, enter your username or email below and press submit. 
				You will receive an email shortly with a link to reset your password.
				</div>				
				<div class="formBody">
					<div class="inl">
						<input class="inputtext inl" name="userinput" type="text" placeholder="username / email" />
					</div>
					
					<div align="center" style="padding-top: 5px;"><a id="btn_forgot" href="#" class="s3d light-blue" style="text-align: center;">SUBMIT</a></div>
				</div>
			</form>
		</div>
	</c:otherwise>
</c:choose>



<style type="text/css">
.instructions{
	color : #646464;
	margin: auto;
	width: 95%;
	font-size: 1em;
	font-style: italic;
}

.form-bg.changePassword{
	width: 600px;
	height: 380px;
}


.form-bg form.changePassword{
	width: 595px;
	height: 380px;
}

.form-bg{
	width: 455px;
	margin: auto !important;
}

.form-bg form{
	width: 450px;
	height: 220px;
}

.inputtext{
	height: 30px !important;
	width: 250px;
}

.inl{
	display: inline-block !important;
	text-align: center;
}

.formBody,.error{
	margin: auto;
	/* padding-top: 20px; */
	text-align: center;
}

.error b,.errorText{
	color: #ff0000;
}


</style>