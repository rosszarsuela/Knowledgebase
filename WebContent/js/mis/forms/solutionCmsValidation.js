/**
 * 
 */
$(document).ready(function() {
	    $('#solution_form').formValidation({
	    	icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	           code: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Solution Code.'
	                    }
	                }
	            },

	            name: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Solution Name.'
	                    }
	                }
	            },
	            
	            description: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Solution Description.'
	                    }
	                }
	            },
	         
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