<%@page import="com.tools.AllUserString"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>类别管理</title>
</head>
	<style>
		*{
			margin: 0;
			padding: 0;
			box-sizing: border-box;
			}
		.showUser{
			position: fixed;     /*以窗口的方式定位 顶点*/
			left: 50%;
			top:50%;
			margin-left:-300PX ;  /*确定表单在中间*/
			margin-top: -250px;
			
			}
		.show{
			border-spacing: 0px;
			width: 650px;
			}
		.top{
			height:40px ;
			line-height: 40px;
			background: red;
			text-align: center;
		}
		.choose{
			width: 50px;
			text-align: center;
			background-color: coral;
		}
		.td1{
			width: 200px;
			height: 50px;
			text-align: center;
			background-color: coral;
		}
		.td{	
			width: 200px;
			height: 50px;
			text-align: center;
			
		}
		.tr1:hover{
			background-color:#DDDDDD;
		}
		a{	
			text-decoration:none;
			color: #FC9E9E;
			font-size: 20px;
		}
		
	</style>
	<body>
		<div class="showUser" >
	<table  class="show">
		<tr >
			<td  class="choose">选择</td>
			<td  class="td1">序号</td>
			<td  class="td1">类别名称</td>
			<td  class="td1">权重</td>
		<tr>
   
   		<%
			AllUserString as=new AllUserString();
   		   	String type=  as.getAllNav();
   			 out.print(type);
		%>
		
		</table>
			<div>
				<a href="addNav.jsp">添加类别</a>
				<a  href="#" onclick="updateNav()">修改</a>
				<a  href="#" onclick="deleteNav()">删除</a>
				
			</div>
	</div>
	</body>
	<script type="text/javascript">
		function updateNav(){
				var ma=document.getElementsByName("ma");
				var obj=null;
				for(var i=0;i<ma.length;i++){
					if(ma[i].checked==true){
						obj=ma[i];
						break;
					}	
				}
				if(obj==null){
				alert("请选中一个类别");
				return;
				}
			//将修改页面中的value值带入到传入的地址去
			location="updateNav.jsp?nav_id="+obj.value;
			}
		function deleteNav(){
			var ma=document.getElementsByName("ma");
				var obj=null;
				for(var i=0;i<ma.length;i++){
					if(ma[i].checked==true){
					obj=ma[i];
					break;
					}	
				}
				if(obj==null){
				alert("请选中一个类别");
				return;
				}
				var a = confirm("确定要删除这个类别吗？删除后该类别下的新闻也将删除！");
				//将修改页面中的value值带入到传入的地址去
				if(a){
					location="../deleteNav?nav_id="+obj.value;					
				}
				
		}	
	</script>
</html>