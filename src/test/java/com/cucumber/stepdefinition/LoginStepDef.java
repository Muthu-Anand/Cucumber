package com.cucumber.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.cucumber.org.Cucumber1.Baseclass;
import com.cucumber.pom.loginpage;
import com.cucumber.runner.Runner;

import cucumber.api.java.en.*;

public class LoginStepDef extends Baseclass{
	public static WebDriver driver = Runner.driver;
	
	loginpage lp =new loginpage(driver);
    
	@Given("^User launch the application  url$")
	public void user_launch_the_application_url() throws Throwable {
		getUrl("https://adactinhotelapp.com/");
		
	}

	@When("^user enter \"([^\"]*)\" as username$")
	public void user_enter_as_username(String arg1) throws Throwable {
		sendKeys(lp.getName(), arg1);
	}

	@When("^user enter \"([^\"]*)\"as password$")
	public void user_enter_as_password(String arg1) throws Throwable {
		sendKeys(lp.getPass(), arg1);
	}

	@Then("^user verified user name and password with login btn$")
	public void user_verified_user_name_and_password_with_login_btn() throws Throwable {
	click(lp.getLoginbtn());
	}

}
