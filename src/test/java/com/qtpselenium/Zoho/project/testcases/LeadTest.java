package com.qtpselenium.Zoho.project.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qtpselenium.Zoho.project.BaseTest.Testcase_BaseClass;
import com.qtpselenium.Zoho.project.util.XLS_reader;
import com.relevantcodes.extentreports.LogStatus;

public class LeadTest extends Testcase_BaseClass {
	
SoftAssert softAssert;
String popUpWin ;
	
	@BeforeTest
	public void init() throws IOException{
		 softAssert=new SoftAssert();
		initiate();
	}
	 
	@Test(priority=1, dataProvider="getTestData1")
	public void createLead(String runmode,String browser,String companyName,String lastName) throws IOException, Exception{
		if(runmode.equals("N")){
			//reportSkip("Testcase Skipped");
			test=rep.startTest("Create Lead");
			test.log(LogStatus.SKIP, "Skipped Test for Testcase : CreateLead");
			rep.endTest(test);
			rep.flush();
			throw new SkipException("Skipping testcase as runmode is N: CreateLead");
			
		}else if(runmode.equals("Y")){
		test=rep.startTest("CreateLead");
		test.log(LogStatus.INFO, "Starting test  for testcase: CreateLead");
		openBrowser(browser);
		test.log(LogStatus.INFO, "Opening browser");
		navigatetoURL("AppURL");
		test.log(LogStatus.INFO, "Navigating to URL : "+prop.getProperty("AppURL"));
		Thread.sleep(5000);
		click("LoginLink_linkText");
		test.log(LogStatus.INFO, "Clicked on Link : "+prop.getProperty("LoginLink_linkText"));
		boolean actualRes=doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		if (!actualRes==true)
			reportFail("Invalid Login");
		Thread.sleep(3000);
		//click("CRMLink_linkText");
		//test.log(LogStatus.INFO, "Clicked on the CRM Link");
		if(isElementPresent("CRMLink_xpath")){
			click("CRMLink_xpath");
			test.log(LogStatus.INFO, "Clicked on the CRM Link");
			
		}else{
			test.log(LogStatus.FAIL, "CRM Link not present");
			reportFail("CRM Link not present");
		}
		if(isElementPresent("LeadsTab_xpath")){
			click("LeadsTab_xpath");
			test.log(LogStatus.INFO, "Clicked on Leads tab");
			
		}else{
			test.log(LogStatus.FAIL, "Leads tab not present");
			reportFail("Leads tab not present");
		}	
		if(isElementPresent("AddLead_xpath")){
			click("AddLead_xpath");
			test.log(LogStatus.INFO, "Clicked on Add Leads button");
			
		}else{
			test.log(LogStatus.FAIL, "Add Leads button not present");
			reportFail("Add Leads button not present");
		}
		if(isElementPresent("CRM_Lead_Companyname_id")){
			click("CRM_Lead_Companyname_id");
			typeinField("CRM_Lead_Companyname_id", companyName);
			test.log(LogStatus.INFO, "TYped in company name : "+companyName);
			
		}else{
			test.log(LogStatus.FAIL, "Company name field not present");
			reportFail("Company name field not present");
		}
		if(isElementPresent("CRM_Lead_Lastname_id")){
			click("CRM_Lead_Lastname_id");
			typeinField("CRM_Lead_Lastname_id", lastName);
			test.log(LogStatus.INFO, "TYped in lead name : "+lastName);
			
		}else{
			test.log(LogStatus.FAIL, "Last name field not present");
			reportFail("Last name field not present");
		}
		if(isElementPresent("SaveLeadsBtn_id")){
			click("SaveLeadsBtn_id");
			test.log(LogStatus.INFO, "Clicked on save button");
			
		}else{
			test.log(LogStatus.FAIL, "Save button not present");
			reportFail("Save button not present");
		}
		Thread.sleep(10000);
		if(isElementPresent("LeadsTab_xpath")){
			click("LeadsTab_xpath");
			test.log(LogStatus.INFO, "Clicked on Leads tab");
			
		}else{
			test.log(LogStatus.FAIL, "Leads tab not present");
			reportFail("Leads tab not present");
		}
		Thread.sleep(3000);
		int rowNum=getRowNumofLead(lastName);
		if(rowNum==-1){
			reportFail("Lead name not found in the leads page.");
		}else{
			reportPass("Lead Found in table.");
			takeScreenshot();
		}
		if(isElementPresent("profileIMG_Indisdeapl_id")){
			click("profileIMG_Indisdeapl_id");
			test.log(LogStatus.INFO, "Clicked on profile icon");
			
		}else{
			test.log(LogStatus.INFO, "profile icon not present");
			
		}
		if(isElementPresent("SignOut_linkText")){
			click("SignOut_linkText");
			test.log(LogStatus.INFO, "Clicked on Sign OUt Link.");
			
		}else{
			test.log(LogStatus.INFO, "Sign out lilnk not present");
			
		}
		quitBrowser();
		
	}
	}
	
