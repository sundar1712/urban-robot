package com.salary.Statement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	  public static void main(String[] args) {
		    // Step 1: Read Excel File into Java List Objects
		    List<Company> company = readExcelFile("SALARY STATEMENT - DECEMBER - 2020.xlsx");
		    
		    // Step 2: Convert Java Objects to JSON String
//		    String String = convertObjects2String(company);
		    
  System.out.println(company);
		  }
		  
		  /**
		   * Read Excel File into Java List Objects
		   * 
		   * @param filePath
		   * @return
		   */
		  private static List<Company> readExcelFile(String filePath){
		    try {
		      FileInputStream excelFile = new FileInputStream(new File(filePath));
		        Workbook workbook = new XSSFWorkbook(excelFile);
		     
		        Sheet sheet = workbook.getSheet("Sheet1");
		        Iterator<Row> rows = sheet.iterator();
		        
		        List<Company> lstSheet1 = new ArrayList<Company>();
		        
		        int rowNumber = 14;
		        while (rows.hasNext()) {
		          Row currentRow = rows.next();
		          
//		           skip header
		          if(rowNumber == 0) {
		            rowNumber++;
		            continue;
		          }
		          
		          Iterator<Cell> cellsInRow = currentRow.iterator();
		 
		          Company cust = new Company();
		          
		          int cellIndex = 1;
		          while (cellsInRow.hasNext()) {
		            Cell currentCell = cellsInRow.next();
		            
		            if(cellIndex==0) { // ID
		              cust.setCompanyName(currentCell.getStringCellValue());
		              System.out.println(currentCell.getStringCellValue());
		            } 
//		              else if(cellIndex==0) { // Name
//		              cust.setAddress(currentCell.getStringCellValue());
//		            } 
//		              else if(cellIndex==2) { // Address
//		              cust.setAddress(currentCell.getStringCellValue());
//		            } else if(cellIndex==3) { // Age
//		              cust.setAge((int) currentCell.getNumericCellValue());
//		            }
		            
//		            cellIndex++;
		          }
		          
		          lstSheet1.add(cust);
		        }
		        
		        // Close WorkBook
		        workbook.close();
		        
		        
		        return lstSheet1;
		        } catch (IOException e) {
		          throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		        }
		    
		  
		    }

//		  private static  String convertObjects2String(List<Company>Sheet1) {
//			  Object mapper = new Object();
//		      String String = "";
//		      
//		      try {
//		        String =mapper.toString();
//		      }
//		      catch (Exception e) {
//		        e.printStackTrace();
//		      }
//			
//		      
//		      return String; 
//		  }
//		  
		}



