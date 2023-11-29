package pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Spicejettest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);	       
		  driver.manage().window().maximize();
	       driver.get("https://www.spicejet.com/");
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	       
	      WebElement roundtrip = driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']"));
	      roundtrip.click();
	        driver.findElement(By.xpath("//div[text()='From']")).click();
	       driver.findElement(By.xpath("//div[text()='Agartala']")).click();
	     
	      driver.findElement(By.xpath("//div[text()='To']")).click();
	     WebElement to = driver.findElement(By.xpath("//div[text()='Sardar Vallabhbhai Patel International Airport']"));
	     to.click();
	     
	     
	     WebElement Dedat = driver.findElement(By.xpath("//div[text()='Departure Date']"));
	     Dedat.click();
	   
	     WebElement depaturedate = driver.findElement(By.xpath("//div[text()='December ' and '2023']/ancestor::div[@data-testid='undefined-month-December-2023']/descendant::div[text()='12']"));
	     depaturedate.click();
	     
	     Thread.sleep(10);
	     
	     WebElement x = driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73']/*[name()='svg' and @data-testid='svg-img'])[1]"));
	     x.click();
	     
	     WebElement returndate = driver.findElement(By.xpath("//div[text()='Return Date']"));
	     returndate.click();
	}

}
	

