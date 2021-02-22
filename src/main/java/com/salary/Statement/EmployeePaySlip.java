package com.salary.Statement;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs;

public class EmployeePaySlip {
//	ArrayList<Company>list1 = new ArrayList<>();
	ArrayList<Employee> list = new ArrayList<>();
//	
	
	LinkedHashMap<String,String> storeExcelValue = new LinkedHashMap<String, String>();

	String path;

	public void ReadExcelFile(String path) {
		this.path = path;
	

		try {
			FileInputStream file = new FileInputStream(new File(path));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			
//			Company company = new Company();
//			List<String> obj = new ArrayList<String>();

			System.out.println("");

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			
	        DataFormatter dataFormatter = new DataFormatter();
	        Company company = null;
	        Employee employee=null;
	        Earnings earnings=null;
	        Deductions deductions=null;
			for (Row row: sheet) {
//				skip the row
				 if ( row.getRowNum() == 0 || row.getRowNum() == 1 || row.getRowNum()==2||
			                row.getRowNum() == 3 || 
			                row.getRowNum() == 4 || row.getRowNum() == 5 || 
			                row.getRowNum() == 6 || row.getRowNum() == 7 || 
			                row.getRowNum() == 9 || row.getRowNum() == 10 || 
			                row.getRowNum() == 11 || row.getRowNum() == 12 ||
			                row.getRowNum() ==  8 || row.getRowNum()==121||row.getRowNum()==124|| row.getRowNum()==125||row.getRowNum()==126 || 
			                row.getRowNum()==127||row.getRowNum()==128|| row.getRowNum()==129||row.getRowNum()==130|| row.getRowNum()==131||row.getRowNum()==152||
			                row.getRowNum()==154||row.getRowNum()==163||row.getRowNum()==165||row.getRowNum()==166||row.getRowNum()==167||row.getRowNum()==168||row.getRowNum()==169) {
			            continue;
			        }
				 
	            for(Cell cell: row) {
	                String cellValue = dataFormatter.formatCellValue(cell);
//                 System.out.print(cell.getRowIndex()+"\t"+cellValue+"\n");
                    int rowID = cell.getRowIndex();
                    int columnID =cell.getColumnIndex();
                    if(columnID == 0 && !cellValue.isEmpty()) {
                    	System.out.println(columnID+"test");
//                    	if(company != null ) {
//                    	 list1.add(company);
//						}
                    	 if(employee !=null) {
							list.add(employee);
						}
//                    	
                    	employee=new Employee();
                    	earnings=new Earnings();
                    	deductions=new Deductions();
//                    	company= new Company();

                    	
                    	
                    }
//                    String a = String.valueOf(rowID) + String.valueOf(columnID);
//                    System.out.println(a); 
                    switch (cell.getColumnIndex()) {
//					
                   
					case 0:
//						System.out.println(cell.getStringCellValue());
					 
						if(!cellValue.isEmpty()) {
//							if(company.getCompanyName() == null) {
//							company.setCompanyName(cell.getStringCellValue());
//							
//						     }
							
							 if( employee.getRefNo()==null){
								
								employee.setRefNo(cell.getStringCellValue());;
						     }
						}
						break;
					case 1:
//						System.out.println(cell.getStringCellValue());
						if(!cellValue.isEmpty()) {
							if(employee.getEmployeeName() == null) {
								employee.setEmployeeName(cell.getStringCellValue());
							}else {
								employee.setDesignation(cell.getStringCellValue());
							}
						}
						break;
					case 2:
						if(!cellValue.isEmpty()) {
////							System.out.println("inside case 2 :" + cell.getNumericCellValue());
							if(employee.getPayDays() == 0) {
							employee.setPayDays(cell.getNumericCellValue());
							}else if(employee.getPresentDays() == 0) {
								employee.setPresentDays(cell.getNumericCellValue());
							}
						}
						break;
					case 3:
						if(!cellValue.isEmpty()) {
							if(earnings.getBasic() == 0) {
								earnings.setBasic(cell.getNumericCellValue());
							}else if(earnings.getOtherAllowance()==0){
							
								earnings.setOtherAllowance(cell.getNumericCellValue());
							}else if(earnings.getSpclAllowance()==0){
								earnings.setSpclAllowance(cell.getNumericCellValue());
							}
						}
						break;
						case 4:
//							System.out.println(cell.getStringCellValue());
							if(!cellValue.isEmpty()) {
								if(earnings.getHra() == 0) {
									earnings.setHra(cell.getNumericCellValue());
								}else  {
									earnings.setMedicalAllowance(cell.getNumericCellValue());
								}
									
								
							}
							break;
						case 5:
							if(!cellValue.isEmpty()) {
////								System.out.println("inside case 2 :" + cell.getNumericCellValue());
								if(earnings.getConveyance() == 0) {
								earnings.setConveyance(cell.getNumericCellValue());
								}
							}
							break;
						case 6:
							if(!cellValue.isEmpty()) {
////							System.out.println("inside case 2 :" + cell.getNumericCellValue());
							if(earnings.getTotalEarnings() == 0) {
							earnings.setTotalEarnings(cell.getNumericCellValue());
							}
						}
							break;
						case 7:
							if(!cellValue.isEmpty()) {
								if(deductions.getPf() == 0) {
									deductions.setPf(cell.getNumericCellValue());
								}else {
								
									deductions.setTds(cell.getNumericCellValue());
								}
							}
							break;
							case 8:
//								System.out.println(cell.getStringCellValue());
								if(!cellValue.isEmpty()) {
									if(deductions.getEsi() == 0) {
										deductions.setEsi(cell.getNumericCellValue());
									}else  {
										deductions.setLoan(cell.getNumericCellValue());
									}
										
									
								}
								break;
							case 9:
								if(!cellValue.isEmpty()) {
////									System.out.println("inside case 2 :" + cell.getNumericCellValue());
									if(deductions.getPt() == 0) {
									deductions.setPt(cell.getNumericCellValue());
									}else {
										deductions.setSpclDeduction(cell.getNumericCellValue());
									}
								}
								break;
							case 10:
								if(!cellValue.isEmpty()) {
////								System.out.println("inside case 2 :" + cell.getNumericCellValue());
								if(deductions.getTotalDeductions() == 0) {
								deductions.setTotalDeductions(cell.getNumericCellValue());
								}
							}
			
							break;
	//	
					default:
						break;
					}
                    employee.setEarnings(earnings);
                	employee.setDeductions(deductions);
                  

	            }

	            System.out.println("company " + employee.toString());
                   
//	                storeExcelValue.put(a,cellValue);
	            
	        }

				

//			 System.out.println("company " + employee.toString());
				}
		

		catch (Exception e) {
			e.printStackTrace();
		}
		for(String i :storeExcelValue.keySet()) {
		      System.out.println("key: " + i + " value: " + storeExcelValue.get(i));
		}

		
	}


}