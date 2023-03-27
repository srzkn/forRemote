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


    @FindBy(xpath = "//tbody/tr[5]/td[21]/div/div/a")
    public WebElement threeDotMenu;



    @FindBy(css= "li[class='launcher-item']:nth-child(3)")

    public WebElement deleteButtonOfThreeDotMenu;

    @FindBy(css = ".modal-header>h3")
    public WebElement deleteConfirmation;

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










}
