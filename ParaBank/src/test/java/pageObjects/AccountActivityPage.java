package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.GenericUtils;

public class AccountActivityPage extends GenericUtils {
	public WebDriver driver;

	

	public AccountActivityPage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		
	}

	public void verifyAccountDetailsPage() {
		String accountNo=driver.getCurrentUrl().split("id=")[1];
		if(OpenAccountPage.accountCategory.contains("SAVINGS"))
			Assert.assertEquals(accountNo, OpenAccountPage.savingAccountNo);
		if(OpenAccountPage.accountCategory.contains("CHECKING"))
			Assert.assertEquals(accountNo, OpenAccountPage.checkingAccountNo);
	}
	private By accountId = By.id("accountId");
	public void verifyUserAccountNo()  {
		
		
		if(OpenAccountPage.accountCategory.contains("SAVINGS")) {
			webDriverWait_textToBe(accountId,OpenAccountPage.savingAccountNo);
			String accountNo=driver.findElement(accountId).getText();
			Assert.assertEquals(accountNo, OpenAccountPage.savingAccountNo);
		}
		if(OpenAccountPage.accountCategory.contains("CHECKING")) {
			webDriverWait_textToBe(accountId,OpenAccountPage.checkingAccountNo);
			String accountNo=driver.findElement(accountId).getText();
		    Assert.assertEquals(accountNo, OpenAccountPage.checkingAccountNo);
		}
	}
	private By accountType = By.id("accountType");
	public void verifyUserAccountType(String accountTypeExpected)  {
		
		
		webDriverWait_textToBe(accountType,accountTypeExpected);
		String accountTypeActual = driver.findElement(accountType).getText();
		
		Assert.assertEquals(accountTypeExpected,accountTypeActual);
	}
	private By balance = By.id("balance");
	public void verifyBalance() {
		double balanceActual = Double.parseDouble(driver.findElement(balance).getText().split("\\$")[1]);
			
		double minAmount = Double.parseDouble(AccountsPage.minAmountRequired );
		Assert.assertTrue(balanceActual>=minAmount);
		
	}
	private By availableBalance = By.id("availableBalance");
	public void verifyAvailableBalance() {
		double availableBalanceActual = Double.parseDouble(driver.findElement(availableBalance).getText().split("\\$")[1]);
		
		double minAmount = Double.parseDouble(AccountsPage.minAmountRequired );
		
		Assert.assertTrue(availableBalanceActual>=minAmount);
		
	}
	private By transactionTableCell = By.xpath("//table[@id='transactionTable']//td");
	private String transactionTableDesiredCell(int desiredCell) {
		return driver.findElement(By.xpath("(//table[@id='transactionTable']//td)["+desiredCell+"]")).getText().split("\\$")[1];
	}
	public void verifyTransaction(String transactionAmount, String transactionType) {
		webDriverWait_presenceOfAllElements(transactionTableCell);
		int desiredCell = driver.findElements(transactionTableCell).size();
		if(transactionType.equals("credit"))
			Assert.assertEquals(transactionTableDesiredCell(desiredCell),transactionAmount,transactionType +" amount is "+transactionAmount+" but "+transactionType+" amount in transaction table shows "+transactionTableDesiredCell(desiredCell));
		if(transactionType.equals("debit"))
			Assert.assertEquals(transactionTableDesiredCell(desiredCell-1), transactionAmount,transactionType +" amount is "+transactionAmount+" but "+transactionType+" amount in transaction table shows "+transactionTableDesiredCell(desiredCell-1));
	}

}
