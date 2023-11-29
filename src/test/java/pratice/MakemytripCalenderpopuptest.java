package pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakemytripCalenderpopuptest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions action=new Actions(driver);
		action.click().pause(Duration.ofSeconds(4)).click().build().perform();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		String Month="February";
		String Year="2024";
		String day="14";
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+Month+" "+Year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
				break;
				
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		
	}

}
