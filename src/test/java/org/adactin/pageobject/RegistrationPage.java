package org.adactin.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	@FindBy(name = "username")
	private WebElement username;
	
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmpassword() {
		return confirmpassword;
	}

	public WebElement getFullname() {
		return fullname;
	}

	public WebElement getEmail() {
		return email;
	}

	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "re_password")
	private WebElement confirmpassword;
	
	@FindBy(name = "full_name")
	private WebElement fullname;
	
	@FindBy(name = "email_add")
	private WebElement email;


public RegistrationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
}