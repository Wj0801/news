<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
	<style>
		
     *{    
     	margin: 0;
     	padding: 0;
     }
     .bj{
     position:absolute;
     left:0;
     top:0;
     width:100%;
     height:100%;
     background: url("img/login1.png") no-repeat center;background-size: cover;
     }
     .login{
     	width: 300px;
     	height: 300px;
		position: fixed;     /*以窗口的方式定位 顶点*/
		left: 80%;
		top:50%;
		margin-left:-150PX ;  /*确定表单在中间*/
		margin-top: -150px;
     }
     .denglu{
     	width: 300px;
     	height: 30px;
     	font-size: 30px;
     	text-align: center;
     	font-weight: bold;     /*加粗*/
     	color: #F74A9B;
     	margin-bottom: 20px;
     }
		.name{
			width: 100%;
			height: 40px;
		    background: #F74A9B;
			margin-bottom: 20px;
		}
		.name input{
			float: left;
			width: 250px;
			padding-left: 10px;
			height: 40px;
			border: none;
			outline: none;
			 background: #84c1ff;
		}
		.name img{
			float: left;
			height: 20px;
			width: 20px;
			margin: 10px ;	
		}
		.btn{
			height: 40px;
			width: 148px;
			background: #84c1ff;
			border: 1px solid #84c1ff;   /*边框为1，为浅蓝色*/
			color: white;                
			border-radius: 5px;   /*圆角*/

		}
		.dl{
			width: 300px;
			height: 40px;
			margin-top: 30px;
		}
		.button{
			float: left;
		}
		.zhuce{
			line-height: 40px;
			text-align: center;
			
		}
		a{
			text-decoration:none;
			color: #FC9E9E;
			font-size: 10px;
		}
     
	</style>
	<body>
	<form action="loginServlet"  method="post" id="myFrom">
	<div class="bj">
		<div class="login">
			<div class="denglu">欢迎登陆</div>
			<div class="name">
				<input type="text" placeholder="id" id="id" name="id"/>
				<img src="img/name.png" />
			</div>
			<div class="name">
				<input type="password" placeholder="密码"  id="password" name="password"/>
				<img src="img/password.png" />
			</div>
			<div class="dl">
			<div class="button"><input type="button" onclick="login()" class="btn" value="登陆"></div>
			<div class="zhuce"><a href="regist.jsp">没有账号，去注册</a></div>
			</div>
		</div>
	</div>
		</form>
	<script type="text/javascript">
    function login(){
    	//获取用户填写的信息
			
			var id = document.getElementById("id").value;
			//var name = document.getElementById("name").value;
			var pwd = document.getElementById("password").value;
			//var cfpwd = document.getElementById("cfpassword").value;
    	  
			var flag = true;
		//验证编号信息
		if(id == "" || id.length < 6)
		{
			alert("输入的编号内容不能为空，且长度不能小于6位！");
			flag = false;
		}
		
		//验证密码信息
		if(pwd == "" || pwd.length < 6) 
		{
			alert("输入的密码内容不能为空，且长度不能小于6位！");
			flag = false;
		}

		//提交表单
		if(flag)
		{
			document.getElementById("myFrom").submit();   //把input数据提交到request后台去  取值以input name取值
		}
	}
	
	</script>
	</body>
</html>
