


function refreshAppeal(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/appeal/refresh',
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

function deleteAppeal(id){
	
	if (!confirm("确定删除")) {
		return;
	}
	
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/appeal/delete',
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

