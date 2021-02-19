package com.salary.Statement;

public class Employee {
 String employeeName;
String refNo;
 String designation;
 double payDays;
 double presentDays;
 public Employee() {
	 
 }
 
 public Employee( String employeeName,String refNo,String pfNo,String designation,String branch,double payDays,double presentDays) {
		this.employeeName=employeeName;
		this.refNo=refNo;
		
		this.designation=designation;
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


public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}

public double getPayDays() {
	return payDays;
}
public void setPayDays(double numericalCellValue) {
	this.payDays = numericalCellValue;
}
public double getPresentDays() {
	return presentDays;
}
public void setPresentDays(double numericalCellValue) {
	this.presentDays = numericalCellValue;
}

 



public String toString() {
    return "Employee [employeeName=" + employeeName + ", refNo=" + refNo + ",  designation=" + designation + ", payDays=" + payDays + ", presentDays=" + presentDays + "]";

}



}