package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class PopUpComponentPage extends TopBarComponentPage {
    private final SelenideElement
            cartPopUpSuccessful = $(By.xpath("//div[@id='layer_cart']")),
            continueShoppingButton = $(By.xpath("//span[@title='Continue shopping']")),
            proceedCheckoutButton = $(By.xpath("//a[@title='Proceed to checkout']")),
            closeCartPopUpButton = $(By.xpath("//span[@class='cross']")),
            productQuickViewForm = $(By.xpath("//body[@id='product']")),
            quickViewFormLoadingSpinner = $(By.xpath("//div[@id='fancybox-loading']")),
            quickViewAddToCartButton = $(By.xpath("//p[@id='add_to_cart']/button[@type='submit']")),
            closeQuickFormButton = $(By.xpath("//a[@title='Close']"));


    public SelenideElement getCartPopUpSuccessful() {
        return cartPopUpSuccessful;
    }

    public SelenideElement getContinueShoppingButton() {
        return continueShoppingButton;
    }

    public SelenideElement getProceedCheckoutButton() {
        return proceedCheckoutButton;
    }

    public SelenideElement getCloseCartPopUpButton() {
        return closeCartPopUpButton;
    }

    public SelenideElement getProductQuickViewForm() {
        return productQuickViewForm;
    }

    public SelenideElement getQuickViewFormLoadingSpinner() {
        return quickViewFormLoadingSpinner;
    }

    public SelenideElement getQuickViewAddToCartButton() {
        return quickViewAddToCartButton;
    }

    public SelenideElement getCloseQuickFormButton() {
        return closeQuickFormButton;
    }

    public PopUpComponentPage ver_successfulPopUpVisible(){
        getCartPopUpSuccessful().shouldBe(visible).shouldHave(text("Product successfully added to your shopping cart\n" +
                "\t\t\t\t"));

        return this;
    }

    public PopUpComponentPage act_closeCartPopUp(){
        getCloseCartPopUpButton().shouldBe(visible).shouldBe(enabled).click();
        getCartPopUpSuccessful().shouldNotBe(visible);

        return this;
    }

    public PopUpComponentPage ver_quickViewFormVisible(){
        getProductQuickViewForm().shouldBe(visible);

        return this;
    }

    public PopUpComponentPage act_clickAddToCartOnQuickForm(){
        getQuickViewAddToCartButton().shouldBe(visible).shouldBe(enabled).click();

        return this;
    }
}
