package stepdefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import com.nopcommerce.pageObjects.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition extends BaseClass {

	@Given("user launch the browser")
	public void user_launch_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@When("user opens the url {string}")
	public void user_opens_the_url(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@And("user enters the username as {string} and password as {string}")
	public void user_enters_the_username_as_and_password_as(String user, String pwd) {
		lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
	}

	@And("user click on login button")
	public void user_click_on_login_button() throws InterruptedException {
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

	@And("user close the browser")
	public void user_close_the_browser() {
		lp.clickLogout();
		driver.quit();

	}

}
