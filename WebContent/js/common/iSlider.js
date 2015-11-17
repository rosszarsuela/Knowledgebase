
/**
 * iSlider plugin
 * --Author: Jobo Danque
 * 
 * --Dependencies:
 * jObject.js
 * jQuery
 */

(function( $ ){
	var base = null; //will instansiate on init
	var container = null;
	
	var iSliderMethods = {
	
    init : function( options ) {
    	base = this;
    	var method = iSliderMethods;
    	
    	base.html(base.iSlider.html.iSlide_html);
    
    	return base.each(function(){
    		base.opt = $.extend({}, $.fn.iSlider.defaultOptions, options);
    		base.method = $.extend({},base.method,method);
    		
    		container = $(base.selector);
    		
    		method.hideSlideLeft();
        	method.hideSlideRight();
    		
    		container.find('.iSlide_left').unbind('click');
    		container.find('.iSlide_right').unbind('click');
    		container.find('.iSlide_left').click(base.method.slideLeft);
    		container.find('.iSlide_right').click(base.method.slideRight);
    		
    	});
    },
    
    showSlideLeft : function(){
    	container.find('.iSlide_left').css('visibility','visible');
	},
	
	showSlideRight : function(){
		container.find('.iSlide_right').css('visibility','visible');
	},
	
	hideSlideLeft : function(){
		container.find('.iSlide_left').css('visibility','hidden');
	},
	
	hideSlideRight : function(){
		container.find('.iSlide_right').css('visibility','hidden');	
	},
	
	getSlide : function(slideNumber){
		return container.find('div.slide'+slideNumber+'.iSlide');
	},
	
	slideLeft : function(){
		
		if(0 != base.opt.currentSlide - 1){
			var currentSlide_div = base.method.getSlide(base.opt.currentSlide);
			base.opt.currentSlide -= 1;
			var nextSlide_div = base.method.getSlide(base.opt.currentSlide);
			currentSlide_div.hide("slide", { direction: "right" }, base.opt.slideSpeed,function(){
				nextSlide_div.show("slide", { direction: "left" }, base.opt.slideSpeed);
			});
			
			base.method.hideSlideLeft();
			base.method.showSlideRight();
			if(0 != base.opt.currentSlide - 1){
				base.method.showSlideLeft();
			}
		}
	}, //end slideLeft
	
	slideRight : function(){
		
		if(base.opt.totalSlides != base.opt.currentSlide){
			var currentSlide_div = base.method.getSlide(base.opt.currentSlide);
			base.opt.currentSlide += 1;
			var nextSlide_div = base.method.getSlide(base.opt.currentSlide);
			currentSlide_div.hide("slide", { direction: "left" }, base.opt.slideSpeed, function(){
				nextSlide_div.show("slide", { direction: "right" }, base.opt.slideSpeed);
			});
			
			base.method.hideSlideRight();
			base.method.showSlideLeft();
			if(base.opt.totalSlides != base.opt.currentSlide){
				base.method.showSlideRight();
			}
		}
	},//end slideRight
	
	addSlide : function(html){
		var slideCount = Number(base.opt.totalSlides)+Number(1);
		var slideStyle = (slideCount != 1) ? slideStyle = 'style="display:none;"' : '';
		
		var slideHtml = '<div class="slide'+slideCount+' iSlide" '+slideStyle+' >'+html+'</div>';
		$(container).find('div.iSlide_middle').append(slideHtml);
		base.opt.totalSlides += 1;
		
		if(base.opt.totalSlides > 1){
			base.method.showSlideRight();
		}
		
	}, //end addSlide
	
	//numbering is index based 1
	goToSlide : function(slideNumber){
		
		if(jObject.validate.isWholeNumber(slideNumber)){
			if(base.opt.currentSlide != slideNumber){
				if(base.opt.currentSlide > slideNumber){
					//slide -
					
					if(0 != base.opt.currentSlide - slideNumber){
						var currentSlide_div = base.method.getSlide(base.opt.currentSlide);
						base.opt.currentSlide = slideNumber;
						var nextSlide_div = base.method.getSlide(base.opt.currentSlide);
						currentSlide_div.hide("slide", { direction: "right" }, base.opt.slideSpeed,function(){
							nextSlide_div.show("slide", { direction: "left" }, base.opt.slideSpeed);
						});
						
						base.method.hideSlideLeft();
						base.method.showSlideRight();
						if(0 != base.opt.currentSlide - slideNumber){
							base.method.showSlideLeft();
						}
					}
					
				}else if(base.opt.currentSlide < slideNumber){
					//slide +
					
					if(base.opt.totalSlides != base.opt.currentSlide){
						var currentSlide_div =  base.method.getSlide(base.opt.currentSlide);
						base.opt.currentSlide = slideNumber;
						var nextSlide_div =  base.method.getSlide(base.opt.currentSlide);
						currentSlide_div.hide("slide", { direction: "left" }, base.opt.slideSpeed, function(){
							nextSlide_div.show("slide", { direction: "right" }, base.opt.slideSpeed);
						});
						
						base.method.hideSlideRight();
						base.method.showSlideLeft();
						if(base.opt.totalSlides != base.opt.currentSlide){
							base.method.showSlideRight();
						}
					}
				}
			}
		}
	}, //end goToSlide
	
	
  };

  $.fn.iSlider = function( method ) {
    
    // Method calling logic
    if ( iSliderMethods[method] ) {
      return iSliderMethods[ method ].apply( this, Array.prototype.slice.call( arguments, 1 ));
    } else if ( typeof method === 'object' || ! method ) {
      return iSliderMethods.init.apply( this, arguments );
    } else {
      $.error( 'Method ' +  method + ' does not exist on jQuery.iSlider' );
    }    
  
  };
  
  $.fn.iSlider.defaultOptions = {
        currentSlide: 1,
        totalSlides: 0,
        slideSpeed: 100
  };
  
  $.fn.iSlider.html = {
		iSlide_html : ''
			+'<div class="iSlideContainer" >'
				+'<div class="iSlide_main">'
					+'<div class="iSlide_left">'
						+'<div class="iSlide_left_text">'
							+'<< prev'
						+'</div>'
					+'</div>'
					+'<div class="iSlide_middle"></div>'
					+'<div class="iSlide_right">'
						+'<div class="iSlide_right_text">'
								+'>> next'
							+'</div>'
						+'</div>'
				+'</div>'
			+'</div>',	  
  };
  
})( jQuery );


