package org.adactin.base;

import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {

	private WebDriver driver=null;

	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver() {
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
		
	}
	
	public void getUrl(String url) {
		driver.get(url);
	}
	
	
	
	public void inputboxText(WebElement element, String input) {
		element.sendKeys(input);
	}
	
	public void clickButtons(WebElement element) {
		element.click();
	}
	
	
	public String base64Screenshot() throws IOException {
		TakesScreenshot scr = (TakesScreenshot)driver;
		String screenshot = scr.getScreenshotAs(OutputType.BASE64);
		return screenshot;
	}
				
	public void closeWindow() {
		driver.close();
		}
	}


