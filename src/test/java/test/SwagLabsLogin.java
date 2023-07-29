package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SwagLabsHomePage;
import pages.SwagLabsLoginPage;

import static org.junit.Assert.assertEquals;

public class SwagLabsLogin {
    String driverpath = "src/main/resources/chromedriver.exe";
    WebDriver driver;
    SwagLabsLoginPage Login;
    SwagLabsHomePage HomePage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", driverpath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Create Login page Object
        Login = new SwagLabsLoginPage(driver);

        // Create HomePage Object
        HomePage = new SwagLabsHomePage(driver);
    }

    /**
     * The following test will log in with the 'standard_user' user account
     * Ensure that the ‘Sauce Labs Fleece Jacket’ product is displayed.
     */

    @Test
    public void loginAndVerifyProduct(){
        // Login to application
        Login.loginToSwagLabs("standard_user","secret_sauce");
        //Verify if the product is displayed
        HomePage.product1IsDisplayed();
    }

    /**
     * The following test will log in with the 'standard_user' using a wrong password
     * Ensure that an error is displayed stating that the log in credentials are incorrect
     */

    @Test
    public void loginErrorWithStandardUser(){
        Login.loginToSwagLabs("standard_user", "test123");
        assertEquals(Login.errorMessage() ,"Epic sadface: Username and password do not match any user in this service" );
    }

    /**
     * The following test will log in with the 'locked_out_user' user account
     * ensure that an error message is displayed stating that this user has been locked out of the platform.
     */

    @Test
    public void loginWithLockedUser(){
        Login.loginToSwagLabs("locked_out_user","secret_sauce");
        assertEquals(Login.errorMessage() ,"Epic sadface: Sorry, this user has been locked out." );
    }


    /**
     * The following test will log in with the 'locked_out_user' user account
     *  assert that the ‘Sauce Labs Backpack’ is $29.99,
     *  add it to the cart
     *  and ensure that it has been successfully added to the cart on the “Your cart” overview page
     */

    @Test
    public void loginAndAddProductToCart()  {
        Login.loginToSwagLabs("standard_user","secret_sauce");
        HomePage.product2IsDisplayed();
        assertEquals(HomePage.price(), "29.99");
        HomePage.clickAddToCart();
        HomePage.clickShoppingCart();
        HomePage.product2IsDisplayed();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
