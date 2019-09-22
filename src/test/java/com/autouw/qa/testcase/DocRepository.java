package com.autouw.qa.testcase;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autouw.qa.base.TestBase;
import com.autouw.qa.page.DocRepositorypage;

@Listeners(com.autouw.qa.util.Listener.class)
public class DocRepository {
	WebDriver driver;
	DocRepositorypage doc;

	@BeforeClass
	public void Doc_Repository() {
		driver=TestBase.driver;
		doc= PageFactory.initElements(driver, DocRepositorypage.class);
	}

	//Verify Validation Message After Clicking ON Create Deal Button When Root Home Folder Is Not Selected.
	@Test(priority=15)
	public void VerifyValidationMessageAfterClickingOnCreateDealButtonWhenHomeRootRopoIsNotSelected() throws InterruptedException {
		Thread.sleep(5000);

		//Clicking on Create Deal Folder.
		doc.before_selecting_folder_create_deal();

		//Verify The Acual And Expected Text of Create Deal Button.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='sub-header-bg clearfix']/div[3]/a")).getText(),"Create Deal");

		//Verify The Actual And Expectation Message When Root Home Message Is Not Selected.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='toast-message']")).getText(), "Please select a folder for creating deal");

	}


	//Verify Validation Message While Creating Folder When Root Homen Repository Is Not Selected.
	@Test(priority=16)
	public void VerifyValidationMessageWhileCreateFolderWhenRootHomeRepoIsNotSelected() throws InterruptedException{

		//Clicking On Add Folder Button.
		doc.add_folder();

		Thread.sleep(5000);

		//Verify The Acutal Message and Expected Message After Clicking on Add Folder Button When Home Root Repo Is Not Selected.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='toast-message']")).getText(),"Please select home to create folder");

	}

	//Selecting Home Root Repository. 
	@Test(priority=17)
	public void SelectHomeRoot() throws InterruptedException {
		Thread.sleep(5000);

		//Clicking on Home Root Repository.
		doc.root();
	}

	//Verify The Vaildation Message After clicking on Create Deal Button When Root Home Is Not Selected.
	@Test(priority=18,dependsOnMethods="SelectHomeRoot")
	public void VerifyValidationMessageAfterClickingOnCreateDealButtonWhenRootHomeRopoIsSelected() throws InterruptedException {
		Thread.sleep(5000);

		//Clicking on Create Deal Button After Selecting The Root Home Folder.
		doc.before_selecting_folder_create_deal();

		//Verify The Actual And Expection Message After Clicking in Create Deal Button When Root Home Folder Is Selected.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='toast-message']")).getText(), "Please select a folder for creating deal");
	}

	//Verify Validation Message While Uploading Document In Home Root Repository.
	@Test(priority=19,dependsOnMethods="SelectHomeRoot")
	public void VerifyValidationMessageWhileUploadingDocumentInHomeRootRepo() throws AWTException, InterruptedException, IOException {
		Thread.sleep(5000);

		//Uploading A Document From Local To Sever.
		doc.uplaod_document();

		//Verify The Actual And Expected Message After Uploading Documents In Home Root Repository.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='toast-message']")).getText(),"Please create a folder or select any existing folder to upload documents");
	}

	//Clicking on Add Folder Button After Select Root Home Repository.
	@Test(priority=20,dependsOnMethods="SelectHomeRoot")
	public void ClickAddFolderButton() {

		//Clicking Add Folder Button.
		doc.add_folder();

	}

	//Verify Validation Message When Sending a Folder Name Is Empty.
	@Test(priority=21,dependsOnMethods="ClickAddFolderButton")
	public void SendingAFolderNameIsEmpty() throws InterruptedException {
		Thread.sleep(5000);

		//Click on "Create Folder" button in Add Folder pop up box.
		driver.findElement(By.xpath("//*[@class='btn-default btn width100']")).click();

		//Verify The Actual and Expected Message When Folder Name TextBox Is Empty.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='toast-message']")).getText(), "Please Enter Folder Name");
	}


	//Verify Successfull Message After Creating new forlder in Root Home Repository And Sending A FolderName.
	@Test(priority=22,dependsOnMethods="ClickAddFolderButton")
	public void VerifySuccessfullMessageAfterCreatingFolder() throws InterruptedException{

		//Sending A Folder Name and Clicking Create Folder Button.
		doc.create_folder();

		Thread.sleep(5000);

		//Verify The Actual And Expected Message After Creating A Folder In Root Home Repositoy.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='toast-message']")).getText(),"Folder has been successfully created!");
	}

	//Select A Created Folder In Home Root Repositoy.
	@Test(priority=23,dependsOnMethods="VerifySuccessfullMessageAfterCreatingFolder")
	public void SelectCreateFolder() throws InterruptedException {
		Thread.sleep(5000);

		//Clicking on Created Folder In Home Root Repositoy.
		doc.select_folder();
	}

	//Verify The Vailidation Message After clicking On Creating Deal Button When Create Folder Does Not Contain Documents.
	@Test(priority=24, dependsOnMethods="SelectCreateFolder")
	public void VerifyValidationMessageAfterAfterClickingOnCreateDealButtonWhenCreatedFolderIsNotContainDocuments() throws InterruptedException {
		Thread.sleep(5000);

		//Clicking on Create Deal Button When Created Folder Does Not have Any Documents.
		doc.after_selecting_folder_create_deal();

		//Verify the Actual and Expected Message After Clicking on Create Deal Button When Created Folder Does Not Contain Documents.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='toast-message']")).getText(), "Please upload a document before creating deal");
	}


	//Verify Successfull Message After Uploading The Document in Created Sub Folder.
	@Test(priority=25,dependsOnMethods="SelectCreateFolder")
	public void	 UploadDocuments() throws AWTException, InterruptedException, IOException {
		Thread.sleep(5000);

		//Upload Document From Local To Sever.
		doc.uplaod_document();

		//Verify The Actual And Expected Message After Uploading A Documents In Created Folder.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='toast-message']")).getText(),"File has been successfully uploaded.");
	}

	//Create deal after creating a folder and uploading documents on that folder.
	@Test(priority=26,dependsOnMethods="UploadDocuments")
	public void CreateDeal() throws InterruptedException {
		Thread.sleep(5000);

		//Clicking on Create Deal Button After Uploading Documents In Craeted Folder.
		doc.after_selecting_folder_create_deal();

		//Verify The Acual And Expected Text of Create Deal Button.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='btn btn-default height add-upload-btn pull-right margin-t-none']")).getText(),"Create Deal");
	}

	//Closing the open tab from the browser.
	@Test(priority=27)
	public void CloseTab() throws InterruptedException {

		//Getting all tab array
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		Thread.sleep(2000);

		for(int i=3;i>0;i--) {		

			//Switing to first tab.
			driver.switchTo().window(tabs.get(i));

			//Closing the current tab. 
			driver.close();
		}

		//Open a new tab and closing the that tab.
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
		//Closing the tab.
		//driver.close();
		//driver.switchTo().window(tabs.get(0));
	}
}
