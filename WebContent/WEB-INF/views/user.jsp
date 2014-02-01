<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Dash Board</title>
		<link href='<c:url value="/web/css/style.css"/>' rel="stylesheet"
			type="text/css" />
		<link href='<c:url value="/web/css/mstyles.css"/>' rel="stylesheet"
			type="text/css" />
		<script src='<c:url value="/web/js/jquery.min.js"></c:url>'></script>
		<script type="text/javascript">
			$(document).ready(function(){
				
				$("#addUser").click(function(){
					$("#editForm").css('display','none');
					$("#addForm").css('display','block');
				});
				
				$("#editButton").click(function(){
					$("#addForm").css('display','none');
					$("#editForm").css('display','block');
					
					var row = $(this).parent().parent();
					
					var id = row.find('td').eq(0).html();
					var name = row.find('td').eq(1).html();
					var company = row.find('td').eq(2).html();
					var designation = row.find('td').eq(3).html();
					var email = row.find('td').eq(4).html();
					var mobile = row.find('td').eq(5).html();
					var userName = row.find('td').eq(6).html();
					var password = row.find('td').eq(7).html();
					
					$("#editForm #id").val(id);
					$("#editForm #name").val(name);
					$("#editForm #company").val(company);
					$("#editForm #designation").val(designation);
					$("#editForm #email").val(email);
					$("#editForm #mobile").val(mobile);
					$("#editForm #userName").val(userName);
					$("#editForm #password").val(password);
				});
				
				<c:if test="${not empty viewList}">
					alert("${viewList}");
				</c:if>
				
				<c:if test="${not empty deleteError}">
					alert("${deleteError}");
				</c:if>
				
				<c:if test="${not empty addFormErrors}">
					$("#editForm").css('display','none');
					$("#addForm").css('display','block');
					<c:forEach items="${addFormErrors}" var="list" >
						var id = "#addForm #${list.field}";
						var msg = "${list.defaultMessage}";
						$(id).after("<span style='color:red'>"+msg+"</span>")
					</c:forEach>
				</c:if>
				
				<c:if test="${not empty updateFormErrors}">
					
					$("#addForm").css('display','none');
					$("#editForm").css('display','block');
					
					<c:forEach items="${updateFormErrors}" var="list" >
						var id = "#editForm #${list.field}";
						var msg = "${list.defaultMessage}";
						$(id).after("<span style='color:red'>"+msg+"</span>")
					</c:forEach>
						
				</c:if>
				
			});
		</script>
		
	</head>
	
	<body>
		<div class="container">
		
			<div class="header">
				<jsp:include page="adminheader.jsp"></jsp:include>
				
				<div id="user" class="user">
					<table class="tableclass" id="tableclass">
						<tr>
							<td colspan="9" align="right">
								<input type="button" id="addUser" value="+User" />
							</td>
						</tr>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Company</th>
							<th>Designation</th>
							<th>email</th>
							<th>mobile</th>
							<th>UserName</th>
							<th>password</th>
							</tr>
						<c:forEach items="${list}" var="list" >
							<tr>
								<td>${list.id}</td>
								<td>${list.name}</td>
								<td>${list.company}</td>
								<td>${list.designation}</td>
								<td>${list.email}</td>
								<td>${list.mobile}</td>
								<td>${list.userName}</td>
								<td>${list.password}</td>
								<td><a href='<c:url value="/admin/deleteUser?id=${list.id}"></c:url>'>DELETE</a></td>
								<td><input type="button" value="EDIT" id="editButton" class="editButton"/></td>
							</tr>	
						</c:forEach>	
					</table>	
				</div>
				<div id = "userAdd" class="userAdd" >
					<form action='<c:url value="/admin/addUser"></c:url>' name="addForm" id="addForm" method="post"
					autocomplete="off" style="display:none">
						<table>
							
							<tr>
								<td>Name</td>
								<td><input type="text" name = "name" id= "name" /></td>
							</tr>
							<tr>
								<td>Company</td>
								<td><input type="text" name = "company" id= "company" /></td>
							</tr>
							<tr>
								<td>Designation</td>
								<td><input type="text" name = "designation" id= "designation" /></td>
							</tr>
							<tr>
								<td>email</td>
								<td><input type="text" name = "email" id= "email" /></td>
							</tr>
							<tr>
								<td>mobile</td>
								<td><input type="text" name = "mobile" id= "mobile" /></td>
							</tr>
							<tr>
								<td>UserName</td>
								<td><input type="text" name = "userName" id= "userName" /></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><input type="text" name = "password" id= "password" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Save"></td>
								<td><input type="reset" value="reset" /></td>
							</tr>						
						</table>
					</form>
					<form action='<c:url value="/admin/updateUser"></c:url>' name="editForm" id ="editForm" method="post"
					autocomplete="off" style="display:none">
						<table>
							<tr>
								<td>Id</td>
								<td><input type="text" name = "id" id="id" /></td>
							</tr>
							<tr>
								<td>Name</td>
								<td><input type="text" name = "name" id= "name" /></td>
							</tr>
							<tr>
								<td>Company</td>
								<td><input type="text" name = "company" id= "company" /></td>
							</tr>
							<tr>
								<td>Designation</td>
								<td><input type="text" name = "designation" id= "designation" /></td>
							</tr>
							<tr>
								<td>email</td>
								<td><input type="text" name = "email" id= "email" /></td>
							</tr>
							<tr>
								<td>mobile</td>
								<td><input type="text" name = "mobile" id= "mobile" /></td>
							</tr>
							<tr>
								<td>UserName</td>
								<td><input type="text" name = "userName" id= "userName" /></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><input type="text" name = "password" id= "password" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Update"></td>
								<td><input type="reset" value="reset" /></td>
							</tr>						
						</table>
					</form>				
				</div>
				
			</div>
		
		</div>
	</body>
	
</html>