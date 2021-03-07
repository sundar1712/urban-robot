package com.salary.Statement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SalaryStatement {

	ArrayList<Employee> employeeList = new ArrayList<Employee>();

	String path;
	Company company = null;

	public static void main(String args[]) throws IOException, InterruptedException {
		SalaryStatement read = new SalaryStatement();
		read.readingEmployeeDetailsFromExcel("SALARY STATEMENT - DECEMBER - 2020.xlsx");
		read.addingToList();

	}

	public void readingEmployeeDetailsFromExcel(String path) {
		this.path = path;

		try {
			FileInputStream file = new FileInputStream(new File(path));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			System.out.println("");

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			int rowCount = 0;
			int rowID = 0;

			Employee emp = null;
			Earnings earnings = null;
			Deductions deductions = null;
			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// Check the cell type and format accordingly
					DataFormatter dataFormatter = new DataFormatter();
					rowID = cell.getRowIndex();
					String cellValue = dataFormatter.formatCellValue(cell);

					if (rowCount == 0 && !cellValue.isEmpty()) {

						company = new Company();
						company.setCompanyName(cell.getStringCellValue());
//           		 

						if (rowIterator.hasNext()) {
							row = rowIterator.next();
							cellIterator = row.cellIterator();

							rowCount = 1;
						}
					} else if (rowCount == 1 && !cellValue.isEmpty()) {
						company.setReport(cell.getStringCellValue());
						rowCount = 2;
					}

					if (cellValue.contains("TUP")
							|| cellValue.contains("HSR") && !cellValue.isEmpty() && cellValue != null) {
						rowCount = row.getRowNum() + 2;
						emp = new Employee();
						earnings = new Earnings();
						deductions = new Deductions();

						emp.setRefNo(cellValue);
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							emp.setEmployeeName(cell.getStringCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							emp.setPayDays(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							earnings.setBasic(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							earnings.setHra(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							earnings.setConveyance(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							earnings.setTotalEarnings(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							deductions.setPf(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							deductions.setEsi(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							deductions.setPt(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							deductions.setTotalDeductions(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							emp.setNetAmount(cell.getNumericCellValue());
						}

						if (rowIterator.hasNext()) {
							row = rowIterator.next();
							cellIterator = row.cellIterator();
						}
					} else if (rowCount != 0 && rowID < rowCount && !cellValue.isEmpty() && cellValue != null) {
						emp.setDesignation(cell.getStringCellValue());

						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							earnings.setOtherAllowance(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							earnings.setMedicalAllowance(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							earnings.setOtherConveyance(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							deductions.setTds(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							deductions.setLoan(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							deductions.setSpclDeduction(cell.getNumericCellValue());
						}
						if (rowIterator.hasNext()) {
							row = rowIterator.next();
							cellIterator = row.cellIterator();
						}
					} else if (rowCount != 0 && rowID == rowCount && !cellValue.isEmpty()) {
						emp.setPresentDays(cell.getNumericCellValue());
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							earnings.setSpclAllowance(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							earnings.setSpecial(cell.getNumericCellValue());
						}
						if (cellIterator.hasNext()) {
							cell = cellIterator.next();
							earnings.setSpclConveyance(cell.getNumericCellValue());
						}
						if (emp != null) {
							emp.setEarnings(earnings);
							emp.setDeductions(deductions);
							employeeList.add(emp);
							company.setEmpDetails(employeeList);

						}
						if (company != null) {
							System.out.println(company.toString());
						}

					}

				}

				file.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addingToList() throws IOException, InterruptedException {
		PaySlipGeneration paySlip = new PaySlipGeneration();
		paySlip.generatePaySlip(company);
	}

}
