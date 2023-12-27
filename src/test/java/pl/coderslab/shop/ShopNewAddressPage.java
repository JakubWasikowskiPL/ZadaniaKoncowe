package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopNewAddressPage {
    private final WebDriver driver;
    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

//    @FindBy(xpath = "//*[@id=\"field-id_country\"]//*[2]")
    @FindBy(id = "field-id_country")
    private WebElement countryInput;

    @FindBy(id = "field-phone")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//footer/button")
    private WebElement submitBtn;

    public ShopNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterNewAddressData(String alias,String address,String city,String postalCode,String countryName,String phoneNumber) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);


        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        countryInput.click();
        countryInput.sendKeys(countryName);
        countryInput.isSelected();

        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);

        submitBtn.click();
    }
}
