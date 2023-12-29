package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopOrderPage extends BasePage {


    @FindBy(xpath = "//div[@id=\"delivery-addresses\"]/article[1]")
    private WebElement adressSelection;

    @FindBy(name = "confirm-addresses")
    private WebElement confirmAdressBtn;

    @FindBy(xpath = "//div[@class=\"delivery-options\"]/div[1]/div[1]")
    private WebElement shippinMethodBtn;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDeliveryBtn;

    @FindBy(xpath = "//input[@id=\"payment-option-1\"]")
    private WebElement paymentMethod;

    @FindBy(xpath = "//span[@class=\"custom-checkbox\"]/input")
    private WebElement termsAgrrmentCheckBox;

    @FindBy(xpath = "//div[@class=\"ps-shown-by-js\"]/button")
    private WebElement placeOrderBtn;

    public ShopOrderPage(WebDriver driver) {
        super(driver);
    }

    public void selectAdress() {
        adressSelection.click();
    }

    public void confirmAdress() {
        confirmAdressBtn.click();
    }

    public void selectShippingMethod() {
        shippinMethodBtn.click();
    }

    public void confirmDelivery() {
        confirmDeliveryBtn.click();
    }

    public void selectPaymentMethod() {
        paymentMethod.click();
    }

    public void selectTermsAgreement() {
        termsAgrrmentCheckBox.click();
    }

    public void clickPlaceOrderBtn() {
        placeOrderBtn.click();
    }
}
