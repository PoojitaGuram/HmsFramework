package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HmsHomePage {

	public HmsHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='hms/admin']")
	private WebElement adminlink;
	@FindBy(xpath = "//a[@href='hms/doctor/']")
	private WebElement doctorlink;
	@FindBy(xpath = "//a[@href='hms/user-login.php']")
	private WebElement patientlink;

	public WebElement getAdminlink() {
		return adminlink;
	}

	public WebElement getDoctorlink() {
		return doctorlink;
	}

	public WebElement getPatientlink() {
		return patientlink;
	}

	public void clickonadminlink() {
		adminlink.click();
	}

	public void clickonPatientlink() {
		patientlink.click();
	}

	public void clickonDoctorlink() {
		doctorlink.click();
	}
}
