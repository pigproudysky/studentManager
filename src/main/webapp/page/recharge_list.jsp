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
		layui.use(['table', 'jquery','form'],function(){
			var table = layui.table;
			var $ = layui.jquery;
			var form = layui.form;



			 table.render({
					elem : '#bill-table',
					url : '../recharge/list',
                    totalRow: true,
					page : true,
					cols: [[ 
				    		{field: 'id', title: 'ID', align : 'center'}
					      ,{field: 'price', title: '金额', align : 'center',totalRow: true}
					      ,{field: 'cdate', title: '充值时间', align : 'center'}
					  ]]
				});

			$('#add').click(function(){
				var index = layer.open({
					type: 1,
					title:'账户充值',
					skin: 'layui-layer-rim',
					area: ['350px', '160px'],
					content: $('#add-view').html()
				});
				$('#addForm').click(function(){
					var price = $('input[name=price]').val();
					if(0 >= price){
						layer.msg('非法输入', {
							offset: 't',
							anim: 6
						});
					}else{
						$.post('../recharge/add',{'price':price},function(flag){
							if(flag){
								layer.msg('充值成功!', {icon: 6});
								table.reload('bill-table', {});
							} else {
								layer.msg('充值失败!', {icon: 5});
							}
							layer.close(index);
						});
					}
				})
			});


		});
	</script>
	<script type="text/html" id="add-view">
			<form class="layui-form" action="">
				<div class="layui-form-item">
					<label class="layui-form-label">金额</label>
					<div class="layui-input-inline">
						<input type="text" name="price" required lay-verify="required"  autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="add-form-btn" id="addForm">充值</button>
					</div>
				</div>
			</form>
	</script>

	<div class="search-div">
		<button class="layui-btn  layui-btn-normal" id="add"><i class="layui-icon">&#xe61f;</i></button>
	</div>

	<table id="bill-table" lay-filter="bill-list"></table>

</body>
</html>