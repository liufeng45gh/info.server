/**
 * ---------------------------------学历选择部分开始------------------------------
 */
var education_mouse_in = false;
var education_options_in = false;
$(document).ready(function(){
	$(".education").click(function (){
		$("#education_options").css("display","block");
	});
	$(".education").mouseover(function(){
		education_mouse_in = true;
	});
	$(".education").mouseout(function(){
		education_mouse_in = false;
		setTimeout(educationHid,1);
		//educationHid();
	});
	$("#education_options").mouseover(function(){
		education_options_in = true;
	});
	$("#education_options").mouseout(function(){
		education_options_in = false;
		setTimeout(educationHid,1);
		//educationHid();
	});
});

function educationHid(){
	if(!(education_options_in||education_mouse_in)){
		$("#education_options").css("display","none");
	}
}

function educationSelect(object){
	//alert($(object).html());
	$("#education_text").val($(object).text());
	$("#education").val($(object).attr("data-value"));
	$("#education_options").css("display","none");	
	
}
/**
 * -----------------------------------学历选择部分结束--------------------------------------
 */



/**
 * ------------------------------------月薪选择部分开始-------------------------------------
 */

var salary_mouse_in = false;
var salary_options_in = false;
$(document).ready(function(){
	$(".salary").click(function (){
		$("#salary_options").css("display","block");
	});
	$(".salary").mouseover(function(){
		salary_mouse_in = true;
	});
	$(".salary").mouseout(function(){
		salary_mouse_in = false;
		setTimeout(salaryHid,1);
		//educationHid();
	});
	$("#salary_options").mouseover(function(){
		salary_options_in = true;
	});
	$("#salary_options").mouseout(function(){
		salary_options_in = false;
		setTimeout(salaryHid,1);
		//educationHid();
	});
});

function salaryHid(){
	if(!(salary_options_in||salary_mouse_in)){
		$("#salary_options").css("display","none");
	}
}

function salarySelect(object){
	//alert($(object).html());
	$("#salary_desc").val($(object).text());
	$("#salary").val($(object).attr("data-value"));
	$("#salary_options").css("display","none");	
}

/**
 * -------------------------月薪选择部分结束---------------------------------
 */

/**
 * ------------------------------------工作年限选择部分开始-------------------------------------
 */

var work_years_mouse_in = false;
var work_years_options_in = false;
$(document).ready(function(){
	$(".work_years").click(function (){
		$("#work_years_options").css("display","block");
	});
	$(".work_years").mouseover(function(){
		work_years_mouse_in = true;
	});
	$(".work_years").mouseout(function(){
		work_years_mouse_in = false;
		setTimeout(workYearsHid,1);
		//educationHid();
	});
	$("#work_years_options").mouseover(function(){
		work_years_options_in = true;
	});
	$("#work_years_options").mouseout(function(){
		work_years_options_in = false;
		setTimeout(workYearsHid,1);
		//educationHid();
	});
});

function workYearsHid(){
	if(!(work_years_options_in||work_years_mouse_in)){
		$("#work_years_options").css("display","none");
	}
}

function workYearsSelect(object){
	//alert($(object).html());
	$("#work_years_text").val($(object).text());
	$("#work_years").val($(object).attr("data-value"));
	$("#work_years_options").css("display","none");	
}

/**
 * -------------------------工作年限选择部分结束---------------------------------
 */

/**
 * ---------------------------籍贯省份选择开始---------------------------------
 */

var origin_place_province_mouse_in = false;
var origin_place_province_options_in = false;
$(document).ready(function(){
	$(".origin_place_province").click(function (){
		$("#origin_place_province_options").css("display","block");
		initOriginPlaceDiv();
	});
	$(".origin_place_province").mouseover(function(){
		origin_place_province_mouse_in = true;
	});
	$(".origin_place_province").mouseout(function(){
		origin_place_province_mouse_in = false;
		setTimeout(originPlaceProvinceHid,1);
		//educationHid();
	});
	$("#origin_place_province_options").mouseover(function(){
		origin_place_province_options_in = true;
	});
	$("#origin_place_province_options").mouseout(function(){
		origin_place_province_options_in = false;
		setTimeout(originPlaceProvinceHid,1);
		//educationHid();
	});
	
//	$("#origin_place_province").change(function(){
//		resetOriginPlaceCity();
//	});
//	$("#origin_place_province").on('input',function(e){  
//		resetOriginPlaceCity();
//	});  
});

function originPlaceProvinceHid(){
	if(!(origin_place_province_options_in||origin_place_province_mouse_in)){
		$("#origin_place_province_options").css("display","none");
	}
}

