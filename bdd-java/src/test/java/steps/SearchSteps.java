package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SearchSteps {

    WebDriver driver;

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("I am on the Google search page")
    public void openGoogle() {
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void search(String term) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(term);
        searchBox.submit();
    }

    @Then("I should see {string} in the results")
    public void verify(String term) {
        assert driver.getPageSource().contains(term);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}