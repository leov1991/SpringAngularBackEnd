package com.demo.util;

import java.util.List;

public class QueryResults {
	
	private int totalRecords; //Campo útil para limitar la cantidad de resultados de la query y paginar
	private List<Object> list;
	
	
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	
	

}
