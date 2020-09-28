    $("#mobileRegTab").click(function(){
    	$(this).addClass('active').siblings().removeClass('active');
    	$("#mobileRegCon").show();	
    	$("#regCon").hide();
    	$("#register_type").val("mobile");
    });
    $("#regTab").click(function(){
    	$(this).addClass('active').siblings().removeClass('active');
    	$("#regCon").show();
    	
	    $("#mobileRegCon").hide();
		
    	$("#register_type").val("email");
    });
    
    
$.formUtils.addValidator({
        name : 'telephone',
        validatorFunction : function(value, $el, config, language, $form) {
        	if ($el.is(":hidden")){
        		return true;
        	}
            return validMobileFormat(value);
        },
        errorMessage : '手机号码格式错误',
        errorMessageKey: 'badTelephone'
 });

$.formUtils.addValidator({
    name : 'email',
    validatorFunction : function(value, $el, config, language, $form) {
    	if ($el.is(":hidden")){
    		return true;
    	}
        return validMailFormat(value);
    },
    errorMessage : '电子邮箱格式错误',
    errorMessageKey: 'badMail'
});


$.formUtils.addValidator({
    name : 'repassword',
    validatorFunction : function(value, $el, config, language, $form) {
    	
    	if($("#password").val()=="") {
    		return false;
    	}
    	
    	if($("#password").val()==value) {
    		return true;
    	}
    	return false;
    },
    errorMessage : '重复密码不一致',
    errorMessageKey: 'badRepasword'
});
  
  

$.validate({
		modules : 'date, security'
});