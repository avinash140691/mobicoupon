<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Department Form</title>
<script src='<c:url value="/web/js/jquery.min.js"></c:url>'></script>
<script>
	$(document).ready(function() {
		$("#addDept").click(function() {
			$('#deptAddForm').css('display', 'block');
			$('#editDept').css('display', 'none');
		});

		$("#editDeptButton").click(function() {
			$('#deptAddForm').css('display', 'none');
			$('#editDept').css('display', 'block');

			var id = $('select').val();
			var name = $.trim($('select option:selected').html());
			alert(id +" : "+ name );
			$("#editDept #deptId").val(id);
			$("#editDept #deptName").val(name);
		});
		
		$("#removeDept").click(function(){
			var id = $('select').val();
			var name =$.trim( $('select option:selected').html());
			var removeDeptConfirm = confirm("Do you want to remove '" +name + "'?");
			if(removeDeptConfirm)
				window.top.location = '<c:url value="/admin/removeDept" />?id='+id;
		});
		
		<c:if test="${not empty errors}">
			$('#deptAddForm').css('display', 'block');
			$('#editDept').css('display', 'none');
			<c:forEach items="${errors}" var="fieldError">
				var id1 = '#${fieldError.field}';
				var msg1 = '${fieldError.defaultMessage}';
				$(id1).after("<span style='color:red'>" + msg1 + "</span>");
			</c:forEach>
		</c:if>
		
		<c:if test="${not empty editErrors}">
			$('#deptAddForm').css('display', 'none');
			$('#editDept').css('display', 'block');
			<c:forEach items="${editErrors}" var="fieldError">
				var id2 = '#editDept #${fieldError.field}';
				var msg2 = '${fieldError.defaultMessage}';
				$(id2).after("<span style='color:red'>" + msg2 + "</span>");
			</c:forEach>
		</c:if>
	});
</script>
<link href='<c:url value="/web/css/style.css"></c:url>' rel="stylesheet"
	type="text/css" />
</head>
<div class="container">
	<div class="header">
		<jsp:include page="adminheader.jsp"></jsp:include>
		<div class="d_form">
			<div class="indep">
				<b> Department</b>
			</div>
			<br /> <br />
			<div id="departmentshow">
				<table align="center">
					<tr>
						<td>Departments: <select>
								<c:forEach items="${depts}" var="depts">
									<option value="${depts.deptId}">${depts.deptName}</option>
								</c:forEach>
						</select> <br /> <br /> <input type="button" value="AddDept" id="addDept" />
							&nbsp; &nbsp; <input type="button" value="EditDept" id="editDeptButton" />
							&nbsp; &nbsp; <input type="button" value="RemoveDept"
							id="removeDept" /><span style="color:red">${error}</span><br /> <br />

							<form autocomplete="off"
								action='<c:url value="/admin/addDept"></c:url>'
								style="display: none" id="deptAddForm" method="post" name="deptForm">
								Dept Name: <input type="text" name="deptName" id="deptName" /> <br /> <br />
								<input type="submit" value="Add" /> &nbsp; &nbsp; <input
									type="reset" value="clear" />
							</form>
							<form autocomplete="off"
								action='<c:url value="/admin/editDept"></c:url>'
								style="display: none" id="editDept" method="post" name="editDept">
								Dept Id: <input type="text" name="deptId" id="deptId" readonly />
								<br /> <br /> Dept Name: <input type="text" name="deptName"
									id="deptName" /> <br /> <br /> <input type="submit"
									value="Update" /> &nbsp; &nbsp; <input type="reset"
									value="clear" />
							</form>
						</td>
					</tr>
				</table>
			</div>

		</div>
	</div>
</div>
</body>
</html>