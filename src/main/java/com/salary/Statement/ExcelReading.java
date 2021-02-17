package com.salary.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

    // public Workbook workbook= null;
    // public Sheet firstSheet= null;

    public String INPUT_XLS = "SALARY STATEMENT - DECEMBER - 2020.xlsx";

    public ExcelReading() {
    }

    public ExcelReading(String filepath) {
        INPUT_XLS = filepath;
    }

    public Map<Integer, List<String>> ReadExcel() throws IOException {

        FileInputStream inputStream = new FileInputStream(new File("SALARY STATEMENT - DECEMBER - 2020.xlsx"));

        Map<Integer, List<String>> data = new HashMap<Integer, List<String>>();

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet firstSheet = workbook.getSheetAt(0);

        Iterator<Row> iterator = firstSheet.iterator();

        // Test test=new Test();
        int rowCnt = 13;

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();

            Iterator<Cell> cellIterator = nextRow.cellIterator();
            List<String> obj = new ArrayList<String>();
            while (cellIterator.hasNext()) 
            {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                switch (cell.getCellType()) 
                {
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");

                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                }
            }
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//
//                String cellobj = cell.getStringCellValue();
//                
//
//                if ("".equals(cell.getStringCellValue())) {
//                    obj.add("Missing");
//
//                } else if (cellobj.equals(null)) {
//                    obj.add("");
//
//                } else {
//                    obj.add(cell.getStringCellValue());
//                }
//
//            }

            data.put(rowCnt, obj);
            rowCnt++;

        }
        return data;
    }

}
