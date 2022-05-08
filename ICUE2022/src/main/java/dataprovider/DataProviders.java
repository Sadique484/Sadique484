package dataprovider;

import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utility.ExcelUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DataProviders extends BaseClass {
    ArrayList<String> ActualList = new ArrayList<>();
    ArrayList<String> ExcelList = new ArrayList<>();

    public void StatusReasonDropdownValues(String ExcelPath, String SheetName, int ColumnNo, WebElement StatusReason) throws IOException {
        logger.info("Validate Dropdown Values Function is called for : " + StatusReason.getAttribute("name"));
        Select sel = new Select(StatusReason);
        List<WebElement> listOptions = sel.getOptions();
        int k = listOptions.size();
        for (WebElement listOption : listOptions) {
            ActualList.add(listOption.getText());
        }
        ExcelUtils excelUtils = new ExcelUtils(ExcelPath);
        int totalRows = excelUtils.getRowCount(SheetName);
        for (int i = 1; i <= totalRows; i++) {
            ExcelList.add(excelUtils.getCellData(SheetName, i, ColumnNo));
        }
        for (String s : ActualList) {
            if (ExcelList.contains(s)) {
                logger.log(Status.PASS, s + " is available.");
            } else {
                logger.log(Status.FAIL, s + " is not available.");
            }
        }
        ExcelList.clear();
        ActualList.clear();
        logger.info("Validate Dropdown Values are completed for : " + StatusReason.getAttribute("name"));
    }

    public void ExpandCollapseValidate(WebElement ClickObject, WebElement toCheck, String Section) {
        if (toCheck.isDisplayed()) {
            ClickObject.click();
            System.out.println("Clicked on : +, now the " + Section + " section is Collapsed.");
        } else {
            System.out.println(Section + " Section is already Collapsed.");
        }
        ClickObject.click();
        if (toCheck.isDisplayed()) {
            logger.log(Status.PASS, Section + " Section is expanded on clicking + Sign.");
            ClickObject.click();
            if (toCheck.isDisplayed()) {
                Assert.assertTrue(toCheck.isDisplayed());
                logger.log(Status.FAIL, Section + " Section is not collapsed on clicking - Sign.");
            } else {
                logger.log(Status.PASS, Section + " Section is collapsed on clicking - Sign.");
            }
        } else
            logger.log(Status.FAIL, Section + " Section is not expanded on clicking + Sign.");
    }

    public void PopupWindowHandler(String WindowTitle) {
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        int count = allWindows.size();
        for (String child : allWindows) {
            if (!parentWindow.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                String newWindowTitle = driver.getTitle();
                if (newWindowTitle.contains(WindowTitle)) {
                    logger.log(Status.PASS, "User is correctly landed to : " + newWindowTitle);
                } else
                    logger.log(Status.FAIL, "User is not landed to : " + WindowTitle + "but to : " + newWindowTitle);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
    }
}



