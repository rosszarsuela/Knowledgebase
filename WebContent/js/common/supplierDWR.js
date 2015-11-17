$(document).ready(function() {
	
	$("#search-supplier-dialog").toggle();
	
	$("#search-supplier-dialog").dialog({
		resizable: false,
		height : 450,
		overflow: scroll,
		autoOpen: false,
	    width : 670,
		modal: true,
		closeOnEscape : true
	});
	
	$("#search-suppliers").click(function() {
		$('#supplier-tbody').html('');
		$("#search-supplier-dialog").dialog('open');
		
		$('#search').live('keyup', function(e) {
			var search = $(this).val();
			if(e.keyCode == 13) {
				getAllSuppliers(search);
			}
		});
	});
});

function getAllSuppliers(search) {
	misDWRService.getAllSuppliersByStatus(search, Number(1), function(data) {
		if(data.length > 0) {
			$('#supplier-tbody').html('');
			for(var index in data) {
				$('#supplier-tbody').append(
					'<tr>'+
						'<input type="hidden" id="modal-supplier-id" value="'+data[index].id+'"/>'+
						'<td id="modal-supplier-name">'+data[index].companyName+'</td>'+
						'<td>'+data[index].statusDesc+'</td>'+
						'<td width="30px;" align="center" class="info select"><input type="button" value="SELECT"/></td>'+
					'</tr>'
				);
			}
			
			$('.select').click(function() {
				var id = $(this).siblings('#modal-supplier-id').val();
				var name = $(this).siblings('#modal-supplier-name').text();
				$("#supplier-id").attr("value",id);
				$("#supplier-name").attr("value",name);					
				$("#search-supplier-dialog").dialog('close');
			});
		} else {
			$('#supplier-tbody').html('');
			$('#supplier-tbody').append(
				'<tr>'+
					'<td colspan="3" style="text-align: center; color: red;">No records found.</td>'+
				'</tr>'
			);
		}
	});
}