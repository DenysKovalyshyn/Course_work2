package tests;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class LoginLogoutTests {
    LoginPage loginPage = new LoginPage();

    String unregisteredUserEmail = RandomStringUtils.randomAlphanumeric(10) + "@yahoo.com";
    String userFirstName = RandomStringUtils.randomAlphabetic(5);
    String userLastName = RandomStringUtils.randomAlphabetic(7);
    String userPassword = RandomStringUtils.randomAlphanumeric(10);
    String userAddress = "Freedom str, 777";
    String userCity = "Lviv";
    String userState = "Florida";
    String userPostcode = RandomStringUtils.randomNumeric(5);
    String userPhoneNumber = "+38063"+RandomStringUtils.randomNumeric(7);
    String existUserEmail = "qwerty@q.com";
    String existUserPassword = "123ewqasdcxz";

    @BeforeClass
    public void SetUp() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://automationpractice.com/index.php");
    }

    @Test (priority = 1)
    public void createNewCustomer() {
        loginPage
                .act_openSignInForm()
                .act_startCreateUserProcess(unregisteredUserEmail)
                .act_createNewUser(userFirstName, userLastName, userPassword, userAddress,userCity, userState, userPostcode, userPhoneNumber)
                .act_logOut();
    }

    @Test (priority = 2)
    public void loginLogout() {
        loginPage
                .act_openSignInForm()
                .act_loginAsExistingUser(existUserEmail, existUserPassword)
                .act_logOut();
    }
}
