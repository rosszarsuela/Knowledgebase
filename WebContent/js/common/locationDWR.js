$(document).ready(function() {
	$("#search-vendor-dialog").toggle();
	
	$("#search-vendor-dialog").dialog({
		resizable: false,
		height : 450,
		overflow: scroll,
		autoOpen: false,
	    width : 670,
		modal: true,
		closeOnEscape : true
	});
	
	$("#search-vendor").click(function() {
		$("#search-vendor-dialog").find('#search').val('');
		$('#vendor-tbody').html('');
		$("#search-vendor-dialog").dialog('open');
		
		$("#search-vendor-dialog").find('#search').live('keyup', function(e) {
			var search = $(this).val();
			if(e.keyCode == 13) {
				getAllVendors(search);
			}
		});
	});
});
function getAllVendors(search) {
	var tbody = $('#vendor-tbody');
	misDWRService.getAllVendors(search, function(data) {
		if(data.length > 0) {
			$('#vendor-tbody').html('');
			for(var index in data) {
				tbody.append(
					'<tr>'+
						'<input type="hidden" id="modal-vendor-id" value="'+data[index].id+'"/>'+
						'<td id="modal-vendor-name">'+data[index].name+'</td>'+
						'<td id="modal-vendor-code">'+data[index].code+'</td>'+
						'<td id="modal-vendor-address">'+data[index].address+'</td>'+
						'<td width="30px;" align="center" class="info select"><input type="button" value="SELECT"/></td>'+
					'</tr>'
				);
			}
			
			$('.select').click(function() {
				var id = $(this).siblings('#modal-vendor-id').val();
				var name = $(this).siblings('#modal-vendor-name').text();
				var code = $(this).siblings('#modal-vendor-code').text();
				$("#vendor-id").attr("value",id);
				$("#vendor-name").attr("value",name);
				$("#vendor-code").attr("value",code);
				$("#search-vendor-dialog").dialog('close');
			});
		} else {
			tbody.html('');
			tbody.append(
				'<tr>'+
					'<td colspan="3" style="text-align: center; color: red;">No records found.</td>'+
				'</tr>'
			);
		}
	});
}