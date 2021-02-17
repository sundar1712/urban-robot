package com.salary.Statement;

public class Company {
	private String companyName;
//	private String address;
	
	public Company() {
		
	}
	public   Company( String companyName) {
		this.companyName=companyName;
//		this.address=address;
		
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//

	 public String toString() {
		    return "Company [companyName=" + companyName + "]";
		  }
	}

