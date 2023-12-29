package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShopProductPage extends BasePage {

    @FindBy(className = "discount-percentage")
    private WebElement discount;

    @FindBy(id = "group_1")
    private WebElement sizeChar;

    @FindBy(xpath = "//div[1]/span[@class=\"control-label\"]")
    private WebElement controlLabel;

    @FindBy(xpath = "//input[@id=\"quantity_wanted\"]")
    private WebElement quantityNumberWebElement;


    @FindBy(xpath = "//span[@class=\"input-group-btn-vertical\"]/button[1]")
    private WebElement increaseButton;

    @FindBy(xpath = "//span[@class=\"input-group-btn-vertical\"]/button[2]")
    private WebElement decreaseButton;

    @FindBy(xpath = "//div[@class=\"add\"]/button")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class=\"cart-content-btn\"]/a")
    private WebElement proceedToCheckoutBtn;

    public ShopProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean discountIsTrue(String procentage) {
        String expectedDiscount = String.join(" ", "SAVE", procentage);
        return discount.getText().equals(expectedDiscount);
    }


    public void selectSize(String size) {
        Select objSelect = new Select(sizeChar);
        if (size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL")) {
            objSelect.selectByVisibleText(size);
        } else {
            objSelect.selectByIndex(0);
        }
    }

    public String getControlLabelText() {
        return controlLabel.getText();
    }

    public void enterQuantity(String quantity) {

        this.deleteTextFromTheField(quantityNumberWebElement);
        if (Integer.parseInt(quantity) > 1) {
            quantityNumberWebElement.sendKeys(quantity);
        } else {
            quantityNumberWebElement.sendKeys("1");
        }

    }

    public void adToTheCart() {
        addToCartBtn.click();
    }

    public void proceedToCheckoutBtn() {
        proceedToCheckoutBtn.click();
    }
}
