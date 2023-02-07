package com.vtiger;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganization {
	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8888");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.linkText("Organizations")).click();
        Random r = new Random();
        int num = r.nextInt(100);
        driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
        driver.findElement(By.name("accountname")).sendKeys("Ching"+num);
        WebElement industryDd = driver.findElement(By.name("industry"));
        Select select = new Select(industryDd);
        select.selectByValue("Banking");
        WebElement accountType = driver.findElement(By.name("accounttype"));
        Select select2 = new Select(accountType);
        select2.selectByValue("Analyst");
        driver.findElement(By.name("button")).click();
        Thread.sleep(2000);
        WebElement adminImg = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
        Actions act = new Actions(driver);
        act.moveToElement(adminImg).perform();
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
