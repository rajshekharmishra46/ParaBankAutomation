package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.GenericUtils;
import utils.TestContextSetup;

public class AccountsPage extends GenericUtils {
	public WebDriver driver;
	public static String account_TransferFund; 
	public static String balance_TransferFund;
	public static String availableAmount_TransferFund;
	public static String minAmountRequired;
	public AccountsPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
	} 
	private By header = By.cssSelector(".logo");
	public String getHeader() {
		
		return driver.findElement(header).getAttribute("title");
	}
	private By welcomeName = By.xpath("//p[contains(text(),'John')]");
	public void verifyLogin() {
		Assert.assertEquals("ParaBank | Accounts Overview", getTitle());
	    Assert.assertTrue(driver.findElement(welcomeName).isDisplayed());
		
		
	}
	private By openNewAccount = By.xpath("//a[@href='/parabank/openaccount.htm']");
	private By billPay = By.xpath("//a[@href='/parabank/billpay.htm']");
	private By accountOverview = By.xpath("//a[@href='/parabank/overview.htm']");
	private By account_ToTransferFund = By.xpath("//tbody/tr[1]/td/a");
	private By balance_ToTransferFund = By.xpath("//tbody/tr[1]/td[2]");
	private By availableAmount_ToTransferFund = By.xpath("//tbody/tr[1]/td[3]");
	
	public void getAccountDetails_ToTransferFund() {
		account_TransferFund = driver.findElement(account_ToTransferFund).getText();
		
		
		balance_TransferFund = driver.findElement(balance_ToTransferFund).getText().split("\\$")[1];
		
		availableAmount_TransferFund = driver.findElement(availableAmount_ToTransferFund).getText().split("\\$")[1];
		
	}
	private By minAmountInstruction = By.xpath("//form/p[2]/b");
	public static String billPayTitleActual;
	
	public void openNewAccount() {
		if(OpenAccountPage.accountCategory==null)
				getAccountDetails_ToTransferFund();
		moveToEleAndClick(driver.findElement(openNewAccount));
		minAmountRequired = driver.findElement(minAmountInstruction).getText().split("\\$")[1].split(" ")[0];
		}

	public void billPayment() {
		billPayTitleActual=driver.findElement(billPay).getText();
		moveToEleAndClick(driver.findElement(billPay));
	}
	
	public void accountOverview() {
		moveToEleAndClick(driver.findElement(accountOverview));
	}
	//private By accountNo = By.xpath("//tr/td/a");
	private WebElement accountNo(String str) {
		return driver.findElement(By.xpath("//tr/td/a[text()='"+str+"']"));
	}
	public void selectAccount(String accountCategory)  {
		
		if(accountCategory.contains("SAVINGS")) {
			webDriverWait_textToBeWebEle(accountNo(OpenAccountPage.savingAccountNo),OpenAccountPage.savingAccountNo);
			moveToEleAndClick(accountNo(OpenAccountPage.savingAccountNo));
		}
		if(accountCategory.contains("CHECKING")) {
			webDriverWait_textToBeWebEle(accountNo(OpenAccountPage.checkingAccountNo),OpenAccountPage.checkingAccountNo);
			moveToEleAndClick(accountNo(OpenAccountPage.checkingAccountNo));
		}
			
		
		
	}

}
