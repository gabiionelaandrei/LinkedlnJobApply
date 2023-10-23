package pages;

import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class BasePage extends SeleniumWrappers {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	public MenuPage menu =  new MenuPage(driver);
	public MyAccount account =  new MyAccount(driver);
	public JobPage job = new JobPage(driver);
}