package com.tools;

import java.util.List;


import com.entity.ArticleNav;
import com.entity.Nav;
import com.entity.User;
import com.sqlHelper.SqlHelper;

public class AllUserString {
	//获取所有管理员的信息 拼接为页面可用的字符串
	public   String  getAllUser()
	{
			SqlHelper sh = new SqlHelper();
			List<User> list = sh.selectUserIDs();   //调用查询所有管理员的类
			String tableStr = "";
			int i = 1;       //默认排序为1
			for(User u:list)
				//在工具类中拼接字符串，id，name。密码不显示
			{
				tableStr += "<tr class=\"tr1\">\n"
							+ "<td><input type=\"radio\" name=\"ma\" value=\""+u.getId()
							+"\" style=\"margin-left:18.5px ;\"></td>"
							+ "<td class=\"td\">"+(i++)+"</td >"
							+ "<td class=\"td\">"+u.getId()+"</td>"
							+ "<td class=\"td\">"+u.getName()+"</td>"
						+ "</tr>\n";
			}
			sh.closeConn();
		return tableStr;
	}
	//获取id修改时显示在input中
	public User getUserById(String id)
	{
		User u=new User();
		u.setId(id);
		System.out.println(u);
		SqlHelper sh=new SqlHelper();
		User uu= sh.selectUserID(id);
		System.out.println(uu);
		return uu;
	}
	
	
	
	//获取所有类别的信息 拼接为页面可用的字符串
		public String getAllNav() {
			SqlHelper sh=new SqlHelper();
			List<Nav> list=sh.queryNavAll();
			String tableStr="";
			int i=1;
			for(Nav n:list)
			{
				tableStr += "<tr class=\"tr1\">\n"
							+ "<td><input type=\"radio\" name=\"ma\" value=\""+n.getNav_id()+"\" style=\"margin-left:18.5px ;\"></td>\n"
							+ "<td class=\"td\">"+(i++)+"</td>\n"
							+ "<td class=\"td\">"+n.getNav_name()+"</td>\n"
							+"<td class=\"td\" >"+n.getNav_weight()+"</td>"
						+ "</tr>\n";
			}
			sh.closeConn();	
			return tableStr;
		}
		//获取id修改时显示在input中
		public Nav getNavById(String id)
		{
				Nav n = new Nav();
				n.setNav_id(id);
				SqlHelper sh = new SqlHelper();	
				Nav nn  = sh.queryNav(n);
				sh.closeConn();
				return nn;
		}
		
		//显示文章管理页面的内容
		public   String  getAllArticle()
		{
				SqlHelper sh = new SqlHelper();
				List<ArticleNav> li = sh.queryArticleNav();
				String tableStr = "";
				int i = 1;
				for(ArticleNav a:li)
				{
					tableStr += "<tr ><td ><input type=\"radio\" name=\"wz\" value=\""+a.getArticle_id()+"\" style=\"margin-left:18.5px ;\"></td>"
							+ "<td	class=\"td\">"+(i++)
							+"</td><td  class=\"td\">"+a.getArticle_name()
							+"</td><td	class=\"td\">"+a.getArticle_author()
							+"</td><td	class=\"td\">"+a.getArticle_time()
							+"</td><td	class=\"td\">"+a.getNav_name()+"</td></tr>";	
				}
				sh.closeConn();
			return tableStr;
		}
		
	
		
		
		
		
	
		
}
