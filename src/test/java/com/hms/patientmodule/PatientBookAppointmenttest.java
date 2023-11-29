package com.hms.patientmodule;

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
import com.hms.pomrepository.HmsHomePage;
import com.hms.pomrepository.PatientLoginPage;
import com.hms.pomrepository.UserBookAppointmentPage;
import com.hms.pomrepository.UserDashboardPage;

public class PatientBookAppointmenttest {

	public static void main(String[] args) throws Throwable {
		ExcelUtils excel = new ExcelUtils();
		FileUtils file = new FileUtils();
		WebdriverUtils wbd = new WebdriverUtils();

		String URL = file.readdatafrompropertyfile("Url");
		String USERNAME = file.readdatafrompropertyfile("UsernameP");
		String PASSWORD = file.readdatafrompropertyfile("PasswordP");

		WebDriver driver = new ChromeDriver();
		wbd.Maximizethewindow(driver);
		driver.get(URL);
		wbd.implicitwait(driver, 5);

		// click on patient link
		HmsHomePage hp = new HmsHomePage(driver);
		hp.clickonPatientlink();

		// enter username Enter password login button
		PatientLoginPage plp = new PatientLoginPage(driver);
		plp.Patientlogin(USERNAME, PASSWORD);

		// click on bookapoointment module
		UserDashboardPage udp = new UserDashboardPage(driver);
		udp.clickonBookAppointmentPM();

		// Enter the doctor specilization
		String DoctorSpecialization = excel.readDataFromExceltest1("testdatapatientSheet4", 0, 1);

		// Enter doctors name
		String Doctors = excel.readDataFromExceltest1("testdatapatientSheet4", 1, 1);

		// enter all the details
		UserBookAppointmentPage ubap = new UserBookAppointmentPage(driver);
		ubap.Enteralldetails(DoctorSpecialization, driver, 5, Doctors);

		//
		String message = wbd.alertText(driver);
		System.out.println(message);
		// handle the alert
		wbd.alertAccept(driver);

		// picon and logout
		udp.clickonProfileicon();

		wbd.Minimizethewindow(driver);
		driver.quit();

	}

}
