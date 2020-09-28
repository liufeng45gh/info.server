<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="dtree" style="float:left;text-align:left;font-size:14px;">
			
			<p><a href="javascript: d.openAll();">展开</a> | <a href="javascript: d.closeAll();">关闭</a></p>
			
			
			<script type="text/javascript">
				<!--
			
				d = new dTree('d');
			
				d.add(0,-1,'点击添加根节点','/cms/self/business_type/add?parent_id=0');
			
				<c:forEach var="businessType" items="${businessTypeList}" varStatus="status">
				 d.add('${businessType.id}' ,'${businessType.parent_id }','${businessType.name }','/cms/self/business_type/update?id=${businessType.id}');
				</c:forEach>
				
			
				document.write(d);
			
				//-->
			</script>
			
			</div>	