<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>后台管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="/cms/css/admin.css">
	<link rel="shortcut icon" href="/cms/images/favicon.ico">
	<script type="text/javascript" charset="UTF-8" src="/script/jquery-1.9.1.min.js"></script>
	<link rel="StyleSheet" href="/dtree/dtree.css" type="text/css" />
	<script type="text/javascript" src="/dtree/dtree.js"></script>
	<link rel="stylesheet" type="text/css" href="/script/jquery/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/script/jquery/themes/icon.css">
	<script type="text/javascript" src="/script/jquery/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/script/jquery/demo/demo.css">
	
</head>
<body style="zoom: 1;">
	<div class="container">
		<jsp:include page="../top_menu.jsp"></jsp:include>
		<div id="info_bar" >
			<label class="navindex" style="display:none;"><a href="#">快速导航管理</a></label>
			<span class="nav_sec"></span>
		</div>
		<jsp:include page="left_menu.jsp"></jsp:include>
		
		<div id="admin_right">
		
			<div class="position"><span>系统</span><span>|</span><span>分类管理</span><span>|</span><span>分类管理列表</span></div>	
			<div class="content form_content" style="font-size:14px;">
				<jsp:include page="positionTree.jsp"></jsp:include>
				<form action="/cms/self/position/add" method="post">
					<table class="table_new">
						<tbody>
						<!-- 
						<tr>
							<th>分类id：</th>
							<td><input id="city_id" type="text" class="normal" name="id"    /><label id="city_id_info">* 分类id(正整数字)</label></td>
						</tr>
						 -->
						<jsp:include page="positionFormField.jsp"></jsp:include>
						
						<tr>
							<th></th>
							<td>
								<button class="easyui-linkbutton" data-options="iconCls:'icon-save'"  type="submit" onclick="return checkFiled();"><span>保存设置</span></button>
							</td>
						</tr>
						</tbody>
					</table>	
				</form>
			</div>
		</div>
		<div id="separator"></div>
	</div>

</body></html>