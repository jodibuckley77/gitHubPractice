package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
	
	private static Logger log = LogManager.getLogger(LaunchBrowser.class.getName());

	public static WebDriver launchChrome() {
		
		System.setProperty("webdriver.chrome.driver", getDriverPath());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("http://google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info("Web Browser is launched successfully");
		return driver;
		
	}
	
	public static String getDriverPath() {
		try{
		String path = "D:\\practice\\selenium_practice_workspace\\search\\env.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		File file = new File(prop.getProperty("chromeDriverPath"));
		String driverPath = file.getAbsolutePath();
		return driverPath;
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	

}
