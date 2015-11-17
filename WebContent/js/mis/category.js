$(document).ready(function() {
	
	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {
			confirmDialogBox("Do you want to save?",140,350);
			$('#confirmDialog').parents('div.ui-dialog').css('top','130px');
			
			$('.ui-dialog-buttonset').find('.ui-button').live('click', function() {
				var answer = $(this).find('.ui-button-text').text();
				if(answer === 'OK') {
					document.forms["category_form"].submit();
				}
			});
		}
	});
	
	$('#description').live('change', function() {
		var id = $('#id').val();
		var desc = $('#description').val();
		misDWRService.isCategoryExists(id, desc, function(data) {
			if(data) {
				promptErrorMessage(desc + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','130px');
			} else {
				
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#description').val('');
			$('#description').focus();
		});
	});
	
	$('#code').live('change', function() {
		var id = $('#id').val();
		var code = $('#code').val();
		misDWRService.isCategoryExists(id, code, function(data) {
			if(data) {
				promptErrorMessage(code + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','130px');
			} else {
				
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#code').val('');
			$('#code').focus();
		});
	});
	
	function checkRequiredFields() {
		var ctr = 0;
		
		if(checkValue($('#description').val(), $("#description"))) {
			ctr++;
		}
		
		if(ctr > 0) {
			return true;
		} else {
			return false;
		}
	}
});