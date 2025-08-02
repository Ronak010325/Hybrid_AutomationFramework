package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
//Logger Package from apache  core
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTestcaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	@BeforeClass(groups= {"Sanity","Regression","Datadriven","Master"})
	@Parameters({"browser","os"})
	public void setUp(String browser, String os) throws IOException {
//		Loading Properties File
		prop = new Properties();
		FileInputStream propFile = new FileInputStream("./src//test//resources//config.properties");
		prop.load(propFile);

		logger = LogManager.getLogger(this.getClass());
		
		if (prop.getProperty("execution_env").equals("local")) {
			switch (browser.toLowerCase()) {
			case "chrome":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				driver = new ChromeDriver(options);
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
		} else {
			DesiredCapabilities cap = new DesiredCapabilities();	
			switch(os.toLowerCase()) {
			case "window" : cap.setPlatform(Platform.WINDOWS); break;
			case "linux" : cap.setPlatform(Platform.LINUX); break;
			case "mac" : cap.setPlatform(Platform.MAC); break;			
			default : System.out.println("Invalid OS"); return;
			}
			switch(browser.toLowerCase()) {
				case "chrome" : cap.setBrowserName("chrome"); break;
				case "edge" : cap.setBrowserName("MicrosoftEdge"); break;
				case "firefox" : cap.setBrowserName("firefox"); break;	
				default : System.out.println("Inavlid Browser"); return;
			}
			String hubUrl = "http://localhost:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(hubUrl), cap);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String appUrl = prop.getProperty("appurl"); 
		driver.get(appUrl);
	}
	
	@AfterClass(groups= {"Sanity","Regression","Datadriven","Master"})
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
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
	
	public String captureScreen(String fileName) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ss = (TakesScreenshot) driver; 
		File input = ss.getScreenshotAs(OutputType.FILE);

		String outputPath = System.getProperty("user.dir")+"\\screenshots\\"+fileName+"_"+timeStamp+".png";
		File output = new File(outputPath);
		
		input.renameTo(output);
		
		return outputPath;
	}
}
