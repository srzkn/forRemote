package com.xfleet.step_definitions;

import com.xfleet.pages.BasePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.pages.VehiclesPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Delete_A_Car_Steps {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    VehiclesPage vehiclesPage = new VehiclesPage();
    Actions actions = new Actions(Driver.getDriver());


    @Given("User should be on the login page")
    public void user_should_be_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("User login with his her {string} and {string}")
    public void user_login_with_his_her_and(String userName, String Password) {
        loginPage.loginInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(Password);
        loginPage.loginButton.click();
        BrowserUtils.waitFor(4);

    }
    @When("choose Vehicles from Fleet menu")
    public void choose_vehicles_from_fleet_menu() {

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(basePage.fleetMenu).pause(2).
                moveToElement(basePage.vehiclesFromFleet).perform();


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].click();",basePage.vehiclesFromFleet);


    }
    @When("hover over three dot menu on any row")
    public void hover_over_three_dot_menu_on_any_row() {

        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitFor(3);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //I used table's css locator with js executor to scroll right to the end.
        js.executeScript("document.querySelector(\"div[class='grid-scrollable-container scrollbar-is-visible']\").scrollLeft=3000");



        actions.moveToElement(vehiclesPage.threeDotMenu).perform();

        actions.moveToElement(vehiclesPage.deleteButtonOfThreeDotMenu).perform();

    }

    @Then("she he must see the delete button")
    public void s_he_must_see_the_delete_button() {

        actions.moveToElement(vehiclesPage.deleteButtonOfThreeDotMenu).perform();

        Assert.assertTrue(vehiclesPage.deleteButtonOfThreeDotMenu.isDisplayed());
        Assert.assertTrue(vehiclesPage.deleteButtonOfThreeDotMenu.isEnabled());
    }

    @When("clicks on delete button")
    public void clicks_on_delete_button() {
        vehiclesPage.deleteButtonOfThreeDotMenu.click();
    }
    @Then("she he must see delete confirmation message")
    public void she_he_must_see_delete_confirmation_message() {

       Assert.assertTrue(vehiclesPage.deleteConfirmation.isDisplayed());
    }
}
