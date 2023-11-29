package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
	public PatientLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement UsernameP;
	@FindBy(name = "password")
	private WebElement PasswordP;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement LoginbtnP;

	public WebElement getUsernameP() {
		return UsernameP;
	}

	public WebElement getPasswordP() {
		return PasswordP;
	}

	public WebElement getLoginbtnP() {
		return LoginbtnP;
	}

	public void Patientlogin(String usernamep, String passwordp) {
		UsernameP.sendKeys(usernamep);
		PasswordP.sendKeys(passwordp);
		LoginbtnP.click();

	}
}
