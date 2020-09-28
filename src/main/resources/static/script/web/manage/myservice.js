function changecheckHighlight(object){
	if ($(object).hasClass("active")) {
		$(object).removeClass("active");
	} else {
		$(object).addClass("active");		
	}
	var welfares = "";
	$(".welfare .active").each(function(){
		if (welfares == "") {
			welfares = $(this).attr("data-value");
		}else{
			welfares = welfares +","+ $(this).attr("data-value");
		}
		
	});
	$("#type_s").val(welfares);
}


function refreshBusinessService(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/service/refresh',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function deleteBusinessService(id){
	
	if (!confirm("确定删除")) {
		return;
	}
	
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/service/delete',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
	
}

function initType_s(init_str){
	$(".welfare li").each(function(){
		var text = $(this).attr("data-value");
		if (init_str.indexOf(text)>-1) {
			$(this).addClass("active");
		}
	});
}