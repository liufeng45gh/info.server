<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0026)http://beijing.qd8.com.cn/ -->
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../head.jsp"></jsp:include>
<link href="/css/zplist.css" rel="stylesheet" type="text/css">
<body>
	<jsp:include page="../navagation.jsp"></jsp:include>
	<div class="fl_main fl_main_12" >
		<form action="/job" id="search_from">
		<div class="clear">
			<div class="search_element">
				<div  class="label h30">职位类别</div>
					 <div class="item-info select_input_div">
	                <input   id="position_name" maxlength="18"  readonly value="${job.position.name}" class="sel-text position_name" size="40"   placeholder="请选择">
	                <input   id="position_id" name="position_id" type="hidden" value="${job.position.id}">
	                <div class="sel-arrow js-select-show position_name" ></div>
	                <div class="js-select-option sel-option " id="position_name_options" >
	                </div>
            	</div>
			</div>
			<div  class="search_element">
				<div class="label h30">工作地点</div>
				<div class="item-info">
	                <div class="select_input_div">
	                	<input type="text"  readonly class="sel-text w80 work_province"  id="work_province" value="${job.parentCity.name}"  placeholder="请选择">
	                	<div class="sel-arrow js-select-show work_province" ></div>
	                	<div class="js-select-option sel-option w116" id="work_province_options">
	                	</div>
	                </div>            
	                <div style="margin-left:20px;" class="select_input_div">
	                	<input type="text" value="${job.city.name}" readonly class="sel-text w80 work_city" id="work_city"   placeholder="请选择">
	                	<input type="hidden" id="work_city_id" name="city_id" value="${job.city.id}">
	                	<div class="sel-arrow js-select-show work_city" ></div>
	                	<div class="js-select-option sel-option w116" id="work_city_options">
	                	</div>
	                </div> 
        		</div>
			</div>
			<div style="clear: both;"></div>
			<div class="search_element">
				<div  class="label h30">行业类别</div>
				 <div class="item-info select_input_div">
		                <input   id="industry_name" maxlength="18" readonly value="${job.industry.name }"  class="sel-text industry_name" size="40"   placeholder="请选择">
		                <input   id="industry_id" name="industry_id" type="hidden" value="${job.industry.id}">
		                <div class="sel-arrow js-select-show industry_name" ></div>
		                <div class="js-select-option sel-option " id="industry_name_options" >
		                </div>
            	</div>
			</div>
			<div class="search_element">
				<div class="label h30">关键词</div>
				<div style="float: left;">
					<input style="width: 300px; height: 30px; ;" id="title" name="title" value="${job.title}" />
				</div>
				<div style="margin-left:125px;">
					<span>热门搜索： <a href="#">ios</a>
						<a href="#">java</a> 
						<a href="#">php</a> 
						<a href="#">android</a>
					</span>
				</div>
			</div>

			<div style="clear: both;"></div>
			<div style="float: left; margin-left: 80px; margin-top: 20px;">
				<div class="search_button">搜索</div>
			</div>
		</div>
		</form>
		<jsp:include page="listBlock.jsp" />
	</div>

	<jsp:include page="../foot.jsp"></jsp:include>
	<jsp:include page="../common/alertMessage.jsp"></jsp:include>
</body>
</html>
<script src="/script/web/pselect.js"></script>
<script src="/script/web/job.js"></script>
