package testngtests;

import org.testng.annotations.Test;

public class Fetchthedatatest {

	@Test(dataProviderClass = StoreandfetchDataprovidertest.class,dataProvider = "data1")
	public void getdata1(String from,String to,int price) {
		System.out.println(from +"------"+to+"-----"+price);
	}
	@Test(dataProviderClass =  Dataproviderfromexceltest.class,dataProvider = "data")
	public void getdata2(String from,String to) {
		System.out.println(from +"------"+to);
	}
	@Test(dataProviderClass = Dataprovider2excel.class ,dataProvider = "data")
		public void getdata3(String from,String to) {
		System.out.println(from+"---"+to);
	}
	
	
}
