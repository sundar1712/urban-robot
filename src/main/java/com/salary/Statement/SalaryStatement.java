package com.salary.Statement;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class SalaryStatement {
	 static PDDocument doc = new PDDocument();
	    static PDPage Page = new PDPage();
	    static PDPageContentStream contentStream;
	    
	    public static void main(String args[]) throws IOException, InterruptedException {
	    	SalaryStatement pay =new SalaryStatement();
	    	Read read=new Read();
	    	Test test=new Test();
//    read.ReadExcelDemo("SALARY STATEMENT - DECEMBER - 2020.xlsx");
    test.ReadExcelDemo("SALARY STATEMENT - DECEMBER - 2020.xlsx");
//	    ExcelReading excel=new ExcelReading();
//	    excel.ReadExcel();
	  
//    	read.extractExcelContentByColumnIndex(0);
//	    read.extractExcelContentByColumnIndex(1);
//	    read.extractExcelContentByColumnIndex(2);
//	    read.extractExcelContentByColumnIndex(3);
	    	doc.addPage(Page);
			contentStream =new PDPageContentStream(doc, Page);

			 String[][] contentHeader = {{ "EARNINGS", "AMOUNT", "DEDUCTIONS", "AMOUNT" } };

				String[][] content = { 
		                {"BASIC","6000","PF","0"}, 
		                {"OTHER ALLOWANCE","10650","TDS","0"},
		                {"SPECIAL ALLOWANCE","0","ESI","0" }, 
		                {"HRA","5750","LOAN","0"},
		                {"MEDICAL ALLOWANCE","1500","PT","0"},
		                {"CONVEYANCE","6500","SPCL DEDUCTION","0"},
		                {"TOTAL","30400","TOTAL","0"}} ;
	    	
//				pay.employee();
//	    	pay.details("TUP002", "J JUDE PRIMUS", "AssT MANAGER-OPERATION", "31", "24", "TIRUPUR");
//	    	pay.insertingImage();
	    	table(Page, contentStream, 630, 25, contentHeader, content);
	    	contentStream.close();
	    	doc.save("judePrimus.pdf");
//	    	System.out.println("pdf is created");
	    	
	    }
	    

		public void employee() throws IOException {
		 contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER_BOLD, 15);
	          contentStream.newLineAtOffset(200, 750);
	          contentStream.showText("AISHNAV LOGISTICS");
	         contentStream.endText();
	         
	         contentStream.beginText();
	         contentStream.setFont(PDType1Font.COURIER_BOLD, 13);
	         contentStream.newLineAtOffset(240, 725);
	         contentStream.showText("TIRUPUR");
	        contentStream.endText();
	        
	          contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
	          contentStream.newLineAtOffset(25, 700);
	          contentStream.showText("REF NO");
	         contentStream.endText();
	         
	          contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
	          contentStream.newLineAtOffset(25, 675);
	          contentStream.showText("EMPLOYEE NAME");
	          contentStream.endText();
	          
	          contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
	          contentStream.newLineAtOffset(25, 650);
	          contentStream.showText("DESIGNATION");
	          contentStream.endText();
	          
	          contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
	          contentStream.newLineAtOffset(400,700);
	          contentStream.showText("NOD");
	          contentStream.endText();
	          
	          contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
	          contentStream.newLineAtOffset(400, 675);
	          contentStream.showText("NOP");
	          contentStream.endText();
	          
	          contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
	          contentStream.newLineAtOffset(400, 650);
	          contentStream.showText("BRANCH");
	          contentStream.endText();
	          
	          
	          
	          contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER_BOLD, 10);
	          contentStream.newLineAtOffset(25, 635);
	          contentStream.showText("MONTH OF NOVEMBER-2020");
	          contentStream.endText();
	          
	          contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
	          contentStream.newLineAtOffset(25, 455);
	          contentStream.showText("NET PAY");
	          contentStream.endText();
	          
	          contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER, 12);
	          contentStream.newLineAtOffset(200, 455);
	          contentStream.showText("30400");
	          contentStream.endText();
	          
	          contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
	          contentStream.newLineAtOffset(25, 430);
	          contentStream.showText("IN WORDS");
	          contentStream.endText();
	          
	          contentStream.beginText();
	          contentStream.setFont(PDType1Font.COURIER, 12);
	          contentStream.newLineAtOffset(100, 430);
	          contentStream.showText("Rupees:thirty thousand four hundred only");
	          contentStream.endText();
	          
	          
	          
	          
		}
		       
		     
		
