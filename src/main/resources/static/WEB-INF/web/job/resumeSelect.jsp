<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!-- saved from url=(0061)http://user.qd8.com.cn/users/usbaselist/users_emailcheck.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="../head.jsp"></jsp:include>



<body>
        <div class="globalContainer clearfix">
            <div class="mainContainer">
                <div class="rightCol">
                <div>
                    <div class="rightBody" style="margin-top:20px;">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="t-comment mt10">
                            <tbody>
                                <tr class="bg-blue height24" style="height:30px;">
                                	<td style="text-align:center" width="10%"></td>
                                    <td style="text-align:center" width="60%">简历名称</td>
                                    <td style="text-align:center" width="30%">更新日期</td>                                    
                                </tr>
                               
                                 <c:forEach var="resume" items="${resumeList}" varStatus="status">
                                 <tr style="height:30px;">
                                 	<td style="text-align:center"><input type="checkbox" onclick="clearChecked(this)" class="resume_checkbox" value="${resume.id}"></td>
                                     <td style="text-align:center">${resume.title}
                                         (正常显示)  
                                     </td>
                                     <td style="text-align:center"><fmt:formatDate value="${resume.updated_at}" pattern="yyyy-MM-dd HH:mm"/></td>
                                    
                                 </tr>
                                 </c:forEach>
                            
                                <!--帖子循环开始 -->
                                
                                <!--帖子循环结束 -->
                            </tbody>
                        </table>
                        
                        <div class="clearfix">&nbsp;</div>
                                             
                        <a   class="simple_button" style="margin-top:10px;display:block;float:right;margin-right:30px;" href="#" onclick="openApplyJob();return false;">确认选择</a>
                       
                    </div>
                   
                </div>
            </div>
                <!--左侧菜单开始 -->
                
				



                <!--左侧菜单结束 -->
            </div>

        </div>
        

    
<script type="text/javascript">
function openApplyJob(){
	var resume_id = null;
	$(".resume_checkbox").each(function () {
		if (this.checked) {
			resume_id = this.value;
		}
	});
	if (resume_id == null) {
		alert("请选择简历");
	}
	window.parent.applyJob(resume_id);
}

function clearChecked(object){
	$(".resume_checkbox").each(function () {
		if (this != object) {
			this.checked = false;
		}
	});
}
</script>


</body></html>