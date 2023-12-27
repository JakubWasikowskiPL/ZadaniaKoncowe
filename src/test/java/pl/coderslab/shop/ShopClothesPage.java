package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopClothesPage {
    private final WebDriver driver;

    @FindBy(className = "cart-products-count")
    private WebElement cartItemsQuantity;


    @FindBy(xpath = "//a[text()=\'Hummingbird printed sweater\']")
    private WebElement item;


    public ShopClothesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean isEmpty() {
        return cartItemsQuantity.getText().equals("(0)");
    }

    public void selectItem() {
        item.click();
    }

}
