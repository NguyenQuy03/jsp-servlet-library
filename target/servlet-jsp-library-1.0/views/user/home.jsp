<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<div class="row">

		<div class="col-lg-3">

			<h1 class="my-4">Danh mục</h1>
			<div class="list-group">
				<c:forEach var="item" items="${categories}">
					<a href="#" class="list-group-item">${item.name}</a>
				</c:forEach>
			</div>

		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">

			<div class="row">
					<c:forEach var="item" items="${books}">
						<div class="book-content col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top book-img"
									src="${item.thumbnail}" alt=""></a>
								<div class="card-body">
									<h6 class="card-title book-title">${item.title}</h6>
									<h6 class="book-author">${item.author}</h6>
								</div>
								<div class="card-footer">
									<p class="card-text book-shortDesc">${item.shortDescription}</p>
								</div>
							</div>
						</div>
					</c:forEach>

			</div>
			<!-- /.row -->

		</div>
		<!-- /.col-lg-9 -->
		
	</div>
	<div class="row">
		<form method="get" id="formSubmit">	
			<!-- Pagination -->
			<nav aria-label="Page navigation">
				<ul class="pagination" id="pagination"></ul>
			</nav>
			
			<!-- Request Input value -->
			<input type="hidden" value="" name="page" id="page">
			<input type="hidden" value="" name="maxPageItem" id="maxPageItem">
		</form>
	</div>
	
	<script type="text/javascript">
		var totalPage = ${model.totalPage};
		var currPage = ${model.page};
		var maxPageItem = 3;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPage,
				startPage : currPage,
				visiblePages : 10,
				onPageClick : function(event, page) {
					if (currPage != page) {
						$("#page").val(page);
						$("#maxPageItem").val(maxPageItem);
						$("#formSubmit").submit();
					}
				}
			})
		});
	</script>
</body>
</html>