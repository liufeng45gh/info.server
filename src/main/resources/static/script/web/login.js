
$.fn.placeholder = function() {
	var defaultValue = $(this).attr('placeholderval');
	$(this).bind("focus", function() {
		$(this).removeClass("c_ccc");

		if ($(this).attr("id") == "password")
			$(this).removeClass("pw").removeClass("pw_wc");

		if ($(this).val() == defaultValue)
			$(this).val("");

	}).bind("blur", function() {
		if ($(this).val() == "") {
			$(this).val(defaultValue);
			$(this).addClass("c_ccc");
			if ($(this).attr("id") == "password")
				$(this).addClass("pw_wc");
		}
	}).bind("change", function() {
		if ($(this).val() == "") {
			$(this).addClass("c_ccc");
			if ($(this).attr("id") == "password")
				$(this).addClass("pw").addClass("pw_wc");
		} else {
			$(this).removeClass("c_ccc");
			if ($(this).attr("id") == "password")
				$(this).removeClass("pw").removeClass("pw_wc");
		}
	});
};


$(function() {
	
	$.formValidator.initConfig({
		formID : "submitForm",
		theme:"Default",
		forcevalid : true,

		onError : function(msg,obj,errorlist) {
//			$("#errorlist").empty();
//			$.map(errorlist,function(msg){
//				$("#errorlist").append("<li>" + msg + "</li>")
//			});
//			alert(msg);

		},
		ajaxPrompt : '有数据正在异步验证，请稍等...'
	});

	$("#username").formValidator({
		onShowText:"请输入用户名",
		onShow:"请输入用户名",
		onFocus:"账户名为手机号或者邮箱地址",
		onCorrect : "输入合法",
		tipID : "tipDiv"
	}).inputValidator({
		onError : "您还没有输入账户名"
	}).functionValidator({
		fun : function(val, elem) {
			if (val == "电子邮箱/手机号码"||val == "")
				return "您还没有输入账户名";
			return true;
		}
	}).regexValidator({
		regExp : "^[\\w|\\u4e00-\\u9fa5|\@|\\.|\\-]{2,40}$",
		onError : "用户名格式错误"
		
	});
	$("#username").bind("change", function() {
		//$(this).val($.formValidator.QtoB(this.value));
	});
	$("#password").formValidator({
		tipID : 'tipDiv',
		onCorrect : "输入合法",
		onFocus: '请输入密码'
	}).inputValidator({
		onError : "您还没有输入密码"
	}).regexValidator({
		regExp : "^[\\s\\S]{6,16}$",
		onError : "密码太短，最少为6位。#密码不应超过16个字符。"
	});
	$("#password").bind("change", function() {
		upwd = $(this).val();
	});
	$("#validatecode").formValidator({		
		tipID : 'tipDiv',
		onFocus: '请输入验证码',
		onCorrect : "输入合法"
	}).inputValidator({
		onError : "请输入验证码"
	}).regexValidator({
		regExp : "^([a-zA-Z0-9]){4}$",
		onError : "验证码输入不正确。"
	});
	$("#validatecode").bind("blur", function() {
		//$(this).val($.formValidator.QtoB(this.value));
	});
	$("#username").bind("change", function() {
		//$(this).val($.formValidator.QtoB(this.value));
	});
	$('#username').placeholder();
	$('#password').placeholder();
	
//	$("#formSubmitFrame").get(0).contentWindow.name = "formSubmitFrame";
});

