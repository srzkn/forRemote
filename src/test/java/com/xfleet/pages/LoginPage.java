package com.xfleet.pages;

import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    public void login(String username){
        if (username.equals("storemanager51")){
        loginInput.sendKeys(ConfigurationReader.getProperty("usr_name_storemanager"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
        }
        else {
            loginInput.sendKeys(ConfigurationReader.getProperty("usr_name_salesmanager"));
            passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
            loginButton.click();
        }
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

    public void login(){
        BrowserUtils.waitForVisibility(loginButton,5);
        loginInput.sendKeys(ConfigurationReader.getProperty("usr_name_storemanager"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

}
