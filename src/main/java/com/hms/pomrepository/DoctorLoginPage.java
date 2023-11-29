package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {
	public  DoctorLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
		@FindBy(name = "username")
		private WebElement UsernameD;
		@FindBy(name = "password")
		private WebElement PasswordD;
		@FindBy(xpath = "//button[@name='submit']")
		private WebElement LoginbtnD;
		public WebElement getUsernameP() {
			return UsernameD;
		}
		public WebElement getPasswordP() {
			return PasswordD;
		}
		public WebElement getLoginbtnP() {
			return LoginbtnD;
		}
		
		public void Doctorlogin(String usernamed ,String passwordd) {
			UsernameD.sendKeys(usernamed);
			PasswordD.sendKeys(passwordd);
			LoginbtnD.click();
			
	}
}