public void details(String refNo,String employeeName,String designation,String nod,String nop,String branch) throws IOException {
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.newLineAtOffset(140, 700);
        contentStream.showText(refNo);
       contentStream.endText();

        
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.newLineAtOffset(140, 675);
        contentStream.showText(employeeName);
        contentStream.endText();
        
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.newLineAtOffset(140, 650);
        contentStream.showText(designation);
        contentStream.endText();
        
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.newLineAtOffset(500, 700);
        contentStream.showText(nod);
        contentStream.endText();
        
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.newLineAtOffset(500, 675);
        contentStream.showText(nop);
        contentStream.endText();
        
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
        contentStream.newLineAtOffset(500, 650);
        contentStream.showText(branch);
        contentStream.endText();
}
public static  void  table(PDPage page, PDPageContentStream contentStream,
		    float y, float margin, String[][] contentHeader,String[][] content) throws IOException {
		 final int rows = 8;
		    final int cols =content[0].length;
		    final float rowHeight = 20.0f;
		    final float tableWidth = page.getMediaBox().getWidth()  - 2.0f*margin;
		    final float tableHeight = rowHeight * (float) rows;
		    final float colWidth =tableWidth / (float) cols;
//		    System.out.println(tableWidth);
//
//		    System.out.println(tableHeight);
//		    System.out.println(colWidth);
		    //draw the rows
		    float nexty = y ;
		    for (int i = 0; i <= rows; i++) {
		        contentStream.moveTo(margin, nexty);
		        contentStream.lineTo(margin + tableWidth, nexty);
		        contentStream.stroke();
		        nexty-= rowHeight;
		    }

		    //draw the columns
		    float nextx = margin;
		    for (int i = 0; i <= cols; i++) {
		        contentStream.moveTo(nextx, y);
		        contentStream.lineTo(nextx, y - tableHeight);
		        contentStream.stroke();
		        nextx += colWidth;
		    }

		    //now add the text
		  
		   
		    final float cellMargin = 5.0f;
		  float headerTextx = margin + cellMargin;
		float headerTexty = y - 15.0f;
		float texty = y-headerTextx;
		float textx= 30;
		    
		  for (final String[] header : contentHeader) {
			for (String value : header) {
				contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12.0f);

				contentStream.beginText();

				contentStream.newLineAtOffset(headerTextx, headerTexty);

				contentStream.showText(value);
				contentStream.endText();
				headerTextx += colWidth;
				
			}
		}
		    for (final String[] aContent : content) {
		        for (String text : aContent) {
		        	
					contentStream.setFont(PDType1Font.HELVETICA, 12.0f);

		        	contentStream.beginText();
		            contentStream.newLineAtOffset(textx, texty-5f);
		            
		            contentStream.showText(text);
		           contentStream.endText();
		            textx += colWidth;
		        }
		        texty -= rowHeight;
		        textx = margin + cellMargin;
		        
		    }
		    
	}
  
  public void insertingImage() throws IOException{

      PDImageXObject pdImage1 = PDImageXObject.createFromFile("C:\\Users\\User\\Downloads\\seal.jpg", doc); 
      PDImageXObject pdImage = PDImageXObject.createFromFile("C:\\Users\\User\\Downloads\\stamp.jpg", doc); 
      contentStream.drawImage(pdImage1,500, 300); 
      contentStream.drawImage(pdImage,25, 300); 
      System.out.println("Image inserted"); 

  }

  


}