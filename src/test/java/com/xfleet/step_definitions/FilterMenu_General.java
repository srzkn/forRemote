package com.xfleet.step_definitions;


import com.xfleet.pages.BasePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.pages.VehicleFilterMenuPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterMenu_General {
    LoginPage loginPage = new LoginPage();
    BasePage dashboard = new BasePage();
    VehicleFilterMenuPage vehicle = new VehicleFilterMenuPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("the user should be able to login in home page with {string} and {string}")
    public void the_user_should_be_able_to_login_in_home_page_with_and(String userName, String password) {
        loginPage.loginInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
        BrowserUtils.sleep(10);
    }

    @And("the user should be able to hover over the fleet menu and clicks to the fleet-vehicles page")
    public void the_user_should_be_able_to_hover_over_the_fleet_menu_and_clicks_to_the_fleet_vehicles_page() {

        dashboard.fleetMenu.click();
        dashboard.vehiclesFromFleet.click();
        BrowserUtils.sleep(10);
    }

    @And("the user should be able to clicks the filter icon")
    public void the_user_should_be_able_to_clicks_the_filter_icon() {


        js.executeScript("arguments[0].click();", vehicle.filtersBtn);

    }

    @Then("the user should be able to be visible the manage filter button")
    public void the_user_should_be_able_to_be_visible_the_manage_filter_button() {

        Assert.assertEquals("Manage filters", vehicle.manageFiltersBtn.getText());
    }

    @When("the user should be able to clicks the filter icon and the manage filter button")
    public void the_user_should_be_able_to_clicks_the_filter_icon_and_the_manage_filter_button() {


        js.executeScript("arguments[0].click();", vehicle.filtersBtn);

        js.executeScript("arguments[0].click();", vehicle.manageFiltersBtn);

    }

    @Then("the user should be able to be to click the filter name at the manage filters")
    public void the_user_should_be_able_to_be_to_click_the_name_at_the_manage_filters() {
        List<String> filterName = new ArrayList<>();
        filterName.addAll(Arrays.asList("License Plate", "Tags", "Location"));
        for (String each : filterName) {

            WebElement allselect = Driver.getDriver().findElement(By.xpath("//input[@title='" + each + "']"));
            allselect.click();

        }


    }

    @Then("the user should be able to be to type the filter name at the manage filters")
    public void the_user_should_be_able_to_be_to_type_the_filter_name_at_the_manage_filters() {

        js.executeScript("arguments[0].click();", vehicle.manageFiltersBtn);

        List<String> filterName = new ArrayList<>();
        filterName.addAll(Arrays.asList("License Plate", "Tags", "Location"));
        for (String each : filterName) {
            vehicle.manageFiltersBtn.sendKeys(each);

        }


    }


    @Then("the user should be able to click the reset icon and remove the all filters")
    public void the_user_should_be_able_to_click_the_reset_icon_and_remove_the_all_filters() {
        // Actions actions= new Actions(Driver.getDriver());
        // actions.moveToElement(vehicle.refreshBtn).perform();

        try {
            js.executeScript("arguments[0].click();", vehicle.refreshBtn);
            System.out.println("başarılı");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed");
        }

        Assert.assertTrue(vehicle.refreshBtn.isEnabled());
    }


}
/*
  js.executeScript("arguments[0].click();", vehicle.manageFiltersBtn);
        BrowserUtils.sleep(10);

        //String value = vehicle.mngCheckboxes.get(i).getText();
        //            System.out.println(value);



         int elementsCount= vehicle.mngCheckboxes.size();
        System.out.println("Amount of elements: " + elementsCount);

// loop and click through all elements found


        for (int x = 0; x < elementsCount; x++) {
            List<WebElement> elements = vehicle.mngCheckboxes;
            WebElement client = elements.get(x);
            client.click();
            Thread.sleep(5000);
        }



        List<String> filterName = new ArrayList<>();
        filterName.addAll(Arrays.asList("License Plate" , "Tags" ,"Location","Driver","Chassis Number",
                "Model Year","Last Odometer","Immatriculation Date","First Contract Date","Catalog Value (VAT Incl.)",
                "Seats Number" ,"Doors Number","Color" ,"Transmission", "Fuel Type" ,"CO2 Emissions",
                "Horsepower","Horsepower Taxation","Power (kW)"));
        for (String each : filterName) {
vehicle.manageFiltersBtn.sendKeys(each);

        }


    @Then("the user should be able to click the dashboard module")
    public void the_user_should_be_able_to_click_the_dashboard_module() {
        js.executeScript("arguments[0].click();", vehicle.backDashboardPage);

BrowserUtils.sleep(10);
    }
 */