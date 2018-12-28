package com.entity;

public class Article {
	
	private String article_id;
	private String article_name;	//标题
	private String article_time;
	private String article_author;	//作者
	private String article_content;
	private String nav_id;
	
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
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public String getNav_id() {
		return nav_id;
	}
	public void setNav_id(String nav_id) {
		this.nav_id = nav_id;
	}
	
	public Article() {
		super();
	}
	public Article(String article_id, String article_name, String article_time, String article_author,
			String article_content, String nav_id) {
		super();
		this.article_id = article_id;
		this.article_name = article_name;
		this.article_time = article_time;
		this.article_author = article_author;
		this.article_content = article_content;
		this.nav_id = nav_id;
	}

	
	
}
