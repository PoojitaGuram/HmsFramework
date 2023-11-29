package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDoctorManagePage {
	public AdminDoctorManagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='edit-doctor.php?id=3']/i[@class='fa fa-pencil']")

	private WebElement pencilicon;

	public WebElement getPencilicon() {
		return pencilicon;
	}

	public void clickonpencilicon() {
		pencilicon.click();
	}
}
