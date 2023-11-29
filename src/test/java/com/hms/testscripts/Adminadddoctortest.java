package com.hms.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.Select;

import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.FileUtils;
import com.hms.GenericUtils.JavaUtils;
import com.hms.GenericUtils.WebdriverUtils;

public class Adminadddoctortest {

	public static void main(String[] args) throws Throwable {
		ExcelUtils excel = new ExcelUtils();
		FileUtils file = new FileUtils();
		WebdriverUtils wbd = new WebdriverUtils();

		String USERNAME = file.readdatafrompropertyfile("UsernameA");
		String PASSWORD = file.readdatafrompropertyfile("PasswordA");
		String URL = file.readdatafrompropertyfile("Url");

		WebDriver driver = new ChromeDriver();
		wbd.Maximizethewindow(driver);
		driver.get(URL);
		wbd.implicitwait(driver,5);
		WebElement Adminlink = driver.findElement(By.xpath("//a[@href='hms/admin']"));
		Adminlink.click();
		Thread.sleep(500);
		WebElement Un = driver.findElement(By.name("username"));
		Un.sendKeys(USERNAME);
		WebElement Ps = driver.findElement(By.name("password"));
		Ps.sendKeys(PASSWORD);
		WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='submit']"));
		Loginbutton.click();

		// click on doctorsmodule
		WebElement doctors = driver.findElement(By.xpath("//span[text()=' Doctors ']"));
		doctors.click();

		// click on add doctor
		WebElement adddoctor = driver.findElement(By.xpath("//a[@href='add-doctor.php']"));
		adddoctor.click();

		String doctorspec = excel.readDataFromExceltest1("AdddoctorSheet2", 0, 1);

		// doctor specilization
		WebElement dsn = driver.findElement(By.name("Doctorspecialization"));
		wbd.selectbyvisibletext(dsn, doctorspec);

		// add all other fields
		int count = excel.getLastRowNo("AdddoctorSheet2");
		excel.readmultipledatafromthExcelsheet("AdddoctorSheet2", driver);

//click on submit button
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();

		String cont = wbd.alertText(driver);
		System.out.println(cont);
		driver.switchTo().alert().accept();

//click on profile icon
		WebElement picon = driver.findElement(By.xpath("//i[@class='ti-angle-down']"));
		picon.click();

//click on logout
		WebElement logout = driver.findElement(By.xpath("//a[@href='logout.php']"));
		logout.click();

//

		String USERNAME1 = file.readdatafrompropertyfile("UsernameD1");
		String PASSWORD1 = file.readdatafrompropertyfile("PasswordD1");

//login as doctor
		WebElement Doctorlink = driver.findElement(By.xpath("//a[@href='hms/doctor/']"));
		Doctorlink.click();

		WebElement Un1 = driver.findElement(By.name("username"));
		Un1.sendKeys(USERNAME1);
		WebElement Ps1 = driver.findElement(By.name("password"));
		Ps1.sendKeys(PASSWORD1);
		WebElement Loginbutton2 = driver.findElement(By.xpath("//button[@name='submit']"));
		Loginbutton2.click();
        wbd.Minimizethewindow(driver);
        driver.quit();
	}
}
