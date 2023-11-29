package adminmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Adminadddoctor {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondatahms.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String USERNAME = pobj.getProperty("UsernameA");
		String PASSWORD = pobj.getProperty("PasswordA");
		String URL = pobj.getProperty("Url");

	 WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	WebElement Adminlink = driver.findElement(By.xpath("//a[@href='hms/admin']"));
	Adminlink.click(); 
	
	Thread.sleep(500);
    WebElement Un = driver.findElement(By.name("username"));
    Un.sendKeys(USERNAME);
    WebElement Ps = driver.findElement(By.name("password"));
	Ps.sendKeys(PASSWORD);
	WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='submit']"));
	Loginbutton.click();
	
	
	//click on doctorsmodule
	WebElement doctors = driver.findElement(By.xpath("//span[text()=' Doctors ']"));
    doctors.click();
    
    //click on add doctor
    WebElement adddoctor = driver.findElement(By.xpath("//a[@href='add-doctor.php']"));
    adddoctor.click();
    
   FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\adddoctortestdata.xlsx");
   Workbook wb = WorkbookFactory.create(fis1);
   Sheet sh = wb.getSheet("Sheet1");
   String doctorspec = sh.getRow(0).getCell(1).getStringCellValue();
   
    //doctor specilization
   WebElement dsn = driver.findElement(By.name("Doctorspecialization"));
   Select sc = new Select(dsn);
   sc.selectByVisibleText(doctorspec);
   
   //add all other fields
    int count =sh.getLastRowNum();
 
  HashMap<String, String> hmap = new HashMap<String, String>();
  for(int i=1;i<=count;i++) {
	String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			hmap.put(key, value);
}
for (Entry<String, String> data:hmap.entrySet()) {
	driver.findElement(By.name(data.getKey())).sendKeys(data.getValue());
	
}
//click on submit button
WebElement submit = driver.findElement(By.name("submit"));
submit.click();

String cont = driver.switchTo().alert().getText();
System.out.println(cont);
driver.switchTo().alert().accept();

//click on profile icon
WebElement picon = driver.findElement(By.xpath("//i[@class='ti-angle-down']"));
picon.click();

//click on logout
WebElement logout = driver.findElement(By.xpath("//a[@href='logout.php']"));
logout.click();

//

pobj.load(fis);
String USERNAME1 = pobj.getProperty("UsernameD1");
String PASSWORD1 = pobj.getProperty("PasswordD1");


//login as doctor
WebElement Doctorlink = driver.findElement(By.xpath("//a[@href='hms/doctor/']"));
Doctorlink.click();

WebElement Un1 = driver.findElement(By.name("username"));
Un1.sendKeys(USERNAME1);
WebElement Ps1 = driver.findElement(By.name("password"));
Ps1.sendKeys(PASSWORD1);
WebElement Loginbutton2 = driver.findElement(By.xpath("//button[@name='submit']"));
Loginbutton2.click();




 
    

}}
