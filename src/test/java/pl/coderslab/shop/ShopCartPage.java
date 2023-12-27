package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopCartPage {
    private final WebDriver driver;

    @FindBy(xpath = "//div[@class=\"text-sm-center\"]/a")
    private WebElement proceedBtn;

    public ShopCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProceed(){
        proceedBtn.click();
    }

}
