package testngtests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidertest {
	
   @Test(dataProvider="store")
	public void getdata(String from ,String to) {
		System.out.println(from+"----"+ to);
	}
	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[2][2];
		obj[0][0]="banglore";
		obj[0][1]="pune";
		
		obj[1][0]="hyd";
		obj[1][1]="chennai";
		return obj;
		
	}
	
	@DataProvider
	public Object[][] store()
	{
		Object[][] obj = new Object[2][2];

		obj[0][0]="jaipur";
		obj[0][1]="pune";
		
		obj[1][0]="bnglore";
		obj[1][1]="chennai";
		return obj;
	}

}
