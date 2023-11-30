package com.hms.doctormodule;

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
import org.testng.annotations.Test;

import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.FileUtils;
import com.hms.GenericUtils.WebdriverUtils;
import com.hms.pomrepository.DAddMedicalHistory;
import com.hms.pomrepository.DoctorDashboardPage;
import com.hms.pomrepository.DoctorLoginPage;
import com.hms.pomrepository.DoctorManagePatientPage;
import com.hms.pomrepository.HmsHomePage;
import com.hms.pomrepository.PatientLoginPage;
import com.hms.pomrepository.UserDashboardPage;

public class Doctoraddpatienttest {
   
	@Test
	public  void doctortest() throws Throwable {
		ExcelUtils excel = new ExcelUtils();
		FileUtils file = new FileUtils();
		WebdriverUtils wbd = new WebdriverUtils();
		// read data from property file

		String URL = file.readdatafrompropertyfile("Url");
		String USERNAME = file.readdatafrompropertyfile("UsernameD");
		String PASSWORD = file.readdatafrompropertyfile("PasswordD");
		WebDriver driver = new ChromeDriver();
		wbd.Maximizethewindow(driver);
		driver.get(URL);
		wbd.implicitwait(driver, 5);

		// click on doctor link
		HmsHomePage hp = new HmsHomePage(driver);
		hp.clickonDoctorlink();

		// enter username Enter password click on login button
		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		dlp.Doctorlogin(USERNAME, PASSWORD);

		// click on patient click on manage patient
		DoctorDashboardPage dds = new DoctorDashboardPage(driver);
		dds.clickonpatientthenclickonmage();

		// click on eyeicon medical history
		DoctorManagePatientPage dmp = new DoctorManagePatientPage(driver);
		dmp.clickoneyeicon();

		dmp.clickonmedicalhistory();

		// add all the medical history //click on submit

		DAddMedicalHistory damh = new DAddMedicalHistory(driver);
		damh.addMedicalhistory(driver, excel.readmultipledatafromthExcelsheet1("MedicalHistorySheet1"));

		String cm = wbd.alertText(driver);
		System.out.println(cm);
		wbd.alertAccept(driver);

		// profileicon logout
		dds.clickoniconlogout();

		String USERNAME1 = file.readdatafrompropertyfile("UsernameJ");
		String PASSWORD1 = file.readdatafrompropertyfile("PasswordJ");
		// click on patient link
		hp.clickonPatientlink();
		PatientLoginPage plp = new PatientLoginPage(driver);
		plp.Patientlogin(USERNAME1, PASSWORD1);

		UserDashboardPage udp = new UserDashboardPage(driver);
		udp.clickonUpdateMedicalHistoryP();

		wbd.Minimizethewindow(driver);
		driver.quit();

	}

}
