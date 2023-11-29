package pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Crickbuzztest {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("https://www.cricbuzz.com/");
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	       driver.findElement(By.xpath("//a[text()='Live Scores']")).click();
	    WebElement team1 = driver.findElement(By.xpath("//div[@class='cb-ovr-flo cb-hmscg-tm-nm']"));
	       System.out.println(team1.getText());
WebElement score1 = driver.findElement(By.xpath("//div[text()='AFG']/following-sibling::div[@class='cb-ovr-flo']"));
System.out.println(score1.getText());


WebElement team2 = driver.findElement(By.xpath("//div[@class='cb-hmscg-bat-txt ']/div[@class='cb-ovr-flo cb-hmscg-tm-nm']"));

System.out.println(team2.getText());
WebElement score2 = driver.findElement(By.xpath("//div[@class='cb-hmscg-bat-txt ']/div[text()='AUS']/following-sibling::div[@class='cb-ovr-flo']"));
System.out.println(score2.getText());

	}

}
