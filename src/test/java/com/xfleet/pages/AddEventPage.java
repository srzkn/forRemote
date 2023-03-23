package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEventPage {
    public AddEventPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='ui-dialog-title']")
    public WebElement addEventText;

    @FindBy(name = "oro_calendar_event_form[title]")
    public WebElement titleInputBox;

    @FindBy(name = "oro_calendar_event_form[organizerDisplayName]")
    public WebElement organizerDisplayNameInputBox;

    @FindBy(name = "oro_calendar_event_form[organizerEmail]")
    public WebElement organizerEmailInputBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[.='This value should not be blank.']")
    public WebElement errorMessage;

    @FindBy(xpath = "//button[@type='reset']")
    public WebElement cancelButton;
}
