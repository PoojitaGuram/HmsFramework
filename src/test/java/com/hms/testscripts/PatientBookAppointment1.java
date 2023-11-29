package com.hms.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.FileUtils;
import com.hms.GenericUtils.WebdriverUtils;

public class PatientBookAppointment1 {

	public static void main(String[] args) throws Throwable {
		ExcelUtils excel = new ExcelUtils();
		FileUtils file = new FileUtils();
		WebdriverUtils wbd = new WebdriverUtils();
		
		String URL = file.readdatafrompropertyfile("Url");
		String USERNAME = file.readdatafrompropertyfile("UsernameP");
		String PASSWORD = file.readdatafrompropertyfile("PasswordP");
		
		WebDriver driver=new ChromeDriver();
		wbd.Maximizethewindow(driver);
		driver.get(URL);
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
		
		//click on bookapoointment module
		WebElement BookAppointment = driver.findElement(By.xpath("//span[text()=' Book Appointment ']"));
		BookAppointment.click();
		
		
		
		//Enter the doctor specilization
				String DoctorSpecialization = excel.readDataFromExceltest1("testdatapatientSheet4", 0, 1);
				WebElement doctorspecilationdropdown = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
			  wbd.selectbyvisibletext(doctorspecilationdropdown, DoctorSpecialization);
				
			    
			    //Enter doctors name
			    String Doctors = excel.readDataFromExceltest1("testdatapatientSheet4", 1, 1);
			   WebElement doctorsdropdown = driver.findElement(By.name("doctor"));
			   wbd.selectbyvisibletext(doctorsdropdown, Doctors);
			  
			    
			   //enter the date
			  WebElement date = driver.findElement(By.name("appdate"));
			  date.click();
			  
			  //click on next button
			  WebElement next = driver.findElement(By.xpath("//th[text()='November 2023']/following-sibling::th[@class='next']"));
			  next.click();
			  
			  //Thread.sleep();
			  //click on particular date
			  WebElement particulardate = driver.findElement(By.xpath("//th[text()='December 2023']/ancestor::div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']/descendant::td[text()='5']"));
			  particulardate.click();
			  
			 //click on time 
			 WebElement time = driver.findElement(By.xpath("//input[@id='timepicker1']"));
			 time.click();
			 
			//select the time
				WebElement decrementhour = driver.findElement(By.xpath("//a[@data-action='decrementHour']"));
				WebElement decrementminute = driver.findElement(By.xpath("//a[@data-action='decrementMinute']"));
				WebElement togglemeridian = driver.findElement(By.xpath("//a[@data-action='toggleMeridian']"));
				
				//Actions action = new Actions(driver);
			    //action.moveToElement(decrementhour).click().pause(Duration.ofSeconds(5)).moveToElement(decrementminute).click().pause(Duration.ofSeconds(5)).moveToElement(togglemeridian).click().build().perform();
		     wbd.movetoelement(driver, decrementhour, 5)	;
		     wbd.movetoelement(driver, decrementminute, 5);
		     wbd.movetoelement(driver, togglemeridian, 5);
			    //click on submit button
			    WebElement submitbutton = driver.findElement(By.name("submit"));
			    submitbutton.click();
			    
			    //
			   String message = wbd.alertText(driver);
			   System.out.println(message);
			    //handle the alert
			    wbd.alertAccept(driver);
			    
			    
			    WebElement picon = driver.findElement(By.xpath("//i[@class='ti-angle-down']"));
			    picon.click();
			    
			       WebElement logout = driver.findElement(By.xpath("//a[@href='logout.php']"));
					logout.click();
					
					wbd.Minimizethewindow(driver);
					driver.quit();
					
					
			 
		
	}

}
