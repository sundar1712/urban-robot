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

public class Test {
//	ArrayList<Company> list1 = new ArrayList<>();
	ArrayList<Employee> list = new ArrayList<>();
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
	        Employee employee = null;
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
                    	if(employee != null ) {
                    		list.add(employee);
						}
                    	employee= new Employee();
                    	
                    }
//                    String a = String.valueOf(rowID) + String.valueOf(columnID);
//                    System.out.println(a); 
                    switch (cell.getColumnIndex()) {
//					
                   
					case 0:
//						System.out.println(cell.getStringCellValue());
						if(!cellValue.isEmpty()) {
							employee.setRefNo(cell.getStringCellValue());
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
//					case 3:
////						System.out.println(cell.getNumericCellValue());
//						break;
//	
					default:
						break;
					}
                    
				}
				System.out.println("company " + employee.toString());
                    
//	                storeExcelValue.put(a,cellValue);
	            
	        }
			
			for(Employee emp : list) {
				System.out.println(emp.getRefNo());
				System.out.println(emp.getEmployeeName());
				System.out.println(emp.getDesignation());
				System.out.println(emp.getPayDays());
				System.out.println(emp.getPresentDays());
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