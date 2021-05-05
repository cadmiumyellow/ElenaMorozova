package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.BaseSeleniumTestsSetup;

import java.util.Arrays;
import java.util.List;


public class JdiPageSeleniumSecondTest extends BaseSeleniumTestsSetup {

    @Test
    public void jdiSeleniumPageSecondTest() {
        // 1. Assert that test site page is loaded
        webDriver.navigate().to(testPageUrl);
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        softAssert.assertEquals(testPageUrl, webDriver.getCurrentUrl());

        //2. Assert that browser title is "Home page"
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        //3. Assert that user is logged
        WebElement loginDropdown = webDriverWait
                .until(webDriver -> webDriver.findElement(By.className("profile-photo")));
        loginDropdown.click();

        WebElement username = webDriverWait
                .until(webDriver -> webDriver.findElement(By.cssSelector(("input#name"))));
        username.sendKeys(userName);

        WebElement pass = webDriverWait
                .until(webDriver -> webDriver.findElement(By.cssSelector(("input#password"))));
        pass.sendKeys(password);

        WebElement loginButton = webDriverWait
                .until(webDriver -> webDriver.findElement(By.cssSelector(("button#login-button"))));
        loginButton.click();

        WebElement logout = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.cssSelector(("div[class='logout'] button"))));
        softAssert.assertTrue(logout.isEnabled());


        //4.Assert that user name is displayed and is equal to expected
        WebElement logged = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.cssSelector(("span#user-name"))));
        softAssert.assertTrue(logged.isDisplayed());
        softAssert.assertEquals(logged.getText(), "ROMAN IOVLEV");


        //5.Assert that Service -> Different Elements Page is opened
        WebElement serviceDropDown = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.cssSelector(("a.dropdown-toggle > span.caret:first-child"))));
        serviceDropDown.click();

        WebElement diffElementsPage = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.cssSelector(("header ul.dropdown-menu a[href='different-elements.html']"))));
        diffElementsPage.click();
        softAssert.assertEquals(diffElementsPageUrl, webDriver.getCurrentUrl());


        //6.Assert checkboxes Water, Wind are checked
        WebElement waterCheckbox = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.cssSelector((".label-checkbox:first-child > input"))));
        waterCheckbox.click();
        softAssert.assertTrue(waterCheckbox.isSelected());

        WebElement windCheckbox = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.cssSelector((".label-checkbox:nth-last-child(2) > input"))));
        windCheckbox.click();
        softAssert.assertTrue(windCheckbox.isSelected());

        //7. Assert radio Selen selection
        WebElement selenRadio = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.cssSelector((".label-radio:last-child > input"))));
        selenRadio.click();
        softAssert.assertTrue(selenRadio.isSelected());


        //8. Assert Yellow dropdown selected
        WebElement colorsDropDown = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.cssSelector((".colors"))));
        colorsDropDown.click();

        WebElement yellow = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.xpath(("//*[text()='Yellow']"))));
        yellow.click();
        softAssert.assertTrue(yellow.isSelected());

        //9. Assert logs for Water, Wind, Selen and Yellow
        List<String> expectedLogsTexts = Arrays.asList(
                "Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Metals & Colors",
                "Water: condition changed to true");

        List<WebElement> logs = webDriver.findElements(
                            By.cssSelector("ul.panel-body-list > li"));
        softAssert.assertTrue(logs.size() == 4);
        for (int h = 0; h < logs.size(); h++) {
            softAssert.assertEquals(logs.get(h).getText().substring(9), expectedLogsTexts.get(h));
        }

    }

}