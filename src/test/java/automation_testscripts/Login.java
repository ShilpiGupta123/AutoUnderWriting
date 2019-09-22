package automation_testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import library.Login_Page;
import setup_browser.Setup;

@Listeners(listener.Listener.class)
public class Login {
	WebDriver driver;
	Login_Page login;
	FileInputStream input;
	Properties pro;

	@BeforeClass
	public void SetUp() throws IOException {
		driver=Setup.driver;   	
		login=PageFactory.initElements(driver, Login_Page.class);
		input=new FileInputStream("Configration/Config.properties");
		pro=new Properties();
		pro.load(input);
	}



	//Click on Term of Serivce link
	@Test(priority=2)
	public void TermAndSerivce() throws InterruptedException{
		login.terms_serivce();
	}

	//Click on Privacy Policy link
	@Test(priority=3)
	public void PrivacyPolicy() throws InterruptedException{
		login.privacy();
	}

	//Click on Request Demo Button
	@Test(priority=4)
	public void RequestDemo() throws InterruptedException{
		login.request_demo();
	}

	//Accetping cookies of the application.
	@Test(priority=5)
	public void AcceptCookies() {
		login.accept_cookies();
	}
	
	//Verify validation Message When Term And Service Check Box Is Not Selected.
	@Test(priority=6, enabled=false)
	public void VerfiyValidationMessageWhenTermAndServiceCheckBoxIsNotSelected() {
		WebDriverWait wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginform-terms']"))).click();
		
	} 

	//User should not be able to login with empty username and empty password.
	@Test(priority=7, enabled=false)
	public void VerifyValidationMessageWhenUserLoginWithEmptyUsernameAndPassword() throws InterruptedException {
		login.log();

		//Verify validation message of username.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='login-form']/div[1]/p")).getText(), "Username cannot be blank.");

		//Verify validation message of password.
		Assert.assertEquals(driver.findElement(By.xpath("//*[[@id='login-form']/div[2]/p")).getText(), "Password cannot be blank.");
	}

	//User should not be able to login with valid username and empty password.
	@Test(priority=8, enabled=false)
	public void VerifyValidationMessageWhenUserLoginWithValidUsernameAndEmptyPassword() throws InterruptedException {
		login.log();

		//Verify validation message of password.
		Assert.assertEquals(driver.findElement(By.xpath("//*[[@id='login-form']/div[2]/p")).getText(), "Password cannot be blank.");
	}

	//User should not be able to login with empty username and valid password.
	@Test(priority=9, enabled=false)
	public void VerifyValidationMessageWhenUserLoginWithEmptyUsernameAndValidPassword() throws InterruptedException {
		login.log();

		//Verify validation message of username.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='login-form']/div[1]/p")).getText(), "Username cannot be blank.");
	}

	//User should not be logged in with both invalid username and password.
	@Test(priority=10, enabled=false)
	public void VerifyVAlidationMessageWhenUserLoginWithInvalidUsernameAndPassword() throws InterruptedException {
		login.log();

		//Verify validation message of username and password.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='login-form']/div[2]/p")).getText(), "Incorrect username or password.");
	}

	//User should not be able to login with invalid username and valid password.
	@Test(priority=11, enabled=false)
	public void VerifyValidationMessageWhenUserLoginWithInvalidUsernameAndValidPassword() throws InterruptedException {
		login.log();


		//Verify validation message of username and password.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='login-form']/div[2]/p")).getText(), "Incorrect username or password.");
	}

	//User should not be able to login with valid username and invalid password.
	@Test(priority=12, enabled=false)
	public void VerifyValidationMessageWhenUserLoginWithValidUsernameAndInvalidPassword() throws InterruptedException {
		login.log();

		//Verify validation message of username and password.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='login-form']/div[2]/p")).getText(), "Incorrect username or password.");
	}

	//User should be logged in with valid username and password.
	@Test(priority=13)
	public void UserLoginWithValidUsernameAndPassword() throws InterruptedException{
		login.log();

		//Check user is login only one browser or not
		try { 
			if(driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissable']//*[@class='btn btn-login']")).isDisplayed()) {


				//Click on Logout Multiple Browser Button.
				driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissable']//*[@class='btn btn-login']")).click();
				WebDriverWait wait=new WebDriverWait(driver,20);

				//Sending Username to username Textbox.
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='loginform-username']")))).sendKeys(pro.getProperty("UserName"));

				//Sending Password to Password Textbox.
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='loginform-password']")))).sendKeys(pro.getProperty("Password"));

				//Click on Terms and Privacy Checkbox.
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='loginform-terms']")))).click();

				//Click on Login Button.
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='login-button']")))).submit();

				//Verify Login page is naviagting to Dashboard Page or not.
				Assert.assertEquals("Deals",driver.findElement(By.xpath("//*[@class='card-title-light margin-t-none']")).getText());
			}
			System.out.println("User is login after logout from multiple browser.");
		} catch (NoSuchElementException e) {
			
			System.out.println("<----------------User is login without logout from multiple browse.--------------------->");

			//Verify Login page is naviagting to Dashboard Page or not.
			Assert.assertEquals(driver.findElement(By.xpath("//*[@class='card-title-light margin-t-none']")).getText(),"Deals");
		}
	}











}
