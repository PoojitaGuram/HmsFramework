package testngtests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.hms.GenericUtils.IPathConstant;

public class Dataproviderfromexceltest {
	@DataProvider
	public Object[][] data() throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount=sh.getPhysicalNumberOfRows();
		int colCount=sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowcount][ colCount];
		for(int i=0;i<rowcount;i++) {
			for(int j=0;j<colCount;j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		
		return obj;
	}

}
