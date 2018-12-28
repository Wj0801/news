package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Article;
import com.sqlHelper.SqlHelper;

/**
 * Servlet implementation class deleteArticeServlet
 */
@WebServlet("/deleteArticle")
public class deleteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//获取id
		String article_id=request.getParameter("id");
		String article_name=request.getParameter("article_name");
		String article_time=request.getParameter("article_time");
		String article_author=request.getParameter("article_author");
		String article_content=request.getParameter("article_content");
		String nav_id=request.getParameter("nav_id");
		//验证
		if("".equals(article_id)||article_id==null) {
			
			response.sendRedirect("admin/deleteArticleError.jsp");
		}else{
			//删除
			SqlHelper sh=new SqlHelper();
			Article a=new Article(article_id,article_name,article_time,article_author,article_content,nav_id);
			if(sh.deleteArticle(a)) {
			response.sendRedirect(request.getContextPath()+"/goShowArticleServlet");
			}else {			
				response.sendRedirect("admin/deleteArticleError.jsp");
			}
			//关闭数据库	
			sh.closeConn();
		}
		
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
