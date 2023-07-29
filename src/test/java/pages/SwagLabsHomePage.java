package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabsHomePage {
    WebDriver driver;
    By product1 = By.xpath("//*[@id=\"item_5_title_link\"]/div");
    By product2 = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    By product2Price = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    By shoppingCart = By.className("shopping_cart_link");


    public SwagLabsHomePage(WebDriver driver){
        this.driver=driver;
    }

    //Verify if the product1 is displayed
    public void product1IsDisplayed(){
        Assert.assertTrue(driver.findElement(product1).isDisplayed());
    }

    //Verify if the product2 is displayed
    public void product2IsDisplayed(){
        Assert.assertTrue(driver.findElement(product2).isDisplayed());
    }

    //Verify the product2 price
    public String price(){
        return driver.findElement(product2Price).getText().substring(1);
    }

    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }

    public void clickShoppingCart(){
        driver.findElement(shoppingCart).click();
    }




}
