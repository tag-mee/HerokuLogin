package StepsDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver ;
//	 @Before
//	    public void setUp() {
//	        driver = new ChromeDriver();
//	        driver.manage().window().maximize();
//	    }
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver =new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");		
	    
	}
	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement login = driver.findElement(By.id("username"));
		WebElement pass =driver.findElement(By.id("password"));
		login.sendKeys("tomsmith");
		pass.sendKeys("SuperSecretPassword!");
	    
	}
	@When("I click on the login button")
	public void i_click_on_the_login_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement logBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
		logBtn.click();
		Thread.sleep(3000);
	    
	}
	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() {
		
	    // Write code here that turns the phrase above into concrete actions
		String Actual= driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).getText();
		
		String Expected = "Logout";
		Assert.assertEquals(Expected, Actual,"Didn't logged in properly");
	    
	}
	@After
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}


}
