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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Delete_A_Car_Steps {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    VehiclesPage vehiclesPage = new VehiclesPage();


    @Given("User should be on the login page")
    public void user_should_be_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("User login with his her {string} and {string}")
    public void user_login_with_his_her_and(String userName, String Password) {
        loginPage.loginInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(Password);
        loginPage.loginButton.click();

    }
    @When("choose Vehicles from Fleet menu")
    public void choose_vehicles_from_fleet_menu() throws InterruptedException {

        //WebElement vehicles =(WebElement)((JavascriptExecutor)Driver.getDriver()).executeScript("return $(\":contains('Fleet'):last\").get(0);");

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.fleetMenu).perform();
       actions.moveToElement(basePage.vehiclesFromFleet).click().perform();
        BrowserUtils.waitFor(3);






    }
    @When("hover over three dot menu on any row")
    public void hover_over_three_dot_menu_on_any_row() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(vehiclesPage.threeDotMenu);
        BrowserUtils.waitFor(3);
    }

    @Then("she he must see the delete button")
    public void s_he_must_see_the_delete_button() {
        System.out.println("test");
    }
}
