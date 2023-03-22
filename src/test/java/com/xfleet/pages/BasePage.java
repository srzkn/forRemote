package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[contains(text(),'Fleet')]")
    public WebElement fleetMenu;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehiclesFromFleet;

    @FindBy(css = ".grid-body")
    public WebElement table;

    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;

    //just added some notes here.
    //Basepage
    //added new line here
    //This line created by gserin


}
