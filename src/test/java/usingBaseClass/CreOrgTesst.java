package usingBaseClass;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import objectRepo.CreateOrganizationClass;
import objectRepo.HomePageClass;
import utilities.BaseC;
import utilities.ExcelFile;

public class CreOrgTesst extends BaseC{
	@Test
	public void cretOr() throws Throwable {
		homePageClass = new HomePageClass(driver);
		homePageClass.getOrgBtn().click();
		CreateOrganizationClass createOrganizationClass = new CreateOrganizationClass(driver);
		ExcelFile excelFile = new ExcelFile();
		createOrganizationClass.getCreateOrgBtn().click();
		Random r = new Random();
		int num = r.nextInt(100);
		createOrganizationClass.getOrgNameTf().sendKeys(excelFile.readDataFromExcel("sheet1", 5, 0) + num);
		WebElement indDd = createOrganizationClass.getIndustryDd();
		Select s = new Select(indDd);
		s.selectByValue(excelFile.readDataFromExcel("sheet1", 3, 1));
		WebElement typeD = createOrganizationClass.getTypeDd();
		Select s2 = new Select(typeD);
		s2.selectByValue(excelFile.readDataFromExcel("sheet1", 4, 2));
		createOrganizationClass.getsBtn().click();
		Thread.sleep(3000);
	}

}
