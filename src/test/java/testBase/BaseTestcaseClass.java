package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
//Logger Package from apache  core
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTestcaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties prop;
	@BeforeClass
	@Parameters({"browser","os"})
	public void setUp(String browser, String os) throws IOException {
//		Loading Properties File
		prop = new Properties();
		FileInputStream propFile = new FileInputStream("./src//test//resources//config.properties");
		prop.load(propFile);
		
		System.out.println("Os used to run tests : "+os);
		logger = LogManager.getLogger(this.getClass());
		switch(browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser !!");
			return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String appUrl = prop.getProperty("appurl"); 
		driver.get(appUrl);
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	public String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
	public String randomPass() {
		return RandomStringUtils.randomAlphabetic(5)+"#"+RandomStringUtils.randomNumeric(5);
	}
}
