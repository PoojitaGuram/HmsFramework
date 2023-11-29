package pratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkarttest {

	public static void main(String[] args) {
       ChromeDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.flipkart.com/");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
       driver.findElement(By.xpath("//span[text()='✕']")).click() ;
       driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("camera");
       driver.findElement(By.xpath("//button[@title='Search for Products, Brands and More']")).click();
        List<WebElement> cameraname = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
        List<WebElement> priceofall = driver.findElements(By.xpath("//div[@class='col col-5-12 nlI3QM']/descendant::div[@class='_30jeq3 _1_WHN1']\r\n"
           		+ ""));
     for(int i=0;i<cameraname.size();i++) {
    	
    	String camnames= cameraname.get(i).getText();
		
		String prices =priceofall.get(i).getText();
		System.out.println(camnames + "-------------"+prices);
	}
     
     
    	
	
     
 
		
	
}}
