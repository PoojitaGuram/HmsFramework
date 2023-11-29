package sqlprctise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readdatafromexcelsheet {

	public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	String value= sh.getRow(0).getCell(1).getStringCellValue();
	System.out.println(value);
	

	}

}
