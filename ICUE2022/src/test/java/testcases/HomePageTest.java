package testcases;

import base.BaseClass;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.SearchForMemberProgram;

import java.io.IOException;

public class HomePageTest extends BaseClass {
    IndexPage indexPage;
    HomePage homePage;
    SearchForMemberProgram searchForMemberProgram;


    @BeforeMethod
    public void setup() {
        logger = extent.createTest("HomePageTest");
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
    public void loginTest() {
        indexPage = new IndexPage();
        homePage = new HomePage();
        homePage = indexPage.login();
        searchForMemberProgram = homePage.enterMemberID();
        String actualURL = searchForMemberProgram.getCurrURL();
        String expectedURL = prop.getProperty("expectedStageURL");
        BaseClass.logger.info("Comparing Both the URLs");
        Assert.assertEquals(actualURL, expectedURL);
    }
}
