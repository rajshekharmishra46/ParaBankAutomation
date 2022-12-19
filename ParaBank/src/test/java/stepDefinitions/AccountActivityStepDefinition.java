package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountActivityPage;
import pageObjects.AccountsPage;
import utils.TestContextSetup;

public class AccountActivityStepDefinition {
	private TestContextSetup testContextSetup;
	private AccountActivityPage accountActivityPage;

	public AccountActivityStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.accountActivityPage =testContextSetup.pageObjectManager.getAccountActivityPage();
	}

	@Then("user verify account number")
	public void user_verify_account_number() {
		accountActivityPage.verifyUserAccountNo();
	}

	@Then("user verify account type as {string}")
	public void user_verify_account_type_as(String string)  {
		accountActivityPage.verifyUserAccountType(string);
	}

	@Then("user verify the balance in the account")
	public void user_verify_the_balance_in_the_account() {
		accountActivityPage.verifyBalance();
	}

	@Then("user verify the available amount in the account")
	public void user_verify_the_available_amount_in_the_account() {
		accountActivityPage.verifyAvailableBalance();
	}
	@When("user finds the created account details page is open")
	public void user_finds_the_created_account_details_page_is_open() {
		accountActivityPage.verifyAccountDetailsPage(); 
	}
	@Then("user verify the transaction - {string} details")
	public void user_verify_the_transaction_debit_details(String transactionType,DataTable data) {
		
		String transactionAmount = data.asMaps().get(0).get("Amount");
		accountActivityPage.verifyTransaction(transactionAmount,transactionType);
	}

	
}
