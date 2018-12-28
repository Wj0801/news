<%@page import="com.entity.Article"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Nav"%>
<%@page import="com.tools.AllUserString" import="com.sqlHelper.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
      	SqlHelper sh=new SqlHelper();
    	String id=request.getParameter("id");
    	Article a=new Article();
    	a.setArticle_id(id);
  		a = sh.queryArticle(a);
    	sh.closeConn();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改文章</title>
  <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath() %>/kindeditor/kindeditor-all.js"></script>      
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath() %>/kindeditor/lang/zh-CN.js"></script> 
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script> 

  	<script language="javascript" type="text/javascript">
   	KindEditor.ready(function(K) {
	       K.create('#article_content', {  
	          uploadJson : '<%=request.getContextPath() %>/kindeditor/jsp/upload_json.jsp',  
	          fileManagerJson : '<%=request.getContextPath() %>/kindeditor/jsp/file_manager_json.jsp',  
	         allowFileManager : true,
	         afterBlur: function(){this.sync();}
	       });  
 		 });  
   		
   </script>
</head>
<body>
	<h1>修改文章页面</h1>
	<form  >
		文章标题:<input type = "text" name="article_name" id="article_name" value="<%=a.getArticle_name() %>"/>
		<br/>
		文章类别:<select name="nav_id" id="nav_id" >
				<option>请选择文章类别</option>
				<%
				    List<Nav> li =  new ArrayList();
				    SqlHelper sh1 = new SqlHelper();
					li =  sh1.queryNavAll();
					String selected = "selected = \"selected\"";
					String s;
				    for(Nav n:li)
				    {	
				    	if(n.getNav_id().equals(a.getNav_id())){
				    		s = selected;
				    	}else{
				    		s="";
				    	}
				    	String str = "<option "+s+" value=\""+n.getNav_id()+"\">"+n.getNav_name()+"</option>";
				    	out.print(str);
				    }				
				%>
		</select> 
		<br/>
		发布时间:<input type="date" name="article_time" id="article_time" value="<%=a.getArticle_time() %>"/>
		<br/>
		作者:<input type="text" name="article_author" id = "article_author"   value="<%=a.getArticle_author() %>" />
		<br/>
		文章内容：
			<textarea  id="article_content" rows="25" cols="100" name="article_content"  ><%=a.getArticle_content() %></textarea>
		<br/>
			<input type="button" onclick="updateArticle()"  value="修改"> 
	</form>
</body>
<script type="text/javascript">
		function updateArticle() {
			var name=$("#article_name").val();  
			var nav_id=$("#nav_id option:selected").val();
			var time=$("#article_time").val();
			var author=$("#article_author").val();
			var content=$("#article_content").val();
			var id="<%=id%>";
			
			var url="../updateArticle";
			var param="article_name="+name+"&nav_id="+nav_id+"&article_time="+time+"&article_author="+author+"&article_content="+content+"&id="+id;
			console.log(param);
			$.post(url,param,function(rst){
				if(rst==0){
					alert("内容不能为空！");
				}else if(rst==1){
					alert("修改成功！即将跳转到文章管理页面！");
					window.location="<%=request.getContextPath()%>/goShowArticleServlet";
				}else if(rst==2){
					alert("修改失败！");
				}
			},"text");
			
			
		}
</script>
</html>