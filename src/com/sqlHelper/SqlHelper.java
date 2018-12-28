package com.sqlHelper;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.dao.BaseDao;
import com.entity.Article;
import com.entity.ArticleNav;
import com.entity.Nav;
import com.entity.User;
import java.sql.*;





public class SqlHelper {

    //创建数据库对象
    private static Connection conn;
    //默认行数内容为3
    private int pageNum = 5;
	private Nav n;
    
    
    public SqlHelper() {
		  conn=BaseDao.getConnnection();   //调用连接数据库中的方法
	  }
    
	
	/*插入新的用户*/
 public boolean insertUser(User u) {
	 String sql="INSERT into `user` (id,name,password)values(?,?,?);";
	 boolean flag =false;
	 try {
		PreparedStatement ps = conn.prepareStatement(sql);     //调用PreparedStatement对象给sql语句中‘？’赋值
		ps.setString(1, u.getId());
		ps.setString(2, u.getName());
		ps.setString(3, u.getPassword());
		ps.execute();
		flag = true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return flag;
 }
 
 /*以id删除用户*/
  public boolean deleteUser(User u) {
	  String sql="DELETE FROM `user` where id=?;";
	  boolean flag =false;
	  
	    try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getId());
			ps.executeUpdate();
			flag =true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  return flag ;
  }
 
