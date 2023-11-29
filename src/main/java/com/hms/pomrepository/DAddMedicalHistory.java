package com.hms.pomrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DAddMedicalHistory {
	public DAddMedicalHistory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement submit_btn;

	public WebElement getSubmit_btn() {
		return submit_btn;
	}

	public void addMedicalhistory(WebDriver driver, HashMap<String, String> hmap) {

		for (Entry<String, String> data : hmap.entrySet()) {
			driver.findElement(By.name(data.getKey())).sendKeys(data.getValue());

		}
		submit_btn.click();

	}

}
