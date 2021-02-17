package com.salary.Statement;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StatementRead {
	private File file;
	
	 public void Upload(File file){

	  this.file = file;
	
	 }
	 File excelFile = new File("SALARY STATEMENT - DECEMBER - 2020.xlsx");
//	 Upload uploaded = new Upload(alreadyFile);

	 public ArrayList<ArrayList<Object>> extractAsList(){
	
	  ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
	
	  int maxDataCount =0;

	  try{
	
	       FileInputStream file = new FileInputStream(this.file);
	
	       

	      // Create Workbook instance holding reference to .xlsx file
	
	      XSSFWorkbook workbook = new XSSFWorkbook(file);
	
	      // Get first/desired sheet from the workbook
	
	      XSSFSheet sheet = workbook.getSheetAt(0);
	
	      // Iterate through each rows one by one
	
	      Iterator<Row> rowIterator = sheet.iterator();

	      while (rowIterator.hasNext()) {

	     
	
	          Row row = rowIterator.next();

	        

	          //Skip the first row beacause it will be header

	          if (row.getRowNum() == 0) {
	
	      
	
	              maxDataCount = row.getLastCellNum();
	
	              continue;
	
	     }

	    /**
	
	     * if row is empty then break the loop,do not go further
	
	     */
	
	    if(this.isRowEmpty(row,maxDataCount)){
	
	     //Exit the processing
	
	     break;
	
	    }
	
	     

	    ArrayList<Object> singleRows = new ArrayList<Object>();

	     
	
	    // For each row, iterate through all the columns
	
	    for(int cn=0; cn<maxDataCount; cn++) {
	
	 
	
	        Cell cell = row.getCell(cn);
	
	      
	
	        switch (cell.getCellType()) {
	
	          
	
	            case NUMERIC:
	
	         

	                                         if(DateUtil.isCellDateFormatted(cell)){

	                                             singleRows.add( new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue()) );

	                                         }else

	                                             singleRows.add(cell.getNumericCellValue());

	                                         break;

	         

	            case STRING:
	                                         singleRows.add(cell.getStringCellValue());
	                                    break;
	
	       

	            case BLANK: singleRows.add(null);break;

	       

	            default : singleRows.add(cell.getStringCellValue());
	
	        }
	
	 

	     }

	     list.add(singleRows);

	   }
	
	   file.close();

	   workbook.close();  

	  } catch (Exception e) {  e.printStackTrace();}
	
	   
	
	  return list;

	 }

	 

	 public boolean isRowEmpty(Row row,int lastcellno) {
	
	     for (int c = row.getFirstCellNum(); c < lastcellno; c++) {
	
	         Cell cell = row.getCell(c);
	
	         if (cell != null && cell.getCellType() != CellType.BLANK)
	
	             return false;

	     }

	     return true;
	
	 }
	
	}


	

//	 public String[] excelvalue(String columnWanted,int sheet_no){
//         int i=0;
//         String[] column_content_array =new String[140];
//         try{
//             int instindicator=-1;       
//             InputStream fileIn = this.getClass().getClassLoader().getResourceAsStream("SALARY STATEMENT - DECEMBER - 2020.xlsx");
//             POIFSFileSystem fs = new POIFSFileSystem(fileIn);
//             XSSFWorkbook filename = new XSSFWorkbook();
//             XSSFSheet sheet = filename.getSheetAt(sheet_no);                                                // in the row 0 (which is first row of a work sheet)                                                    // search for column index containing string "Inst_Code"
//             Integer columnNo = null;
//             Integer rowNo = null;
//             List<Cell> cells = new ArrayList<Cell>();
//             Row firstRow = sheet.getRow(0);
//             for (Cell cell : firstRow) {
//                 if (cell.getStringCellValue().equals(columnWanted)) {
//                     columnNo = cell.getColumnIndex();
//                     rowNo=cell.getRowIndex();
//                 }
//             }
//             if (columnNo != null) {
//                 for (Row row : sheet) {
//                     Cell c = row.getCell(columnNo);
//                     String cell_value=""+c;
//                     cell_value=cell_value.trim();
//                     try{
//                         if((!cell_value.equals(""))&&(!cell_value.equals("null"))&&(!cell_value.equals(columnWanted))){ 
//                             column_content_array[i]=cell_value;
//                             i++;
//                         }}
//                     catch(Exception e){
//                     }
//
//                 }
//                 return column_content_array;
//             }}
//         catch(Exception ex){
//             return column_content_array;
//         }
//         return column_content_array;
//
//     }}
//
