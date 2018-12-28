package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Nav;
import com.sqlHelper.SqlHelper;

/**
 * Servlet implementation class deleteNavServlet
 */
@WebServlet("/deleteNav")
public class deleteNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteNavServlet() {
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
		String nav_id=request.getParameter("nav_id");
		
		//验证id
		if("".equals(nav_id)||nav_id==null) {
			response.sendRedirect("admin/deleteNavError.jsp");
		}else {
			//执行删除
			SqlHelper  sh=new SqlHelper();
			Nav  n=new Nav();
			n.setNav_id(nav_id);

			if(sh.deleteNav(n))
			{
				response.sendRedirect("admin/TypeUser.jsp");
			}else
			{
				response.sendRedirect("admin/deleteNavError.jsp");
			}
			//关闭连接
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
