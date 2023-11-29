package pratice;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Olympictest {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	       
	       WebElement countryname = driver.findElement(By.xpath("//div[@data-cy='table-content']/div/span[@data-cy='country-name']"));
	       System.out.println(countryname.getText());
			
			
				WebElement Gold = driver.findElement(By.xpath("//div[@data-medal-id='gold-medals-row-1']/span/span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']"));
				System.out.println(Gold.getText());
                WebElement silver = driver.findElement(By.xpath("//div[@data-medal-id='silver-medals-row-1']/span/span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']"));
                System.out.println(silver.getText());
                WebElement bronze = driver.findElement(By.xpath("//div[@data-medal-id='bronze-medals-row-1']/span/span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']"));
                System.out.println(bronze.getText());
                WebElement totalmedal= driver.findElement(By.xpath("//div[@data-medal-id='total-medals-row-1']/span/span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']"));
                System.out.println(totalmedal.getText());
                
			}
		
}
