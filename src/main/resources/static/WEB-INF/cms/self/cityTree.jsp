<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="dtree" style="float:left;text-align:left;">
			
			<p><a href="javascript: d.openAll();">展开</a> | <a href="javascript: d.closeAll();">关闭</a></p>
			
			
			<script type="text/javascript">
				<!--
			
				d = new dTree('d');
			
				d.add(0,-1,'点击添加根节点','/cms/self/cityadd?parent_id=0');
			
				<c:forEach var="city" items="${cityList}" varStatus="status">
				 d.add(${city.id} ,${city.parent_id },'${city.name }','/cms/self/cityUpdate?id=${city.id}');
				</c:forEach>
				
			
				document.write(d);
			
				//-->
			</script>
			
			</div>	