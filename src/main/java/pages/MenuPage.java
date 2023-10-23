package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers {

	public MenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
																																																				
	

	//cookies
	@FindBy(xpath = "//button [contains(text(), 'Reject')]") 
	public WebElement rejectCookies;
	@FindBy(xpath="//button [contains(text(), 'Accept')]")
	public WebElement acceptCookies;
	
//search
	@FindBy(xpath = "//input[@class='search-global-typeahead__input']") 
	public WebElement searchTab;
	@FindBy(xpath = "//*[@id=\"search-reusables__filters-bar\"]/ul/li[1]/button") 
	public WebElement jobPage;

	
	public void search(String text) {
		Actions action =  new Actions(driver);
		searchTab.click();
		searchTab.clear();
		searchTab.sendKeys(text);
		action.sendKeys(Keys.ENTER)
		.perform();

	}
}
