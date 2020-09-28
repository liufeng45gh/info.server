$(function() {
	var pu58login = $('.tablogin li');
	pu58login.click(function() {
		$.j.Cookie.set("logintab58", $(this).attr("id"), "", 30, "/login");
		var count = pu58login.index(this);
		var user = $('#username').val();
		var tel = $('#pptmobilecodeloginmobile').val();
		var rTel = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[6,7,8]{1}))+\d{8})$/;
		$(this).addClass('active').siblings().removeClass('active');
		if (count == 0) {
			if (tel.match(rTel)) {
				$('#username').val(tel).removeClass('c_ccc');
			}
			clickLog("from=normal_tab");
			$('#mobilelogin').hide();
			$('#pulogin').show();
		} else {
			if (user && user.match(rTel)) {
				$('#pptmobilecodeloginmobile').val(user).removeClass('c_ccc');
			}
			clickLog("from=phonecode_tab");
			$('#pulogin').hide();
			$('#mobilelogin').show();
		}

	});

});



var isSend = false;
$(function() {
	//验证手机号
	$("#pptmobilecodeloginmobile").bind("blur", function() {
		$(this).val(mobileUi.QtoB(this.value));
		if (!validMobileFormat(this.value)) {
			$("#mobileLoginTipLi").show();
			$(this).removeClass("c_ccc action_color");$(this).addClass("wrong_color");
			$("#mobileLoginTip").html("请填写正确的手机号码！");
		} else {
			$(this).removeClass("c_ccc wrong_color action_color");
			$("#mobileLoginTipLi").hide();
			$("#mobileLoginTip").html("");
		}
		if ($(this).val() == "") {
			$(this).addClass("c_ccc");
			$(this).val("请输入手机号");
		}
	}).bind("focus", function() {
		$("#mobileLoginTipLi").hide();
		$(this).addClass("action_color");
		if ($(this).val() == "请输入手机号") {
			$(this).removeClass("c_ccc wrong_color");
			$(this).val("");
		}
	}).bind("keyup", function(){
		$(this).val($(this).val().replace(/[^0-9]/g,''));
	});

	//获取手机验证码
	$("#pptmobilecodeloginresendbtn").bind("click", function() {
		$("#pptmobilecodeloginresendbtn").attr("disabled", "disabled");
		$("#mobileLoginTipLi").hide();
		mobile = $("#pptmobilecodeloginmobile").val();
		if (!validMobileFormat(mobile)) {
			$("#mobileLoginTipLi").show();
			$("#pptmobilecodeloginmobile").removeClass("action_color");$("#pptmobilecodeloginmobile").addClass("wrong_color");
			$("#mobileLoginTip").html("请填写正确的手机号码！");
			$("#pptmobilecodeloginresendbtn").removeAttr("disabled");
		} else {
			var pptmobilecodeloginvcode = "";
			if ($("#passport-login-code") && $("#passport-login-code").html() != null) {
				if ($("#pptmobilecodeloginvcode")) {
					pptmobilecodeloginvcode = $("#pptmobilecodeloginvcode").val();
				}
			}
			getCode(mobile, pptmobilecodeloginvcode);
		}
	});
	

	//验证手机确认码
	$("#pptmobilecodeloginmobilecode").bind("blur", function() {
		$(this).val(mobileUi.QtoB(this.value));
		if (this.value.length < 6) {
			$(this).removeClass("action_color");$(this).addClass("wrong_color");
			$("#mobileLoginTipLi").show();
			$("#mobileLoginTip").html("请填写正确的手机确认码！");
			//按钮置灰并变为不可用状态
			$("#mobilecodeloginButtonLable").addClass("login_grey");
		} else {
			//颜色变黄
			$("#mobilecodeloginButtonLable").removeClass("login_grey");
			
			$(this).removeClass("wrong_color");$(this).addClass("action_color");
			$("#mobileLoginTipLi").hide();
			$("#mobileLoginTip").html("");
		}
	}).bind("focus", function() {
		$("#mobileLoginTipLi").hide();
		$(this).addClass("action_color");
	}).bind("keyup", function() {
		if (this.value.length == 6) {
			//颜色变黄
			$("#mobilecodeloginButtonLable").removeClass("login_grey");
		}else{
			//颜色变灰
			$("#mobilecodeloginButtonLable").addClass("login_grey");
		}
	});

	//提交登录
	$("#pptmobilecodeloginButton").bind("click", function() {
		//验证手机号
		mobile = $("#pptmobilecodeloginmobile").val();
		if(mobile == null || mobile.length == 0){
			$("#mobileLoginTipLi").show();
			$("#pptmobilecodeloginmobile").addClass("c_ccc wrong_color");
			$("#mobileLoginTip").html("请输入手机号码！");
			return false;
		}
		
		if (!validMobileFormat(mobile)) {
			$("#mobileLoginTipLi").show();
			$("#pptmobilecodeloginmobile").addClass("c_ccc wrong_color");
			$("#mobileLoginTip").html("请填写正确的手机号码！");
			return false;
		}
		if(!isSend){
			$("#mobileLoginTipLi").show();
			$("#pptmobilecodeloginmobile").addClass("c_ccc wrong_color");
			$("#mobileLoginTip").html("请点击获取手机短信确认码按钮！");
			return false;
		}
		pptmobilecodeloginvcode = "";
		//验证手机认证码
		mobilecode = $("#pptmobilecodeloginmobilecode").val();
		if (mobilecode.length < 6) {
			$("#pptmobilecodeloginmobilecode").addClass("wrong_color");
			$("#mobileLoginTipLi").show();
			$("#mobileLoginTip").html("请填写正确的手机确认码！");
			return false;
		} else {
			$("#pptmobilecodeloginmobilecode").removeClass("wrong_color");
		}
		codeCommitLogin(mobile, mobilecode, pptmobilecodeloginvcode);
	});
});

