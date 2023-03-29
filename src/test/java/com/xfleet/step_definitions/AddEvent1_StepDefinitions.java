package com.xfleet.step_definitions;

import com.xfleet.pages.*;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEvent1_StepDefinitions {
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    VehiclesPage vehiclesPage = new VehiclesPage();
    GeneralInformationPage generalInformationPage = new GeneralInformationPage();
    AddEventPage addEventPage = new AddEventPage();



    @When("user clicks vehicles option under the Fleet radio button")
    public void userClicksVehiclesOptionUnderTheFleetRadioButton() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.loginInput.sendKeys("storemanager51");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginButton.click();
       // basePage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(8);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.fleetMenu).pause(200).click(basePage.vehiclesFromFleet).build().perform();

    }

    @And("user clicks any vehicle row under fleet-vehicle module")
    public void user_clicks_any_vehicle_row_under_fleet_vehicle_module() {
       BrowserUtils.waitFor(8);
        //basePage.waitUntilLoaderScreenDisappear();
        vehiclesPage.thirdRow.click();
    }

    @Then("general information page will be open and the user can see add event page")
    public void general_information_page_will_be_open_and_the_user_can_see_add_event_page() {
        BrowserUtils.waitFor(8);
        //basePage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(generalInformationPage.generalInformationText.isDisplayed());
    }


    @When("Store manager on the general information page")
    public void storeManagerOnTheGeneralInformationPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.loginInput.sendKeys("storemanager51");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginButton.click();

        BrowserUtils.waitFor(8);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.fleetMenu).pause(200).click(basePage.vehiclesFromFleet).build().perform();

        BrowserUtils.waitFor(8);
        vehiclesPage.thirdRow.click();

    }

    @Then("s-he can see add event button and click it")
    public void sHeCanSeeAddEventButtonAndClickIt() {

        BrowserUtils.waitFor(8);
        Assert.assertTrue(generalInformationPage.generalInformationText.isDisplayed());
    }

    @When("Sales Manager on the general information page")
    public void salesManagerOnTheGeneralInformationPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.loginInput.sendKeys("salesmanager101");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginButton.click();

        BrowserUtils.waitFor(8);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.fleetMenu).pause(200).click(basePage.vehiclesFromFleet).build().perform();

        BrowserUtils.waitFor(8);
        vehiclesPage.thirdRow.click();
    }

    @When("driver opens the general information page")
    public void driverOpensTheGeneralInformationPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.loginInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginButton.click();

        BrowserUtils.waitFor(8);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.fleetMenu).pause(200).click(basePage.vehiclesFromFleet).build().perform();

        BrowserUtils.waitFor(8);
        vehiclesPage.thirdRow.click();
    }

    @Then("driver can not see add event button")
    public void driverCanNotSeeAddEventButton() {
        BrowserUtils.waitFor(8);
        Assert.assertTrue(!generalInformationPage.generalInformationText.isDisplayed());
        addEventPage.cancelButton.click();
    }

    @When("Sales Manager or Store manager clicks the add event button")
    public void salesManagerOrStoreManagerClicksTheAddEventButton() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.loginInput.sendKeys("salesmanager101");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginButton.click();

        BrowserUtils.waitFor(8);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.fleetMenu).pause(200).click(basePage.vehiclesFromFleet).build().perform();

        BrowserUtils.waitFor(8);
        vehiclesPage.thirdRow.click();

        BrowserUtils.waitFor(8);
        generalInformationPage.addEventButton.click();
    }

    @Then("add event page should pop up")
    public void addEventPageShouldPopUp() {
        BrowserUtils.waitFor(4);
        Assert.assertTrue(addEventPage.addEventText.isDisplayed());
        addEventPage.cancelButton.click();

    }

    @When("Sales Manager or Store manager create an event they fill the compulsory fields")
    public void salesManagerOrStoreManagerCreateAnEventTheyFillTheCompulsoryFields() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.loginInput.sendKeys("salesmanager101");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginButton.click();

        BrowserUtils.waitFor(8);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.fleetMenu).pause(200).click(basePage.vehiclesFromFleet).build().perform();

        BrowserUtils.waitFor(8);
        vehiclesPage.thirdRow.click();

        BrowserUtils.waitFor(8);
        generalInformationPage.addEventButton.click();
        BrowserUtils.waitFor(4);

        addEventPage.titleInputBox.click();
        addEventPage.titleInputBox.sendKeys("title");

        addEventPage.organizerDisplayNameInputBox.click();
        addEventPage.organizerDisplayNameInputBox.sendKeys("john");

        addEventPage.saveButton.click();


    }

    @Then("they can save the event")
    public void theyCanSaveTheEvent() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(!(generalInformationPage.eventSuccessfullyCreatedText.isDisplayed()));
    }

    @When("Sales Manager or Store manager create an event they dont fill the compulsory fields and try to save the event")
    public void salesManagerOrStoreManagerCreateAnEventTheyDontFillTheCompulsoryFieldsAndTryToSaveTheEvent() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.loginInput.sendKeys("salesmanager101");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginButton.click();

        BrowserUtils.waitFor(8);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.fleetMenu).pause(200).click(basePage.vehiclesFromFleet).build().perform();

        BrowserUtils.waitFor(8);
        vehiclesPage.thirdRow.click();

        BrowserUtils.waitFor(8);
        generalInformationPage.addEventButton.click();
        BrowserUtils.waitFor(4);

        addEventPage.titleInputBox.click();
        addEventPage.titleInputBox.sendKeys("title");

        addEventPage.organizerDisplayNameInputBox.click();
        addEventPage.organizerDisplayNameInputBox.sendKeys("john");

        addEventPage.saveButton.click();

    }

    @Then("the This value should not be blank. message should be displayed after clicking on the save button")
    public void theThisValueShouldNotBeBlankMessageShouldBeDisplayedAfterClickingOnTheSaveButton() {

        try {
            Assert.assertTrue(addEventPage.errorMessage.isDisplayed());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            Assert.assertTrue(false);
            addEventPage.cancelButton.click();
        }
    }



}
