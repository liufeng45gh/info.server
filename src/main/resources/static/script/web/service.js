
/**
 * ---------------------------工作区域省份选择开始---------------------------------
 */

var work_province_mouse_in = false;
var work_province_options_in = false;
$(document).ready(function(){
	$(".work_province").click(function (){
		$("#work_province_options").css("display","block");
		initWorkProvinceDiv();
	});
	$(".work_province").mouseover(function(){
		work_province_mouse_in = true;
	});
	$(".work_province").mouseout(function(){
		work_province_mouse_in = false;
		setTimeout(workProvinceHid,1);
		//educationHid();
	});
	$("#work_province_options").mouseover(function(){
		work_province_options_in = true;
	});
	$("#work_province_options").mouseout(function(){
		work_province_options_in = false;
		setTimeout(workProvinceHid,1);
		//educationHid();
	});
	
//	$("#origin_place_province").change(function(){
//		resetOriginPlaceCity();
//	});
//	$("#origin_place_province").on('input',function(e){  
//		resetOriginPlaceCity();
//	});  
});

function workProvinceHid(){
	if(!(work_province_options_in||work_province_mouse_in)){
		$("#work_province_options").css("display","none");
	}
}

function workProvinceSelect(object){
	//alert($(object).html());
	$("#work_province").val($(object).text());
	$("#work_pcity_id").val($(object).attr("cid"));
	$("#work_province_options").css("display","none");	
	//resetWorkCity();
	var redirect_url = "/service/"+$("#selected_type_id").val()+"?pcity_id="+$("#work_pcity_id").val();
	window.location.href = redirect_url;
}

function initWorkProvinceDiv(){
	var initHtml = $("#work_province_options").html();
	if(initHtml.trim()!=""){
		return;
	}
	var send_data={};
	   //alert(1);
    send_data.random=Math.random();
  	var account_request =$.ajax({
      type: 'POST',
      url: '/api/city/top_list.json',
      data: send_data,
      dataType: 'json'
	});

  	account_request.fail(function( jqXHR, textStatus ) {
        if(jqXHR.status==401){
           //openWeiboLogin();
        }
	});

  	account_request.done(function(data) {
  		$("#work_province_options").empty();
         for(var i=0 ;i<data.length;i++){
        	 var city = data[i];
        	 var htmlString = '<a href="#" onclick="workProvinceSelect(this);return false;" cid="'+city.id+'" >'+city.name+'</a>'
        	 $("#work_province_options").append(htmlString);
         }         
    });
}

/**
 * ----------------------------------工作省份选择结束-----------------------------------------------
 */



/**
 * -------------------------------------工作城市选择开始----------------------------------------------
 */

var work_city_mouse_in = false;
var work_city_options_in = false;
$(document).ready(function(){
	$(".work_city").click(function (){
		$("#work_city_options").css("display","block");
		
	});
	$(".work_city").mouseover(function(){
		work_city_mouse_in = true;
	});
	$(".work_city").mouseout(function(){
		work_city_mouse_in = false;
		setTimeout(workCityHid,1000);
		//educationHid();
	});
	$("#work_city_options").mouseover(function(){
		work_city_options_in = true;
	});
	$("#work_city_options").mouseout(function(){
		work_city_options_in = false;
		setTimeout(workCityHid,1000);
		//educationHid();
	});
	
	
});

function workCityHid(){
	if(!(work_city_options_in||work_city_mouse_in)){
		$("#work_city_options").css("display","none");
	}
}

function workCitySelect(object){
	//alert($(object).html());
	$("#work_city").val($(object).text());
	$("#work_city_id").val($(object).attr("cid"));
	$("#work_city_options").css("display","none");	
	
	var redirect_url = "/service/"+$("#selected_type_id").val()+"?pcity_id="+$("#work_pcity_id").val()+"&city_id="+$("#work_city_id").val();
	window.location.href = redirect_url;
}

function resetWorkCity(){
	//alert("resetOriginPlaceCity");
	var send_data={};
	   //alert(1);
	send_data.random=Math.random();
	send_data.name = $("#work_province").val();
	var account_request =$.ajax({
	   type: 'POST',
	   url: '/api/city/child_list.json',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
     if(jqXHR.status==401){
        //openWeiboLogin();
     }
	});

	account_request.done(function(data) {
		$("#work_city_options").empty();
      for(var i=0 ;i<data.length;i++){
     	 var city = data[i];
     	 var htmlString = '<a href="#" onclick="workCitySelect(this);return false;" cid="'+city.id+'">'+city.name+'</a>'
     	 $("#work_city_options").append(htmlString);
      }         
	});
}

/**
 * 
 * -----------------------------------------工作城市选择结束------------------------------------------------
 */
$(document).ready(function (){
	resetWorkCity();
});
$(".type_select").click(function () {
	var type_id = $(this).attr("type_id");
	var redirect_url = "/service/"+type_id+"?pcity_id="+$("#work_pcity_id").val()+"&city_id="+$("#work_city_id").val();
	window.location.href = redirect_url;
});

function initType_s(init_str){
	$(".welfare li").each(function(){
		var text = $(this).attr("data-value");
		if (init_str.indexOf(text)>-1) {
			$(this).addClass("active");
		}
	});
}
$("#tab_service").addClass("on");