package com.hms.adminmodule;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.FileUtils;
import com.hms.GenericUtils.WebdriverUtils;
import com.hms.pomrepository.AdminChangePasswordPage;
import com.hms.pomrepository.AdminDashboardPage;
import com.hms.pomrepository.AdminLoginPage;
import com.hms.pomrepository.HmsHomePage;

import adminmodule.Adminchangepassword;

public class Adminchangepasswordtest {
@Test
	public  void  adminchangepass ()throws Throwable {
		ExcelUtils excel = new ExcelUtils();
		FileUtils file = new FileUtils();
		WebdriverUtils wbd = new WebdriverUtils();
		WebDriver driver;

		// read data from excel sheet

		String USERNAME = file.readdatafrompropertyfile("UsernameA");
		String PASSWORD = file.readdatafrompropertyfile("PasswordA");
		String URL = file.readdatafrompropertyfile("Url");

		driver = new ChromeDriver();
		wbd.Maximizethewindow(driver);
		driver.get(URL);
		wbd.implicitwait(driver, 5);
		HmsHomePage hp = new HmsHomePage(driver);
		hp.clickonadminlink();

		AdminLoginPage lpa = new AdminLoginPage(driver);
		lpa.Adminlogin(USERNAME, PASSWORD);

		// click on profile icon
		AdminDashboardPage dba = new AdminDashboardPage(driver);
		dba.clickonprofileiconchangepass();

		AdminChangePasswordPage adchp = new AdminChangePasswordPage(driver);
		adchp.changepassword(driver, excel.readmultipledatafromthExcelsheet1("AdminchangepasswordSheet6"));

		String actualtext = "Password Changed Successfully !!";
		
		WebElement confirmess = adchp.getCongirmmsg();
		
		String confirm = confirmess.getText();
		//System.out.println(confirm);
		Assert.assertEquals(confirm, actualtext);
		System.out.println("password changed");
		/*if (confirm.equalsIgnoreCase(expectedtext)) {
			System.out.println("password confirmed");

		} else {
			System.out.println("password is empty");
		}*/

		dba.clickonprofileiconlogout();

		wbd.Minimizethewindow(driver);
		driver.quit();

	}

}
