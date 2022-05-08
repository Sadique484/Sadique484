package pageobjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(xpath = "//*[@id=\"5\"]")
    WebElement memberProgramID;
    @FindBy(xpath = "//*[@id=\"23\"]")
    WebElement communicationContactID;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    public SearchForMemberProgram enterMemberID(){
        memberProgramID.click();
        return new SearchForMemberProgram();
    }
    public EngagementCommunicationContactSearch enterCommunicationID(){
        communicationContactID.click();
        return new EngagementCommunicationContactSearch();
    }


}
