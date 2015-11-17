$(document).ready(function() {

	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {
			confirmDialogBox("Do you want to save?",140,350);
			$('#confirmDialog').parents('div.ui-dialog').css('top','140px');
			
			$('.ui-dialog-buttonset').find('.ui-button').live('click', function() {
				var answer = $(this).find('.ui-button-text').text();
				if(answer === 'OK') {
					document.forms["submit_form"].submit();
				}
			});
		}
	});
	
	$('#country').live('change', function() {
		var name = $('#country').val();
		misDWRService.isOriginExists(name, function(data) {
			if(data) {
				promptErrorMessage(name + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','140px');
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#country').val('');
			$('#country').focus();					
		});
	});
	
	function checkRequiredFields() {
		var ctr = 0;
		
		if(checkValue($('#country').val(), $('#country'))) {
			ctr++;
		}
		
		if(ctr > 0) {
			return true;
		} else {
			return false;
		}
	}
});