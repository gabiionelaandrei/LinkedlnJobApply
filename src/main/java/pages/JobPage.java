package pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class JobPage extends SeleniumWrappers{

	public JobPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
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
	
	
	
	@FindBy(xpath = "//button[@id='ember929']/span[text()[contains(.,'Show')]]") 
	public WebElement showResults;
	@FindBy(xpath = "//button/span[text()[contains(.,'Reset')]]") 
	public WebElement reset;
	@FindBy(xpath = "//li-icon[@type ='cancel-icon']") 
	public WebElement cancelX;
	
	
	//filterByTimePostedRange
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
	
	
	@FindBy(id = "searchFilter_company") 
	public WebElement company;
	@FindBy(id = "searchFilter_workplaceType") 
	public WebElement workplaceType;
	@FindBy(id = "searchFilter_workplaceType") 
	public WebElement ember643;
	
	
	public void filterByTimePostedRange( WebElement filter, WebElement value) {
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
	
	
}
