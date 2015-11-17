$(document).ready(function() {
	
	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {
			confirmDialogBox("Do you want to save?",140,350);
			$('#confirmDialog').parents('div.ui-dialog').css('top','130px');
			
			$('.ui-dialog-buttonset').find('.ui-button').live('click', function() {
				var answer = $(this).find('.ui-button-text').text();
				if(answer === 'OK') {
					document.forms["color_form"].submit();
				}
			});
		}
	});
	
	$('#color').live('change', function() {
		var color = $('#color').val();
		misDWRService.isColorExists(color, function(data) {
			if(data) {
				promptErrorMessage(color + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','130px');
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#color').val('');
			$('#color').focus();
		});
	});
	
	$('#code').live('change', function() {
		var code = $('#code').val();
		misDWRService.isColorExists(code, function(data) {
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
		
		if(checkValue($('#color').val(), $('#color'))) {
			ctr++;
		}
		
		if(checkValue($('#code').val(), $('#code'))) {
			ctr++;
		}
		
		if(ctr > 0) {
			return true;
		} else {
			return false;
		}
	}
});