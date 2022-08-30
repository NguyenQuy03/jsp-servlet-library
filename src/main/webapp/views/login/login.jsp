<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container p-0">
		<div class="row no-gutters height-self-center">
			<div class="col-sm-12 align-self-center page-content rounded">
				<div class="row m-0">
					<div class="col-sm-12 sign-in-page-data">
						<div class="sign-in-from bg-primary rounded">
						
							<!-- Form Submit -->
							<form id="submitForm" action="<c:url value="/login" />" method="post" class="mt-4 form-text">
								<div class="form-group">
									<label for="exampleInputEmail1">User Name</label> 
									<input type="text" class="form-control mb-0" id="exampleInputEmail1"
										placeholder="Enter user name"
										required
									>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label>
									<input type="password" class="form-control mb-0"
										id="exampleInputPassword1" placeholder="Password"
										required
									>
								</div>
								
								<input type="hidden" name="action" value="login"/>
								
								<div class="sign-info text-center">
									<button id="submitBtn" type="submit" class="btn btn-white d-block w-100 mb-2">
										Sign in
									</button>
								</div>
							</form>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>