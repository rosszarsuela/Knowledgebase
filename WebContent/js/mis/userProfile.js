$(document).ready(function() {
	
	$('#username').live('change', function() {
		var username = $(this).val();
		misDWRService.isUserExists(username, function(data) {
			if(data && !$('#user').val()) {
				promptInfoMessage('Username '+ username + ' is already existing!');
				$('#username').val('');
			}
		});
	});
	
	$('#email').live('change', function() {
		var email = $(this).val();
		misDWRService.isUserEmailExists(email, function(data) {
			if(data) {
				promptInfoMessage('E-mail ' + email + ' is already existing!');
				$('#email').val('');
				
				$('.ui-icon-closethick').click(function() {
					$('#email').focus();
				});
			}
		});
	});
	
	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {
			confirmDialogBox("Do you want to save?",140,350);
			$('#confirmDialog').dialog('open');
			
			$('.ui-dialog-buttonset').find('.ui-button').live('click', function() {
				var answer = $(this).find('.ui-button-text').text();
				if(answer === 'OK') {
					document.forms["user_form"].submit();
				}
			});
		}
	});
	
	
	function checkRequiredFields() {
		var ctr = 0;
		var errorMessage = "";
		
		if(checkValue($('#firstName').val(), $('#firstName'))) {
			ctr++;
		}
		
		if(checkValue($('#middleName').val(), $('#middleName'))) {
			ctr++;
		}
		
		if(checkValue($('#lastName').val(), $('#lastName'))) {
			ctr++;
		}
		
		if(checkValue($('#email').val(), $('#email'))) {
			ctr++;
		} else {
			if(validateEmail($('#email').val())) {
				errorMessage += "&bull; Invalid email format.</br>";
				ctr++;
			}
		}
		
		if(checkValue($('#username').val(), $('#username'))) {
			ctr++;
		}
		
		if(checkValue($('#password').val(), $('#password'))) {
			ctr++;
		}
		
		if(checkValue($('#confirmPassword').val(), $('#confirmPassword'))) {
			ctr++;
		}
		
		if($('#password').val() != $('#confirmPassword').val()) {
			errorMessage += "&bull; Password and Confirm password doesn't match.";
			ctr++;
		}
		
		if(errorMessage) {
			promptInfoMessage(errorMessage);
		}
		
		if(ctr > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	function validateEmail(value) {
		if(value) {
			if(!emailReg.test(value)) {
				return true;
			}
		}
		return false;
	}
});