/**
 * 
 */

$(document).ready(function() {
	    $('#eventRegistration_form').formValidation({
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
	            
	            contactNo: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please provide Handheld No.'
	                    },
	                    stringLength: {
	                        min: 7,
	                        message: 'Handheld No. cannot be less than 11 characters long'
	                    },
		                regexp: {
	                    regexp: /^[0-9]+$/,
	                    message: 'Handheld should only contain numeric characters.'
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
	            
	            building: {
	            		validators: {
	            			notEmpty: {
	            				message: 'Please provide No. /Unit # /Building'
	            			}
	            		}
	            },
	            
	            street: {
	            		validators: {
	            			notEmpty: {
	            				message: 'Please provide street'
	            			}
	            		}
	            },
	            
	            city: {
	            		validators: {
	            			notEmpty: {
	            				message: 'Please provide valid City'
	            			}
	            		}
	            },
	            
	            province: {
	            		validators: {
	            			notEmpty: {
	            				message: 'Please provide valid Province'
	            			}
	            		}
	            },
	            
	            landline: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please provide Landline number.'
	                    },
	                    stringLength: {
	                        min: 7,
	                        message: 'Landline number cannot be less than 7 characters long'
	                    },
		                regexp: {
	                    regexp: /^[0-9]+$/,
	                    message: 'Landline should only contain numeric characters.'
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