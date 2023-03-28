package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vehicle_Table_View_Page {
    public Vehicle_Table_View_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div.other-scroll-container")
    public WebElement allVehicleInfoTable;

    @FindBy(xpath = "//div[@class='pagination pagination-centered']/label[2]")
    public WebElement totalPageNumber;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public WebElement rightClickButton;

    @FindBy(xpath = "//i[@class='fa-chevron-left hide-text']")
    public WebElement leftClickButton;

    @FindBy(xpath = "//label[.='Total of 108 records']")
    public WebElement totalRecords;

    @FindBy(xpath = "(//a[contains(@class,'btn')]/i)[1]")//(//a[contains(@class,'btn')]/i)[1]
    public WebElement exportGridButton;

    @FindBy(xpath = "//label[contains(text(),'Total')]")
    public WebElement CSVGridButton;

    @FindBy(xpath ="(//td[2])[1]")
    public WebElement firstData;



    @FindBy(xpath ="//div[.='Export started successfully. You will receive email notification upon completion.']")
      public WebElement popUpMessage;





}
