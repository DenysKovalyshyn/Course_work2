package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class WorkWithProductTests {
    LoginPage loginPage = new LoginPage();
    PageWithProducts pageWithProducts = new PageWithProducts();
    PopUpComponentPage popUpComponentPage = new PopUpComponentPage();
    TopBarComponentPage topBarComponentPage = new TopBarComponentPage();
    SpecificProductPage specificProductPage = new SpecificProductPage();
    CartPage cartPage = new CartPage();

    String existUserEmail = "qwerty@q.com";
    String existUserPassword = "123ewqasdcxz";
    String productName = "Blouse";

    @BeforeClass
    public void SetUp() {
        Configuration.timeout = 20000;
        Configuration.startMaximized = true;
        open("http://automationpractice.com/index.php");
        loginPage.act_openSignInForm().act_loginAsExistingUser(existUserEmail, existUserPassword);
    }

    @Test (priority = 1, description = "in the following test we are adding the product to the cart"+
            "using 'add to cart' button on the product grid")
    public void addProductFromGrid() {
        pageWithProducts
                .act_clickOnLogo();
        topBarComponentPage
                .ver_cartEmpty();
        pageWithProducts
                .act_clickAddToCartOnGrid(productName);
        popUpComponentPage
                .ver_successfulPopUpVisible()
                .act_closeCartPopUp();
        topBarComponentPage
                .ver_cartWithProduct("1");
    }

    @Test(priority = 2, description = "in the following test we are adding the product to the cart"+
            "using 'add to cart' button on the preview")
    public void addProductFromQuickView(){
        pageWithProducts
                .act_clickQuickViewButton(productName);
        switchTo().frame(1);
        popUpComponentPage
                .ver_quickViewFormVisible()
                .act_clickAddToCartOnQuickForm();
        switchTo().defaultContent();
        popUpComponentPage
                .ver_successfulPopUpVisible()
                .act_closeCartPopUp();
        topBarComponentPage
                .ver_cartWithProduct("2");
    }

    @Test(priority = 3, description = "in the following test we are adding the product to the cart"+
            "using 'add to cart' button on the product page")
    public void addProductFromProductPage(){
        pageWithProducts
                .act_clickMoreButtonOnGrid(productName);
        specificProductPage
                .ver_specProductPageVisible()
                .act_clickAddToCartOnSpecPage();
        popUpComponentPage
                .ver_successfulPopUpVisible()
                .act_closeCartPopUp();
        topBarComponentPage
                .ver_cartWithProductOnSpecProductPage("3");
    }

    @Test(priority = 4, description = "inthe following test we are checking if product is displayed on the cart page")
    public void checkProductOnCartPage(){
        topBarComponentPage
                .act_openCart();
        cartPage
                .ver_cartPageIsOpened()
                .ver_orderSummaryVisible()
                .ver_productQuantity("3");
    }

    @Test(priority = 5, description = "in the following test we are deleting the product from cart page")
    public void deleteProductFromCartPage(){
        cartPage
                .act_deleteProduct()
                .ver_cartPageIsEmpty();
    }
}
