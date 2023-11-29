package pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ksrtcCalenderpopupTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='7']")).click();
		

	}

}
