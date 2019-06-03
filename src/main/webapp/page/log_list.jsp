<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="../load/layui/css/layui.css">
<script type="text/javascript" src="../load/layui/layui.js"></script>
</head>
<body>
	<script type="text/javascript">
		layui.use(['table', 'jquery'],function(){
			var table = layui.table;
			 var $ = layui.jquery;
			 table.render({
					elem : '#log-table',
					url : '../log/list',
					page : true,
					cols: [[ 
				    		{field: 'lid', title: 'ID', align : 'center'}
					      ,{field: 'ip', title: 'IP', align : 'center'}
					      ,{field: 'logintime', title: '登录时间', align : 'center'}
					      ,{field: 'logouttime', title: '登出时间', align : 'center'}
					  ]]
				});
		
		});
	</script>
	<table id="log-table" lay-filter="log-list"></table>
</body>
</html>