package com.hms.adminmodule;

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
import org.testng.annotations.Test;

import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.FileUtils;
import com.hms.GenericUtils.WebdriverUtils;
import com.hms.pomrepository.AdminDashboardPage;
import com.hms.pomrepository.AdminDoctorManagePage;
import com.hms.pomrepository.AdminEditDoctorDetailPage;
import com.hms.pomrepository.AdminLoginPage;
import com.hms.pomrepository.HmsHomePage;

public class Admineditdocyordetailstest {
@Test
	public void adminedit() throws Throwable {
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
		
		AdminLoginPage lpa = new AdminLoginPage(driver);
		lpa.Adminlogin(USERNAME, PASSWORD);
		
		// click on totaldoctorlink
		AdminDashboardPage dba = new AdminDashboardPage(driver);
		dba.clickontotaldoctorlink();

        //click on pencil icon
		AdminDoctorManagePage admdoctormanage = new AdminDoctorManagePage(driver);
          admdoctormanage.clickonpencilicon();
	//Thread.sleep(5000);
          //enter all details and update
          String fees= excel.readDataFromExceltest1("consultancyfeesSheet3", 0, 1);
             AdminEditDoctorDetailPage admeditdoc = new AdminEditDoctorDetailPage(driver);
              admeditdoc.changefeesandclickupdate(fees);
	
		String expectedmess = "Doctor Details updated Successfully";

		
	   WebElement confirmm = admeditdoc.getConfirmmsg();
		String actualmess = confirmm.getText();
		if (actualmess.equals(expectedmess)) {
			System.out.println("doctor details changed");
		} else {
			System.out.println("doctor detilas not changed");
		}

		// click on doctor module and click on manage doctors
		dba.clickondoctclikonmanagedoctor();
		//click on penciliconF
		admdoctormanage.clickonpencilicon();
		


	WebElement ucf1 = driver.findElement(By.xpath("//input[@name='docfees']"));
		//WebElement ucf1 = admeditdoc.getConsultancyfees();
		
		String actualconsultancy = ucf1.getAttribute("value");
		if (actualconsultancy.equals(fees)) {
			System.out.println("doctor updated");

		} else
			System.out.println("doctor not updated");
		wbd.Maximizethewindow(driver);
		driver.quit();

	}

}
