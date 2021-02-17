package com.salary.Statement;

public class SalaryBreakUp {
	float earnings;
	float basic;
	float hra;
	float otherAllowance;
	float medicalAllowance;
	float conveyance;
	float deduction;
	float pf;
	float esi;
	float tds;
	float loan;
	float pt;
	float spclDeduction;
	public SalaryBreakUp() {
		
	}
	public SalaryBreakUp(float earnings,float basic,float hra,float otherAllowance,float medicalAllowance,float conveyance,
			float deduction,float pf,float esi,float tds,float loan,float pt,float spclDeduction) {
		this.earnings=earnings;
		this.basic=basic;
		this.hra=hra;
		this.otherAllowance=otherAllowance;
		this.medicalAllowance=medicalAllowance;
		this.conveyance=conveyance;
		this.deduction=deduction;
		this.pf=pf;
		this.esi=esi;
		this.tds=tds;
		this.loan=loan;
		this.pt=pt;
		this.spclDeduction=spclDeduction;
		
	}
	public float getEarnings() {
		return earnings;
	}
	public void setEarnings(float earnings) {
		this.earnings = earnings;
	}
	public float getBasic() {
		return basic;
	}
	public void setBasic(float basic) {
		this.basic = basic;
	}
	public float getHra() {
		return hra;
	}
	public void setHra(float hra) {
		this.hra = hra;
	}
	public float getOtherAllowance() {
		return otherAllowance;
	}
	public void setOtherAllowance(float otherAllowance) {
		this.otherAllowance = otherAllowance;
	}
	public float getMedicalAllowance() {
		return medicalAllowance;
	}
	public void setMedicalAllowance(float medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}
	public float getConveyance() {
		return conveyance;
	}
	public void setConveyance(float conveyance) {
		this.conveyance = conveyance;
	}
	public float getDeduction() {
		return deduction;
	}
	public void setDeduction(float deduction) {
		this.deduction = deduction;
	}
	public float getPf() {
		return pf;
	}
	public void setPf(float pf) {
		this.pf = pf;
	}
	public float getEsi() {
		return esi;
	}
	public void setEsi(float esi) {
		this.esi = esi;
	}
	public float getTds() {
		return tds;
	}
	public void setTds(float tds) {
		this.tds = tds;
	}
	public float getLoan() {
		return loan;
	}
	public void setLoan(float loan) {
		this.loan = loan;
	}
	public float getPt() {
		return pt;
	}
	public void setPt(float pt) {
		this.pt = pt;
	}
	public float getSpclDeduction() {
		return spclDeduction;
	}
	public void setSpclDeduction(float spclDeduction) {
		this.spclDeduction = spclDeduction;
	}
	public String toString() {
	    return "SalaryBreakUp[earnings=" + earnings + ", basic=" +basic + ",hra=" +hra + ",otherAllowance=" +otherAllowance + ", medicalAllowance=" +medicalAllowance + ""
	    		+ ", conveyance=" +conveyance + ", deduction=" +deduction + ", pf=" +pf + ",esi=" +esi + ", tds=" +tds + ",loan=" +loan + ","
	    				+ " pt=" +pt + ",spclDeduction=" +spclDeduction+"]";
	}

}
