package adminmodule;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassSpecificReferenceForm;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Admineditdoctordetails {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondatahms.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String USERNAME = pobj.getProperty("UsernameA");
		String PASSWORD = pobj.getProperty("PasswordA");
		String URL = pobj.getProperty("Url");

		
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebElement Adminlink = driver.findElement(By.xpath("//a[@href='hms/admin']"));
	Adminlink.click();
	
    WebElement Un = driver.findElement(By.name("username"));
    Un.sendKeys(USERNAME);
    WebElement Ps = driver.findElement(By.name("password"));
	Ps.sendKeys(PASSWORD);
	WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='submit']"));
	Loginbutton.click();
	
	//click on totaldoctorlink
	WebElement totaldoctorlink = driver.findElement(By.xpath("//a[@href='manage-doctors.php']"));
	totaldoctorlink.click();
	
	WebElement penclikicon = driver.findElement(By.xpath("//a[@href='edit-doctor.php?id=3']/i[@class='fa fa-pencil']"));
	penclikicon.click();
	
	FileInputStream fis1 = new FileInputStream(".\\src\\main\\resources\\consultancyfeesteaddata.xlsx");
    Workbook wb = WorkbookFactory.create(fis1);
    Sheet sh = wb.getSheet("Sheet1");
   String value = sh.getRow(0).getCell(1).getStringCellValue();
   WebElement doctorconsultancy = driver.findElement(By.name("docfees"));
   doctorconsultancy.click();
   doctorconsultancy.clear();
   doctorconsultancy.sendKeys(value);
   
 WebElement update = driver.findElement(By.name("submit"));
 update.click();
 
 String expectedmess ="Doctor Details updated Successfully";
 	
WebElement confirmm = driver.findElement(By.xpath("//h5[@style='color: green; font-size:18px; ']"));
    String actualmess = confirmm.getText();
    if(actualmess.equals(expectedmess)) {
    	System.out.println("doctor details changed");
    }
    else {
    	System.out.println("doctor detilas not changed");
    }
    
    //click on doctor module
    WebElement doctors = driver.findElement(By.xpath("//span[text()=' Doctors ']"));
    doctors.click();
  
       //
    WebElement managedoctors = driver.findElement(By.xpath("//span[text()=' Manage Doctors ']"));
    managedoctors.click();
    
    WebElement penclikicon1 = driver.findElement(By.xpath("//a[@href='edit-doctor.php?id=3']/i[@class='fa fa-pencil']"));
	penclikicon1.click();
	
WebElement ucf1 = driver.findElement(By.xpath("//input[@name='docfees']"));
String actualconsultancy = ucf1.getAttribute("value");
if(actualconsultancy.equals(value)) {
	System.out.println("doctor updated");
	
}
else
	System.out.println("doctor not updated");

	
	
	
	
  
  
   
	
	}

}
