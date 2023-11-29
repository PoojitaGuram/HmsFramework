package patientmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Patientupdateprofile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondatahms.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("Url");
		String USERNAME = pobj.getProperty("UsernameP");
		String PASSWORD = pobj.getProperty("PasswordP");
		
		//
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
		//click on patient link
	    WebElement Patientlink = driver.findElement(By.xpath("//p[text()='Register & Book Appointment']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a[text()='Click Here']"));
	    Patientlink.click();
	    
	    //enter username
	    WebElement Un = driver.findElement(By.name("username"));
	    Un.sendKeys(USERNAME);
	    
	   // Enter password
		WebElement Ps = driver.findElement(By.name("password"));
		Ps.sendKeys(PASSWORD);
		
		//click on login button
	    WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='submit']"));
		Loginbutton.click();
		
		//clcik on update button
		driver.findElement(By.xpath("//p[@class='links cl-effect-1']/a[@href='edit-profile.php']")).click();
		
	    String previouscity = "banglore";
		//change the city 
        driver.findElement(By.name("city")).sendKeys("Bidar");
        
        //click on update
        driver.findElement(By.xpath("//button[@type='submit']")).click();
		

	}

}
