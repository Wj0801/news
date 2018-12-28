<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<title>左页面</title>
<style>
*{
	margin: 0px;
	padding: 0px;

}
.left{
	float: left;
	width: 300px;
	background-image: url("../img/4.png");
  	background-size:100% 100%; 
  	background-attachment:fixed;
}
ul{
	width:300px;
	height: 280px;
	position:absolute;
	top:50%;
    margin-top:-150px ;
}
ul li{
	height: 70px; 
	line-height: 70px;
	font-size:20px ;
	text-align: center;
	list-style: none;
    
}
ul li:hover{
	background-color: gray;
}
a{
	color: #fff;
	text-decoration:none;
	display:block;
	width:300px;
	height:70px;
}

</style>
	</head>
	
	<body disabled="false">
		<div class="left">
			<ul>
				<li ><a href="showUser.jsp"  	 target="right">所有用户</a></li>
				<li><a href="NewArticle.jsp"		 target="right">新建文章</a></li>
				<li><a href="TypeUser.jsp"		 target="right">类别管理</a></li>
				<li><a href="../goShowArticleServlet"	 target="right">文章管理</a></li>
				<li><a  onclick="ExitSystem()"	target="_top">退出系统</a></li>
			</ul>	
		</div>
		
	</body>
	<script>
		//js控制div浏览器的高度
		var left = document.getElementsByClassName("left")[0];
		left.style.height = window.innerHeight + "px";
		window.onresize=function(){
			left.style.height = window.innerHeight + "px";
		}
		
		function ExitSystem(){
			var a = confirm("确定要退出系统吗？");
			//将修改页面中的value值带入到传入的地址去
			if(a){
			//window.parent.location="../login.jsp";
			window.parent.location.href='../ExitServlet';
			}
		
		}
		
		if("<%=request.getSession().getAttribute("name") %>" == "null" ){

			$("ul").click(function(){
				alert("没有登陆，请先登录在操作！");
				return false;
			});
		}
	
	</script>
</html>