package anudip.assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage extends BaseTest{
	WebDriver driver;

	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement usernameInput;
	@FindBy(id = "pass")
	private WebElement passwordInput;
	@FindBy(name = "login")
	private WebElement loginButton;

	public void login(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
		driver.close();
	}
	
	
}
