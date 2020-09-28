<%@ page language="java" pageEncoding="utf-8"%>
<div id="admin_left" style="height:100%">
	<ul class="submenu">
		<li><span>后台首页</span>
			<ul name="menu"><li id="left_menu_welcome"><a href="/cms/self/welcome">后台首页</a></li></ul>
		</li>
		<li><span>地域管理</span>
			<ul name="menu"><li id="left_menu_city"><a href="/cms/self/city">地区列表</a></li></ul>
		</li>
		<li><span>行业管理</span>
			<ul name="menu"><li id="left_menu_class"><a href="/cms/self/industry">行业列表</a></li></ul>
		</li>
		<li><span>职位管理</span>
			<ul name="menu"><li id="left_menu_position"><a href="/cms/self/position">职位列表</a></li></ul>
		</li>
		
		<li><span>服务分类管理</span>
			<ul name="menu"><li id="left_menu_business_type"><a href="/cms/self/business_type">服务分类列表</a></li></ul>
		</li>
		
		<li><span>广告管理</span>
			<ul name="menu"><li id="left_menu_ad_add"><a href="/cms/ad/add">添加广告</a></li></ul>
			<ul name="menu"><li id="left_menu_ad"><a href="/cms/ad/list?type=the_new">广告列表</a></li></ul>
		</li>
		<li><span>搜索热词管理</span>
			<ul name="menu"><li id="left_menu_hot_add"><a href="/cms/hot/add">添加热词</a></li></ul>
			<ul name="menu"><li id="left_menu_hot"><a href="/cms/hot/list">热词列表</a></li></ul>
		</li>
		<li><span>个人资料</span>
			<ul name="menu">				
				<li id="left_menu_upnick"><a href="/cms/self/upnick">修改昵称</a></li>
			</ul>
			
			<ul name="menu">				
				<li id="left_menu_uppass"><a href="/cms/self/uppassword">修改密码</a></li>
			</ul>
		</li>
	</ul>
	
	<div id="copyright"></div>
</div>
<script>
$("#top_menu_self").addClass("selected");
</script>