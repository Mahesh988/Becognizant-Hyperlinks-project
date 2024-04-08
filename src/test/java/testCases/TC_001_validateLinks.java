package testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_validateLinks extends BaseClass {
	@Test(priority = 0)
	public void checkingHREFLinks() throws IOException {
		HomePage hp = new HomePage(driver);
		List<WebElement> links = hp.getLinks();
		for(WebElement link : links) {
			System.out.println(link.getText());
			String url = link.getAttribute("href");	
			URL link1 = new URL(url); 
		      HttpURLConnection httpConn = (HttpURLConnection) link1.openConnection(); 
		      httpConn.connect();	      
		      int code = httpConn.getResponseCode(); 	          
		      // for broken link,number >400 
		      if(code >= 400) 
		      { 
		        System.out.println("Broken Link: "+url); 
		      } 
		      else
		      { 
		        System.out.println("Valid Link: "+url); 
		      }     
		    } 
		System.out.println(); 
	}
}
