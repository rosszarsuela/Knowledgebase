/**
 * 
 */
$(document).ready(function () {

    $("#home").carousel({
        afterUpdate: function () {
            updateSize();
        },
        afterInit:function(){
            updateSize();
        }
    });
    function updateSize(){
        var minHeight=parseInt($('.item').eq(0).css('height'));
        $('.item').each(function () {
            var thisHeight = parseInt($(this).css('height'));
            minHeight=(minHeight<=thisHeight?minHeight:thisHeight);
        });
        $('.carousel-wrapper-outer').css('height',minHeight+'px');
    }
});