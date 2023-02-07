package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationClass {
	WebDriver driver;
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createOrgBtn;
	 
	@FindBy(name = "accountname")
	private WebElement orgNameTf;
	
	@FindBy(name = "industry")
	private WebElement industryDd;
	
	@FindBy(name = "accounttype")
	private WebElement typeDd;
	
	@FindBy(name = "button")
	private WebElement sBtn;
	
	public CreateOrganizationClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}

	public WebElement getOrgNameTf() {
		return orgNameTf;
	}

	public WebElement getIndustryDd() {
		return industryDd;
	}

	public WebElement getTypeDd() {
		return typeDd;
	}

	public WebElement getsBtn() {
		return sBtn;
	}

}
