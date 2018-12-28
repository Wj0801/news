<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加类别</title>
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
			height: 230px;
			background: rgb(255,255,255,0.8);
			position: fixed;     /*以窗口的方式定位 顶点*/
			left: 50%;
			top:50%;
			margin-left:-170PX ;  /*确定表单在中间*/
			margin-top: -135px;
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
			margin-top: 30px;
		}
	</style>
	</head>
	<body>
	<form action="../AddNavServlet"  method="post" id="myFrom">
		<div class="regist">
			<div class="zhuce">添加类别</div>
			<div class="name">
			<input type="text" placeholder="请输入类别名称" id="nav_name" name="nav_name"/>
				<img src="../img/id.png">
			<div>
			<div class="name">
			<input type="text" placeholder="请输入权重" id="nav_weight" name="nav_weight"/>
				<img src="../img/name.png" />
			</div>
			</div>
			<input type="button"  class="btn" onclick="addNav()" value="添加"/>
		</div>
		</div>
		</form>
	</body>
<script type="text/javascript">
          function addNav(){
        	//获取用户填写的信息
  			var var_name = document.getElementById("nav_name").value;
  			var var_weight = document.getElementById("nav_weight").value;

        	  
  			var flag = true;
			//验证编号信息
			if(var_name == "")
			{
				alert("输入的类别名称不能为空！");
				flag = false;
			}
			
			//验证姓名信息
			if(var_weight == "")
			{
				alert("输入的权重不能为空！");
				flag = false;
			}
		
			//提交表单
			
			if(flag)
			{
				//alert("添加成功，即将跳转到类别管理页面！");
				document.getElementById("myFrom").submit();
			}
		}
</script>

</html>