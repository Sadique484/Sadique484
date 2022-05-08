package utility;

import base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class SuiteListener implements ITestListener {

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
        System.out.println("Test Casse Is Failed with Sucess percentage : " + Result.getName());
    }

    @Override
    public void onTestFailure(ITestResult Result) {
        String filename = System.getProperty("user.dir") + File.separator + "ScreenShots" + File.separator + Result.getName();
        File f = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f, new File(filename + "png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test Case Is Failed" + Result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult Result) {
        System.out.println("Test Case Is Skipped" + Result.getName());
    }

    @Override
    public void onTestStart(ITestResult Result) {
        System.out.println("Test Case Is Started on Test" + Result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult Result) {
        System.out.println("Test Case Is Success" + Result.getName());
    }
}
