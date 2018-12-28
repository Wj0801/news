<%@page import="com.tools.AllUserString"%>
<%@page import="com.sqlHelper.SqlHelper"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		String ctx = request.getContextPath();
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"src="http://localhost:8080/News/js/jquery.min.js"></script>
<title>文章管理</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.showUser {
	width: 800px;
	height: 420px;
	position: fixed; /*以窗口的方式定位 顶点*/
	left: 50%;
	top: 40%;
	margin-left: -400px; /*确定表单在中间*/
	margin-top: -220px;
}

.show {
	border-spacing: 0px;
	width: 800px;
}

.choose {
	width: 50px;
	height: 50px;
	text-align: centen;
	background-color: coral;
}

.new {
	float: right;
}

.td1 {
	width: 150px;
	height: 50px;
	text-align: center;
	background-color: coral;
}

.td {
	width: 150px;
	height: 50px;
	text-align: center;
}

tr:hover {
	background-color: #DDDDDD;
}

a {
	height: 20px;
	text-decoration: none;
	color: #FC9E9E;
	font-size: 20px;
}

.selecttext {
	width: 178px;
	height: 40px;
	border: 2px solid #FC9E9E;
	border-radius: 5px; /*圆角*/
}

.select {
	width: 98px;
	height: 40px;
	background: coral;
	border: 1px solid red; /*边框为1，为红色*/
	color: white;
	border-radius: 5px; /*圆角*/
}

.jumptext {
	width: 98px;
	border: 1px solid #dddddd; /*边框为1，为灰色*/
	border-radius: 5px; /*圆角*/
}

div a {
	padding: 15px;
}

.p {
	float: right;
}

.jump {
	width: 48px;
	height: 20px;
	background: coral;
	border: 1px solid #dddddd; /*边框为1，为灰色*/
	color: white;
	border-radius: 5px; /*圆角*/
}
}
</style>
</head>
<body>
	<div class="showUser">
		<div>
			<form id="likeQuery" action="<%=ctx %>/goShowArticleServlet">
				<input class="selecttext" type="text" name="keyword" placeholder="输入文章标题或作者" value="${keyword}"/> 
				<input name="likeQuery" value="true" style="display:none"/>
				<input class="select" type="button" value="查询" onclick="selectArticle()" />
				<a class="new" href="admin/NewArticle.jsp" target="right">跳转到新建文章</a>
			</form>
			
		</div>
		<table class="show">
			<tr>
				<td class="choose">选择</td>
				<td class="td1">序号</td>
				<td class="td1">文章标题</td>
				<td class="td1">作者</td>
				<td class="td1">发布时间</td>
				<td class="td1">文章类别</td>
			</tr>
			<!--
				5
			 	
			 	(pageCurrent-1)*pageNum ~ pageCurrent*pageNum-1
			 	
			 	1: 0 - 4
			 	2: 5 - 9
			 	
			 	pageCurrent 页数
			 	pageSize 总页数
			 	pageNum 每页条数
			 	
			 	
			 	 -->
			<c:forEach items="${list }" var="item" varStatus="status"
				begin="${(pageCurrent-1)*pageNum}" end="${pageCurrent*pageNum -1}">
				<tr>
					<td><input type="radio" name="wz" value="${item.article_id }"></td>
					<td class="td">${status.count }</td>
					<td class="td">${item.article_name }</td>
					<td class="td">${item.article_author }</td>
					<td class="td">${item.article_time }</td>
					<td class="td">${item.nav_name }</td>
				</tr>
			</c:forEach>


		</table>
		<div>
			<a href="#" onclick="updateArticle()">修改</a>
			 <a href="#"onclick="deleteArticle()">删除</a>
			<div class="p">
				<a href="#" onclick="firstPage()" target="right">首页</a> <a href="#"
					onclick="previewPage()" target="right">上一页</a> <a href="#"
					onclick="nextPage()" target="right">下一页</a> <a href="#"
					onclick="lastPage()" target="right">尾页</a> <input type="text"
					class="jumptext" id="jumptext" /> <input type="button"
					class="jump" onclick="jumpPage()" value="跳转" />
			</div>
		</div>

	</div>
<script type="text/javascript">
			//首页
			function firstPage() {

				doPreNext(1);
			
			}
			
			//尾页
			function lastPage() {
				doPreNext(${pageSize});
			}
			
			//上一页
			function previewPage() {
				var pageCurrent = ${pageCurrent};
				if(pageCurrent >1){
					pageCurrent -= 1;
				}else{
					pageCUrrent = 1;
				}
				doPreNext(pageCurrent);
			}
			//下一页
			function nextPage() {
				var pageCurrent = ${pageCurrent};
				var pageSize = ${pageSize};
				if(pageCurrent < pageSize){
					pageCurrent += 1;
				}else{
					pageCurrent = pageSize;
				}
				doPreNext(pageCurrent);
			}
			
			
			function doPreNext(pageCurrent){
				var keyword = $(".selecttext").val();
				if(keyword.trim() =="" || keyword.trim() == null){
					keyword = "";
				}else{
					keyword = "&likeQuery=true&keyword="+keyword;
				}
				location="<%=request.getContextPath()%>/goShowArticleServlet?pageCurrent=" + pageCurrent + keyword;	
			};
			
			
			//跳转
			function jumpPage(){
					var text=document.getElementById("jumptext").value;
					text=parseInt(text);
				 if( typeof text  != typeof 0){
						alert("请输入数字！");
					}else if(text>=1 && text<=${pageSize}){

						doPreNext(text);
			  		}else {
			  			alert("没有这一页！");
					}
						 console.log(text);
			}
			
			//修改
 			function updateArticle(){
 				var wz=document.getElementsByName("wz");
 				var obj=null;
 				for(var i=0;i<wz.length;i++){
 					if(wz[i].checked==true){
						obj=wz[i];
						break;
 					}	
 				}
 				if(obj==null){
					alert("请选中一个管理员");
					return;
 				}
				//将修改页面中的value值带入到传入的地址去
				location="admin/updateArticle.jsp?id="+obj.value;
 			}
			
			
			//删除
			function deleteArticle(){
				var wz=document.getElementsByName("wz");
 				var obj=null;
 				for(var i=0;i<wz.length;i++){
 					if(wz[i].checked==true){
						obj=wz[i];
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
					location="<%=request.getContextPath()%>/deleteArticle?id="+obj.value;	
					
				}
			}
			//查询
			function selectArticle() {	
				//用class获取输入的字符去数据库模糊查询
				var keyword=$(".selecttext").val();
				if(keyword.trim() == ""){
					alert("请输入要查询的内容！");
					}
				else{
					
				$("#likeQuery").submit();
				}
			}
			
			
</script>
</body>
</html>