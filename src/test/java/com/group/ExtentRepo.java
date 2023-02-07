package com.group;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ExtentRepo 
{
      ExtentSparkReporter extentSparkReporter;
      ExtentTest extentTest;
      ExtentReports extentReports;
      @Test
      public void createRepo() {
    	  Random r = new Random();
    	  int num = r.nextInt(100);
    	  extentSparkReporter = new ExtentSparkReporter("./ExtentRep/vtiger"+num+".html");
    	  extentSparkReporter.config().setDocumentTitle("Facebook");
    	  extentSparkReporter.config().setTheme(Theme.STANDARD);
    	  
    	  extentReports = new ExtentReports();
    	  extentReports.attachReporter(extentSparkReporter);
    	  extentReports.setSystemInfo("browser", "chrome");
    	  extentReports.setSystemInfo("build", "2.3.4");
    	  extentReports.setSystemInfo("environment", "dev");
    	  extentReports.setSystemInfo("Reporter Name", "Rohit Vemuri");
    	  WebDriver driver = new ChromeDriver();
    	  driver.get("http://www.amazon.in");
    	 
    	  extentTest = extentReports.createTest("Rohit Amazon");
    	  TakesScreenshot takeScreenshort = (TakesScreenshot) driver;
  		File source = takeScreenshort.getScreenshotAs(OutputType.FILE);
  		String path = "./Screenshot/Fb.png";
  		File destination = new File(path);
  		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		 
  		extentTest.addScreenCaptureFromPath(path);
    	  extentReports.flush();
    	//  extentTest.addScreenCaptureFromPath(path);
    	  
      }
      
}
