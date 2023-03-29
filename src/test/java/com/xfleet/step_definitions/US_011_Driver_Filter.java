package com.xfleet.step_definitions;

import com.xfleet.pages.DriverFilterPage;
import com.xfleet.pages.LoginPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;


public class US_011_Driver_Filter {
    DriverFilterPage driverFilterPage = new DriverFilterPage();
    LoginPage loginpage = new LoginPage();


    @Given("click manage filters")
    public void click_manage_filters() {

        driverFilterPage.manageFilters.click();

    }

    @Given("Select Driver checkboxes")
    public void select_driver_checkboxes() {

        driverFilterPage.checkBoxDriver.click();

    }

    @Given("Select Driver:All")
    public void select_driver_all() {

        driverFilterPage.driverAllButton.click();

    }

    @Given("Verify Driver checkbox is selected")
    public void verify_driver_checkbox_is_selected() {

        driverFilterPage.checkBoxDriver.isSelected();

    }

    @Given("type {string}")
    public void type(String string) {

        driverFilterPage.inputfield.sendKeys(string);

    }

    @Given("click upload button")
    public void click_upload_button() {

        driverFilterPage.uploadbutton.click();
       // BrowserUtils.waitFor(1);


    }

    @Then("the result should include {string}")
    public void the_result_should_include(String specifiedKeyword) {

        String actualKeyword = driverFilterPage.driverColumntd3.getText();
        System.out.println(actualKeyword);

        Assert.assertTrue(actualKeyword.contains(specifiedKeyword));


    }

    @Then("the results should not contain the {string}")
    public void the_results_should_not_contain_the(String string) {

        String actualKeyword = driverFilterPage.driverColumntd3.getText();
        System.out.println(actualKeyword);

        Assert.assertFalse(actualKeyword.contains(string));

    }

    @When("user select Starts With")
    public void user_select_starts_with() {
        driverFilterPage.startswith.click();

    }

    @Then("usual result shouldn't be appeared\\(No entities were found to match your search)")
    public void usual_result_shouldn_t_be_appeared_no_entities_were_found_to_match_your_search() {

        // driverFilterPage.uploadbutton.isDisplayed();
        driverFilterPage.nodatafound.isDisplayed();

    }

    @And("user click fleet module")
    public void userClickFleetModule() {

        driverFilterPage.fleetDropdown.click();

    }

    @And("user move to vehicles")
    public void userMoveToVehicles() {

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(driverFilterPage.fleetDropdown).
        moveToElement(driverFilterPage.vehicles).perform();

        driverFilterPage.vehicles.click();

        BrowserUtils.waitFor(11);



    }

    @And("go to filterSign")
    public void goToFilterSign() {

        driverFilterPage.filtersSign.click();

    }

    @When("users logins with his her {string} and {string}")
    public void usersLoginsWithHisHerAnd(String string, String string2) {

        driverFilterPage.loginField.sendKeys(string);
        driverFilterPage.passwordField.sendKeys(string2);
        driverFilterPage.loginButton.click();
        // BrowserUtils.waitFor(3);

    }

    @Given("users should be on the login page")
    public void usersShouldBeOnTheLoginPage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user click filter dropdown under Driver:All")
    public void userClickFilterDropdownUnderDriverAll() {

        driverFilterPage.choiceContainsEndswith.click();
    }

    @Then("select specified filter")
    public void selectSpecifiedFilter() {

        driverFilterPage.doesnotcontain.click();
    }

    @Then("select contains filter")
    public void selectContainsFilter() {
        driverFilterPage.contains.click();

    }

    @And("select Does Not Contain")
    public void selectDoesNotContain() {
        driverFilterPage.doesnotcontain.click();

    }

    @And("select {string}")//features.da endwith tırnak içinde yazmak gereksiz oldu.
    public void select(String arg0) {
        driverFilterPage.isequalto.click();

    }

    @Then("the results should start with the {string}")
    public void theResultsShouldStartWithThe(String specifiedKeyword) {

        String actualKeyword = driverFilterPage.driverColumntd3.getText();
        System.out.println(actualKeyword);

        Assert.assertTrue(actualKeyword.contains(specifiedKeyword));

    }

    @Then("the results should end with the {string}")
    public void theResultsShouldEndWithThe(String specifiedKeyword) {

        String actualKeyword = driverFilterPage.driverColumntd3.getText();
        System.out.println(actualKeyword);

        Assert.assertTrue(actualKeyword.endsWith(specifiedKeyword));
    }

    @Then("the results should match the {string} exactly")
    public void theResultsShouldMatchTheExactly(String specifiedKeyword) {
        String actualKeyword = driverFilterPage.driverColumntd3.getText();
        System.out.println(actualKeyword);

        Assert.assertEquals(actualKeyword, specifiedKeyword);

    }
}
