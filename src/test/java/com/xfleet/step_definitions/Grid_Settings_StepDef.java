package com.xfleet.step_definitions;

import com.xfleet.pages.GridSettingsPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid_Settings_StepDef {
    Actions actions = new Actions(Driver.getDriver());
    GridSettingsPage gridSettingsPage = new GridSettingsPage();

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
    public void moveMouseIconToFleetMenuAndClickVehicleButton() {

        //WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]")));

        BrowserUtils.waitFor(10);
        actions.moveToElement(gridSettingsPage.menuFleet)
                .click()
                .moveToElement(gridSettingsPage.menuVahicles)
                .click()
                .perform();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Grid Settings']")));
        BrowserUtils.waitFor(10);
    }

    @And("user can see {string}")
    public void userCanSee(String str) {
        String text = "";
        for (WebElement each : gridSettingsPage.gridTable) {
            if (each.getText().equals(str)) {
                text = str;
            }
        }
        Assert.assertEquals(str, text);
    }

    @And("user can search {string}")
    public void userCanSearch(String str) {
        gridSettingsPage.searchInput.clear();
        gridSettingsPage.searchInput.sendKeys(str + Keys.ENTER);
        Assert.assertTrue(gridSettingsPage.searchResultTable.isDisplayed());

    }

    @And("user can click at {string}")
    public void userCanClickAt(String str) {
        for (WebElement each : gridSettingsPage.gridTable) {
            if (each.getText().equals(str)) {
                each.click();
            }
        }

    }


    @And("user drag and drop {string}")
    public void userDragAndDrop(String arg0) {
        //List<String> list = new ArrayList<>(Arrays.asList("Model Year", "Immatriculation Date", "Driver", "CO2 Emissions"));
            int index = 0;
            for (WebElement webElem : gridSettingsPage.gridTable) {
                if (webElem.getText().equals(arg0)) {
                    break;
                }
                index++;
            }
            actions.clickAndHold(gridSettingsPage.moveItemPoints.get(index))
                    .dragAndDrop(gridSettingsPage.moveItemPoints.get(index),gridSettingsPage.moveItemPoints.get(0))
                    .moveToElement(gridSettingsPage.moveItemPoints.get(0))
                    .release()
                    .perform();
            WebElement element=Driver.getDriver().findElement(By.xpath("(//span[@class='grid-header-cell__label'])[1]"));
            BrowserUtils.waitFor(1);
        //System.out.println(element.getText()+" -- "+arg0.toUpperCase());
            Assert.assertEquals(element.getText(),arg0.toUpperCase());



    }
        

    @And("user can click at {string} and checked vehicle table")
    public void userCanClickAtAndCheckedVehicleTable(String str) {
        int count = 0;
        boolean check = false;
        for (WebElement each : gridSettingsPage.gridTable) {
            if (each.getText().equals(str)) {
                each.click();
                if (gridSettingsPage.tableCheckBox.get(count).isSelected()) {
                    for (WebElement each1 : gridSettingsPage.vehicleTable) {
                        if (each1.getText().equalsIgnoreCase(str)) {
                            Assert.assertTrue(each1.getText().equalsIgnoreCase(str));
                        }
                    }
                } else {
                    for (WebElement each1 : gridSettingsPage.vehicleTable) {
                        if (each1.getText().equalsIgnoreCase(str)) {
                            check = true;
                        }
                    }
                    Assert.assertFalse(check);
                }
            }
            count++;
        }
    }


    @And("user can see changes")
    public void userCanSeeChanges() {


    }
}

