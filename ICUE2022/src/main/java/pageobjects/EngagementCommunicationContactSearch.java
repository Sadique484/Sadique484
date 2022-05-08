package pageobjects;

import actiondriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EngagementCommunicationContactSearch extends BaseClass {
    @FindBy(id = "communicationTransactionID")
    WebElement CommunicationID;
    @FindBy(id = "searchButton")
    WebElement SearchButton;

    public EngagementCommunicationContactSearch(){
        PageFactory.initElements(driver, this);
    }
    public boolean CommunicationIDValidate(){
        return Action.isDisplayed(driver, CommunicationID);
    }
    public void searchCommunication(){
        Action.type(CommunicationID, prop.getProperty("CommunicationContactID"));
        Action.click(driver, SearchButton);
    }
}