     /*以id修改姓名*/
    public boolean updateUserName(User u) {
    	String sql="UPDATE `user` set name=? where id=?;";
    	boolean flag =false;
    	
    	try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getId());
			ps.executeUpdate();
			flag =true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return flag ;
    }
    /*以id修改密码*/
    public boolean updateManagerPwd(User u) {
		String sql="update `user` set password = ? where id=?";
		boolean flag=false;
		try {
			PreparedStatement pStatement=conn.prepareStatement(sql);
			pStatement.setString(1, u.getPassword());
			pStatement.setString(2, u.getId());
			pStatement.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	//修改用户名和密码
	public boolean updateUserNameAndPwd(User u) {
		String sql="update `user` set name = ?,password= ? where id=?";
		boolean flag=false;
		try {
			PreparedStatement pStatement=conn.prepareStatement(sql);
			pStatement.setString(1, u.getName());
			pStatement.setString(2, u.getPassword());
			pStatement.setString(3, u.getId());
			pStatement.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	//查询用户信息  查询所有   分页
	//1.查询单个用户信息
	public User selectUserID(String id) {
        String sql="SELECT * FROM `user` where id=?";   
		User u=null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);	//调用PreparedStatement对象给sql语句中‘？’赋值
			ps.setString(1, id);								//赋值id
			ResultSet rs=ps.executeQuery();						//创建结果集rs接收   executeQuery执行 后的结果
			if(rs.next()) {											//next下行内容 默认为0
				u = new User(rs.getString(1),rs.getString(2),rs.getString(3));			//new一个对象获取到id，name，password
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	//2.查询全部信息
	public List<User> selectUserIDs(){
		String sql="select * from `user`";
		User u=null;
	    List<User> list=new ArrayList<>();   //创建数组
		
	    try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u=new User(rs.getString("id"),rs.getString("name"),rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//3.登陆账号密码验证
	public boolean loginUseridAndPwd(User u) {
		//1.u.id   获取 user对象 
		User user=this.selectUserID(u.getId());
		
		//u.name 服务器获取的 user.name
	   if(user == null) {
		   System.out.println("未找到该用户");
	   }else if(u.getPassword().equals(user.getPassword())) {
		   System.out.println("登陆成功");
	   }else {
		   System.out.println("密码不一样，登陆失败");
	   }
		
		return false;
	}
	//4.查询单个用户信息比较密码是否正确
	public User selsectUserByIDandPassword(String id,String password) {
        String sql="SELECT * FROM `user` where id=? and password=?";   
		User u=null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);	//调用PreparedStatement对象给sql语句中‘？’赋值
			ps.setString(1, id);								//赋值id
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();						//创建结果集rs接收   executeQuery执行 后的结果
			if(rs.next()) {											//next下行内容 默认为0
				u = new User(rs.getString(1),rs.getString(2),rs.getString(3));			//new一个对象获取到id，name，password
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
/**************************************Nav新闻类别********************************************/
	
	/*插入新的用户*/
 public boolean insertNav(Nav n) {
	 String sql="INSERT into `nav` (nav_id,nav_name,nav_weight)values(?,?,?);";
	 boolean flag =false;
	 try {
		 
		 //先判断用户id是否存在
		 SqlHelper sh=new SqlHelper();
		 Nav nn=sh.queryNav(n);
		 if(nn!=null) {
			 System.out.println("类别已存在"+n.getNav_id());
			 return false;
		 }
		 
		PreparedStatement ps = conn.prepareStatement(sql);     //调用PreparedStatement对象给sql语句中‘？’赋值
		ps.setString(1, n.getNav_id());
		ps.setString(2, n.getNav_name());
		ps.setInt(3, n.getNav_weight());
		ps.execute();
		flag = true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return flag;
 }
 
 	/*以id删除指定类别*/
 public boolean deleteNav(Nav n) {
	  String sql="DELETE FROM `nav` where nav_id=?;";
	  boolean flag =false;
	  
	    try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, n.getNav_id());
			ps.executeUpdate();
			flag =true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  return flag ;
 }
	
	/*以id修改类表名称*/
 public boolean updateNavName(Nav n) {
	 String sql="UPDATE `nav` SET nav_name=? where nav_id=?";
	 boolean flag =false;
	 
	 try {
	    PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, n.getNav_id());
		ps.setString(2, n.getNav_name());
		 ps.executeUpdate();
		 flag=true;
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 return flag;
 }
	
 /*以id修改类表的权重 nav_weight*/
 public boolean updateNavWeight(Nav n) {
		String sql="update `nav` set nav_weight = ? where nav_id=?";
		boolean flag=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, n.getNav_weight());
			ps.setString(2, n.getNav_id());
			ps.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
 /*以id修改类表名称nav_name和权重 nav_weight*/
	public boolean updateNavNameAndWeight(Nav n) {
		String sql="update `nav` set nav_name = ?,nav_weight= ? where nav_id=?";
		boolean flag=false;
		try {
			PreparedStatement pStatement=conn.prepareStatement(sql);
			pStatement.setString(1, n.getNav_name());
			pStatement.setInt(2, n.getNav_weight());
			pStatement.setString(3,n.getNav_id());
			pStatement.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	//1.查询单个id信息
	public Nav queryNav(Nav n) {
     String sql="SELECT * FROM `nav` where nav_id=?";   
		Nav nn=null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);	//调用PreparedStatement对象给sql语句中‘？’赋值
			ps.setString(1, n.getNav_id());								//赋值id
			ResultSet rs=ps.executeQuery();						//创建结果集rs接收   executeQuery执行 后的结果
			if(rs.next()) {											//next下行内容 默认为0
				nn=new Nav();
				nn.setNav_id(rs.getString("nav_id"));
				nn.setNav_name(rs.getString("nav_name"));
				nn.setNav_weight(rs.getInt("nav_weight"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nn;
	}
	//2.查询全部信息
	public List<Nav> queryNavAll(){
		String sql="select * from `nav`";
		Nav n=null;
	    List<Nav> li=new ArrayList<>();   //创建数组
		
	    try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				n=new Nav();
				n.setNav_id(rs.getString("nav_id"));
				n.setNav_name(rs.getString("nav_name"));
				n.setNav_weight(rs.getInt("nav_weight"));
				li.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
	
	/**************************************所有新闻管理********************************************/
	
	/**  插入新的新闻*/
	public boolean insertArticle(Article a)
	{
		String sql = "insert into article(article_id,article_name,article_time,article_author,article_content,nav_id) values(?,?,?,?,?,?)";
		boolean flag = false;
		
		try {
			
			//先判断  用户id是否已存在
			SqlHelper sh = new SqlHelper();
			Article nn=sh.queryArticle(a);
				if(nn != null)
				{
					return false;
				}
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getArticle_id());
			ps.setString(2,a.getArticle_name());				
			ps.setString(3, a.getArticle_time());			
			ps.setString(4, a.getArticle_author());
			ps.setString(5, a.getArticle_content());
			ps.setString(6, a.getNav_id());
			
			ps.execute();
			flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;	
		
	}
	
	/**删除指定类别*/
	public boolean deleteArticle(Article a)
	{
		String sql = "delete from article where article_id = ?";
		boolean flag =false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getArticle_id());
			ps.executeUpdate();
			flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	

	/**修改文章名称*/
	public boolean updateArticle(Article a)
	{
		String sql = "update article set article_name = ?,article_time=?,article_author=?,article_content=?,nav_id=? where article_id = ?";
		boolean flag = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getArticle_name());
			ps.setString(2, a.getArticle_time());
			ps.setString(3, a.getArticle_author());	
			ps.setString(4, a.getArticle_content());	
			ps.setString(5, a.getNav_id());	
			ps.setString(6, a.getArticle_id());	
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	/**查询单个类别*/
	public Article  queryArticle(Article a)
	{
		String sql = "select * from article where  article_id = ?";
		Article aa = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getArticle_id());	
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				aa = new Article();
				aa.setArticle_id(rs.getString("article_id"));
				aa.setArticle_name(rs.getString("article_name"));
				aa.setArticle_content(rs.getString("article_content"));
				aa.setArticle_time(rs.getString("article_time"));
				aa.setArticle_author(rs.getString("article_author"));
				aa.setNav_id(rs.getString("nav_id"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("------"+mm);
		return aa;
	}
	
	
	/** 查询所有类别*/
	public List<Article> queryArticle()
	{
		String sql = "select * from  article";
		Article aa = null;
		List<Article> li = new ArrayList<Article>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				aa = new Article();
				aa.setArticle_id(rs.getString("article_id"));
				aa.setArticle_name(rs.getString("article_name"));
				aa.setArticle_content(rs.getString("article_content"));
				aa.setArticle_time(rs.getString("article_time"));
				aa.setArticle_author(rs.getString("article_author"));
				aa.setNav_id(rs.getString("nav_id"));
				
				li.add(aa);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return li;
	}
	
	/*查询所有类别加个nav_name*/
	public List<ArticleNav> queryArticleNav()
	{
		String sql = "select article_id,article_name,article_author,article_time,nav_name from article,nav where article.nav_id = nav.nav_id";
		ArticleNav aa = null;
		List<ArticleNav> li = new ArrayList<ArticleNav>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				aa = new ArticleNav();	
				
				aa.setArticle_name(rs.getString("article_name"));	
				aa.setArticle_id(rs.getString("article_id"));	
				aa.setArticle_time(rs.getString("article_time"));
				aa.setArticle_author(rs.getString("article_author"));
				aa.setNav_name(rs.getString("nav_name"));
				
				li.add(aa);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return li;
	}

	
     //关闭数据库连接
	public void closeConn() {
          try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*模糊查询*/
	public List<ArticleNav> queryLikeArticle(String a) {
		String sql = "select *" + 
				"from(" + 
				"select article_id,article_name,article_author,article_time,nav_name " + 
				"from article,nav where article.nav_id = nav.nav_id " + 
				")as a " + 
				"where article_name like '%"+a+"%' or article_author like '%"+a+"%'";
		ArticleNav aa = null;
		//System.out.println(sql);
		List<ArticleNav> li = new ArrayList<ArticleNav>();
		try {
			Statement statement = conn.createStatement();
		//	ps.setString(1, a);
		//	ps.setString(2, a);
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				aa = new ArticleNav();	
				
				aa.setArticle_name(rs.getString("article_name"));	
				aa.setArticle_id(rs.getString("article_id"));	
				aa.setArticle_time(rs.getString("article_time"));
				aa.setArticle_author(rs.getString("article_author"));
				aa.setNav_name(rs.getString("nav_name"));
				
				li.add(aa);
			}
			//System.out.println(li);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//有几个？号ps。几个值
		
		//resulrt结果集接受
		
		//while判断  new需要用的对象，将值赋值给前面的
		
		//写个数组，然后调用add方法将所有的结果返还出去
		return li;
	}
	
	
}
