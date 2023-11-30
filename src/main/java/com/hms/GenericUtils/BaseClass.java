package com.hms.GenericUtils;

import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;

import com.hms.pomrepository.AdminLoginPage;
import com.hms.pomrepository.DoctorLoginPage;
import com.hms.pomrepository.HmsHomePage;
import com.hms.pomrepository.PatientLoginPage;
import com.hms.pomrepository.UserDashboardPage;

public class BaseClass {
public  WebDriver driver;
public DatabaseUtils dbu=new DatabaseUtils();
public ExcelUtils excel=new ExcelUtils();
public FileUtils fu=new FileUtils();
public JavaUtils ju=new JavaUtils();
public WebdriverUtils wbu=new WebdriverUtils();
public static WebDriver sdriver;


	@BeforeSuite(alwaysRun = true)
	public void config_bs() throws Throwable {
		
		dbu.connectDB();
		System.out.println("connect to database");
	}
	//@Parameters("browser1")
	@BeforeClass(alwaysRun = true)
public void config_bc() throws Throwable {
		
		String BROWSER=fu.readdatafrompropertyfile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
		   driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
	else
		System.out.println("not taking");
		sdriver=driver;
		}
	

	
	@BeforeMethod(alwaysRun = true)
public void config_bm() throws Throwable {
		System.out.println("browser is launched");
	 String URL = fu.readdatafrompropertyfile("Url");
 //String USERNAMEA = fu.readdatafrompropertyfile("UsernameA ");
 String USERNAMEP = fu.readdatafrompropertyfile("UsernameP");
// String USERNAMED = fu.readdatafrompropertyfile("UsernameD");
// String PASSWORDA = fu.readdatafrompropertyfile("PasswordA");
 String PASSWORDP = fu.readdatafrompropertyfile("PasswordP");
 //String PASSWORDD = fu.readdatafrompropertyfile("PasswordD");
 Thread.sleep(10000);
 
 driver.get(URL);
// sdriver=driver;
 wbu.Maximizethewindow(driver);
 wbu.implicitwait(driver, 5);
    HmsHomePage hmp =new HmsHomePage(driver);
     hmp.clickonPatientlink();
    //AdminLoginPage alp = new AdminLoginPage(driver);
	//alp.Adminlogin(USERNAMEA, PASSWORDA);	
	//DoctorLoginPage dlp = new DoctorLoginPage(driver);
	//dlp.Doctorlogin(USERNAMED, PASSWORDD);
	PatientLoginPage plp = new PatientLoginPage(driver);
	plp.Patientlogin(USERNAMEP, PASSWORDP);
	
	}
	@AfterMethod(alwaysRun = true)
public void config_am() {
		UserDashboardPage udbp = new UserDashboardPage(driver);
		udbp.clickonProfileicon();
		
	}
	@AfterClass(alwaysRun = true)
public void config_ac() {
		wbu.Minimizethewindow(driver);
		
		driver.quit();
	}


	@AfterSuite(alwaysRun = true)
public void config_as() throws Throwable {
		dbu.disconnectDB();
		System.out.println("disconnect from database");
	}

}

