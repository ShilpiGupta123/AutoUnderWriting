package library;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Doc_Repository_page {
	WebDriver driver;

	public Doc_Repository_page(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(how=How.XPATH,using="//*[text()='Home']")
	@CacheLookup
	WebElement root;

	@FindBy(how=How.XPATH, using="//*[text()='Add Folder']")
	@CacheLookup
	WebElement add_folder;

	@FindBy(how=How.XPATH, using="/html/body/div[10]/div/div/div/div[2]/form/div/div[1]/div/input")
	@CacheLookup
	WebElement folder_name;


	@FindBy(how = How.XPATH,using="//*[@class='sub-header-bg clearfix']/div[3]/a")
	@CacheLookup
	WebElement before_selecting_folder_create_deal;

	@FindBy(how = How.XPATH,using="//*[@class='btn btn-default height add-upload-btn pull-right margin-t-none']")
	@CacheLookup
	WebElement after_selecting_folder_create_deal;

	@FindBy(how=How.XPATH,using="//*[@class='dz-or-text']")
	@CacheLookup
	WebElement upload_document;

	//Select Home Root Repository.
	public void root() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);

		//Selecting a Home Root Repository.
		wait.until(ExpectedConditions.visibilityOf(root)).click();

	}

	//Clicking on Add Folder Button.
	public void add_folder(){
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);

		//Click on Add Folder Button.
		wait.until(ExpectedConditions.visibilityOf(add_folder)).click();
	}

	//Sending a "Folder Name" And Then "Create a Folder" in Root Home Repository. 
	public void create_folder() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(folder_name)).sendKeys("Selenium");

		//Click on "Create Folder" button in Add Folder pop up box.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn-default btn width100']"))).click();
	}

	//Select Sub Created Folder in Home Root Repository. 
	public void select_folder() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);

		//Click on sub created Folder Button.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tree-folder-content']/div/div[1]"))).click();

	}

	//Select created folder and Upload the document in created folder in Home Repository.
	public void uplaod_document() throws AWTException, InterruptedException, IOException {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);

		//Click on Browser File Button.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='dz-default dz-message']/p"))).click();

		//Document upload from the system.
		Thread.sleep(3000);
		Runtime.getRuntime().exec("\"D:\\Selenium\\AutoIt\\test.exe\""+" "+"\"D:\\OS\\Multifamily\\Affinity At Billings\\QIE- Rentroll_004.PDF\""+" "+"\"D:\\OS\\Multifamily\\Affinity At Billings\\Property Financial Statements Historical - Certified_002.PDF\"");

	}


	//Clicking on Create Deal Button.
	public void before_selecting_folder_create_deal() {

		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(15))
				.ignoring(NoSuchFieldException.class);

		//Clicking Created Deal Button Without Selecting the Created Folder.
		wait.until(ExpectedConditions.visibilityOf(before_selecting_folder_create_deal)).click();
	}

	public void after_selecting_folder_create_deal() {

		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(15))
				.ignoring(NoSuchFieldException.class);

		//Clicking on Create Deal Button After Selecting The Created Folder.
		wait.until(ExpectedConditions.visibilityOf(after_selecting_folder_create_deal)).click();
	}
}
