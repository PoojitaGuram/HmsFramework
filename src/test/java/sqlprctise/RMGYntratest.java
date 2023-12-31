package sqlprctise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYntratest {

	 
	 
	public static void main(String[] args) throws Throwable {
		 Connection con=null;
		 String expecteddata="project7";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
    driver.get("http://rmgtestingserver:8084/");
    driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
    driver.findElement(By.xpath("//span[text()='Create Project']")).click();
    
    driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expecteddata);
    driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Deepak");
    WebElement status = driver.findElement(By.xpath("//select[@name='status']"));
    Select sel = new Select(status);
    sel.selectByValue("Created");
    driver.findElement(By.xpath("//input[@value='Add Project']")).click();
 
     Driver driver2 = new Driver();
     DriverManager.registerDriver(driver2);
     
     con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
     
   Statement state = con.createStatement();
   String query="select project_name from project where project_name='"+expecteddata+"';";
   ResultSet result = state.executeQuery(query);
   
   boolean flag=false;
   while(result.next()) {
	  String actualprojname = result.getString(1);
	   if(actualprojname.equals(expecteddata)) {
		System.out.println("project got created");
		   flag=true;
	   }
	   if(!flag) {
		   System.out.println("project not created");
	   }
   }
   
    con.close();
	}

}