function codeCommitLogin(mobile, mobilecode, vcode) {
	$("#pptmobilecodeloginButton").attr("disabled", "disabled");
	source = $("#source").val();
	risktype = $("#risktype").val();
	url = "https://passport.58.com/mobileauthcodelogin/login?mobile=" + mobile + "&mobilevcode=" + mobilecode + "&validatecode=" + vcode +"&source=" + source + "&risktype=" + risktype + "&callback=?";
	$.getJSON(url, function(result) {
		codeSuccessCommitLoginFunction(result);
	});
}

function codeSuccessCommitLoginFunction(result) {
	$("#pptmobilecodeloginButton").removeAttr("disabled");
	if (result.code == 0) {
		if (result.data.ppu) {
			//need write cookie, { path: '/', expires: 1 });
			var exp = new Date();
			var expires_time = exp.getTime() + (14 * 24 * 60 * 60 * 1000);
			//14 DAYS
			$.cookie("PPU", result.data.ppu, {
				path : result.data.path,
				expires : expires_time
			});
		}
		mobileloginSuccessFunction();
		return true;
	} else if (result.code == 15) {
		$("#mobileLoginTipLi").show();
		$("#mobileLoginTip").html("请填写正确的手机确认码！");
		$("#pptmobilecodeloginmobilecode").removeClass("action_color");
		$("#pptmobilecodeloginmobilecode").addClass("wrong_color");
	} else if (result.code == 1) {
		$("#mobileLoginTipLi").show();
		$("#mobileLoginTip").html("请填写正确的手机号码！");
	} else if (result.code == 9) {//高危
		window.location.href = "http://passport.58.com/warnuser?risktype=1&path=http://my.58.com&errorpath=http://passport.58.com/login";
	} else {
		$("#mobileLoginTipLi").show();
		$("#mobileLoginTip").html(result.msg);
	} 
}

/**
 * get vcode
 */
