$("#qy_zd .select").click(function (){
	$("#qy_zd .select").addClass("off");
	$(this).removeClass("off");
	//alert($(this).attr("data-value"));
	$("#is_intermediary").val($(this).attr("data-value"));
});

function initIntermediaryType(){
	var is_intermediary = $("#is_intermediary").val();
	$("#qy_zd .select").each(function(){
		if ($(this).attr("data-value") == is_intermediary) {
			$(this).removeClass("off");
		}  else {
			$(this).addClass("off");
		}
	});
}

function changecheckHighlight(object){
	if ($(object).hasClass("active")) {
		$(object).removeClass("active");
	} else {
		$(object).addClass("active");		
	}
	var welfares = "";
	$(".welfare .active").each(function(){
		if (welfares == "") {
			welfares = $(this).text();
		}else{
			welfares = welfares +","+ $(this).text();
		}
		
	});
	$("#welfares").val(welfares);
}




function G(id) {
	return document.getElementById(id);
}


var map = new BMap.Map("compmap");
map.disableScrollWheelZoom();
//var point = new BMap.Point(116.400244,39.92556);
var mapPoint = JSON.parse(mapPointStr);
var point = new BMap.Point(mapPoint.lng,mapPoint.lat);
map.centerAndZoom(point, 18);
var myIcon = new BMap.Icon("http://developer.baidu.com/map/jsdemo/img/fox.gif", new BMap.Size(300,157));
var marker = new BMap.Marker(point,{icon:myIcon});// 创建标注
map.addOverlay(marker);             // 将标注添加到地图中
marker.enableDragging();           // 可拖拽
var label = new BMap.Label("拖动图标到您公司所在的位置",{offset:new BMap.Size(50,10)});
marker.setLabel(label);


var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
		{"input" : "address"
		,"location" : map
	});
ac.setInputValue($("#address").val());
ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
var str = "";
	var _value = e.fromitem.value;
	var value = "";
	if (e.fromitem.index > -1) {
		value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
	}    
	str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
	
	value = "";
	if (e.toitem.index > -1) {
		_value = e.toitem.value;
		value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
	}    
	str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
	G("searchResultPanel").innerHTML = str;
});

var myValue;
ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
var _value = e.item.value;
	myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
	G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
	
	setPlace();
});

function setPlace(){
	map.clearOverlays();    //清除地图上所有覆盖物
	function myFun(){
		point = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
		map.centerAndZoom(point, 18);
		//map.addOverlay(new BMap.Marker(pp));    //添加标注
		var myIcon = new BMap.Icon("http://developer.baidu.com/map/jsdemo/img/fox.gif", new BMap.Size(300,157));
		marker = new BMap.Marker(point,{icon:myIcon});// 创建标注
		map.addOverlay(marker);             // 将标注添加到地图中
		marker.enableDragging();           // 可拖拽
		var label = new BMap.Label("拖动图标到您公司所在的位置",{offset:new BMap.Size(50,10)});
		marker.setLabel(label);
		$("#map_ponit").val(JSON.stringify(marker.getPosition()));
	}
	var local = new BMap.LocalSearch(map, { //智能搜索
	  onSearchComplete: myFun
	});
	local.search(myValue);
}

function initWelfares(init_str){
	$(".welfare li").each(function(){
		var text = $(this).text();
		if (init_str.indexOf(text)>-1) {
			$(this).addClass("active");
		}
	});
}

function refreshJob(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/job/refresh',
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

function deleteJob(id){
	
	if (!confirm("确定删除")) {
		return;
	}
	
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/job/delete',
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