package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import pages.CheckboxPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CheckboxSteps {

    WebDriver driver;
    CheckboxPage page;

    @Before
    public void setup(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        page = new CheckboxPage(driver);
    }

    @Given("I open the Checkboxes page")
    public void openPage(){
        page.openPage();
    }

    @When("I select the first checkbox")
    public void selectCheckbox(){
        page.clickCheckbox();
    }

    @Then("the first checkbox should be selected")
    public void verifyCheckbox(){
        assert page.isCheckboxSelected();
    }

    @After
    public void close(){
        driver.quit();
    }
}