package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboardPage {
	public UserDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[@class='links cl-effect-1']/a[@href='edit-profile.php']")
	private WebElement updateprofilelink;

	@FindBy(xpath = "//span[text()=' Book Appointment ']")
	private WebElement BookappointmentPM;

	@FindBy(xpath = "//span[text()=' Medical History ']")
	private WebElement MedicalHitoryPM;

	@FindBy(xpath = "//i[@class='ti-angle-down']")
	private WebElement Profileiconp;

	public WebElement getUpdateprofilelink() {
		return updateprofilelink;
	}

	public WebElement getBookappointmentPM() {
		return BookappointmentPM;
	}

	public WebElement getMedicalHitoryPM() {
		return MedicalHitoryPM;
	}

	public WebElement getProfileiconp() {
		return Profileiconp;
	}

	public WebElement getLogoutp() {
		return logoutp;
	}

	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logoutp;

	public void clickonUpdateProfilelinkP() {
		updateprofilelink.click();
	}

	public void clickonBookAppointmentPM() {
		BookappointmentPM.click();
	}

	public void clickonUpdateMedicalHistoryP() {
		MedicalHitoryPM.click();
	}

	public void clickonProfileicon() {
		Profileiconp.click();
		logoutp.click();

	}

}
