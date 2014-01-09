<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>MERCHANT Dashboard</title>
<link href='<c:url value="/web/css/style.css"/>' rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	function onPriceCal() {
		var price = document.getElementById('actualPrice').value;
		var discper = document.getElementById('discount').value;
		var afterdic = (price) - ((price * discper) / 100);
		document.getElementById('afterdiscount').value = afterdic;
	}
</script>
</head>
<body onload="reduce_dbConnection()">
	<div class="container">
		<div class="header">
			<div id="logo">
				<a href="#"><img src='<c:url value="/web/images/logo.png"/>'
					alt="your logo here" border="0" class="imagedropshadow" /></a>
			</div>
			<div class="social">

				Welcome to Mobi Coupon <br> <a href="#"><img
					src='<c:url value="/web/images/facebook.jpg" />' alt="Become a fan"
					width="24" height="24" border="0" class="imagedropshadow" /></a><a
					href="#"><img src='<c:url value="/web/images/twitter.jpg"/>'
					alt="Follow on Twitter" width="24" height="24" border="0"
					class="imagedropshadow" /></a> <a href="#"><img
					src='<c:url value="/web/images/24b.png"/>' alt="Myspace" width="24"
					height="24" border="0" class="imagedropshadow" /></a> <a href="#"><img
					src='<c:url value="/web/images/google.jpg"/>' alt="Digg" width="24"
					height="24" border="0" class="imagedropshadow" /></a> <a href="#"><img
					src='<c:url value="/web/images/youtube.jpg" />' alt="Digg"
					width="24" height="24" border="0" class="imagedropshadow" /></a> <a
					href="#"><img src='<c:url value= "/web/images/youtube.jpg" />'
					alt="Digg" width="24" height="24" border="0"
					class="imagedropshadow" /></a> <a href="#"><img
					src='<c:url value="/web/images/blog.jpg"/>' alt="Digg" width="24"
					height="24" border="0" class="imagedropshadow" /></a>

				<div class="user_name">welcome to user name</div>
				<a href='<c:url value="/logout" />' class="readbutton right">Logout</a>

			</div>

			<div class="login" style="width: 100%; margin-top: 50px;">

				<div class="merchantname">Merchant Name:</div>
				<div class="mername">
					Mr/Ms. <span id="MerchantName"> </span>
				</div>
				<br> <br>
				<div id="productDetails">

					<div class="left mar_name">Reference ID</div>
					<div class="left mar_sno">Product Name</div>
					<div class="merchantdash" id="merchantdash">
						<div class="list_mar">
							<input type="hidden" value="dataNotExists" id="merchantDetails">
						</div>
					</div>



					<div class="marchbut" style="">
						<a href="addproduct.jsp?name="><input type="button"
							class="readbuttons createm" value="Add Product (AP)" /> </a> <a
							href="#"><input type="button" class="readbutton createm"
							value="Cancel" /></a>
					</div>
				</div>
			</div>
			<div id="view"></div>
		</div>

	</div>

</body>
</html>
