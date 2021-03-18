package com.actitime.testscripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

public class CreateCustomer extends BaseClass {

	@Test
	public void testCreateCustomer() throws Exception {
		FileLib fl = new FileLib();
		String ExpectedCustName = fl.getExcelValue("CreateCustomerData", 1, 0);
		String ExpectedCustDescription = fl.getExcelValue("CreateCustomerData", 1, 1);
		HomePage h=new HomePage(driver);
		h.getTaskslink().click();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewdrpdwn().click();
		t.getNewCustomerOption().click();
		t.getEnterCustomerNametbx().sendKeys(ExpectedCustName);
		t.getEnterCustomerDescriptiontbx().sendKeys(ExpectedCustDescription);
		t.getSelectCustdrpdwn().click();
		t.getOurCompanyOption().click();
		t.getCreateCustomerbtn().click();
		Thread.sleep(5000);
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(t.getTitleDisplayed()));*/
		String actualCustName = t.getTitleDisplayed().getText();
		Assert.assertEquals(actualCustName,ExpectedCustName);
	}

}
