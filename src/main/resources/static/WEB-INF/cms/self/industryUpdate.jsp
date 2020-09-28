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
<body style="zoom: 1;"><div class="" style="display: none; position: absolute;"><div class="aui_outer"><table class="aui_border"><tbody><tr><td class="aui_nw"></td><td class="aui_n"></td><td class="aui_ne"></td></tr><tr><td class="aui_w"></td><td class="aui_c"><div class="aui_inner"><table class="aui_dialog"><tbody><tr><td colspan="2" class="aui_header"><div class="aui_titleBar"><div class="aui_title" style="cursor: move; display: block;"></div><a class="aui_close" href="javascript:/*artDialog*/;" style="display: block;">×</a></div></td></tr><tr><td class="aui_icon" style="display: none;"><div class="aui_iconBg" style="background: none;"></div></td><td class="aui_main" style="width: auto; height: auto;"><div class="aui_content" style="padding: 20px 25px;"></div></td></tr><tr><td colspan="2" class="aui_footer"><div class="aui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="aui_e"></td></tr><tr><td class="aui_sw"></td><td class="aui_s"></td><td class="aui_se" style="cursor: se-resize;"></td></tr></tbody></table></div></div>
	<div class="container">
		<jsp:include page="../top_menu.jsp"></jsp:include>
		<div id="info_bar" >
			<label class="navindex" style="display:none;"><a href="#">快速导航管理</a></label>
			<span class="nav_sec"></span>
		</div>
		<jsp:include page="left_menu.jsp"></jsp:include>
		

		
		<div id="admin_right">
		
			<div class="position"><span>系统</span><span>|</span><span>行业管理</span><span>|</span><span>行业管理列表</span></div>	
			<div class="content form_content" style="font-size:14px;">
			<jsp:include page="industryTree.jsp"></jsp:include>
				<form action="/cms/self/industry/update" method="post" id="city_form">
					<table class="table_new">
						<tbody>
						<tr>
							<th align="right" width="20%">分类id:</th>
							<td><input id="city_id" type="text" class="easyui-textbox" name="id"  readonly="readonly" value="${industry.id }"  /><label id="city_id_info">* 系统分配</label></td>
						</tr>
						<jsp:include page="industryFormField.jsp"></jsp:include>
						
						<tr>
							<th></th>
							<td>
								<button class="easyui-linkbutton" type="submit" onclick="return checkFiled();"><span>保存设置</span></button>
								<c:if test="${industry.terminal }">
								<button class="easyui-linkbutton" type="button" onclick="delCity();" ><span>删除分类</span></button>
								</c:if>
								<button class="easyui-linkbutton" type="button" onclick="addCity();" ><span>添加子节点</span></button>
							</td>
						</tr>
						</tbody>
					</table>	
				</form>
			</div>
		</div>
		<div id="separator"></div>
	</div>
<script type="text/javascript">
function delCity(){
	if(confirm("确定删除分类?")){
		$("#city_form").attr("action","/cms/self/industry/delete");
		$("#city_form").submit();
	}
	
}

function addCity(){
	window.location.href="/cms/self/industry/add?parent_id=${industry.id}"
}
</script>
	


</body></html>