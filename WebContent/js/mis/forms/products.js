$(document).ready(function() {
	
	$('#categoryId').change(function() {
		getAllProducts($(this).val());
	});
	
	function getAllProducts(id) {
		productDWRService.getProductsByCategoryId(id, function(data) {
			var imageContent = $('.grid-product div.row');
			if(data.length > 0) {
				imageContent.html('');
				for(var i in data) {
					console.log('content-type: ' + data[i].contentType);
					if(data[i].contentType == null) {
						imageContent.append(
							'<div class="col-md-3 portfolio-item">'+
								'<a href="#" data-toggle="tooltip" title="'+data[i].name+'">'+
									'<input type="hidden" class="product-id" value="'+data[i].id+'" />'+
									'<img class="img-responsive" src="/Oris/images/no_image_available.jpg" />'+
								'</a>'+
							'</div>'
						);
					} else {
						imageContent.append(
							'<div class="col-md-3 portfolio-item">'+
								'<a href="#" data-toggle="tooltip" title="'+data[i].name+'">'+
									'<input type="hidden" class="product-id" value="'+data[i].id+'" />'+
									'<img class="img-responsive" src="'+data[i].imageContent+'"/>'+
								'</a>'+
							'</div>'
						);
					}
				}
			}
			
			$('.grid-product').show();
			$('.product-detail').hide();
		});
	}

	$('div.grid-product').on('click', '.img-responsive', function() {
		$('.grid-product').hide();
		$('.product-detail').show('src');
		
		//get id
		var productId = $(this).parents('a').find('.product-id').val();
		getProductById(productId);
	});
	
	function getProductById(id) {
		productDWRService.getProductById(id, function(data) {
			$('#product-name').text(data.name);
			$('#product-nameOverview').text(data.name);
			$('#product-image').attr('src', data.imageContent);
			$('#product-description').text(data.description);
			$('#download-pdf').attr('href', "/Oris/web/view/downloadPdf?id=" + data.id);
		});
	}
	
	$('#myTab').tabCollapse({
	    tabsClass: 'hidden-sm',
	    accordionClass: 'visible-sm'
	});
	
});