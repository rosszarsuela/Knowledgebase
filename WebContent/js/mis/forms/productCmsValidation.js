
$(document).ready(function() {
		$('.removeButton').on('click', function() {
	    	$(this).parents('div.specifications').remove();
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
	        $('#product_form').formValidation('addField', $el);
	        
	        initSpeaker();
	        
	    	$row.on('click', '.removeButton', function(e) {
	            $('#product_form').formValidation('removeField', $el);
	            $row.remove();
	            initSpeaker();
	        });
	    });
	    
	    function initSpeaker() {
	    	var ctr = 0;
	    	$('.specifications').each(function(i) {
	    		ctr++;
	    	});
	    	
	    	$('.specifications').each(function(i) {
	    		if(i < (ctr-1) ) {
	    			$(this).find('.specs-id').attr('name','specs['+i+'].id');
	        		$(this).find('.specs-specification').attr('name','specs['+i+'].specification');
	        		$(this).find('.specs-spec1').attr('name','specs['+i+'].spec1');
	        		$(this).find('.specs-spec2').attr('name','specs['+i+'].spec2');
	        		$(this).find('.specs-spec3').attr('name','specs['+i+'].spec3');
	    		}
	    	});
	    }
	   
	    $('#product_form').formValidation({
	    	icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	             name: {
	                validators: {
	                    notEmpty: {
	                        message: 'Set Product Name.'
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
	    
	    
		initImages();
		function initImages() {
			var ct = 0;
			$('#images-table').find('tbody').find('tr').each(function(i){
				$(this).find('.productImages').next().find('label').attr('for','filestyle-'+i+'');
				$(this).find('.imgDesc').attr('name','productImages['+i+'].imgDesc');
				$(this).find('.productImages').attr('name','productImages['+i+'].pImg');
				$(this).find('.productImages').attr('id', 'filestyle-'+i+'');
				$(this).find('.productImages').addClass('ff'+i+'');
				$(this).find('.productImages').prev().attr('name','productImages['+i+'].fileName');
				ct++;
			});
			
			ct = ct-1;
			$('.ff'+ct+'').change(function(){
				var _this = $(this).val().split('\\').pop();;
				/*alert(_this);*/
				$(this).next().find('input').val(_this);
				$(this).prev().val(_this);
			});
		}
		
		$(document).on('click', '.add-image', function() {
				$('#images-table').find('tbody').append(
					'<tr>' +	
					'<td><input type="text" class="imgDesc form-control" data-buttonName="btn-primary"/></td>' +
					'<td>' +
						'<input type="hidden" class="img-name img2" value="">' +
						'<input type="file" class="filestyle productImages" data-buttonname="btn-primary" tabindex="-1" style="display: none; position: absolute; clip: rect (0px 0px 0px 0px);">' +
						'<div class="bootstrap-filestyle input-group">' +
							'<input type="text" class="fake-filename form-control" disabled>' +
							'<span class="group-span-filestyle input-group-btn" tabindex="0">' +
								'<label class="image-label btn btn-primary">' +
									'<span class="glyphicon glyphicon-folder-open">' +
									'</span>' +
									'<span class="buttonText">Choose file</span>' +
								'</label>' +
							'</span>' +
						'</div>' +
					'</td>' +
					'<td>' +
						'<button type="button" class="btn btn-danger dlt-image">X</button>' +
					'</td>' +
					'</tr>'	
				);
				initImages();
		});
		
		var check = 0;
		$(document).on('change', '.productImages', function() {
			var img_value2 = $('.img2').val();
			$('#images-table').find('tbody').find('tr').each(function(){
				var_this = $(this).find('.productImages').val().split('\\').pop();
				var img_value = $(this).find('.img1').val();
				if(img_value2 == img_value) {
					check++;
				}
			});
				
			if(check > 0){
				$('#modal-error-message').text('File already exist');
				$('#errorModal').modal('show');
				$(this).parent().parent().remove();
				initImages();
			}
			
		
		});
		
		$(document).on('click', '.dlt-image', function() {
			$(this).parent().parent().remove();
			initImages();
		});
		
		$('#images-table').find('tbody').find('tr').find('.view-image').click(function(){
			var id = $(this).prev().val();
			getImageById(id);
		});
		
		function getImageById(id) {
			productDWRService.getImageById(id, function(data){
				$('.modal-header').empty();
				$('.modal-header').append("<b>"+data.imgDesc+"</b>");
				/*alert(data.imageContent);*/
				$('.modal-body .img-responsive').attr('src', data.imageContent);
				$('#imagemodal').modal('show');
			});
		}
});