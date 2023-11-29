package testngtests;

import org.testng.annotations.DataProvider;

import com.hms.GenericUtils.ExcelUtils;

public class Dataprovider2excel {

	@DataProvider
	public Object[][] data() throws Throwable {
		ExcelUtils eut = new ExcelUtils();
		 Object[][] value = eut.readmultipledatafromdataprovider("Sheet1");
		 return value;
	}
}
