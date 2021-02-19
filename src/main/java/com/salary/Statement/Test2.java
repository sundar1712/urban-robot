package com.salary.Statement;



import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test2 {
	ArrayList<Company> list1 = new ArrayList<>();
	ArrayList<Employee> list = new ArrayList<>();
	ArrayList<Earnings> list2 = new ArrayList<>();
	LinkedHashMap<String,String> storeExcelValue = new LinkedHashMap<String, String>();

	String path;

	public void ReadExcelDemo(String path) {
		this.path = path;

		try {
			FileInputStream file = new FileInputStream(new File(path));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
//			Company company = new Company();
			List<String> obj = new ArrayList<String>();

			System.out.println("");

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			
	        DataFormatter dataFormatter = new DataFormatter();
	     Earnings earnings = null;
			for (Row row: sheet) {
//				skip the row
				 if (row.getRowNum() == 0 || row.getRowNum() == 1 || 
			                row.getRowNum() == 2 || row.getRowNum() == 3 || 
			                row.getRowNum() == 4 || row.getRowNum() == 5 || 
			                row.getRowNum() == 6 || row.getRowNum() == 7 || 
			                row.getRowNum() == 9 || row.getRowNum() == 10 || 
			                row.getRowNum() == 11 || row.getRowNum() == 12 ||
			                row.getRowNum() ==  8 || row.getRowNum()==121||row.getRowNum()==124) {
			            continue;
			        }
				 
	            for(Cell cell: row) {
	                String cellValue = dataFormatter.formatCellValue(cell);
//                 System.out.print(cell.getRowIndex()+"\t"+cellValue+"\n");
                    int rowID = cell.getRowIndex();
                    int columnID =cell.getColumnIndex();
                    if(columnID == 0 && !cellValue.isEmpty()) {
                    	System.out.println(columnID);
                    	if(earnings != null ) {
                    		list2.add(earnings);
						}
                    	earnings= new Earnings();
                    	
                    }
//                    String a = String.valueOf(rowID) + String.valueOf(columnID);
//                    System.out.println(a); 
                    switch (cell.getColumnIndex()) {
//					
                   
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
//						System.out.println(cell.getStringCellValue());
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
////							System.out.println("inside case 2 :" + cell.getNumericCellValue());
							if(earnings.getConveyance() == 0) {
							earnings.setConveyance(cell.getNumericCellValue());
							}
						}
						break;
					case 6:
						if(!cellValue.isEmpty()) {
////						System.out.println("inside case 2 :" + cell.getNumericCellValue());
						if(earnings.getTotalEarnings() == 0) {
						earnings.setTotalEarnings(cell.getNumericCellValue());
						}
					}
						break;
//					case 3:
////						System.out.println(cell.getNumericCellValue());
//						break;
//	
					default:
						break;
					}
                    
				}
				System.out.println("earnings " + earnings.toString());
                    
//	                storeExcelValue.put(a,cellValue);
	            
	        }
			
			for(Earnings earn : list2) {
				System.out.println(earn.getBasic());
				System.out.println(earn.getOtherAllowance());
				System.out.println(earn.getSpclAllowance());
				System.out.println(earn.getHra());
				System.out.println(earn.getMedicalAllowance());
				System.out.println(earn.getConveyance());
				System.out.println(earn.getTotalEarnings());
			}
				}

		catch (Exception e) {
			e.printStackTrace();
		}
		for(String i :storeExcelValue.keySet()) {
		      System.out.println("key: " + i + " value: " + storeExcelValue.get(i));
		}
	}


}

