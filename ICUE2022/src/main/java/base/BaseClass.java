package base;


import actiondriver.Action;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class BaseClass {
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static Properties prop;
    public static WebDriver driver;

    @BeforeTest
    public void loadConfig() {
        htmlReporter = new ExtentHtmlReporter("user.dir" + File.separator + "reports" + File.separator + "AutomationReport.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setReportName("Automation Test Results");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Mohammad Sadique");

    }

    @AfterMethod
    public void AfterTestMethod(ITestResult result) {
        extent.flush();
    }

    @AfterSuite
    public void closeApp() {
        driver.quit();
    }


    @BeforeSuite
    public static void launchApp() {
        try {
            prop = new Properties();
            System.out.println("Super Constructor Invoked");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
            prop.load(ip);
            System.out.println("driver : " + prop.getProperty("browser"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String BrowserName = prop.getProperty("browser");
        if (BrowserName.contains("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\msadiqu\\Desktop\\Selenium Jars and Drivers\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (BrowserName.contains("Edge")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\msadiqu\\Desktop\\Selenium Jars and Drivers\\Drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        Action.implicitWait(driver, 10);
        Action.pageLoadTimeOut(driver, 30);
        driver.get(prop.getProperty("urlStage"));
    }

    public String getScreenShot(WebDriver driver, String FileName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "C:\\Users\\msadiqu\\Desktop\\ICUE2022\\ScreenShots\\" + FileName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
