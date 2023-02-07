package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	WebDriver driver;
	@FindBy(name = "user_name")
	private WebElement uName;
	
	@FindBy(name ="user_password")
	private WebElement pWord;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getuName() {
		return uName;
	}
	public WebElement getpWord() {
		return pWord;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	
}
