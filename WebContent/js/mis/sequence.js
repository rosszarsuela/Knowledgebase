$(document).ready(function() {
	
	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {			
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
	
	function checkRequiredFields() {
		var ctr = 0;
		
		if(checkValue($('#start').val(), $('#start'))) {
			ctr++;
		}
		
		if(checkValue($('#end').val(), $('#end'))) {
			ctr++;
		}
		
		if(ctr > 0) {
			return true;
		} else {
			return false;
		}
	}
});