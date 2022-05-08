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
import pageobjects.IndexPage;

import java.io.IOException;

public class IndexPageTest extends BaseClass {
    IndexPage indexPage = new IndexPage();

    @BeforeMethod
    public void setup() {
        logger = extent.createTest("IndexPageTest");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String longText = "Test Case: " + methodName + " Passed";
            Markup m = MarkupHelper.createLabel(longText, ExtentColor.GREEN);
            logger.log(Status.PASS, m);

        } else if (result.getStatus() == ITestResult.FAILURE) {
            String pathString = getScreenShot(driver, result.getName());
            String methodName = result.getMethod().getMethodName();
            String longText = "Test Case: " + methodName + " Failed";
            Markup m = MarkupHelper.createLabel(longText, ExtentColor.RED);
            logger.log(Status.FAIL, m);
            logger.addScreenCaptureFromPath(pathString);
        }
    }

    @Test
    public void verifyHeader() {
        indexPage = new IndexPage();
        boolean result = indexPage.verifyHeader();
        Assert.assertTrue(result, "Incorrect Page returned.");
    }

    @Test
    public void VerifyTitle() {
        String pgeTitle = indexPage.pageTitleTop();
        Assert.assertEquals(pgeTitle, "Application Sign On - I-CUE powered by eSync", "Page Title in incorrect.");
    }
}
