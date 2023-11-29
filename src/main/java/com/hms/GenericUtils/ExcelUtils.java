package com.hms.GenericUtils;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtils {
	public String readDataFromExceltest1(String sheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

	public int getLastRowNo(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;
	}

	public void writedatafromthExcelsheet(String sheetname, int row, int cell, String data)
			throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstant.ExcelPath);
		wb.write(fos);
		wb.close();
	}

	public HashMap<String, String> readmultipledatafromthExcelsheet(String sheetname, WebDriver driver)
			throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		HashMap<String, String> hmap = new HashMap<String, String>();
		for (int i = 1; i <= count; i++) {
			String Key = sh.getRow(i).getCell(0).getStringCellValue();
			String Value = sh.getRow(i).getCell(1).getStringCellValue();
			hmap.put(Key, Value);

		}
		return hmap;
	}

	public HashMap<String, String> readmultipledatafromthExcelsheet1(String sheetname) throws Throwable, IOException {
	
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		HashMap<String, String> hmap = new HashMap<String, String>();
		for (int i = 0; i <= count; i++) {
			String Key = sh.getRow(i).getCell(0).getStringCellValue();
			String Value = sh.getRow(i).getCell(1).getStringCellValue();
			hmap.put(Key, Value);

		}
		return hmap;

	}

	public Object[][] readmultipledatafromdataprovider(String Sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int rowcount = sh.getPhysicalNumberOfRows();
		int colcount = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowcount][colcount];
		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
