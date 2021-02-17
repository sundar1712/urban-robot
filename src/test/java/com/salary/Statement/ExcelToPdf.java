package com.salary.Statement;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

import org.apache.commons.logging.impl.AvalonLogger;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelToPdf {
	  private static final Logger logger = Logger.getLogger(ExcelTo.class.getCanonicalName());

	    /**
	     * excel to pdf
	     * 
	     * @param book excel workbook
	     * @param out output to pdf
	     * @param documentSetup document setup
	     * @throws IOException I/O exception
	     */
	    public static void pdf(Workbook book, OutputStream out, Consumer<PDFPrinter> documentSetup) throws IOException {
	        Objects.requireNonNull(book);
	        Objects.requireNonNull(out);
	        try (PDFPrinter printer = new PDFPrinter()) {
	            printer.documentSetup = Optional.ofNullable(documentSetup);
	            for (int i = 0, end = book.getNumberOfSheets(); i < end; i++) {
	                Sheet sheet = book.getSheetAt(i);
	                int rowCount = sheet.getPhysicalNumberOfRows();
	                if (rowCount <= 0) {
	                    logger.info(sheet.getSheetName() + ": empty");
	                    continue; /* skip blank sheet */
	                }
	                logger.info(sheet.getSheetName() + ": " + rowCount + " rows");
	                printer.println("sheet name: " + sheet.getSheetName());
	                printer.println("max row index: " + sheet.getLastRowNum());
	                printer.println("max column index: " + Tool.stream(sheet.rowIterator(), rowCount).mapToInt(Row::getLastCellNum).max().orElse(0));
	                eachCell(sheet, (cell, range) -> Tool.cellValue(cell).ifPresent(
	                        value -> printer.println('[' + (range == null ? new CellReference(cell).formatAsString() : range.formatAsString()) + "] " + value)));
	                eachShape(sheet, shapeText(text -> printer.println("[shape text] " + text)));
	                printer.newPage();
	            }
	            printer.getDocument().save(out);
	        }
	        public static void main(String[] args) {
	            Objects.requireNonNull(args);
	            int count = 0;
	            boolean[] drawMarginLine = { false };
	            for (int i = 0; i < args.length; i++) {
	                switch (args[i]) {
	                case "-m":/* set draw margin line */
	                    i++;
	                    drawMarginLine[0] = Boolean.parseBoolean(args[i]);
	                    break;
	                case "-p":/* set password */
	                    i++;
	                    Biff8EncryptionKey.setCurrentUserPassword(args[i]);
	                    break;
	                default:
	                    String path = Tool.trim(args[i], "\"", "\"");
	                    String toPath = Tool.changeExtension(path, ".pdf");
	                    String toTextPath = Tool.changeExtension(path, ".txt");
	                    try (InputStream in = Files.newInputStream(Paths.get(path));
	                            Workbook book = WorkbookFactory.create(in);
	                            OutputStream out = Files.newOutputStream(Paths.get(toPath));
	                            OutputStream outText = Files.newOutputStream(Paths.get(toTextPath))) {
	                        logger.info("processing: " + path);
	                        pdf(book, out, printer ) {
	                            printer.setPageSize(PDRectangle.A4, false);
	                            printer.setFontSize(10.5f);
	                            printer.setMargin(15);
	                            printer.setLineSpace(5);
	                            printer.setDrawMarginLine(drawMarginLine[0]);
	                        });
	                        text(book, outText);
	                        logger.info("converted: " + toPath + ", " + toTextPath);
	                        count++;
	                    } catch (IOException e) {
	                        throw new UncheckedIOException(e);
	                    }
	                    break;
	                }
	            }
	            AvalonLogger.info("processed " + count + " files.");
	        }

	    }
	    }



