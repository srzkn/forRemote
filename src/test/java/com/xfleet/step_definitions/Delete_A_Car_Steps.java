package com.xfleet.step_definitions;

import com.xfleet.pages.BasePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.pages.VehiclesGeneralInfoPage;
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
    VehiclesGeneralInfoPage generalInfoPage = new VehiclesGeneralInfoPage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    String licencePlateOnTable;


    @Given("user should be on the login page")
    public void user_should_be_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("user logins with his her {string} and {string}")
    public void user_login_with_his_her_and(String userName, String Password) {
        loginPage.loginInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(Password);
        loginPage.loginButton.click();
        BrowserUtils.waitFor(3);

    }
    @When("choose Vehicles from Fleet menu")
    public void choose_vehicles_from_fleet_menu() {

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(basePage.fleetMenu).pause(2).
                moveToElement(basePage.vehiclesFromFleet).perform();

//not :(recep) yukarıya "click()" ekleyip burayı devre dışı bıraktım..
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
        wait.until(ExpectedConditions.visibilityOf(vehiclesPage.deleteButtonOfThreeDotMenu));
        vehiclesPage.deleteButtonOfThreeDotMenu.click();
    }
    @Then("she he must see delete confirmation message")
    public void she_he_must_see_delete_confirmation_message() {

       Assert.assertTrue(vehiclesPage.deleteConfirmation.isDisplayed());
    }

    @When("clicks yes,delete from delete confirmation")
    public void clicks_yes_delete_from_delete_confirmation() {
        vehiclesPage.deleteButtonOfDeleteConfirmation.click();


    }


    @Then("she he must see {string}")
    public void she_he_must_see(String message) {
        wait.until(ExpectedConditions.visibilityOf(vehiclesPage.youDontHavePermissionMessage));
       Assert.assertEquals(message,vehiclesPage.youDontHavePermissionMessage.getText());


    }
    @When("User login with his her username {string} and  password {string}")
    public void user_login_with_his_her_username_and_password(String username, String password) {

        loginPage.loginInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
        BrowserUtils.waitFor(5);
    }

    @When("hover over three dot menu on any row while logged in as driver")
    public void hover_over_three_dot_menu_on_any_row_while_logged_in_as_driver() {

        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitFor(3);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //I used table's css locator with js executor to scroll right to the end.
        js.executeScript("document.querySelector(\".grid-scrollable-container\").scrollLeft=3000");



        actions.moveToElement(vehiclesPage.threeDotMenu).perform();

        actions.moveToElement(vehiclesPage.deleteButtonOfThreeDotMenu).perform();
    }

    @When("clicks on any row")
    public void clicks_on_any_row() {
        BrowserUtils.waitFor(3);

        licencePlateOnTable = vehiclesPage.anyRowLicencePlate.getText();
        System.out.println(licencePlateOnTable);

        //wait.until(ExpectedConditions.elementToBeClickable(vehiclesPage.anyRow));

        vehiclesPage.anyRow.click();
        BrowserUtils.waitFor(3);

        String licencePlateOnGeneralInfo = generalInfoPage.generalInfoLicencePlate.getText();
        System.out.println(licencePlateOnGeneralInfo);


        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("arguments[0].click();",vehiclesPage.anyRow);


    }
    @Then("she or he must land on {string} page")
    public void s_he_must_land_on_page(String generalInfo) {

        System.out.println(generalInfoPage.generalInfoText.getText());
        Assert.assertEquals(generalInfo, generalInfoPage.generalInfoText.getText());
    }
    @Then("she or he clicks on delete")
    public void s_he_clicks_on_delete() {

        generalInfoPage.deleteButtonOfGeneralInfo.click();
        BrowserUtils.waitFor(3);
        generalInfoPage.deleteConfirmYesButton.click();
        BrowserUtils.waitFor(3);



    }
    @Then("the row must be deleted and {string} message must be displayed")
    public void the_row_must_be_deleted_and_message_must_be_displayed(String message) {

        wait.until(ExpectedConditions.visibilityOf(vehiclesPage.carDeletedMessage));

        //to compare if the "Car deleted" message is displayed
        Assert.assertEquals(message,vehiclesPage.carDeletedMessage.getText());

        System.out.println(vehiclesPage.carDeletedMessage.getText());

        System.out.println(licencePlateOnTable);

        //to check if the licence plate number is deleted.
        // I get whole licence plate numbers in a list then check if the licence plate is exist or not
        for (WebElement eachLicence : vehiclesPage.licencePlateColumn) {

            Assert.assertNotEquals(licencePlateOnTable,eachLicence.getText());

        }
    }

    @Then("{string} message must be displayed")
    public void message_must_be_displayed(String message) {

        wait.until(ExpectedConditions.visibilityOf(vehiclesPage.itemDeletedMessage));
        Assert.assertEquals(message,vehiclesPage.itemDeletedMessage.getText());

    }

    @Then("the corresponding car must be deleted from the Fleet-Vehicles page")
    public void the_corresponding_car_must_be_deleted_from_the_fleet_vehicles_page() {

        wait.until(ExpectedConditions.visibilityOf(vehiclesPage.carDeletedMessage));

        //to check if the licence plate number is deleted.
        // I get whole licence plate numbers in a list then check if the licence plate is exist or not
        for (WebElement eachLicence : vehiclesPage.licencePlateColumn) {

            Assert.assertNotEquals(licencePlateOnTable,eachLicence.getText());

        }

    }
}
