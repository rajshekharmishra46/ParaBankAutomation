package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountsPage;
import utils.TestContextSetup;

public class AccountPageStepDefinition {
	private TestContextSetup testContextSetup;
	private AccountsPage accountsPage;

	public AccountPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.accountsPage =testContextSetup.pageObjectManager.getAccountsPage();
	}
	
	@Then("user verify login is successful")
	public void user_verfy_login_is_successful() {
		accountsPage.verifyLogin();
		
	}
	@Given("user navigates to account opening section")
	public void user_navigates_to_account_opening_section() {
	    accountsPage.openNewAccount();
	}
	@Given("user navigates to bill payment section")
	public void user_navigates_to_bill_payment_section() {
		accountsPage.billPayment();
	}
	@Given("user navigates to account overwiew section")
	public void user_navigates_to_account_overwiew_section() {
		accountsPage.accountOverview();
	}
	@When("user navigates to {string} account which is credited")
	public void user_navigates_to_account_which_is_credited(String accountType)  {
		
		accountsPage.selectAccount(accountType);
	}
	@When("user navigates to {string} account which is debit")
	public void user_navigates_to_account_which_is_debit(String accountType)  {
		
		accountsPage.selectAccount(accountType);
	}
}

