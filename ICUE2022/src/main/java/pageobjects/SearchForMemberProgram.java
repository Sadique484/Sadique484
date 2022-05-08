package pageobjects;

import actiondriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchForMemberProgram extends BaseClass {
    @FindBy(name = "searchID")
    WebElement MemberID;
    @FindBy(id = "searchButton")
    WebElement SearchButton;

    public SearchForMemberProgram() {
        PageFactory.initElements(driver, this);
    }

    public boolean ProgramIDValidate() {
        return Action.isDisplayed(driver, MemberID);
    }

    public MemberProgram searchProgram() {
        Action.type(MemberID, prop.getProperty("ProgramIDStage"));
        Action.click(driver, SearchButton);
        return new MemberProgram();
    }

    public String getCurrURL() {
        return driver.getCurrentUrl();
    }
}
