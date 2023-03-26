package com.xfleet.step_definitions;

import com.xfleet.pages.GeneralInformationPage;
import com.xfleet.pages.Vehicle_Table_View_Page;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class Vehicle_Table_View_StepDefinitions {

    Vehicle_Table_View_Page vehicle_table_view_page=new Vehicle_Table_View_Page();

    @Then("user sees all vehicle information")
    public void user_sees_all_vehicle_information() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(vehicle_table_view_page.allVehicleInfoTable.isDisplayed() ) ;
    }

    @Then("users see the total page number")
    public void usersSeeTheTotalPageNumber() {
        BrowserUtils.waitFor(3);
       Assert.assertTrue(vehicle_table_view_page.totalPageNumber.isDisplayed());

    }

    @And("user should go to next page clicking > button")
    public void userShouldGoToNextPageClickingButton() {

       //BrowserUtils.sleep(3);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.rightClickButton).pause(3000).perform();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].click();",vehicle_table_view_page.rightClickButton);
        BrowserUtils.sleep(3);
    }


    @And("user should go to previous page clicking < button")
    public void userShouldGoToPreviousPageClickingButton() {
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.leftClickButton).perform();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].click();",vehicle_table_view_page.leftClickButton);
        BrowserUtils.sleep(3);
    }

    @Then("user should see total recordings")
    public void userShouldSeeTotalRecordings() {
        String expectedTextOfRecords="Total of 108 records";
        String actualTextOfRecords= vehicle_table_view_page.totalRecords.getText();
        Assert.assertEquals(expectedTextOfRecords, actualTextOfRecords);

    }

    @And("user click Export Grid")
    public void userClickExportGrid() {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitFor(5);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.exportGridButton).click(vehicle_table_view_page.exportGridButton).perform();
        BrowserUtils.sleep(5);
    }
    @And("user select CSV option")
    public void userSelectCSVOption() {
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.CSVGridButton).pause(2).click(vehicle_table_view_page.CSVGridButton).perform();

    }


}
