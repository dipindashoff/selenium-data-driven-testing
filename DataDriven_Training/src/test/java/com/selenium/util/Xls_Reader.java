package com.selenium.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {

	String path = "";
	public FileInputStream f = null;
	private XSSFWorkbook w = null;
	private XSSFSheet s = null;
	private XSSFRow r = null;
	private XSSFCell c = null;

	public Xls_Reader(String path) {
		this.path = path;
		try {
			f = new FileInputStream(path);
			w = new XSSFWorkbook(f);
			s = w.getSheetAt(0);
			f.close();
		} catch (Exception e) {

		}
	}

	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {

			s = w.getSheet(sheetName);
			r = s.getRow(rowNum - 1);
			c = r.getCell(colNum);

			if (c.getCellType() == CellType.STRING)
				return c.getStringCellValue();
			else
				return String.valueOf(c.getBooleanCellValue()); // For blank cells we return a false. For strings,
																// numbers, and errors, we throw an exception.

		} catch (Exception e) {
			return "false";
		}

	}

	public int getRowCount(String sheetName) {

		s = w.getSheet(sheetName);

		return s.getLastRowNum() + 1;

	}

	public String getCellData(String sheetName, String colName, int rowNum) {
		try {

			s = w.getSheet(sheetName);
			r = s.getRow(0);
			int colNum = 0;
			for (int i = 0; i < r.getLastCellNum(); i++) {
				if (colName.equals(r.getCell(i).getStringCellValue())) {
					colNum = i;
					System.out.println(colNum);
				}
			}
			r = s.getRow(rowNum);
			c = r.getCell(colNum);

			if (c.getCellType() == CellType.STRING)
				return c.getStringCellValue();
			else
				return String.valueOf(c.getBooleanCellValue());
			// return c.getStringCellValue();

		} catch (Exception e) {
			return "";
		}
	}

}
