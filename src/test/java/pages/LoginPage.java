package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPage extends TopBarComponentPage {
    private final SelenideElement
            authenticationFormTitle = $(By.xpath("//h1[@class='page-heading']")),
            emailFieldCreate = $(By.xpath("//input[@id='email_create']")),
            emailFieldRegistered = $(By.xpath("//input[@id='email']")),
            passwordField = $(By.xpath("//input[@id='passwd']")),
            createUserButton = $(By.xpath("//button[@id='SubmitCreate']")),
            loginButton = $(By.xpath("//button[@id='SubmitLogin']")),
            userFirstNameField = $(By.xpath("//input[@id='customer_firstname']")),
            userLastNameField = $(By.xpath("//input[@id='customer_lastname']")),
            userPasswordField = $(By.xpath("//input[@id='passwd']")),
            userAddressField = $(By.xpath("//input[@id='address1']")),
            userCityField = $(By.xpath("//input[@id='city']")),
            userStateField = $(By.xpath("//div[@id='uniform-id_state']")),
            userPostcodeField = $(By.xpath("//input[@id='postcode']")),
            userPhoneNumberField = $(By.xpath("//input[@id='phone_mobile']")),
            registerButton = $(By.xpath("//button[@id='submitAccount']")),
            errorAlert = $(By.xpath("//div[@class='alert alert-danger']"));

    public SelenideElement getAuthenticationFormTitle() {
        return authenticationFormTitle;
    }

    public SelenideElement getEmailFieldCreate() {
        return emailFieldCreate;
    }

    public SelenideElement getEmailFieldRegistered() {
        return emailFieldRegistered;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getCreateUserButton() {
        return createUserButton;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public SelenideElement getUserFirstNameField() {
        return userFirstNameField;
    }

    public SelenideElement getUserLastNameField() {
        return userLastNameField;
    }

    public SelenideElement getUserPasswordField() {
        return userPasswordField;
    }

    public SelenideElement getUserAddressField() {
        return userAddressField;
    }

    public SelenideElement getUserCityField() {
        return userCityField;
    }

    public SelenideElement getUserStateField() {
        return userStateField;
    }

    public SelenideElement getUserPostcodeField() {
        return userPostcodeField;
    }

    public SelenideElement getUserPhoneNumberField() {
        return userPhoneNumberField;
    }

    public SelenideElement getRegisterButton() {
        return registerButton;
    }

    public SelenideElement getErrorAlert() {
        return errorAlert;
    }

    public LoginPage act_openSignInForm(){
        getSignInButton().shouldBe(visible).shouldBe(enabled).click();
        getAuthenticationFormTitle().shouldBe(visible).shouldHave(text("AUTHENTICATION"));

        return this;
    }

    public LoginPage act_startCreateUserProcess(String userEmail) {
        getEmailFieldCreate().shouldBe(visible).setValue(userEmail);
        getCreateUserButton().shouldBe(visible).shouldBe(enabled).click();
        getAuthenticationFormTitle().shouldBe(visible).shouldHave(text("CREATE AN ACCOUNT"));

        return this;
    }

    public LoginPage act_createNewUser(String firstName, String lastName, String password, String address, String city, String state, String postcode, String phoneNumber){
        getUserFirstNameField().shouldBe(visible).setValue(firstName);
        getUserLastNameField().shouldBe(visible).setValue(lastName);
        getUserPasswordField().shouldBe(visible).setValue(password);
        getUserAddressField().shouldBe(visible).setValue(address);
        getUserCityField().shouldBe(visible).setValue(city);
        getUserStateField().shouldBe(visible).click();
        $(By.xpath("//select[@id='id_state']//option[@value='9']")).shouldBe(visible).click();
        getUserPostcodeField().shouldBe(visible).setValue(postcode);
        getUserPhoneNumberField().shouldBe(visible).setValue(phoneNumber);
        getRegisterButton().shouldBe(visible).shouldBe(enabled).click();
        sleep(3000);
        getErrorAlert().shouldNotBe(visible);
        getAuthenticationFormTitle().shouldBe(visible).shouldHave(text("MY ACCOUNT"));

        return this;
    }

    public LoginPage act_loginAsExistingUser(String email, String password){
        getEmailFieldRegistered().shouldBe(visible).setValue(email);
        getUserPasswordField().shouldBe(visible).setValue(password);
        getLoginButton().shouldBe(visible).shouldBe(enabled).click();

        return this;
    }

    public LoginPage act_logOut(){
        getSignOutButton().shouldBe(visible).shouldBe(enabled).click();
        getAuthenticationFormTitle().shouldBe(visible).shouldHave(text("AUTHENTICATION"));

        return this;
    }
}
