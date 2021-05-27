package com.cucumber.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;




import org.openqa.selenium.WebDriver;

import com.cucumber.org.Cucumber1.Baseclass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src\\test\\java\\features\\login1.feature",
                    glue ="com\\cucumber\\stepdefinition",
                    dryRun = false,
                    monochrome = true,
                    plugin = "pretty",
                    tags = {"@tags"}
                    )
                 
public class Runner {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static  void setup() {
    driver=Baseclass.browserLaunch("chrome");
	}
	@AfterClass
	public static void close() {
		Baseclass.quit();
		
		
    
	}

}
