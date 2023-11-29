package sqlprctise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Writeandreaddatafromproperty {

	public static void main(String[] args) throws IOException {
		
		Properties pobj = new Properties();
		pobj.setProperty("browser", "chrome");
		pobj.setProperty("url", "http://rmgtestingserver/domain/Hospital_Management_System/");
		pobj.setProperty("username", "Poojita@123");
		pobj.setProperty("password", "Poojita15");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\main\\resources\\Commondata.properties");
		pobj.store(fos, "write data");
		
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\Commondata.properties");
		pobj.load(fis);
		
		String BROWSERNAME = pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//p[text()='Register & Book Appointment']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a[text()='Click Here']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
		
		

	}

}
