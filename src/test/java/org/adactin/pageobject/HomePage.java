package org.adactin.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "New User Register Here")
	private WebElement newuser;



		public WebElement getNewuser() {
		return newuser;
		
	}	
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
	}
}
