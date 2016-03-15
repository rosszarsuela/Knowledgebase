$(document).ready(function() {
	
	/*pageSize = 4;
	var i = 1;
	showPage = function(page) {
	    $(".educators-picture").hide();
	    $(".educ-prof").hide();
	    $(".educators-picture").each(function(n) {
	        if (n >= pageSize * (page - 1) && n < pageSize * page)
	            $(this).show();
	    });
	    $(".educ-prof").each(function(n) {
	        if (n >= pageSize * (page - 1) && n < pageSize * page)
	            $(this).show();
	    });  
	};
	
	showPage(i);*/
	
	$("#previous").click(function() {
	    $("#next").removeClass("current");
	    $(this).addClass("current");
	    if (i != 1) {
	      showPage(--i);
	    }
	});
	$("#next").click(function() {
	    $("#previous").removeClass("current");
	    $(this).addClass("current");
	    if (i < ($('.educators-picture').length)/4) {
	      showPage(++i);
	    }   
	    if (i < ($('.educ-prof').length)/4) {
		      showPage(++i);
		    }    
	});
});