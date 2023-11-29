package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage {
	public DoctorDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patientsMd;

	@FindBy(xpath = "//span[text()=' Manage Patient ']")
	private WebElement managepatient;

	@FindBy(xpath = "//i[@class='ti-angle-down']")
	private WebElement profileicon;

	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logout;

	public WebElement getPatientsMd() {
		return patientsMd;
	}

	public WebElement getManagepatient() {
		return managepatient;
	}

	public void clickonpatientthenclickonmage() {
		patientsMd.click();
		managepatient.click();
	}

	public void clickoniconlogout() {
		profileicon.click();
		logout.click();
	}
}
