package com.salary.Statement;

public class Employee {
 String employeeName;
 String refNo;
 String designation;
 double payDays;
 double presentDays;
 double netAmount;
public double getNetAmount() {
	return netAmount;
}

public void setNetAmount(double netAmount) {
	this.netAmount = netAmount;
}





private Earnings earnings;
 private Deductions deductions;




public Deductions getDeductions() {
	return deductions;
}

public void setDeductions(Deductions deductions) {
	this.deductions = deductions;
}

public Earnings getEarnings() {
	return earnings;
}

public void setEarnings(Earnings earnings) {
	this.earnings = earnings;
}
public Employee(){
	
}
 
 public Employee( String employeeName,String refNo,String designation,double payDays,double presentDays,Earnings earnings,Deductions deductions,double netAmount) {
		this.employeeName=employeeName;
		this.refNo=refNo;
		this.designation=designation;
		this.payDays=payDays;
		this.presentDays=presentDays;
        this.earnings=earnings;
        this.deductions=deductions;
        this.netAmount=netAmount;
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
public void setPayDays(double d) {
	this.payDays = d;
}
public double getPresentDays() {
	return presentDays;
}
public void setPresentDays(double d) {
	this.presentDays = d;
}

 



public String toString() {
    return "Employee [employeeName=" + employeeName + ", refNo=" + refNo + ",  designation=" + designation + ", payDays=" + payDays + ", presentDays=" + presentDays + ",earnings="+earnings+",deductions="+deductions+",netAmount="+netAmount+"]";

}



}