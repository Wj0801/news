package com.entity;

import java.util.List;

//分页实体类
public class PageInfo {
		private Integer totalRecords;    //总记录数
		private Integer totalPages;		//总页数		
		private Integer pageSize;		//每页显示数
		private Integer currentPage;	//当前页数	
		private List<?> list;			//每页显示数据集合
		
		
		//构造函数
		public PageInfo() {
			this.currentPage=1;      //初始化当前页数
			this.pageSize	=  5;       //初始化每页显示数
		}
		
		//定义初始化对象的方法
		public PageInfo(int totalRecords,int currentPage,int pageSize,List<?> list) {
			this.totalRecords=totalRecords;
			//总记录 % 每页显示数 == 0 ？ 总记录 /每页显示数：总记录 /每页显示数 + 1  （）
			this.totalPages=(int)Math.ceil(totalRecords/(double)pageSize);
			this.currentPage=currentPage;
			this.pageSize=pageSize;			
			this.list=list;
		}
		
		
		
		
		
		
		public Integer getTotalRecords() {
			return totalRecords;
		}
		public void setTotalRecords(Integer totalRecords) {
			this.totalRecords = totalRecords;
		}
		public Integer getTotalPages() {
			return totalPages;
		}
		public void setTotalPages(Integer totalPages) {
			this.totalPages = totalPages;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		public Integer getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(Integer currentPage) {
			this.currentPage = currentPage;
		}
		public List<?> getList() {
			return list;
		}
		public void setList(List<?> list) {
			this.list = list;
		}
		
		//定义分类对象的方法
		
			/*
			 * 定义首页方法
			 */
			public int getFirstPage() {
				return 1;
			}
		
			/*
			 * 定义尾页方法
			 */
			public int getLastPage() {
				return totalPages;
			}

			/*
			 * 定义上一页方法
			 */
			public int getPerPage() {
				return currentPage - 1 < 1 ? 1 :currentPage - 1;					//如果当前页-1小于总页数就等于总页数，如果不小于总页数就-1
			}
			
			/*
			 * 定义下一页方法
			 */
			public int getNexPage() {
				return currentPage+1 > totalPages ? totalPages : currentPage + 1;  //如果当前页+1大于总页数就等于总页数，如果不大于总页数就+1
			}
			
}
