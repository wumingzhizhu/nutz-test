<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
    <link rel="stylesheet" href="/nutz-test/static/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/nutz-test/static/angular/ng-pagination.css">
    <script src="/nutz-test/static/jquery/jquery.min.js"></script>
    <script src="/nutz-test/static/angular/angular.min.js"></script>
    <script src="/nutz-test/static/angular/ng-pagination.js"></script>
    <script src="/nutz-test/static/bootstrap/bootstrap.min.js"></script>
</head>
<body>
<div ng-app="myapp" ng-controller="mycontroller">
	<form id="form" role="form" class="form-horizontal" action="" ng-submit="save()">
		<div class="form-group">
			<label class="control-label col-sm-2">用户名：</label>
			<div class="col-sm-8">
				<input id="username" name="username" type="text" class="form-control" placeholder="请输入用户名">
			</div>
			
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">密码：</label>
			<div class="col-sm-8">
				<input id="pwd" name="pwd" type="text" class="form-control" placeholder="请输入密码">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">验证码：</label>
			<div class="col-sm-4">
				<input id="captch" name="captch" type="text" class="form-control" placeholder="请输入验证码">
			</div>
			<div class="col-sm-4">
				<img src="${base}/captch/getCaptch" id="captcha_img" ng-click="changeCaptcha()">
			</div>	
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-2">
				<button type="submit" class="btn btn-default">登录</button>
			</div>
		</div>
	</form>
</div>
</body>
<script type="text/javascript">
var app = angular.module('myapp', []);
app.controller('mycontroller',function($scope){
	$scope.changeCaptcha = function(){
		$('#captcha_img').attr("src","${base}/captch/getCaptch?_=" + new Date().getTime());
		return false;
	}
	$scope.save = function(){
		var username = $('#username').val();
		var pwd = $('#pwd').val();
		var captch = $('#captch').val();
		$.ajax({
	              type:"post",
	              url:'${base}/checkLogin',
	              data:{
	                  "username":username,
	                  "pwd":pwd,
	                  "captch":captch
	              },
	              /* data:$('#form').serialize(), */
	              dataType:"json",
	              success:function(data){
	            	  $scope.$apply(function () {
	            		  alert(data.result);
	            		  
	                    });
	                  
	              }
	          })
	}

});

</script>
</html>