package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesGeneralInfoPage {

    public VehiclesGeneralInfoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[.='General Information']")
    public WebElement generalInfoText;

    @FindBy(xpath = "//label[.='License Plate']/../div/div")
    public WebElement generalInfoLicencePlate;

    @FindBy(xpath = "//a[@title='Delete Car']")
    public WebElement deleteButtonOfGeneralInfo;

    @FindBy(xpath = "//a[@class='btn ok btn-danger']")
    public WebElement deleteConfirmYesButton;
}
