<%@page import="com.entity.User"%>
<%@page import="com.tools.AllUserString" %>
<%@page import="java.util.List"%>
<%@page import="com.sqlHelper.SqlHelper"%>
<%@page import="com.entity.ArticleNav"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
   		String id=session.getAttribute("id").toString();
    	System.out.println(id);
       AllUserString as=new AllUserString();
       User u= as.getUserById(id);
       
   %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<style>
	body{
			width: 800px;
			height:420px;
			position: fixed;     /*以窗口的方式定位 顶点*/
			left: 50%;
			top:40%;
			margin-left:-400px;  /*确定表单在中间*/
			margin-top: -220px;
			}
		.d{ 
			color:orange;
		}
		.show{
			border-spacing: 0px;
			width: 800px;
	
			}
		.td{	
			width: 150px;
			height: 50px;
			text-align: center;
			
		}
	
		.td1{
			width: 150px;
			height: 50px;
			text-align: center;
			background-color: coral;
		}

</style>
</head>
<body>
<h1 style="color: red ">个人信息页面</h1>
		<div class="d">
		编号(id):<input type="text" value="<%=u.getId() %>" readonly="readonly" />
		姓名(name):<input type="text" value="<%=u.getName() %>" readonly="readonly"/>
		密码(password):<input type="text" value="<%=u.getPassword()%>" readonly="readonly"/>
		</div>
		<h3 style="color: coral" >以发布的文章：</h3>
			<table  class="show">
			<tr >
				<td class="td1">序号</td>
				<td  class="td1">文章标题</td>
				<td  class="td1">作者</td>
				<td  class="td1">发布时间</td>
				<td  class="td1">文章类别</td>
			</tr >
			<%
			//显示文章管理页面的内容
					SqlHelper sh = new SqlHelper();
					List<ArticleNav> li = sh.queryArticleNav();
					String tableStr = "";
					int count=0;
					
					int i = 1;
					for(ArticleNav a:li)
					{
						if(a.getArticle_author().equals(session.getAttribute("name"))){
						tableStr += "<tr > <td	class=\"td\">"+(i++)
								+"</td><td  class=\"td\">"+a.getArticle_name()
								+"</td><td	class=\"td\">"+a.getArticle_author()
								+"</td><td	class=\"td\">"+a.getArticle_time()
								+"</td><td	class=\"td\">"+a.getNav_name()+"</td></tr>";
								count++;
						}	
						
					}
					sh.closeConn();
					if(count==0){
						out.print("该账号没有新建过文章，快去新建吧！");
					}else{
						out.print(tableStr);
					}
					
				%>
	
		</table>
	
</body>
<script type="text/javascript">
		
	


</script>
</html>