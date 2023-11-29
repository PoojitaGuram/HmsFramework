package com.hms.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.FileUtils;
import com.hms.GenericUtils.WebdriverUtils;

public class Doctoraddpatient1 {

	public static void main(String[] args) throws Throwable {
		ExcelUtils excel = new ExcelUtils();
		FileUtils file = new FileUtils();
		WebdriverUtils wbd = new WebdriverUtils();
		//read data from property file
		
		String URL = file.readdatafrompropertyfile("Url");
		String USERNAME = file.readdatafrompropertyfile("UsernameD");
		String PASSWORD = file.readdatafrompropertyfile("PasswordD");
		WebDriver driver=new ChromeDriver();
		wbd.Maximizethewindow(driver);
		driver.get(URL);
		wbd.implicitwait(driver, 5);
	
		//click on doctor link
	    WebElement Doctorlink= driver.findElement(By.xpath("//a[@href='hms/doctor/']"));
	    Doctorlink.click();
	    
	    //enter username
	    WebElement Un = driver.findElement(By.name("username"));
	    Un.sendKeys(USERNAME);
	    
	   // Enter password
		WebElement Ps = driver.findElement(By.name("password"));
		Ps.sendKeys(PASSWORD);
		
		//click on login button
	    WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='submit']"));
		Loginbutton.click();
		WebElement patients = driver.findElement(By.xpath("//span[text()=' Patients ']"));
		patients.click();
		
		
		WebElement managepatient = driver.findElement(By.xpath("//span[text()=' Manage Patient ']"));
		Thread.sleep(500);
		managepatient.click();
		
		WebElement eyeicon = driver.findElement(By.xpath("//a[@href='view-patient.php?viewid=322']/i[@class='fa fa-eye']"));
		eyeicon.click();
		
		WebElement medicalhis = driver.findElement(By.xpath("//button[@class='btn btn-primary waves-effect waves-light w-lg']"));
		medicalhis.click();
		
		//add all the medical history
		 
		// excel.readmultipledatafromthExcelsheet1("MedicalHistorySheet1", driver);
		//click on submit
			WebElement submit = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
			
			submit.click();
			
			String cm = wbd.alertText(driver);
			System.out.println(cm);
			wbd.alertAccept(driver);
			driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
			driver.findElement(By.xpath("//a[@href='logout.php']")).click();
			
			String USERNAME1 = file.readdatafrompropertyfile("UsernameJ");
			String PASSWORD1 = file.readdatafrompropertyfile("PasswordJ");
			 WebElement Patientlink = driver.findElement(By.xpath("//p[text()='Register & Book Appointment']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a[text()='Click Here']"));
			    Patientlink.click();
			    
			    //enter username
			    WebElement Un1 = driver.findElement(By.name("username"));
			    Un1.sendKeys(USERNAME1);
			    
			   // Enter password
				WebElement Ps1 = driver.findElement(By.name("password"));
				Ps1.sendKeys(PASSWORD1);
				
				//click on login button
			    WebElement Loginbutton1 = driver.findElement(By.xpath("//button[@name='submit']"));
				Loginbutton1.click();
				
				driver.findElement(By.xpath("//span[text()=' Medical History ']")).click();
				
				wbd.Minimizethewindow(driver);
				driver.quit();
		
	}

}
