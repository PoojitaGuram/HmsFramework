package com.hms.patientmodule;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hms.GenericUtils.BaseClass;
import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.FileUtils;
import com.hms.GenericUtils.ListnerImplementationClass;
import com.hms.GenericUtils.WebdriverUtils;
import com.hms.pomrepository.HmsHomePage;
import com.hms.pomrepository.PatientLoginPage;
import com.hms.pomrepository.UserBookAppointmentPage;
import com.hms.pomrepository.UserDashboardPage;

//@Listeners(ListnerImplementationClass.class)
public class PatientBookAppointmentbasetest extends BaseClass
 {
	@Test()
	public void test1() throws Throwable, IOException {
		
		// click on bookapoointment module
		UserDashboardPage udp = new UserDashboardPage(driver);
		Assert.fail();
		udp.clickonBookAppointmentPM();

		// Enter the doctor specilization
		String DoctorSpecialization = excel.readDataFromExceltest1("testdatapatientSheet4", 0, 1);

		// Enter doctors name
		String Doctors = excel.readDataFromExceltest1("testdatapatientSheet4", 1, 1);

		// enter all the details
		UserBookAppointmentPage ubap = new UserBookAppointmentPage(driver);
		ubap.Enteralldetails(DoctorSpecialization, driver, 5, Doctors);
          
		//
		String message = wbu.alertText(driver);
		System.out.println(message);
		// handle the alert
		wbu.alertAccept(driver);

		


	}

}
