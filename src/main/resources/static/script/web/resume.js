$(".search_button").click(function(){
//	var send_data ={};
//	send_data.position_id = $("position_id").val();
//	send_data.city_id = $("work_city_id").val();
//	send_data.industry_id = $("industry_id").val();
//	send_data.keywords = $("keywords").val();
//	$.get("/resume",send_data,searchCallBack,"html");
	$("#search_from").submit();
});
function searchCallBack(data,textStatus){
	
}
$("#tab_resume").addClass("on");