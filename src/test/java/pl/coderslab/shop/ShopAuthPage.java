package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopAuthPage extends BasePage {

    @FindBy(id = "field-email")
    private WebElement loginEmailInput;

    @FindBy(id = "field-password")
    private WebElement loginPasswdInput;

    @FindBy(id = "submit-login")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@class=\"input-group-btn\"]//button")
    private WebElement showBtn;

    public ShopAuthPage(WebDriver driver) {
        super(driver);
    }

    public ShopMyAccountPage loginAs(String login, String passwd) {
        loginEmailInput.clear();
        loginEmailInput.sendKeys(login);

        loginPasswdInput.clear();
        loginPasswdInput.sendKeys(passwd);
        showBtn.click();


        loginBtn.click();
        return new ShopMyAccountPage(getDriver());
    }
}
