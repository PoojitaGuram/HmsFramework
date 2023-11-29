package testngtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.GenericUtils.BaseClass;

public class testpratise1 extends BaseClass {
	

@Test(groups = {"smoke","regression"})
public void delete(){
	
	System.out.println("delete test");
}
@Test()
public void Simple() {
	System.out.println("delete simple");
}
}
