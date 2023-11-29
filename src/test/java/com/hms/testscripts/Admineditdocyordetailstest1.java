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

import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.FileUtils;
import com.hms.GenericUtils.WebdriverUtils;
import com.hms.pomrepository.HmsHomePage;

public class Admineditdocyordetailstest1 {

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
		wbd.implicitwait(driver, 5);
		HmsHomePage hp = new HmsHomePage(driver);
		hp.clickonadminlink();
		

		WebElement Un = driver.findElement(By.name("username"));
		Un.sendKeys(USERNAME);
		WebElement Ps = driver.findElement(By.name("password"));
		Ps.sendKeys(PASSWORD);
		WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='submit']"));
		Loginbutton.click();

		// click on totaldoctorlink
		WebElement totaldoctorlink = driver.findElement(By.xpath("//a[@href='manage-doctors.php']"));
		totaldoctorlink.click();

		WebElement penclikicon = driver
				.findElement(By.xpath("//a[@href='edit-doctor.php?id=3']/i[@class='fa fa-pencil']"));
		penclikicon.click();

		String value = excel.readDataFromExceltest1("consultancyfeesSheet3", 0, 1);
		WebElement doctorconsultancy = driver.findElement(By.name("docfees"));
		doctorconsultancy.click();
		doctorconsultancy.clear();
		doctorconsultancy.sendKeys(value);

		WebElement update = driver.findElement(By.name("submit"));
		update.click();

		String expectedmess = "Doctor Details updated Successfully";

		WebElement confirmm = driver.findElement(By.xpath("//h5[@style='color: green; font-size:18px; ']"));
		String actualmess = confirmm.getText();
		if (actualmess.equals(expectedmess)) {
			System.out.println("doctor details changed");
		} else {
			System.out.println("doctor detilas not changed");
		}

		// click on doctor module
		WebElement doctors = driver.findElement(By.xpath("//span[text()=' Doctors ']"));
		doctors.click();

		//
		WebElement managedoctors = driver.findElement(By.xpath("//span[text()=' Manage Doctors ']"));
		managedoctors.click();

		WebElement penclikicon1 = driver.findElement(By.xpath("//a[@href='edit-doctor.php?id=3']/i[@class='fa fa-pencil']"));
		penclikicon1.click();

		WebElement ucf1 = driver.findElement(By.xpath("//input[@name='docfees']"));
		String actualconsultancy = ucf1.getAttribute("value");
		if (actualconsultancy.equals(value)) {
			System.out.println("doctor updated");

		} else
			System.out.println("doctor not updated");
		wbd.Maximizethewindow(driver);
		driver.quit();

	}

}
