package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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







}
