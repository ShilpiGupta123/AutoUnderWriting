package library;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Login_Page {
	WebDriver driver;
	FileInputStream input;
	Properties pro;

	public Login_Page(WebDriver driver) throws IOException {
		this.driver=driver;
		pro = new Properties();
		input= new FileInputStream("Configration/Config.properties");
		pro.load(input);
	}

	@FindBy(how=How.XPATH,using="//input[@id='loginform-username']")
	@CacheLookup
	WebElement username;

	@FindBy(how=How.XPATH, using="//input[@id='loginform-password']")
	@CacheLookup
	WebElement password;

	@FindBy(how=How.XPATH, using="//*[@id='loginform-terms']")
	@CacheLookup
	WebElement rememberme;

	@FindBy(how=How.XPATH,using="//*[@name='login-button']")
	@CacheLookup
	WebElement loginbutton;

	@FindBy(how=How.XPATH,using="//*[text()='Terms of Service']")
	@CacheLookup
	WebElement trems;

	@FindBy(how=How.XPATH,using="//*[text()='Privacy Policy']")
	@CacheLookup
	WebElement privacy;

	@FindBy(how=How.XPATH,using="//*[text()='Request Demo']")
	@CacheLookup
	WebElement request_demo;

	@FindBy(how=How.ID,using="hs-eu-confirmation-button")
	@CacheLookup
	WebElement accept_cookies;

	//Login
	public void log() throws InterruptedException{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(WebDriverException.class);

		//Getting all tab array
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));

		//Username sending to Username Textbox
		WebElement username1=wait.until(ExpectedConditions.visibilityOf(username));
		username1.clear();
		username1.sendKeys(pro.getProperty("UserName"));

		//Password sending to Password Testbox
		WebElement pass=wait.until(ExpectedConditions.visibilityOf(password));
		pass.clear();
		pass.sendKeys(pro.getProperty("Password"));

		//Click on Term and Codition Checkbox.
		wait.until(ExpectedConditions.visibilityOf(rememberme)).click();

		//Click on Login Button.
		wait.until(ExpectedConditions.visibilityOf(loginbutton)).submit();
	}

	//Term of Service Link
	public void terms_serivce() throws InterruptedException {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(WebDriverException.class);

		//Click on Term Of Service link.
		wait.until(ExpectedConditions.visibilityOf(trems)).click();
	}

	//Privacy Policy Link
	public void privacy() throws InterruptedException {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(WebDriverException.class);

		//Click on Privacy Policy link.
		wait.until(ExpectedConditions.visibilityOf(privacy)).click();
	}

	//Request Demo Buttton
	public void request_demo() throws InterruptedException {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(WebDriverException.class);

		//Click on Request Demo Button.
		wait.until(ExpectedConditions.visibilityOf(request_demo)).click();
	}


	//Accepting Cookies
	public void accept_cookies() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(WebDriverException.class);

		//Click on Ok Button for accepting cookies.
		wait.until(ExpectedConditions.visibilityOf(accept_cookies)).click();
	}

}

