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
 * Servlet implementation class AddManagerServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//设置编码
		 request.setCharacterEncoding("utf-8");
		//获取信息
		String id =request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String cfpassword=request.getParameter("cfpassword");
		
		//服务器端验证
		if("".equals(id)||id==null||"".equals(name) || name == null||"".equals(password) || password == null||"".equals(cfpassword) || cfpassword == null ||  !password.equals(cfpassword)) {
			//用户信息不正确
			response.sendRedirect("addError.jsp"); //跳转到错误jsp页面
		}
		else {
			//用户信息正确
			SqlHelper sh= new SqlHelper();   //new数据库增删改查对象
		    User u=new User(id,name,password);            //new实体类对象将参数放进去
		    
			    if(sh.insertUser(u)) {					//调用sqlhelper中inster插入方法
			    		//重定向login登陆页面
			    	response.sendRedirect("login.jsp");
			    }else {
			    		//去用户信息错误页面
			    	response.sendRedirect("addIdError.jsp");
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
