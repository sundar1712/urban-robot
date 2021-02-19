package com.salary.Statement;

public class Deductions {
	double pf;
	double tds;
	double esi;
	double loan;
	double pt;
	double spclDeduction;
	double totalDeductions;
	public Deductions(){
		}
	public Deductions(double pf,double tds,double esi,double loan,double pt,double spclDeduction,double totalDeductions)
	{
		this.pf=pf;
		this.tds=tds;
		this.esi=esi;
		this.loan=loan;
		this.pt=pt;
		this.spclDeduction=spclDeduction;
		this.totalDeductions=totalDeductions;
		
	}
	
	public double getTotalDeductions() {
		return totalDeductions;
	}
	public void setTotalDeductions(double totalDeductions) {
		this.totalDeductions = totalDeductions;
	}
	public double getPf() {
		return pf;
	}
	public void setPf(double pf) {
		this.pf = pf;
	}
	public double getTds() {
		return tds;
	}
	public void setTds(double tds) {
		this.tds = tds;
	}
	public double getEsi() {
		return esi;
	}
	public void setEsi(double esi) {
		this.esi = esi;
	}
	public double getLoan() {
		return loan;
	}
	public void setLoan(double loan) {
		this.loan = loan;
	}
	public double getPt() {
		return pt;
	}
	public void setPt(double pt) {
		this.pt = pt;
	}
	public double getSpclDeduction() {
		return spclDeduction;
	}
	public void setSpclDeduction(double spclDeduction) {
		this.spclDeduction = spclDeduction;
	}

	public String toString() {
	    return "Deductions[ pf=" +pf + ",tds=" +tds + ",esi=" +esi+", loan=" +loan + ",pt=" +pt + ""
	    		+ ", spclDeduction=" +spclDeduction + ",totalDeductions="+totalDeductions+"]";
	}
}
