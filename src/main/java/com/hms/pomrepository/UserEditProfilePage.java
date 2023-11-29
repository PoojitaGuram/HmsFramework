package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserEditProfilePage {
	public UserEditProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "city")
	private WebElement city_textfield;
	
	public WebElement getConfirmmsg() {
		return confirmmsg;
	}
	
	public void setConfirmmsg(WebElement confirmmsg) {
		this.confirmmsg = confirmmsg;
	}

	@FindBy(xpath = "//h5[@style='color: green; font-size:18px; ']")
	private WebElement confirmmsg;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement update_btn;

	public WebElement getCity_textfield() {
		return city_textfield;
	}

	public WebElement getUpdate_btn() {
		return update_btn;
	}

	public void changecitynameandclickonupdate() {
		city_textfield.clear();
		city_textfield.sendKeys("pune");
		update_btn.click();
	}

}
