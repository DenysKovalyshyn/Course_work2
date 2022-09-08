package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SpecificProductPage extends TopBarComponentPage{
    SelenideElement
            specificProductPage = $(By.xpath("//div[@id='center_column']/div[@itemtype='http://schema.org/Product']")),
            specificProductAddToCartButton = $(By.xpath("//p[@id='add_to_cart']/button[@type='submit']"));

    public SelenideElement getSpecificProductPage() {
        return specificProductPage;
    }

    public SelenideElement getSpecificProductAddToCartButton() {
        return specificProductAddToCartButton;
    }

    public SpecificProductPage ver_specProductPageVisible(){
        getSpecificProductPage().shouldBe(visible);

        return this;
    }

    public SpecificProductPage act_clickAddToCartOnSpecPage(){
        getSpecificProductAddToCartButton().shouldBe(visible).shouldBe(enabled).click();

        return this;
    }
}
