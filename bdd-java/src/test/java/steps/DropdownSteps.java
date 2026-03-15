package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import pages.DropdownPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DropdownSteps {

    WebDriver driver;
    DropdownPage page;

    @Before
    public void setup(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        page = new DropdownPage(driver);
    }

    @Given("I open the Dropdown page")
    public void openPage(){
        page.openPage();
    }

    @When("I select Option 1")
    public void selectOption(){
        page.selectOption1();
    }

    @Then("Option 1 should be selected")
    public void verifyOption(){
        assert page.getSelectedOption().equals("Option 1");
    }

    @After
    public void close(){
        driver.quit();
    }
}