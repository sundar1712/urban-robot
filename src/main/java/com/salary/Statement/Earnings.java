package com.salary.Statement;

public class Earnings {
	
	double basic;
	double hra;
	double otherAllowance;
	double medicalAllowance;
	double conveyance;
	double spclAllowance;
	double totalEarnings;
	
	public Earnings() {
		
	}
	public Earnings(double totalEarnings,double basic,double hra,double otherAllowance,double medicalAllowance,double conveyance,double spclAllowance) 
	{
		
		this.basic=basic;
		this.hra=hra;
		this.otherAllowance=otherAllowance;
		this.medicalAllowance=medicalAllowance;
		this.conveyance=conveyance;
		this.spclAllowance=spclAllowance;
		this.totalEarnings=totalEarnings;
		
		
	}

	
	
	public double getTotalEarnings() {
		return totalEarnings;
	}
	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
	public double getSpclAllowance() {
		return spclAllowance;
	}
	public void setSpclAllowance(double spclAllowance) {
		this.spclAllowance = spclAllowance;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double d) {
		this.basic = d;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double d) {
		this.hra = d;
	}
	public double getOtherAllowance() {
		return otherAllowance;
	}
	public void setOtherAllowance(double d) {
		this.otherAllowance = d;
	}
	public double getMedicalAllowance() {
		return medicalAllowance;
	}
	public void setMedicalAllowance(double d) {
		this.medicalAllowance = d;
	}
	public double getConveyance() {
		return conveyance;
	}
	public void setConveyance(double d) {
		this.conveyance = d;
	}
	public String toString() {
	    return "Earnings[ basic=" +basic + ",otherAllowance=" +otherAllowance + ",spclAllowance=" +spclAllowance+", hra=" +hra + ",medicalAllowance=" +medicalAllowance + ""
	    		+ ", conveyance=" +conveyance + ",totalEarnings="+totalEarnings+"]";
	}

}
