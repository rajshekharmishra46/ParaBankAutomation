package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountsPage;
import pageObjects.WelcomePage;
import utils.TestContextSetup;

public class WelcomeStepDefinition {
	private TestContextSetup testContextSetup;
	private WelcomePage welcomePage;

	public WelcomeStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.welcomePage =testContextSetup.pageObjectManager.getWelcomePage();
	}
	
	@Given("user land on the correct page")
	public void user_land_on_the_correct_page() {
		welcomePage.verifyLandingPage();
	    
	    
	}

	@When("user login with username {string} and password {string}")
	public void user_login_with_username_and_password(String userName, String password) {
		welcomePage.login(userName,password);
	   
	}

	



}
