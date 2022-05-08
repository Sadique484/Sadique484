package pageobjects;

import actiondriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {
    @FindBy(xpath = "//*[@id=\"userID\"]")
    WebElement userBox;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"box\"]/form/div[2]/center/table/tbody/tr[4]/td/input")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"headerText\"]")
    WebElement headerText;

    public IndexPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage login() {
        Action.type(userBox, prop.getProperty("username"));
        Action.type(password, prop.getProperty("password"));
        Action.click(driver, loginButton);
        return new HomePage();
    }

    public boolean verifyHeader() {
        return Action.isDisplayed(driver, headerText);
    }

    public String pageTitleTop() {
        String pageTitle;
        pageTitle = driver.getTitle();
        return pageTitle;
    }

}
