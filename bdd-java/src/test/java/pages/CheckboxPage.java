package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage {

    WebDriver driver;

    public CheckboxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement checkbox1;

    public void openPage(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public void clickCheckbox(){
        checkbox1.click();
    }

    public boolean isCheckboxSelected(){
        return checkbox1.isSelected();
    }
}