function getValidateCode() {
	if($("#pptmobilecodeloginvcode").val() != "请填写图片验证码"){
		$("#pptmobilecodeloginvcode").val("");
	}
	$("#vcodeTelImg").attr("src", "https://passport.58.com/validatecode?temp=123" + (new Date().getTime().toString(36)));
}

/**
 * get mobile code
 */
function getCode(mobile, vcode) {
	addLog("phonecode_btn");
	source = $("#source").val();
	url = "https://passport.58.com/mobileauthcodelogin/getcode?mobile=" + mobile + "&validatecode=" + vcode + "&source=" + source + "&callback=?";
	$.getJSON(url, function(result) {
		successGetCodeFunction(result);
	});
}

function successGetCodeFunction(result) {
	if (result.code == 0) {
		isSend = true;
		//增加timeout的时间倒序
		$("#mobilecodeloginSendMobileCodesendok").show();
		//按钮变成灰色
		$("#pptmobilecodeloginresendbtn").removeClass("mobilecode_yellow");
		$("#pptmobilecodeloginresendbtn").addClass("mobilecode_grey");
		
		var sendokhtml = '<img src="http://img.58cdn.com.cn/ui6/my/images/sendok.png"/>确认码短信已经发到您的手机，请查收！';
		$("#mobilecodeloginSendMobileCodesendok").html(sendokhtml);
		mobilelogincountresent(180);
		//隐藏验证码
		$("#mobilecodeloginVcodeLi").html("");
		$("#mobilecodeloginVcodeLi").hide();
		//隐藏提示语
		$("#mobileLoginTipLi").hide();
		$("#mobileLoginTip").html("");
		//显示登录按钮
		$("#ppt_login").show();
	} else if (result.code == 98){
		$("#mobilecodeloginVcodeLi").show();
		//增加验证码逻辑
		addLog("pic");
		if (!$("#passport-login-code") || $("#passport-login-code").html() == null) {
			var html = '<span id="passport-login-code" name=="passport-login-code" class="passport-login-input-span">验证码</span><input type="text" name="pptmobilecodeloginvcode" id="pptmobilecodeloginvcode" value="请填写图片验证码" class="passport-login-input passport-login-input-mobile c_ccc"><img align="absmiddle" name="vcodeTelImg" id="vcodeTelImg" style="height:36px;"><a href="javascript:getValidateCode();">看不清楚？</a>';
			$("#mobilecodeloginVcodeLi").html(html);
			//验证码
			$("#pptmobilecodeloginvcode").bind("focus", function(){
				if($(this).val() == "请填写图片验证码"){
					$(this).val("");
				}
				$("#mobileLoginTipLi").hide();
				$(this).removeClass("wrong_color c_ccc");
			}).bind("blur", function(){
				if($(this).val() == ""){
					$(this).addClass("c_ccc");
					$(this).val("请填写图片验证码");
				}
			});
		} else {
			$("#mobileLoginTipLi").show();
			$("#mobileLoginTip").html("请正确填写验证码！");
			$("#pptmobilecodeloginvcode").addClass("wrong_color");
		}
		getValidateCode();
		$("#pptmobilecodeloginresendbtn").removeAttr("disabled");
	} else{
		$("#mobileLoginTipLi").show();
		$("#mobileLoginTip").html(result.msg);
		$("#pptmobilecodeloginresendbtn").removeAttr("disabled");
	}
}

function addLog(type) {
	try {
		source = $("#source").val();
		if (!source) {
			clickLog("from=passport_login_" + type);
		} else {
			clickLog("from=" + source + "_" + type);
		}
	} catch (e) {
	}
}

