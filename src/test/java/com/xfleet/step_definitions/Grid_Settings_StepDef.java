package com.xfleet.step_definitions;

import com.xfleet.pages.GridSettingsPage;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Grid_Settings_StepDef {

    GridSettingsPage gridSettingsPage =new GridSettingsPage();

    @Given("user, open the login page and user can be login")
    public void user_open_the_login_page_and_user_can_be_login() {
        Driver.getDriver().get("http://qa.xfleetsolutions.com");
        gridSettingsPage.loginInput.sendKeys("storemanager57");
        gridSettingsPage.passwordInput.sendKeys("UserUser123");
        gridSettingsPage.loginButton.click();
    }
    @Given("user click the gear button")
    public void user_click_the_gear_button() throws InterruptedException {
        gridSettingsPage.nemuGearButton.click();
    }
    @Given("user, can see grid setting")
    public void user_can_see_grid_setting() {
        Assert.assertTrue(gridSettingsPage.gridPopup.isDisplayed());
    }

    @Given("move mouse icon to fleet menu and click vehicle button")
    public void moveMouseIconToFleetMenuAndClickVehicleButton() throws InterruptedException {
        Actions actions=new Actions(Driver.getDriver());
        //WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]")));

        Thread.sleep(10000);
        actions.moveToElement(gridSettingsPage.menuFleet)
                .click()
                .moveToElement(gridSettingsPage.menuVahicles)
                .click()
                .perform();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Grid Settings']")));
        Thread.sleep(5000);
    }

    @And("user can see {string}")
    public void userCanSee(String str) {
        String text = "";
        for (WebElement each: gridSettingsPage.gridTable) {
            if(each.getText().equals(str)){
                text=str;
            }
        }
        Assert.assertEquals(str,text);
    }

    @And("user can search {string}")
    public void userCanSearch(String str) {

    }

    @And("user can click at {string}")
    public void userCanClickAt(String str) {

    }

    @And("user select the menuItem searchBox")
    public void userSelectTheMenuItemSearchBox() {

    }

    @And("user drag and drop {string}")
    public void userDragAndDrop(String arg0) {

    }

    @And("user can see changes")
    public void userCanSeeChanges() {

    }

}
