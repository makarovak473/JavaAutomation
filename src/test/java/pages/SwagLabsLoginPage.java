package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabsLoginPage {
    WebDriver driver;
    By username = By.name("user-name");
    By password = By.name("password");
    By login = By.name("login-button");

    By loginError = By.className("error-message-container");


    public SwagLabsLoginPage(WebDriver driver){
        this.driver=driver;
    }

    // Insert username in textbox
    public void setUserName(String strUserName){
        driver.findElement(username).sendKeys(strUserName);
    }

    // Insert password in textbox
    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }

    //Click on the login button
    public void clickLogin(){
        driver.findElement(login).click();
    }

    public String errorMessage(){
        return driver.findElement(loginError).getText();
    }

    public void loginToSwagLabs(String strUserName, String strPassWord){
        this.setUserName(strUserName);
        this.setPassword(strPassWord);
        this.clickLogin();
    }

}
