package com.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.org.Cucumber1.Baseclass;

public class loginpage extends Baseclass {
	public static WebDriver driver;
	public loginpage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public WebElement getName() {
		return name;
	}
	public WebElement getPass() {
		return pass;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	@FindBy(id = "username")
	private WebElement name;
	@FindBy(id = "password") 
	private WebElement pass;
	@FindBy(id = "login")
	private WebElement loginbtn; 
	
	

}
