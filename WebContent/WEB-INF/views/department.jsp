<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Department Form</title>
<script src='<c:url value="/web/js/jquery.min.js"></c:url>'></script>
<script src='<c:url value="/web/js/script.js"></c:url>'></script>
<script>
	$(document).ready(function() {
		$("#addDept").click(function() {
			$('#deptAddForm').css('display', 'block');
			$('#deptEditForm').css('display', 'none');
		});

		$("#editDept").click(function() {
			$('#deptAddForm').css('display', 'none');
			$('#deptEditForm').css('display', 'block');

			var id = $('select').val();
			var name = $.trim($('select option:selected').html());

			$("#did").val(id);
			$("#dname").val(name);
		});
		
		$("#removeDept").click(function(){
			var id = $('select').val();
			var name =$.trim( $('select option:selected').html());
			alert('delete this dept'  +  name);
			window.top.location = '<c:url value="/admin/removeDept" />?id='+id;
		});

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
							&nbsp; &nbsp; <input type="button" value="EditDept" id="editDept" />
							&nbsp; &nbsp; <input type="button" value="RemoveDept"
							id="removeDept" /><br /> <br />

							<form autocomplete="off"
								action='<c:url value="/admin/addDept"></c:url>'
								style="display: none" id="deptAddForm" method="post">
								Dept Name: <input type="text" name="deptName" /> <br /> <br />
								<input type="submit" value="Add" /> &nbsp; &nbsp; <input
									type="reset" value="clear" />
							</form>
							<form autocomplete="off"
								action='<c:url value="/admin/editDept"></c:url>'
								style="display: none" id="deptEditForm" method="post">
								Dept Id: <input type="text" name="deptId" id="did" readonly />
								<br /> <br /> Dept Name: <input type="text" name="deptName"
									id="dname" /> <br /> <br /> <input type="submit"
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