package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclesPage {

    public VehiclesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='loader-mask shown']/div")
    public WebElement loaderMask;

    @FindBy(css = "tbody>tr:nth-child(5)")
    public WebElement anyRow;
    @FindBy(xpath = "//tbody/tr[5]/td[2]")
    public WebElement anyRowLicencePlate;

    @FindBy(xpath = "//tbody/tr[5]/td[@class='action-cell grid-cell grid-body-cell']/div/div/a")
    public WebElement threeDotMenu;

    @FindBy(css= "li[class='launcher-item']:nth-child(3)")
    public WebElement deleteButtonOfThreeDotMenu;

    @FindBy(css = ".modal-header>h3")
    public WebElement deleteConfirmation;


    @FindBy(css = ".btn.ok.btn-danger")
    public WebElement deleteButtonOfDeleteConfirmation;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement youDontHavePermissionMessage;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement carDeletedMessage;

    @FindBy(xpath = "//td[@data-column-label='License Plate']")
    public List<WebElement> licencePlateColumn;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement itemDeletedMessage;
    
    @FindBy(xpath = "//td[.='Berry Senger']")
    public WebElement thirdRow;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[1]")
    public WebElement viewPerPageButton;


    @FindBy(xpath = "(//ul[@class='dropdown-menu pull-right'])[2]")
    public List<WebElement> allOptions;

    @FindBy(xpath = "(//ul[@class='dropdown-menu pull-right'])[2]/li[1]")
    public WebElement option10;

    @FindBy(xpath = "(//ul[@class='dropdown-menu pull-right'])[2]/li[2]")
    public WebElement option25;

    @FindBy(xpath = "(//ul[@class='dropdown-menu pull-right'])[2]/li[3]")
    public WebElement option50;

    @FindBy(xpath = "(//ul[@class='dropdown-menu pull-right'])[2]/li[4]")
    public WebElement option100;




    @FindBy(xpath ="//td[3]")
    public WebElement firstData;

    @FindBy(xpath = "(//label[@class='dib'])[2]")
    public WebElement numberOfPages;

    @FindBy(xpath = "//i[@class=\"fa-chevron-right hide-text\"]")
    public WebElement nextPage;

    @FindBy(xpath = "//div[@class='details']")
    public WebElement eventDetails;

    @FindBy (xpath = "//td[.='Miss Clemmie Kulas']")
    public WebElement carWithEvent;








}
