<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Home Page</title>

	<link
		href="<c:url value='/template/user/bootstrap/css/bootstrap.min.css' />"
		rel="stylesheet" type="text/css" media="all" />
    
	<link href="<c:url value='/template/user/css/style.css' />"rel="stylesheet" type="text/css" media="all" />
    
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
	<script src="../jquery.twbsPagination.js" type="text/javascript"></script>
	
	<link href="<c:url value='/template/user/home/home.css' />"rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<!-- header -->
	<%@ include file="/common/user/header.jsp"%>
	<!-- header -->

	<div class="container">
		<dec:body />
	</div>

	<!-- footer -->
	<%@ include file="/common/user/footer.jsp"%>
	<!-- footer -->
</body>
</html>