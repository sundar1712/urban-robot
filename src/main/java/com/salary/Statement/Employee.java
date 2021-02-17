package com.salary.Statement;

public class Employee {
 String employeeName;
String refNo;
 String pfNo;
 String designation;
 String branch;
 String payDays;
 String presentDays;
 public Employee() {
	 
 }
 
 public Employee( String employeeName,String refNo,String pfNo,String designation,String branch,String payDays,String presentDays) {
		this.employeeName=employeeName;
		this.refNo=refNo;
		this.pfNo=pfNo;
		this.designation=designation;
		this.branch=branch;
		this.payDays=payDays;
		this.presentDays=presentDays;
 }
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getRefNo() {
	return refNo;
}
public void setRefNo(String refNo) {
	this.refNo = refNo;
}
public String getPfNo() {
	return pfNo;
}
public void setPfNo( String pfNo) {
	this.pfNo = pfNo;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getPayDays() {
	return payDays;
}
public void setPayDays(String payDays) {
	this.payDays = payDays;
}
public String getPresentDays() {
	return presentDays;
}
public void setPresentDays(String presentDays) {
	this.presentDays = presentDays;
}

 



public String toString() {
    return "Employee [employeeName=" + employeeName + ", refNo=" + refNo + ", pfNo=" + pfNo + ", designation=" + designation + ",branch=" + branch + ""
    		+ ", payDays=" + payDays + ", presentDays=" + presentDays + "]";

}
}