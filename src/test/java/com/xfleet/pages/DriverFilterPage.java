package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DriverFilterPage {

    public DriverFilterPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css ="button[class='ui-multiselect ui-corner-all select-filter-widget']")
    public WebElement manageFilters;

    // @FindBy(css ="button[class='ui-multiselect ui-corner-all select-filter-widget']")
         @FindBy(css="input[id='ui-multiselect-0-0-option-2']")
          public WebElement checkBoxDriver;

         @FindBy(className = "filter-items")
         public WebElement driverAllButton;

    @FindBy(css="span[class='title title-level-1']")
    public WebElement fleetDropdown;

    @FindBy(xpath = "//span[text()='Vehicles']")
    public WebElement vehicles;

    @FindBy(css="a[title='Filters']")
    public WebElement filtersSign;

    @FindBy(id = "prependedInput")
    public WebElement loginField;

    @FindBy(id = "prependedInput2")
    public WebElement passwordField;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(css = "button[class='btn dropdown-toggle']")
    public WebElement choiceContainsEndswith;


    @FindBy(css = "a[data-value='1']")
    public WebElement contains;

    @FindBy(css = "a[data-value='2']")
    public WebElement doesnotcontain;

    @FindBy(css = "a[data-value='3']")
    public WebElement isequalto;

    @FindBy(css = "a[data-value='4']")
    public WebElement startswith;

    @FindBy(css = "a[data-value='5']")
    public WebElement endswith;

    @FindBy(css = "a[data-value='6']")
    public WebElement isanyof;

    @FindBy(css = "a[data-value='7']")
    public WebElement isnotanyof;

    @FindBy(css = "a[data-value='filter_empty_option']")
    public WebElement isempty;

    @FindBy(css = "a[data-value='filter_not_empty_option']")
    public WebElement isnotempty;

    @FindBy(css = "input[name='value']")
    public WebElement inputfield;

    @FindBy(css = "button[class='btn btn-primary filter-update']")
    public WebElement uploadbutton;

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']/tbody//td[3]")
    public WebElement driverColumntd3;

    @FindBy(xpath = "//div[@class='no-data']/span")
    public WebElement nodatafound;


}
