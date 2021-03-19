package com.actitime.generic;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * generic class for performing actions on the webelements
 * @author Supriya
 *
 */
public class MouseActionsLib {
	/**
	 * to move the mouse to desired webelement
	 * @param driver
	 * @param xpath
	 */
	public void getMouseMove(WebDriver driver, WebElement webelement ) {
		Actions a=new Actions(driver);
		 a.moveToElement(webelement).perform();
	}
	/**
	 * to perform double click on desired webelement
	 * @param driver
	 * @param xpath
	 */
	public void getDoubleClicked(WebDriver driver, WebElement webelement) {
		Actions a=new Actions(driver);
		a.doubleClick(webelement).perform();
	}
	/**
	 * to perform right click on desired webelement
	 * @param driver
	 * @param xpath
	 * @throws Exception
	 */
	public void getRightClicked(WebDriver driver, WebElement webelement) throws Exception {
		Actions a=new Actions(driver);
		a.contextClick(webelement).perform();
	}
	/**
	 * to perform drag and drop with desired webelement
	 * @param driver
	 * @param sxpath
	 * @param dxpath
	 */
	public void getElementDroped(WebDriver driver, WebElement source, WebElement destination) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source,destination).perform();
	}

}
