package SetupClass.TestStep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Google_existing_user_sign_in extends Set {

	WebDriverWait wait = new WebDriverWait(driver,50);
	
	@Given("^user is already on Home Page old gmail$")
	public void user_is_already_on_Home_Page_old_gmail() throws InterruptedException  {
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(2000);
	

		try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
		Thread.sleep(3000);
		try {
			// click on sign in with google button on home page
			driver.findElement(By.cssSelector("div.social-login-authentication-channel:nth-child(3) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL");
		} 
		catch (NoSuchElementException popup) {
		}
	    
	}

	@Then("^User click on sign in with google plus button old gmail$")
	public void user_click_on_sign_in_with_google_plus_button_old_gmail() throws InterruptedException  {
		Thread.sleep(2000);
		WebElement gmail_email = wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId")));
		Thread.sleep(2000);
	    gmail_email.sendKeys("himanshi.sharma@slidetech.in");
	    Thread.sleep(2000);
	    WebElement next_1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#identifierNext > span:nth-child(3) > span:nth-child(1)")));
	    Thread.sleep(2000);
	    next_1.click();
	    Thread.sleep(2000);
	    WebElement gmail_pass = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".I0VJ4d > div:nth-child(1) > input:nth-child(1)")));
	    Thread.sleep(2000);
	    gmail_pass.sendKeys("himanshi@123");
	    
	    Thread.sleep(2000);
	    WebElement next_2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#passwordNext > span:nth-child(3)")));
	    Thread.sleep(2000);
	    next_2.click();
	    Thread.sleep(2000);
	    
		/*
		 * WebElement
		 * gmail_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.id(
		 * "loginbutton"))); gmail_login_btn.click();
		 */
	}

	@Then("^user go to free ppts page old gmail$")
	public void user_go_to_free_ppts_page_old_gmail() throws InterruptedException  {
		Thread.sleep(3000);
		WebElement free_ppt_btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Free PPTs')]")));
		Thread.sleep(2000);
	    free_ppt_btn.click();
	    Thread.sleep(2000);
	}

	@Then("^user download a free ppt old gmail$")
	public void user_download_a_free_ppt_old_gmail() throws InterruptedException  {
		driver.findElement(By.cssSelector("li.product:nth-child(2) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > span:nth-child(1) > a:nth-child(1)")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#clicking")).click();
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Then("^logout pld gmail$")
	public void logout_pld_gmail() throws Throwable {
	   
		Thread.sleep(2000);
	    WebElement my_account_og = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'My Account')]")));
	    Thread.sleep(2000);
	   my_account_og.click();
	    Thread.sleep(2000);
   
		 Thread.sleep(3000);
		 WebElement sign_out = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Sign Out')]")));
		 Thread.sleep(2000);
		 sign_out.click();
		 Thread.sleep(3000);
		
	}
	
}
