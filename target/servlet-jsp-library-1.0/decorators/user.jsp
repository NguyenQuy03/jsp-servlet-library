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
	<link href="<c:url value='/template/user/home/home.css' />"rel="stylesheet" type="text/css" media="all" />
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>

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

	<script type="text/javascript"
		src="<c:url value='/template/user/jquery/jquery.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/template/user/bootstrap/js/bootstrap.bundle.min.js' />"></script>

</body>
</html>