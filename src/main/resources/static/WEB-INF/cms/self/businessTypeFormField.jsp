<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tr>
	<th align="right" width="20%">分类名称:</th>
	<td><input id="city_name" type="text" class="easyui-textbox" name="name" value="<c:out value="${businessType.name}"/>" /><label id="city_name_info">* 分类名称</label></td>
</tr>
			
<tr>
	<th align="right">父级分类:</th>
	<td>
	<input id="parent_city" type="text" class="easyui-textbox" readonly="true" value="<c:out value="${parnetBusinessType.name}"  />"  />
	<input type="hidden" name="parent_id" value="<c:out value="${parnetBusinessType.id}"/>" />
	</td>
</tr>

<script type="text/javascript">
	//DOM加载完毕执行
	$(document).ready(function(){
		$("#left_menu_business_type").addClass("selected");
	});
	
	function checkFiled(){
		
		var city_name=$("#city_name").val();
		if(city_name.trim()==""){
			$("#city_name_info").css("color","red");
			$("#city_name_info").html("* 分类名称必须填写");
			return false;
		}else{
			$("#city_name_info").css("color","green");
			$("#city_name_info").html("√");
		}
				
		return true;
	}
	
	function checkIdExist(city_id){
		var data_send = {};
           data_send.random = Math.random();
           data_send.id = city_id;
		var is_exist = true;
           var request =$.ajax({
               type: 'GET',
               url: '/cms/self/business_type/exist',
               data: data_send,
               dataType: 'json',
               async: false
           });

           request.fail(function( jqXHR, textStatus ) {
              alert("系统异常");
           });

           request.done(function(data) {
               if(data.is_exist){
               	is_exist = true;
               }else{               	
               	is_exist = false;
               }
               
           });
           
           return is_exist;
	}
	
</script>