	@Test(priority=2,dataProvider="getTestData2")
	public void convertLead(String runmode,String browser,String company,String leadName) throws Exception{
		if(runmode.equals("N")){
			//reportSkip("Testcase Skipped");
			test=rep.startTest("Create Lead");
			test.log(LogStatus.SKIP, "Skipped Test for Testcase : ConvertLead");
			rep.endTest(test);
			rep.flush();
			throw new SkipException("Skipping testcase as runmode is N: ConvertLead");
			
		}else if(runmode.equals("Y")){
		test=rep.startTest("ConvertLead");
		test.log(LogStatus.INFO, "Starting test  for testcase: ConvertLead");
		openBrowser(browser);
		test.log(LogStatus.INFO, "Opening browser");
		navigatetoURL("AppURL");
		test.log(LogStatus.INFO, "Navigating to URL : "+prop.getProperty("AppURL"));
		Thread.sleep(5000);
		click("LoginLink_linkText");
		test.log(LogStatus.INFO, "Clicked on Link : "+prop.getProperty("LoginLink_linkText"));
		boolean actualRes=doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		if (!actualRes==true)
			reportFail("Invalid Login");
		Thread.sleep(3000);
		//click("CRMLink_linkText");
		//test.log(LogStatus.INFO, "Clicked on the CRM Link");
		if(isElementPresent("CRMLink_xpath")){
			click("CRMLink_xpath");
			test.log(LogStatus.INFO, "Clicked on the CRM Link");
			
		}else{
			test.log(LogStatus.FAIL, "CRM Link not present");
			reportFail("CRM Link not present");
		}
		if(isElementPresent("LeadsTab_xpath")){
			click("LeadsTab_xpath");
			test.log(LogStatus.INFO, "Clicked on Leads tab");
			
		}else{
			test.log(LogStatus.FAIL, "Leads tab not present");
			reportFail("Leads tab not present");
		}
		Thread.sleep(5000);
		clickLeadName(leadName);
		
		if(isElementPresent("ConvertButn_xpath")){
			test.log(LogStatus.INFO, "Lead details page is displayed");
			click("ConvertButn_xpath");
			test.log(LogStatus.INFO, "Clicked on Convert button");
			
		}else{
			test.log(LogStatus.FAIL, "Convert button not present");
			reportFail("Convert button not present");
		}
		if(isElementPresent("ConvertBtn_ConvLeadPage_xpath")){
			test.log(LogStatus.INFO, "Convert Lead confirmation  page is displayed");
			click("ConvertBtn_ConvLeadPage_xpath");
			test.log(LogStatus.INFO, "Clicked on Convert button");
			
		}else{
			test.log(LogStatus.FAIL, "Convert button not present");
			reportFail("Convert button not present");
		}
		Thread.sleep(10000);
		if(isElementPresent("AccTab_xpath")){
			click("AccTab_xpath");
			test.log(LogStatus.INFO, "Clicked on Accounts tab");
			
		}else{
			test.log(LogStatus.FAIL, "Accounts tab not present");
			reportFail("Accounts tab not present");
		}
		Thread.sleep(3000);
		int accnameRowNum=getRowNumofAccount(company);
		if(accnameRowNum==-1){
			reportFail("Account name not found in the leads page.");
		}else{
			reportPass("Company name found under accounts table in row num : "+accnameRowNum + "Lead successfully converted to Account. Testcase passed");
			takeScreenshot();
		}
		if(isElementPresent("profileIMG_Indisdeapl_id")){
			click("profileIMG_Indisdeapl_id");
			test.log(LogStatus.INFO, "Clicked on profile icon");
			
		}else{
			test.log(LogStatus.INFO, "profile icon not present");
			
		}
		if(isElementPresent("SignOut_linkText")){
			click("SignOut_linkText");
			test.log(LogStatus.INFO, "Clicked on Sign OUt Link.");
			
		}else{
			test.log(LogStatus.INFO, "Sign out lilnk not present");
			
		}
		quitBrowser();
		
		}
	}
	
