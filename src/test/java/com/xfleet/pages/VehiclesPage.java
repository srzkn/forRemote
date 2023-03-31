package com.xfleet.pages;

import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class VehiclesPage {

    VehicleFilterMenuPage vehicleFilter = new VehicleFilterMenuPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    public VehiclesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='loader-mask shown']/div")
    public List<WebElement> loaderMask;

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

    @FindBy(xpath = "//span[.='License Plate']")
    public WebElement licensePlateButton;


    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement firstRowOfLicencePlate;

    @FindBy(xpath = "(//tbody/tr/td[2])[1]")
    public WebElement firstRowOfLicencePlateAfterSortingAndFiltering;

    @FindBy(xpath = "//a[@title='Reset']")
    public WebElement resetButton;

    @FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")
    public WebElement locationButton;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement locationInputBox;

    @FindBy(xpath = "//input[@id='ui-multiselect-0-0-option-3']")
    public WebElement locationCheckBox;

    public void activatingLocationFilter() throws InterruptedException {
        vehicleFilter.manageFiltersBtn.click();
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", locationCheckBox);
        //locationCheckBox.click();
    }

    @FindBy(xpath ="//td[3]")
    public WebElement firstData;

    @FindBy(xpath = "(//label[@class='dib'])[2]")
    public WebElement numberOfPages;

    @FindBy(xpath = "(//label[@class='dib'])[3]")
    public WebElement numberOfRecords;

    @FindBy(xpath = "//i[@class=\"fa-chevron-right hide-text\"]")
    public WebElement nextPage;

    @FindBy(xpath = "//div[@class='details']")
    public WebElement eventDetails;

    @FindBy (xpath = "//td[.='Miss Clemmie Kulas']")
    public WebElement carWithEvent;


    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rows;

    /**
     * This method gettext of a webElement and converts the number in text to int.
     * @param text
     * @return
     */
    public int getNumber(WebElement text){

        String numberOfRecords = text.getText();
        String onlyRecord="";

        for (int i = 0; i <numberOfRecords.length() ; i++) {

            if(Character.isDigit(numberOfRecords.charAt(i))){
                onlyRecord+=numberOfRecords.charAt(i);

            }
        }
        return Integer.parseInt(onlyRecord);
    }

    /**
     * This method will check 10 times, 1 second intervals till the loader disappears
     * If not it will give an exception. You can change time and intervals.
     * PS:You must assign loader to a List<WebElement>
     */
    public void waitForLoadingBarToDisappear(){


        int count = 0;
        while(loaderMask.size()!=0 && count <10) {
            try{ Thread.sleep(500);
            count++;
        }catch(Exception e){


            }
        }

    }

    public int getWholeRowNumber(){
        List<WebElement> wholeList = new ArrayList<>();


        int i = 1;
        while(i<= getNumber(numberOfPages) ){
            List<WebElement> vehicleRows = new ArrayList<>();
            vehicleRows = rows;
            wholeList.addAll(vehicleRows);
            BrowserUtils.waitFor(2);
            nextPage.click();
            BrowserUtils.waitFor(2);
            i++;
        }
        return wholeList.size();



    }







}
