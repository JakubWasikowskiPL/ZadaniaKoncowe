package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopClothesPage extends BasePage{

    @FindBy(className = "cart-products-count")
    private WebElement cartItemsQuantity;


    @FindBy(xpath = "//a[text()=\'Hummingbird printed sweater\']")
    private WebElement item;


    public ShopClothesPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isEmpty() {
        return cartItemsQuantity.getText().equals("(0)");
    }

    public void selectItem() {
        item.click();
    }

}
