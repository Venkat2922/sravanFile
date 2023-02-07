package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageClass {
	WebDriver driver;
	@FindBy(linkText = "Organizations")
	private WebElement orgBtn;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutBtn;
	
	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgBtn() {
		return orgBtn;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}

}
