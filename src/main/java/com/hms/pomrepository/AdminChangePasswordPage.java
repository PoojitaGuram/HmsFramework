package com.hms.pomrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminChangePasswordPage {
	public  AdminChangePasswordPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "submit")
	private WebElement submitbutton;
	
	@FindBy(xpath = "//p[@style='color:red;']")
	private WebElement congirmmsg;
	
	public WebElement getCongirmmsg() {
		return congirmmsg;
	}


	public WebElement getSubmitbutton() {
		return submitbutton;
	}


	public void changepassword(WebDriver driver,	HashMap<String, String> hmap) {
	
		for (Entry<String, String> data:hmap.entrySet()) {
			driver.findElement(By.name(data.getKey())).sendKeys(data.getValue());
			
		}
		submitbutton.click();
	}
	
	
}

	