function mobilelogincountresent(resendtime) {
	var sel = setInterval(function() {
		if (resendtime == 0) {
			$("#pptmobilecodeloginresendbtn").removeAttr("disabled").removeClass("countdown");
			$("#pptmobilecodeloginresendbtn").val("获取手机短信确认码");
			//隐藏提示信息
			$("#mobilecodeloginSendMobileCodesendok").hide();
			//按钮变成yellow
			$("#pptmobilecodeloginresendbtn").removeClass("mobilecode_grey");
			$("#pptmobilecodeloginresendbtn").addClass("mobilecode_yellow");
			
			clearInterval(sel);
			return;
		}
		$("#pptmobilecodeloginresendbtn").attr("disabled", "disabled").addClass("countdown");
		$("#pptmobilecodeloginresendbtn").val(resendtime + "秒,重发手机确认码");
		resendtime--;
	}, 1000);
}

var mobileUi = {
	QtoB : function(a) {
		for (var c = "", d = 0; d < a.length; d++) {
			c += a.charCodeAt(d) == 12288 ? String.fromCharCode(a.charCodeAt(d) - 12256) : a.charCodeAt(d) > 65280 && a.charCodeAt(d) < 65375 ? String.fromCharCode(a.charCodeAt(d) - 65248) : String.fromCharCode(a.charCodeAt(d));
		}
		return c;
	}
};

/**
 * check mobile
 */
function validMobileFormat(mobile) {
	var numberRegStr = /^\d{11}$/;
	var regNum = new RegExp(numberRegStr);
	if (regNum.test(mobile)) {
		var telRegStr = /^(13|14|15|17|18)\d{9}$/;
		var reg = new RegExp(telRegStr);
		if (reg.test(mobile))
			return true;
		else
			return false;
	} else {
		return false;
	}
}

function mobileloginSuccessFunction(){
	window.location.href="http://my.58.com/?pts=1438399239807";
}

