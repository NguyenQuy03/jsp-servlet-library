<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Book</title>
</head>
<style>
    body {
        font-family: 'Open Sans', sans-serif !important;
    }
</style>

<body>
	<div class="main-content">
		<form action="" method="get" id="formSubmit">
			<div class="main-content-inner">
				<div class="container">
					<div class="page-content">
						<div class="table-filter">
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<a class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title='Thêm sách'
											href='<c:url value="/admin-book?type=edit"/>'> <span>
												<i class="fa fa-plus-circle bigger-110 purple"></i>
										</span>
										</a>
										<button id="btnDelete" type="button"
											class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title='Xóa sách'>
											<span> <i class="fa fa-trash-o bigger-110 pink"></i>
											</span>
										</button>
									</div>
								</div>
							</div>
						</div>
						<h1>Thư viện:</h1>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Tiêu đề</th>
									<th>Mô tả ngắn</th>
									<th>Tác giả</th>
									<th>Thao tác</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${model.listResult}">
									<tr>
										<td>${item.title}</td>
										<td>${item.shortDescription}</td>
										<td>${item.author}</td>
										<td><c:url var="editURL" value="/admin-book">
												<c:param name="type" value="edit" />
												<c:param name="id" value="${item.id}" />
											</c:url> <a class="btn btn-sm btn-primary btn-edit"
											data-toggle="tooltip" title="Cập nhật sách" href='${editURL}'>
												<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<!-- Pagination -->
						<nav aria-label="Page navigation">
							<ul class="pagination" id="pagination"></ul>
						</nav>

						<!-- Request Input value -->
						<input type="hidden" value="" name="page" id="page"> <input
							type="hidden" value="" name="maxPageItem" id="maxPageItem">
						<input type="hidden" value="" name="sortName" id="sortName">
						<input type="hidden" value="" name="sortBy" id="sortBy"> <input
							type="hidden" value="" name="type" id="type">

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
				startPage : currPage,
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