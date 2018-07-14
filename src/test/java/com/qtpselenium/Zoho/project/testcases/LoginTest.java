package com.qtpselenium.Zoho.project.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qtpselenium.Zoho.project.BaseTest.*;
import com.qtpselenium.Zoho.project.util.XLS_reader;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends Testcase_BaseClass {
	SoftAssert softAssert;
	
	@BeforeTest
	public void init() throws IOException{
		 softAssert=new SoftAssert();
		initiate();
	}
	 
	@Test(dataProvider="getTestData")
	public void loginTest(String loginID, String password,String expResult) throws Exception{
	
		
		test=rep.startTest("LoginTest");
		test.log(LogStatus.INFO, "Starting test  for testcase: LoginTest");
		openBrowser("Chrome");
		test.log(LogStatus.INFO, "Opening browser");
		navigatetoURL("AppURL");
		test.log(LogStatus.INFO, "Navigating to URL : "+prop.getProperty("AppURL"));
		click("LoginLink_linkText");
		test.log(LogStatus.INFO, "Clicked on Link : "+prop.getProperty("LoginLink_linkText"));
		boolean actualRes=doLogin(loginID, password);
		
		boolean expectedResult=false;
		if(expResult.equals("pass")){
				expectedResult=true;
		}else if(expResult.equals("fail")){
			expectedResult=false;
		}
		
		if(expectedResult!=actualRes){
			quitBrowser();
			reportFail("Testcase Failed");
			
		//quit();
		}else{
			click("profileIMG_id");
			moveToElementAndClick("SignOut_id");
			quitBrowser();
			reportPass("Testcase Passed");
		}
	}
	@DataProvider(name="getTestData")
	public Object[][] getTestData() throws IOException{
	//	System.out.println(System.getProperty("user.dir"+"//"+prop.getProperty("pathTestData")));
		initiate();
		xls=new XLS_reader(System.getProperty("user.dir")+"//src//test//resources//"+prop.getProperty("pathTestData"));
		return xls.getData(prop.getProperty("loginsheet")) ;
		
	}
	@AfterTest
	public void quit(){
		try{
			softAssert.assertAll();
		}catch(Error e){
			test.log(LogStatus.FAIL, e.getMessage());
		}
		rep.endTest(test);
		rep.flush();
	}
	
	
}
