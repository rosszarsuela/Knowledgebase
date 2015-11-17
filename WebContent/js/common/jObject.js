/*	
 * 	jObject object with my custom functions :)
 *	Note: this is dependent on jQuery plugin
 *	Author: Jobo Danque
 */


//        .==.        .==.          
//       //`^\\      //^`\\         
//      // ^ ^\(\__/)/^ ^^\\        
//     //^ ^^ ^/6  6\ ^^ ^ \\       
//    //^ ^^ ^/( .. )\^ ^ ^ \\      
//   // ^^ ^/\| v""v |/\^ ^ ^\\     
//  // ^^/\/ /  `~~`  \ \/\^ ^\\    
//  -----------------------------
/// HERE BE DRAGONS--

var jObject = {
	
	/*    Date functions  */
	date : {
		
		/*
		  	 Converts the date in d to a date-object. The input can be:
	           a date object: returned without modification
	           an array      : Interpreted as [year,month,day]. NOTE: month is 0-11.
	           a number     : Interpreted as number of milliseconds
	                          since 1 Jan 1970 (a timestamp) 
	           a string     : Any format supported by the javascript engine, like
	                          "YYYY/MM/DD", "MM/DD/YYYY", "Jan 31 2009" etc.
	          an object     : Interpreted as an object with year, month and date
	                          attributes.  **NOTE** month is 0-11.
		 */
	    convert:function(d) {
	       
	        return (
	            d.constructor === Date ? d :
	            d.constructor === Array ? new Date(d[0],d[1],d[2]) :
	            d.constructor === Number ? new Date(d) :
	            d.constructor === String ? new Date(d) :
	            typeof d === "object" ? new Date(d.year,d.month,d.date) :
	            NaN
	        );
	    },
	    
	     /*
	       Compare two dates (could be of any type supported by the convert
	         function above) and returns:
	          -1 : if a < b
	           0 : if a = b
	           1 : if a > b
	         NaN : if a or b is an illegal date
	         NOTE: The code inside isFinite does an assignment (=).
	      */
	    compare:function(a,b) {
	        return (
	            isFinite(a=this.convert(a).valueOf()) &&
	            isFinite(b=this.convert(b).valueOf()) ?
	            (a>b)-(a<b) :
	            NaN
	        );
	    },
	    
	    /**
	     * Checks if date in d is between dates in start and end.
	     * @param d
	     * @param start
	     * @param end
	     * @returns Returns a boolean or NaN:
	     * 	 true  : if d is between start and end (inclusive)
	     *   false : if d is before start or after end
	     *   NaN   : if one or more of the dates is illegal.
	     *   NOTE: The code inside isFinite does an assignment (=).
	     */
	    inRange:function(d,start,end) {
	       return (
	            isFinite(d=this.convert(d).valueOf()) &&
	            isFinite(start=this.convert(start).valueOf()) &&
	            isFinite(end=this.convert(end).valueOf()) ?
	            start <= d && d <= end :
	            NaN
	        );
	    },
	    
	    /**
	     * Checks if the given range is valid i.e. start <= end
	     * @param start - A string that should be convertible using the convert function above
	     * @param end - A string that should be convertible using the convert function above
	     * @returns {Boolean}
	     */
	    isValidDateRange : function(start, end){
	    	start = jObject.date.convert(start);
	    	end = jObject.date.convert(end);
	    	return (start <= end);
	    },
	},
	/*    end Date functions  */
		
	/*    Money functions  */
	addCurrency : function(c1, c2){
		if(c1 === undefined || c1 === null) c1 = 0;
		if(c2 === undefined || c2 === null) c2 = 0;
		return jObject.toMoney( (Number(jObject.removeComma(c1)) + Number(jObject.removeComma(c2))), 2 )  ; 
	},//end addCurrency
		
	removeComma : function(value) {
		if (value != null && value != '') {
			var removedComma = value.replace(/,/g,'');
			return removedComma;
		}
	}, //end removeComma
		
	toMoney : function(string,decimalPlaces){
		var dp = decimalPlaces || {};
		var n = Number(string), 
		decimalPlaces = isNaN(c = Math.abs(dp)) ? 2 : dp, 
	    d = ".",
	    t = ",", 
	    s = n < 0 ? "-" : "", 
	    i = parseInt(n = Math.abs(+n || 0).toFixed(decimalPlaces)) + "", 
	    j = (j = i.length) > 3 ? j % 3 : 0;
	   return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (decimalPlaces ? d + Math.abs(n - i).toFixed(decimalPlaces).slice(2) : "");
	},//end toMoney function
	/*    end Money functions  */
	
	//jObject object defaults
	defaults : {
		container : $('body').find('#mainWrapper') //default for cocolife
	},
	
	getJSONStringVal : function(mainObj, path){
		var r = jObject.isDefined(mainObj, path);
		return r == false ? "" : jObject.getStringValue(r);
	},//end getJSONStringVal
	
	isDefined : function(mainObj, path) {
	    try {
			if (typeof mainObj != 'object' || mainObj == null) {
				return false;
			}
			var parts = path.split('.');
			while (parts.length) {
				var branch = parts.shift();
				if (!(branch in mainObj)) {
					return false;
				}
				mainObj = mainObj[branch];
			}
			return mainObj;
		} catch (e) {
			return false;
		}
	},//end isDefined
		
	getStringValue : function(item){
		try{
			return ( undefined === item || null == item || 'null' == item) ? '' : String(item);
		}catch(e){
			console.log('[Error ]: '+e);
			return '';
		}
	},
	
	/**
	 * Returns Number object containing value of the item.
	 * If the item is null or empty, returns the default number
	 * @param item - number to parse
	 * @param defaultNumber - 0 if not set
	 */
	getNumberWithDefault : function(item,defaultNumber){
		defaultNumber = defaultNumber || 0;
		return isNaN(item) ? Number(defaultNumber) : Number(item);
	},
	
	confirm : function(opt){
		return jObject.confirmThis(opt.html,opt.yes,opt.no);
	},//end confirm
	
	confirmThis : function(html,yes,no){
		if(html === undefined) html = 'Confirm Action?';
		$('#confirmThis-dialog')
			.html(html)
			.dialog({
				autoOpen : true,
				overflow : scroll,
				modal : true,
				resizable : false,
				height : 150,
				width : 300,
				title : 'Confirm',
				buttons : {
					'Yes' : function(){
							$(this).dialog("close");
							if(yes){
								yes();
							}
					},
					'No' : function(){
						 	$(this).dialog("close");
						 	if(no){
						 		no();
						 	}
						}
					},
				open : function(event, ui) { $(".ui-dialog-titlebar-close", $(this).parent()).hide(); }
			})
			.on('keydown', function(evt) {
		        if (evt.keyCode === $.ui.keyCode.ESCAPE) {
		        	$(this).dialog("close");
				 	if(no){
				 		no();
				 	}
		        }                
		        evt.stopPropagation();
		    })
			;
	}, //end confirmThis
	
	initDialogs : function(dialogSelector,title,width,height){
		if(width === undefined) width = 500;
		if(height === undefined) height = 500;
		if(title === undefined) title = '';
		$(dialogSelector).dialog({
			autoOpen : false,
			closeOnEscape : true,
			overflow : scroll,
			modal : true,
			resizable : false,
			height : height,
			width : width,
			title : title
		});
	},//end initDialogs functions
		
	isEmpty : function(str) {
		var result = false;
		if (str == null || str.trim() == '') {
			result = true;
		}
		return result;
	}, //end isEmpty
	
	
	//deprecated
	scrollHere : function(opt) {
		
		if(opt === undefined) {
			console.log('[elem] attribute is required for function scrollHere');
			return false;
			};
		
		var elem = opt.elem || false; //default for cocolife
		var container = opt.container || jObject.defaults.container; 
		var easing = opt.easing || 0;
		var withBlink = opt.withBlink;
		if (withBlink === undefined) withBlink = true;
		
		//override elem if jquery object is passed
		if(opt instanceof jQuery){
			elem = opt;
		}
		
		container.animate({
			scrollTop: elem.offset().top
			}, 
			easing
			);
		
	}, //end scrollHere
	
	validate : {
		
		isWholeNumber : function(n){
			if(n === undefined){
				return false;
			}else{
				return +n === n && !(n % 1);
			}
		}, //end isWholeNumber
		
		isEmpty : function(str) {
			var result = false;
			if(str === undefined){
				return true;
			}
			if ( str == null || str == '') {
				result = true;
			}
			return result;
		} //end isEmpty
	}
	
}; //end jObject object