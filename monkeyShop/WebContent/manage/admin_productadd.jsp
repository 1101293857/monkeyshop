<%@ page language="java" contentType = "text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">产品管理</a><span class="crumb-step">&gt;</span><span>新增产品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/monkeyShop/manage/admin_doproductadd" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                                <th><i class="require-red">*</i>产品名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productname" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>产品分类：</th>
                                <td>
                                    <select class="common-text required"  name="parentid" >
                                    	<c:forEach var = "f" items = "${flist }">
                                    		 <option value="${f.CATE_ID}" disabled="disabled">|-${f.CATE_NAME} </option>
                                    		 <c:forEach var = "c" items = "${clist }">
                                    		      <c:if test="${c.CATE_PARENT_ID==f.CATE_ID}">
                                    		          <option value="${c.CATE_ID}-${f.CATE_ID}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${c.CATE_NAME} </option>
                                    		      </c:if>
                                    		        	    
                                    	      </c:forEach>       	    
                                    	</c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>产品图片：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productphoto" size="50" value="" type="file">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>产品价格：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productprice" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>产品介绍：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productdesc" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>库存数量：</th>
                                <td>
                                    <input class="common-text required" id="title" name="productnum" size="50" value="" type="text">
                                </td>
                            </tr>
                           
                            
                            
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
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