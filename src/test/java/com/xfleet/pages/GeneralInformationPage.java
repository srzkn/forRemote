package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationPage {

    public GeneralInformationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btn icons-holder-text no-hash']")
    public WebElement addEventButton;

    @FindBy(xpath = "//h5[.='General Information']")
    public WebElement generalInformationText;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement eventSuccessfullyCreatedText;


}
