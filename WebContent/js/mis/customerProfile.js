$(document).ready(function() {
	
	$('#name').live('change', function() {
		var name = $(this).val();
		misDWRService.isCustomerExists(name, function(data) {
			if(data) {
				promptErrorMessage(name + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','150px');
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#name').val('');
			$('#name').focus();
		});
	});
	
	$('#email').live('change', function() {
		var email = $(this).val();
		misDWRService.isCustomerExists(email, function(data) {
			if(data) {
				promptErrorMessage('E-mail ' + email + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','150px');
				
				$('.ui-icon-closethick').click(function() {
					$('#email').val('');
					$('#email').focus();
				});
			}
		});
	});
	
	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {
			confirmDialogBox("Do you want to save?",140,350);
			$('#confirmDialog').parents('div.ui-dialog').css('top','150px');
			
			$('.ui-dialog-buttonset').find('.ui-button').live('click', function() {
				var answer = $(this).find('.ui-button-text').text();
				if(answer === 'OK') {
					removeCommaFromMaskedCurrency();
					document.forms["customer_form"].submit();
				}
			});
		}
	});
	
	
	function checkRequiredFields() {
		var ctr = 0;
		var errorMessage = "";
		
		if(checkValue($('#name').val(), $('#name'))) {
			ctr++;
		}
		
		if(checkValue($('#address').val(), $('#address'))) {
			ctr++;
		}
		
		if(checkValue($('#contactNo').val(), $('#contactNo'))) {
			ctr++;
		}
		
		if(checkValue($('#email').val(), $('#email'))) {
			ctr++;
		}
		
		if($('#email').val()) {
			$("#email").css("border-color","");
			if(validateEmail($('#email').val())) {
				errorMessage = "&bull; Invalid email format.</br>";
				ctr++;
			}
		}
		
		if(ctr > 0) {
			if(errorMessage){promptErrorMessage(errorMessage);}
			return true;
		}
		
		return false;
	}
});