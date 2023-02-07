package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import objectRepo.HomePageClass;
import objectRepo.LoginPageClass;

public class BaseC {
	public WebDriver driver;
	public static WebDriver sdriver;
	PropertyFile propertyFile;
	public HomePageClass homePageClass;
	@BeforeSuite(groups = {"smoke", "integration"})
	public void connectToDB() 
	{
		System.out.println("==> connect to DataBase ==>");
	}
	@AfterSuite(groups = {"smoke", "integration"})
	public void disconnectToDB() 
	{
		System.out.println("==> Disconnect to DataBase ==>");
	}
	@BeforeClass(groups = {"smoke", "integration"})
	@Parameters("Browser")
	public void launchTheBrowser(String Browser) throws Throwable 
	{
		if(Browser.equals("chrome")) {
		driver = new ChromeDriver();
		sdriver = driver;
		}else {
			driver = new EdgeDriver();
			sdriver = driver;
		}
		propertyFile = new PropertyFile();
		driver.get(propertyFile.readDataFromProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@org.testng.annotations.AfterClass(groups = {"smoke", "integration"})
	public void closeTheBrowser() {
		driver.close();
	}
	@BeforeMethod(groups = {"smoke", "integration"})
	public void loginToApp() throws Throwable {
		propertyFile = new PropertyFile();
		LoginPageClass loginPageClass = new LoginPageClass(driver);
		loginPageClass.getuName().sendKeys(propertyFile.readDataFromProperty("username"));
		loginPageClass.getpWord().sendKeys(propertyFile.readDataFromProperty("password"));
		loginPageClass.getSubmitBtn().click();
	}
     @AfterMethod(groups = {"smoke", "integration"})
     public void logOutFromApp() {
    	 homePageClass = new HomePageClass(driver);
    	 WebElement adminImg = homePageClass.getAdminImg();
    	 Actions act = new Actions(driver);
    	 act.moveToElement(adminImg).perform();
    	 homePageClass.getSignOutBtn().click();
     }
}
