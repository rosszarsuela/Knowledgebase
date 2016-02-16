$('table tr').each(function(){      
    if ($('td:empty',this).length > 0);
    $(this).hide();
});