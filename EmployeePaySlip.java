package com.example.Example;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class EmployeePaySlip {
//	creating a pdf document object
	 static PDDocument doc = new PDDocument();
    static PDPage Page = new PDPage();
    static PDPageContentStream contentStream;

	

	 public static void main (String args[]) throws IOException {
		 EmployeePaySlip paySlip=new EmployeePaySlip();
//		 ExampleRead exampleRead=new ExampleRead();
//		 exampleRead.readExcel();
//		 paySlip.createPdf();
//		 PDDocument doc = new PDDocument();
//			PDPage Page = new PDPage();
//		adding  the blank page to document	
		 doc.addPage( Page );
		 
		 contentStream = new PDPageContentStream(doc, Page);
		  String[][] contentHeader = {{ "EARNINGS", "AMOUNT", "DEDUCTIONS", "AMOUNT" } };

 
			String[][] content = {{"EARNINGS","AMOUNT","DEDUCTIONS","AMOUNT"}, 
	                {"BASIC","18000","PF","0"}, 
	                {"HRA","7000","PT","0"}, 
	                {"CONVEYANCE","10000","TDS","0"},
	                {"OTHER ALLOWANCE","25500","LOAN","0"},
	                {"PETROL","0" },
	                {"TEA","500"},
	                {"OT","1500"},
	                {"MEDICAL ALLOWANCE","2500"},
	                {"TOTAL","650000","TOTAL","0"}} ;
//		String[][] contentHeader={{"EARNINGS","AMOUNT","DEDUCTIONS","AMOUNT"}};
			paySlip.createPdf();
			paySlip.insertImage();
			paySlip.employeeDeatils("TUPOO2", "29", "17/12/2016", "SUNDAR LOGISTICS", "6002738922", "KUMAR", "25", "MANAGER", "MANAGEMENT", "MADURAI");

	drawTable(Page, contentStream, 550,25, content);
	contentStream.close();
	doc.save("payslip.pdf" );
    System.out.println("pdf is created");
		 
	 }
		 public void createPdf()throws IOException {
//			 PDFont font = PDType1Font.HELVETICA_BOLD;
//	            int marginTop = 30;
////	            int fontSize = 16;
//
//			 String title="SUNDAR LOGISTICS";
//			 
//			 float titleWidth = font.getStringWidth(title) / 1000 * fontSize;
//		        float titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
//
//		        float startX = (mediaBox.getWidth() - titleWidth) / 2;
//		        float startY = mediaBox.getHeight() - marginTop - titleHeight;
//   
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 15);
          contentStream.newLineAtOffset(180, 750);
          contentStream.showText("SUNDAR LOGISTICS");
         contentStream.endText();
         
         contentStream.beginText();
         contentStream.setFont(PDType1Font.COURIER_BOLD, 13);
         contentStream.newLineAtOffset(100, 725);
         contentStream.showText("3/111,VELUCHAMY NAGAR,NPK,MADURAI-625019");
        contentStream.endText();
        
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(25, 700);
          contentStream.showText("REF NO");
         contentStream.endText();
         
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(25, 675);
          contentStream.showText("PF NO");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(25, 650);
          contentStream.showText("NOD");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(25, 625);
          contentStream.showText("DOJ");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(25, 600);
          contentStream.showText("ATTENDANCE");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(25, 575);
          contentStream.showText("BANK ACC NO");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(400, 700);
          contentStream.showText("EMPLOYEE NAME");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(400, 675);
          contentStream.showText("ESI NO");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(400, 650);
          contentStream.showText("NOP");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(400, 625);
          contentStream.showText("DESIGNATION");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(400, 600);
          contentStream.showText("DEPARTMENT");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(400, 575);
          contentStream.showText("BRANCH");
          contentStream.endText();
          
          
 		 contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(25, 555);
          contentStream.showText("MONTH OF FEBRUARY-2020");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(25, 334);
          contentStream.showText("NET PAY");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER, 12);
          contentStream.newLineAtOffset(200, 334);
          contentStream.showText("65000");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
          contentStream.newLineAtOffset(25, 300);
          contentStream.showText("IN WORDS");
          contentStream.endText();
          
          contentStream.beginText();
          contentStream.setFont(PDType1Font.COURIER, 12);
          contentStream.newLineAtOffset(100, 300);
          contentStream.showText("Rupees:sixty five thousand only");
          contentStream.endText();
          
          
                     
          
          
