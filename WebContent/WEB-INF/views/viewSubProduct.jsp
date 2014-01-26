<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Dash Board</title>
		<link href='<c:url value="/web/css/style.css"/>' rel="stylesheet"
			type="text/css" />
		<link href='<c:url value="/web/css/mstyles.css"></c:url>' rel="stylesheet" type="text/css"/>
		<script src='<c:url value="/web/js/jquery.min.js"></c:url>'></script>
		<script type="text/javascript">
			$(document).ready(function(){
				
				$("#addButton").click(function(){
					$("#editForm").css('display','none');
					$("#addForm").css('display','block');
				});
				
				$("table tr td #editButton").click(function(){
					$("#addForm").css('display','none');
					$("#editForm").css('display','block');
					var cols = $(this).parent().parent().find('td');
					var pname = cols.eq(0).html();
					var spid = cols.eq(1).find('input').eq(0).val();
					var spname = cols.eq(1).find('span').eq(0).html();
					$("#editForm #subProductId").val(spid);
					$("#editForm #productName").val(pname);
					$("#editForm #subProductName").val(spname);
				});
				
				<c:if test="${not empty addFormError}">
					$("#editForm").css('display','none');
					$("#addForm").css('display','block');
					<c:forEach items="${addFormError}" var="list" >
						var msg ="${list.defaultMessage}";
						$('#addForm #${list.field}').after("<span style='color:red'>"+ msg+"</span>");
					</c:forEach>
				</c:if>
				
				<c:if test="${not empty addError}" >
					alert("NOT INSERTED INTO DATABASE");
				</c:if>
				
				<c:if test = "${not empty editFormErrors}">
					$("#addForm").css('display','none');
					$("#editForm").css('display','block');
					<c:forEach items="${editFormErrors}" var = "list">
						var msg = "${list.defaultMessage}";
						$("#editForm #${list.field}").after("<span style='color:red'>"+ msg +"<span/>");
					</c:forEach>
				</c:if>
				
				<c:if test = "${not empty editError}">
					alert("NOT INSERTED INTO DATABASE");
				</c:if>
				
				<c:if test = "${not empty deleteErrorMsg}">
					alert("${deleteErrorMsg}");
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
						<td colspan="4" align="right"> <input type="button" value="+SubSubProduct" 
						 id="addButton" class="addButton" />  </td>
					</tr>
					<tr>
						<th>PRODUCT</th>
						<th>SUBPRODUCT</th>
						<th>EDIT</th>
						<th>DELETE</th>
					</tr>
					<c:forEach items="${list}" var="list">
						<tr>
							<c:if test="${not empty list.subProductId}">
								<td>${list.productName}</td>
								<td><span>${list.subProductName}</span><input type="hidden" value=${list.subProductId} name="subProductId"/></td>
								<td><input type="button" value="EDIT" id="editButton" class="editButton"/></td>
								<td><a href='<c:url value="/admin/deleteSubProduct?subProductId=${list.subProductId}" />'>DELETE</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<form id="addForm" class="addForm" action='<c:url value="/admin/addSubProduct"></c:url>' 
					style="display:none" method="post">
					<table>
						<tr>
							<td>PRODUCT:</td>
							<td><select name="productId" id="productId">
									<option value="" selected>select</option>
									<c:forEach items="${viewProduct}" var="list">				
										<option value="${list.productId}">${list.productName}</option>
									</c:forEach>
								</select> </td>
						</tr>
						<tr>
							<td>SUBPRODUCTNAME:</td>
							<td><input type="text" name="subProductName" id="subProductName"/></td>
						</tr>
						<tr>	
							<td> <input type="submit" value="SUBMIT"/></td>
							<td> <input type="reset" value="RESET" /> </td>
						</tr>	
					</table>
				</form>
				<form id="editForm" class="editForm" action='<c:url value="/admin/editSubProduct"></c:url>' 
					style="display:none" method="post">
					<table>
						<tr>
							<td>SUBPRODUCTID:</td>
							<td><input type="text" name="subProductId" id="subProductId" readonly="readonly"/></td>
						</tr>
						<tr>
							<td>PRODUCTNAME:</td>
							<td><input type="text" name="productName" id="productName" readonly="readonly"/></td>
						</tr>
						<tr>
							<td>SUBPRODUCTNAME:</td>
							<td><input type="text" name="subProductName" id="subProductName"/></td>
						</tr>
						<tr>	
							<td> <input type="submit" value="SUBMIT"/> </td>
							<td> <input type="reset" value="RESET" /> </td>
						</tr>	
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
			