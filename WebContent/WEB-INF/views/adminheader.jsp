<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<div id="logo">
			<a href="#"><img
				src='<c:url value="/web/images/logo.png"></c:url>'
				alt="your logo here" border="0" class="imagedropshadow" /></a>
		</div>
		<div class="social">

			Welcome to Mobi Coupon <br> <a href="#"><img
				src='<c:url value="/web/images/facebook.jpg"></c:url>'
				alt="Become a fan" width="24" height="24" border="0"
				class="imagedropshadow" /></a><a href="#"><img
				src='<c:url value="/web/images/twitter.jpg"></c:url>'
				alt="Follow on Twitter" width="24" height="24" border="0"
				class="imagedropshadow" /></a><a href="#"><img
				src='<c:url value="/web/images/24b.png"></c:url>' alt="Myspace"
				width="24" height="24" border="0" class="imagedropshadow" /></a><a
				href="#"><img src='<c:url value="/web/images/google.jpg" />' alt="Digg" width="24" height="24" border="0"
				class="imagedropshadow" /></a><a href="#"><img
				src='<c:url value="/web/images/linked.jpg"></c:url>' alt="Digg"
				width="24" height="24" border="0" class="imagedropshadow" /></a><a
				href="#"><img
				src='<c:url value="/web/images/youtube.jpg"></c:url>' alt="Digg"
				width="24" height="24" border="0" class="imagedropshadow" /></a><a
				href="#"><img src='<c:url value="/web/images/blog.jpg"></c:url>'
				alt="Digg" width="24" height="24" border="0" class="imagedropshadow" /></a>

			<div class="user_name">welcome to user name</div>
			<a href='<c:url value="/logout" ></c:url>' class="readbutton right">logout</a>
		</div>

		<div class="tabs master_tab">
			<ul class="Master" id="menu-bar" style="float: left;">
				<li class="headerm" style="list-style-type: none;"><a
					style="color: #D8EEFD;" href="#">Master</a>
					<ul class="submenu"
						style="margin-top: 0px; margin-right: -50px; width: 96%; z-index: 6; margin-left: 0;">
						<li class="subdown select"><a style="color: #FFF;"
							href='<c:url value="/admin/department"></c:url>' >Department</a></li>
						<li class="subdown select2"><a style="color: #FFF;"
							href='<c:url value="/admin/designation"></c:url>' >Designation</a></li>
						<li class="subdown select3"><a style="color: #FFF;"
							href='<c:url value="/admin/viewProduct" />'>Product</a></li>
						<li class="subdown select4"><a style="color: #FFF;"
							href='<c:url value="/admin/viewSubProduct"></c:url>'>Sub Product</a></li>
						<li class="subdown select5"><a style="color: #FFF;"
							href='<c:url value="/admin/viewSubSubProduct" />'>Sub Child product</a></li>
					</ul></li>
			</ul>
			<ul id="menu-bar" style="float: left; padding-left: 0.7%;">
				<li class="headerms" style="list-style-type: none;"><a
					style="color: #D8EEFD;" href="#">Merchant</a>
					<ul class="submenus"
						style="margin-top: 0px; margin-right: -50px; width: 96%; z-index: 6; margin-left: 0;">
						<li class="subdowns select"><a style="color: #FFF;"
							href='<c:url value="/admin/add"></c:url>' >Create Merchant</a></li>
						<li class="subdowns select2"><a style="color: #FFF;"
							href='<c:url value="/admin/partOfView"></c:url>'>View Merchant</a></li>
					</ul></li>
			</ul>
			<ul class="ucreation" id="menu-bar"
				style="float: left; padding-left: 0.7%;">
				<li class="headerms3" style="list-style-type: none;"><a
					style="color: #D8EEFD;" href="#">User Creation</a>
					<ul class="submenus3"
						style="margin-top: 0px; margin-right: -50px; width: 96%; z-index: 6; margin-left: 0;">
						<li class="subdowns3 vusers"><a style="color: #FFF;"
							href='<c:url value="/admin/userView"></c:url>'>View Users</a></li>
						<li class="subdowns3 cusers"><a style="color: #FFF;"
							href="adminuserCreation.jsp">Create Users</a></li>
					</ul></li>
			</ul>
		</div>