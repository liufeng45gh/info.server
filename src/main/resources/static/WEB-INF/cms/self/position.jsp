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
			<div class="position"><span>系统</span><span>|</span><span>职位管理</span><span>|</span><span>职位管理列表</span></div>	
				<div class="content form_content" >
					<jsp:include page="positionTree.jsp"></jsp:include>
				</div>
		</div>
		<div id="separator"></div>
	</div>

	<script type="text/javascript">
		//DOM加载完毕执行
		$(document).ready(function(){
			$("#left_menu_position").addClass("selected");
		});
		
		
	</script>


</body></html>