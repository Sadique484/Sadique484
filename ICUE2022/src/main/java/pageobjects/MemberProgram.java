package pageobjects;

import actiondriver.Action;
import base.BaseClass;
import dataprovider.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemberProgram extends BaseClass {
    public MemberProgram() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[3]/div[3]/div[1]/span/div[1]/a")
    WebElement eleProgramID;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div[2]/form/div[1]/a")
    WebElement eleProgramDetails;
    @FindBy(id = "memberProgramStatusReasonTypememberProgramSuffix")
    WebElement StatusReason1;
    @FindBy(xpath = "//*[@id=\"intake\"]/form/div[3]/div[1]/a")
    WebElement ActivityHistory;
    @FindBy(id = "selectedMemberProgramID")
    WebElement Programs;
    @FindBy(xpath = "//*[@id=\"intake\"]/form/div[4]/a")
    WebElement RecentNotes;
    @FindBy(xpath = "//*[@id=\"recentNotesDiv\"]/table/tbody")
    WebElement RecentNotesTable;
    @FindBy(xpath = "//*[@id=\"intake\"]/form/div[6]/div[2]/a")
    WebElement AssessmentSummary;
    @FindBy(xpath = "//*[@id=\"assessmentInProgress\"]/a[1]")
    WebElement AssessmentSummarySection;
    @FindBy(xpath = "//*[@id=\"intake\"]/form/div[8]/a")
    WebElement ProgramPriorityHistory;
    @FindBy(xpath = "//*[@id=\"priorityHistoryDiv\"]/table/tbody")
    WebElement ProgramPriorityHistoryTable;
    DataProviders dataProviders = new DataProviders();
    @FindBy(xpath = "//*[@id=\"memberPageSection\"]/a")
    WebElement Member;

//    public void CheckFirstOption() {//First Function to Check if Member Sidebar Tab is Expanded/Collapsed
//        if (!Action.isDisplayed(driver, MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[1]/td/a"))))
//            Member.click();
//    }
//    MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[1]/td/a"))

    public boolean verifyProgramIDetails() {
//        if (!Action.isDisplayed(driver, MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[1]/td/a"))))
        Member.click();
        return Action.isDisplayed(driver, eleProgramID);
    }

    public boolean verifyProgramIDele() {
        return Action.isDisplayed(driver, eleProgramID);
    }

    public boolean verifyStatusReason() {
        return Action.isDisplayed(driver, StatusReason1);
    }

    public boolean MemberSummaryLink() {
        MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[1]/td/a")).click();
        dataProviders.PopupWindowHandler("Member | Summary");
        return Action.isDisplayed(driver, MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[1]/td/a")));
    }

    public boolean CareSummaryLink() {
        MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[2]/td/a")).click();
        dataProviders.PopupWindowHandler("Care Summary Note");
        return Action.isDisplayed(driver, MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[2]/td/a")));
    }

    public boolean ViewNerveCenter() {
        MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[3]/td/a")).click();
        dataProviders.PopupWindowHandler("OCM - Login");
        return Action.isDisplayed(driver, MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[3]/td/a")));
    }

    public boolean ViewConsumerDashboardLink() {
        MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[4]/td/a")).click();
        dataProviders.PopupWindowHandler("Consumer Dashboard");
        return Action.isDisplayed(driver, MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[4]/td/a")));
    }

    public boolean MyHealthDirectLink() {
        MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[5]/td/a")).click();
        dataProviders.PopupWindowHandler("MyHealth");
        return Action.isDisplayed(driver, MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[5]/td/a")));
    }

    public boolean SecureMessageLink() {
        MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[6]/td/a")).click();
        dataProviders.PopupWindowHandler("Sign On Error");
        return Action.isDisplayed(driver, MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[6]/td/a")));
    }

    public boolean ViewImpactProLink() {
        MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[7]/td/a")).click();
        dataProviders.PopupWindowHandler("Invalid column name");
        return Action.isDisplayed(driver, MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[7]/td/a")));
    }

    public boolean ViewRXWebLink() {
        MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[8]/td/a")).click();
        dataProviders.PopupWindowHandler("RxWeb");
        return Action.isDisplayed(driver, MemberProgram.driver.findElement(By.xpath("//*[@id=\"memberDivSide\"]/table/tbody/tr[8]/td/a")));
    }

    public void verifyExpand() {
        DataProviders dataProviders = new DataProviders();
        dataProviders.ExpandCollapseValidate(eleProgramDetails, StatusReason1, "Program Details");
        dataProviders.ExpandCollapseValidate(ActivityHistory, Programs, "Activity History");
        dataProviders.ExpandCollapseValidate(RecentNotes, RecentNotesTable, "Recent Notes");
        dataProviders.ExpandCollapseValidate(AssessmentSummary, AssessmentSummarySection, "Assessment Summary");
        dataProviders.ExpandCollapseValidate(ProgramPriorityHistory, ProgramPriorityHistoryTable, "Program Priority History");
    }


}



