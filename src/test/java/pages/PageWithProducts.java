package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;


public class PageWithProducts extends TopBarComponentPage{
    ElementsCollection
            productsInGrid = $$(By.xpath("//ul[@id='homefeatured']//a[@class='product_img_link']")),
            addToCartButtonOnGrid = $$(By.xpath("//ul[@id='homefeatured']//a[@title='Add to cart']")),
            moreButtonOnGrid = $$(By.xpath("//ul[@id='homefeatured']//a[@title='View']")),
            quickViewButtonOnGrid = $$(By.xpath("//ul[@id='homefeatured']//a[@class='quick-view']"));

    public ElementsCollection getProductsInGrid() {
        return productsInGrid;
    }

    public ElementsCollection getAddToCartButtonOnGrid() {
        return addToCartButtonOnGrid;
    }

    public ElementsCollection getMoreButtonOnGrid() {
        return moreButtonOnGrid;
    }

    public ElementsCollection getQuickViewButtonOnGrid() {
        return quickViewButtonOnGrid;
    }

    public PageWithProducts act_clickAddToCartOnGrid(String productName){
        for (int i = 0; i < getProductsInGrid().size(); i++) {
            if(getProductsInGrid().get(i).has(attribute("title", productName))){
                getProductsInGrid().get(i).hover();
                getAddToCartButtonOnGrid().get(i).shouldBe(visible).shouldBe(enabled).click();
                break;
            }
        }

        return this;
    }

    public PageWithProducts act_clickQuickViewButton(String productName){
        for (int i = 0; i < getProductsInGrid().size(); i++) {
            if(getProductsInGrid().get(i).has(attribute("title", productName))){
                getProductsInGrid().get(i).hover();
                getQuickViewButtonOnGrid().get(i).shouldBe(visible).shouldBe(enabled).click();
                break;
            }
        }


        return this;
    }

    public PageWithProducts act_clickMoreButtonOnGrid(String productName){
        for (int i = 0; i < getProductsInGrid().size(); i++) {
            if(getProductsInGrid().get(i).has(attribute("title", productName))){
                getProductsInGrid().get(i).hover();
                getMoreButtonOnGrid().get(i).shouldBe(visible).shouldBe(enabled).click();
                break;
            }
        }

        return this;
    }
}
