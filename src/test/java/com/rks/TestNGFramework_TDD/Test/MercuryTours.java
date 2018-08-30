package com.rks.TestNGFramework_TDD.Test;

import org.testng.annotations.Test;

import com.rks.TestNGFramework_TDD.Config.ConfigFileReader;
import com.rsk.TestNGFramework_TDD.Constants.e2ETestConstants;
import com.rsk.TestNGFramework_TDD.Pages.FlightFinderPage;
import com.rsk.TestNGFramework_TDD.Pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;


@Listeners(com.rks.TestNGFramework_TDD.Listener.testNGListener.class)

public class MercuryTours {
	
	static WebDriver driver;
	ConfigFileReader confFileReader = new ConfigFileReader();
// @Parameters("browser")
 @Test (priority = 0)
  public void mercuryToursLoginPage() {
	  WebElement findFlight = driver.findElement(LoginPage.findflight);
		if(findFlight.isDisplayed()) {
			System.out.println("User is on Login Page");
			Reporter.log("User is on Login Page", findFlight.isDisplayed());
			driver.findElement(LoginPage.userName).sendKeys(e2ETestConstants.UserName);
			Reporter.log("Username is Entered");
			driver.findElement(LoginPage.password).sendKeys(e2ETestConstants.password);
			Reporter.log("Paasword is Entered");
			driver.findElement(LoginPage.LogInBttn).click();
			Reporter.log("LogIn Button is Clicked");
		}
		else {
			System.out.println("User is not on Login Page");
			Reporter.log("User is NOT on Login Page", !(findFlight.isDisplayed()));			
		}
  }
  
  @Test(dependsOnMethods = {"mercuryToursLoginPage"}, priority =1)
  public void mercuryToursFlightFinderPage() {
	  
	  WebElement flightFinder = driver.findElement(FlightFinderPage.flightFinderCaption);
		if(flightFinder.isDisplayed()) {
			System.out.println("User is on Flight Finder Launch Page");
			Reporter.log("User is on Flight Finder Launch Page", flightFinder.isDisplayed());
			WebElement tripTypeRound = driver.findElement(FlightFinderPage.tripTypeRadioBttn);
			if(tripTypeRound.isSelected()) {
				System.out.println("Round Trip is selected");
				Reporter.log("Round Trip is selected", tripTypeRound.isSelected());
				WebElement passengerCount = driver.findElement(FlightFinderPage.passengerCount);
				Select oselectPassCounty = new Select(passengerCount);
				oselectPassCounty.selectByIndex(e2ETestConstants.passengerCountryDrpdwnOptions);
			}
			else {
				tripTypeRound.click();
				WebElement passengerCount = driver.findElement(FlightFinderPage.passengerCount);
				Select oselectPassCounty = new Select(passengerCount);
				oselectPassCounty.selectByIndex(e2ETestConstants.passengerCountryDrpdwnOptions);
			}
			
			WebElement departingFrom = driver.findElement(FlightFinderPage.departingFromdrpdwn);
			Select oselectDepartingCountry = new Select(departingFrom);
			oselectDepartingCountry.selectByIndex(e2ETestConstants.departingFromDrpdwnOption);
			System.out.println("Departing From dropdown is selected");
			Reporter.log("Departing From dropdown is selected", departingFrom.isDisplayed());
			
			WebElement arrivingTo = driver.findElement(FlightFinderPage.arrivingTodrpdwn);
			Select oselectArrivingCountry = new Select(arrivingTo);
			oselectArrivingCountry.selectByIndex(e2ETestConstants.arrivingToDrpdwnOption);
			System.out.println("Arriving In dropdown is selected");
			Reporter.log("Arriving In dropdown is selected", arrivingTo.isDisplayed());
			
			WebElement serviceClass = driver.findElement(FlightFinderPage.serviceClassType);
			if(serviceClass.isSelected()) {
				System.out.println("Economy Class Radio Button is selected");
			}
			else {
				serviceClass.click();
				System.out.println("Economy Class Radio Button is clicked");
			}
			
			WebElement continueButton = driver.findElement(FlightFinderPage.continueBttn);
			continueButton.click();
			System.out.println("Continue Button is clicked");			
		}
		
		else {
			System.out.println("User is not Flight Finder Launch Page");
		}
  }
  
  
  @BeforeMethod
  public void mercuryToursBeforeMethod() {
//	  if(browser.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", confFileReader.getDriverPath());
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(confFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
//	  }
	  /*else if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver", confFileReader.getDriverPathFirefox());
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(confFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	  }*/
//	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(confFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	  driver.get(confFileReader.getApplicationUrl());	  
  }

  @AfterMethod
  public void mercuryToursAfterMethod() {
	  driver.close();
	  driver.quit();	
  }

}
