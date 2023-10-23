package utils;

import java.io.FileReader;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;

public class SeleniumWrappers extends BaseTest {

	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//webelement.click();
	
	public Map<String, String> getCredentials() {
		String[] csvLineData;
		Map<String, String> credentials = new HashMap<String, String> (); 
		try {
			FileReader credentialsFile = new FileReader("C:\\Users\\ProBook 6470b\\OneDrive\\Desktop\\Linkedin project\\credentials.csv");
			CSVReader readCredentialsFile = new CSVReader(credentialsFile);
			csvLineData = readCredentialsFile.readNext();
			
			while(csvLineData != null) {
				
				credentials.put(csvLineData[0], csvLineData[2]);
				credentials.put(csvLineData[1], csvLineData[3]);
				readCredentialsFile.close();
			}
				
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		

		return credentials;
		
	}
	
	public void click(WebElement element) {
		Log.info("Called method<click> on  " );
		try {
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			
		}catch(StaleElementReferenceException e) {
			Log.info("StaleElement exception caught -> retrying to find element" );

			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.stalenessOf(element));
			element.click();

		}catch(NoSuchElementException e) {
			Log.error(e.getMessage());
			//Log.error(e.printStackTrace());
		}
		
	}
	
	public void sendKeys(WebElement element, String text) {
		Log.info("called method <sendKeys> on element " + element.getAttribute("outerHTML"));
		try {
			//WebElement element = driver.findElement(locator);
			waitForElementToBeVisible(element);
			element.clear();
			element.sendKeys(text);
			
		}catch (Exception e) {
			Log.error(e.getMessage());	
		}
		
	}
	
	
	public void waitForElementToBeVisible(WebElement element) {
		Log.info("Called method <waitForElementToBeVisible> on locator :");
		try {
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));

		}catch(NoSuchElementException e) {
			Log.error(e.getMessage());
		}
	}
	
	
	
	public WebElement returnWebElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public boolean checkElementIsDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
}