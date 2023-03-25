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

    @FindBy(xpath = "(//label[@class='dib'])[2]")
    public WebElement numberOfPages;

    @FindBy(xpath = "//i[@class=\"fa-chevron-right hide-text\"]")
    public WebElement nextPage;







}
