package com.hms.patientmodule;

import static org.testng.Assert.expectThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.FileUtils;
import com.hms.GenericUtils.WebdriverUtils;
import com.hms.pomrepository.HmsHomePage;
import com.hms.pomrepository.PatientLoginPage;
import com.hms.pomrepository.UserDashboardPage;
import com.hms.pomrepository.UserEditProfilePage;

public class Patientupdateprofiletest {

	public static void main(String[] args) throws Throwable {
		ExcelUtils excel = new ExcelUtils();
		FileUtils file = new FileUtils();
		WebdriverUtils wbd = new WebdriverUtils();

		String URL = file.readdatafrompropertyfile("Url");
		String USERNAME = file.readdatafrompropertyfile("UsernameP");
		String PASSWORD = file.readdatafrompropertyfile("PasswordP");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		wbd.Maximizethewindow(driver);
		wbd.implicitwait(driver, 5);
		// click on patient link
		HmsHomePage hp = new HmsHomePage(driver);
		hp.clickonPatientlink();

		// enter username pass.login
		PatientLoginPage plp = new PatientLoginPage(driver);
		plp.Patientlogin(USERNAME, PASSWORD);

		// clcik on update link
		UserDashboardPage udp = new UserDashboardPage(driver);
		udp.clickonUpdateProfilelinkP();

	

		// change the city
		UserEditProfilePage uepp = new UserEditProfilePage(driver);
		uepp.changecitynameandclickonupdate();

		// confirmation

		String Expectedmessage = "\r\n" + "Your Profile updated Successfully ";

		//WebElement confirmationmessage = driver.findElement(By.xpath("//h5[@style='color: green; font-size:18px; ']"));
		WebElement confirmationmessage = uepp.getConfirmmsg();
		String cm = confirmationmessage.getText();
		if (Expectedmessage.contains(cm)) {
			System.out.println("profile updated");
		} else
			System.out.println("profile not updated");

		// click on pi and logout
		udp.clickonProfileicon();

		hp.clickonPatientlink();

		plp.Patientlogin(USERNAME, PASSWORD);
		// clcik on update link
		udp.clickonUpdateProfilelinkP();

		String previouscity = "banglore";
		WebElement city2 = uepp.getCity_textfield();
		String changedcityname = city2.getText();
		Assert.assertNotEquals(previouscity,changedcityname,"city not updated");
		System.out.println("city updated");
		
		/*if (previouscity.equals(changedcityname)) {
			System.out.println("city not updated");
		} else {
			System.out.println("city updated");
		}*/
		wbd.Minimizethewindow(driver);
		driver.quit();
	}

}
