//inner nav display effects

$(document).ready(function(){
    function megaHoverOver()
    {
        var windowSize = $(window).width();
//        alert(windowSize);
        if(windowSize > 1400)
            $(this).find("ul").stop().fadeTo('slow', 0.99).show();
			
        else if(windowSize <= 1400)
        {
            var w1 = $(this).width();
            var w2 = $(this).find("ul").width();
            $(this).find("ul").css({
                "margin-left":(-1)*((w1+w2)-490)
                }).stop().fadeTo('slow', 0.99).show();
            
            $('ul.third-nav').hide();
        }
			
    }

    function megaHoverOut()
    { 
        $(this).find("ul").stop().fadeTo('slow', 0, function() {
            $(this).hide();	  
        });
    }

    var config = {
        sensitivity: 2, // number = sensitivity threshold (must be 1 or higher)
        interval: 100, // number = milliseconds for onMouseOver polling interval
        over: megaHoverOver, // function = onMouseOver callback (REQUIRED)
        timeout: 300, // number = milliseconds delay before onMouseOut
        out: megaHoverOut // function = onMouseOut callback (REQUIRED)
    };
    
    $("ul.sub-nav li#sub-nav-list").hoverIntent(config);

    function thirdLevel_megaHoverOver()
    {
        var windowSize = $(window).width();
        if(windowSize > 1400)
            $(this).find("ul").stop().fadeTo('slow', 0.99).show();
			
        else if(windowSize <= 1400)
        {
            var w1 = $(this).width();
            var w2 = $(this).find("ul").width();
            $(this).find("ul").css({
                "margin-left":(-1)*((w1+w2)-490)
                }).stop().fadeTo('slow', 0.99).show();
        }
			
    }

    function thirdLevel_megaHoverOut()
    { 
        $(this).find("ul").stop().fadeTo('slow', 0, function() {
            $(this).hide();	  
        });
    }
    
    var thirdLevelConfig = {
    		sensitivity: 2, // number = sensitivity threshold (must be 1 or higher)
            interval: 100, // number = milliseconds for onMouseOver polling interval
            over: thirdLevel_megaHoverOver, // function = onMouseOver callback (REQUIRED)
            timeout: 300, // number = milliseconds delay before onMouseOut
            out: thirdLevel_megaHoverOut // function = onMouseOut callback (REQUIRED)	
    };
    
    $("ul.inner-nav li#sub-inner-list").hoverIntent(thirdLevelConfig);
    $(".third-nav").hide();
});
