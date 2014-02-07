<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>MERCHANT ADD FORM</title>
		<script src='<c:url value="/web/js/jquery.min.js"></c:url>'></script>
		<link href='<c:url value="/web/css/style.css"></c:url>' rel="stylesheet" type="text/css" />
		<link href='<c:url value="/web/css/mstyles.css"></c:url>' rel="stylesheet" type="text/css"/>
		<script type="text/javascript">
			
			$(document).ready(function(){
				var id, msg;
				
				<c:if test="${not empty addFormErrors}">
					<c:forEach items="${addFormErrors}" var="list">					
						id = ' #${list.field}';
						msg = '${list.defaultMessage}';
						$(id).after("<span style='color:red'>"+ msg +"</span>");
					</c:forEach>
				</c:if>
				
				<c:if test="${not empty editError}" >
					<c:forEach items="${editError}" var="error"> 
						alert("${error}");
					</c:forEach>
				</c:if>
				
				<c:if test="${not empty emailError}">
					$("#corporateEmailId").after("<span style='color:red'> ${emailError} </span>");
				</c:if>
				
				
				<c:if test="${not empty landLineError}">
					$("#landLine").after("<span style='color:red'> ${landLineError} </span>");
				</c:if>
				
				<c:if test="${not empty mobileError}">
					$("#mobile").after("<span style='color:red'> ${mobileError} </span>");
				</c:if>
				
				<c:if test="${not empty pContactError}" >
					$("#personalContactNum").after("<span style='color:red' > ${pContactError} </span>");
				</c:if>
				
			});
		</script>
		
	</head>
<body>
	<div class="container">
		<div class="header">
			<jsp:include page="adminheader.jsp"></jsp:include>
			<div class="d_form">
				<form action='<c:url value="/admin/addMerchant"></c:url>' name="merchantAddForm" id="merchantAddForm" 
				method="post">
					<table id="tableclass" class="tableclass">
						
						<tr>
							<td>Name</td>
							<td><input type="text" name="merchantName" id="merchantName"/></td>
						</tr>
						
						<tr>
							<td>CompanyName</td>
							<td><input type="text" name="companyName" id="companyName"></td>
						</tr>
						
						<tr>
							<td>Designation</td>
							<td>
								<select id="desgId" name="desgId">
									<option value="" selected>select</option>
									<c:forEach items="${desgList}" var="list">
										<option value="${list.desgId}">${list.desgName}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>Department</td>
							<td>
								<select id="deptId" name="deptId">
									<option value="" selected>select</option>
									<c:forEach items="${deptList}" var="list">
										<option value="${list.deptId}">${list.deptName}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>Address</td>
							<td><input type="text" name="address" id="address"/> </td>
						</tr>
						
						<tr>
							<td>Mobile</td>
							<td><input type="text" name="mobile" id="mobile"> </td>
						</tr>
						
						<tr>
							<td>Phone</td>
							<td><input type="text" name="landLine" id="landLine"></td>
						</tr>
						
						<tr>
							<td>email</td>
							<td><input type="text"  name="corporateEmailId" id="corporateEmailId" /></td>
						</tr>
						
						<tr>
							<td>Website</td>
							<td><input type="text" name="website" id="website" /></td>
						</tr>
						
						<tr>
							<td>username</td>
							<td><input type="text" name="userName" id="userName"/></td>
						</tr>
						
						<tr>
							<td>password</td>
							<td><input type="password" name="password" id="password" /></td>
						</tr>
						
						<tr>
							<td>Authority</td>
							<td>
								<select id="authority" name="authority" >
									<option value="" selected>select</option>
									<option value="ROLE_MERCHANT">MERCHANT</option>
								</select>
							</td>
						</tr>
											
						<tr>
							<td>personalContactNum</td>
							<td><input type="text" name="personalContactNum" id="personalContactNum" /></td>
						</tr>
						
						<tr>
							<td  align="right"><input type="submit" value="Submit" /></td>
							<td colspan="2" align="left"><input type="reset"  />  </td>
						</tr>
						
					
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>