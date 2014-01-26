<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>SUBSUBPRODUCT</title>
		<link href='<c:url value="/web/css/style.css"/>' rel="stylesheet"
			type="text/css" />
		<link href='<c:url value="/web/css/mstyles.css"/>' rel="stylesheet"
			type="text/css" />
		<script src='<c:url value="/web/js/jquery.min.js" />'></script>
		<script type="text/javascript">
			
		$(document).ready(function(){
				
				$("#table #addButton").click(function(){
					$("#editForm").css('display','none');
					$("#addForm").css('display','block');
					
					
					$("#addForm #productId").change(function(){
						var Id = $(this).val();
						$.ajax({
							url: '<c:url value="/admin/viewSelectSubProducts" />',
							type: "post",
							data: {productId: Id},
							success: function(data){
								$("#subProductId").html(data);
							}
						});	
					});
				
				});
				
				$("#table #editButton").click(function(){
					
					$("#addForm").css('display','none');
					$("#editForm").css('display','block');
					
					var colum = $(this).parent().parent().find('td');
					var pname = colum.eq(0).html();
					var sname = colum.eq(1).html();
					var ssid = colum.eq(2).find('input').eq(0).val(); 
					var ssname = colum.eq(2).find('span').eq(0).html();
					
					$("#editForm #productName").val(pname);
					$("#editForm #subProductName").val(sname);
					$("#editForm #subSubProductId").val(ssid);
					$("#editForm #subSubProductName").val(ssname);
		
				});
				
				<c:if test="${not empty addFormErrors}">
					
					$("#editForm").css('display','none');
					$("#addForm").css('display','block');
					
					<c:forEach items="${addFormErrors}" var="list">
						var id = "#addForm #${list.field}";
						var msg = "${list.defaultMessage}";
						$(id).after("<span style='color:red'>"+ msg +"</span>");
					</c:forEach>
					
				</c:if>
				
				<c:if test="${not empty addErrors}">
					alert("Not Stored In DataBase");
				</c:if>
				
				<c:if test="${not empty editFormErrors}">
				
				$("#addForm").css('display','none');
				$("#editForm").css('display','block');
				
				<c:forEach items="${editFormErrors}" var="list">
					var id = "#editForm #${list.field}";
					var msg = "${list.defaultMessage}";
					$(id).after("<span style='color:red'>"+ msg +"</span>");
				</c:forEach>
				
			</c:if>
			
			<c:if test="${not empty editErrors}">
				alert("${editErrors}");
			</c:if>
			
			<c:if test="${not empty viewErorrs}">
				alert("${viewErrors}");
			</c:if>
			
			<c:if test="${not empty deleteErrors}">
				alert("${deleteErrors}");
			</c:if>
				
				
			});
			
		</script>
	</head>
	
	<body>
		<div class="container">
		
			<div class="header">
				<jsp:include page="adminheader.jsp"></jsp:include>
				<table class="tableclass" id="table" align="center">
					<tr>
						<td colspan="5" align="right"> <input type="button" value="+SubSubProduct" 
						 id="addButton" class="addButton" />  </td>
					</tr>
					<tr>
						<th>PRODUCT</th>
						<th>SUBPRODUCT</th>
						<th>SUBSUBPRODUCT</th>
						<th>EDIT</th>
						<th>DELETE</th>
					</tr>
					<c:forEach items="${viewList}" var="list">
						<tr>
							<c:if test="${not empty list.subSubProductId}">
								<td>${list.productName}</td>
								<td>${list.subProductName}</td>
								<td><span>${list.subSubProductName}</span>
								<input type="text" value=${list.subSubProductId} name="subSubProductId" id="subSubProductId" hidden="true"/></td>
								<td><input type="button" value="EDIT" id="editButton" class="editButton"/></td>
								<td><a href='<c:url value="/admin/deleteSubSubProduct?subSubProductId=${list.subSubProductId}" />'>DELETE</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<form id="addForm" class="addForm" action='<c:url value="/admin/addSubSubProduct"></c:url>' 
					 method="post" style="display:none">
					<table>
						<tr>
							<td>PRODUCT:</td>
							<td><select name="productId" id="productId">
									<option value="" selected>select</option>
									<c:forEach items="${viewProducts}" var="list">				
										<option value="${list.productId}">${list.productName}</option>
									</c:forEach>
								</select> </td>
						</tr>
						<tr>
							<td>SUBPRODUCTNAME:</td>
							<td><select name="subProductId" id="subProductId">
								<option value="" selected>select</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>SUBSUBPRODUCTNAME:</td>
							<td>
								<input type="text" name = "subSubProductName" id="subSubProductName"/>
							</td>
						</tr>
						<tr>	
							<td> <input type="submit" value="SUBMIT"/></td>
							<td> <input type="reset" value="RESET" /> </td>
						</tr>	
					</table>
				</form>
				<form id="editForm" name = "editForm" class="editForm" action='<c:url value="/admin/editSubSubProduct"></c:url>' 
					 method="post" style="display:none">
					<table>
						<tr>
							<td>PRODUCT:</td>
							<td><input type="text" name="productName" id="productName" readonly="readonly"> </td>
						</tr>
						<tr>
							<td>SUBPRODUCT:</td>
							<td><input type="text" name="subProductName" id="subProductName" readonly="readonly"/>
							</td>
						</tr>
						<tr>
							<td>SUBPRODUCTID:</td>
							<td><input type="text" name="subSubProductId" id="subSubProductId" readonly="readonly"/>
							</td>
						</tr>
						
						<tr>
							<td>SUBSUBPRODUCT:</td>
							<td>
								<input type="text" name = "subSubProductName" id="subSubProductName"/>
							</td>
						</tr>
						<tr>	
							<td> <input type="submit" value="SUBMIT"/></td>
							<td> <input type="reset" value="RESET" /> </td>
						</tr>	
					</table>
				</form>
			</div>
		
		</div>
	</body>
	
</html>