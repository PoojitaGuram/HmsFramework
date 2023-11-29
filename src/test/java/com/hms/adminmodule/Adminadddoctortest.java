package com.hms.adminmodule;

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
import com.hms.pomrepository.AdminAddDoctorPage;
import com.hms.pomrepository.AdminDashboardPage;
import com.hms.pomrepository.AdminLoginPage;
import com.hms.pomrepository.DoctorLoginPage;
import com.hms.pomrepository.HmsHomePage;

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
		wbd.implicitwait(driver, 5);

		HmsHomePage hp = new HmsHomePage(driver);

		hp.clickonadminlink();
		AdminLoginPage Adlogin = new AdminLoginPage(driver);
		Adlogin.Adminlogin(USERNAME, PASSWORD);

		Thread.sleep(500);
		// click on doctorsmodule and add doctor
		AdminDashboardPage Addash = new AdminDashboardPage(driver);
		Addash.clickondoctoradddoctor();

		// enter all the details
		String doctorspec = excel.readDataFromExceltest1("AdddoctorSheet2", 0, 1);
		AdminAddDoctorPage adminadddoctor = new AdminAddDoctorPage(driver);
		adminadddoctor.enteralldoctordetails(driver, excel.readmultipledatafromthExcelsheet("AdddoctorSheet2", driver),doctorspec);

		String cont = wbd.alertText(driver);
		System.out.println(cont);
		driver.switchTo().alert().accept();

		// click on profile icon click on logout
		Addash.clickonprofileiconlogout();

		// enter as doctor

		String USERNAME1 = file.readdatafrompropertyfile("UsernameD1");
		String PASSWORD1 = file.readdatafrompropertyfile("PasswordD1");

		// login as doctor
		hp.clickonDoctorlink();

		DoctorLoginPage doctorlogin = new DoctorLoginPage(driver);
		doctorlogin.Doctorlogin(USERNAME1, PASSWORD1);

		wbd.Minimizethewindow(driver);
		driver.quit();
	}
}
