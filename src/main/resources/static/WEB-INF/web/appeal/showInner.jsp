<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="typeListInfo">
	<div class="basicInfo ">
		<div class="basicConShow showDiv">
			<dl >
				<dt>
					<span>${appeal.title }</span> <span class="sexAge">[${appeal.businessType.name}]</span>
				</dt>
				
				<div style="clear:both;"></div>
				<dd class="dd">
					<span class="jobType">区域：</span> 
					<span>${appeal.parentCity.name}-${appeal.city.name}</span>
				</dd>
				<dd class="dd">
					<span class="jobType">联系人：</span> 
					<span>${appeal.linkman }</span>
				</dd>
				<dd class="dd">
					<span class="jobType">联系电话：</span> 
					<span>${appeal.telephone }</span>
				</dd>
				<dd class="dd">
					<span class="jobType">刷新日期：</span> 
					<span class="jobType"><fmt:formatDate value="${appeal.updated_at}" pattern="yyyy-MM-dd HH:mm"/></span>					
				</dd>
			</dl>
		</div>
	</div>
	<div class="experInfo">
		<h3>
			<b class="tipx">*</b> <span id="ex">需求介绍：</span> 
		</h3>
		<div id="expDiv" class="experConShow showDiv">		
				<dl>
					 <div class="">${appeal.description }</div>			
				</dl>	
				
		</div>
	</div>
	
	
</div>

