package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	static public WebDriver driver;
	public Properties prop;
	
	 @BeforeTest
	 @Parameters({"browser"})
	public void setup(String browser) throws IOException{
		
		if(browser.equals("Chrome")) 
		{
			driver= new ChromeDriver();
		}
		else if(browser.equals("Edge")) 
		{
			driver = new EdgeDriver();
		}
		else if(browser.equals("Firefox")) 
		{
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
	}
	 @AfterTest
	 public void closeBrowser() {
		 driver.quit();
	 }
}
