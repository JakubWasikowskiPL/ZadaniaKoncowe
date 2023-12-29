package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopCartPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"text-sm-center\"]/a")
    private WebElement proceedBtn;

    public ShopCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickProceed() {
        proceedBtn.click();
    }

}
