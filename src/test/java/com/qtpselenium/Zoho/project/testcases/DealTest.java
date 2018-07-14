package com.qtpselenium.Zoho.project.testcases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qtpselenium.Zoho.project.BaseTest.Testcase_BaseClass;
import com.qtpselenium.Zoho.project.util.XLS_reader;
import com.relevantcodes.extentreports.LogStatus;

public class DealTest extends Testcase_BaseClass{
	SoftAssert softAssert;
	String popUpWin ;
		
		@BeforeTest
		public void init() throws IOException{
			 softAssert=new SoftAssert();
			initiate();
		}
		 
		@Test(priority=1, dataProvider="getDealTestData1")
		public void createDeal(String runmode,String browser,String dealName,String accName,String closingDate,String stage) throws IOException, Exception{
			if(runmode.equals("N")){
				//reportSkip("Testcase Skipped");
				test=rep.startTest("Create Deal");
				test.log(LogStatus.SKIP, "Skipped Test for Testcase : DealTest-CreateDeal");
				rep.endTest(test);
				rep.flush();
				throw new SkipException("Skipping testcase as runmode is N: DealTest-CreateDeal");
				
			}else if(runmode.equals("Y")){
			test=rep.startTest("CreateDeal");
			test.log(LogStatus.INFO, "Starting test  for testcase: CreateDeal");
			openBrowser(browser);
			test.log(LogStatus.INFO, "Opening browser");
			navigatetoURL("AppURL");
			test.log(LogStatus.INFO, "Navigating to URL : "+prop.getProperty("AppURL"));
			Thread.sleep(3000);
			click("LoginLink_linkText");
			test.log(LogStatus.INFO, "Clicked on Link : "+prop.getProperty("LoginLink_linkText"));
			
			boolean actualRes=doLogin(prop.getProperty("username"), prop.getProperty("password"));
			
			if (!actualRes==true)
				reportFail("Invalid Login");
			Thread.sleep(3000);
			
			if(isElementPresent("CRMLink_xpath")){
				click("CRMLink_xpath");
				test.log(LogStatus.INFO, "Clicked on the CRM Link");
				
			}else{
				test.log(LogStatus.FAIL, "CRM Link not present");
				reportFail("CRM Link not present");
			}
			if(isElementPresent("DealsTab_xpath")){
				click("DealsTab_xpath");
				test.log(LogStatus.INFO, "Clicked on Deals tab");
				
			}else{
				test.log(LogStatus.FAIL, "Deals tab not present");
				reportFail("Deals tab not present");
			}	
			if(isElementPresent("AddDealBtn_xpath")){
				click("AddDealBtn_xpath");
				test.log(LogStatus.INFO, "Clicked on Add Deals button");
				
			}else{
				test.log(LogStatus.FAIL, "Add Deal button not present");
				reportFail("Add Deal button not present");
			}
			if(isElementPresent("CRM_DealName_id")){
				click("CRM_DealName_id");
				typeinField("CRM_DealName_id", dealName);
				test.log(LogStatus.INFO, "TYped in deal name : "+dealName);
				
			}else{
				test.log(LogStatus.FAIL, "Deal name field not present");
				reportFail("Deal name field not present");
			}
			if(isElementPresent("CRM_AccName_id")){
				click("CRM_AccName_id");
				
				typeinField("CRM_AccName_id", accName);
				test.log(LogStatus.INFO, "TYped in Account name : "+accName);
				
			}else{
				test.log(LogStatus.FAIL, "Account name field not present");
				reportFail("Account name field not present");
			}
			if(isElementPresent("CRM_Deal_ClosingDate_id")){
				click("CRM_Deal_ClosingDate_id");
				test.log(LogStatus.INFO, "Closing date field present. Selecting the date.");
				if(isElementPresent("calendar_id")){
					selectDate("calendar_monthYear_xpath", closingDate);
					test.log(LogStatus.INFO, "Selected the date "+closingDate);
					
				}else{
					test.log(LogStatus.FAIL, "Did not select the date");
					}
			}else{
				test.log(LogStatus.FAIL, "Closing date field not present");
				reportFail("Closing date field not present");
			}
			if(isElementPresent("CRM_StageSelect_id")){
				click("CRM_StageSelect_id");
				test.log(LogStatus.INFO, "Clicked on Stage field");
				if(isElementPresent("CRM_Stage_Select_id")){
					SelectFromList("CRM_Stage_Select_id", stage);
					test.log(LogStatus.INFO, "Selected Stage");
					
				}else{
					test.log(LogStatus.INFO, "List not present");
					
				}
				
			}else{
				test.log(LogStatus.INFO, "Stage field not present");
				
			}
			if(isElementPresent("saveDealBtn_id")){
				click("saveDealBtn_id");
				test.log(LogStatus.INFO, "Clicked on Save ");
				
			}else{
				test.log(LogStatus.INFO, "Save Btn not present");
				
			}
			Thread.sleep(5000);
			if(isElementPresent("DealsTab_xpath")){
				click("DealsTab_xpath");
				test.log(LogStatus.INFO, "Clicked on Deals tab");
				
			}else{
				test.log(LogStatus.FAIL, "Deals tab not present");
				reportFail("Deals tab not present");
			}
			
			int dealnameRowNum=getRowNumofDeal(dealName);
			if(dealnameRowNum==-1){
				reportFail("Deal name not found in the Deals page.");
			}else{
				reportPass("Deal name found under deals table in row num : "+dealnameRowNum + "Deal successfully Added. Testcase passed");
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
		
		
		@Test(priority=2)
		public void DeleteLead() throws Exception{
			//not writing steps as it is monotonous in nature
		}
		
		@DataProvider(name="getDealTestData1")
		public Object[][] getTestDataCreateDeal() throws IOException{
		//	System.out.println(System.getProperty("user.dir"+"//"+prop.getProperty("pathTestData")));
			initiate();
			xls=new XLS_reader(System.getProperty("user.dir")+"//src//test//resources//"+prop.getProperty("pathTestData"));
			return xls.getData(prop.getProperty("createDeal")) ;
			
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