function originPlaceProvinceSelect(object){
	//alert($(object).html());
	$("#origin_place_province").val($(object).text());
	$("#origin_place_province_options").css("display","none");	
	resetOriginPlaceCity();
}

function initOriginPlaceDiv(){
	var initHtml = $("#origin_place_province_options").html();
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
  		$("#origin_place_province_options").empty();
         for(var i=0 ;i<data.length;i++){
        	 var city = data[i];
        	 var htmlString = '<a href="#" onclick="originPlaceProvinceSelect(this);return false;"  >'+city.name+'</a>'
        	 $("#origin_place_province_options").append(htmlString);
         }         
    });
}

/**
 * ----------------------------------籍贯省份选择结束-----------------------------------------------
 */



/**
 * -------------------------------------籍贯城市选择开始----------------------------------------------
 */

var origin_place_city_mouse_in = false;
var origin_place_city_options_in = false;
$(document).ready(function(){
	$(".origin_place_city").click(function (){
		$("#origin_place_city_options").css("display","block");
		
	});
	$(".origin_place_city").mouseover(function(){
		origin_place_city_mouse_in = true;
	});
	$(".origin_place_city").mouseout(function(){
		origin_place_city_mouse_in = false;
		setTimeout(originPlaceCityHid,1000);
		//educationHid();
	});
	$("#origin_place_city_options").mouseover(function(){
		origin_place_city_options_in = true;
	});
	$("#origin_place_city_options").mouseout(function(){
		origin_place_city_options_in = false;
		setTimeout(originPlaceCityHid,1000);
		//educationHid();
	});
	
	
});

function originPlaceCityHid(){
	if(!(origin_place_city_options_in||origin_place_city_mouse_in)){
		$("#origin_place_city_options").css("display","none");
	}
}

function originPlaceCitySelect(object){
	//alert($(object).html());
	$("#origin_place_city").val($(object).text());
	$("#registered").val($(object).attr("cid"));
	$("#origin_place_city_options").css("display","none");	
}

function resetOriginPlaceCity(){
	//alert("resetOriginPlaceCity");
	var send_data={};
	   //alert(1);
	send_data.random=Math.random();
	send_data.name = $("#origin_place_province").val();
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
		$("#origin_place_city_options").empty();
      for(var i=0 ;i<data.length;i++){
     	 var city = data[i];
     	 var htmlString = '<a href="#" onclick="originPlaceCitySelect(this);return false;" cid="'+city.id+'" >'+city.name+'</a>'
     	 $("#origin_place_city_options").append(htmlString);
      }         
 });
}

/**
 * 
 * ------------------------------籍贯城市选择结束------------------------------------------------
 */




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
	$("#work_province_options").css("display","none");	
	resetWorkCity();
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
        	 var htmlString = '<a href="#" onclick="workProvinceSelect(this);return false;" >'+city.name+'</a>'
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

/**
 * ---------------------------------------------行业选择开始----------------------------------------------
 */

$(document).ready(function (){
	$(".industry_name").click(function (){
		$("#industry_name_options").css("display","block");
		initIndustryOptions();
	});
});

function initIndustryOptions(){
	var html = $("#industry_name_options").html();
	if(html.trim()!=""){
		return;
	}
	var send_data={};
	   //alert(1);
	send_data.random=Math.random();
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/industry/list_selects',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
	  }
	});

	account_request.done(function(data) {
	$("#industry_name_options").empty();
	$("#industry_name_options").html(data);  
	});
}

function selectIndustry(industry_id,text){
	$("#industry_name").val(text);
	$("#industry_id").val(industry_id);
}
function closeIndustrySelectOptions(){
	$("#industry_name_options").css("display","none");
}

/**
 * -----------------------------------------行业选择结束------------------------------------
 */




// -----------------------------------------职位选择开始--------------------------------------

$(document).ready(function (){
	$(".position_name").click(function (){
		$("#position_name_options").css("display","block");
		initPositionOptions();
	});
});

function initPositionOptions(){
	var html = $("#position_name_options").html();
	if(html.trim()!=""){
		return;
	}
	var send_data={};
	   //alert(1);
	send_data.random=Math.random();
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/position/list_selects',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
	  }
	});

	account_request.done(function(data) {
	$("#position_name_options").empty();
	$("#position_name_options").html(data);  
	});
}

function selectPosition(p_id,text){
	$("#position_name").val(text);
	$("#position_id").val(p_id);
}

function closePositionSelectOptions(){
	$("#position_name_options").css("display","none");
}

//--------------------------职位选择结束------------------------