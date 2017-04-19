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
					Data
				</li>
			</ul>
			<div class="row clearfix">
				<div class="col-md-8 column">
					<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/register.do" method="post">
						<div class="form-group">
							 <label for="inputUserName" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputUserName" name="userName" value="${formbean.userName}"/>${formbean.errors.userName}
							</div>
						</div>
						<div class="form-group">
							 <label for="inputUserPwd1" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputUserPwd1" name="userPwd" value="${formbean.userPwd}"/>${formbean.errors.userPwd}
							</div>
						</div>
						<div class="form-group">
							 <label for="inputUserPwd2" class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputUserPwd2" name="confirmPwd" value="${formbean.confirmPwd}"/>${formbean.errors.confirmPwd}
							</div>
						</div>
						<div class="form-group">
							 <label for="inputEmail" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputEmail" name="email" value="${formbean.email}"/>${formbean.errors.email}
							</div>
						</div>
						<div class="form-group">
							 <label for="inputClassName" class="col-sm-2 control-label">班级</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputClassName" name="className" value="${formbean.className}"/>${formbean.errors.className}
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								 <button type="submit" class="btn btn-default">注册</button>
							</div>
						</div>
					</form>

				</div>
				<div class="col-md-4 column">
					<div class="carousel slide" id="carousel-224685">
						<ol class="carousel-indicators">
							<li class="active" data-slide-to="0" data-target="#carousel-224685">
							</li>
							<li data-slide-to="1" data-target="#carousel-224685">
							</li>
							<li data-slide-to="2" data-target="#carousel-224685">
							</li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img alt="" src="v3/default.jpg" />
								<div class="carousel-caption">
									<h4>
										First Thumbnail label
									</h4>
									<p>
										Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="v3/default1.jpg" />
								<div class="carousel-caption">
									<h4>
										Second Thumbnail label
									</h4>
									<p>
										Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="v3/default2.jpg" />
								<div class="carousel-caption">
									<h4>
										Third Thumbnail label
									</h4>
									<p>
										Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
									</p>
								</div>
							</div>
						</div> <a class="left carousel-control" href="#carousel-224685" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-224685" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
					</div> <button type="button" class="btn btn-default btn-info btn-block">按钮</button> <button type="button" class="btn btn-default btn-warning disabled active">按钮</button>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../footer.html"%>
</html>