package pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsrtcCalenderpopuptest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//click on date
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']/ancestor::div[@class='ui-datepicker-group ui-widget-content ng-tns-c58-10 ng-star-inserted']/descendant::td[@class='ng-tns-c58-10 ng-star-inserted']/a[text()='9']")).click();
		
	}

}
