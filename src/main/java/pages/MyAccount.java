package pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CSVDataReader;
import utils.SeleniumWrappers;

public class MyAccount extends SeleniumWrappers{
	
	public MyAccount(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//login
	@FindBy(id = "session_key") 
	public WebElement emailOrPhone;
	@FindBy(id = "session_password") 
	public WebElement userPassword;
	@FindBy(xpath="//button [contains(text(), 'Sign in')]")
	public WebElement loginButton;
	


	public void loginInApp(String user, String pass) {
		sendKeys(emailOrPhone, user);
		sendKeys(userPassword, pass);
		click(loginButton);
	}
}
