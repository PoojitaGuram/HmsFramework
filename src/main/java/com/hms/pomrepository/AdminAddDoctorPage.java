package com.hms.pomrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.GenericUtils.ExcelUtils;
import com.hms.GenericUtils.JavaUtils;
import com.hms.GenericUtils.WebdriverUtils;

public class AdminAddDoctorPage extends WebdriverUtils {
	
	JavaUtils j=new JavaUtils();
	public AdminAddDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Doctorspecialization")
	private WebElement Doctorspecilization;

	@FindBy(name = "submit")
	private WebElement submitd;

	public WebElement getDoctorspecilization() {
		return Doctorspecilization;
	}

	public WebElement getSubmitd() {
		return submitd;
	}
	@FindBy(name ="docemail")
	private WebElement email;

	public WebElement getEmail() {
		return email;
	}

	

	public void enteralldoctordetails(WebDriver driver, HashMap<String, String> hmap, String DoctorSpecialization) throws Throwable {
		for (Entry<String, String> data : hmap.entrySet()) {
			WebElement elekey = driver.findElement(By.name(data.getKey()));
			elekey.sendKeys(data.getValue());
             
		}
		email.sendKeys("poo"+j.getRandomNo()+"@gmail.com");
		selectbyvisibletext(Doctorspecilization, DoctorSpecialization);
	  Thread.sleep(20000);
		submitd.click();

	}
}