//          contentStream.close();
		 }

		 public void employeeDeatils(String refNo,String nod,String doj,String attendance,String bankAccNo,String employeeName,String nop,String designation,String department,String branch) throws IOException 
		 {
		
         contentStream.beginText();
         contentStream.setFont(PDType1Font.COURIER, 12);
         contentStream.newLineAtOffset(140, 700);
         contentStream.showText(refNo);
        contentStream.endText();

         
         contentStream.beginText();
         contentStream.setFont(PDType1Font.COURIER, 12);
         contentStream.newLineAtOffset(140, 650);
         contentStream.showText(nod);
         contentStream.endText();
         
         contentStream.beginText();
         contentStream.setFont(PDType1Font.COURIER, 12);
         contentStream.newLineAtOffset(140, 625);
         contentStream.showText(doj);
         contentStream.endText();
         
         contentStream.beginText();
         contentStream.setFont(PDType1Font.COURIER, 12);
         contentStream.newLineAtOffset(140, 600);
         contentStream.showText(attendance);
         contentStream.endText();
         
         contentStream.beginText();
         contentStream.setFont(PDType1Font.COURIER, 12);
         contentStream.newLineAtOffset(140, 575);
         contentStream.showText(bankAccNo);
         contentStream.endText();
         
         contentStream.beginText();
         contentStream.setFont(PDType1Font.COURIER, 12);
         contentStream.newLineAtOffset(500, 700);
         contentStream.showText(employeeName);
         contentStream.endText();
         
         contentStream.beginText();
         contentStream.setFont(PDType1Font.COURIER, 12);
         contentStream.newLineAtOffset(500, 650);
         contentStream.showText(nop);
         contentStream.endText();
         
         contentStream.beginText();
         contentStream.setFont(PDType1Font.COURIER, 12);
         contentStream.newLineAtOffset(500, 625);
         contentStream.showText(designation);
         contentStream.endText();
         
         contentStream.beginText();
         contentStream.setFont(PDType1Font.COURIER, 12);
         contentStream.newLineAtOffset(500, 600);
         contentStream.showText(department);
         contentStream.endText();
         
         contentStream.beginText();
         contentStream.setFont(PDType1Font.COURIER, 12);
         contentStream.newLineAtOffset(500, 575);
         contentStream.showText(branch);
         contentStream.endText();
   
}
          
          public static  void  drawTable(PDPage page, PDPageContentStream contentStream,
      		    float y, float margin, String[][] content) throws IOException {
      		 final int rows = content.length;
      		    final int cols =content[0].length;
      		    final float rowHeight = 20.0f;
      		    final float tableWidth = page.getMediaBox().getWidth()  - 2.0f*margin;
      		    final float tableHeight = rowHeight * (float) rows;
      		    final float colWidth =tableWidth / (float) cols;
//      		    System.out.println(tableWidth);
//
//      		    System.out.println(tableHeight);
//      		    System.out.println(colWidth);
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
      		    float textx = margin + cellMargin;
      		    float texty = y - 15.0f;
      		    for (final String[] aContent : content) {
      		        for (String text : aContent) {
      		        	
      		        	
      		        	contentStream.beginText();
      		            contentStream.newLineAtOffset(textx, texty);
      		            
      		            contentStream.showText(text);
      		           contentStream.endText();
      		            textx += colWidth;
      		        }
      		        texty -= rowHeight;
      		        textx = margin + cellMargin;
      		    }
      		    
      	}
          
          public void insertImage() throws IOException{

    	      PDImageXObject pdImage1 = PDImageXObject.createFromFile("C:\\Users\\User\\Downloads\\seal.jpg", doc); 
    	      PDImageXObject pdImage = PDImageXObject.createFromFile("C:\\Users\\User\\Downloads\\stamp.jpg", doc); 
    	      contentStream.drawImage(pdImage1,500, 180); 
    	      contentStream.drawImage(pdImage,25, 180); 
    	      System.out.println("Image inserted"); 

          }

          

}

