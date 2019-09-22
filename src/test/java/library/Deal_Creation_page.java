package library;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;


public class Deal_Creation_page {
	WebDriver driver;

	public void Deal_Craetion_page(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(how=How.XPATH, using="")
	@CacheLookup
	WebElement update;

	@FindBy(how=How.XPATH, using="//*[@class='btn btn-default height add-upload-btn pull-right']")
	@CacheLookup
	WebElement loan_sizing;

	@FindBy(how=How.XPATH, using="//*[@class='btn btn-default height add-upload-btn grid-btnCol margin-t-none']")
	@CacheLookup
	WebElement create_deal1;

	@FindBy(how=How.XPATH, using="")
	@CacheLookup
	WebElement deal_selection;

	
	//Click on Loan Sizing Button.
	public void loan_sizing() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(loan_sizing)).click();
	}


	//Click on Craete Deal Button.
	public void create_deal1	() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(create_deal1)).click();


	}

	//Create Deal Popup box.
	public void create_deal_popup() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		//Select folder for Creating a folder.
		Select createdeal=new Select(driver.findElement(By.xpath("//*[@class='form-control form-select ng-pristine ng-valid ng-touched']")));
		createdeal.selectByIndex(1);
		
		//Click on first Next Button.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn-default']"))).click();

		//Excute Loan Information
		//Select property type of deal
		Select property=new Select(driver.findElement(By.id("property_type")));
		property.selectByVisibleText("Multi-Family");
		
		//Click on Second Next Button.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).click();
	}

	//Deal selection from deal panel.
	public void deal_selection() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='panel-group ng-scope']/div"))).click();

	}
	
	//Tagged document
	public void hotel_tagged_document() {
		
		
	}



}
