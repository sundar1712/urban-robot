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
	        Employee company = null;
			for (Row row: sheet) {
				 if (row.getRowNum() == 0 || row.getRowNum() == 1 || 
			                row.getRowNum() == 2 || row.getRowNum() == 3 || 
			                row.getRowNum() == 4 || row.getRowNum() == 5 || 
			                row.getRowNum() == 6 || row.getRowNum() == 7 || 
			                row.getRowNum() == 9 || row.getRowNum() == 10 || 
			                row.getRowNum() == 11 || row.getRowNum() == 12 ||
			                row.getRowNum() ==  8) {
			            continue;
			        }
				 
	            for(Cell cell: row) {
	                String cellValue = dataFormatter.formatCellValue(cell);
//                 System.out.print(cell.getRowIndex()+"\t"+cellValue+"\n");
                    int rowID = cell.getRowIndex();
                    int columnID =cell.getColumnIndex();
                    if(columnID == 0 && !cellValue.isEmpty()) {
                    	System.out.println(columnID);
                    	if(company != null ) {
                    		list.add(company);
						}
                    	company = new Employee();
                    }
//                    String a = String.valueOf(rowID) + String.valueOf(columnID);
//                    System.out.println(a); 
                    switch (cell.getColumnIndex()) {
//					
					case 0:
//						System.out.println(cell.getStringCellValue());
						if(!cellValue.isEmpty()) {
							company.setRefNo(cell.getStringCellValue());
						}
						break;
					case 1:
//						System.out.println(cell.getStringCellValue());
						if(!cellValue.isEmpty()) {
							if(company.getEmployeeName() == null) {
								company.setEmployeeName(cell.getStringCellValue());
							}else {
								company.setDesignation(cell.getStringCellValue());
							}
						}
						break;
					case 2:
//						if(!cellValue.isEmpty()) {
////							System.out.println("inside case 2 :" + cell.getNumericCellValue());
//							if(company.getPayDay() == null) {
//								company.setPayDay(cell.getNumericCellValue());
//							}else if(company.getPresentDay() == null) {
//								company.setPresentDay(cell.getNumericCellValue());
//							}
//						}
						break;
					case 3:
//						System.out.println(cell.getNumericCellValue());
						break;
	
					default:
						break;
					}
				}
				System.out.println("company " + company.toString());
                    
//	                storeExcelValue.put(a,cellValue);
	            
	        }
			
			for(Employee emp : list) {
				System.out.println(emp.getRefNo());
				System.out.println(emp.getEmployeeName());
			}
			// Row getSchool = sheet.getRow(13);
			
			
			
//				Row row = rowIterator.next();
				// For each row, iterate through all the columns
//				Iterator<Cell> cellIterator = row.cellIterator();
//
//				while (cellIterator.hasNext()) {
//					Cell cell = cellIterator.next();
//					obj.add(cell.toString());
//					// Check the cell type and format accordingly
//					// switch (cell.getCellType())
//					// {
//					// case NUMERIC:
//					// System.out.print(cell.getNumericCellValue() + ",");
//					//
//					// break;
//					// case STRING:
//					// System.out.print(cell.getStringCellValue() + ",");
//					// break;
//					// }
//					if (cell.getColumnIndex() == 0) {
//						// System.out.println(cell.getStringCellValue());
//						// company.setCompanyName(cell.getStringCellValue());
//
//					}
//				}
				
			
			
			
			
//			while (rowIterator.hasNext()) {
//				Row row = rowIterator.next();
//				 if (row.getRowNum() == 0 || row.getRowNum() == 1 || 
//			                row.getRowNum() == 2 || row.getRowNum() == 3 || 
//			                row.getRowNum() == 4 || row.getRowNum() == 5 || 
//			                row.getRowNum() == 6 || row.getRowNum() == 7 || 
//			                row.getRowNum() == 9 || row.getRowNum() == 10 || 
//			                row.getRowNum() == 11 || row.getRowNum() == 12 ||
//			                row.getRowNum() == 8) {
//			            continue;
//			        }
//				 int rowCount = row.getRowNum();
//				 
//				 if(row.getRowNum() == rowCount) {
//					 company = new Company();
//				 }
////				 For each row, iterate through all the columns
//				Iterator<Cell> cellIterator = row.cellIterator();
//				while (cellIterator.hasNext()) {
//					Cell cell = cellIterator.next();
//					
////					
//					switch (cell.getColumnIndex()) {
//					
//					case 0:
////						System.out.println(cell.getStringCellValue());
//						company.setAddress(cell.getStringCellValue());
//						break;
//					case 1:
////						System.out.println(cell.getStringCellValue());
//
//						company.setCompanyName(cell.getStringCellValue());
//						break;
//					case 2:
////						System.out.println(cell.getNumericCellValue());
//						break;
//					case 3:
////						System.out.println(cell.getNumericCellValue());
//						break;
//	
//					default:
//						break;
//					}
//				}
//				System.out.println("company " + company.toString());

				file.close();
//			}
			

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		for(String i :storeExcelValue.keySet()) {
		      System.out.println("key: " + i + " value: " + storeExcelValue.get(i));
		}
	}

	private void put(int rowIndex, String cellValue) {
		// TODO Auto-generated method stub
		
	}

}
