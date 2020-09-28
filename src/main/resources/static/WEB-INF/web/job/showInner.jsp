<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="typeListInfo">
	<div class="basicInfo ">
		<div class="basicConShow showDiv">
			<dl >
				<dt>
					<span>${job.title }</span> <span class="sexAge">[${company.name}]</span>
				</dt>
				<dd class="dd">					
					<span class="jobType">薪资 : ${job.salaryText() }</span>
					<span class="divide">|</span> 
					<span class="jobType">${job.educationText()}</span>
					<span class="divide">|</span>
					<span>${job.workYearsText()}</span>  					
					<span class="divide">|</span> 
					<span>招聘人数:  ${job.number } 人</span>
				</dd>
				<dd class="dd">
					<span class="jobType">工作地点：</span> 
					<span>${job.parentCity.name}-${job.city.name}</span>
				</dd>
				<dd class="dd">
					<span class="jobType">所属行业：</span> 
					<span>${job.industry.name }</span>
				</dd>
				<dd class="dd">
					<span class="jobType">职位类别：</span> 
					<span>${job.position.name}</span>
				</dd>
				<dd class="dd">
					<span class="jobType">刷新日期：</span> 
					<span class="jobType"><fmt:formatDate value="${job.updated_at}" pattern="yyyy-MM-dd HH:mm"/></span>					
				</dd>
			</dl>
		</div>
	</div>
	<div class="experInfo">
		<h3>
			<b class="tipx">*</b> <span id="ex">任职要求：</span> 
		</h3>
		<div id="expDiv" class="experConShow showDiv">		
				<dl>
					 <div class="">${job.description }</div>			
				</dl>	
				
		</div>
	</div>
	<div class="experInfo">
		<h3>
			<b class="tipx">*</b> <span id="ex">联系方式：</span> 
		</h3>
		<div id="expDiv" class="experConShow showDiv">			
				 <dl >
				 	<dd class="dd">
						<span class="jobType">职位联系人：</span> 
						<span>${job.contacts }</span>
					</dd>
				 	<dd class="dd">
						<span class="jobType">联系电话：</span> 
						<span>${job.telephone }</span>
					</dd>
					<dd class="dd">
						<span class="jobType">接受简历邮箱：</span> 
						<span>${job.email }</span>
					</dd>
					<dd class="dd">
						<span class="jobType">工作地址：</span> 
						<span>${job.address }</span>
					</dd>
				 </dl>		
		</div>
	</div>
	<div class="experInfo">
		<h3>
			<b class="tipx">*</b> <span id="ex">公司信息：</span> 
		</h3>
		<div id="expDiv" class="experConShow showDiv">			
				 <dl >
				 	<dd class="dd">
						<span class="jobType">公司名称：</span> 
						<span>${company.name}</span>
					</dd>
				 	<dd class="dd">
						<span class="jobType">公司性质：</span> 
						<span>${company.typeName() }</span>
					</dd>
					<dd class="dd">
						<span class="jobType">公司规模：</span> 
						<span>${company.sizeText()}</span>
					</dd>					
				 </dl>
				 <dl>
				 	<dd class="dd">
						<div class="jobType" style="float:left;">公司福利：</div> 	
						<input type="hidden" name="welfares" id="welfares" value="${company.welfares}">
						<div class="contedit zidx01">
							<ul class="welfare">
								<li  class="guding">五险一金</li>
								<li  class="guding">包吃</li>
								<li  class="guding">包住</li>
								<li  class="guding">每周双休</li>
								<li  class="guding">年底双薪</li>
								<li  class="guding">房补</li>
								<li  class="guding">话补</li>
								<li  class="guding">交补</li>
								<li  class="guding">饭补</li>
								<li  class="guding">加班补助</li>
							</ul>
						</div>	
							
					</dd>
				 </dl>
				 <dl>
				 	<dd class="dd">
						<span class="jobType">公司简介：</span> 						
					</dd>
					<div class="">${company.description}</div>	
				 </dl>		
				 
		</div>
	</div>
</div>
<script>
$(document).ready(function (){
	initWelfares('${company.welfares}');
});
</script>
