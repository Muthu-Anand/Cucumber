package com.cucumber.org.Cucumber1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {
	


	public static WebDriver driver;

	public static WebDriver browserLaunch(String option) {
		try {
			if (option.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (option.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (option.equals("ie")) {
				System.setProperty("web  driver.ie.driver", System.getProperty("user.dir")+"\\driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver pageLoadWait(int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver implicitTimeOut(int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		return driver;
	}

	public static void exciplitTimeOut(int timeOut, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void sendKeys(WebElement element, String input) {
		element.clear();
		element.sendKeys(input);
	}

	public static void close() {
		driver.close();
	}

	public static void scrollUpAndDown(String option) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (option.equalsIgnoreCase("up")) {
			js.executeScript("window.scrollBy(0,400)");
		} else if (option.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollBy(0,-400)");
		}
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void quit() {
		driver.quit();
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void navigateForword() {
		driver.navigate().forward();
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void alert(String option) {
		Alert alert = driver.switchTo().alert();
		if (option.equalsIgnoreCase("accept")) {
			alert.accept();
		} else if (option.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
		} else {
			alert.sendKeys(option);
		}
	}

	public static void action(WebElement element, String option) {
		Actions mouseMovement = new Actions(driver);
		if (option.equalsIgnoreCase("movetoelement")) {
			mouseMovement.moveToElement(element).build().perform();
		} else if (option.equalsIgnoreCase("contextClick")) {
			mouseMovement.contextClick(element).build().perform();
		}
	}

	public static void select(WebElement element, String option, String value) {
		Select dropDown = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			dropDown.selectByIndex(index);
		} else if (option.equalsIgnoreCase("text")) {
			dropDown.selectByVisibleText(value);
		} else if (option.equalsIgnoreCase("value")) {
			dropDown.selectByValue(value);
		}
	}

	public static void windowHandle(String id) {
		driver.switchTo().window(id);
	}

	public static void iFrame(String option, String input) {
		if (option.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(input);
			driver.switchTo().frame(index);
		} else if (option.equalsIgnoreCase("id")) {
			driver.switchTo().frame(input);
		} else if (option.equalsIgnoreCase("element")) {
			WebElement webelement = driver.findElement(By.xpath(input));
			driver.switchTo().frame(webelement);
		}
	}

	public static void robot(int count) {
		try {
			Robot keyboard = new Robot();
			for (int i = 1; i <= count; i++) {
				keyboard.keyPress(KeyEvent.VK_DOWN);
			}
			keyboard.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}

	public static void isSelected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println(selected);
	}

	public static void isEnabled(WebElement element) {
		boolean isEnabled = element.isEnabled();
		System.out.println(isEnabled);
	}

	public static void getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void getAttribute(WebElement element, String option, String input) {
		if (option.equalsIgnoreCase("value")) {
			element.getAttribute(input);
		} else if (option.equalsIgnoreCase("attribute")) {
			element.getAttribute(input);
		}
	}

	public static void screenShot(String input) {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File(
					"C:\\Users\\DELL\\eclipse-workspace\\additoin\\java.core\\Selenuium_Project\\src\\selenium_overallPractice\\screenShot\\"
							+ input + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getOptions(WebElement element) {
		Select dropDown = new Select(element);
		List<WebElement> options = dropDown.getOptions();
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}

	}

	public static void getFirstSelected(WebElement element) {
		Select dropDown = new Select(element);
		WebElement firstSelectedOption = dropDown.getFirstSelectedOption();
		System.out.println(firstSelectedOption);
	}

	public static void getAllSelectedOptions(WebElement element) {
		Select dropDown = new Select(element);
		List<WebElement> allSelectedOptions = dropDown.getAllSelectedOptions();
		System.out.println(allSelectedOptions);
	}

	public static void isMultiple(WebElement element) {
		Select dropDown = new Select(element);
		boolean multiple = dropDown.isMultiple();
		System.out.println(multiple);

	}

}

