package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemovePage {

    WebDriver driver;

    public AddRemovePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Add Element']")
    WebElement addButton;

    @FindBy(xpath = "//button[text()='Delete']")
    WebElement deleteButton;

    public void openPage(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    public void clickAdd(){
        addButton.click();
    }

    public boolean isDeleteVisible(){
        return deleteButton.isDisplayed();
    }
}