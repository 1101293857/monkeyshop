<%@ page language="java" contentType = "text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="">分类管理</a><span class="crumb-step">&gt;</span><span>修改分类</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/monkeyShop/manage/admin_docateupdate" method="post" id="myform" name="myform">
                    <input type="hidden" name="id" value="${Cate.CATE_ID}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>父级分类：</th>
                                <td>
                                    <select class="common-text required"  name="parentid" >
                                    	<option value="0">根分类 </option>
                                    	<c:forEach var = "cate" items = "${catelist }">
                                    		<c:if test="${Cate.CATE_PARENT_ID==cate.CATE_ID }">
                                	               <option value="${cate.CATE_ID}" selected = "selected">${cate.CATE_NAME} </option>
                                            </c:if>   
                                            <c:if test="${Cate.CATE_PARENT_ID!=cate.CATE_ID && cate.CATE_PARENT_ID==0}">
                                	               <option value="${cate.CATE_ID}">${cate.CATE_NAME} </option>
                                            </c:if>     	    
                                    	</c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>分类名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="classname" size="50" value="${Cate.CATE_NAME }" type="text">
                                </td>
                            </tr>
                           
                            
                            
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="修改" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>