var needValidMobile =  false ; 
$(function(){
	$("#btnNext").click(function(){
		var mobileVal = $("#mobile").val();
		var reg = new RegExp(/^(13|14|18|15)\d{9}$/);
        if($("#password").val().length==0){
            $.formValidator.setTipState(null, "onError", '您还没有输入密码', 'password_Tip');
        }
        if($("#cpassword").val().length==0){
            $.formValidator.setTipState(null, "onError", '密码不一致，请再次确认', 'cpassword_Tip');
        }
        if($("#mobile").val().length==0){
            $.formValidator.setTipState(null, "onError", '请输入您的手机号码', 'mobile_Tip');
        }
        
		if($("#password_Tip").hasClass("wrong1")||$("#cpassword_Tip").hasClass("wrong1")||$("#password").val().length==0||$("#cpassword").val().length==0||$("#mobile_Tip").hasClass("wrong1")||$("#mobile").val().length==0){
			//alert('1');
			return;
		}
    
    	var timesign = new Date().getTime() + timespan;
    	var mobile = $("#mobile").val();
    	var validatecode =  $("#validatecode").val();
    	if(mobile==null || mobile.length==0){
    		$.formValidator.setTipState(null, "onError", '请填写手机号码', 'mobile_Tip');
    		return;
    	}
    	if(!validMobileFormat(mobile)){
    		$.formValidator.setTipState(null, "onError", '手机号码格式错误', 'mobile_Tip');
    		return;
    	}
    	
    	var result = $("#chkagreement:checked").size();
    	if(result <= 0 ){
    		$.formValidator.setTipState(null, "onError", '请查看使用协议，并选择！', 'chkagreement_Tip');
    		return;
    	}
    	
    	
    	
    	 $("#btnNext").attr("disabled",true);
    	 $.get("/sendregmobilecode",
				{
					"mobile":mobile,
					"timesign":timesign,
					"validatecode":validatecode,
					"p":getm32str(mobile,timesign+"")
				},
				function(result){
				    $("#btnNext").attr("disabled",false);
				    refreshValidatecode();
					if(result=="1"){					   	
						$(".submitwrap,#mobileCodeCon").show();
						$("#passwordCon,#mobileRegCon,#verifyCode,#nextwrap,.agreement").hide();
						$("#nextmobile").text($("#mobile").val());
						$("#pre").show();
						$("#gologin").hide();
					
						$("#resendcode_Tip").addClass("chenggong");
						$("#resendcode_Tip").html("确认码短信已发送到您的手机，请查收");
						resendtime = 180;
						countresent(resendtime);
					}else{
						$("#resendcode_Tip").removeClass("chenggong");
						$("#resendcode_Tip").html("");
						if(result=="5"){
							$.formValidator.setTipState(null, "onError", '该手机号码已被注册。您可以使用该手机号码<a href="/login">登录</a>，如果您忘记密码请点击<a href="/forgetpassword">找回密码</a>。', 'mobile_Tip');
						}else if(result=="6"){
							$.formValidator.setTipState(null, "onError", '该手机号码今天发送验证码过多', 'mobile_Tip');
						}else if(result=="7"){
							$.formValidator.setTipState(null, "onError", '验证码错误','validatecode_Tip');
						}else{
							$.formValidator.setTipState(null, "onError", '手机号码格式错误', 'mobile_Tip');
						}
					}
				},"html");
   
        
       
		
	
	});
	$("#pre").click(function(){
		$(".submitwrap,#mobileCodeCon").hide();
		$("#passwordCon,#mobileRegCon,#verifyCode,#nextwrap,.agreement").show();
        $("#mobile_Tip2").removeClass('wrong1').html("");
        $("#validatecode").val("");
        $("#validatecode_Tip").removeClass("chenggong");
         $("#btnNext").attr("disabled",false);
	});

    $("#mobileRegTab").click(function(){
    	$(this).addClass('active').siblings().removeClass('active');
    	$("#mobileRegCon,#verifyCode").show();
		$("#mobileCodeCon").hide();
		$("#passwordCon,#mobileRegCon,#verifyCode,.agreement").show();
    	$("#regCon").hide();
    	//$("#nickName").hide();
    	$("#txtemail").hide();
    	$("#mobile").show();
    	$("#mobilecode").show();
    	//$("#submitForm").attr("action", "/domobileregister");
    	//$("#weixinReg").hide();
    	$("#origReg").show();
    	$("#register_type").val("mobile");
    });
    $("#regTab").click(function(){
    	$(this).addClass('active').siblings().removeClass('active');
    	$("#regCon").show();
    	//$("#nickName").show();
    	$("#txtemail").show();
    	//if(!needValidMobile){
	    	$("#mobileRegCon,#mobileCodeCon,#pre,#nextwrap").hide();
			$("#passwordCon,#gologin,.submitwrap,.agreement").show();
	    	$("#mobile").hide();
	    	$("#mobilecode").hide();
    	//}
    	//$("#submitForm").attr("action", "/account/register");
    	$("#weixinReg").hide();
    	$("#origReg").show();
    	$("#register_type").val("email");
    });
    $('#showtip a').mouseover(function(){
        $('#ewmwrap').fadeOut();
        $('#tipwrap').fadeIn();
    }).mouseout(function(){
        $('#ewmwrap').fadeIn();
        $('#tipwrap').fadeOut();
    });
    
})



