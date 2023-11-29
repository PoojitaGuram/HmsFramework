package adminmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hms.GenericUtils.IPathConstant;

public class Adminchangepassword {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//read data from excel sheet
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
	
	//click on profile icon
	
	WebElement profileicon = driver.findElement(By.xpath("//i[@class='ti-angle-down']"));
	profileicon.click();
	
	
	//click on change password
	WebElement changepassword = driver.findElement(By.xpath("//a[@href='change-password.php']"));
	changepassword.click();
	
	//enter all details
	WebElement currentpassword = driver.findElement(By.name("cpass"));
	currentpassword.sendKeys("Test@12345");
	
	WebElement newpassword = driver.findElement(By.name("npass"));
	newpassword.sendKeys("Test@12345");
	
	
	WebElement confirmpassword = driver.findElement(By.name("cfpass"));
	confirmpassword.sendKeys("Test@12345");
	/*
	 public void readmultipledatafromthExcelsheet(String sheetname,WebDriver driver) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count=sh.getLastRowNum();
		HashMap<String, String> hmap = new HashMap<String, String>();
		for(int i =0;i<=count;i++) {
			String Key=sh.getRow(i).getCell(0).getStringCellValue();
			String Value=sh.getRow(i).getCell(1).getStringCellValue();
			hmap.put(Key, Value);
			
		}
		for (Entry<String, String> data:hmap.entrySet()) {
			driver.findElement(By.name(data.getKey())).sendKeys(data.getValue());
			
		
}

	 */
	
	WebElement submit = driver.findElement(By.name("submit"));
	submit.click();
	
	
	String expectedtext ="Password Changed Successfully !!								";
	WebElement confirmess = driver.findElement(By.xpath("//p[@style='color:red;']"));
	String confirm = confirmess.getText();
	if(confirm.equalsIgnoreCase(confirm)) {
		System.out.println("password confirmed");
		
	}
	else {
		System.out.println("password is empty");
	}
	
	driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		WebElement logout = driver.findElement(By.xpath("//a[@href='logout.php']"));
	logout.click();
	
	
	 

	}

}
