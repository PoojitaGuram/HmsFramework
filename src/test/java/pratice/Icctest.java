package pratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Icctest {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//a[text()='Team Rankings'])[1]")).click();
		String countryname="usa";
		List<WebElement>ele= driver.findElements(By.xpath("//table/tbody/tr/td/span[@class='u-hide-phablet']"));
		boolean flag=false;
		for (WebElement webEle : ele) {
			String Countrynames = webEle.getText();
			if(Countrynames.equals("countryname"));{
				System.out.println("is present");
				flag=true;
				break;
			}
		}
		if(!flag) {
		System.out.println("not present");
	}
}}
