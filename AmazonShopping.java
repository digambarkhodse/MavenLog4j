package com.Listener;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonShopping {

	WebDriver driver;
	static Logger log = Logger.getLogger(AmazonShopping.class);

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(priority = 1)
	public void signIn_ValidData1() throws InterruptedException {
		log.info("Signing in with Valid Data");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email")).sendKeys("digambarkhodse@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("amazon@1234");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		String title1 = driver.getTitle();
		if (title1.equals(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
			log.info("LogIn Succeessfully with Valid Data");

		}

		else {
			log.info("LogIn Unsuccessful with Valid Data");
		}

	}

	@Test(priority = 2)

	public void signIn_ValidData2() throws InterruptedException {
		log.info("Signing in with Valid Data");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email")).sendKeys("9767711139");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("amazon@1234");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		String title1 = driver.getTitle();
		if (title1.equals(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
			log.info("LogIn Succeessfully with Valid Data");
		}

		else {
			log.error("LogIn Unsuccessful with Valid Data");
		}

	}

	@Test(priority = 3)
	public void signIn_InValidData() {
		log.info("Signing In with Invalid Data");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email")).sendKeys("digambarkhodse@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("glob@2021");
		driver.findElement(By.id("signInSubmit")).click();

		Assert.assertEquals(driver.getTitle(), "Amazon Sign In");
		String title1 = driver.getTitle();
		if (title1.contains(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
			log.error("Logged In with invalid data");

		}

		else {
			log.info("LogIn Unsuccessful because of Invalid Data");
		}

	}

	@Test(priority = 4)
	public void signIn_Blank() {
		log.info("Signing In with Blank Data");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email")).sendKeys("");
		driver.findElement(By.id("continue")).click();
		WebElement loginText = driver.findElement(By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/div"));
		String text = loginText.getText();
		Assert.assertEquals(text, "Enter your email or mobile phone number");
		if (text.contains("Enter your email or mobile phone number")) {
			log.info("Unable to Login with blank data");
		}

		else {
			log.error("Logged In with blank data");
		}

	}

	@Test(priority = 5)
	public void searchBox() {
		log.info("Finding Search Box");
		boolean isPresent = driver.findElement(By.id("nav-search-bar-form")).isDisplayed();
		Assert.assertEquals(true, isPresent);
		if (isPresent) {
			log.info("Search Box is Present in Application");

		}

		else {
			log.error("Search Box is not in Application");

		}

	}

	@Test(priority = 6)
	public void searchItem() {
		log.info("Searching Item");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung Galaxy");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement element2 = driver.findElement(
				By.xpath("//span[normalize-space()='Samsung Galaxy M31 (Ocean Blue, 6GB RAM, 128GB Storage)']"));
		String mob = element2.getText();
		Assert.assertEquals(mob, "Samsung Galaxy M31 (Ocean Blue, 6GB RAM, 128GB Storage)");

		if (mob.equals("Samsung Galaxy M31 (Ocean Blue, 6GB RAM, 128GB Storage)")) {
			log.info("Item Searched ");
		}

		else {
			log.error("Incorrect Item searched");
		}

	}

	@Test(priority = 8)
	public void addressEdit() {
		log.info("Selecting Address");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email")).sendKeys("digambarkhodse@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("globalivl@2021");
		driver.findElement(By.id("signInSubmit")).click();
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[1]/a/div/div")).click();
		driver.findElement(By.id("ya-myab-address-edit-btn-0")).click();
		driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).clear();
		driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("Magico Medical");
		driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
		WebElement add = driver.findElement(By.xpath("//*[@id=\"yaab-alert-box\"]/div"));
		String address = add.getText();
		Assert.assertEquals(address, "Address saved");

		if (address.equals("Address saved")) {
			log.info("Address Saved Successfully");
		}

		else {
			log.error("Address not Saved");

		}

	}

	@Test(priority = 7)
	public void selectCategories() {

		log.info("Selecting Categories");
		driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[7]")).click();

		Assert.assertEquals(driver.getTitle(),
				"Electronics Store: Buy Electronics products Online at Best Prices in India at Amazon.in");
		String title1 = driver.getTitle();
		if (title1
				.contains("Electronics Store: Buy Electronics products Online at Best Prices in India at Amazon.in")) {
			log.info("Selected Correct Category");

		}

		else {
			log.error("Selected wrong Category");

		}

	}

	@AfterTest
	public void endTest() {
		log.info("Testing Completed");
		driver.quit();

	}

}
