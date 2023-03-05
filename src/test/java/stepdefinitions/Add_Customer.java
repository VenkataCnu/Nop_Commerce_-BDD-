package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_Customer extends BaseClass {

	@Given("user launche the browser")
	public void user_launche_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@When("user opens the applications with url {string}")
	public void user_opens_the_applications_with_url(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@And("user enters the user name as {string} and password as {string}")
	public void user_enters_the_user_name_as_and_password_as(String user, String pwd) {
		lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
	}

	@And("user click on login")
	public void user_click_on_login() throws InterruptedException {
		lp.clickLogin();
		Thread.sleep(2000);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		if (driver.getTitle().equals(title)) {
			System.out.println("WelCome to HomePage");
		} else {
			System.out.println("Login is failed");
		}

		Thread.sleep(2000);

	}

	@When("user clicks on customer menu")
	public void user_clicks_on_customer_menu() throws InterruptedException {
		cp = new AddcustomerPage(driver);
		cp.clickOnCustomersMenu();
		cp.clickOnCustomersMenuItem();
		Thread.sleep(2000);

	}

	@And("user click on add button")
	public void user_click_on_add_button() {
		cp.clickOnAddnew();
		
	}

	@Then("user can view the add customer page")
	public void user_can_view_the_add_customer_page(String title1) {
		Assert.assertEquals("Add a new customer / nopCommerce administration", title1);
		
	}

	@When("user enters the customer details")
	public void user_enters_the_customer_details() {
		cp.setEmail("abcdef@gmail.com");
		cp.setPassword("123456");
		cp.setFirstName("Nethaji");
		cp.setLastName("Subhash");
		cp.setGender("male");
		cp.setDob("02/01/2012");
		cp.setCompanyName("rntbci");
		cp.setNews("Hello News");
		cp.setAdminContent("Check ");
		cp.setManagerOfVendor("Vendor");
		cp.clickOnSave();
	}

	@And("click on save button")
	public void click_on_save_button() throws InterruptedException {
		cp.clickOnSave();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		if (msg.equals("The new customer has been added successfully.")) {
			System.out.println("The page is ok");
		} else {
			System.out.println("The page is not ok");
		}

	}

	@And("close the browser")
	public void close_the_browser() {
		driver.quit();
	}

}
