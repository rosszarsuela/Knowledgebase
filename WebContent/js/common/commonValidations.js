	//tinNumber
	function validateTin(tinNumber) {
		var tinReg = /^[0-9]{12}$/;
		
		if(tinReg.test(tinNumber)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	function validatePhilhealth(philhealth) {
		var philhealthReg = /^[0-9]{12}$/;
		
		if(philhealthReg.test(philhealth)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	function validateTelNum(telNumber) {
		var telNumReg = /^0[1-9]{1,2}[0-9]{7}$/;
		
		if(telNumReg.test(telNumber)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	function validatePercentage(percentage) {
		var feeRegPercent = /^(0.[0-9]{0,2}|1|1[.]+0)$/;
		
		if(feeRegPercent.test(percentage)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	function validateDouble(double) {
		var feeReg = /^[1-9]{1}|[1-9][0-9]{1,6}$/;
		
		if(feeReg.test(double)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	function validateInteger(integer) {
		var numReg = /^[1-9]{1}$|[1-9]{1}[0-9]{1,2}$/;
		
		if(numReg.test(integer)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	function validateAlpha(alphaName) {
		var alphaReg = /^\S[A-Za-z0-9.,\s]|ñ|Ñ{1,}$/;
		
		if(alphaReg.test(alphaName)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
//	function validateEmail(emailAddress) {
//		var emailReg = /^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$/;
//		
//		if(emailReg.test(emailAddress)) {
//			return true;
//		}
//		
//		else {
//			return false;
//		}
//	}
	
	function validateMobileNumber(mobileNumber) {
		var phoneReg = /^0([0-9]{8}|[0-9]{10})$/;
		
		if(phoneReg.test(mobileNumber)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	function validateEmployeeNumber(empNumber) {
		 var empnoReg = /^[0-9\-]{1,15}$/;
		 
		 if(empnoReg.test(empNumber)) {
			 return true;
		 }
		 
		 else {
			 return false;
		 }
	}
	
	function validateOfficeNumber(officeNumber) {
		var officePhoneReg = /^0([0-9]{8}|[0-9]{9})$/;
		
		if(officePhoneReg.test(officeNumber)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	function validateSssGsis(sssGsis) {
		var sssReg = /^[0-9]{10}$/;
		
		if(sssReg.test(sssGsis)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	function validateErrorCounter(counter) {
		if(counter > 0) {
			$('#btn_next').hide();
			
			var currentTab = $('#btn_back').attr('class');
			previous(currentTab);
		}
		
		else {
			$('#btn_next').show();
		}
	}
	
	function previous(currentTab) {
		var prevTab = Number(currentTab) - 1;
		var nextTab = Number(currentTab) + 1;
		
		$('#btn_back').attr('class', prevTab);
		$('#btn_next').attr('class', nextTab);
		
		$('#link'+currentTab+' div').attr('class', 'activeLink');
		$('.tab'+currentTab).show();
		
		$('#link'+nextTab+' div').attr('class', 'disabledLink');
		$('.tab'+nextTab).hide();
		
		$('#btn_next').show();
		$('#btn_submit').hide();
		
		return prevTab;
	}
	
	function next(currentTab) {
		var prevTab = Number(currentTab) - 1;
		var nextTab = Number(currentTab) + 1;
		
		$('#btn_back').attr('class', prevTab);
		$('#btn_next').attr('class', nextTab);
					
		$('#link'+prevTab+' div').attr('class', 'disabledLink');
		$('.tab'+prevTab).hide();
		$('#link'+currentTab+' div').attr('class', 'activeLink');
		$('.tab'+currentTab).show();
		
		return nextTab;
	}