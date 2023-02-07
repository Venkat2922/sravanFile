package com.vtiger;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import objectRepo.CreateOrganizationClass;
import objectRepo.HomePageClass;
import objectRepo.LoginPageClass;
import utilities.ExcelFile;
import utilities.PropertyFile;

public class OrgTest {
	@Test
	public void createOrg() throws Throwable {
		WebDriver driver = new ChromeDriver();
		PropertyFile propertyFile = new PropertyFile();
		LoginPageClass loginPageClass = new LoginPageClass(driver);
		driver.get(propertyFile.readDataFromProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPageClass.getuName().sendKeys(propertyFile.readDataFromProperty("username"));
		loginPageClass.getpWord().sendKeys(propertyFile.readDataFromProperty("password"));
		loginPageClass.getSubmitBtn().click();
		HomePageClass homePageClass = new HomePageClass(driver);
		homePageClass.getOrgBtn().click();
		ExcelFile excelFile = new ExcelFile();
		CreateOrganizationClass createOrganizationClass = new CreateOrganizationClass(driver);
		createOrganizationClass.getCreateOrgBtn().click();
		Random r = new Random();
		int num = r.nextInt(100);
		createOrganizationClass.getOrgNameTf().sendKeys(excelFile.readDataFromExcel("sheet1", 3, 0) + num);
		WebElement industryDdd = createOrganizationClass.getIndustryDd();
		Select select = new Select(industryDdd);
		select.selectByValue(excelFile.readDataFromExcel("sheet1", 1, 1));

		WebElement typeD = createOrganizationClass.getTypeDd();
		Select select2 = new Select(typeD);
		select2.selectByValue(excelFile.readDataFromExcel("sheet1", 1, 2));

		createOrganizationClass.getsBtn().click();
		Thread.sleep(2000);

		WebElement adminImg = homePageClass.getAdminImg();
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		homePageClass.getSignOutBtn().click();
	}
}
