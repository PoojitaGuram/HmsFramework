package testngtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.GenericUtils.BaseClass;

public class testpractise2 extends BaseClass {
	
@Test(groups = "smoke")
public void create() {
	System.out.println("create test");
}
@Test(groups = "regression")
public void sample() {
	System.out.println("create sample");
}
}

