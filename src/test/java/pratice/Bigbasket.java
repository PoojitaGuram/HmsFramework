package pratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Bigbasket {
public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.bigbasket.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebElement shopcategory = driver.findElement(By.xpath("//button[@aria-controls='headlessui-menu-items-:R9bab6:']/div/span[text()='Category']"));
	shopcategory.click();
	Thread.sleep(4000);
	WebElement bakery = driver.findElement(By.xpath("//div[@aria-labelledby='headlessui-menu-button-:R5bab6:']/nav/ul/li/a[text()='Bakery, Cakes & Dairy']"));
	WebElement fruit = driver.findElement(By.xpath("//div[@aria-labelledby='headlessui-menu-button-:R5bab6:']/nav/ul/li/a[text()='Fruits & Vegetables']"));
	WebElement foodoilmasla = driver.findElement(By.xpath("//div[@aria-labelledby='headlessui-menu-button-:R5bab6:']/nav/ul/li/a[text()='Foodgrains, Oil & Masala']"));
	Actions action = new Actions(driver);
	//action.moveToElement(foodoilmasla).perform();
	//action.moveToElement(bakery).perform();
	action.moveToElement(fruit).perform();
	Thread.sleep(1000);
	List<WebElement> all = driver.findElements(By.xpath("//div[@id='headlessui-menu-items-:R9bab6:']/nav[@class='jsx-1259984711 flex text-medium']/ul[@class='jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800']/li"));
for (WebElement eleme : all) 
{
	String allelem = eleme.getText();
	
System.out.println(allelem);
}
}}
