<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<!-- Form Submit -->
	<div class="container">
        <form id="submitForm" action="<c:url value='/login'/>" method="POST">
			<label for="userName">User name</label> 
			<input id="userName" type="text" name="userName" placeholder="UserName" required>
			<label for="password">Password</label> 
            <input id="password" type="password" name="password" placeholder="Password" autocomplete="current-password" required>
            <input type="submit" class="login loginmodal-submit" name="action" value="login">
		</form>
	</div>
</body>
</html>