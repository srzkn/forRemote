package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "prependedInput")
    public WebElement loginInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(css = "span[class='custom-checkbox__text']")
    public WebElement rememberMe;

    @FindBy(css = "a[href='/user/reset-request']")
    public WebElement forgotPassword;

    public void loginToXFleet(String username, String password){
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();


    }


}
