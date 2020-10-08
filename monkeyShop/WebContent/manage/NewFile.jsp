<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<c:out value="Hello JSP 2.0 !!" /><br/>
<c:out value="${ 3 + 5 }" /><br/>
<% out.print("Hello JSP 2.0 !!");%>
</body> 
</html>