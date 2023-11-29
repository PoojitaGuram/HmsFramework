package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Doctors ']")
	private WebElement DoctorM_btn;

	@FindBy(xpath = "//a[@href='add-doctor.php']")
	private WebElement adddoctor_btn;

	@FindBy(xpath = "//a[@href='manage-doctors.php']")
	private WebElement Totaldoctorlink;

	@FindBy(xpath = "//i[@class='ti-angle-down']")
	private WebElement Profileicona;

	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logouta;

	@FindBy(xpath = "//a[@href='change-password.php']")
	private WebElement changepassworda;

	@FindBy(xpath = "//span[text()=' Manage Doctors ']")
	private WebElement manage_btn;

	public WebElement getManage_btn() {
		return manage_btn;
	}

	public WebElement getDoctorM_btn() {
		return DoctorM_btn;
	}

	public WebElement getAdddoctor_btn() {
		return adddoctor_btn;
	}

	public WebElement getTotaldoctorlink() {
		return Totaldoctorlink;
	}

	public WebElement getProfileicona() {
		return Profileicona;
	}

	public WebElement getLogouta() {
		return logouta;
	}

	public WebElement getChangepassworda() {
		return changepassworda;
	}

	public void clickondoctoradddoctor() {
		DoctorM_btn.click();
		adddoctor_btn.click();
	}

	public void clickontotaldoctorlink() {
		Totaldoctorlink.click();
	}

	public void clickonprofileiconlogout() {
		Profileicona.click();
		logouta.click();
	}

	public void clickondoctclikonmanagedoctor() {
		DoctorM_btn.click();
		manage_btn.click();
	}

	public void clickonprofileiconchangepass() {
		Profileicona.click();
		changepassworda.click();
	}

}
