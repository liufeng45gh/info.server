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
<body style="zoom: 1;"><div class="" style="display: none; position: absolute;"><div class="aui_outer"><table class="aui_border"><tbody><tr><td class="aui_nw"></td><td class="aui_n"></td><td class="aui_ne"></td></tr><tr><td class="aui_w"></td><td class="aui_c"><div class="aui_inner"><table class="aui_dialog"><tbody><tr><td colspan="2" class="aui_header"><div class="aui_titleBar"><div class="aui_title" style="cursor: move; display: block;"></div><a class="aui_close" href="javascript:/*artDialog*/;" style="display: block;">×</a></div></td></tr><tr><td class="aui_icon" style="display: none;"><div class="aui_iconBg" style="background: none;"></div></td><td class="aui_main" style="width: auto; height: auto;"><div class="aui_content" style="padding: 20px 25px;"></div></td></tr><tr><td colspan="2" class="aui_footer"><div class="aui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="aui_e"></td></tr><tr><td class="aui_sw"></td><td class="aui_s"></td><td class="aui_se" style="cursor: se-resize;"></td></tr></tbody></table></div></div>
	<div class="container">
		<jsp:include page="../top_menu.jsp"></jsp:include>
		<div id="info_bar" >
			<label class="navindex" style="display:none;"><a href="#">快速导航管理</a></label>
			<span class="nav_sec"></span>
		</div>
		<jsp:include page="left_menu.jsp"></jsp:include>
		

		
		<div id="admin_right">
		
		<div class="content_box" >
				
			
			<div class="content form_content" >
				<jsp:include page="cityTree.jsp"></jsp:include>
				<form action="/cms/self/cityadd" method="post">
					<table class="form_table " style="font-size:12px;width:auto;margin-left:30px;">
						<colgroup><col width="150px"></col></colgroup>
							<tbody>
							<tr><th></th><td>添加新城市</td></tr>
							<tr>
								<th>城市id：</th>
								<td><input id="city_id" type="text" class="normal" name="id"    /><label id="city_id_info">* 城市id(正整数字)</label></td>
							</tr>
							<jsp:include page="cityFormField.jsp"></jsp:include>
							
							<tr>
								<th></th>
								<td>
									<button class="submit" type="submit" onclick="return checkFiled();"><span>保存设置</span></button>
								</td>
							</tr>
						</tbody>
					</table>	
				
				</form>
				
				
			</div>
		</div>
		</div>
		<div id="separator"></div>
	</div>

	


</body></html>