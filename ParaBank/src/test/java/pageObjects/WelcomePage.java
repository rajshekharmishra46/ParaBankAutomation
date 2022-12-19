package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.GenericUtils;

public class WelcomePage extends GenericUtils {
	public WebDriver driver;

	public WelcomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
	}
	private By header = By.cssSelector(".logo");
	public String getHeader() {
		
		return driver.findElement(header).getAttribute("title");
	}
	private By username = By.name("username");
	private By password = By.name("password");
	private By loginButton = By.cssSelector("div.login input[value='Log In']");
	public void login(String userName, String password) {
		inputValue(username, userName);
		inputValue(this.password, password);
		driver.findElement(loginButton).click();
	}
	public void verifyLandingPage() {
		Assert.assertEquals("ParaBank | Welcome | Online Banking", getTitle());
	    Assert.assertEquals("ParaBank",getHeader());
		
	}

	

	
}
