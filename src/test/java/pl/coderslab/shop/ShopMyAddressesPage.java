package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopMyAddressesPage extends BasePage {

    @FindBy(xpath = "//div[1]/h4")
    private List<WebElement> aliases;

    @FindBy(xpath = "//div[1]/address")
    private List<WebElement> addresses;

    @FindBy(xpath = "//div[@class=\"address-footer\"]/a[2]")
    private List<WebElement> deleteBtns;
    @FindBy(xpath = "//*[@id=\"content\"]/*[@class=\"addresses-footer\"]/a")
    private WebElement newAddressBtn;

    public ShopMyAddressesPage(WebDriver driver) {
        super(driver);
    }

    public boolean addressIsVisible() {
        return addresses.size() > 0;
    }

    public void addNewAddress() {
        newAddressBtn.click();
    }

    public String getFirstAddressAsText() {
        WebElement address = addresses.get(1);
        return address.getText();
    }

    public String getFirstAddressAliasAsText() {
        WebElement alias = aliases.get(1);
        return alias.getText();
    }

    public void removeAddresses() {
        for (int i = deleteBtns.size() - 1; i >= 1; i--) {
            deleteBtns.get(i).click();
        }


    }
}
