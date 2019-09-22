package library;

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

public class Dashboard_Page {
	WebDriver driver;

	public Dashboard_Page(WebDriver driver ) {
		this.driver=driver;
	}

	@FindBy(how=How.XPATH, using="//*[text()='Upload Documents']")
	@CacheLookup
	WebElement ud;

	@FindBy(how=How.XPATH,using="//*[@href='/agents/dashboard/deal']")
	@CacheLookup
	WebElement view_all;

    //Click on upload documents button
	public void upload_doc() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(ud)).click();
	}

	//Click on View All Button
	public void viewall() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchFieldException.class);
		wait.until(ExpectedConditions.visibilityOf(view_all)).click();
	}

	//Select particular tab from the head
	public void hearder(){
		WebElement head=driver.findElement(By.xpath("//*[@class='hdrTopnav']"));
		List<WebElement> list= head.findElements(By.tagName("li"));
		for(WebElement w:list) {
			if(w.getText().equals("Doc Repository")) {
				w.click();
				
			} 
		}
	}
}
