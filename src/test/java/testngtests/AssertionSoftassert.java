package testngtests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionSoftassert {
@Test
public void softassert() {
	String Expectedtitle = "Hospital Management System";
	SoftAssert sa = new SoftAssert();
	WebDriver driver=new ChromeDriver();
	driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
	String actualtitle = driver.getTitle();
	sa.assertEquals(actualtitle,Expectedtitle);
	System.out.println(actualtitle);
	sa.assertAll();
	
	
	
}
}
