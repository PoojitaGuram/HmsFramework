package pratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prokabbaditest {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("https://www.prokabaddi.com/standings");
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	      WebElement teamname = driver.findElement(By.xpath("//div[@class='team-name']/p"));
	      System.out.println(teamname.getText());
	     WebElement matchesplayed = driver.findElement(By.xpath("//div[@class='table-data matches-play']/p[@class='count']"));
	     System.out.println(matchesplayed.getText());
	     
	     WebElement matcheswon = driver.findElement(By.xpath("//div[@class='table-data matches-won']/p[@class='count']"));
	     System.out.println(matcheswon.getText());
	     
	     WebElement matcheslost = driver.findElement(By.xpath("//div[@class='table-data matches-lost']/p[@class='count']"));
	     System.out.println(matcheslost.getText());
	     
	     WebElement matchesdraw = driver.findElement(By.xpath("//div[@class='table-data matches-draw']/p[@class='count']"));
	     System.out.println(matchesdraw.getText());
	     
	     WebElement matchesscorediff = driver.findElement(By.xpath("//div[@class='table-data score-diff']/p[@class='count']"));
	     System.out.println(matchesscorediff.getText());
	     
	   
	    	  
	    	WebElement mat1 = driver.findElement(By.xpath("//div[@class='table-data form']//li[@class='form-item win']/p"));
	    	System.out.println(mat1.getText());
	    	WebElement mat2 = driver.findElement(By.xpath("//div[@class='table-data form']//li[@class='form-item win']/p"));
	    	System.out.println(mat2.getText());
	    	WebElement mat3 = driver.findElement(By.xpath("//div[@class='table-data form']//li[@class='form-item win']/p"));
	    	System.out.println(mat3.getText());
	    	WebElement mat4 = driver.findElement(By.xpath("//div[@class='table-data form']//li[@class='form-item win']/p"));
	    	System.out.println(mat4.getText());
	    	WebElement mat5 = driver.findElement(By.xpath("//div[@class='table-data form']//li[@class='form-item lost']/p"));
	    	System.out.println(mat5.getText());
	    	
			    
	  
	     WebElement matchdatapoint = driver.findElement(By.xpath("//div[@class='table-data points']/p[@class='count']"));
	     System.out.println(matchdatapoint.getText());
	     
	     
	}
	
}
