package ma.esoftech.esoftrade.controller;

import java.util.List;
import java.util.Map;

public class RequestTable {

	private String name;
	private String age;
	public String getName() {
		return name;
	}
	 private List<Map<ColumnCriterias, String>> columns;	
	public RequestTable(){
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	  public enum SearchCriterias {
	        value,
	        regex
	    }
	    public enum OrderCriterias {
	        column,
	        dir
	    }
	    public enum ColumnCriterias {
	        data,
	        name,
	        searchable,
	        orderable,
	        searchValue,
	        searchRegex
	    }

	
	
}
