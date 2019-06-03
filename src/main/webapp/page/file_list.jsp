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
					elem : '#file-table',
					url : '../file/list',
					page : true,
					cols: [[ 
						{field: 'id', title: 'ID',align : 'center'}
						,{field: 'prefix', title: '课件名称', align : 'center'}
						,{field: 'name', title: '类别', align : 'center'}
						,{field: 'desc', title: '介绍', align : 'center'}
						,{field: 'price', title: '价格', align : 'center'}
						,{field: 'sale_number', title: '销售数量', align : 'center'}
						,{field: 'cdate', title: '上传时间', align : 'center'}
						,{field: 'right', title: '操作', align : 'center',templet: function(temp){
							if(1 == temp.billFlag){
								return '<a title="下载当前课件" href="../file/download?id='+temp.id+'" class="layui-btn layui-btn-xs">下载</a>';
							}else{
								return ' <a title="前往门户页面购买" href="./details.html?fid='+temp.id+'" class="layui-btn layui-btn-primary layui-btn-xs">购买</a>';
							}
						}}

					  ]]
				});
		
		});
	</script>
	<table id="file-table" lay-filter="file-list"></table>
</body>
</html>