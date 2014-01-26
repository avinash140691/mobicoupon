<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Designation Form</title>
<link href='<c:url value="/web/css/style.css"/>' rel="stylesheet"
	type="text/css" />
<script src='<c:url value="/web/js/jquery.min.js"></c:url>'></script>
<script>
	$(document)
			.ready(
					function() {
						$("#addDesgButton").click(function() {
							$('#desgAddForm').css('display', 'block');
							$('#desgEditForm').css('display', 'none');
						});

						$("#editDesgButton").click(function() {
							$('#desgAddForm').css('display', 'none');
							$('#desgEditForm').css('display', 'block');

							var id = $('select').val();
							var name = $.trim($('select option:selected').html());

							$("#desgEditForm #desgId").val(id);
							$("#desgEditForm #desgName").val(name);
						});
						
						$("#removeDesgButton").click(function() {
							var id = $('select').val();
							var name = $.trim($('select option:selected').html());
							var confirmVariable = confirm("remove desg: " + name);
							if (confirmVariable)
								window.top.location = '<c:url value="/admin/removeDesg" />?id='+ id;
						});
						
						
						<c:if test="${not empty addErrors}">
							$('#desgAddForm').css('display', 'block');
							$('#desgEditForm').css('display', 'none');
							<c:forEach items="${addErrors}" var="fieldError">
								var id1 = '#${fieldError.field}';
								var msg1 = '${fieldError.defaultMessage}';
								$(id1).after("<span style='color:red'>" + msg1 + "</span>");
							</c:forEach>
						</c:if>
						
						<c:if test="${not empty editErrors}">
							$('#desgAddForm').css('display', 'none');
							$('#desgEditForm').css('display', 'block');
							<c:forEach items="${editErrors}" var="fieldErrors">
								var id2 = '#desgEditForm #${fieldErrors.field}';
								var msg2 = '${fieldErrors.defaultMessage}';
								alert(id2+ " : " + msg2);
								$(id2).after("<span style= 'color:red'>" +msg2+ "</span>" );
							</c:forEach>
						</c:if>
					});

	
</script>
</head>
<div class="container">
	<div class="header">
		<jsp:include page="adminheader.jsp"></jsp:include>
		<div class="d_form">
			<div class="indep">
				<b>Designation</b>
			</div>
			<br /> <br />
			<table align="center">
				<tr>
					<td>Designations: <select>
							<c:forEach items="${desg}" var="desg">
								<option value="${desg.desgId}">${desg.desgName}</option>
							</c:forEach>
					</select> <br /> <br /> <input type="button" value="AddDesg"
						id="addDesgButton" /> &nbsp; &nbsp; <input type="button"
						value="EditDesg" id="editDesgButton" /> &nbsp; &nbsp; <input
						type="button" value="RemoveDesg" id="removeDesgButton" /><span style="color:red">${error}</span><br />
						<br />

						<form autocomplete="off"
							action='<c:url value="/admin/addDesg"></c:url>'
							style="display: none" id="desgAddForm" name="desgAddForm"
							method="post">
							Desg Name: <input type="text" name="desgName" id="desgName" /> <br />
							<br /> <input type="submit" value="Add" /> &nbsp; &nbsp; <input
								type="reset" value="clear" />
						</form>
						<form autocomplete="off"
							action='<c:url value="/admin/editDesg"></c:url>'
							style="display: none" id="desgEditForm" name="desgEditForm"
							method="post">
							Desg Id: <input type="text" name="desgId" id="desgId" readonly />
							<br /> <br /> Desg Name: <input type="text" name="desgName"
								id="desgName" /> <br /> <br /> <input type="submit"
								value="Update" /> &nbsp; &nbsp; <input type="reset"
								value="clear" />
						</form>
					</td>
				</tr>
			</table>

		</div>
	</div>
</div>
</body>
</html>