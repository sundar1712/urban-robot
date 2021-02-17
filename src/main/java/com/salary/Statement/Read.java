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
	ArrayList<Company> list = new ArrayList<>();
//	ArrayList<Employee> list1 = new ArrayList<>();
	
	
    String path;

   public void ReadExcelDemo(String path)
   {
       this.path = path;

        try
        {
            FileInputStream file = new FileInputStream(new File(path));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
       
           
             System.out.println("");

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
//            Row getSchool = sheet.getRow();
            
           
            while (rowIterator.hasNext()) 
            {
            	 
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                
            

                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    

                

                    
                   
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) 
                    {
                    
                    	
                    case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + ",");

                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + ",");
                            break;
                      
                    }
                    
               
                
                }
                
                


                System.out.println("");
            
            file.close();
        } 
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

  }
   
}
   
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFFactory;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class Read {
//	
	
//	public ArrayList<String> extractExcelContentByColumnIndex(int columnIndex){
//        ArrayList<String> columndata = null;
//     
//        try {
//            File f = new File("SALARY STATEMENT - DECEMBER - 2020.xlsx");
//            FileInputStream file = new FileInputStream(f);
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Iterator<Row> rowIterator = sheet.iterator();
//            columndata = new ArrayList<>();
//
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//                Iterator<Cell> cellIterator = row.cellIterator();
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//
//                    if(row.getRowNum() > 0){ //To filter column headings
//                        if(cell.getColumnIndex() == columnIndex){// To match column index
//                            switch (cell.getCellType()) {
//                            case NUMERIC:
//                                columndata.add(cell.getNumericCellValue()+"");
//                                break;
//                            case STRING:
//                                columndata.add(cell.getStringCellValue());
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//        file.close();
//            System.out.println(columndata);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return columndata;
//    }
//
//}
