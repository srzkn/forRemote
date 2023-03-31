package com.xfleet.step_definitions;

import com.xfleet.pages.BasePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.pages.VehiclesPage;
import com.xfleet.pages.VehicleFilterMenuPage;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Vehicle_Table_Columns_StepDefinitions {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    VehiclesPage vehiclesPage = new VehiclesPage();
    VehicleFilterMenuPage vehicleFilterMenuPage = new VehicleFilterMenuPage();

    FilterMenu_General filterMenuGeneral = new FilterMenu_General();

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();



    @Then("user can can sort a column in ascending order by clicking the column name")
    public void user_can_can_sort_a_column_in_ascending_order_by_clicking_the_column_name() throws InterruptedException {
        String expectedFirstRowTextLicencePlateAscending = "00BKVZ";
        Thread.sleep(10000);
        js.executeScript("arguments[0].click();", vehiclesPage.licensePlateButton);
        //vehiclesPage.licensePlateButton.click();
        Thread.sleep(10000);
        String actualFirstRowTextLicencePlateAscending = vehiclesPage.firstRowOfLicencePlateAfterSortingAndFiltering.getText();
        System.out.println("actualFirstRowTextLicencePlateAscending = " + actualFirstRowTextLicencePlateAscending);
        Assert.assertEquals(expectedFirstRowTextLicencePlateAscending,actualFirstRowTextLicencePlateAscending);

    }
    @Then("user can can sort a column in descending order by clicking the column name")
    public void user_can_can_sort_a_column_in_descending_order_by_clicking_the_column_name() throws InterruptedException {

        String expectedFirstRowTextLicencePlateDescending = "99WKOU";
        js.executeScript("arguments[0].click();", vehiclesPage.licensePlateButton);
        //vehiclesPage.licensePlateButton.click();
        Thread.sleep(10000);
        String actualFirstRowTextLicencePlateDescending = vehiclesPage.firstRowOfLicencePlateAfterSortingAndFiltering.getText();
        System.out.println("actualFirstRowTextLicencePlateDescending = " + actualFirstRowTextLicencePlateDescending);
        Assert.assertEquals(expectedFirstRowTextLicencePlateDescending,actualFirstRowTextLicencePlateDescending);
    }

    @Then("driver can can sort a column in ascending order by clicking the column name")
    public void driverCanCanSortAColumnInAscendingOrderByClickingTheColumnName() throws InterruptedException {

        String expectedFirstRowTextLicencePlateAscending = "00BKVZ";
        Thread.sleep(10000);
        js.executeScript("arguments[0].click();", vehiclesPage.licensePlateButton);
        //vehiclesPage.licensePlateButton.click();
        Thread.sleep(10000);
        String actualFirstRowTextLicencePlateAscending = vehiclesPage.firstRowOfLicencePlate.getText();
        System.out.println("actualFirstRowTextLicencePlateAscending = " + actualFirstRowTextLicencePlateAscending);
        Assert.assertEquals(expectedFirstRowTextLicencePlateAscending,actualFirstRowTextLicencePlateAscending);


    }

    @Then("driver can can sort a column in descending order by clicking the column name")
    public void driverCanCanSortAColumnInDescendingOrderByClickingTheColumnName() throws InterruptedException {

        String expectedFirstRowTextLicencePlateDescending = "99WKOU";
        js.executeScript("arguments[0].click();", vehiclesPage.licensePlateButton);
        //vehiclesPage.licensePlateButton.click();
        Thread.sleep(10000);
        String actualFirstRowTextLicencePlateDescending = vehiclesPage.firstRowOfLicencePlate.getText();
        System.out.println("actualFirstRowTextLicencePlateDescending = " + actualFirstRowTextLicencePlateDescending);
        Assert.assertEquals(expectedFirstRowTextLicencePlateDescending,actualFirstRowTextLicencePlateDescending);


    }



    @And("user sort and filter a column")
    public void userSortAndFilterAColumn() throws InterruptedException {

        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(5000);
        vehiclesPage.licensePlateButton.click();
        Thread.sleep(5000);

        filterMenuGeneral.the_user_should_be_able_to_clicks_the_filter_icon_and_the_manage_filter_button();
        Thread.sleep(5000);
        vehiclesPage.activatingLocationFilter();
        Thread.sleep(5000);
        vehiclesPage.locationButton.click();
        Thread.sleep(5000);
        vehiclesPage.locationInputBox.sendKeys("LUBATOWN" + Keys.ENTER);

    }

    @And("user click on the reset button")
    public void userClickOnTheResetButton() throws InterruptedException {

        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        vehiclesPage.resetButton.click();
        Thread.sleep(5000);
    }

    @Then("user can remove all sortings and filterings")
    public void userCanRemoveAllSortingsAndFilterings() throws InterruptedException {

        String expectedFirstRowTextLicencePlateOriginal = "40SVWU";
        String actualFirstRowTextLicencePlateAfterSortingAndFiltering = vehiclesPage.firstRowOfLicencePlateAfterSortingAndFiltering.getText();
        //Thread.sleep(5000);
        Assert.assertEquals(expectedFirstRowTextLicencePlateOriginal,actualFirstRowTextLicencePlateAfterSortingAndFiltering);

    }

    @Then("driver can remove all sortings and filterings")
    public void driverCanRemoveAllSortingsAndFilterings() {

        String expectedFirstRowTextLicencePlateOriginal = "40SVWU";
        String actualFirstRowTextLicencePlateAfterSortingAndFiltering = vehiclesPage.firstRowOfLicencePlate.getText();
        //Thread.sleep(5000);
        Assert.assertEquals(expectedFirstRowTextLicencePlateOriginal,actualFirstRowTextLicencePlateAfterSortingAndFiltering);

    }


}