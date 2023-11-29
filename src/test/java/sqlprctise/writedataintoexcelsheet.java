package sqlprctise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writedataintoexcelsheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		//sh.getRow(4).createCell(0).setCellValue("good");
		//sh.createRow(4).createCell(1).setCellValue("morning");
	     sh.createRow(5).createCell(0).setCellValue("hi");
	     sh.getRow(5).createCell(1).setCellValue("bye");
	     
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\testdata.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
