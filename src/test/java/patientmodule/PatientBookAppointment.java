package patientmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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

public class PatientBookAppointment {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//read data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondatahms.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("Url");
		String USERNAME = pobj.getProperty("UsernameP");
		String PASSWORD = pobj.getProperty("PasswordP");
		
		//
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
		//click on patient link
	    WebElement Patientlink = driver.findElement(By.xpath("//p[text()='Register & Book Appointment']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a[text()='Click Here']"));
	    Patientlink.click();
	    
	    //enter username
	    WebElement Un = driver.findElement(By.name("username"));
	    Un.sendKeys(USERNAME);
	    
	   // Enter password
		WebElement Ps = driver.findElement(By.name("password"));
		Ps.sendKeys(PASSWORD);
		
		//click on login button
	    WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='submit']"));
		Loginbutton.click();
		
		//click on bookapoointment module
		WebElement BookAppointment = driver.findElement(By.xpath("//span[text()=' Book Appointment ']"));
		BookAppointment.click();
		
		//enter the values in textfields by using excelsheet
		FileInputStream fis1 = new FileInputStream(".\\src\\main\\resources\\testdatapatient.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet1");
		int count =sh.getLastRowNum();
		
		//Enter the doctor specilization
		String DoctorSpecialization = sh.getRow(0).getCell(1).getStringCellValue();
		WebElement doctorspecilationdropdown = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
		Select sc = new Select(doctorspecilationdropdown);
	    sc.selectByVisibleText(DoctorSpecialization);
	    
	    //Enter doctors name
	    String Doctors = sh.getRow(1).getCell(1).getStringCellValue();
	   WebElement doctorsdropdown = driver.findElement(By.name("doctor"));
	   Select sc1 = new Select(doctorsdropdown);
	    sc1.selectByVisibleText(Doctors);
	    
	   //enter the date
	  WebElement date = driver.findElement(By.name("appdate"));
	  date.click();
	  
	  //click on next button
	  WebElement next = driver.findElement(By.xpath("//th[text()='November 2023']/following-sibling::th[@class='next']"));
	  next.click();
	  
	  //Thread.sleep();
	  //click on particular date
	  WebElement particulardate = driver.findElement(By.xpath("//th[text()='December 2023']/ancestor::div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']/descendant::td[text()='5']"));
	  particulardate.click();
	  
	 //click on time 
	 WebElement time = driver.findElement(By.xpath("//input[@id='timepicker1']"));
	 time.click();
	 
	 //select the time
	WebElement decrementhour = driver.findElement(By.xpath("//a[@data-action='decrementHour']"));
	WebElement decrementminute = driver.findElement(By.xpath("//a[@data-action='decrementMinute']"));
	WebElement togglemeridian = driver.findElement(By.xpath("//a[@data-action='toggleMeridian']"));
	
	Actions action = new Actions(driver);
    action.moveToElement(decrementhour).click().pause(Duration.ofSeconds(5)).moveToElement(decrementminute).click().pause(Duration.ofSeconds(5)).moveToElement(togglemeridian).click().build().perform();
	  
    //click on submit button
    WebElement submitbutton = driver.findElement(By.name("submit"));
    submitbutton.click();
    
    //handle the alert
    driver.switchTo().alert().accept();
    
    WebElement picon = driver.findElement(By.xpath("//i[@class='ti-angle-down']"));
    picon.click();
    
       WebElement logout = driver.findElement(By.xpath("//a[@href='logout.php']"));
		logout.click();
		
		
		
		
	}

}
