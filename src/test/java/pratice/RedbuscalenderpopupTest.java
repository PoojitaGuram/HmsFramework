package pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class RedbuscalenderpopupTest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//span[@class='dateText']")).click();
		driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']/*[name()='svg' and @id='Layer_1']")).click();
		
		for(;;) {
			try {
				
				driver.findElement(By.xpath("//div[text()='jan'and '2024' ]/ancestor::div[@class='sc-jzJRlG dPBSOp']/descendant::span[text()='12']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']/*[name()='svg' and @id='Layer_1']")).click();
				
			}
		}
	    
	   
	

	
	

	}

}
