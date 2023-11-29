package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorManagePatientPage {
	public DoctorManagePatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='view-patient.php?viewid=322']/i[@class='fa fa-eye']")
	private WebElement eyeicon;

	@FindBy(xpath = "//button[@class='btn btn-primary waves-effect waves-light w-lg']")
	private WebElement medicalhistory_btn;

	public WebElement getMedicalhistory_btn() {
		return medicalhistory_btn;
	}

	public WebElement getEyeicon() {
		return eyeicon;
	}

	public void clickoneyeicon() {
		eyeicon.click();
	}

	public void clickonmedicalhistory() {
		medicalhistory_btn.click();
	}
}
