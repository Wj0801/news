package com.entity;
			//文章类别
public class Nav {
    private String nav_id;
    private String nav_name;   //类别 
    private int nav_weight;
    
    public Nav() {
		
	}
    public Nav(String nav_id,String nav_name,int nav_weight) {
    	super();
    	this.nav_id=nav_id;
    	this.nav_name=nav_name;
    	this.nav_weight=nav_weight;
    }
    
	public String getNav_id() {
		return nav_id;
	}
	public void setNav_id(String nav_id) {
		this.nav_id = nav_id;
	}
	public String getNav_name() {
		return nav_name;
	}
	public void setNav_name(String nav_name) {
		this.nav_name = nav_name;
	}
	public int getNav_weight() {
		return nav_weight;
	}
	public void setNav_weight(int nav_weight) {
		this.nav_weight = nav_weight;
	}
	@Override
	public String toString() {
		return "Nav [nav_id=" + nav_id + ", nav_name=" + nav_name + ", nav_weight=" + nav_weight + "]";
	}
    
}
