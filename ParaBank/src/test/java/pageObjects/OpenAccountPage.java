package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.GenericUtils;
import utils.TestContextSetup;

public class OpenAccountPage extends GenericUtils {
	public WebDriver driver;
	public static String savingAccountNo;
	public static String checkingAccountNo;
	public static String accountCategory;
	public OpenAccountPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		
	}

	private By accountType = By.id("type");
	public void selectSavingAccountCategory(String accountCategory) {
		OpenAccountPage.accountCategory=accountCategory;
		selectValueFromDropdown(accountType).selectByVisibleText(accountCategory);
		
	}
	private By existingAccount = By.id("fromAccountId");
	public void selectExistingAccount()  {
		
		webDriverWait_elementToBeClickable(existingAccount);
//		
		selectValueFromDropdown(existingAccount).selectByVisibleText(AccountsPage.account_TransferFund);
		
	}
	private By openNewAccount = By.xpath("//input[@type='submit']");
	public void selectOpenNewAccount() {
		webDriverWait_elementToBeClickable(openNewAccount);
		moveToEleAndClick(driver.findElement(openNewAccount));
		driver.findElement(openNewAccount).click();
	} 
	private By accountOpened = By.xpath("//h1[contains(text(),'Account Opened!')]");
	public WebElement accountOpenedConfirmation() {
		
		return driver.findElement(accountOpened);
	}
	private By newAccount = By.id("newAccountId");
	public WebElement verifyNewSavingAccountNoGenerated()  {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(accountCategory.contains("SAVINGS")) {
			
			savingAccountNo = driver.findElement(newAccount).getText();
			
		}
		if(accountCategory.contains("CHECKING")) {
			checkingAccountNo = driver.findElement(newAccount).getText();
			
		}
		return driver.findElement(newAccount);
	}
	public void navigateToCreatedAccount() {
		moveToEleAndClick(driver.findElement(newAccount));
		//driver.findElement(newAccount).click();
		
	}

}
