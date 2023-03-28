package com.xfleet.step_definitions;

import com.xfleet.pages.BasePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.pages.VehiclesPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Vehicle_Table_Columns_StepDefinitions {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    VehiclesPage vehiclesPage = new VehiclesPage();


    @Then("user can can sort a column in ascending order by clicking the column name")
    public void user_can_can_sort_a_column_in_ascending_order_by_clicking_the_column_name() throws InterruptedException {
        String expectedFirstRowTextLicencePlateAscending = "00BKVZ";
        Thread.sleep(10000);
        vehiclesPage.licensePlateButton.click();
        Thread.sleep(10000);
        String actualFirstRowTextLicencePlateAscending = vehiclesPage.firstRowOfLicencePlate.getText();
        System.out.println("actualFirstRowTextLicencePlateAscending = " + actualFirstRowTextLicencePlateAscending);
        Assert.assertEquals(expectedFirstRowTextLicencePlateAscending,actualFirstRowTextLicencePlateAscending);

    }
    @Then("user can can sort a column in descending order by clicking the column name")
    public void user_can_can_sort_a_column_in_descending_order_by_clicking_the_column_name() throws InterruptedException {

        String expectedFirstRowTextLicencePlateDescending = "99WKOU";
        vehiclesPage.licensePlateButton.click();
        Thread.sleep(10000);
        String actualFirstRowTextLicencePlateDescending = vehiclesPage.firstRowOfLicencePlate.getText();
        System.out.println("actualFirstRowTextLicencePlateDescending = " + actualFirstRowTextLicencePlateDescending);
        Assert.assertEquals(expectedFirstRowTextLicencePlateDescending,actualFirstRowTextLicencePlateDescending);
    }


}
