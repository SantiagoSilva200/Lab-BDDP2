package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.AddRemovePage;

import java.util.concurrent.TimeUnit;

public class AddRemoveSteps {

    WebDriver driver;
    AddRemovePage page;

    @Before
    public void setup(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        page = new AddRemovePage(driver);
    }

    @Given("I open the Add Remove Elements page")
    public void openPage(){
        page.openPage();
    }

    @When("I click the Add Element button")
    public void clickAdd(){
        page.clickAdd();
    }

    @Then("I should see the Delete button")
    public void verifyDelete(){
        assert page.isDeleteVisible();
    }

    @After
    public void close(){
        driver.quit();
    }
}