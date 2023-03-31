package com.xfleet.step_definitions;

import com.xfleet.pages.*;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class AddEvent2_stepDefinitions {

    LoginPage loginPage=new LoginPage();
    BasePage basePage=new BasePage();
    VehiclesPage vehiclesPage=new VehiclesPage();
    AddEventPage addEventPage=new AddEventPage();
    BrowserUtils browserUtils=new BrowserUtils();
    Actions actions=new Actions(Driver.getDriver());

    @When("user logins with valid credentials")
    public void userLoginsWithValidCredentials() {
        loginPage.login();
        loginPage.waitForProgressBarToDisappear();
    }

    @When("user hovers over Fleet and clicks on vehicles")
    public void user_hovers_over_fleet_and_clicks_on_vehicles() {
        actions.moveToElement(basePage.fleetMenu).pause(1000).moveToElement(basePage.vehiclesFromFleet).click().perform();
        System.out.println("vehicles menu is clicked");
    }

    @When("user clicks on any vehicle")
    public void user_clicks_on_any_vehicle() {
        vehiclesPage.waitForLoadingBarToDisappear();
        actions.moveToElement(vehiclesPage.firstData).pause(1000).moveToElement(vehiclesPage.firstData).click().perform();
        vehiclesPage.waitForLoadingBarToDisappear();
        System.out.println("vehicle is clicked");
    }

    @Then("user can see Add Event button")
    public void user_can_see_add_event_button() {
        Assert.assertTrue(addEventPage.addEventButton.isDisplayed());
        System.out.println("add event button is seen");
    }

    @When("user clicks on Add Event button")
    public void user_clicks_on_add_event_button() {
        actions.moveToElement(addEventPage.addEventButton).pause(2000).moveToElement(addEventPage.addEventButton).click().perform();
        vehiclesPage.waitForLoadingBarToDisappear();
        System.out.println("add event button is CLICKED");
    }


    @Then("Add Event page pop ups")
    public void addEventPagePopUps() {
        vehiclesPage.waitForLoadingBarToDisappear();
        Assert.assertTrue(addEventPage.addEventText.isDisplayed());
        System.out.println("add event TITLE is DISPLAYED");
    }

    @When("user selects color")
    public void user_selects_color() {
        vehiclesPage.waitForLoadingBarToDisappear();
        if (addEventPage.selectColor.isEnabled()){
            System.out.println("button is Enabled");
            actions.moveToElement(addEventPage.selectColor).pause(1000).click().build().perform();
            System.out.println("button is Selected");
        }
        else{
            System.out.println("the color box is not enabled");
        }
    }
    @Then("the color is selected")
    public void the_color_is_selected() {
        vehiclesPage.waitForLoadingBarToDisappear();
        if (addEventPage.selectColor.isSelected()){
            System.out.println("button is Selected");
        }
        else{
            System.out.println("button is NOT SELECTED");
        }
    }
    @When("user selects repeat Checkbox")
    public void user_selects_repeat_checkbox() {
        actions.moveToElement(addEventPage.repeatCheckBox).click().build().perform();
    }

    @Then("repeat options are visible")
    public void repeat_options_are_visible() {
       Assert.assertTrue(addEventPage.repeatOptions.isDisplayed());
    }
    @Then("all three end options are visible and clickable")
    public void all_three_end_options_are_visible_and_clickable() {
        Assert.assertTrue(addEventPage.endNever.isEnabled());
        Assert.assertTrue(addEventPage.endAfter.isEnabled());
        Assert.assertTrue(addEventPage.endBy.isEnabled());
    }

    @And("user clicks on any vehicle with an event")
    public void userClicksOnAnyVehicleWithAnEvent() {
        vehiclesPage.waitForLoadingBarToDisappear();
        actions.moveToElement(vehiclesPage.carWithEvent).pause(1000).click().perform();
       System.out.println("vehicle is clicked");
    }

    @Then("user can see event information")
    public void userCanSeeEventInformation() {
        vehiclesPage.waitForLoadingBarToDisappear();
        Assert.assertTrue(vehiclesPage.eventDetails.isDisplayed());
    }

    @When("user selects All-day event Checkbox")
    public void user_selects_all_day_event_checkbox() {
        actions.moveToElement(addEventPage.allDayCheckBox).pause(1000).click().build().perform();
    }
    @Then("time-boxes disappear")
    public void time_boxes_disappear() {
        Assert.assertFalse(addEventPage.timeBox.isDisplayed());
    }
}
