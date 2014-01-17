<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Dash Board</title>
<link href='<c:url value="/web/css/style.css"/>' rel="stylesheet"
	type="text/css" />
<script src="http://code.jquery.com/jquery-1.8.1.js"></script>
</head>

<div class="container">

	<div class="header">
		<jsp:include page="adminheader.jsp"></jsp:include>
		<div id="productForm">
			<b style="align:center">Product</b>		
		</div>
	</div>

</div>
</body>
</html>