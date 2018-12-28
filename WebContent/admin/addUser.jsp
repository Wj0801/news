<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员</title>
</head>

	<style>
		body{
			margin: 0;
			padding: 0;
			background-image:url(../img/regist.jpg);
		}
		.regist{
			padding: 20px;
			width:300px;
			height: 370px;
			background: rgb(255,255,255,0.8);
			position: fixed;     /*以窗口的方式定位 顶点*/
			left: 50%;
			top:50%;
			margin-left:-170PX ;  /*确定表单在中间*/
			margin-top: -205px;
		}
		.zhuce{
			font-size: 25px;
			line-height: 60px;
			height: 60px;
			text-align: center;
			font-weight: bold;     /*加粗*/
			margin-bottom: 20px;;
		}
		.name{
			width: 100%;
			height: 40px;
		    background: white;
			margin-bottom: 20px;
		}
		.name input{
			float: left;
			width: 250px;
			padding-left: 10px;
			height: 38px;
			border: none;
			outline: none;
			
		}
		.name img{
			float: left;
			height: 20px;
			width: 20px;
			margin: 10px ;
		
		}
		.btn{
			height: 40px;
			width: 298px;
			background: #84c1ff;
			border: 1px solid #84c1ff;   /*边框为1，为浅蓝色*/
			color: white;                
			border-radius: 5px;   /*圆角*/
			margin-top: 10px;
		}
</style>

<body>
	<form action="../AddUserServlet"  method="post" id="myFrom">
		<div class="regist">
			<div class="zhuce">添加管理员</div>
			<div class="name">
				<input type="text" placeholder="id" id="id" name="id"/>
				<img src="../img/id.png">
			</div>
			<div class="name">
				<input type="text" placeholder="账号" id="name" name="name"/>
				<img src="../img/name.png" />
			</div>
			<div class="name">
				<input type="password" placeholder="密码" id="password" name="password"/>
				<img src="../img/password.png" />
			</div>
			<div class="name">
				<input type="password" placeholder="确认密码" id="cfpassword" name="cfpassword"/>
				<img src="../img/password.png" />
			</div>
			<input type="button"  class="btn" onclick="zhuce()" value="添加"/>
		</div>
		</div>
		</form>
	</body>
<script type="text/javascript">
          function zhuce(){
        	//获取用户填写的信息
  			
  			var id = document.getElementById("id").value;
  			var name = document.getElementById("name").value;
  			var pwd = document.getElementById("password").value;
  			var cfpwd = document.getElementById("cfpassword").value;
        	  
  			var flag = true;
			//验证编号信息
			if(id == "" || id.length < 6)
			{
				alert("输入的编号内容不能为空，且长度不能小于6位！");
				flag = false;
			}
			
			//验证姓名信息
			if(name == "" || name.length < 6)
			{
				alert("输入的姓名内容不能为空，且长度不能小于6位！");
				flag = false;
			}
			
			//验证密码信息
			if(pwd == "" || pwd.length < 6) 
			{
				alert("输入的密码内容不能为空，且长度不能小于6位！");
				flag = false;
			}
			
			//验证密码信息
			if(cfpwd == "" || cfpwd.length < 6 || pwd != cfpwd) 
			{
				alert("密码与确认密码不同，且长度不能小于6位！");
				flag = false;
			}
			
			//提交表单
			
			if(flag)
			{
				alert("注册成功，即将跳转到登陆页面");
				document.getElementById("myFrom").submit();
			}
		}
</script>

</html>