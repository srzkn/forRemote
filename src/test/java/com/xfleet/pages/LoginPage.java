package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(css = ".progress.progress-striped.active")
    public List<WebElement> progressBar;

    public void loginToXFleet(String username, String password){
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();


    }

    public void waitForProgressBarToDisappear(){


        int count = 0;
        while(progressBar.size()!=0 && count <10) {
            try{ Thread.sleep(500);
                count++;
            }catch(Exception e){


            }
        }

    }


}
