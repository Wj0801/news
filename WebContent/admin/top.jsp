<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.getSession().getAttribute("abc");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上页面</title>
<style>
  *{
      margin: 0px;
      padding: 0px;  	 
  }
.top{
    width: 100%;
    min-width: 900px;
    height:80px;
  	background-image: url("../img/1.png");
  	background-size:100% 100%; 
  	background-attachment:fixed;
 
}
.size{  
    font-size: 20px;
    line-height: 80px;
    color: #fffaf0;
} 

.ul{

	width: 520px;
	height: 80px;
	line-height: 80px;
	
}
.ul li{
	float: left;
	margin-left:20px ;
	list-style: none;
	
}
.left{
	width: 200px;
	height: 80px;
	float: left;
	text-align: center;
}
.right{
	width: 420px;
	height: 80px;
	float: right;
	
}
a{
text-decoration:none;
color: yellow;
}

    </style>
</head>
<body>
        <div class="top">
        	<div class="left">
          		 <img style="float: left; width: 80px;height: 80px;" src="../img/huawei.png"/>        
           		 <span class="size">新闻管理系统</span>
            </div>
            <div class="right">
        	  <ul class="ul">
	              <li>欢迎您:<a href="information.jsp" id="name" target="right"><%=request.getSession().getAttribute("name") %></a></li>
	              <li><img  src="../img/zhuce.png"/><a  href="../regist.jsp" target="_top" >用户注册</a></li>
	              <li><img  src="../img/denglu.png"/><a  href="../login.jsp" target="_top">用户登陆</a></li>
	              <li><img  src="../img/tuichu.png"/><a  onclick="ExitTheUser()"	target="right" >注销</a></li>
	              </ul>
            </div>
        </div>
</body>
<script type="text/javascript">
		function ExitTheUser(){
			
			var a = confirm("确定要注销<%=request.getSession().getAttribute("name") %>用户吗？");
			//将修改页面中的value值带入到传入的地址去
			if(a){
			//window.parent.location="../login.jsp";
			window.parent.location.href='../ExitTheUserServlet';
			}
		
		}
		if("<%=session.getAttribute("name")%>"=="null"){
			$("#name").click(function() {
				alert("没有登陆，请登陆在查看个人信息！");
				return false;
			});
		}

</script>
</html>