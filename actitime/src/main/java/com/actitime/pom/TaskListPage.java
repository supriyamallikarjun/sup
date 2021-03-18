package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addNewdrpdwn;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newCustomerOption;
	
	@FindBy(xpath = "//input[@placeholder='Enter Customer Name' and @autocomplete='off']")
	private WebElement enterCustomerNametbx;
	
	@FindBy(xpath = "//textarea[@placeholder=\'Enter Customer Description\']")
	private WebElement enterCustomerDescriptiontbx;
	
	@FindBy(xpath = "//div[@class='emptySelection']")
	private WebElement selectCustdrpdwn;
	
	@FindBy(xpath = "//div[text()='Our company' and @class='itemRow cpItemRow ']")
	private WebElement ourCompanyOption;
	
	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement CreateCustomerbtn;
	
	@FindBy(xpath = "//div[@class=\"titleEditButtonContainer\"]/div[@class='title']")
	private WebElement titleDisplayed;
	
	@FindBy(linkText = "Logout")
	private WebElement lgoutbtn;

	public TaskListPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddNewdrpdwn() {
		return addNewdrpdwn;
	}
	public WebElement getLgoutbtn() {
		return lgoutbtn;
	}

	public WebElement getNewCustomerOption() {
		return newCustomerOption;
	}

	public WebElement getEnterCustomerNametbx() {
		return enterCustomerNametbx;
	}

	public WebElement getEnterCustomerDescriptiontbx() {
		return enterCustomerDescriptiontbx;
	}

	public WebElement getSelectCustdrpdwn() {
		return selectCustdrpdwn;
	}

	public WebElement getOurCompanyOption() {
		return ourCompanyOption;
	}

	public WebElement getCreateCustomerbtn() {
		return CreateCustomerbtn;
	}

	public WebElement getTitleDisplayed() {
		return titleDisplayed;
	}
	
}