var timespan = 1411093327735 - new Date().getTime();
var passporttimeout;
var upwd = "";
function clearPassportTimeout() {
	clearTimeout(passporttimeout);
}

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
	$("#usernametr").html('<td><span class="logpic">账户名</span></td><td><input class="inp inw c_ccc useplaceholder" type="text" id="username" name="username" size="20" value="电子邮箱/手机号码" placeholderval="电子邮箱/手机号码" autocomplete="off" /></td>');
	$("#passwordtr").html('<td><span class="logpic">密码</span></td><td><input type="password" style="display:none;" /><input class="inp inw c_ccc pw useplaceholder" id="password" type="password" name="password" size="20" placeholderval="" autocomplete="off" maxlength="16" /></td>');

	$.formValidator.initConfig({
		formid : "submitForm",
		theme:"Default",
		errorfocus : false,
		forcevalid : true,
		btnid : 'btnSubmit',
		btnvalue : '登录',
		btnactionvalue : '登录中...',
		fun : function() {
			var wrongTimes = 0;
			if (GetCookieValue('wrongtimes') != null) {
				wrongTimes = parseInt(GetCookieValue('wrongtimes'));
			}
			if (wrongTimes > 4) {
				alert("您密码输入错误次数太多,请过一段时间再试");
				return false;
			}
			var timesign = new Date().getTime() + timespan;
			if (timesign - 1411093327735 > 1800000) {
				alert("页面已过期，请刷新后再提交");
				window.location.href = window.location.href;
				return false;
			}
			if (passwordIsWeak($("#username").val(), $("#password").val()))
				$("#isweak").val("1");
			else
				$("#isweak").val("0");
			$("#timesign").val(timesign);
			$("#p1").val(getm32str($("#password").val(), timesign + ""));
			$("#p2").val(getm16str($("#password").val(), timesign + ""));
			$("#p3").val(encryptString(timesign + encodeURIComponent($("#password").val()), "010001", "008baf14121377fc76eaf7794b8a8af17085628c3590df47e6534574efcfd81ef8635fcdc67d141c15f51649a89533df0db839331e30b8f8e4440ebf7ccbcc494f4ba18e9f492534b8aafc1b1057429ac851d3d9eb66e86fce1b04527c7b95a2431b07ea277cde2365876e2733325df04389a9d891c5d36b7bc752140db74cb69f"));
			$("#username").addClass("c_ccc").attr("readonly", "readonly");
			$("#password").val("").addClass("c_ccc").attr("readonly", "readonly");
			passporttimeout = setTimeout(function() {
				//	alert("服务器繁忙，请稍后再试");
				$("#password").val(upwd);
				$.formValidator.subfalse('submitForm', 'btnSubmit', '登录');
			}, 10000);
			return true;
		},
		errorclass : "sc",
		successclass : "hc",
		focusclass : "hc",
		tiphtml : '<div class="mid mid-t1"><div class="conn" id=\'errorTip\'>{0}</div></div>'
	});

	$("#username").formValidator({
		onfocus : "",
		tipid : 'tipDiv'
	}).inputValidator({
		onerror : "您还没有输入账户名"
	}).functionValidator({
		fun : function(val, elem) {
			if (val == "电子邮箱/手机号码")
				return "您还没有输入账户名";
			return true;
		}
	}).regexValidator({
		regexp : "^[\\w|\\u4e00-\\u9fa5|\@|\\.|\\-]{2,40}$",
		onerror : "用户名格式错误"
	});
	$("#username").bind("change", function() {
		//$(this).val($.formValidator.QtoB(this.value));
	});
	$("#password").formValidator({
		onfocus : "",
		tipid : 'tipDiv'
	}).inputValidator({
		onerror : "您还没有输入密码"
	}).regexValidator({
		regexp : "^[\\s\\S]{6,}$#^(.){6,16}$",
		onerror : "密码太短，最少为6位。#密码不应超过16个字符。"
	});
	$("#password").bind("change", function() {
		upwd = $(this).val();
	});
	$("#validatecode").formValidator({
		onfocus : "",
		tipid : 'tipDiv'
	}).inputValidator({
		onerror : "请输入验证码"
	}).regexValidator({
		regexp : "^([a-zA-Z0-9]){5}$",
		onerror : "验证码输入不正确。"
	});
	$("#validatecode").bind("blur", function() {
		//$(this).val($.formValidator.QtoB(this.value));
	});
	$("#username").bind("change", function() {
		//$(this).val($.formValidator.QtoB(this.value));
	});
	$('#username').placeholder();
	$('#password').placeholder();
	$("#submitForm").attr("target", "formSubmitFrame");
//	$("#formSubmitFrame").get(0).contentWindow.name = "formSubmitFrame";
});

function clearform() {
	$("#username").removeClass("c_ccc").removeAttr("readonly");
	$("#password").removeClass("c_ccc").removeAttr("readonly").val(upwd);
}

function showvalidcode() {
	var result;
	if (!$("#validatetr") || $("#validatetr").html() == null) {
		var html = '<tr id="validatetr"><td><span class="logpic">验证码</span></td><td><input class="inp inw3" id="validatecode" maxlength="5" name="validatecode" size="2" type="text"><img src="/validatecode" style="cursor: pointer; height: 32px;" id="vcodeImg" name="vcodeImg" onclick="document.getElementById(\'vcodeImg\').src=\'/validatecode?temp=123\'+ (new Date().getTime().toString(36)); _gaq.push([\'pageTracker._trackEvent\', \'58_my\', \'passport\', \'refresh\']); return false" align="absmiddle"> <a class="f12" href="javascript:void(0)" onclick="document.getElementById(\'vcodeImg\').src=\'/validatecode?temp=123\'+ (new Date().getTime().toString(36)); _gaq.push([\'pageTracker._trackEvent\', \'58_my\', \'passport\', \'refresh\']); return false">看不清？</a></td></tr>';
		$("#passwordtr").after(html);
		result = true;
	} else {
		$("#vcodeImg").attr("src", "/validatecode?temp=123" + (new Date().getTime().toString(36)));
		result = false;
	}
	_gaq.push(['pageTracker._trackEvent', '58_my', 'passport', 'show']);
	return result;
}

