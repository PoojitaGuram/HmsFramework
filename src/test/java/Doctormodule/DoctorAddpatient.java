package Doctormodule;

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

public class DoctorAddpatient {

	public static void main(String[] args) throws IOException, InterruptedException {
		//read data from property file
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondatahms.properties");
				Properties pobj = new Properties();
				pobj.load(fis);
				String URL = pobj.getProperty("Url");
				String USERNAME = pobj.getProperty("UsernameD");
				String PASSWORD = pobj.getProperty("PasswordD");
				
				//
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(URL);
			
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				
				//click on doctor link
			    WebElement Doctorlink= driver.findElement(By.xpath("//a[@href='hms/doctor/']"));
			    Doctorlink.click();
			    
			    //enter username
			    WebElement Un = driver.findElement(By.name("username"));
			    Un.sendKeys(USERNAME);
			    
			   // Enter password
				WebElement Ps = driver.findElement(By.name("password"));
				Ps.sendKeys(PASSWORD);
				
				//click on login button
			    WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='submit']"));
				Loginbutton.click();
				
				WebElement patients = driver.findElement(By.xpath("//span[text()=' Patients ']"));
				patients.click();
				
				
				WebElement managepatient = driver.findElement(By.xpath("//span[text()=' Manage Patient ']"));
				Thread.sleep(500);
				managepatient.click();
				
				WebElement eyeicon = driver.findElement(By.xpath("//a[@href='view-patient.php?viewid=322']/i[@class='fa fa-eye']"));
				eyeicon.click();
				
				WebElement medicalhis = driver.findElement(By.xpath("//button[@class='btn btn-primary waves-effect waves-light w-lg']"));
				medicalhis.click();
				
				//add all the medical history
				 FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\mediclhistorypatient.xlsx");
				   Workbook wb = WorkbookFactory.create(fis1);
				   Sheet sh = wb.getSheet("Sheet1");
				   int count=sh.getLastRowNum();
				   HashMap<String, String> hmap = new HashMap<String, String>();
				   for(int i=0;i<=count;i++) {
				 	String key=sh.getRow(i).getCell(0).getStringCellValue();
				 			String value=sh.getRow(i).getCell(1).getStringCellValue();
				 			hmap.put(key, value);
				 }
				 for (Entry<String, String> data:hmap.entrySet()) {
				 	driver.findElement(By.name(data.getKey())).sendKeys(data.getValue());
				 }
				//click on submit
				WebElement submit = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
				
				submit.click();
				
				String cm = driver.switchTo().alert().getText();
				System.out.println(cm);
				driver.switchTo().alert().accept();
				driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
				driver.findElement(By.xpath("//a[@href='logout.php']")).click();
				
				String USERNAME1 = pobj.getProperty("UsernameJ");
				String PASSWORD1 = pobj.getProperty("PasswordJ");
				 WebElement Patientlink = driver.findElement(By.xpath("//p[text()='Register & Book Appointment']/ancestor::div[@class='listview_1_of_3 images_1_of_3']/descendant::a[text()='Click Here']"));
				    Patientlink.click();
				    
				    //enter username
				    WebElement Un1 = driver.findElement(By.name("username"));
				    Un1.sendKeys(USERNAME1);
				    
				   // Enter password
					WebElement Ps1 = driver.findElement(By.name("password"));
					Ps1.sendKeys(PASSWORD1);
					
					//click on login button
				    WebElement Loginbutton1 = driver.findElement(By.xpath("//button[@name='submit']"));
					Loginbutton1.click();
					
					driver.findElement(By.xpath("//span[text()=' Medical History ']")).click();

	}

	}

