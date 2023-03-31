package com.xfleet.pages;


import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehicleFilterMenuPage {
    public VehicleFilterMenuPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='action btn mode-icon-only']/i")
    public WebElement filtersBtn;

    @FindBy(xpath = "//a[@class='add-filter-button']")
    public WebElement manageFiltersBtn;

    @FindBy(xpath = "(//i[@class='fa-refresh'])[2]")
    public WebElement refreshBtn;

    @FindBy(xpath = "(//span[@class='title title-level-2'][contains(.,'Dashboard')])[1]")
    public WebElement backDashboardPage;

    @FindBy(xpath = "//div[@class='ui-multiselect-checkboxes ui-helper-reset fixed-li']")
    public List<WebElement> mngCheckboxes;

    @FindBy(xpath = "//label[@title='Chassis Number']")
    public WebElement addFilterSelect;

    @FindBy(xpath = "//div[@class='ui-multiselect-reset']")
    public List<WebElement> selectFilters;

    @FindBy(xpath = "//i[contains(@class,'fa-trash-o hide-text')]")
    public WebElement delete;

    @FindBy(xpath = "//div[@class='loader-mask shown']/div")
    public List<WebElement> loaderMask;

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
}



