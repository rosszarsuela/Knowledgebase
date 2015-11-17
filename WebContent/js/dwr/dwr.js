function receiveMessages(messages) {
	var notifications = '<div class="ui-state-highlight ui-corner-all">'+
											'<span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span><strong>Notifications</strong>'+
											'</div>'+
											'<ul>';
	for ( var i in messages) {
		notifications = notifications.concat('<li>' + messages[i].description + '</li>');
	}
	
	$('#notif').attr('value', notifications);
	
	notifications = notifications.concat('</ul>');
	dwr.util.setValue("notifications", notifications, {
		escapeHtml : false
	});
	
	var options = {};
	$( "#notifications" ).slideDown('slow');
}

$(document).ready(function() {
	$('#notificationButton').click(function() {
		populateNotifications();
	});
	
	function callback() {
		setTimeout(function() {
			$( "#effect" ).removeAttr( "style" ).hide().slideUp();
		}, 1000 );
	};
	
	function populateNotifications() {
		var username = $('#principalUser').val();
		dwrService.getReminders(username, 
			function(data) {
				var notifications = '<div class="ui-state-highlight ui-corner-all">'+
											'<span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span><strong>Notifications</strong>'+
											'</div>'+
											'<ul>';
				if(data.length > 0) {
						for(var index in data) {
							notifications = notifications.concat('<li>' + (Number(index)+1) + '. ' + data[index].description + '</li>');
						}
						notifications = notifications.concat('</ul>');						
				}
				
				else {
					notifications = notifications.concat('<li>No notifications</li>');
					notifications = notifications.concat('</ul>');
				}
				
				$('#notifications').html(notifications);
				$( "#notifications" ).slideToggle('slow');
			});		
	}
});