<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<%@ include file="header.html"%>
	<!-- 页面主体内容 -->
	<div class="row clearfix" style="margin-top: 60px;">
		<div class="col-md-2 column">
			<img alt="140x140" src="resources/img/xiniu.jpg" />
		</div>
		<div class="col-md-6 column">
			<div class="jumbotron">
				<h2>
					Hello, <c:if test="${user!=null}">${user.userName}</c:if>
				</h2>
				<p>
					这是一个正在建设中的学生二手市场，敬请期待。。。。。。
				</p>
				<p>
					 <a class="btn btn-primary btn-large" href="#">Learn more</a>
				</p>
			</div>
		</div>
		<div class="col-md-4 column">
			<ul>
				<li>
					Lorem ipsum dolor sit amet
				</li>
				<li>
					Consectetur adipiscing elit
				</li>
				<li>
					Integer molestie lorem at massa
				</li>
				<li>
					Facilisis in pretium nisl aliquet
				</li>
				<li>
					Nulla volutpat aliquam velit
				</li>
				<li>
					Faucibus porta lacus fringilla vel
				</li>
				<li>
					Aenean sit amet erat nunc
				</li>
				<li>
					Eget porttitor lorem
				</li>
			</ul>
		</div>
	</div>
	<%@ include file="footer.html"%>
</html>