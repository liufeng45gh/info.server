<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="selection">
	<dl class="secitem">
		<dt class="secitem_brand">区块 ：</dt>
		<dd id="ObjectType">
						<a >${topType.name }</a>											
		</dd>
    </dl>
	<input type="hidden" id="selected_type_id" value="${selected_type_id}">
	<dl class="secitem">
		<dt class="secitem_brand">类别 ：</dt>
		<dd id="ObjectType">
				<a type_id="${topType.id }" class="type_select  <c:if test="${childType == null}"> select</c:if>">全部</a>
				<c:forEach var="aChildType" items="${topType.children()}" varStatus="status">
				<a type_id="${aChildType.id }" class="type_select  <c:if test="${childType.id == aChildType.id}"> select</c:if>">${ aChildType.name}</a>
				</c:forEach>											
		</dd>
    </dl>
	
	<dl class="secitem">
		<dt class="secitem_brand">服务区域  ：</dt>
		<dd id="local">
				<div class="item-info">
	                <div class="select_input_div">
	                	<input type="text"  readonly class="sel-text w80 work_province"  id="work_province" value="${parentCity.name}"  placeholder="请选择">
	                	<input type="hidden" id="work_pcity_id" name="pcity_id" value="${parentCity.id}">
	                	<div class="sel-arrow js-select-show work_province" ></div>
	                	<div class="js-select-option sel-option w116" id="work_province_options">
	                	</div>
	                </div>            
	                <div style="margin-left:20px;" class="select_input_div">
	                	<input type="text" value="${city.name}" readonly class="sel-text w80 work_city" id="work_city"   placeholder="请选择">
	                	<input type="hidden" id="work_city_id" name="city_id" value="${city.id}">
	                	<div class="sel-arrow js-select-show work_city" ></div>
	                	<div class="js-select-option sel-option w116" id="work_city_options">
	                	</div>
	                </div> 
        		</div>		
        		<div style="margin-left:20px;float:left;"><a href="/appeal/${selected_type_id}" >不限区域</a>	</div>
        														
		</dd>
    </dl>	
</section>
<div class="tabsbar">
    <div class="list-tabs">
			${selectedType.name }
	</div>	
</div>
<jsp:include page="listBlock.jsp"></jsp:include>