	@Test(priority=3,dataProvider="getTestData3")
	public void DeleteLead(String runmode,String browser,String company,String leadName) throws Exception{
		if(runmode.equals("N")){
			//reportSkip("Testcase Skipped");
			test=rep.startTest("Delete Lead");
			test.log(LogStatus.SKIP, "Skipped Test for Testcase : DeleteLead");
			rep.endTest(test);
			rep.flush();
			throw new SkipException("Skipping testcase as runmode is N: DeleteLead");
			
		}else if(runmode.equals("Y")){
			test=rep.startTest("Delete Lead");
			test.log(LogStatus.INFO, "Starting test  for testcase: DeleteLead");
			openBrowser(browser);
			test.log(LogStatus.INFO, "Opening browser");
			navigatetoURL("AppURL");
			test.log(LogStatus.INFO, "Navigating to URL : "+prop.getProperty("AppURL"));
			Thread.sleep(5000);
			click("LoginLink_linkText");
			test.log(LogStatus.INFO, "Clicked on Link : "+prop.getProperty("LoginLink_linkText"));
			boolean actualRes=doLogin(prop.getProperty("username"), prop.getProperty("password"));
			if (!actualRes==true)
				reportFail("Invalid Login");
			Thread.sleep(3000);
			//click("CRMLink_linkText");
			//test.log(LogStatus.INFO, "Clicked on the CRM Link");
			if(isElementPresent("CRMLink_xpath")){
				click("CRMLink_xpath");
				test.log(LogStatus.INFO, "Clicked on the CRM Link");
				
			}else{
				test.log(LogStatus.FAIL, "CRM Link not present");
				reportFail("CRM Link not present");
			}
			if(isElementPresent("LeadsTab_xpath")){
				click("LeadsTab_xpath");
				test.log(LogStatus.INFO, "Clicked on Leads tab");
				
			}else{
				test.log(LogStatus.FAIL, "Leads tab not present");
				reportFail("Leads tab not present");
			}
			Thread.sleep(5000);
			clickLeadName(leadName);
			if(isElementPresent("CustomizeToolsIcon_id")){
				test.log(LogStatus.INFO, "Leads information page displayed. Clicking on Customize options button" );
				click("CustomizeToolsIcon_id");
				test.log(LogStatus.INFO, "Clicked on Customize options ");
				
			}else{
				test.log(LogStatus.FAIL, "Customize options button not present");
				reportFail("Customize options button not present");
			}
			
			getElementInsideboxAndClick("customizeBox_id","DeleteLink_xpath");
	
			WebElement elem=getElement("deletePopup_id");
			elem.findElement(By.xpath(prop.getProperty("MovetoBinbutton_xpath"))).click();
			test.log(LogStatus.INFO, "Clicked on Yes move to bin button");
			
			Thread.sleep(5000);
			if(isElementPresent("LeadsTab_xpath")){
				click("LeadsTab_xpath");
				test.log(LogStatus.INFO, "Clicked on Leads tab");
				
			}else{
				test.log(LogStatus.FAIL, "Leads tab not present");
				reportFail("Leads tab not present");
			}
			int rowNum=getRowNumofLead(leadName);
			if(rowNum==-1){
				test.log(LogStatus.PASS, "successfully deleted from the leads page.");
				reportPass("Lead name : "+leadName+" successfully deleted from the leads page.");
				takeScreenshot();
			}else{
				reportFail("Lead Found in table. Not yet deleted. ");
				
			}
			if(isElementPresent("profileIMG_Indisdeapl_id")){
				click("profileIMG_Indisdeapl_id");
				test.log(LogStatus.INFO, "Clicked on profile icon");
				
			}else{
				test.log(LogStatus.INFO, "profile icon not present");
				
			}
			if(isElementPresent("SignOut_linkText")){
				click("SignOut_linkText");
				test.log(LogStatus.INFO, "Clicked on Sign OUt Link.");
				
			}else{
				test.log(LogStatus.INFO, "Sign out lilnk not present");
				
			}
			quitBrowser();
			
		}
	}
	@DataProvider(name="getTestData1")
	public Object[][] getTestDataCreateLead() throws IOException{
	//	System.out.println(System.getProperty("user.dir"+"//"+prop.getProperty("pathTestData")));
		initiate();
		xls=new XLS_reader(System.getProperty("user.dir")+"//src//test//resources//"+prop.getProperty("pathTestData"));
		return xls.getData(prop.getProperty("createLead")) ;
		
	}
	@DataProvider(name="getTestData2")
	public Object[][] getTestDataConvertLead() throws IOException{
	//	System.out.println(System.getProperty("user.dir"+"//"+prop.getProperty("pathTestData")));
		initiate();
		xls=new XLS_reader(System.getProperty("user.dir")+"//src//test//resources//"+prop.getProperty("pathTestData"));
		return xls.getData(prop.getProperty("convertLead")) ;
		
	}
	@DataProvider(name="getTestData3")
	public Object[][] getTestDataDeleteLead() throws IOException{
	//	System.out.println(System.getProperty("user.dir"+"//"+prop.getProperty("pathTestData")));
		initiate();
		xls=new XLS_reader(System.getProperty("user.dir")+"//src//test//resources//"+prop.getProperty("pathTestData"));
		return xls.getData(prop.getProperty("deleteLead")) ;
		
	}
	@AfterTest
	public void quit(){
		try{
			softAssert.assertAll();
		}catch(Error e){
			test.log(LogStatus.FAIL, e.getMessage());
		}
		if (rep!=null){
		rep.endTest(test);
		rep.flush();
		}
		if(driver!=null){
			driver.quit();
		}
	}
	
}
