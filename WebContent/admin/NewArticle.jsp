<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Nav"%>
<%@page import="java.util.Date" %>
<%@page import="com.tools.AllUserString" import="com.sqlHelper.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建页面</title>
  <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath() %>/kindeditor/kindeditor-all.js"></script>      
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath() %>/kindeditor/lang/zh-CN.js"></script>  

  	<script language="javascript" type="text/javascript">
   	KindEditor.ready(function(K) {
	       K.create('#editor_id', {  
	          uploadJson : '<%=request.getContextPath() %>/kindeditor/jsp/upload_json.jsp',  
	          fileManagerJson : '<%=request.getContextPath() %>/kindeditor/jsp/file_manager_json.jsp',  
	         allowFileManager : true,
	         afterBlur: function(){this.sync();}
	       });  
 		 });  
   		
   </script>
</head>
<style>
	*{
		margin:0px;
		padding:0px;
	}
	form{ 
			width: 500px;
			height:600px;
			position: fixed;     /*以窗口的方式定位 顶点*/
			left: 30%;
			top:50%;
			margin-left:-250px;  /*确定表单在中间*/
			margin-top: -300px;
	}
	form p{
			color: coral;
	}
	
	.btn{
			width: 98px;
			height:30px;
			background: coral;
			border: 1px solid red;   /*边框为1，为红色*/
			color: white;                
			border-radius: 5px;   /*圆角*/
	}
</style>
<body>
	<h1 style="color: red ">添加文章页面</h1>
	<form action="../AddArticle" method="post" >
		<p>文章标题:<input type = "text" name="article_name" id="article_name"></p>
		<br/>
		<p>文章类别:<select name="nav_id">
				<option>请选择文章类别</option>
				<%
				    List<Nav> li =new ArrayList();
				    SqlHelper sh = new SqlHelper();
					li =  sh.queryNavAll();
				    for(Nav n:li)
				    {
				    	String str = "<option value=\""+n.getNav_id()+"\">"+n.getNav_name()+"</option>";
				    	out.print(str);
				    }				
				%>
		</select> 
		</p>
		<br/>
		<p>发布时间:<input type="date" name="article_time" id="article_time"/></p>
		<br/>
		<p>作者:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="article_author" id = "article_author" value="<%=session.getAttribute("name") %>" readonly="readonly"></p>
		<br/>
		<p>文章内容：
			<textarea  id = "editor_id" rows="25" cols="100" name="article_content"></textarea>
		</p>
		<br/>
		<p>	<input type="submit"	class="btn"  value="发布" > </p>
	</form>
</body>

</html>