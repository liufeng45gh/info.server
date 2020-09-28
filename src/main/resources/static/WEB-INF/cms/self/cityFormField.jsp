<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tr>
	<th>区域名称：</th>
	<td><input id="city_name" type="text" class="normal" name="name" value="<c:out value="${city.name}"/>" /><label id="city_name_info">* 区域名称</label></td>
</tr>
<tr>
	<th>密码：</th>
	<td><input id="city_password" type="text" class="normal" name="password" value="<c:out value="${city.password}"  default="123456"/>"  /><label id="city_password_info">* 密码</label></td>
</tr>
				
<tr>
	<th>父级城市：</th>
	<td>
	<input id="parent_city" type="text" class="normal" readonly="true" value="<c:out value="${parnetCity.name}"  />"  />
	<input type="hidden" name="parent_id" value="<c:out value="${parnetCity.id}"/>" />
	</td>
</tr>

<script type="text/javascript">
	//DOM加载完毕执行
	$(document).ready(function(){
		$("#left_menu_city").addClass("selected");
	});
	
	function checkFiled(){
		<c:if test="null==${city }">
		var city_id=$("#city_id").val();
		if(city_id.trim()==""){
			$("#city_id_info").css("color","red");
			$("#city_id_info").html("* 城市id必须填写");
			return false;
		}else if(checkIdExist(city_id)){
			$("#city_id_info").css("color","red");
			$("#city_id_info").html("* 城市id已被占用");
			return false;
		}else{
			$("#city_id_info").css("color","green");
			$("#city_id_info").html("√");
		}
		</c:if>
		var city_name=$("#city_name").val();
		if(city_name.trim()==""){
			$("#city_name_info").css("color","red");
			$("#city_name_info").html("* 城市名称必须填写");
			return false;
		}else{
			$("#city_name_info").css("color","green");
			$("#city_name_info").html("√");
		}
		
		var city_password=$("#city_password").val();
		if(city_password.trim()==""){
			$("#city_password_info").css("color","red");
			$("#city_password_info").html("* 城市拼音必须填写");
			return false;
		}else{
			$("#city_password_info").css("color","green");
			$("#city_password_info").html("√");
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
               url: '/cms/self/exist',
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