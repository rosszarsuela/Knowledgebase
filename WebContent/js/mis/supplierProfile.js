$(document).ready(function() {
	
	$('#companyName').live('change', function() {
		var name = $(this).val();
		misDWRService.isSupplierExists(name, function(data) {
			if(data) {
				promptErrorMessage(name + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','150px');
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#companyName').val('');
			$('#companyName').focus();
		});
	});
	
	$('#code').live('change', function() {
		var code = $(this).val();
		misDWRService.isSupplierExists(code, function(data) {
			if(data) {
				promptErrorMessage(code + ' code is already existing!');
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#code').val('');
			$('#code').focus();
		});
	});
	
	$('#email').live('change', function() {
		var email = $(this).val();
		if(email) {
			misDWRService.isSupplierExists(email, function(data) {
				if(data) {
					promptErrorMessage(email + ' is already existing!');
				}
			});
			
			$('.ui-icon-closethick').click(function() {
				$('#email').val('');
				$('#email').focus();
			});
		}
	});
	
	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {
			confirmDialogBox("Do you want to save?",140,350);
			$('#confirmDialog').dialog('open');
			
			$('.ui-dialog-buttonset').find('.ui-button').live('click', function() {
				var answer = $(this).find('.ui-button-text').text();
				if(answer === 'OK') {
					removeCommaFromMaskedCurrency();
					document.forms["supplier_form"].submit();
				}
			});
		}
	});
	
	
	function checkRequiredFields() {
		var ctr = 0;
		var errorMessage = "";
		
		if(checkValue($('#companyName').val(), $('#companyName'))) {
			ctr++;
		}
		
		if(checkValue($('#address').val(), $('#address'))) {
			ctr++;
		} 
		
		if($('#email').val()){
			$("#email").css("border-color","");
			if(validateEmail($('#email').val())) {
				errorMessage = "&bull; Invalid email format.</br>";
				ctr++;
			}
		}
		
		if(checkValue($('#contactPerson').val(), $('#contactPerson'))) {
			ctr++;
		}
		
		if(ctr > 0) {
			if(errorMessage){promptErrorMessage(errorMessage);}
			return true;
		}
		
		return false;
	}
});