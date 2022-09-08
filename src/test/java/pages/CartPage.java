package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class CartPage extends TopBarComponentPage{
    private final SelenideElement
            cartTitle = $(By.xpath("//h1[@id='cart_title']")),
            orderSummaryTable = $(By.xpath("//div[@id='order-detail-content']")),
            productQuantity = $(By.xpath("//span[@id='summary_products_quantity']")),
            emptyCartLabel = $(By.xpath("//p[@class='alert alert-warning']")),
            unitPrice = $(By.xpath("//td[@data-title='Unit price']/span[@class='price']")),
            unitQty = $(By.xpath("//td[@class='cart_quantity text-center']//input[@type='hidden']")),
            unitQtyPlus = $(By.xpath("//a[@class='cart_quantity_up btn btn-default button-plus']")),
            unitQtyMinus = $(By.xpath("//a[@class='cart_quantity_down btn btn-default button-minus']")),
            totalShippingPrice = $(By.xpath("//td[@id='total_shipping']")),
            continueShoppingButton = $(By.xpath("//a[@title='Continue shopping']"));

    private final ElementsCollection
            deleteButton = $$(By.xpath("//a[@class='cart_quantity_delete']"));

    public SelenideElement getCartTitle() {
        return cartTitle;
    }

    public SelenideElement getOrderSummaryTable() {
        return orderSummaryTable;
    }

    public SelenideElement getProductQuantity() {
        return productQuantity;
    }

    @Override
    public SelenideElement getEmptyCartLabel() {
        return emptyCartLabel;
    }

    public SelenideElement getUnitPrice() {
        return unitPrice;
    }

    public SelenideElement getUnitQty() {
        return unitQty;
    }

    public SelenideElement getUnitQtyPlus() {
        return unitQtyPlus;
    }

    public SelenideElement getUnitQtyMinus() {
        return unitQtyMinus;
    }

    public ElementsCollection getDeleteButton() {
        return deleteButton;
    }

    public SelenideElement getTotalShippingPrice() {
        return totalShippingPrice;
    }

    public SelenideElement getContinueShoppingButton() {
        return continueShoppingButton;
    }

    public CartPage ver_cartPageIsOpened(){
        getCartTitle().shouldBe(visible);

        return this;
    }

    public CartPage ver_orderSummaryVisible(){
        getOrderSummaryTable().shouldBe(visible);

        return this;
    }

    public CartPage ver_productQuantity(String productQuantity){
        getProductQuantity().getText().equals(productQuantity);

        return this;
    }

    public CartPage act_deleteProduct(){
        while (getOrderSummaryTable().isDisplayed()){
            for (int i = 0; i < getDeleteButton().size(); i++) {
                getDeleteButton().get(i).shouldBe(visible).shouldBe(enabled).click();
                sleep(3000);
            }
        }

        return this;
    }

    public CartPage ver_cartPageIsEmpty(){
        getEmptyCartLabel().shouldBe(visible);

        return this;
    }
}
