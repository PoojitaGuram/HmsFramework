package com.hms.testscripts;

import static org.testng.Assert.expectThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.FileUtils;
import com.hms.GenericUtils.WebdriverUtils;

public class Patientupdateprofile1 {

	public static void main(String[] args) throws Throwable {
		ExcelUtils excel = new ExcelUtils();
		FileUtils file = new FileUtils();
		WebdriverUtils wbd = new WebdriverUtils();
		
		
		String URL = file.readdatafrompropertyfile("Url");
		String USERNAME = file.readdatafrompropertyfile("UsernameP");
		String PASSWORD = file.readdatafrompropertyfile("PasswordP");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		wbd.Maximizethewindow(driver);
		wbd.implicitwait(driver, 5);
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
		
		//clcik on update link
		driver.findElement(By.xpath("//p[@class='links cl-effect-1']/a[@href='edit-profile.php']")).click();
		
	    String previouscity = "banglore";
		//change the city 
     WebElement city = driver.findElement(By.name("city"));
     city.clear();
     city.sendKeys("bidar");
        
        //click on update
        driver.findElement(By.xpath("//button[@type='submit']")).click();
		
      //confirmation
        
        String Expectedmessage="\r\n"
        		+ "Your Profile updated Successfully ";
        		
        	
      WebElement confirmationmessage = driver.findElement(By.xpath("//h5[@style='color: green; font-size:18px; ']"));
	 String cm = confirmationmessage.getText();
	 if(Expectedmessage.contains(cm)) {
		 System.out.println("profile updated");
	 }
	 else
		 System.out.println("profile not updated");
		 
	
	 WebElement picon = driver.findElement(By.xpath("//i[@class='ti-angle-down']"));
	    picon.click();
	    
	       WebElement logout = driver.findElement(By.xpath("//a[@href='logout.php']"));
			logout.click();
			
		    WebElement Patientlink1 = driver.findElement(By.xpath("//p[text()='Register & Book Appointment']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a[text()='Click Here']"));
		    Patientlink1.click();
			    
			    //enter username
			    WebElement Un1 = driver.findElement(By.name("username"));
			    Un1.sendKeys(USERNAME);
			    
			   // Enter password
				WebElement Ps1 = driver.findElement(By.name("password"));
				Ps1.sendKeys(PASSWORD);
				
				//click on login button
			    WebElement Loginbutton1 = driver.findElement(By.xpath("//button[@name='submit']"));
				Loginbutton1.click();
				
				//clcik on update link
				driver.findElement(By.xpath("//p[@class='links cl-effect-1']/a[@href='edit-profile.php']")).click();
				
				  WebElement city2 = driver.findElement(By.name("city"));
				String changedcityname = city2.getText();
				if(previouscity.equals(changedcityname)) {
					System.out.println("city not updated");
				}
				else {
					System.out.println("city updated");
				}
				wbd.Minimizethewindow(driver);
				driver.quit();
	}	

}
