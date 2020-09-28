<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="com.lucifer.util.ViewHelper" %>
<link href="/css/zplist.css" rel="stylesheet" type="text/css">
<div  class="fl_middle">
    	<div>                
    			 <c:forEach var="appeal" items="${appealList}" varStatus="status">
                <dl class="list-noimg job-list">
                    <dt>
                       
                        <span class="mouse">
                        <a href="/appeal/show/${appeal.id }" target="_blank" class="list_title">${appeal.title }</a>                        
                        </span>
                    </dt>
                    <dd class="pay">${appeal.parentCity.name }-${appeal.city.name }</dd>
                    <dd class="pub-time"><fmt:formatDate value="${appeal.updated_at}" pattern="yyyy-MM-dd HH:mm"/></dd>
                </dl>
                </c:forEach>                
         </div>
</div>
<div class="page">
    <div class="paginator">
        <%= ViewHelper.willPaginate(request,Integer.MAX_VALUE, 20, new String []{"page"}) %>
    </div>
</div>