package com.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Article;
import com.sqlHelper.SqlHelper;

/**
 * Servlet implementation class AddArticleServlet
 */
@WebServlet("/AddArticle")
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		request.setCharacterEncoding("utf-8");
		//获取提交信息

		String article_name = request.getParameter("article_name");
		String article_content = request.getParameter("article_content");
		String article_time = request.getParameter("article_time");
		String article_author = request.getParameter("article_author");
		String nav_id = request.getParameter("nav_id");
		
		//验证
		if( article_name == null || "".equals(article_name)||article_time == null || "".equals(article_time)||article_content == null || "".equals(article_content)||article_author == null || "".equals(article_author)||	nav_id == null || "".equals(nav_id)
		) {

			
			response.sendRedirect("admin/NewArticleError.jsp");
		}else {
			String article_id = UUID.randomUUID().toString();
			Article a = new Article(article_id,article_name,article_time,article_author,article_content,nav_id);
			SqlHelper sh=new SqlHelper();
			if(sh.insertArticle(a)) {
				response.sendRedirect(request.getContextPath()+"/goShowArticleServlet");
			}else {
				
				response.sendRedirect("admin/NewArticleError.jsp");
			}
			//sh.closeConn();
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
