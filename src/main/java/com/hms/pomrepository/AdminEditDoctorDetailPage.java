package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminEditDoctorDetailPage {
	public AdminEditDoctorDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "docfees")
	private WebElement consultancyfees;

	@FindBy(name = "submit")
	private WebElement update_btn;
	
	@FindBy(xpath = "//h5[@style='color: green; font-size:18px; ']")
	private WebElement confirmmsg;

	public WebElement getConfirmmsg() {
		return confirmmsg;
	}

	public WebElement getConsultancyfees() {
		return consultancyfees;
	}

	public WebElement getUpdate_btn() {
		return update_btn;
	}

	public void changefeesandclickupdate(String value) {
		consultancyfees.clear();
		consultancyfees.sendKeys(value);
		
		update_btn.click();
	}

}
