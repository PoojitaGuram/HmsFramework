package com.hms.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.spec.MGF1ParameterSpec;
import java.time.Duration;
import java.util.Properties;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.FileUtils;
import com.hms.GenericUtils.WebdriverUtils;

public class Adminchangepassword1 {
	

	public static void main(String[] args) throws Throwable {
		ExcelUtils excel = new ExcelUtils();
		FileUtils file= new FileUtils();
		WebdriverUtils wbd = new WebdriverUtils();
		
			//read data from excel sheet
			
			String USERNAME = file.readdatafrompropertyfile("UsernameA");
			String PASSWORD = file.readdatafrompropertyfile("PasswordA");
			String URL = file.readdatafrompropertyfile("Url");

			
		WebDriver driver = new ChromeDriver();
		wbd.Maximizethewindow(driver);
		driver.get(URL);
		wbd.implicitwait(driver, 5);
		WebElement Adminlink = driver.findElement(By.xpath("//a[@href='hms/admin']"));
		Adminlink.click();
		
	    WebElement Un = driver.findElement(By.name("username"));
	    Un.sendKeys(USERNAME);
	    WebElement Ps = driver.findElement(By.name("password"));
		Ps.sendKeys(PASSWORD);
		WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='submit']"));
		Loginbutton.click();
		
		//click on profile icon
		
		WebElement profileicon = driver.findElement(By.xpath("//i[@class='ti-angle-down']"));
		profileicon.click();
		
		
		//click on change password
		WebElement changepassword = driver.findElement(By.xpath("//a[@href='change-password.php']"));
		changepassword.click();
		//excel.readmultipledatafromthExcelsheet1("AdminchangepasswordSheet6", driver);
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
		
		
		String expectedtext ="Password Changed Successfully !!								";
		WebElement confirmess = driver.findElement(By.xpath("//p[@style='color:red;']"));
		String confirm = confirmess.getText();
		if(confirm.equalsIgnoreCase(confirm)) {
			System.out.println("password confirmed");
			
		}
		else {
			System.out.println("password is empty");
		}
		
		driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
			WebElement logout = driver.findElement(By.xpath("//a[@href='logout.php']"));
		logout.click();
		
		
		wbd.Minimizethewindow(driver);
		driver.quit();

	}

}
