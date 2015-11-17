

/**
 * validate object used to validate input
 * 
 * call VAL.scanAll(); to scan all validations
 * 
 * Dependency : jQuery
 * 
 * @author Jobo Danque
 * 
 */

var validate = {
		
	//supported validations
	classes : {
		validateNonEmpty : ".validateNonEmpty",
		validateNumber : ".validateNumber",
		validateLettersOnly : ".validateLettersOnly",
	},
	
	//validate all
	scanAll : function(){
		var pass = false;
		
		if(
				validate.all.validateNonEmpty() &&
				validate.all.validateNumber() &&
				validate.all.validateLettersOnly()
		){
			pass = true;
		}
		
		return pass;
	},//end scanAll
	
	regex : {
		alphaReg : /^[A-Za-zñÑ\s]*$/, //alpha only including whitespace
	},//end regex
	
	isEmpty : function(s) {
		return (s === undefined || s == null || s == '');
	},
	
	isNonEmpty : function(s){
		return (s.length > 0);
	},
	
	isNumber : function(s){
		return (!isNaN(s) && s.length > 0);
	},
	
	isLettersOnly : function(s){
		return  (s.length > 0 && validate.regex.alphaReg.test(s));
	},
	
	all : {
		
		validateLettersOnly : function(){
			var pass = true;
			$(validate.classes.validateLettersOnly).each(function(){
				var base = $(this);
				var s = base.val();
				if(s.length <= 0 || !validate.regex.alphaReg.test(s)){
					pass = false;
					validate.logFailed(base, "lettersOnly");
				}
			});
			return pass;
		},//end lettersOnly
		
		validateNonEmpty : function(){
			var pass = true;
			$(validate.classes.validateNonEmpty).each(function(){
				var base = $(this);
				var s = base.val();
				if(s.length <= 0){
					pass = false;
					validate.logFailed(base, "nonEmpty");
				}
			});
			return pass;
		},//end nonEmpty
		
		validateNumber : function(){
			var pass = true;
			$(validate.classes.validateNumber).each(function(){
				var base = $(this);
				var s = base.val();
				if(isNaN(s) || s.length <= 0){
					pass = false;
					validate.logFailed(base, "number");
				}
			});
			return pass;
		},//end number
		
	}, //end all
	
	//logger
	logFailed : function(base,string){
		var nodeName = base.context.nodeName;
		var nodeId = base.context.id != "" ? "#"+base.context.id : "";
		var nodeClassName = "";
		
		if(base.context.className != ""){
			var classess = (base.context.className).split(" ");
			for(var i = 0; i < classess.length ; i++){
				nodeClassName += "."+classess[i];
			}
		}
		console.log( "[ "+string+" validation failed ] : "+nodeName+nodeId+nodeClassName+"" );
	},//end generateNodeSentence

		
}; //end validate