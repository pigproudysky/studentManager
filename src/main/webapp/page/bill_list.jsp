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
					elem : '#bill-table',
					url : '../bill/list',
                    totalRow: true,
					page : true,
					cols: [[ 
				    		{field: 'id', title: 'ID', align : 'center'}
					      ,{field: 'fileName', title: '课件名称', align : 'center'}
					      ,{field: 'price', title: '金额', align : 'center',totalRow: true}
					      ,{field: 'cdate', title: '购买时间', align : 'center'}
					  ]]
				});
		});
	</script>
	<table id="bill-table" lay-filter="bill-list"></table>

</body>
</html>