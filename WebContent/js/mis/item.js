var type = {
    "BOOKS": 1,
    "MUSICAL_INSTRUMENT": 2,
    "PIANO": 3,
    "PRO_AUDIO": 4,
    "SPARE_PARTS": 5
};

$(document).ready(function() {
	
	$('#btn_save').live('click', function() {
		if(!checkRequiredFields()) {
			confirmDialogBox("Do you want to save?",140,350);
			
			$('.ui-dialog-buttonset').find('.ui-button').live('click', function() {
				var answer = $(this).find('.ui-button-text').text();
				if(answer === 'OK') {
					document.forms["item_form"].submit();
				}
			});
		}
	});
	
	$('#itemCode').live('change', function() {
		var code = $('#itemCode').val();
		misDWRService.isItemCodeExists(code, function(data) {
			if(data) {
				promptErrorMessage('Item Code ' + code + ' is already existing!');
				$('#ui-dialog-title-errorDialog').parents('div.ui-dialog').css('top','140px');
			}
		});
		
		$('.ui-icon-closethick').click(function() {
			$('#itemCode').focus();
			$('#itemCode').val('');
		});
	});
	
	$("#search-category-dialog").toggle();
	
	$("#search-category-dialog").dialog({
		resizable: false,
		height : 450,
		overflow: scroll,
		autoOpen: false,
	    width : 670,
		modal: true,
		closeOnEscape : true
	});
	
	$('#search-category').live('click', function() {
		
		$('#category-tbody').html('');
		$("#search-category-dialog").dialog('open');
		
		$('#search').live('keyup', function(e) {
			var search = $(this).val();
			if(e.keyCode == 13) {
				getAllCategory(search);
			}
		});		
	});
	
	$('#category-id').live('change', function() {
		getCategoryCodeById();
	});
	
	//onLoad get category id
	if(!$('#id').val()) {
		getCategoryCodeById();
	}
	
	function getCategoryCodeById() {
		var id = $('#category-id').val();
				
		misDWRService.getCategoryById(id, function(data) {
			$('#category-code').attr('value', data.code);
			$('#category-type').attr('value', data.type);
						
			generateAJPCCode(data.code);
							
		});
	}
	
	function generateAJPCCode(code) {
		var id = $('#category-id').val();
		var categoryType = $('#category-type').val();
		if(type.PIANO != categoryType) {
			misDWRService.getAjpcCodeSeq(Number(id), function(data) {
				$('#ajpcCode').attr('value', code+'-'+data);
			});
		} else {
			$('#ajpcCode').attr('value', code);
		}
	}
	
	function getAllCategory(search) {
		misDWRService.getAllCategories(search, function(data) {
			if(data.length > 0) {
				$('#category-tbody').html('');
				for(var index in data) {
					$('#category-tbody').append(
						'<tr>'+
							'<input type="hidden" id="modal-category-id" value="'+data[index].id+'"/>'+
							'<input type="hidden" id="modal-category-type" value="'+data[index].type+'"/>'+
							'<td id="modal-category-desc">'+data[index].description+'</td>'+
							'<td>'+data[index].typeDesc+'</td>'+
							'<td id="modal-category-code">'+data[index].code+'</td>'+
							'<td width="30px;" align="center" class="info select"><input type="button" value="SELECT"/></td>'+
						'</tr>'
					);
				}
				
				$('.select').click(function() {
					var id = $(this).siblings('#modal-category-id').val();
					var type = $(this).siblings('#modal-category-type').val();
					var desc = $(this).siblings('#modal-category-desc').text();
					var code = $(this).siblings('#modal-category-code').text();
					$("#category-id").attr("value",id);
					$("#category-type").attr("value",type);
					$("#category-desc").attr("value",desc);
					
					$('#barCode').attr('value','');
					$('#item-code').attr('value','');
					$('#item-code-id').attr('value','');
					
					$("#search-category-dialog").dialog('close');
					
					misDWRService.getAjpcCodeSeq(Number(id), function(data) {
						$('#ajpcCode').attr('value', code+'-'+data);
					});
				});
			} else {
				$('#category-tbody').html('');
				$('#category-tbody').append(
					'<tr>'+
						'<td colspan="4" style="text-align: center; color: red;">No records found.</td>'+
					'</tr>'
				);
			}
		});
	}
	
	$("#search-code-dialog").toggle();
	
	$("#search-code-dialog").dialog({
		resizable: false,
		height : 450,
		overflow: scroll,
		autoOpen: false,
	    width : 670,
		modal: true,
		closeOnEscape : true
	});
	
	$('#search-code').live('click', function() {
		
		$('#code-tbody').html('');
		$("#search-code-dialog").dialog('open');
		
		$('#search').live('keyup', function(e) {
			var search = $(this).val();
			if(e.keyCode == 13) {
				getItemCode(search);
			}
		});		
	});
	
	function getItemCode(search) {
		misDWRService.getItemCode(search, function(data) {
			if(data.length > 0) {
				$('#code-tbody').html('');
				for(var index in data) {
					$('#code-tbody').append(
						'<tr>'+
							'<input type="hidden" id="modal-code-id" value="'+data[index].id+'"/>'+
							'<td id="modal-item-code">'+data[index].code+'</td>'+
							'<td id="modal-code-no">'+data[index].codeNo+'</td>'+
							'<td width="30px;" align="center" class="info select"><input type="button" value="SELECT"/></td>'+
						'</tr>'
					);
				}
				
				$('.select').click(function() {
					var id = $(this).siblings('#modal-code-id').val();
					var code = $(this).siblings('#modal-item-code').text();
					var codeNo = $(this).siblings('#modal-code-no').text();
					
					$("#item-code-id").attr("value",id);
					$("#item-code").attr("value",code);
					$("#code-no").attr("value",codeNo);
										
					$("#search-code-dialog").dialog('close');
					
					var categoryId = $('#category-id').val(); 
					misDWRService.getItemSeqByCategory(Number(categoryId), function(data) {
						$('#barCode').attr('value', codeNo+'-'+data);
					});
				});
			} else {
				$('#code-tbody').html('');
				$('#code-tbody').append(
					'<tr>'+
						'<td colspan="3" style="text-align: center; color: red;">No records found.</td>'+
					'</tr>'
				);
			}
		});
	}
	
	function checkRequiredFields() {
		var ctr = 0;
		
		if(checkValue($('#itemCode').val(), $('#itemCode'))) {
			ctr++;
		}
		
		if(checkValue($('#ajpcCode').val(), $('#ajpcCode'))) {
			ctr++;
		}
		
		if(checkValue($('#description').val(), $('#description'))) {
			ctr++;
		}
		
		if(checkValue($('#model').val(), $('#model'))) {
			ctr++;
		}
		
		if(checkValue($('#size').val(), $('#size'))) {
			ctr++;
		}
		
		if(checkValue($('#origin').val(), $('#origin'))) {
			ctr++;
		}
		
		if(ctr > 0) {
			return true;
		} else {
			return false;
		}
	}
});