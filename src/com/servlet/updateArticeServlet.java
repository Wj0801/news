package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Article;
import com.sqlHelper.SqlHelper;


/**
 * Servlet implementation class updateArticeServlet
 */
@WebServlet("/updateArticle")
public class updateArticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateArticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String rst =null;
		//获取
		String article_id  =request.getParameter("id");
		String article_name=request.getParameter("article_name");
		String article_time=request.getParameter("article_time");
		String article_author=request.getParameter("article_author");
		String article_content=request.getParameter("article_content");
		String nav_id=request.getParameter("nav_id");
		//判断
		if( article_name == null || "".equals(article_name)||article_time == null || "".equals(article_time)||article_content == null || "".equals(article_content)||article_author == null || "".equals(article_author)||	nav_id == null || "".equals(nav_id)
			) {
			rst = "0";
		}else {
			//sql语句
			SqlHelper sh=new SqlHelper();
			Article a=new Article(article_id,article_name,article_time,article_author,article_content,nav_id);
			if(sh.updateArticle(a)) {
				rst = "1";
			}else {
				rst = "2";
			}
			
			//关闭数据库
			sh.closeConn();
		}
		
		out.write(rst);
		out.close();
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
