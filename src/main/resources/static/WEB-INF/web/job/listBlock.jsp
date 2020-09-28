<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="com.lucifer.util.ViewHelper" %>
<div style="margin-top:10px;">
    	<div class="topBox">
            <div class="tabBox"></div>
            <div class="border"></div>
        </div>
    	<div>                
    			 <c:forEach var="job" items="${jobList}" varStatus="status">
                <dl class="list-noimg job-list">
                    <dt>
                        <span><input type="checkbox"  name="job_ids" value="${job.id }"></span>
                        <span class="mouse">
                        <a href="/job/${job.id }" target="_blank" class="list_title">${job.title }</a>                        
                        </span>
                    </dt>
                    <dd class="company">${job.company.name }</dd>
                    <dd class="company">${job. salaryText() }</dd>
                    <dd class="pay">${job.parentCity.name }-${job.city.name }</dd>
                    <dd class="pub-time"><fmt:formatDate value="${job.updated_at}" pattern="yyyy-MM-dd HH:mm"/></dd>
                </dl>
                </c:forEach>                
         </div>
         	<div style="margin-top:10px;">
         		<div class="simple_button"  onclick="selectAll();">全选</div> 
         		<div class="simple_button" style="margin-left:20px;" onclick="applySelect();">申请选中职位</div>
         	</div>
</div>
<div class="page">
    <div class="paginator">
        <%= ViewHelper.willPaginate(request,Integer.MAX_VALUE, 20, new String []{"page"}) %>
    </div>
</div>