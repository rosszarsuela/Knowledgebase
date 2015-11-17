$(document).ready(function() {
	$('textarea').keyup(function (event) {
			// Enter key
	       if (event.keyCode == 13) {
	           var content = this.value;
	           var caret = getCaret(this);
	           this.value = content.substring(0,caret)+"\n"+content.substring(caret,content.length);
	           event.stopPropagation();	           
	      }
	       
	       //Tab key
	       else if (event.keyCode == 9) {
	    	   var content = this.value;
	           var caret = getCaret(this);
	           this.value = content.substring(0,caret)+"\t"+content.substring(caret,content.length);
	           event.stopPropagation();
	      }
	});
	function getCaret(el) { 
	  if (el.selectionStart) { 
	    return el.selectionStart; 
	  } else if (document.selection) { 
	    el.focus(); 

	    var r = document.selection.createRange(); 
	    if (r == null) { 
	      return 0; 
	    } 

	    var re = el.createTextRange(), 
	        rc = re.duplicate(); 
	    re.moveToBookmark(r.getBookmark()); 
	    rc.setEndPoint('EndToStart', re); 

	    return rc.text.length; 
	  }  
	  return 0; 
	}
});