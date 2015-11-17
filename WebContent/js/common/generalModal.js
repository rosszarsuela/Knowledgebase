$(document).ready(function()
{
	$("#general-dialog").toggle();
	
	$("#general-dialog").dialog({	 
			resizable: false,
			height:140,
			modal: true,
			buttons: 
			{
				"OK" : function()
				{
					$(this).dialog("close");
				},
					
				Cancel: function() 
				{
					$(this).dialog("close");
				}
			}
		});
});