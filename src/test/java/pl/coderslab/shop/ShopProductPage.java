package pl.coderslab.shop;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopProductPage {
    private final WebDriver driver;


    @FindBy(className = "discount-percentage")
    private WebElement discount;

    @FindBy(id = "group_1")
    private WebElement sizeChar;

    @FindBy(xpath = "//div[1]/span[@class=\"control-label\"]")
    private WebElement controlLabel;

    @FindBy(xpath = "//input[@id=\"quantity_wanted\"]")
    private WebElement quantityNumber;

    @FindBy(xpath = "//span[@class=\"input-group-btn-vertical\"]/button[1]")
    private WebElement increaseButton;

    @FindBy(xpath = "//span[@class=\"input-group-btn-vertical\"]/button[2]")
    private WebElement decreaseButton;

    @FindBy(xpath = "//div[@class=\"add\"]/button")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class=\"cart-content-btn\"]/a")
    private WebElement proceedToCheckoutBtn;

    public ShopProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean discountIsTrue(String procentage) {
        String expectedDiscount = String.join(" ", "SAVE", procentage);
        return discount.getText().equals(expectedDiscount);
    }


    public void selectSize(String size) {

        //Will be changed to the Dropdown lists element
        switch (size) {
            case "S":
                sizeChar.click();
                sizeChar.sendKeys("S");
                sizeChar.click();
                break;
            case "M":
                sizeChar.click();
                sizeChar.sendKeys("M");
                sizeChar.click();
                break;
            case "L":
                sizeChar.click();
                sizeChar.sendKeys("L");
                sizeChar.click();
                break;
            case "XL":
                sizeChar.click();
                sizeChar.sendKeys("XL");
                sizeChar.click();
                break;
            default:
                sizeChar.click();
                sizeChar.sendKeys("S");
                sizeChar.click();
                break;
        }

    }

    public String getControlLabelText() {
        return controlLabel.getText();
    }

    public void enterQuantity(String quantity) {
        //Temporary trick to bypass waiting for an element will be replaced with wait in the future
        quantityNumber.click();
        quantityNumber.sendKeys(Keys.DELETE);
        quantityNumber.sendKeys(Keys.BACK_SPACE);
        quantityNumber.sendKeys(Keys.DELETE);
        quantityNumber.sendKeys(Keys.BACK_SPACE);
        if(Integer.parseInt(quantity)>1) {
            quantityNumber.sendKeys(quantity);
        }else {
            quantityNumber.sendKeys("1");
        }
    }

    public void adToTheCart() {
        addToCartBtn.click();
    }

    public void proceedToCheckoutBtn() {
        proceedToCheckoutBtn.click();
    }
}