var showSugTime;
	var timespan = 1438355239085 - new Date().getTime();
	var passporttimeout;
	function clearPassportTimeout(){
    	clearTimeout(passporttimeout);
    }
	
	$(function() {
        $.formValidator.initConfig({ formid: "submitForm", errorfocus: true, btnid: 'btnSubmit', btnvalue: '同意以下协议，并注册', btnactionvalue: '注册中....', fun: function() {
        	passporttimeout = setTimeout(function(){
            //	alert("服务器繁忙，请稍后再试");
            	$.formValidator.subfalse('submitForm', 'btnSubmit', '注册');
            },5000);
        	return true;
        }
        });
//        $("#nickName").formValidator({ onfocus: "4-20位，可由汉字、数字、字母和“_”组成，注册成功后用户名不可修改" }).inputValidator({ onerror: "您还没有输入用户名" }).functionValidator({ fun: function(val, elem) {
//        	if (val.match("^[\\d]+$")) { return "用户名不能全为数字"; }
//        	
//        	var msg = $.c.user.reg.checknickname(val);
//            if (msg == "") { return true; }
//            msg = "用户名需为4-20个字符（包括汉字、数字、字母、下划线，每个汉字为2字符）";
//            return msg;
//        },
//            onerror: "您还没有输入用户名"
//        }).ajaxValidator({ checkfun: function(val, elem, fun) {
//            //$.c.user.reg.checknameexist(val, fun, function(e){$.formValidator.setTipState(null, "clear", ' ', 'nickName_Tip');});
//        	var send_data={};
//        	   //alert(1);
//    	    send_data.random=Math.random();
//    	    send_data.nick=val;
//        	var nickName_request =$.ajax({
//                type: 'POST',
//                url: '/account/check_nick.json',
//                data: send_data,
//                dataType: 'json'
//           });
//
//        	nickName_request.fail(function( jqXHR, textStatus ) {
//              if(jqXHR.status==401){
//                 //openWeiboLogin();
//              }
//            });
//
//        	nickName_request.done(function(data) {
//                if (!data.ok) {
//                	$("#nickName_Tip").addClass("wrong1");
//                	$("#nickName_Tip").find(".action_po_top").html("用户名已被占用");
//                }else{
//                	$.formValidator.setTipState(null, "clear", ' ', 'nickName_Tip');
//                }
//                
//            });
//        }
//        });
//        $("#nickName").blur(function() {
//            $(this).val($.formValidator.QtoB(this.value));
//        }).keyup(function() {
//        	clearSug();
//        });
        var _txtemail__suffix = "";
        $("#txtemail").formValidator({ onfocus: "请输入有效的电子邮箱，可用于登录和找回密码" }).inputValidator({ onerror: "您还没有输入电子邮箱" }).functionValidator({ fun: function(val, elem) {
        	var _suffix = val.substring(val.length-3,val.length);
			if(/.co|.ne|.or/.test(_suffix)){
				switch(_suffix){
					case ".co":
						val += "m";
						_txtemail__suffix = "com";
						break;
					case ".ne":
						val += "t";
						_txtemail__suffix = "net";
						break;
					case ".or":
						val += "g";
						_txtemail__suffix = "org";
						break;
				}
				$("#txtemail").val(val);
			}else{
				_txtemail__suffix = "";
			}

        	var msg = $.c.user.reg.checkemail(val);
            if (msg == "") { clearSug();return true; }
       
            return msg;
        }
        }).ajaxValidator({ checkfun: function(val, elem, fun) {
//        	$.c.user.reg.checkemailexist(val, function(a){
//        		fun(a);
//        		if(_txtemail__suffix != "" && a == 1){
//	    			$("#txtemail_Tip").attr("class","chenggong").empty().append("<span style='font-size:12px;color:#666;margin-top:-4px;'>已经自动帮你补全为."+_txtemail__suffix +"的邮箱</span>");
//	   			}
//        	}, function(e){
//        		$.formValidator.setTipState(null, "clear", ' ', 'txtemail_Tip');
//
//        	});
        	
        	var send_data={};
     	   //alert(1);
	 	    send_data.random=Math.random();
	 	    send_data.account=val;
	     	var account_request =$.ajax({
	             type: 'POST',
	             url: '/account/check_account.json',
	             data: send_data,
	             dataType: 'json'
	        });
	
	     	account_request.fail(function( jqXHR, textStatus ) {
	           if(jqXHR.status==401){
	              //openWeiboLogin();
	           }
	         });
	
	     	account_request.done(function(data) {
	             if (!data.ok) {
	             	$("#txtemail_Tip").addClass("wrong1");
	             	$("#txtemail_Tip").find(".action_po_top").html("邮箱已被占用");
	             }else{
	             	$.formValidator.setTipState(null, "clear", ' ', 'txtemail_Tip');
	             }
	             
	         });
        	
        }
        });
        $("#txtemail").keyup(function(e) {
        	if(e.keyCode==40 || e.keyCode==38 || e.keyCode==13){return;}
            var sugEmail = ["@163.com","@qq.com","@126.com","@hotmail.com","@gmail.com","@sohu.com","@sina.com","@sina.cn","@yahoo.com","@139.com.cn","@189.cn"];
            var email = $("#txtemail").val().trim();
            clearSug();
            if(email.indexOf("@")==0 || email.length==0 || email.indexOf("<")>-1 || email.indexOf(">")>-1){
            	return;
            }
           	var sugEmail1=[];
           	var perfix = (email.indexOf("@")==-1)?email:email.substring(0,email.indexOf("@"));
            $.each(sugEmail,function(i,n){
            	if((perfix+sugEmail[i]).indexOf(email)==0){
            		sugEmail1[sugEmail1.length] = perfix+sugEmail[i];
            	}
        	});
            if(sugEmail1.length>0){
            	showSug(sugEmail1,"txtemail");
            }
        }).keydown(function(e){
        	var $regkeylist=$("#reg-keyword");
        	if($regkeylist && $regkeylist.is(":visible")){
        		
        		if(e.keyCode==40){//向下
        			var $list=$regkeylist.find("li.reg-keyahover");
        			if($list && $list.length>0){
        				if($list.next()){
        					$list.removeClass("reg-keyahover");
        					$list.next().addClass("reg-keyahover");
        				}else{
        					$list.removeClass("reg-keyahover");
        					$($regkeylist.find("li")[0]).addClass("reg-keyahover");
        				}
        				
        			}else{
        				$($regkeylist.find("li")[0]).addClass("reg-keyahover");
        				
        			}
        			
        			e.stopPropagation(); 
        			return false;
        		}else if(e.keyCode==38){//向上
        			var $list=$regkeylist.find("li.reg-keyahover");
        			if($list && $list.length>0){
        				if($list.prev()){
        					$list.removeClass("reg-keyahover");
        					$list.prev().addClass("reg-keyahover");
        				}else{
        					$list.removeClass("reg-keyahover");
        					$regkeylist.find("li:last").addClass("reg-keyahover");
        				}
        				
        			}else{
        				$regkeylist.find("li:last").addClass("reg-keyahover");
        				
        			}
        			e.stopPropagation(); 
        			return false;
        		}else if(e.keyCode==13){//回车
        			var $list=$regkeylist.find("li.reg-keyahover");
        			if($list && $list.length>0){
        					fillText('txtemail',$list[0])
        			
        				}
        			e.stopPropagation(); 
        			return false;
        		}
        	
        	}
        });
        $("#password").formValidator({ onfocus: "密码需由6-16个字母、数字和符号组成，区分大小写；不能使用重复、连续的字母、数字或符号" }).inputValidator({ onerror: "您还没有输入密码" }).regexValidator({ regexp: "^(.){6,}$#^(.){6,16}$", onerror: "密码太短，最少为6位。#密码不应超过16个字符。" }).functionValidator({ fun: function(val, elem) {
        	var pwd = val.toLowerCase();
            if(pwd.match("^[a-z|A-Z]+$") && (isContinuousChar(pwd) || isSameChar(pwd))){
            	return "为了您的账户安全，密码不能为重复数字和连续字母";
            }
            if(pwd.match("^[\\d]+$") && (isContinuousChar(pwd) || isSameChar(pwd))){
            	return "为了您的账户安全，密码不能为重复数字和连续数字";
            }
            if(isSameChar(pwd)){
            	return "密码不能全为相同的字符";
            }
        	return true;
        }
        });
        $("#cpassword").formValidator({ onfocus: "请再次输入您的密码" }).inputValidator({ onerror: "密码不一致，请再次确认" }).regexValidator({ regexp: "^[\\s\\S]{6,}$#^(.){6,16}$", onerror: "密码太短，最少为6位。#密码不应超过16个字符。" }).functionValidator({ fun: function(val, elem) {

        }
        }).compareValidator({
            desid: "password", operateor: "=", onerror: "密码不一致，请再次确认", datatype: "string"
        });
        $("#mobile").formValidator({ onfocus: "请输入您的手机号码" }).inputValidator({ onerror: "请输入您的手机号码" }).functionValidator({ fun: function(val, elem) {
        	if(validMobileFormat(val)){
            	return true;
            }else{
            	return '手机号码格式错误';
            }
        },
            onerror: "手机号码格式错误"
        });
        $("#mobilecode").formValidator({ onfocus: "请输入您的手机确认码" }).inputValidator({ onerror: "请输入您的手机确认码" });
        
        
        var resendtime = 0;                
        if(resendtime>=0){
        	countresent(resendtime);
        }
        $("#chkagreement").formValidator({ tipid: 'chkagreement_Tip', onfocus: '' }).functionValidator({ fun: function(val, elem) {
            var result = $("#chkagreement:checked").size();
            if (result > 0) return true;
            return "请查看58同城使用协议，并选择！";
        }
        });
        $("#txtemail").val("");
        $("#password").val("");
        $("body").click(function(){
        	if(new Date().getTime()-showSugTime>1000){
        		clearSug();
        		clearSug("username");
        	}
        });
    });
	var vcodesel;
	function countresent(resendtime){
	     if(vcodesel){
	        clearInterval(vcodesel);
	     }
		 vcodesel= setInterval(function(){
           if(resendtime==0){
             $("#resendbtn").attr("disabled",false);
             $("#resendbtn").removeClass("disable");
             $("#resendbtn").val("获取手机确认码");
             clearInterval(vcodesel);
             return;
           }
           $("#resendbtn").attr("disabled","disabled");
           $("#resendbtn").addClass("disable");
           $("#resendbtn").val(resendtime+" 重发手机确认码");
           resendtime--;
          },1000);
	}
	
    function isContinuousChar(str){
    	var str = str.toLowerCase();
        var flag = 0;
        for(var i=0;i<str.length;i++){
        	if(str.charCodeAt(i) != flag+1 && flag!=0)
        		return false;
        	else
        		flag = str.charCodeAt(i);
        }
        return true;
    }
    
    function isSameChar(str){
    	var str = str.toLowerCase();
        var flag = 0;
        for(var i=0;i<str.length;i++){
        	if(str.charCodeAt(i) != flag && flag!=0)
        		return false;
        	else
        		flag = str.charCodeAt(i);
        }
        return true;
    }
    
