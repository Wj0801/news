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
 * Servlet implementation class updateUserServlet
 */
@WebServlet("/updateUsers")
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUserServlet() {
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
		//获取修改后的信息
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pwd=request.getParameter("password");
		String cfpwd=request.getParameter("cfpassword");
		
		if("".equals(id) || id == null ||"".equals(name) || name == null||"".equals(pwd) || pwd == null
				||"".equals(cfpwd) || cfpwd == null ||  !pwd.equals(cfpwd))
		{
			
			response.sendRedirect("admin/updateError.jsp");
		}else
		{
			//执行修改
			SqlHelper sh = new SqlHelper();
			User u= new User(id,name,pwd);
			if(sh.updateUserNameAndPwd(u)) {
				response.sendRedirect("admin/showUser.jsp");
			}else
			{
				response.sendRedirect("admin/updateError.jsp");
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
