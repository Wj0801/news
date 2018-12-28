package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDao {
       
	  private  Connection conn;   			//创建数据库对象
	  public UserDao() {
		  conn=BaseDao.getConnnection();   //调用连接数据库中的方法
	  }
	  
	  
	  public boolean zhuce(String name,String password) {
		  String sql="INSERT into `user`(name,password)value('?','?');"; //数据库增加注册的条目
		  Boolean psBoolean=false;
		  try {
			PreparedStatement ps = conn.prepareStatement(sql);     //调用PreparedStatement对象给sql语句中‘？’赋值
			ps.setString(1, name);
			ps.setString(2, password);   //赋值password
			psBoolean= ps.execute();      //创建Boolean类型接受    execute执行 后的结果
		} catch (SQLException e) {
			e.printStackTrace();
		}
				  
		  return psBoolean;
	  }
	
	
}
