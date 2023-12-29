package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopMyAccountPage extends BasePage {

    @FindBy(xpath = "//a[@class=\"account\"]/span")
    private WebElement userInfo;

    @FindBy(xpath = "//nav/ol/li/a")
    private WebElement homeBtn;

    @FindBy(xpath = "//*[@id=\"addresses-link\"]/span/i")
    private WebElement myAddressesBtn;

    @FindBy(id = "category-3")
    private WebElement myClothesBtn;

    public ShopMyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return userInfo.getText();
    }

    public void goToMyAddressesPage() {
        myAddressesBtn.click();
    }

    public void goToMyClothesPage() {
        myClothesBtn.click();
    }
}
