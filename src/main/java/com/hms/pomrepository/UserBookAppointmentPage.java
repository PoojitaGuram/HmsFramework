package com.hms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.GenericUtils.WebdriverUtils;

public class UserBookAppointmentPage extends WebdriverUtils{
	public  UserBookAppointmentPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
		private WebElement DoctorSpecilization_txt;
	
		@FindBy(name ="doctor")
		private WebElement Doctorname_txt;
		
		@FindBy(name ="appdate")
		private WebElement Date_btn;
		
		@FindBy(xpath = "//th[text()='November 2023']/following-sibling::th[@class='next']")
		private WebElement next_btn;
		
		@FindBy(xpath = "//th[text()='December 2023']/ancestor::div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']/descendant::td[text()='5']")
		private WebElement Particular_date;
		
	
		@FindBy(xpath = "//input[@id='timepicker1']")
		private WebElement time_btn;
		
		@FindBy(xpath = "//a[@data-action='decrementHour']")
		private WebElement decrementhour_btn;
		
		@FindBy(xpath = "//a[@data-action='decrementMinute']")
		private WebElement decrementminute_btn;
		
	
		@FindBy(xpath = "//a[@data-action='toggleMeridian']")
		private WebElement toggleMeridian_btn;
		
		@FindBy(name =   "submit")
		private WebElement submit_btn;

		public WebElement getDoctorSpecilization_txt() {
			return DoctorSpecilization_txt;
		}

		public WebElement getDoctorname_txt() {
			return Doctorname_txt;
		}

		public WebElement getDate_btn() {
			return Date_btn;
		}

		public WebElement getNext_btn() {
			return next_btn;
		}

		public WebElement getParticular_date() {
			return Particular_date;
		}

		public WebElement getTime_btn() {
			return time_btn;
		}

		public WebElement getDecrementhour_btn() {
			return decrementhour_btn;
		}

		public WebElement getDecrementminute_btn() {
			return decrementminute_btn;
		}

		public WebElement getToggleMeridian_btn() {
			return toggleMeridian_btn;
		}

		public WebElement getSubmit_btn() {
			return submit_btn;
		}
		public void Enteralldetails(String DoctorSpecialization ,WebDriver driver,long sec ,String Doctors ) {
			selectbyvisibletext( DoctorSpecilization_txt,DoctorSpecialization );
			selectbyvisibletext(Doctorname_txt, Doctors);
			Date_btn.click();
			next_btn.click();
			Particular_date.click();
			time_btn.click();
			movetoelement(driver, decrementhour_btn, sec);
			movetoelement(driver,decrementminute_btn , sec);
			movetoelement(driver, toggleMeridian_btn, sec);
			submit_btn.click();
			
		}
		
}
