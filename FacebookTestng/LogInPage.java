package FacbookTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	WebDriver driver;
	// Locate web elements using @FindBy annotation
	@FindBy(xpath="//input[@id='email']")
	WebElement usernameField;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement passwordField;
	
	@FindBy(xpath="//*[@name='login']")
	WebElement loginButton;
	
	
	//-Constructor
	
	public LogInPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername() {
		usernameField.sendKeys("123");
	}
	
	public void enterPassword() {
		passwordField.sendKeys("LOPu@123");
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
}
