package pratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iphoneflipkarttest {

	public static void main(String[] args) {
		 ChromeDriver driver=new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("https://www.flipkart.com/");
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	       driver.findElement(By.xpath("//span[text()='✕']")).click() ;
	       driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("iphone");
	       driver.findElement(By.xpath("//button[@title='Search for Products, Brands and More']")).click();
	       
	       List<WebElement> alliphones = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	       List<WebElement> allprices = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[@class='_30jeq3 _1_WHN1']"));
	       for (int i=0;i<alliphones.size();i++) {
	    	  String iphones = alliphones.get(i).getText();
	    	  String prices = allprices.get(i).getText();
			System.out.println(iphones+"-----"+prices);
			
			
		}
	     
	    		
	    	
	     }
	}


