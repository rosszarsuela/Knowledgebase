$(document).ready(function() {
	
	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {
			var category = Number($('#category-id').val());
			var code = $('#code').val();
			misDWRService.isItemCodeExists(category,code, function(data) {
				if(data) {
					promptInfoMessage(code + ' is already existing!');
					$('#code').val('');
					
					$('.ui-icon-closethick').click(function() {
						$('#code').focus();
					});
				} else {
					confirmDialogBox("Do you want to save?",140,350);
					$('#confirmDialog').dialog('open');
					
					$('.ui-dialog-buttonset').find('.ui-button').live('click', function() {
						var answer = $(this).find('.ui-button-text').text();
						if(answer === 'OK') {
							document.forms["submit_form"].submit();
						}
					});
				}
			});
		}
	});
	
	function checkRequiredFields() {
		var ctr = 0;
		
		if(checkValue($('#code').val(), $('#code'))) {
			ctr++;
		}
		
		if(checkValue($('#codeNo').val(), $('#codeNo'))) {
			ctr++;
		}
		
		if(ctr > 0) {
			return true;
		} else {
			return false;
		}
	}
});