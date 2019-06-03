<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>积木课件</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="shortcut icon" href="./load/static/img/logo.ico" type="image/x-icon" />
		<link rel="stylesheet" href="./load/static2/css/font.css">
		<link rel="stylesheet" href="./load/static2/css/weadmin.css">
		<link rel="stylesheet" href="./load/static2/layui/css/layui.css">
		<script src="./load/static2/lib/layui/layui.js" charset="utf-8"></script>
		<script src="./load/static/js/jquery-1.9.1.js" charset="utf-8"></script>
		
		<style>
			#tofacepage {
				background-color: yellowgreen;
			}
			#logo-span {
				font-size: 30px;
			}
		</style>
		
	</head>
	<body class="login-bg">
		<script type="text/javascript">
		layui.use(['layer', 'table', 'jquery','form'], function(){
		  var layer = layui.layer;
		  var table = layui.table;
		  var form = layui.form;
		  var $ = layui.jquery;
	  
		  $('#login').click(function(){
			  var name = $('input[name=name]').val();
				var password = $('input[name=password]').val();
				if(name != '' && password != ''){
					$.post("stu/login",{"name":name,"password":password},function(flag){
						
						  if('0' == flag){
							  layer.msg('用户不存在', {
								  offset: 't',
								  anim: 6
								});
						  }else if("-1" == flag){
							  layer.msg('密码错误', {
								  offset: 't',
								  anim: 6
								});
						  }else if("1" == flag){
							  window.location.href = "main.jsp";
						  }	
					});
				} else {
					layer.msg('用户或密码不能为空', {
						  offset: 't',
						  anim: 6
						});
				}
		  });

		  $('#add').click(function(){  
			  var index = layer.open({
	    		  type: 1,
	    		  title:'注册',
	    		  skin: 'layui-layer-rim', 
	    		  area: ['370px', '550px'],
	    		  content: $('#add-view').html()
	    		});
			  $.post('./clazz/getAll',function(data){
				  for(var d in data){
					  $('#select-clazz').append('<option value="'+data[d].id+'">'+data[d].name+'</option>');
				  }
                  form.render();
			  });

			  form.on('submit(add-form-btn)', function(data){
				  if(data.field.password == data.field.password2){
					  $.post('./stu/add',data.field,function(flag){
					    	if('-1' == flag){
					    		layer.msg('用户名已存在', {
									  offset: 't',
									  anim: 6
									});
						    }else if('1' == flag){
								layer.msg('注册成功', {icon: 6}); 
								layer.close(index);
                                window.location.href = "main.jsp";

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
			  
			  
			  
			  
		  });
		  

		})
	</script>
	
		
		<div>
			<div class="login">
				<div class="message"><span id="logo-span">积木</span><br/>&emsp;&emsp;&emsp;&emsp;积木课件平台</div>
				<div id="darkbannerwrap"></div>
				
					<input name="name"  placeholder="用户名" type="text" lay-verify="required" class="layui-input">
					<hr class="hr15">
					<input name="password" lay-verify="required"  placeholder="密码" type="password" class="layui-input">
					<hr class="hr20">
					<input type="button"  value="登录"  id="login" style="width:100%;" >
					<hr class="hr20">
					<input type="button" value="注册"  id="add" style="width:100%;" >
					<hr class="hr15">
				
			
			</div>
		</div> 
		<script type="text/html" id="add-view">
		<form class="layui-form" action="" lay-filter="edit-form">
<br/>
<div class="layui-form-item">
    <label class="layui-form-label">学号</label>
    <div class="layui-input-inline">
      <input type="text" name="sn" required lay-verify="required"  autocomplete="off" class="layui-input">
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
      <input type="password" name="password" required lay-verify="requireds" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>
<div class="layui-form-item">
    <label class="layui-form-label">确认密码</label>
    <div class="layui-input-inline">
      <input type="password" name="password2" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>
	
	
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="add-form-btn">提交以注册</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
	</script>
		
	</body>

</html>