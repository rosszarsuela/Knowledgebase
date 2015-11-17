$(document).ready(function() {
	
	$("#search-brand-dialog").toggle();
	
	$("#search-brand-dialog").dialog({
		resizable: false,
		height : 450,
		overflow: scroll,
		autoOpen: false,
	    width : 670,
		modal: true,
		closeOnEscape : true
	});
	
	$("#search-brands").click(function() {
		$('#brand-tbody').html('');
		$("#search-brand-dialog").dialog('open');
		
		$('#search').live('keyup', function(e) {
			var search = $(this).val();
			if(e.keyCode == 13) {
				getAllBrands(search);
			}
		});
	});
});

function getAllBrands(search) {
	misDWRService.getAllBrands(search, function(data) {
		if(data.length > 0) {
			$('#brand-tbody').html('');
			for(var index in data) {
				$('#brand-tbody').append(
					'<tr>'+
						'<input type="hidden" id="modal-brand-id" value="'+data[index].id+'"/>'+
						'<td id="modal-brand-name">'+data[index].name+'</td>'+
						'<td width="30px;" align="center" class="info select"><input type="button" value="SELECT"/></td>'+
					'</tr>'
				);
			}
			
			$('.select').click(function() {
				var id = $(this).siblings('#modal-brand-id').val();
				var name = $(this).siblings('#modal-brand-name').text();
				$("#brand-id").attr("value",id);
				$("#brand-name").attr("value",name);
				$("#search-brand-dialog").dialog('close');
			});
		} else {
			$('#brand-tbody').html('');
			$('#brand-tbody').append(
				'<tr>'+
					'<td colspan="2" style="text-align: center; color: red;">No records found.</td>'+
				'</tr>'
			);
		}
	});
}