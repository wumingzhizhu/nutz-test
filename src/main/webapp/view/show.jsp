<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.sql.*,java.io.*" %>
<%@ page import="javax.sql.DataSource" %>
<head>
	<meta charset="UTF-8">
	<title>家庭信息</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
    <!-- <link rel="stylesheet" href="/portal/static/exam.css"> -->
    <link rel="stylesheet" href="/nutz-test/static/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/nutz-test/static/angular/ng-pagination.css">
    <!-- <script src="/portal/static/exam.js"></script> -->
    <script src="/nutz-test/static/jquery/jquery.min.js"></script>
    <!-- <script src="/portal/static/vue/vue.min.js"></script> -->
    <script src="/nutz-test/static/angular/angular.min.js"></script>
    <script src="/nutz-test/static/angular/ng-pagination.js"></script>
    <script src="/nutz-test/static/bootstrap/bootstrap.min.js"></script>

</head>
<style type="text/css">
body{ text-align:center} 
#j-table{
    font-family: tahoma,arial,sans-serif,"Simsun;
    /* font-size:2px; */
    color:"#000";
    text-align:center
}
#myModal{
    font-family:tahoma,arial,sans-serif,"Simsun";
    font-size:1px;
    text-align:center
}
table th{
    white-space: nowrap;
   text-align:center
}
table td{
    white-space: nowrap;
   text-align:center
}
table{
    empty-cells:show; 
    border-collapse: collapse;
    text-align:center
}
.searchinput{
	border-right-width: 0px;
	padding-left: 3px;
	width: 168px;
	font-family: arial;
	float: left;
	border-top-width: 0px;
	border-bottom-width: 0px;
	color: #636365;
	margin-left: 4px;
	font-size: 8pt;
	vertical-align: middle;
	border-left-width: 0px;
	margin-right: 3px;
}
.tab_search{
	border-bottom: #cccccc 1px solid;
	border-left: #cccccc 1px solid;
	height: 25px;
	border-top: #cccccc 1px solid;
	border-right: #cccccc 1px solid;

}
.searchaction{
	width: 21px;
	float: left;
	height: 17px;
}
</style>
<body>
<div id="app" ng-app="myApp" ng-controller="myCtrl" align="center">
    <div style=" overflow: auto; width: 80%; margin-top:5px" >
        <div>
            <h4><strong>家庭信息</strong></h4>
            <!-- <div class="tab_search" align="right"  >
              <table border="1" style="border-style:none">
                  <tr>
                      <td>
                      <input  name="name" id="name" class="searchinput" type="text" placeholder="请输入要查询的内容" 
                          autocomplete="off" value="" data-mounted="1" >
                      <input type="image"  ng-click="onPageChange()" alt="Search" src="http://www.poluoluo.com/jzxy/UploadFiles_333/201108/20110806151936823.gif" >
                     </td>
                  </tr>
               </table>
            </div> -->
        </div>
        <table class="table table-hover table-striped table-bordered" id="j-table">
            <thead>
                <tr>
                    <th>姓名</th>
                    <th>家庭住址</th>
                    <th>手机号</th>
                    <th>Email</th>
                </tr>        
            </thead>
            <tbody>
                <tr ng-repeat="item in list">
                    <th title="{{item.name}}">{{item.name}}</th>
                    <th title="{{item.home}}">{{item.home}}</th>
                    <th title="{{item.mobile}}">{{item.mobile}}</th>
                    <th title="{{item.email}}">{{item.email}}</th>
                  
                </tr>
            </tbody>
        </table>
    </div>
    <div class="pager">
            共{{allSize}}条记录
      <pager page-count="pageCount" current-page="currentPage" on-page-change="onPageChange()" first-text="首页" next-text="下一页" prev-text="上一页" last-text="尾页" show-goto="true" goto-text="跳转到"></pager>
    </div>
</div>
</body>
<script type="text/javascript">
var app = angular.module('myApp', ['ng-pagination']);
app.controller('myCtrl', ['$scope', function ($scope) {
    $scope.onPageChange = function() {
          // ajax request to load data
          console.log($scope.currentPage);
          var name = $('#name').val();
          $.ajax({
              type:"post",
              url:'/nutz-test/view/showAjax.jsp',
              data:{
                  "pageSize":3,
                  "pageIndex":$scope.currentPage,
                  "name":name
              },
              dataType:"json",
              success:function(data){
                  $scope.$apply(function () {
                      $scope.list = data.list;
                      $scope.pageCount = data.pageCount;
                      $scope.allSize = data.allSize;
                    });
                  
              }
          })
        };
        //$scope.pageCount = 10;
        //初始化
        $scope.myinit = function(){
            $.ajax({
                  type:"post",
                  url:'/nutz-test/view/showAjax.jsp',
                  data:{
                      "pageSize":3,
                      "pageIndex":1
                  },
                  dataType:"json",
                  success:function(data){
                      $scope.$apply(function () {
                          $scope.list = data.list;
                          $scope.pageCount = data.pageCount;
                          $scope.allSize = data.allSize;
                        });
                      
                  }
              })
        };
        $scope.myinit();
}]);

</script>
</html>