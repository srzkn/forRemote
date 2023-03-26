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
    }

    @When("user hovers over Fleet and clicks on vehicles")
    public void user_hovers_over_fleet_and_clicks_on_vehicles() {
        BrowserUtils.waitForVisibility(basePage.fleetMenu,10);

       //actions.moveToElement(basePage.fleetMenu).pause(2000).click(basePage.vehiclesFromFleet).build().perform();
        actions.moveToElement(basePage.fleetMenu).pause(200).moveToElement(basePage.vehiclesFromFleet).perform();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].click();",basePage.vehiclesFromFleet);
        System.out.println("vehicles menu is clicked");
    }

    @When("user clicks on any vehicle")
    public void user_clicks_on_any_vehicle() {
        //BrowserUtils.waitForClickablility(vehiclesPage.firstData,10);
        BrowserUtils.waitFor(4);
        vehiclesPage.firstData.click();
        actions.moveToElement(vehiclesPage.firstData).pause(200).click(vehiclesPage.firstData).perform();
        System.out.println("vehicle is clicked");
    }

    @Then("user can see Add Event button")
    public void user_can_see_add_event_button() {
        //BrowserUtils.waitForClickablility(addEventPage.addEventButton,10);
        BrowserUtils.waitFor(4);
        Assert.assertTrue(addEventPage.addEventButton.isDisplayed());
        System.out.println("add event button is seen");
    }

    @When("user clicks on Add Event button")
    public void user_clicks_on_add_event_button() {
        BrowserUtils.waitForClickablility(addEventPage.addEventButton,10);
        addEventPage.addEventButton.click();
    }


    @Then("Add Event page pop ups")
    public void addEventPagePopUps() {
        //BrowserUtils.waitForVisibility(addEventPage.addEventText,10);
        Assert.assertTrue(addEventPage.addEventText.isDisplayed());
    }

    @When("user selects color")
    public void user_selects_color() {
        //BrowserUtils.waitForVisibility(addEventPage.selectColor,10);
        actions.moveToElement(addEventPage.selectColor).click().build().perform();
    }
    @Then("the color is selected")
    public void the_color_is_selected() {
        Assert.assertTrue(addEventPage.selectColor.isSelected());
    }

    @When("user selects All Day Checkbox")
    public void user_selects_all_day_checkbox() {
        actions.moveToElement(addEventPage.allDayCheckBox).click().build().perform();
    }
    @Then("time boxes disappear")
    public void time_boxes_disappear() {
       Assert.assertFalse(addEventPage.timeBox.isDisplayed());
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
        //BrowserUtils.waitForClickablility(vehiclesPage.firstData,10);
        BrowserUtils.waitFor(4);
        vehiclesPage.carWithEvent.click();
       System.out.println("vehicle is clicked");
    }

    @Then("user can see event information")
    public void userCanSeeEventInformation() {
        Assert.assertTrue(vehiclesPage.eventDetails.isDisplayed());
    }
}
