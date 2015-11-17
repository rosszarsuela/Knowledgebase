$(document).ready(function() {
	
	$('#name').live('change', function() {
		var name = $(this).val();
		misDWRService.isVendorExists(name, function(data) {
			if(data) {
				promptErrorMessage(name + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','140px');				
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#name').val('');
			$('#name').focus();
		});
	});
	
	$('#code').live('change', function() {
		var code = $(this).val();
		misDWRService.isVendorExists(code, function(data) {
			if(data) {
				promptErrorMessage('Code ' + code + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','140px');
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#code').val('');
			$('#code').focus();
		});
	});
	
	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {
			confirmDialogBox("Do you want to save?",140,350);
			$('#confirmDialog').parents('div.ui-dialog').css('top','140px');
			
			$('.ui-dialog-buttonset').find('.ui-button').live('click', function() {
				var answer = $(this).find('.ui-button-text').text();
				if(answer === 'OK') {
					removeCommaFromMaskedCurrency();
					document.forms["vendor_form"].submit();
				}
			});
		}
	});
	
	
	function checkRequiredFields() {
		var ctr = 0;
		
		if(checkValue($('#name').val(), $('#name'))) {
			ctr++;
		}
		
		if(checkValue($('#code').val(), $('#code'))) {
			ctr++;
		}
		
		if(checkValue($('#salesCode').val(), $('#salesCode'))) {
			ctr++;
		}
		
		if(checkValue($('#address').val(), $('#address'))) {
			ctr++;
		}
		
		if(checkValue($('#contactNo').val(), $('#contactNo'))) {
			ctr++;
		}
						
		if(checkValue($('#contactPerson').val(), $('#contactPerson'))) {
			ctr++;
		}
		
		if(ctr > 0) {
			return true;
		}
		
		return false;
	}
});