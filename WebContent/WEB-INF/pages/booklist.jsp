<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<%@ include file="../../header.html"%>
	<!-- 页面主体内容 -->
	<div class="modal" id="add-book-modal">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
					<h4 class="modal-title">添加书本</h4>
				</div>
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/bookadd.do" method="post">
					<div class="modal-body">
						<div class="form-group">
							 <label for="inputBookName" class="col-sm-2 control-label">书名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputBookName" name="bookName" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputCategory" class="col-sm-2 control-label">类目</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputCategory" name="category" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputKeyword" class="col-sm-2 control-label">关键字</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputKeyword" name="keyword" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputDescription" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputDescription" name="description" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputPrice" class="col-sm-2 control-label">价格</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputPrice" name="price" />
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</form>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<div class="row clearfix" style="margin-top: 60px;">
		<div class="col-md-12 column">
			<ul class="breadcrumb">
				<li>
					 <a href="#">Home</a>
				</li>
				<li>
					 <a href="#">Library</a>
				</li>
				<li class="active">
					${userName}的书
				</li>
			</ul>
			<button type="button" class="btn btn-default btn-warning active" id="show-add-book-modal">添加书本</button>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>书名</th>
						<th>类目</th>
						<th>关键字</th>
						<th>描述</th>
						<th>创建时间</th>
						<th>价格</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${bookList}" >
				       <tr>
				          <td><c:out value="${book.id}"/></td>
				          <td><c:out value="${book.bookName}"/></td>
				          <td><c:out value="${book.category}"/></td>
				          <td><c:out value="${book.keyword}"/></td>
				          <td><c:out value="${book.description}"/></td>
				          <td><c:out value="${book.createTime}"/></td>
				          <td><c:out value="${book.price}"/></td>
				          <td>
				          	<a href="#">修改</a>
				          	/
				          	<a href="${pageContext.request.contextPath}/bookdel.do?bookId=${book.id}">删除</a>
				          </td>
				       </tr>
				   </c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	<%@ include file="../../footer.html"%>
</html>