$(document).ready(function() {
	
	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {
			confirmDialogBox("Do you want to save?",140,350);
			$('#confirmDialog').parents('div.ui-dialog').css('top','130px');
			
			$('.ui-dialog-buttonset').find('.ui-button').live('click', function() {
				var answer = $(this).find('.ui-button-text').text();
				if(answer === 'OK') {
					document.forms["currency_form"].submit();
				}
			});
		}
	});
	
	$('#currency').live('change', function() {
		var currency = $('#currency').val();
		misDWRService.isCurrencyExists(currency, function(data) {
			if(data) {
				promptErrorMessage(currency + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','130px');
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#description').val('');
			$('#description').focus();
		});
	});
	
	$('#code').live('change', function() {
		var code = $('#code').val();
		misDWRService.isCurrencyExists(code, function(data) {
			if(data) {
				promptErrorMessage(code + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','130px');
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#code').val('');
			$('#code').focus();
		});
	});
	
	function checkRequiredFields() {
		var ctr = 0;
		
		if(checkValue($('#currency').val(), $('#currency'))) {
			ctr++;
		}
		
		if(checkValue($('#code').val(), $('#code'))) {
			ctr++;
		}
		
		if(checkValue($('#rate').val(), $('#rate'))) {
			ctr++;
		}
		
		if(ctr > 0) {
			return true;
		} else {
			return false;
		}
	}
});