package pl.coderslab.shop;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ShopOrderConfirmationPage extends BasePage {


    public ShopOrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) getDriver());
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileName);
        FileUtils.copyFile(SrcFile, DestFile);
    }

}
