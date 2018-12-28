package com.entity;

public class ArticleNav {
	
	private String article_id;
	private String article_name;
	private String article_time;
	private String article_author;
	private String nav_name;
	
	public String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getArticle_name() {
		return article_name;
	}
	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}
	public String getArticle_time() {
		return article_time;
	}
	public void setArticle_time(String article_time) {
		this.article_time = article_time;
	}
	public String getArticle_author() {
		return article_author;
	}
	public void setArticle_author(String article_author) {
		this.article_author = article_author;
	}
	
	public String getNav_name() {
		return nav_name;
	}
	public void setNav_name(String nav_name) {
		this.nav_name = nav_name;
	}
	public ArticleNav() {
		super();
	}
	public ArticleNav(String article_id, String article_name, String article_time, String article_author) {
		super();
		this.article_id = article_id;
		this.article_name = article_name;
		this.article_time = article_time;
		this.article_author = article_author;
		
	}
	
	

}
