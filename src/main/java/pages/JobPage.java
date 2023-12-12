package pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class JobPage extends SeleniumWrappers{

	public JobPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()[contains(.,'Show')]]") 
	public WebElement showResult;
	@FindBy(xpath = "//button/span[text()[contains(.,'Reset')]]") 
	public WebElement reset;
	@FindBy(xpath = "//li-icon[@type ='cancel-icon']") 
	public WebElement cancelX;
	@FindBy(id = "adToggle_ember249") 
	public WebElement setAllert;
	
	//timePostedRange
	@FindBy(id = "searchFilter_timePostedRange") 
	public WebElement datePosted;
	@FindBy(xpath = "//p/span[text()[contains(.,'Any time')]]") 
	public WebElement anyTime;
	@FindBy(xpath = "//p/span[text()[contains(.,'Past month')]]") 
	public WebElement pastMonth;
	@FindBy(xpath = "//p/span[text()[contains(.,'Past week')]]") 
	public WebElement pastWeek;
	@FindBy(xpath = "//p/span[text()[contains(.,'Past 24 hours')]]")
	public WebElement past24Hours;
	
	
	//filterByExperienceLevel
	@FindBy(id = "searchFilter_experience") 
	public WebElement experienceLevel;
	@FindBy(xpath = "//p/span[text()[contains(.,'Internship')]]") 
	public WebElement internship;
	@FindBy(xpath = "//p/span[text()[contains(.,'Entry level')]]") 
	public WebElement entryLevel;
	@FindBy(xpath = "//p/span[text()[contains(.,'Associate')]]") 
	public WebElement associate;
	@FindBy(xpath = "//p/span[text()[contains(.,'Mid-Senior level')]]") 
	public WebElement midSenior;
	@FindBy(xpath = "//p/span[text()[contains(.,'Director')]]") 
	public WebElement director;
	@FindBy(xpath = "//p/span[text()[contains(.,'Executive')]]") 
	public WebElement executive;
	
	//filterByComapny
	@FindBy(id = "searchFilter_company") 
	public WebElement company;
	@FindBy(xpath = "//input[@placeholder='Add a company']") 
	public WebElement addCompany;
	
	//easy apply
	@FindBy(id = "//button[text()[contains(.,'Easy Apply')]]") 
	public WebElement easyApply;
	
	//filterByOn-Site/Remote
	@FindBy(id = "searchFilter_workplaceType") 
	public WebElement workplaceType;
	@FindBy(xpath = "//span[text()[contains(.,'Hybrid')]]") 
	public WebElement hybrid;
	@FindBy(xpath = "//span[text()[contains(.,'Remote')]]") 
	public WebElement remote;
	@FindBy(xpath = "//span[text()[contains(.,'On-Site')]]") 
	public WebElement onSite;
	
	//allfilters
	@FindBy(id = "ember347") 
	public WebElement allFilters;
	@FindBy(xpath = "//span[text()[contains(.,'Green Jobs')]]") 
	public WebElement greenJobs;
	
	//filterByLocation
	@FindBy(xpath = "//h3[text()[contains(.,'Location')]]") 
	public WebElement bucharest;

	//filterByIndustry
	@FindBy(xpath = "//h3[text()[contains(.,'Industry')]]")
	public WebElement industry;

	
	public void filterBy( WebElement filter, WebElement value) {
		filter.click();
		if (!value.isSelected()) {
			value.click();
		}
	}
	
	
	public void filterByExperienceLevel( WebElement filter, List<WebElement> experienceList ) {
		filter.click();
		for (WebElement experienceLevel : experienceList) {		
			if(!experienceLevel.isSelected()) {		
				experienceLevel.click();
			}
        }
	}
	
	public void filterByCompany( WebElement filter, List<String> companyList){
		filter.click();	
		for (String company : companyList) {		
			Actions action =  new Actions(driver);		
			action
			.click(addCompany)
			.sendKeys(company)
			.sendKeys(Keys.TAB, Keys.ENTER)
			.perform();	
		}
	
	}
	
	public void filterByListValue( WebElement filter, List<String> companyList){
		JavascriptExecutor jse = (JavascriptExecutor) driver;	
		jse.executeScript("arguments[0].scrollIntoView()", filter);
		for (String company : companyList) {
			driver.findElement(By.xpath("//td[normalize-space(text())=**company**]/a")).click();


		}
	
	}
	
	public void showResults( WebElement result ) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", result);
	}
	
	
}
