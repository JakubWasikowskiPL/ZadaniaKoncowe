package pl.coderslab.shop;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ShopOrderConfirmationPage {
    private final WebDriver driver;

    public ShopOrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileName);
        FileUtils.copyFile(SrcFile, DestFile);
    }

}
