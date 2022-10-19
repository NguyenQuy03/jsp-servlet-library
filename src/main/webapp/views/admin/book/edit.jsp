<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIAdminURL" value="/api-admin-book" />
<c:url var="AdminBookURL" value="/admin-book" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
</head>

<style>
</style>

<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li class="active">Chỉnh sửa bài viết</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<form id="formSubmit">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thể
									loại</label>
								<div class="col-sm-9">
									<c:if test="${empty model.categoryCode}">
										<select class="form-control" id="categoryCode"
											name="categoryCode">
											<option>Chọn thể loại sách</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}">
													${item.name}
												</option>
											</c:forEach>
										</select>
									</c:if>
									
									<c:if test="${not empty model.categoryCode}">
										<select class="form-control" id="categoryCode"
											name="categoryCode">
											<option>Chọn thể loại sách</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}"
													<c:if test="${item.code == model.categoryCode}">
														selected = "selected"
													</c:if>
												>${item.name}</option>
											</c:forEach>
										</select>
									</c:if>
								</div>
							</div>
							<br /> <br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title"
										value="${model.title}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tác giả</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="author" name="author"
										value="${model.author}"/>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="thumbnail"
										name="thumbnail" value="${model.thumbnail}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô
									tả ngắn</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="shortDescription"
										name="shortDescription" value="${model.shortDescription}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Link tải sách</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="linkDownload"
										name="linkDownload" value="${model.linkDownload}"  />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<div class="col-sm-12">
									<div class="col-sm-12">
	                                     <c:if test="${not empty model.id}">
	                                          <input type="submit" class="btn btn-white btn-warning btn-bold" value="Cập nhật sách" id="btnAddOrUpdateBook"/>
	                                     </c:if>
	                                     <c:if test="${empty model.id}">
	                                          <input type="submit" class="btn btn-white btn-warning btn-bold" value="Thêm sách" id="btnAddOrUpdateBook"/>
	                                     </c:if>
	                                </div>
								</div>
							</div>
							<input type="hidden" value="${model.id}" id="id" name="id" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		$("#btnAddOrUpdateBook").click(function(e) {
			e.preventDefault();
	        var data = {};
	        var formData = $('#formSubmit').serializeArray();
	        var id = $('#id').val();
	        
	        $.each(formData, function (i, v) {
	            data[""+v.name+""] = v.value;
	        });
	        
	        function checkData() {
	        	var result = true;
	        	for (var i = 0; i < formData.length - 1; i++) {
	        		if(!formData[i].value) {
		        		result = false;
	        		}
	        	}
		        return result;
	        }
			
	        
	        if (checkData()) {
		        if (!id) {
		            addBook(data);
		        } else {
		        	updateBook(data);
		        }
	        } else {
	        	alert("Vui lòng điền đầy đủ các trường");
	        }
		});

		function addBook(data) {
			$.ajax({
				url: "${APIAdminURL}",
				type: "POST",
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: "json",
				success: function () {
	            	window.location.href = 
            		"${AdminBookURL}?type=list&page=1&maxPageItem=2&alertType=success&alertMessage=insert_success";
				},
				error: function (e) {
	            	window.location.href = 
					"${AdminBookURL}?type=list&page=1&maxPageItem=2&alertType=danger&alertMessage=insert_error";
				}
			});
		}

		function updateBook(data) {
	        $.ajax({
	            url: '${APIAdminURL}',
	            type: 'PUT',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = 
	            		"${AdminBookURL}?type=list&page=1&maxPageItem=2&alertType=success&alertMessage=update_success";
	            },
	            error: function (e) {
	            	window.location.href = 
						"${AdminBookURL}?type=list&page=1&maxPageItem=2&alertType=danger&alertMessage=update_error";
	            }
	        });
	    }
	</script>
</body>
</html>