/**
 * 
 */
$(document).ready(function() {
	    $('#consultant_form').formValidation({
	    	icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            firstName: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please provide First Name.'
	                    }
	                }
	            },

	            middleName: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please provide Middle Name.'
	                    }
	                }
	            },
	            
	            lastName: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please provide Last Name.'
	                    }
	                }
	            },
	            
	            profession: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please provide Profession.'
	                    }
	                }
	            },
	         
	            address: {
	            	validators: {
	            		notEmpty: {
	            			message: 'Please enter School(s).'
	            		},
	            		regexp:{
	            			regexp: /^[a-z0-9\s,'-]*$/i,
	            		}
	            	}
            	},
	            	            
            	contactNo: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please provide Contact No. mobile or landline.'
	                    },
	                    stringLength: {
	                        min: 7,
	                        message: 'The Contact No. cannot be less than 7 numeric characters.'
	                    },
		                regexp: {
	                    regexp: /^[0-9]+$/,
	                    message: 'The Contact No. should only contain numeric characters.'
		                }
	                }
	            },
	         
	            
	            email: {
	                    validators: {
	                    	notEmpty: {
	                    		message: 'Please provide email address.'
	                    	},
	                        emailAddress: {
	                            message: 'The value is not a valid email address'
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