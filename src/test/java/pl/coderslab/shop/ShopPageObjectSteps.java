package pl.coderslab.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;


public class ShopPageObjectSteps {
    private WebDriver driver;
    ShopMyAddressesPage myAddressesPage;
    ShopClothesPage myClothesPage;
    ShopProductPage myProductPage;
    ShopCartPage myCartPage;
    ShopOrderPage myOrderPage;
    ShopOrderConfirmationPage myConfirmationPage;

    @Given("I'm on the shop authentication page")
    public void iMOnTheShopAuthenticationPage() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String login, String passwd) {
        ShopAuthPage authPage = new ShopAuthPage(driver);
        authPage.loginAs(login, passwd);
    }

    @And("I go to my addresses page")
    public void iGoToMyAddressesPage() {
        ShopMyAccountPage myAccountPage = new ShopMyAccountPage(driver);
        myAccountPage.goToMyAddressesPage();
        myAddressesPage = new ShopMyAddressesPage(driver);
    }

    @Then("I can see there is no addresses")
    public void iCanSeeThereIsNoAddresses() {
        Assertions.assertTrue(myAddressesPage.addressIsVisible(), "No addresses should be visible");
    }

    @When("I add new address")
    public void iAddNewAddress() {
        myAddressesPage.addNewAddress();
    }


    @And("I enter new address {string},{string},{string},{string},{string},{string}")
    public void iEnterNewAddress(String alias, String address, String city
            , String postalCode, String countryName, String phoneNumber) {
        ShopNewAddressPage newAddressPage = new ShopNewAddressPage(driver);
        newAddressPage.enterNewAddressData(alias, address, city, postalCode, countryName, phoneNumber);
    }

    @Then("I can see new address")
    public void iCanSeeNewAddress() {
        Assertions.assertTrue(myAddressesPage.addressIsVisible(), "Created address should be visible");
    }

    @And("I verify created address {string},{string},{string},{string},{string},{string}")
    public void iVerifyCreatedAddress(String alias, String address, String city
            , String postalCode, String countryName, String phoneNumber) {
        String addressAsText = myAddressesPage.getFirstAddressAsText();
        String aliasTekst = myAddressesPage.getFirstAddressAliasAsText();
        String[] adressTextArray = Arrays.stream(addressAsText.split("\\n")).toList().toArray(new String[0]);
        for (String adressText:adressTextArray) {
            System.out.println(adressText);
        }
        String actualAdress = String.join("\n", aliasTekst, adressTextArray[1], adressTextArray[2], adressTextArray[3],
                adressTextArray[4], adressTextArray[5]);
        String expectedAddress = String.join("\n", alias, address, city, postalCode, countryName, phoneNumber);
        Assertions.assertEquals(expectedAddress, actualAdress);
    }

    @And("I remove the address")
    public void iRemoveTheAddress() {
        myAddressesPage.removeAddresses();
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }


    @And("I go to clothes page")
    public void iGoToClothesPage() {
        ShopMyAccountPage myAccountPage = new ShopMyAccountPage(driver);
        myAccountPage.goToMyClothesPage();
        myClothesPage = new ShopClothesPage(driver);
    }

    @And("I can see there is no items in the cart")
    public void iCanSeeThereIsNoItemsInTheCart() {
        Assertions.assertTrue(myClothesPage.isEmpty());
    }

    @And("I select new item")
    public void iSelectNewItem() {
        myClothesPage.selectItem();
        myProductPage = new ShopProductPage(driver);
    }

    @And("I check if the discount is equal to {string}")
    public void iCheckIfTheDiscountIsEqualToDiscount(String procentage) {
        Assertions.assertTrue(myProductPage.discountIsTrue(procentage));
    }


    @And("I enter select {string}")
    public void iEnterSelectSize(String sizeChar) {
        myProductPage.selectSize(sizeChar);
    }


    @And("I enter {string}")
    public void iEnterQuantity(String quantityNumber) {
        myProductPage.enterQuantity(quantityNumber);
    }


    @And("I check if the {string} is corret")
    public void iCheckIfTheSizeIsCorret(String sizeChar) {
        String expectedSize = String.join(" ", "Size: " + sizeChar);
        Assertions.assertEquals(expectedSize, myProductPage.getControlLabelText());
    }

    @And("I click add to cart")
    public void iClickAddToCart() {
        myProductPage.adToTheCart();
    }


    @And("I click Proceed to checkout")
    public void iClickProceedToCheckout() {
        myProductPage.proceedToCheckoutBtn();
        myCartPage = new ShopCartPage(driver);
    }

    @And("I click Proceed on Shopping Cart page")
    public void iClickProceedOnShoppingCartPage() {
        myCartPage.clickProceed();
        myOrderPage = new ShopOrderPage(driver);
    }

    @And("I click Confirm Address")
    public void iClickConfirmAddress() {
        myOrderPage.selectAdress();
        myOrderPage.confirmAdress();
    }

    @And("I select shipping method")
    public void iSelectShippingMethodPickUpInStore() {
        myOrderPage.selectShippingMethod();
        myOrderPage.confirmDelivery();
    }

    @And("I select payment method")
    public void iSelectPaymentMethod() {
        myOrderPage.selectPaymentMethod();
    }

    @And("I check conditions to approve")
    public void iCheckConditionsToApprove() {
        myOrderPage.selectTermsAgreement();
    }

    @And("I click place order button")
    public void iClickPlaceOrderButton() {
        myOrderPage.clickPlaceOrderBtn();
        myConfirmationPage = new ShopOrderConfirmationPage(driver);
    }

    @Then("I Take a Screenshot")
    public void iTakeAScreenshot() throws IOException {

        String screenshotName = String.join("", "orderConfirmation" + System.currentTimeMillis(), ".jpg");
        myConfirmationPage.takeScreenshot(screenshotName);
    }
}
