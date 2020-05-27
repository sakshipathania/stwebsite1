package SetupClass.TestStep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Facebook_existing_user_sign_in extends Set{
	
	WebDriverWait wait = new WebDriverWait(driver,50);

	@Given("^user is already on Home Page old fb$")
	public void user_is_already_on_Home_Page_old_fb() throws InterruptedException {
		
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(5000);

		try {
			driver.findElement(By.cssSelector("div.social-login-authentication-channel:nth-child(3) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL");
		} 
		catch (NoSuchElementException popup) {
		}
	    
	}

	@Then("^User click on sign in with facebook button old fb$")
	public void user_click_on_sign_in_with_facebook_button_old_fb() throws InterruptedException  {
		
		driver.get("https://www.slideteam.net/");
		Thread.sleep(4000);
		WebElement fb_link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-block btn-social btn-facebook social-btn']")));
		Thread.sleep(2000);
	    fb_link.click();
		Thread.sleep(3000);
		

	    WebElement fb_email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		Thread.sleep(2000);
	    fb_email.sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(2000);

	    WebElement fb_pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
		Thread.sleep(2000);
	    fb_pass.sendKeys("himanshi@123");
		Thread.sleep(2000);

	    
	    WebElement fb_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.id("loginbutton")));
		Thread.sleep(2000);

	    fb_login_btn.click();
		
	}

	@Then("^user go to free ppts page old fb$")
	public void user_go_to_free_ppts_page_old_fb() throws InterruptedException  {
	 
		//free ppt pg
		Thread.sleep(4000);
		WebElement free_ppt_btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Free PPTs')]")));
		Thread.sleep(2000);
	    free_ppt_btn.click();
		Thread.sleep(1000);

	}

	@Then("^user download a free ppt old fb$")
	public void user_download_a_free_ppt_old_fb() throws InterruptedException  {
	 
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("li.product:nth-child(4) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > span:nth-child(1) > a:nth-child(1)")).click();
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
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#clicking")).click();
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		// logout
		Thread.sleep(2000);
		try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				Thread.sleep(1000);
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
		
	}

}
