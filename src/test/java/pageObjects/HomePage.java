package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) 
	{
		super (driver);
	}
	
	@FindBy(xpath="//div[@class = 'footer-site-map']//a")
	List<WebElement> links;
	
	public List<WebElement> getLinks() {
		return links;
	}
}
