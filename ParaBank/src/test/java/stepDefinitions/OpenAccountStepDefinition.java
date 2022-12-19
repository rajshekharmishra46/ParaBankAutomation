package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountsPage;
import pageObjects.OpenAccountPage;
import utils.TestContextSetup;

public class OpenAccountStepDefinition {
	private TestContextSetup testContextSetup;
	private OpenAccountPage openAccountPage;

	public OpenAccountStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.openAccountPage =testContextSetup.pageObjectManager.getOpenAccountPage();
	}
	@When("user selects account type as {string}")
	public void user_selects_account_type_as(String accountType) {
		openAccountPage.selectSavingAccountCategory(accountType);
	}
	
	@When("user select an existing account to transfer fund into new account")
	public void user_select_an_existing_account_to_transfer_fund_into_new_account()  {
		openAccountPage.selectExistingAccount();
	}
	@When("user proceed for account opening")
	public void user_proceed_for_account_opening() {
		openAccountPage.selectOpenNewAccount();
	}
	
	@Then("user verify the account is created")
	public void user_verify_the_account_is_created() {
	    Assert.assertTrue(openAccountPage.accountOpenedConfirmation().isDisplayed());
	}
	
	@Then("user verify the new account number is generated")
	public void user_verify_the_new_account_number_is_generated() {
		
		Assert.assertTrue(openAccountPage.verifyNewSavingAccountNoGenerated().isDisplayed());
	}
	@Given("user navigates to created account details page")
	public void user_navigates_to_created_account_details_page() {
		openAccountPage.navigateToCreatedAccount();
	}

	


}
