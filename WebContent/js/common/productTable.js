$('table tr').each(function(){      
    if ($('td:empty',this).length > 0);
    $(this).hide();
});

jQuery(function($){
	  $('.back-button').click(function(e){
	    history.back();
	  });
});