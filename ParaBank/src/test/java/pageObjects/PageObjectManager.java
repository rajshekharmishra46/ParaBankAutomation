package pageObjects;

import org.openqa.selenium.WebDriver;





public class PageObjectManager {
	
	
	public WebDriver driver;
	
	private WelcomePage welcomePage;
	private AccountsPage accountsPage;

	private OpenAccountPage openAccountPage;

	private AccountActivityPage accountActivityPage;

	private BillPayPage billPayPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
		
	}

	public WelcomePage getWelcomePage() {
		welcomePage = new WelcomePage(driver);
		return welcomePage;
	}



	public AccountsPage getAccountsPage() {
		accountsPage = new AccountsPage(driver);
		return accountsPage;
	}

	public OpenAccountPage getOpenAccountPage() {
		openAccountPage = new OpenAccountPage(driver);
		return openAccountPage;
	}

	public AccountActivityPage getAccountActivityPage() {
		accountActivityPage = new AccountActivityPage(driver);
		return accountActivityPage;
	}

	public BillPayPage getBillPayPage() {
		billPayPage = new BillPayPage(driver);
		return billPayPage;
	}

	
		
}
