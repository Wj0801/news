package com.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Nav;
import com.sqlHelper.SqlHelper;

/**
 * Servlet implementation class AddNavServlet
 */
@WebServlet("/AddNavServlet")
public class AddNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNavServlet() {
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
			
		
			String nav_name=request.getParameter("nav_name");
			String nav_weight_str=request.getParameter("nav_weight");
			
			if("".equals(nav_name) || nav_name == null||"".equals(nav_weight_str) || nav_weight_str== null)
			{
				response.sendRedirect("admin/addNavError.jsp");
			}else
			{
				String nav_id =  UUID.randomUUID().toString();
				int nav_weight = Integer.parseInt(nav_weight_str);
				System.out.println(nav_id);
				Nav n = new Nav();
				n.setNav_id(nav_id);
				n.setNav_name(nav_name);
				n.setNav_weight(nav_weight);
				
				SqlHelper sh = new SqlHelper();
				 if(sh.insertNav(n))
				 {
					 response.sendRedirect("admin/TypeUser.jsp");
				 }else
				 {
					 response.sendRedirect("admin/addNavError.jsp");
				 }
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