function refreshvalidcode() {
	if (!$("#validatetr") || $("#validatetr").html() == null) {
	} else {
		$("#vcodeImg").attr("src", "/validatecode?temp=123" + (new Date().getTime().toString(36)));
	}
	_gaq.push(['pageTracker._trackEvent', '58_my', 'passport', 'show']);
}


function passwordIsWeak(username, pwd) {
	if (pwd.match("^[a-z|A-Z]+$") && (isContinuousChar(pwd) || isSameChar(pwd)))
		return true;
	if (pwd.match("^[\\d]+$") && (isContinuousChar(pwd) || isSameChar(pwd)))
		return true;
	if (pwd.match("^[_]+$"))
		return true;
	if (username == pwd)
		return true;
	return false;
}

function isContinuousChar(str) {
	var str = str.toLowerCase();
	var flag = 0;
	for (var i = 0; i < str.length; i++) {
		if (str.charCodeAt(i) != flag + 1 && flag != 0)
			return false;
		else
			flag = str.charCodeAt(i);
	}
	return true;
}

function isSameChar(str) {
	var str = str.toLowerCase();
	var flag = 0;
	for (var i = 0; i < str.length; i++) {
		if (str.charCodeAt(i) != flag && flag != 0)
			return false;
		else
			flag = str.charCodeAt(i);
	}
	return true;
}

function showSelectLoginFlag(f) {
	if (f)
		$("#logintit").show(500);
	else
		$("#logintit").hide(500);
}


function flushWxqrcode(login){
	$.get("/wxqrcode?temp=1" + (new Date().getTime().toString(36)),
		function(result){
			if(result){
				result = eval('('+result+')');
				$("#wxqrcodeImg").attr("src", result.pic);
				if(login)
					flushWxqrcodeLogin();
			}
		}	
	);
}
function flushWxqrcodeLogin(){
	$.ajax({
		url : "/wxqrcodelogin",
		type : "post",
		data : {"path":"http://bj.58.com/?pts=1411093327735"},
		dataType : "json",
		success : function(result){
			if(result.type=="success"){
				window.location.href = result.path;
			}else if(result.type=="warnusererror"){
				window.location.href = "/login?wuid="+result.wuid;
			}else{
				flushWxqrcodeLogin();
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			flushWxqrcodeLogin();
        }
	});
}
$(function() {
	flushWxqrcode(true);
	setInterval("flushWxqrcode(false)", 1800000);
});
$(function() {
    var login_name=$('.login_name')[0];
    var login_name_li=login_name.getElementsByTagName('li');
    for(var i=0;i<login_name_li.length;i++){
        login_name_li[i].index=i;
        login_name_li[i].onclick=function(){
            $(this).addClass('cur').siblings().removeClass('cur');
            $.j.Cookie.set("logintab", $(this).attr("id"), "", 30, "/login");
            if(this.index == '0'){
                $('.qqlogin').show();
                $('.weixinlogin,.loginbox,.link-login').hide();
                 setTimeout("clickLog('from=login_qq')",1500);
            }else if(this.index == '1'){
                $('.weixinlogin,.link-login').show();
				$('.qqlogin,.loginbox').hide();
                setTimeout("clickLog('from=login_orig')",1500);
            }else{
				$('.loginbox,.link-login').show();
				$('.qqlogin,.weixinlogin').hide();
                setTimeout("clickLog('from=login_weixin')",1500);
            }
        };
    }
    
    $('#showtip a').mouseover(function(){
		if(!$('#ewmwrap').is(":animated")){
			$('#ewmwrap').fadeOut();
			$('#tipwrap').fadeIn();
		}		
	}).mouseout(function(){
		$('#ewmwrap').fadeIn();
		$('#tipwrap').fadeOut();
	});
    
   
    
});