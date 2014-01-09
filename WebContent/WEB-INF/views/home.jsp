<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sec:authorize ifAnyGranted="ROLE_USER">
	<jsp:forward page="/user/home"></jsp:forward>
</sec:authorize>

<sec:authorize ifAnyGranted="ROLE_MERCHANT">
	<jsp:forward page="/merchant/home"></jsp:forward>
</sec:authorize>

<sec:authorize ifAnyGranted="ROLE_ADMIN">
	<jsp:forward page="/admin/home"></jsp:forward>
</sec:authorize>