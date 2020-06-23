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

public class Sign_in_existing_free_user extends Set{
	WebDriverWait wait = new WebDriverWait(driver,50);
	
	@Given("^user is already on sign in page efu$")
	public void user_is_already_on_sign_in_page_efu() throws InterruptedException  {
		
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(1000);
	    
		try {
			driver.findElement(By.cssSelector(".authorization-link > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL");
		} 
		catch (NoSuchElementException popup) {
		}
	    
	}

	@Then("^user enter email and password efu$")
	public void user_enter_email_and_password_efu() throws InterruptedException  {
		
		Thread.sleep(1000);
		WebElement old_email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[2]/div[2]/form/fieldset/div[2]/div/input")));
		Thread.sleep(1000);
	    old_email.sendKeys("himanshi@test.com");
	    Thread.sleep(1000);
	    WebElement old_pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[2]/div[2]/form/fieldset/div[3]/div/input")));
	    Thread.sleep(1000);
	    old_pass.sendKeys("123456");
	    Thread.sleep(1000);
	    
	   
	}

	@Then("^user click on login button efu$")
	public void user_click_on_login_button_efu() throws InterruptedException  {
	    
		 WebElement old_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.login > span:nth-child(1)")));
		 Thread.sleep(1000);
		    old_login_btn.click();
	}

	@Then("^user go to free ppts page efu$")
	public void user_go_to_free_ppts_page_efu() throws InterruptedException  {
		Thread.sleep(2000);

		WebElement free_ppt_btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Free PPTs')]")));
		Thread.sleep(2000);

	    free_ppt_btn.click();
	}

	@Then("^user download a free ppt$")
	public void user_download_a_free_ppt() throws InterruptedException  {
	    
		//driver.findElement(By.xpath("//a[contains(.,'3d Puzzle Pieces In Line Powerpoint Presentation …')]")).click();
		driver.get("https://www.slideteam.net/2d-pyramid-simple-powerpoint-presentation-slides.html");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#clicking")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2300);
		
	}

	@Then("^user logout efu\\.$")
	public void user_logout_efu() throws Throwable {
	   Thread.sleep(8000);
	        
	    WebElement my_account = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.page-wrapper > header > div.header.content > div.panel.wrapper > div > div > ul > li:nth-child(1) > a")));
	    Thread.sleep(4000);
	   my_account.click();
	    Thread.sleep(4000);
	    
	
		 Thread.sleep(3000);
		 WebElement sign_out = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.page-wrapper > header > div.header.content > div.panel.wrapper > div > div > ul > li.authorization-link > a")));
		 Thread.sleep(3000);
		 sign_out.click();
		 Thread.sleep(3000);
		
	}
	
}
