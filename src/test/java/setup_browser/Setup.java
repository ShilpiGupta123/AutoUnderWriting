package setup_browser;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Listeners(listener.Listener.class)
public class Setup {
	
	public static WebDriver driver;
	FileInputStream input;
	Properties pro;

	@BeforeSuite()
	public void Start() throws IOException {
		pro=new Properties();

		//Configration with file.
		input=new FileInputStream("configration/config.properties");
		pro.load(input);
	}

	@Test(priority=1)
	public void ConnectWithBrowser(){
		System.setProperty(pro.getProperty("Key"), pro.getProperty("Value"));
		driver=new ChromeDriver();

		//Sending Url to the browser.
		driver.get(pro.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Maxi the browser.
		driver.manage().window().maximize();
	}

	@AfterSuite()
	public void Exit() {

		//Close the browser.
		driver.quit();
	}

}