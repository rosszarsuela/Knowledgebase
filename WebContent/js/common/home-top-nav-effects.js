//top nav animation effects

		$(document).ready(function(){
			function megaHoverOver()
			{
			$(this).find(".sub-nav").stop().fadeTo('fast', 0.95).show();
			$(this).find("a#main-nav-a").addClass("hovered");
			}
		
			function megaHoverOut()
			{ 	
			$(this).find("a#main-nav-a").removeClass("hovered");
			$(this).find(".sub-nav").stop().fadeTo('slow', 0, function() {
			$(this).hide();	  
			});
			}

			var config = {
			sensitivity: 1, // number = sensitivity threshold (must be 1 or higher)
			interval: 1, // number = milliseconds for onMouseOver polling interval
			over: megaHoverOver, // function = onMouseOver callback (REQUIRED)
			timeout: 1, // number = milliseconds delay before onMouseOut
			out: megaHoverOut // function = onMouseOut callback (REQUIRED)
			};

		$("ul.main-nav li#main-nav-list").hoverIntent(config);
		});