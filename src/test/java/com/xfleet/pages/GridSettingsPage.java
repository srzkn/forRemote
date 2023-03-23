package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GridSettingsPage {
    public GridSettingsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[contains(text(),'Grid Settings')]")
    public WebElement gridPopup;
    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement nemuGearButton;

    //*[@id="grid-custom-entity-grid-443981402"]/div[2]/div[1]/div/div[3]/div[1]/div/div/a/i
    @FindBy(xpath = "//*[@id='main-menu']/ul/li[2]/div/div/ul/li[3]")
    public WebElement menuVahicles;
    @FindBy(xpath = "//ul[@class='nav-multilevel main-menu']/li[2]")
    public WebElement menuFleet;

    @FindBy(id = "prependedInput")
    public WebElement loginInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;



}
