package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement UsernameA;
	@FindBy(name = "password")
	private WebElement PasswordA;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement LoginbtnA;

	public WebElement getUsernameA() {
		return UsernameA;
	}

	public WebElement getPasswordA() {
		return PasswordA;
	}

	public WebElement getLoginbtnA() {
		return LoginbtnA;
	}

	public void Adminlogin(String username, String password) {
		UsernameA.sendKeys(username);
		PasswordA.sendKeys(password);
		LoginbtnA.click();
	}
}
