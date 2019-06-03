<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="../load/layui/css/layui.css"/>
<script type="text/javascript" src="../load/layui/layui.js"></script>
</head>
<body>
	<script type="text/javascript">
		layui.use(['layer', 'table', 'jquery','form'], function(){
		  var layer = layui.layer;
		  var table = layui.table;
		  var form = layui.form;
		  var $ = layui.jquery;
		  var clazzs;
		  $.post('../clazz/getAll',function(data){
			  clazzs = data;
		  });
		  
		  table.render({
				elem : '#user-table',
				url : '../stu/list',
				page : true,
				cols: [[ 
				    {field: 'id', title: 'ID', align : 'center'}
				    ,{field: 'sn', title: '编号', align : 'center'}
				    ,{field: 'name', title: '姓名', align : 'center'}
				    ,{field: 'password', title: '密码', align : 'center',templet: function(temp){return "********";}}
				    ,{field: 'clazz_id', title: '所属班级', align : 'center', templet: function(temp){
				    	for(var d in clazzs){
				    		if(clazzs[d].id == temp.clazz_id){
				    			return clazzs[d].name;
				    		}
				    	}
				      }}
				    ,{field: 'sex', title: '性别', align : 'center'}
				    ,{field: 'mobile', title: '联系号码', align : 'center'}
				    ,{field: 'qq', title: 'QQ', align : 'center'}
				    ,{field: 'amount', title: '账户余额', align : 'center'}
				    ,{field: 'integral', title: '积分', align : 'center'}
				    ,{field: 'right', title: '操作', align : 'center', toolbar : '#right-bar'} 
				  ]]
			});
		
		  table.on('tool(user-list)', function(obj){ 
			  var data = obj.data 
		    ,layEvent = obj.event; 
			if(layEvent === 'edit'){
		    	var index = layer.open({
		    		  type: 1,
		    		  title:'修改用户',
		    		  skin: 'layui-layer-rim', 
		    		  area: ['390px', '600px'],
		    		  content: $('#edit-view').html()
		    		});
		    	form.val('edit-form',{
		    		'id':data.id,
		    		'sn':data.sn,
		    		'name':data.name,
		    		'clazz_id':data.clazz_id,
		    		'sex':data.sex,
		    		'mobile':data.mobile,
		    		'qq':data.qq,
		    	});
		    	for(var c in clazzs){
		    		if(data.clazz_id == clazzs[c].id){
		    			$('#select-clazz').append('<option selected="selected" value="'+clazzs[c].id+'">'+clazzs[c].name+'</option>');
		    		}else{
		    			$('#select-clazz').append('<option value="'+clazzs[c].id+'">'+clazzs[c].name+'</option>');
		    		}
		    		
		    	}
		    	form.render();
		    	form.on('submit(edit-form-btn)', function(data){
		    		if(data.field.password == data.field.password2){
		    			 $.post('../stu/edit',data.field,function(flag){
						    	if("-1" == flag){
						        	layer.msg('姓名已存在', {icon: 5});  
							    } else if("0" == flag){
							    	layer.msg('修改失败', {icon: 5});  
								} else if("1" == flag){
									layer.msg('修改成功', {icon: 6});  
									table.reload('user-table', {});
									layer.close(index);
								}
							     
						    });
		    		}else{
		    			 layer.msg('两次密码不一致', {
							  offset: 't',
							  anim: 6
							});
		    		}
				    return false;
				  });
		    }
			
			
			
		  });
	
		
		

		});
	</script>

	<script type="text/html" id="right-bar">
 		<a class="layui-btn layui-btn-radius layui-btn-xs" lay-event="edit" id="edit-btn">编辑</a>
	</script>

	<script type="text/html" id="edit-view">
<form class="layui-form" action="" lay-filter="edit-form">
<br/>
<div class="layui-form-item">
    <label class="layui-form-label">学号</label>
    <div class="layui-input-inline">
      <input type="text" name="sn" required lay-verify="required"  autocomplete="off" class="layui-input" readonly="readonly">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-inline">
      <input type="text" name="name" required lay-verify="required"  autocomplete="off" class="layui-input">
    </div>
  </div>
<div class="layui-form-item">
    <label class="layui-form-label">班级</label>
    <div class="layui-input-block">
      <select name="clazz_id" id="select-clazz" lay-verify="required">
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <input type="radio" name="sex" value="男" title="男">
      <input type="radio" name="sex" value="女" title="女" checked>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">联系号码</label>
    <div class="layui-input-inline">
      <input type="text" name="mobile" required lay-verify="required"  autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">QQ</label>
    <div class="layui-input-inline">
      <input type="text" name="qq" required lay-verify="required"  autocomplete="off" class="layui-input">
    </div>
  </div>

 <div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-inline">
      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>
<div class="layui-form-item">
    <label class="layui-form-label">确认密码</label>
    <div class="layui-input-inline">
      <input type="password" name="password2" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>
	<input type="hidden" name="id"/>
	
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="edit-form-btn">提交以修改</button>
    </div>
  </div>
</form>
	</script>
	
	<table class="layui-hide" id="user-table" lay-filter="user-list"></table>
	
</body>
</html>