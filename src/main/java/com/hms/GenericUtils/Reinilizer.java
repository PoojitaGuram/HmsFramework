package com.hms.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Reinilizer {
	public  WebDriver driver;
	public DatabaseUtils dbu=new DatabaseUtils();
	public ExcelUtils excel=new ExcelUtils();
	public FileUtils fu=new FileUtils();
	public JavaUtils ju=new JavaUtils();
	public WebdriverUtils wbu=new WebdriverUtils();
	public static WebDriver sdriver;

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
	@AfterClass(alwaysRun = true)
	public void config_ac() {
			wbu.Minimizethewindow(driver);
			
			driver.quit();
		}

}
