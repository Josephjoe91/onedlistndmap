package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomerSteps {
	
	static WebDriver driver;
	
	@Given("user launches demo telecom site")
	public void user_launches_demo_telecom_site() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\cucumber\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/index.html");
		driver.manage().window().maximize();
		
	}

	@Given("user clicks on add customer button")
	public void user_clicks_on_add_customer_button() throws Throwable  {
		try {
		handleframe();
		}catch(Exception e) {
			
		}
	driver.findElement(By.xpath("(//a[text()='Add Customer'][1])")).click();
	
	}

	@When("user enters all the fields")
	public void user_enters_all_the_fields() throws Throwable {
		try {
			handleframe();
			}catch(Exception e) {
				
			}
		driver.findElement(By.xpath("//label[@for='done'][1]")).click();
		driver.findElement(By.id("fname")).sendKeys("joe");
		driver.findElement(By.id("lname")).sendKeys("josef");
		driver.findElement(By.id("email")).sendKeys("djd@gmail.com");
		driver.findElement(By.name("addr")).sendKeys("tambaram");
		driver.findElement(By.id("telephoneno")).sendKeys("9884739293");
		
	}
	@When("user enters all the fields with one dimensional")
	public void user_enters_all_the_fields_with_one_dimensional(DataTable customerdata) throws Throwable {
		try {
			handleframe();
			}catch(Exception e) {
				
			}
		List<String> data= customerdata.asList(String.class);
		driver.findElement(By.xpath("//label[@for='done'][1]")).click();
		driver.findElement(By.id("fname")).sendKeys(data.get(0));
		driver.findElement(By.id("lname")).sendKeys(data.get(1));
		driver.findElement(By.id("email")).sendKeys(data.get(2));
		driver.findElement(By.name("addr")).sendKeys(data.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(data.get(4));
	    
	}
	@When("user enters all the fields with one dimensional map")
	public void user_enters_all_the_fields_with_one_dimensional_map(DataTable customerdata) throws Throwable {
		Map<String, String> data = customerdata.asMap(String.class, String.class);
		
		try {
			handleframe();
			}catch(Exception e) {
				
			}
		driver.findElement(By.xpath("//label[@for='done'][1]")).click();
		driver.findElement(By.id("fname")).sendKeys(data.get("Fname"));
		driver.findElement(By.id("lname")).sendKeys(data.get("Lname"));
		driver.findElement(By.id("email")).sendKeys(data.get("Email"));
		driver.findElement(By.name("addr")).sendKeys(data.get("Address"));
		driver.findElement(By.id("telephoneno")).sendKeys(data.get("phno"));
	    
	}
	
	@When("user clicks on the submit button")
	public void user_clicks_on_the_submit_button() throws Exception {
		
	driver.findElement(By.xpath("//input[@value='Submit'][1]")).click();
		}

	@Then("user should be displayed customer ID is generated or not")
	public void user_should_be_displayed_customer_ID_is_generated_or_not() throws Throwable {
		try {
		handleframe();
		}catch(Exception e) {
			
		}
		org.junit.Assert.assertTrue(driver.findElement(By.xpath("//td[@align='center'][2]")).isDisplayed());
		String text = driver.findElement(By.xpath("(//td[@align='center'])[2]")).getText();
		   System.out.println(text);
		   

	}
public void handleframe() throws Throwable {
	Thread.sleep(3000);
	 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
	 driver.findElement(By.id("closeBtn")).click();
	 driver.switchTo().parentFrame();
}

}
