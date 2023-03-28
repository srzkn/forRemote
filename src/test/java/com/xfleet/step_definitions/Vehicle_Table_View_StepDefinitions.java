package com.xfleet.step_definitions;

import com.xfleet.pages.GeneralInformationPage;
import com.xfleet.pages.LoginPage;
import com.xfleet.pages.Vehicle_Table_View_Page;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Vehicle_Table_View_StepDefinitions {

    Vehicle_Table_View_Page vehicle_table_view_page=new Vehicle_Table_View_Page();

    LoginPage loginPage=new LoginPage();

    @Then("user sees all vehicle information")
    public void user_sees_all_vehicle_information() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(vehicle_table_view_page.allVehicleInfoTable.isDisplayed() ) ;
    }

    @Then("users see the total page number")
    public void usersSeeTheTotalPageNumber() {
        BrowserUtils.waitFor(5);
       Assert.assertTrue(vehicle_table_view_page.totalPageNumber.isDisplayed());

    }

    @And("user should go to next page clicking > button")
    public void userShouldGoToNextPageClickingButton() {

        BrowserUtils.sleep(5);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.rightClickButton).perform();

        //BrowserUtils.waitForVisibility(vehicle_table_view_page.rightClickButton,10);
        BrowserUtils.sleep(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",vehicle_table_view_page.rightClickButton);

    }


    @And("user should go to previous page clicking < button")
    public void userShouldGoToPreviousPageClickingButton() {
        BrowserUtils.sleep(5);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.leftClickButton).perform();
        //BrowserUtils.waitForVisibility(vehicle_table_view_page.leftClickButton,10);
        BrowserUtils.sleep(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",vehicle_table_view_page.leftClickButton);
        BrowserUtils.sleep(3);
    }

    @Then("user should see total recordings")
    public void userShouldSeeTotalRecordings() {

        BrowserUtils.waitForPageToLoad(10);
        //String expectedTextOfRecords="Total of 108 records";
        String actualTextOfRecords= vehicle_table_view_page.totalRecords.getText();
        Assert.assertTrue(actualTextOfRecords.startsWith("Total of"));

    }

    @And("user click Export Grid")
    public void userClickExportGrid() {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.sleep(5);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.exportGridButton).perform();

       JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",vehicle_table_view_page.exportGridButton);
        BrowserUtils.sleep(5);
    }
    @And("user select CSV option")
    public void userSelectCSVOption() {

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(vehicle_table_view_page.CSVGridButton).perform();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",vehicle_table_view_page.CSVGridButton);
        BrowserUtils.sleep(3);





    }

    @Then("user sees the confirmation message")
    public void userSeesTheConfirmationMessage() {
        //BrowserUtils.waitForVisibility(vehicle_table_view_page.poupMessage,10);
        BrowserUtils.sleep(5);
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
