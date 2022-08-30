<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Book</title>
</head>

<body>
	<div class="main-content">
	<form action="" method="get" id="formSubmit">
			<div class="main-content-inner">
				<div class="container">
					<div class="page-content">
						<h1>Thư viện:</h1>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Tiêu đề</th>
									<th>Mô tả ngắn</th>
									<th>Tác giả</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${model.listResult}">
									<tr>
										<td>${item.title}</td>
										<td>${item.shortDescription}</td>
										<td>${item.author}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<!-- Pagination -->
						<nav aria-label="Page navigation">
							<ul class="pagination" id="pagination"></ul>
						</nav>	

						<!-- Request Input value -->
						<input type="hidden" value="" name="page" id="page">
						<input type="hidden" value="" name="maxPageItem" id="maxPageItem">
						<input type="hidden" value="" name="sortName" id="sortName">
						<input type="hidden" value="" name="sortBy" id="sortBy">
						<input type="hidden" value="" name="type" id="type">

					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var totalPage = ${model.totalPage};
		var currPage = ${model.page};
		var maxPageItem = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPage,
				startPage: currPage,
				visiblePages : 10,
				onPageClick : function(event, page) {
					if (currPage != page) {
						$("#page").val(page);
						$("#maxPageItem").val(maxPageItem);
						$("#sortName").val("title");
						$("#sortBy").val("desc");
						$("#type").val("list");
						$("#formSubmit").submit();
					}
				}
			})
		});
	</script>
</body>
</html>