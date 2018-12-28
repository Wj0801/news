package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.sqlHelper.SqlHelper;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//获取session
		HttpSession session = request.getSession();
		//获取用户的用户名和密码
		String id=request.getParameter("id");
		//String name=request.getParameter("name");
		String pwd=request.getParameter("password");
		String cfpwd=request.getParameter("cfpassword");
		//验证数据
		if("".equals(id)||id==null||"".equals(pwd)||pwd==null) {
			//错误: 返回到登陆页面
			response.sendRedirect("loginError.jsp");
		}else {
			//正确 ：进行查找
			SqlHelper sh= new SqlHelper();   				//new数据库增删改查对象
		    User u=new User(id,pwd,cfpwd);            		//new实体类对象将参数放进去
		   
			    if(sh.selsectUserByIDandPassword(id,pwd)!=null) {					//调用sqlhelper中selectUserName查询方法
			    	session.setAttribute("success", "登陆成功!");
			    	session.setAttribute("name", u.getName());
			    	session.setAttribute("id", u.getId());
			    	//登陆成功重定向主页面
			    	response.sendRedirect("admin/index.jsp");
			    }else {
		    		//登陆失败重定向登陆失败页面
		    		response.sendRedirect("loginError.jsp");
			    	  }
				    //关闭数据库连接
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
