package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TopBarComponentPage {
    private final SelenideElement
            logo = $(By.xpath("//div[@id='header_logo']")),
            searchField = $(By.xpath("//input[@id='search_query_top']")),
            searchButton = $(By.xpath("//button[@name='submit_search']")),
            signInButton = $(By.xpath("//a[@class='login']")),
            signOutButton = $(By.xpath("//a[@class='logout']")),
            contactUsButton = $(By.xpath("//a[@title='Contact Us']")),
            cartButton = $(By.xpath("//a[@title='View my shopping cart']")),
            productQuantityLabel = $(By.xpath("//span[@class='ajax_cart_quantity unvisible']")),
            productQuantityLabelOnSpecProductPage = $(By.xpath("//a[@title='View my shopping cart']//span[@class='ajax_cart_quantity']")),
            emptyCartLabel = $(By.xpath("//span[@class='ajax_cart_no_product']")),
            cartCheckOutFromPreview = $(By.xpath("//a[@id='button_order_cart']")),
            cartProductPreview = $(By.xpath("//dt[contains(@class,'first_item')]"));

    public SelenideElement getLogo() {
        return logo;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public SelenideElement getSearchButton() {
        return searchButton;
    }

    public SelenideElement getSignInButton() {
        return signInButton;
    }

    public SelenideElement getSignOutButton() {
        return signOutButton;
    }

    public SelenideElement getContactUsButton() {
        return contactUsButton;
    }

    public SelenideElement getCartButton() {
        return cartButton;
    }

    public SelenideElement getProductQuantityLabel() {
        return productQuantityLabel;
    }

    public SelenideElement getProductQuantityLabelOnSpecProductPage() {
        return productQuantityLabelOnSpecProductPage;
    }

    public SelenideElement getEmptyCartLabel() {
        return emptyCartLabel;
    }

    public SelenideElement getCartCheckOutFromPreview() {
        return cartCheckOutFromPreview;
    }

    public SelenideElement getCartProductPreview() {
        return cartProductPreview;
    }

    public TopBarComponentPage act_clickOnLogo(){
        getLogo().shouldBe(visible).shouldBe(enabled).click();

        return this;
    }

    public TopBarComponentPage ver_cartEmpty(){
        getEmptyCartLabel().shouldHave(text("Empty"));

        return this;
    }

    public TopBarComponentPage ver_cartWithProduct(String productQuantity){
        getProductQuantityLabel().shouldHave(text(productQuantity));

        return this;
    }

    public TopBarComponentPage ver_cartWithProductOnSpecProductPage(String productQuantity){
        getProductQuantityLabelOnSpecProductPage().shouldHave(text(productQuantity));

        return this;
    }

    public TopBarComponentPage act_openCart(){
        getCartButton().shouldBe(visible).click();

        return this;
    }
}
