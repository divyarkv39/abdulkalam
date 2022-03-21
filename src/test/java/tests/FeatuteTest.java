package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FeatuteTest {
	RemoteWebDriver driver;
	
	@Given("open {string} browser")
	public void open_browser(String x) 
	{
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	}

	@Given("launch site using {string}")
	public void launch_site_using(String site)
	{
		driver.get(site);
	}

	@When("do login using {string} and {string}")
	public void do_login_using_and(String un, String pwd)throws Exception
	{
	    driver.findElement(By.name("identifier")).sendKeys(un);
	    driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
	}

	@Then("compose is displayed")
	public void compose_is_displayed() 
	{
		if(driver.findElement(By.xpath("//div[text()='Compose']")).isDisplayed())
				{
			
					System.out.println("compose is displayed");
				}
		else
		{
			System.out.println("compose is not displayed");
			System.exit(0);
		}
	}

	@When("click on compose")
	public void click_on_compose()throws Exception
	{
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		Thread.sleep(5000);
	}

	@Then("fields should be  displayed")
	public void fields_should_be_displayed()
	{
		
			System.out.println("fields should not be displayed");
		
	}

	@When("fill fields with {string}, {string},{string} and {string}") 
	public void fill_fields_with_and(String to, String sub, String body, String attach)throws Exception
	{
		driver.findElement(By.name("to")).sendKeys(to);
		driver.findElement(By.name("subjectbox")).sendKeys(sub);
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(body);
		driver.findElement(By.xpath("//input[@name='Filedata']")).sendKeys(attach);
		Thread.sleep(5000);
	}

	@Then("send is enabled")
	public void send_is_enabled() 
	{
			System.out.println("Send button is enabled");
		
	}

	@When("click on send")
	public void click_on_send() throws Exception
	{
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		Thread.sleep(5000);
	    
	}

	@Then("{string} should be displayed")
	public void should_be_displayed(String msg)throws Exception 
	{
		String output=driver.findElement(By.xpath("//div[@role='alert']/descendant::span[2]")).getText();
			System.out.println("correct message");
	   
	}

	@When("do logout")
	public void do_logout()throws Exception
	{
		
		driver.findElement(By.xpath("//a[starts-with(@aria-label,'Google Account')]/img")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(2);
		driver.findElement(By.linkText("Sign out")).click();
		//driver.findElement(By.xpath("//div[@text()='Sign out']/..")).click();
		Thread.sleep(5000);
	}

	@Then("login page should be displayed")
	public void login_page_should_be_displayed() 
	{
		
			System.out.println("login page is displayed");	
		
	}

	@When("close site")
	public void close_site() 
	{
		driver.close();
	}


}
