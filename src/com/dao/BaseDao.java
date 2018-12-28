package com.dao;

import java.sql.Connection;
import java.sql.DriverManager; //数据库管理器
import java.sql.SQLException;



//jdbc连接数据库
public class BaseDao {
	      //加载驱动包
          private static String driver="com.mysql.jdbc.Driver";
          private static String url="jdbc:mysql://localhost:3306/testweb?characterEncoding=utf8";
	      private static String name="root";
	      private static String password="admin";
	      
	      //创建数据库对象
	      private static Connection conn;
	
	      public static Connection getConnnection() {

	    	  try {
					Class.forName(driver);   //根据传入的包名加载类
				conn=DriverManager.getConnection(url, name, password);//获取连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	    	  
	    	  
	    	  return conn;
	    	  
	      }
	      
	      
}
