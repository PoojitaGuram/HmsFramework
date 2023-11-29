package sqlprctise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class READdatafromexcel2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
        int rowcount=sh.getLastRowNum();
        int colcount=sh.getRow(0).getLastCellNum();
        for(int i=0;i<=rowcount;i++) {
        	for(int j=0;j<colcount;j++) {
        	   String result = sh.getRow(i).getCell(j).getStringCellValue();
        	   System.out.print(result);
           	   System.out.print(" ");
        	}
        	
        System.out.println();
	}

}}
