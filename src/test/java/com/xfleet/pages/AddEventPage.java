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

    @FindBy(xpath ="//i[.='Add Event']")
    public WebElement addEventButton;

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

    @FindBy(xpath = "//span[@title='#FF887C']")
    public WebElement selectColor;

    @FindBy(xpath = "(//input[@placeholder='time'])[1]")
    public WebElement timeBox;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement allDayCheckBox;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement repeatCheckBox;

    @FindBy(xpath ="//select[@id='recurrence-repeats-view121']")
    public WebElement repeatOptions;

    @FindBy(xpath ="(//input[@type='radio'])[3]")
    public WebElement endNever;

    @FindBy(xpath ="(//input[@type='radio'])[4]")
    public WebElement endAfter;

    @FindBy(xpath ="(//input[@type='radio'])[5]")
    public WebElement endBy;



}
