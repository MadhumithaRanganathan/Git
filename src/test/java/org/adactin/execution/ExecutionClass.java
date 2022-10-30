package org.adactin.execution;

import org.adactin.base.BaseClass;
import org.adactin.base.ExcelBase;
import org.adactin.pageobject.HomePage;
import org.adactin.pageobject.RegistrationPage;
import org.adactin.report.ExtentReportBase;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	
	public class ExecutionClass extends BaseClass{

		private static final Cell Cell = null;
		HomePage hm=null;
		RegistrationPage rp=null;
		
		@BeforeMethod
		public void browserLaunch() {
		setDriver();
		getUrl("https://adactinhotelapp.com/");
		}
		
		@AfterMethod
		public void closeBrowser( ) {
			closeWindow();
		}
		@Test
		public void homepage() {
			
		ExtentReportBase.createInstance();
			HomePage hm = new HomePage(getDriver());
			clickButtons(hm.getNewuser());

					
		}
	
		
     	@Test(dataProvider = "dptesting")
		public void Registration(String username, String password, String confirmPassword, String fullName, String emailId) {
			homepage();
			rp = new RegistrationPage(getDriver());
			inputboxText(rp.getUsername(), username);
			inputboxText(rp.getPassword(), password);
			inputboxText(rp.getConfirmpassword(), confirmPassword);
			inputboxText(rp.getFullname(), fullName);
			inputboxText(rp.getEmail(), emailId);
			
						
		}
		
		
		

		@DataProvider(name="dptesting")
		public String[][] dptest() {

		ExcelBase t = new ExcelBase();
		String[][] data = ExcelBase.readExcel();
		return data;
		}
	}


	
	

