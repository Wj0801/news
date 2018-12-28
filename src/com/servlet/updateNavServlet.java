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
 * Servlet implementation class updateNavServlet
 */
@WebServlet("/updateNavServlet")
public class updateNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		
		String nav_id = request.getParameter("nav_id");
		String nav_name = request.getParameter("nav_name");
		String nav_weight_str = request.getParameter("nav_weight");
	    System.out.println(nav_id+nav_name+nav_weight_str);
		
		if("".equals(nav_id) || nav_id == null ||"".equals(nav_name) || nav_name == null||"".equals(nav_weight_str) || nav_weight_str == null)
		{
			response.sendRedirect("admin/updateNavError.jsp");
		}else
		{
			//执行修改
			SqlHelper sh = new SqlHelper();
			Nav n = new Nav(nav_id, nav_name, Integer.parseInt(nav_weight_str));
			if(sh.updateNavNameAndWeight(n)) {
				response.sendRedirect("admin/TypeUser.jsp");
			}else
			{
				response.sendRedirect("admin/updateNavError.jsp");
			}
			
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
