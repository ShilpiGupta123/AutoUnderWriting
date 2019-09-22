package com.autouw.qa.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Header {
	WebDriver driver;

	public Header(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(how=How.XPATH, using="//*contains(herf,'/agents/dashboard')]")
	@CacheLookup
	WebElement logo;

	@FindBy(how=How.XPATH, using="//*[contains(herf,'/agents/dashboard')]")
	@CacheLookup
	WebElement dashboard;

	@FindBy(how=How.XPATH, using="//*[contains(herf,'/agents/loans/upload-file')]")
	@CacheLookup
	WebElement doc_repository;

	@FindBy(how=How.XPATH, using="//*[contains(herf,'/agents/loans/deal-create')]")
	@CacheLookup
	WebElement deal_creation;

	@FindBy(how=How.XPATH, using="//*[contains(herf,'/agents/dashboard/deal')]")
	@CacheLookup
	WebElement loan_sizing;

	@FindBy(how=How.XPATH, using="//*[contains(herf,'/agents/dashboard/completed-deal')]")
	@CacheLookup
	WebElement deal_report;

	@FindBy(how=How.XPATH, using="//*[contains(@src,'/dashboard_assets/images/notifications.svg')]")
	@CacheLookup
	WebElement notification;

	@FindBy(how=How.ID, using="userDropdown")
	@CacheLookup
	WebElement profile_menu;

	//Click on clik logo.
	public void logo() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(logo)).click();	
	}

	//Click on dasboard tab on header.
	public void dashboard() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(logo)).click();	
	}

	//Click on doc repository tab on header.
	public void doc_repository() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(logo)).click();	
	}

	//Click on deal creation tab on header.
	public void deal_creation() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(logo)).click();	
	}

	//Click on loan sizing tab on header.
	public void loan_sizing() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(logo)).click();	
	}

	//Click on deal report tab on header.
	public void deal_report() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(logo)).click();	
	}

	//Click on Notification icon on header.
	public void notification() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(logo)).click();	
	}

	//Click on profile menu drop down box on header.
	public void profile_menu() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(logo)).click();	

		//Select the item from profile menu drop down box.
		WebElement head=driver.findElement(By.xpath("//*[@class='dropdown-menu dropdown-user flipInX']"));
		List<WebElement> list= head.findElements(By.tagName("li"));
		for(WebElement w:list) {
			if(w.getText().equals("Doc Repository")) {
				w.click();
			}
		}
	} 
}
