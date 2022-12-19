package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountsPage;
import pageObjects.BillPayPage;
import utils.TestContextSetup;

public class BillPayStepDefinition {
	
	private TestContextSetup testContextSetup;
	private BillPayPage billPayPage;

	public BillPayStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.billPayPage =testContextSetup.pageObjectManager.getBillPayPage();
	}

	@When("user finds the bill payment page is open")
	public void user_finds_the_bill_payment_page_is_open() {
	    billPayPage.verifyBillPaymentPage();
	}
	@Then("user fill the form with required details")
	public void user_fill_the_form_with_required_details(DataTable data) {
		//Address|City|State|Zip Code|Phone|Amount|
		String payeeName = data.asMaps().get(0).get("Payee Name");
		String address = data.asMaps().get(0).get("Address");
		String city = data.asMaps().get(0).get("City");
		String zipCode = data.asMaps().get(0).get("Zip Code");
		String state = data.asMaps().get(0).get("State");
		String phone = data.asMaps().get(0).get("Phone");
		String amount = data.asMaps().get(0).get("Amount");
		billPayPage.fillForm(payeeName,address,city,state,zipCode,phone,amount);
	}
	@Then("user selects created {string} account to receive payment")
	public void user_selects_created_account_to_receive_payment(String accountType) {
		billPayPage.selectAccountToReceivePayment(accountType);
	}
	@Then("user selects created {string} account to disburse payment")
	public void user_selects_created_account_to_disburse_payment(String accountType) {
		billPayPage.selectAccountTodisbursePayment(accountType);
	
	}
	@Given("user confirms the payment")
	public void user_confirms_the_payment() {
	    billPayPage.confirmToPay();
	}
	@Given("bill payment is successful")
	public void bill_payment_is_successful()  {
		
		billPayPage.verifyBillPaymentComplete();
	}

	    
}
