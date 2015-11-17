/**
 * 
 */
$(document).ready(function() {
	$('#user_form').formValidation({
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
	            
	            username: {
	                validators: {
	                    notEmpty: {
	                        message: 'Username cannot be empty.'
	                    }
	                }
	            },
	            
	            password: {
	                validators: {
	                	required: true,
	                    notEmpty: {
	                        message: 'Please provide Password.'
	                    }
	                }
	            },
	            
	            confirmPassword: {
	                validators: {
	                    notEmpty: {
	                        message: 'Confirm password cannot be empty.'
	                    },
	                    identical: {
	                        field: 'password',
	                        message: 'Passwords do not match.'
	                    }
	                }
	            },
	            	            
	            contactNo: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please provide Contact No. Mobile or Landline.'
	                    },
	                    stringLength: {
	                        min: 7,
	                        message: 'The Contact No. cannot be less than 7 characters long'
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