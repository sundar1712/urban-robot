package com.salary.Statement;

import java.util.ArrayList;

public class Company {
	private String companyName;
//	private String address;
	ArrayList<Employee> empDetails = new ArrayList<>();
	
	public ArrayList<Employee> getEmpDetails() {
		return empDetails;
	}
	public void setEmpDetails(ArrayList<Employee> empDetails) {
		this.empDetails = empDetails;
	}
	public Company() {
		
	}
//	public Company(Employee employee) {
////		this.companyName=companyName;
////		this.address=address;
//		this.employee = employee;
//	}
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