//    function fillUsername(username){
//    	$("#nickName").val(username);
//    	$("#nickName").focus();
//   // 	clearSug("username");
//    }
    
    function fillEmail(email){
    	$("#txtemail").val(email);
    	$("#txtemail").focus();
    	clearSug("email");
    }
    
    function clearSug(name){
    	if(!name){
    		$("#reg-keyword").remove();
			return;    		
    	}
    	$("#reg-keyword-"+name).hide(300);
    	$("#"+name+"_comp").html("");
    //	$("#reg-keyword-"+name).remove();
    }
    
    var showSug = function(arr,textid){
    	if(!arr || arr.length<1){
    		return;
    	}
    	var isUserName = textid=="nickName";
    	if(isUserName){
    		var usernameCompContent = "";
            $.each(arr,function(i,n){
            	if(arr.length>0)
            		usernameCompContent += '<li onclick="fillUsername(\''+arr[i]+'\')"><label><input name="usernameSugRadio" type="radio" />'+arr[i]+'</label></li>';
        	});
            if(arr.length>0){
          		$("#username_comp").html(usernameCompContent);
            	$("#reg-keyword-username").show(500);
            	$("#username_comp").unbind("click").bind("click",function(e){e.stopPropagation();})
            }
            showSugTime = new Date().getTime();
    		return;
    	}
    	var obj = $("#"+textid); 
    	var left = obj.offset().left;
    	var top = obj.offset().top + obj.height();

    	var content = '<div class="w234-ui2" id="reg-keyword" style="position: absolute; z-index: 999; top: '+top+'px; left: '+left+'px;"><p>'+(isUserName?'选择推荐用户名':'请选择您的邮箱类型')+'：</p><ul>';
    	$.each(arr,function(i,n){
    		content += '<li  onclick="fillText(\''+textid+'\',this)">'+n+'</li>';
    	});
    	content += '</ul></div>';
    	$(content).insertAfter("form");
    	
    	$("#reg-keyword").mouseover(function(){
    		//$(this).find("li.reg-keyahover").removeClass("reg-keyahover");
    	});
    	$("#reg-keyword li").mouseover(function(){
    		$(this).siblings().removeClass("reg-keyahover");
    		$(this).addClass("reg-keyahover");
    		
    	}).mouseout(function(){
    		$(this).removeClass("reg-keyahover");
    		
    	})


    	showSugTime = new Date().getTime();
    }
    
    function fillText(textId,selectObj){
    	_txtemail__suffix = "";
    	$(selectObj).parent().parent().remove();
    	$("#"+textId).val(selectObj.innerHTML);
    	$("#"+textId).focus();
    }

    function validMobileFormat(mobile){
	    var numberRegStr = /^\d{11}$/;
	    var regNum = new RegExp(numberRegStr);
	    if (regNum.test(mobile)) {
	        var telRegStr = /^(13|14|15|17|18)\d{9}$/;
	        var reg = new RegExp(telRegStr);
	        if (reg.test(mobile)) {
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
	    else {
	        return false;
	    }
    }
    
    function resendcode(){
    	var timesign = new Date().getTime() + timespan;
       	var validatecode =  $("#validatecode").val();
   	
    	$.get("/sendregmobilecode",
				{
					"timesign":timesign,
					"resend":"true"
				},
				function(result){
					if(result=="1"){
						$("#resendcode_Tip").addClass("chenggong");
						$("#resendcode_Tip").html("确认码短信已发送到您的手机，请查收");
						resendtime = 180;
						countresent(resendtime);
					}else{
						$("#resendcode_Tip").removeClass("chenggong");
						$("#resendcode_Tip").html("");
						if(result=="5"){
							$.formValidator.setTipState(null, "onError", '该手机号码已被注册。您可以使用该手机号码<a href="/login">登录</a>，如果您忘记密码请点击<a href="/forgetpassword">找回密码</a>。', 'mobile_Tip2');
						}else if(result=="6"){
							$.formValidator.setTipState(null, "onError", '该手机号码今天发送验证码过多', 'mobile_Tip2');
						}else{
							$.formValidator.setTipState(null, "onError", '手机号码格式错误', 'mobile_Tip2');
						}
					}
				},"html");
    }
    
    function isEmpty(str){
    	return str==null || str.length==0;
    }
    
    function isMobileRegister(){
    	return $("#submitForm").attr("action") == "/domobileregister";
    }
    
    
    function flushWxqrcode(login){
    	$.get("/wxqrcode?isreg=1&temp=1" + (new Date().getTime().toString(36)),
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
    		data : {"path":"http://my.58.com/"},
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