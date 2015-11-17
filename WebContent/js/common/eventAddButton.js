/**
 * 
 */

$(document).ready(function() {
		$('.removeButton').on('click', function() {
	    	$(this).parents('div.speaker').remove();
	    	initSpeaker();
	    });
		
        $('.addButton').on('click', function() {
            var index = $(this).data('index');
            if (!index) {
                index = 1;
                $(this).data('index', 1);
            }
            index++;
            $(this).data('index', index);

            var template     = $(this).attr('data-template'),
                $templateEle = $('#' + template + 'Template'),
                $row         = $templateEle.clone().removeAttr('id').insertBefore($templateEle).removeClass('hide'),
                $el          = $row.find('input').eq(0).attr('name', template + '[]');
            $('#event_form').formValidation('addField', $el);
            
            initSpeaker();
            
        	$row.on('click', '.removeButton', function(e) {
                $('#event_form').formValidation('removeField', $el);
                $row.remove();
                initSpeaker();
            });
        });
        
        function initSpeaker() {
        	var ctr = 0;
        	$('.speaker').each(function(i) {
        		ctr++;
        	});
        	
        	$('.speaker').each(function(i) {
        		if(i < (ctr-1) ) {
        			$(this).find('.speaker-id').attr('name','speakers['+i+'].id');
            		$(this).find('.speaker-name').attr('name','speakers['+i+'].name');
            		$(this).find('.speaker-subject').attr('name','speakers['+i+'].subject');
            		$(this).find('.speaker-time').attr('name','speakers['+i+'].time');
        		}
        	});
        }
        

        $('#event_form')
            .formValidation({
                message: 'This value is not valid',
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
                    'textbox[]': {
                        validators: {
                            notEmpty: {
                                message: 'The textbox field is required'
                            }
                        }
                    }
                }
            })
            
            .on('err.field.fv', function(e, data) {
                //console.log('err.field.fv -->', data.element);
            })
            .on('success.field.fv', function(e, data) {
                //console.log('success.field.fv -->', data.element);
            })
            .on('added.field.fv', function(e, data) {
                //console.log('Added element -->', data.field, data.element);
            })
            .on('removed.field.fv', function(e, data) {
                //console.log('Removed element -->', data.field, data.element);
	});
});