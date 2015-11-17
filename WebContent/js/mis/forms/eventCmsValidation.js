/**
 * 
 */
$(document).ready(function() {
	    $('#event_form').formValidation({
	    	icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        
	        fields: {
	            name: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Event Name.'
	                    }
	                }
	            },
	           
	            description: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Product Description.'
	                    }
	                }
	            },
	            
	            dateFrom: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Date start.'
	                    }
	                }
	            },
	            
	            dateTo: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Date End.'
	                    }
	                }
	            },
	            
	            
	            slot: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set No. of Slots'
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