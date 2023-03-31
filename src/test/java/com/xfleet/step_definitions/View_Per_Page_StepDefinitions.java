package com.xfleet.step_definitions;

import com.xfleet.pages.BasePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.pages.VehiclesPage;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View_Per_Page_StepDefinitions {
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    VehiclesPage vehiclesPage = new VehiclesPage();

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @Then("user can click on View Per Page button")
    public void user_can_click_on_view_per_page_button() throws InterruptedException {
        Assert.assertTrue(vehiclesPage.viewPerPageButton.isEnabled());
        Thread.sleep(5000);
        Assert.assertTrue(vehiclesPage.viewPerPageButton.isDisplayed());
    }


    @Then("user should see 25 by default on the View Per Page dropdown menu")
    public void userShouldSeeByDefaultOnTheViewPerPageDropdownMenu() throws InterruptedException {

        //String innerHTML = vehiclesPage.viewPerPageButton.getAttribute("innerHTML");
        //System.out.println("innerHTML = " + innerHTML);

        //vehiclesPage.viewPerPageButton.click();
        //Thread.sleep(5000);

        Thread.sleep(8000);

        String actualDefaultValue = vehiclesPage.viewPerPageButton.getText();
        Thread.sleep(4000);
        String expectedDefaultValue = "25";
        Assert.assertEquals(expectedDefaultValue,actualDefaultValue);

        //Actions actions = new Actions(Driver.getDriver());
        //actions.moveToElement(vehiclesPage.viewPerPageButton).click().perform();
       // Thread.sleep(5000);

    }


    @Then("user should see all values on the View Per Page dropdown menu")
    public void userShouldSeeAllValuesOnTheViewPerPageDropdownMenu() throws InterruptedException {
        Thread.sleep(6000);
        js.executeScript("arguments[0].click();", vehiclesPage.viewPerPageButton);
        //vehiclesPage.viewPerPageButton.click();
        Thread.sleep(8000);

        List<String> actualValues = new ArrayList<>();

        for (WebElement each : vehiclesPage.allOptions) {
            actualValues.add(each.getText());
        }

        System.out.println(Arrays.toString(actualValues.toArray()));

        List<String> expectedValues = Arrays.asList("10"+"\n"+"25"+"\n"+"50"+"\n"+"100");

        System.out.println("Arrays.toString(expectedValues.toArray()) = " + Arrays.toString(expectedValues.toArray()));

        Assert.assertEquals(expectedValues,actualValues);

    }

    @Then("user can select each of the values")
    public void userCanSelectEachOfTheValues() {

        for (WebElement each : vehiclesPage.allOptions) {
            Assert.assertTrue(each.isEnabled());
            Assert.assertTrue(each.isDisplayed());
        }

        for (WebElement each : vehiclesPage.allOptions) {
            each.click();
            Driver.getDriver().navigate().refresh();
            js.executeScript("arguments[0].click();", vehiclesPage.viewPerPageButton);
            //vehiclesPage.viewPerPageButton.click();
        }

        //vehiclesPage.option10.click();
        //vehiclesPage.option25.click();
        //vehiclesPage.option50.click();
        //vehiclesPage.option100.click();

        //Assert.assertTrue(vehiclesPage.option10.isDisplayed());
        //Assert.assertTrue(vehiclesPage.option10.isEnabled());


    }
}
