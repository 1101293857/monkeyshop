<%@ page language="java" contentType = "text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
        
        <div class="result-wrap"> 
            <form action="/monkeyShop/manage/admin_douserdel" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/monkeyShop/manage/admin_toproductadd"><i class="icon-font"></i>新增产品</a>
     
                        <!--a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a !-->                    
                        </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>ID</th>
                            <th>产品名称</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="u" items="${list}">
                        
                        	<tr>
                        		<td>${u.PRODUCT_ID }</td>
                        		<td><img src="../images/product/${u.PRODUCT_FILENAME }" width="80" height="80">${u.PRODUCT_FILENAME }</td>
                        		<td>
                        			<a href="">修改</a>
                        			<a href="">删除</a>
                        		</td>
                        	</tr>
                            
                        
                        </c:forEach>
                        
                        <script>
                        	function catedel( url){
                        		if(confirm("你确定要删除吗")){
                        			location.href="admin_docatedel?id="+url;
                        		}
                        	}
                        	
                        	
                        </script>
                    </table>
                   
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>