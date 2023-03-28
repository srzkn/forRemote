package com.xfleet.step_definitions;

import com.xfleet.pages.GeneralInformationPage;
import com.xfleet.pages.LoginPage;
import com.xfleet.pages.Vehicle_Table_View_Page;
import com.xfleet.pages.VehiclesPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vehicle_Table_View_StepDefinitions {

    Vehicle_Table_View_Page vehicle_table_view_page=new Vehicle_Table_View_Page();

    LoginPage loginPage=new LoginPage();

    VehiclesPage vehiclesPage=new VehiclesPage ();
    @Then("user sees all vehicle information")
    public void user_sees_all_vehicle_information() {
        vehiclesPage.waitForLoadingBarToDisappear();
        Assert.assertTrue(vehicle_table_view_page.allVehicleInfoTable.isDisplayed() ) ;
    }

    @Then("users see the total page number")
    public void usersSeeTheTotalPageNumber() {
        vehiclesPage.waitForLoadingBarToDisappear();
       Assert.assertTrue(vehicle_table_view_page.totalPageNumber.isDisplayed());

    }

    @And("user should go to next page clicking > button")
    public void userShouldGoToNextPageClickingButton() {

        vehiclesPage.waitForLoadingBarToDisappear();
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.rightClickButton).perform();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",vehicle_table_view_page.rightClickButton);

    }


    @And("user should go to previous page clicking < button")
    public void userShouldGoToPreviousPageClickingButton() {
        vehiclesPage.waitForLoadingBarToDisappear();
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.leftClickButton).perform();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",vehicle_table_view_page.leftClickButton);

    }

    @Then("user should see total recordings")
    public void userShouldSeeTotalRecordings() {

        vehiclesPage.waitForLoadingBarToDisappear();
        //String expectedTextOfRecords="Total of 108 records";
        String actualTextOfRecords= vehicle_table_view_page.totalRecords.getText();
        Assert.assertTrue("geçersiz",actualTextOfRecords.startsWith("Total"));
        BrowserUtils.sleep(3);

    }

    @And("user click Export Grid")
    public void userClickExportGrid() {
        vehiclesPage.waitForLoadingBarToDisappear();

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.exportGridButton).perform();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",vehicle_table_view_page.exportGridButton);


    }
    @And("user select CSV option")
    public void userSelectCSVOption() {
        //vehiclesPage.waitForLoadingBarToDisappear();
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.CSVGridButton).click().perform();

        BrowserUtils.sleep(3);
/*
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",vehicle_table_view_page.CSVGridButton);*/


    }

    @Then("user sees the confirmation message")
    public void userSeesTheConfirmationMessage() {
        //BrowserUtils.waitForVisibility(vehicle_table_view_page.poupMessage,10);

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(vehicle_table_view_page.popUpMessage));
        Assert.assertEquals("Export started successfully. You will receive email notification upon completion.",
                vehicle_table_view_page.popUpMessage.getText());

    }


/*
    @When("user logins with {string} and {string}")
    public void userLoginsWithAnd(String arg0, String arg1) {
        loginPage.loginInput.sendKeys(arg0);
        loginPage.passwordInput.sendKeys(arg1);
        loginPage.loginButton.click();*/


}
