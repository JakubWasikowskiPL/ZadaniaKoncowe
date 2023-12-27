package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopMyAccountPage {
    private final WebDriver driver;

    @FindBy(xpath = "//a[@class=\"account\"]/span")
    private WebElement userInfo;

    @FindBy(xpath = "//nav/ol/li/a")
    private WebElement homeBtn;

    @FindBy(xpath = "//*[@id=\"addresses-link\"]/span/i")
    private WebElement myAddressesBtn;

    @FindBy(id = "category-3")
    private WebElement myClothesBtn;

    public ShopMyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
