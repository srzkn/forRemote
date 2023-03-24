package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GridSettingsPage {
    public GridSettingsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//td[@class='title-cell']//label//span")
    public WebElement searchResultTable;

    @FindBy(xpath = "//input[@data-role='column-manager-search']")
    public WebElement searchInput;

    @FindBy(xpath = "//tbody[@class='ui-sortable']//label")
    public List<WebElement> gridTable;

    @FindBy(xpath = "//div[contains(text(),'Grid Settings')]")
    public WebElement gridPopup;
    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement nemuGearButton;

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
