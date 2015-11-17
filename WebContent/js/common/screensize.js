$(document).ready(function(){
    $('#1').show();
    //$('#link1').css('background', '#7AA9DD');
    
    $('#btn_next_provider').onload(function(){
        
        var x= $('#btn_next_provider').attr('param');
        if(x<6)
        {
            $('#link'+x).css('background', '#82CFFD');
            //            $('#link'+x).animate({
            //                height:30
            //            },"slow");
            $('#'+x).hide();
            
            $('#link'+x+ '[type=text]') .each(function(){
               
                if($(this).val() == "")
                {
                    $(this).css('border-color', '#F08080')
                }
            })
            x++;
            
            $('#btn_next_provider').attr('param', x);
            $('#btn_back_provider').attr('param', x);
            //            $('#link'+x).animate({
            //                height:100
            //            },"slow");
            $('#link'+x).css('background', '#7AA9DD');
            $('#'+x).show(); 
        }
    });                               
});