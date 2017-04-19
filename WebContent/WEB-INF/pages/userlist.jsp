<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<%@ include file="../../header.html"%>
	<!-- 页面主体内容 -->
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
					所有用户
				</li>
			</ul>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>用户名</th>
						<th>邮箱</th>
						<th>班级</th>
						<th>余额</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${userList}" >
				       <tr>
				          <td><c:out value="${user.id}"/></td>
				          <td><c:out value="${user.userName}"/></td>
				          <td><c:out value="${user.email}"/></td>
				          <td><c:out value="${user.className}"/></td>
				          <td><c:out value="${user.balance}"/></td>
				          <td>
				          	<a href="${pageContext.request.contextPath}/booklist.do?userId=${user.id}&userName=${user.userName}">看ta的书</a>
				          	/
				          	<a href="${pageContext.request.contextPath}/userdel.do?userId=${user.id}">删除ta</a>
				          </td>
				       </tr>
				   </c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	<%@ include file="../../footer.html"%>
</html>