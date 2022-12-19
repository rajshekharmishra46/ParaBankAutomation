package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.GenericUtils;

public class BillPayPage extends GenericUtils {
	public WebDriver driver;

	public BillPayPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void verifyBillPaymentPage() {
		String billPayTitleExpected=driver.getTitle().split("\\|")[1].trim();
		Assert.assertEquals(billPayTitleExpected, AccountsPage.billPayTitleActual);
	}
	private By payeeName = By.name("payee.name");
	private By address = By.name("payee.address.street");
	private By city = By.name("payee.address.city");
	private By state = By.name("payee.address.state");
	private By zipCode = By.name("payee.address.zipCode");
	private By phone = By.name("payee.phoneNumber");
	private By amount = By.name("amount");
	public void fillForm(String payeeName, String address, String city, String state,String zipCode, String phone, String amount) {
		inputValue(this.payeeName,payeeName);
		inputValue(this.address,address);
		inputValue(this.city,city);
		inputValue(this.state,state);
		inputValue(this.zipCode,zipCode);
		inputValue(this.phone,phone);
		inputValue(this.amount,amount);
	}
	private By payeeAccNo = By.name("payee.accountNumber");
	private By verifypayeeAccNo = By.name("verifyAccount");
	public void selectAccountToReceivePayment(String accountType) {
		
		if(accountType.contains("SAVINGS"))
		{
			inputValue(payeeAccNo,OpenAccountPage.savingAccountNo);
			inputValue(verifypayeeAccNo,OpenAccountPage.savingAccountNo);
		}
		if(accountType.contains("CHECKING"))
		{	
		inputValue(payeeAccNo,OpenAccountPage.checkingAccountNo);
		inputValue(verifypayeeAccNo,OpenAccountPage.checkingAccountNo);
		}
	}
	private By fromAccNo = By.name("fromAccountId");
	public void selectAccountTodisbursePayment(String accountType) {
		if(accountType.contains("SAVINGS"))
		selectValueFromDropdown(fromAccNo).selectByValue(OpenAccountPage.savingAccountNo);
		if(accountType.contains("CHECKING"))
		selectValueFromDropdown(fromAccNo).selectByValue(OpenAccountPage.checkingAccountNo);
	}
	private By sendPayment = By.xpath("//input[@value='Send Payment']");
	public void confirmToPay() {
		moveToEleAndClick(driver.findElement(sendPayment));
		driver.findElement(sendPayment).click();
	}

	private By billPaymentComplete = By.xpath("//div/h1[contains(text(),'Complete')]");
	public void verifyBillPaymentComplete() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pageTitle = driver.getTitle().split("\\|")[1].trim();
		String pageHeading = driver.findElement(billPaymentComplete).getText();
		Assert.assertTrue(pageHeading.contains(pageTitle));
	}

}
