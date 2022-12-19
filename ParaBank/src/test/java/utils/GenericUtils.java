package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public void SwitchWindowToChild()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1 =s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}
	public String getTitle() {
		return	driver.getTitle();
			
		}
	public void inputValue(By ele, String str) {
		moveToEle(driver.findElement(ele));
		webDriverWait_elementToBeClickable(ele);
		driver.findElement(ele).clear();
		driver.findElement(ele).sendKeys(str);
	}
	public Select selectValueFromDropdown(By ele) {
		Select se = new Select(driver.findElement(ele));
		return se;
	}
	public void webDriverWait_elementToBeClickable(By ele) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public void webDriverWait_textToBe(By ele,String text) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBe(ele,text));
	}
	public void webDriverWait_textMatches(By ele,String text) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textMatches(ele, null));
	}
	public void webDriverWait_presenceOfElement(By ele) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
	}
	
	public void webDriverWait_textToBeWebEle(WebElement ele,String text) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
	}
	public void webDriverWait_presenceOfAllElements(By ele) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ele));
	}
	public void moveToEleAndClick(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		actions.click().build().perform();
	}
	public void moveToEle(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		actions.build().perform();
	}


	
	
}
