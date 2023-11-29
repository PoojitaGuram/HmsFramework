package testngtests;

import org.testng.annotations.DataProvider;

public class StoreandfetchDataprovidertest {

	@DataProvider
	public Object[][] data1() {
		Object[][] obj = new Object[2][3];
		obj[0][0]="banglore";
		obj[0][1]="pune";
		obj[0][2]=1000;
		
		obj[1][0]="hyd";
		obj[1][1]="chennai";
		obj[1][2]=800;
		return obj;
	}
}
