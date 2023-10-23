package utils;

import org.openqa.selenium.WebDriver;

import pages.JobPage;
import pages.MenuPage;
import pages.MyAccount;


public class BasePage  extends SeleniumWrappers{
	

	public BasePage(WebDriver driver) {
		super(driver);
	
	}
	public MenuPage menu =  new MenuPage(driver);
	public MyAccount account = new MyAccount(driver);
	public JobPage job = new JobPage(driver);
}