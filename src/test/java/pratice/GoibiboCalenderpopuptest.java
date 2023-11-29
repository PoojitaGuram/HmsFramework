package pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboCalenderpopuptest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		
		driver.findElement(By.xpath("//span[@class='sc-12foipm-22 cUvQPq fswDownArrow']")).click();
		
		
        for(;;) {
        	try {
        	
        			driver.findElement(By.xpath("//div[text()='May 2024']/ancestor::div[@class='DayPicker-Month']/descendant::div[@aria-label='Fri May 03 2024']")).click();
                     break;
        }
        	catch (Exception e) {
        		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
        

}
        driver.findElement(By.xpath("//span[text()='Done']")).click();
	}}
