<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Mobi Coupon</title>
		<link href='<c:url value="/web/css/style.css"/>' rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div class="container">
			<header>
				<div id="logo">
					<a href="#"><img src='<c:url value="web/images/logo.png"/>'
						alt="your logo here" border="0" class="imagedropshadow" /></a>
				</div>
				<div class="social">

					Welcome to Mobi Coupon <br> <a href="#"><img
						src='<c:url value="/web/images/facebook.jpg" />' alt="Become a fan" width="24"
						height="24" border="0" class="imagedropshadow" /></a><a href="#"><img
						src='<c:url value="/web/images/twitter.jpg" />' alt="Follow on Twitter" width="24"
						height="24" border="0" class="imagedropshadow" /></a><a href="#"><img
						src='<c:url value="/web/images/24b.png"/>' alt="Myspace" width="24" height="24"
						border="0" class="imagedropshadow" /></a><a href="#"><img
						src='<c:url value="/web/images/24b.png"/>' alt="Digg" width="24" height="24"
						border="0" class="imagedropshadow" /></a><a href="#"><img
						src='<c:url value="/web/images/linked.jpg"/>' alt="Digg" width="24" height="24"
						border="0" class="imagedropshadow" /></a><a href="#"><img
						src='<c:url value="/web/images/youtube.jpg" />' alt="Digg" width="24" height="24"
						border="0" class="imagedropshadow" /></a><a href="#"><img
						src='<c:url value="/web/images/blog.jpg"/>' alt="Digg" width="24" height="24"
						border="0" class="imagedropshadow" /></a>

				</div>
				<div style="width: 100%; float: left; margin-top: 50px;">
					<div class="login alogin">
						<form action='<c:url value="/validate" />' method="post">
							<span class="adlogin"> <b> ADMIN LOGIN</b>
							</span> <br /> <span id="loginStatus"></span> <br /> <span class="left">
								Username:</span> <input type="email" name="username"
								id="adminUsername" class="uname" required size="30" /> <br /> <br />
							<span class="left"> Password:</span> <input type="password"
								name="password" id="adminPassword" class="pass" required
								size="30" /> <br />
							<div>
								<br /> <span class="forget_one"> <a
									href="adminforgotpass.html">Forgot Possword?</a></span> <input
									type="submit" class="readbutton lfp" value="Login" />
							</div>
						</form>
					</div>
					<div class="login mainmarchant">
						<span class="mlogin"> <b> MERCHANT LOGIN</b>
						</span> <br /> <br />
						<form action='<c:url value="/validate" />' method="post">
							<span class="left"> Username:</span> <input type="email"
								name="username" id="merchantUsername" class="uname"
								required size="30" /> <br /> <br /> <span class="left">
								Password:</span> <input type="password" name="password"
								id='merchantPassword' class="pass" size="30" /> <br />
							<div>
								<br /> <input type="Submit" class="readbutton rsb" value="Login" />
								<a href="merchantreg.html"> <input type="button"
									class="readbutton rnm" value="New Merchant"></a> <br> <span
									class="rfp"><a href="merchantforgotpass.jsp">Forgot
										Possword?</a></span>
							</div>
						</form>
					</div>
				</div>
			</header>
		</div>
	</body>
</html>