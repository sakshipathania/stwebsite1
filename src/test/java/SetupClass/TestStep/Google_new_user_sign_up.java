package SetupClass.TestStep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Google_new_user_sign_up extends Set {
	
	WebDriverWait wait = new WebDriverWait(driver,60);
	
	
	@Given("^user is already on Home Page new google$")
	public void user_is_already_on_Home_Page_new_google() throws InterruptedException  {
	 
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(1000);
		driver.get("https://www.slideteam.net/");
		Thread.sleep(2000);
		
		try {
			// click on sign in with google button on home page
			driver.findElement(By.xpath("//a[contains(text(),'Sign in with Google')]")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL");
		} 
		catch (NoSuchElementException popup) {
		}
		
		
	}

	@Then("^User click on sign in with google button$")
	public void user_click_on_sign_in_with_google_button() throws InterruptedException  {
		Thread.sleep(2000);
		try
		{
			WebElement another_btn=driver.findElement(By.xpath("//div[text()='Use another account']"));
			another_btn.click();
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
		
		}
		Thread.sleep(3000);
		WebElement gmail_email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='identifierId']")));
		Thread.sleep(2000);
	    gmail_email.sendKeys("slidetech.qa@gmail.com");
	    Thread.sleep(2000);
	    WebElement next_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("#identifierNext > div > button > div.VfPpkd-RLmnJb")));
	    Thread.sleep(2000);
	    next_1.click();
	    Thread.sleep(2000);
	    WebElement gmail_pass = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".I0VJ4d > div:nth-child(1) > input:nth-child(1)")));
	    Thread.sleep(2000);
	    gmail_pass.sendKeys("Himanshi@123");
	    Thread.sleep(2000);
	    
	    WebElement next_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("#passwordNext > div > button > div.VfPpkd-RLmnJb")));
	    Thread.sleep(2000);
	    next_2.click();
	}

	@Then("^user go to free ppts page new google$")
	public void user_go_to_free_ppts_page_new_google() throws InterruptedException  {
		
		Thread.sleep(3000);
		WebElement free_ppt_btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Free PPTs')]")));
		Thread.sleep(2000);
	    free_ppt_btn.click();
	    Thread.sleep(5000);
		
	}

	@Then("^user download a free ppt new google$")
	public void user_download_a_free_ppt_new_google() throws InterruptedException  {
	   
		/*
		 * driver.findElement(By.
		 * cssSelector("li.product:nth-child(2) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > span:nth-child(1) > a:nth-child(1)"
		 * )).click(); Thread.sleep(5000);
		 * driver.findElement(By.cssSelector("#clicking")).click(); Thread.sleep(8000);
		 */
		
		driver.get("https://www.slideteam.net/prod-development-and-program-management.html");
		driver.findElement(By.id("clicking")).click();
		Thread.sleep(5000);
		driver.get("https://www.slideteam.net/");
		Thread.sleep(3000);
		
		
	}

	@Then("^user delete the google account new google$")
	public void user_delete_the_fb_account_new_google() throws InterruptedException  {
		
		/*
		 * WebElement my_account= (new WebDriverWait(driver, 40))
		 * .until(ExpectedConditions.presenceOfElementLocated(By.
		 * xpath("//a[contains(text(),'My Account')]"))); my_account.click();
		 * Thread.sleep(3000);
		 */
		 
	
		driver.get("https://www.slideteam.net/");
		   Thread.sleep(3000);
		   
		 driver.findElement(By.xpath("//a[contains(.,'My Account')]")).click();
		 Thread.sleep(3000);
		 
		 
		 driver.findElement(By.xpath("//a[contains(.,'Delete Account')]")).click();
		 Thread.sleep(3000);
		 


try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if(iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);   
				 Actions act = new Actions(driver);
				 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				 Thread.sleep(2000);
					WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
					 Thread.sleep(1000);
						chat1.click();
						 Thread.sleep(1000);
						 driver.switchTo().defaultContent();
						 Thread.sleep(1000);
						 driver.switchTo().parentFrame();
					 Thread.sleep(1000);
			}
			else {
				

			System.out.println("chat window does not open");
			}
		}
				catch(NoSuchElementException NCP) {
					
				}

     
		 Thread.sleep(3000);
		 WebElement continue_delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"deleteaccount-form\"]/button[1]")));
		 Thread.sleep(2000);

		 continue_delete.click();
		 Thread.sleep(3000);
		
	}



}
