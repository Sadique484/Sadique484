package testcases;

import base.BaseClass;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import dataprovider.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.MemberProgram;
import pageobjects.SearchForMemberProgram;

import java.io.IOException;

public class MemberProgramPageTest extends BaseClass {
    //    IndexPage indexPage;
//    HomePage homePage;
    SearchForMemberProgram searchforMemberProgram;
    MemberProgram memberProgram;
    DataProviders dataProvider;
//    @FindBy(xpath = "//*[@id=\"intake\"]/form/div[1]/a")
//    WebElement eleProgramDetails;

    @BeforeMethod
    public void setup() {
        logger = extent.createTest("MemberProgramPageTest");
        dataProvider = new DataProviders();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String longText = "Test Case: " + methodName + " Passed";
            Markup m = MarkupHelper.createLabel(longText, ExtentColor.GREEN);
            logger.log(Status.PASS, m);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String longText = "Test Case: " + methodName + " Failed";
            Markup m = MarkupHelper.createLabel(longText, ExtentColor.RED);
            logger.log(Status.FAIL, m);
            String pathString = getScreenShot(driver, result.getName());
            logger.addScreenCaptureFromPath(pathString);
        }
    }

    @Test
    public void verifyProgramDetails() throws IOException {

        searchforMemberProgram = new SearchForMemberProgram();
        boolean result = searchforMemberProgram.ProgramIDValidate();
        Assert.assertTrue(result);
        logger.log(Status.PASS, "Program ID is visible on Screen");
        memberProgram = searchforMemberProgram.searchProgram();
        boolean res1 = memberProgram.verifyProgramIDele();
        if (!res1) {
            logger.log(Status.FAIL, "Program ID Element is visible on Screen");
        } else {
            logger.log(Status.PASS, "Program ID Element is visible on Screen");
        }
        boolean res2 = memberProgram.verifyProgramIDetails();
        if (!res2) {
            logger.log(Status.FAIL, "verifyProgramIDetails is Failed.");
        } else {
            logger.log(Status.PASS, "verifyProgramIDetails is passed.");
        }
        boolean res3 = memberProgram.verifyStatusReason();
        if (!res3) {
            logger.log(Status.FAIL, "Member Program is not correctly displayed");
        } else {
            logger.log(Status.PASS, "Member Program is correctly displayed");
        }
        String ExcelPath = "C:\\Users\\msadiqu\\Desktop\\ICUE2022\\src\\test\\resources\\TestData\\TestData.xlsx";
        dataProvider.StatusReasonDropdownValues(ExcelPath, "DataValues", 0, MemberProgram.driver.findElement(By.id("memberProgramStatusReasonTypememberProgramSuffix")));
        dataProvider.StatusReasonDropdownValues(ExcelPath, "DataValues", 1, MemberProgram.driver.findElement(By.id("severityTypememberProgramSuffix")));
        dataProvider.StatusReasonDropdownValues(ExcelPath, "DataValues", 2, MemberProgram.driver.findElement(By.id("memberProgramOutreachTypememberProgramSuffix")));
        dataProvider.StatusReasonDropdownValues(ExcelPath, "DataValues", 3, MemberProgram.driver.findElement(By.id("action")));

        if (!memberProgram.MemberSummaryLink())
            logger.log(Status.FAIL, "Member Summary Link is not correctly displayed");
        else logger.log(Status.PASS, "Member Summary Link is correctly displayed");

        if (!memberProgram.CareSummaryLink()) logger.log(Status.FAIL, "Care Summary Link is not correctly displayed");
        else logger.log(Status.PASS, "Care Summary Link is correctly displayed");

        if (!memberProgram.ViewNerveCenter())
            logger.log(Status.FAIL, "View Nerve Center Link is not correctly displayed.");
        else logger.log(Status.PASS, "View Nerve Center Link is correctly displayed.");

        if (!memberProgram.MyHealthDirectLink())
            logger.log(Status.FAIL, "MyHealth Direct Link is not correctly displayed");
        else logger.log(Status.PASS, "MyHealth Direct Link is correctly displayed");

        if (!memberProgram.SecureMessageLink())
            logger.log(Status.FAIL, "Secure Message Link is not correctly displayed");
        else logger.log(Status.PASS, "Secure Message Link is correctly displayed");

        if (!memberProgram.ViewConsumerDashboardLink())
            logger.log(Status.FAIL, "View Consumer Dashboard Link is not correctly displayed");
        else logger.log(Status.PASS, "View Consumer Dashboard Link is correctly displayed");

        if (!memberProgram.ViewImpactProLink())
            logger.log(Status.FAIL, "View Impact Pro Link is not correctly displayed");
        else logger.log(Status.PASS, "View Impact Pro Link is correctly displayed");

        if (!memberProgram.ViewRXWebLink())
            logger.log(Status.FAIL, "View Rx Weblink Link is not correctly displayed");
        else logger.log(Status.PASS, "View Rx Weblink Link is correctly displayed");

        memberProgram.verifyExpand();
    }


}

