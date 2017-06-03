<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发送邮件</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
    <link rel="stylesheet" href="/nutz-test/static/bootstrap/bootstrap.min.css">
    <script src="/nutz-test/static/jquery/jquery.min.js"></script>
    <script src="/nutz-test/static/angular/angular.min.js"></script>
    <script src="/nutz-test/static/bootstrap/bootstrap.min.js"></script>
    <script src="/nutz-test/static/jquery/jquery.ajaxupload.js"></script>
</head>
<body>
<div ng-app="myapp" ng-controller="mycontroller">
	<form id="form" role="form" class="form-horizontal" action="${base}/mail/send">
		<div class="form-group">
			<label class="control-label col-sm-2">邮箱：</label>
			<div class="col-sm-8">
				<input id="mail" name="mail" type="text" class="form-control" placeholder="请输入邮箱">
			</div>
			
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">标题：</label>
			<div class="col-sm-8">
				<input id="title" name="title" type="text" class="form-control" placeholder="请输入标题">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">正文：</label>
			<div class="col-sm-8">
				<input id="message" name="message" type="text" class="form-control" placeholder="请输入正文">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-2">
				<button type="submit" class="btn btn-default">发送</button>
			</div>
		</div>
	</form>
	<hr/>
	<form id="formFirst" name="upload" enctype="multipart/form-data" 
		method="post" class="form-horizontal">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-2">
				<input type="file" name="uploads"/></p>
	        	<input type="button" value="上传" ng-click="uploadall('formFirst')"/>
	        	<input type="hidden" value="第一个文件" name="answerId">
			</div>
		</div>
	</form>
	<hr/>
	<form id="formSecond" name="upload" enctype="multipart/form-data" 
		method="post" class="form-horizontal">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-2">
				<input type="file" name="uploads"/></p>
	        	<input type="button" value="上传" ng-click="uploadall('formSecond')"/>
	        	<input type="hidden" value="第二个文件" name="answerId">
			</div>
		</div>
	</form>
	<hr/>
	
	
	
</div>
</body>
<script type="text/javascript">
var app = angular.module('myapp', []);
app.controller('mycontroller',function($scope){
	$scope.uploadall = function(id){
		//通过id来判断是哪个form表单进行上传操作
		$("#" + id).ajaxUpload({
			url:"${base}/mail/upload",
            dataType:'json',
            success: function (data, status, xhr){
            	$scope.$apply(function () {
          		  	alert(data.result);
                  });
            }
		});
	}
});
</script>
</html>