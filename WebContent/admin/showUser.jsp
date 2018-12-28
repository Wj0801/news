<%@page import="com.tools.AllUserString"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员信息</title>
<style>
		*{
			margin: 0;
			padding: 0;
			box-sizing: border-box;
			background-image: url(images/j.jpg);
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
</head>
	<body>
			
		<div class="showUser" >
	<table  class="show">
		<tr >
			<td  class="choose">选择</td>
			<td class="td1">序号</td>
			<td  class="td1">id编号</td>
			<td  class="td1">管理员名称</td>
		<tr>
		<%
			 AllUserString as =new AllUserString();
			String str =  as.getAllUser();
			out.print(str);
		%>
	
		</table>
			<div>
				<a href="addUser.jsp">添加管理员</a>
				<a  href="#" onclick="updateUser()">修改</a>
				<a  href="#" onclick="deleteUser()">删除</a>
				
			</div>
	</div>
<script type="text/javascript">
 			function updateUser(){
 				var ma=document.getElementsByName("ma");
 				var obj=null;
 				for(var i=0;i<ma.length;i++){
 					if(ma[i].checked==true){
						obj=ma[i];
						break;
 					}	
 				}
 				if(obj==null){
					alert("请选中一个管理员");
					return;
 				}
				//将修改页面中的value值带入到传入的地址去
				location="UpdateUser.jsp?id="+obj.value;
 			}
			function deleteUser(){
				var ma=document.getElementsByName("ma");
 				var obj=null;
 				for(var i=0;i<ma.length;i++){
 					if(ma[i].checked==true){
						obj=ma[i];
						break;
 					}	
 				}
 				if(obj==null){
					alert("请选中一个管理员");
					return;
 				}
 				var a = confirm("确定要删除这条数据吗？");
				//将修改页面中的value值带入到传入的地址去
				if(a){
					location="../deleteUser?id="+obj.value;					
				}
			}
</script>
</body>
</html>