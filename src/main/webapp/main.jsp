<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>积木课件</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
   <link rel="shortcut icon" href="../load/static/img/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./load/static/css/font.css">
	<link rel="stylesheet" href="./load/static/css/xadmin.css">
	<link rel="stylesheet" href="./load/static/layui/css/layui.css"/>
    <script type="text/javascript" src="./load/static/js/jquery-1.9.1.js"></script>
    <script src="./load/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./load/static/js/xadmin.js"></script>
    <style>
    	#data-div{
    		margin-top: 3px;
    		margin-left: 10px;
    		width: 150px;
    		height: 34px;
    		border-radius: 10px 10px ;
    	}
    	.x-iframe{
    		margin-top:10px;
    		margin-left: 10px;
    	}
    </style>
	<script>
		var aId;
		$(function(){
			aId = 0;
			$('a[id = 0]').css('color','dodgerblue');
		});
		
		function changecolor(id){
			$('a[id = '+aId+']').css('color','');
			aId = id;
			$('a[id = '+aId+']').css('color','dodgerblue');
		}
	</script>
</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="./index.jsp">积木课件平台</a></div>
        <div class="left_open">
            <i title="折叠左侧栏" class="iconfont"><i class="layui-icon">&#xe668;</i>  </i>
        </div>

        <ul class="layui-nav right" lay-filter="">
        	<li class="layui-nav-item"><a title="链接到门户页面" href="./page/index.html"><i class="layui-icon layui-icon-release" style="font-size: 15px"></i></a></li>
        	<li class="layui-nav-item">欢迎&nbsp;[&nbsp;<shiro:principal/>&nbsp;]&nbsp;</li>
			<li class="layui-nav-item"><a href="stu/logout">安全退出</a></li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
            <li>
            	
				<ul>
					<div id="data-div">
					<li>	
						<a _href="./data-view.html" id="1" onclick="changecolor('1')">
							<i class="layui-icon">&#xe629;</i>
							 <cite>统计数据页</cite>
						</a>
					</li>
					</div>			
				</ul>
				<br/>
				
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-engine" style="font-size: 16px;"></i>  
                    <cite>系统信息管理</cite>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="./page/log_list.jsp" id="2" onclick="changecolor('11')">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<cite>登录日志记录</cite>
                        </a>
                    </li>
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="./druid/index.html" id="3" onclick="changecolor('11')">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<cite>SQL监控</cite>
                            
                        </a>
                    </li>
                </ul>
            </li>
             
            <li>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-user" style="font-size: 16px;"></i> 
                    <cite>用户信息管理</cite>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="./page/user_list.jsp" id="4" onclick="changecolor('20')">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<cite>用户信息管理</cite>
                        </a>
                    </li>
                </ul>
            </li>
           
            <li>
            	 <a href="javascript:;">
                    <i class="layui-icon layui-icon-log" style="font-size: 16px;"></i>  
                    <cite>购买记录信息</cite>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="./page/bill_list.jsp" id="5" onclick="changecolor('10')">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<cite>购买订单信息</cite>
                            
                        </a>
                    </li >
                </ul>
            </li>
           	
            <li>       
            </li>
            
             <li>
            	 <a href="javascript:;">
                    <i class="layui-icon layui-icon-tabs" style="font-size: 16px;"></i>  
                    <cite>课件信息管理</cite>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="./page/file_list.jsp" id="6" onclick="changecolor('10')">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<cite>课件信息管理</cite>
                            
                        </a>
                    </li >
                </ul>
            </li>
            <li>       
            </li>
             <li>
            	 <a href="javascript:;">
                    <i class="layui-icon layui-icon-ok-circle" style="font-size: 16px;"></i>  
                    <cite>账户充值操作</cite>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="./page/recharge_list.jsp" id="7" onclick="changecolor('10')">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<cite>账户充值操作</cite>
                            
                        </a>
                    </li >
                </ul>
            </li>
            <li>       
            </li>
            
        </ul>
      </div>
    </div>
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title" style="display:none";>
            <li class="home"><i class="layui-icon">&#xe68e;</i></li>
          </ul>
          <div class="layui-tab-content" id="">
            <div class="layui-tab-item layui-show">
            	<iframe src='./data-view.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
</body>
</html>