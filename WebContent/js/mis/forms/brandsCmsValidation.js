/**
 * 
 */
$(document).ready(function() {
	    $('#brand_form').formValidation({
	    	icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	           code: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Brand Code.'
	                    }
	                }
	            },

	            name: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Brand Name.'
	                    }
	                }
	            },
	            
	            description: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Brand Description.'
	                    }
	                }
	            },
	            
	           /* website: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Website.'
	                    }
	                }
	            },*/
	         
	            color: {
	                validators: {
	                    color: {
	                        type: ['hex', 'rgb', 'hsl', 'keyword'],
	                        message: 'Must be a valid %s color'
	                    }
	                }
	            },
	            colorAll: {
	                validators: {
	                    color: {}
	                }
	            }
	         }
	   });
});