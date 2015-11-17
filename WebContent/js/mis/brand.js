$(document).ready(function() {
	
	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {
			
			var id = $('#id').val();
			var name = $('#name').val();
			misDWRService.isBrandExists(id, name, function(data) {
				if(data) {
					promptErrorMessage(name + ' is already existing!');
					$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','130px');
				} else {
					confirmDialogBox("Do you want to save?",140,350);
					$('#confirmDialog').parents('div.ui-dialog').css('top','130px');
					$('.ui-dialog-buttonset').find('.ui-button').live('click', function() {
						var answer = $(this).find('.ui-button-text').text();
						if(answer === 'OK') {
							document.forms["submit_form"].submit();
						}
					});
				}
			});
			
			$('.ui-icon-closethick').click(function() {
				$('#name').val('');
				$('#name').focus();
			});
		}
	});
	
	function checkRequiredFields() {
		var ctr = 0;
		
		if(checkValue($('#name').val(), $('#name'))) {
			ctr++;
		}
		
		if(ctr > 0) {
			return true;
		} else {
			return false;
		}
	}
});