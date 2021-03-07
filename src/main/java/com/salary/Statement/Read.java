package com.salary.Statement;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.apache.poi.ss.format.CellNumberStringMod;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;


public class Read {

    // public Workbook workbook= null;
    // public Sheet firstSheet= null;
//	ArrayList<Employee> list1 = new ArrayList<>();
	
	
    String path;
	ArrayList<String> list = new ArrayList<>();

    public static void main(String args[]) {
    	Read read = new Read();
    	read.readExcelDemo("SALARY STATEMENT - DECEMBER - 2020.xlsx");
    }

   public void readExcelDemo(String path)
   {
       this.path = path;

        try
        {
            FileInputStream file = new FileInputStream(new File(path));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
       
      
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
//            Row getSchool = sheet.getRow();
        	DataFormatter dataFormatter = new DataFormatter();
			Company company = null;
			Employee employee = null;
			Earnings earnings = null;
			Deductions deductions = null;
			Cell cell;
			Row row;
			Iterator<Cell> cellIterator;
			String arr[];
			 int rowID = 0;
             int rowCount = 0;
            while (rowIterator.hasNext()) 
            {
                row = rowIterator.next();
                //For each row, iterate through all the columns
                cellIterator = row.cellIterator();
              while (cellIterator.hasNext()) 
                {
            	  cell = cellIterator.next(); 
            	  DataFormatter formatter = new DataFormatter();
              	  rowID =cell.getRowIndex();
//               System.out.println(rowID);
            	  String cellValue = formatter.formatCellValue(cell);
            	  
            	  //header
//            	  if(rowCount== 0 ){
////            		  System.out.println("cell"+ cell.getStringCellValue());
//            		  company =new Company();	  
//            		  company.setCompanyName(cell.getStringCellValue());
//            		  System.out.println("cell"+ company.getCompanyName());
//            		  if(cellIterator.hasNext()) {
//            			  cell = cellIterator.next();
//            			  company.setDate(cell.getStringCellValue()); 
//            			  System.out.println("test "+company.getDate());
//            		  }
//            		  if(cellIterator.hasNext()) {
//            			  cell = cellIterator.next();
//            			  company.setReport(cell.getStringCellValue()); 
//            			  System.out.println("test1 "+company.getReport());
//
//            		  } if(rowIterator.hasNext()) {		  
//                          row = rowIterator.next();
//                          cellIterator = row.cellIterator();
//            		  }
//            		  
//            	  }
            	  if(cellValue.contains("TUP") || cellValue.contains("HSR")) {
                      rowCount = cell.getRowIndex()+2;
//                    System.out.println("rowCount"+rowCount);
                	  employee = new Employee();
                	  earnings = new Earnings();
                	  deductions= new Deductions();
            		  employee.setRefNo(cell.getStringCellValue());
            		  if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  employee.setEmployeeName(cell.getStringCellValue()); 
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  employee.setPayDays(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  earnings.setBasic(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			earnings.setHra(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  earnings.setConveyance(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			 earnings.setTotalEarnings(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			 deductions.setPf(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  deductions.setEsi(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			 deductions.setPt(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  deductions.setTotalDeductions(cell.getNumericCellValue());
            		  }if(rowIterator.hasNext()) {
                          row = rowIterator.next();
                          cellIterator = row.cellIterator();
            		  }	  
            	  }else if(rowCount!= 0 && rowID<rowCount && !cellValue.isEmpty()) {
            	  
//            		  System.out.println("values1 "+ cellValue );
//            		  System.out.println("values "+rowCount );
            		  employee.setDesignation(cell.getStringCellValue());
            		  if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
//            			 earnings.setOtherAllowance(cell.getNumericCellValue());	  
            		  }
            		  if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			 earnings.setOtherAllowance(cell.getNumericCellValue());	  
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  earnings.setMedicalAllowance(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  earnings.setConveyance(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			 deductions.setTds(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  deductions.setLoan(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  deductions.setSpclDeduction(cell.getNumericCellValue());
            		  }if(rowIterator.hasNext()) {
                          row = rowIterator.next();
                          cellIterator = row.cellIterator();
            		  }	  
            	  }else if(rowCount != 0  && rowID==rowCount && !cellValue.isEmpty()) {
        			  employee.setPresentDays(cell.getNumericCellValue());
            		 if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  earnings.setSpclAllowance(cell.getNumericCellValue());
            		  } if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			 // earnings.setSpclAllowance(cell.getNumericCellValue());
            		  }if(cellIterator.hasNext()) {
            			  cell = cellIterator.next();
            			  earnings.setConveyance(cell.getNumericCellValue());
            		  }
            	  }
                           
            
        			
//System.out.println("cell"+cellValue);
                    //row id of 	
        			
//                    if(!cellValue.isEmpty() && cell.getColumnIndex() ==0 && cellValue.contains("TUP")|| cellValue.contains("HSR")) {
//                	
//                        rowCount = cell.getRowIndex()+2;
//                        System.out.println("rowcount"+ rowCount);
//                        System.out.println("rowID"+ rowID);
// 
//                    }
//
//                   if(rowCount!=0 && rowID<= rowCount) {
//                    switch (cell.getCellType()){    	
//                    case NUMERIC:
////                    	System.out.println(cell.getNumericCellValue());
//                        String s=String.valueOf(cell.getNumericCellValue()); 
//                        //array
//                            list.add(s);
//                            break;
//                        case STRING:
//                        	
//    						list.add(cell.getStringCellValue());aa
//                            break;       
//                   }
//                    if(rowID== rowCount) {
//                    	System.out.println("test");
//                    	 employee = new Employee(list);
//                    }
//                }
//            	System.out.println(employee.toString());
            }
            }company=new Company();
            employee.setEarnings(earnings);
    		  employee.setDeductions(deductions);
////                
             	if(employee !=null) {
             		company.empDetails.add(employee);
					showList(company);
     	

   	}
//            	System.out.println(employee.toString());

            
            file.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
          
  }
   public void showList(Company company) {
		for(Employee i :company.getEmpDetails()) {
		      System.out.println( i );
		     
		}
   }
}