package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.entity.Article;
import com.entity.ArticleNav;
import com.sqlHelper.SqlHelper;

/**
 * Servlet implementation class goShowArticleServlet
 */
@WebServlet("/goShowArticleServlet")
public class goShowArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goShowArticleServlet() {
        super();
        // TODO Auto-generated constructor stubre
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			SqlHelper sqlHelper=new	SqlHelper();
			String like=request.getParameter("likeQuery");
			String keyword=request.getParameter("keyword");
			
			List<ArticleNav> list = null;
			if(like!=null){
				list=sqlHelper.queryLikeArticle(keyword);
				System.out.println("queryLikeArticle");
			}else{
				list= sqlHelper.queryArticleNav();
				System.out.println("queryArticleNav");
			}
			System.out.println("是否为空"+like);
			System.out.println("多少条数据"+list.size());
			//System.out.println(keyword);
			
			int pageCurrent = 1;//当前页数
			
			if(request.getParameter("pageCurrent") != null) {
				System.out.println("点了页数");
				pageCurrent = Integer.parseInt(request.getParameter("pageCurrent"));
			}
			
			int pageSize = 0;//总页数
			int pageNum = 5;//每页个数
			if(list.size() % pageNum == 0)
				pageSize = list.size() / pageNum;
			else
				pageSize = list.size() / pageNum +1;
			
			HttpSession session=request.getSession();
			session.setAttribute("list", list);
			session.setAttribute("pageNum", pageNum);
			session.setAttribute("keyword", keyword);
			session.setAttribute("pageSize", pageSize);
			session.setAttribute("pageCurrent", pageCurrent);
			System.out.println("pageNum"+pageNum+"PageSIZE"+pageSize+"PageCurrent"+pageCurrent);
			request.getRequestDispatcher("admin/articleUser.jsp").forward(request, response);

	}

}