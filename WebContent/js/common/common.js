var baseUrl = 'Oris/web/secured';
var emailReg = /^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$/;

var MENU = {
	"HOME":1,
	"ABOUT":2,
	"PRODUCT":3,
	"TRAINING":4,
	"EVENT":5,
	"CONTACT":6,
	"FAQ":7
};

$(document).ready(function() {
	
	//set current menu
	if($('#activeMenu').val() == MENU.HOME) {
		$('#home').addClass('current');
	} else if($('#activeMenu').val() == MENU.ABOUT) {
		$('#about').addClass('current');
	} else if($('#activeMenu').val() == MENU.PRODUCT) {
		$('#product').addClass('current');
	} else if($('#activeMenu').val() == MENU.TRAINING) {
		$('#training').addClass('current');
	} else if($('#activeMenu').val() == MENU.EVENT) {
		$('#events').addClass('current');
	} else if($('#activeMenu').val() == MENU.CONTACT) {
		$('#contact').addClass('current');
	} else if($('#activeMenu').val() == MENU.FAQ) {
		$('#faq').addClass('current');
	}
	
	$('a, button').click(function() {
        $(this).toggleClass('active');
    });
	
	$('.fadein img:gt(0)').hide();
	
    setInterval(function(){$('.fadein :first-child').fadeOut().next('img').fadeIn().end().appendTo('.fadein');}, 3000);
	
	$('#submit_form').find('input[type=text]').keypress(function(e){
	    if ( e.which == 13 ) // Enter key = keycode 13
	    {
	        $(this).next().focus();  //Use whatever selector necessary to focus the 'next' input
	        return false;
	    }
	});
	
});

function convertToNumber(value) {
	return Number(removeComma(value));
}

function convert2Decimal(value) {
	return Number(value).toFixed(2);
}

function escapeKeyClear() {
	$(window).bind('keydown', function(e) {
		if(e.keyCode === 27) { 
			clearModalSearch();
		}
	});
}

function checkValue(value, element) {
	if(value) {
		$(element).css("border-color","");
		return false;
	} else {
		$(element).css({"border-color":"red"});
		return true;
	}
}

function validateEmail(value) {
	if(value) {
		return !emailReg.test(value);
	}
}