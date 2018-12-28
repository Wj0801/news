package com.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.sqlHelper.SqlHelper;

/**
 * Servlet implementation class deleteUserServlet
 */
@WebServlet("/deleteUser")
public class deleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUserServlet() {
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
		String id=request.getParameter("id");
		
		//验证id		
			if("".equals(id)||id==null) {
				response.sendRedirect("admin/deleteError.jsp");  
			}else {
		//执行删除	
				SqlHelper sh=new SqlHelper();
				User u=new User();
				u.setId(id);
				if(sh.deleteUser(u)) {
                 response.sendRedirect("admin/showUser.jsp");
				}else {
				 response.sendRedirect("admin/deleteError.jsp");
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
