package stepdefinitions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage lp;
	public AddcustomerPage cp;
	public Logger logger;

	public void setup(String br) throws InterruptedException {
		logger = Logger.getLogger("e-Commerse");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (br.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
		}
	}
}
