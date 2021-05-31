package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.BaseSeleniumTestsSetup;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class JdiPageSeleniumFirstTest extends BaseSeleniumTestsSetup {

    @Test
    public void jdiSeleniumPageFirstTest() {

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

        //5. Assert that there are 4 items on the header and they correspond to expected
        List<WebElement> headerElements = webDriverWait
                .until(webDriver -> webDriver.findElements(
                        By.xpath("//*[@class='uui-navigation nav navbar-nav m-l8']/child::li")));
        int expectedNoOfItems = 4;
        softAssert.assertEquals(headerElements.size(), expectedNoOfItems);
        List<String> expectedHeaderFields =
                Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (int i = 0; i < headerElements.size(); i++) {
            softAssert.assertEquals(headerElements.get(i).getText(),
                    expectedHeaderFields.get(i));
        }

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = webDriverWait
                .until(webDriver -> webDriver.findElements(
                By.cssSelector("div.benefit-icon")));
        int expectedNoOfIcons = 4;
        softAssert.assertEquals(icons.size(), expectedNoOfIcons);
        for (WebElement e : icons) {
            softAssert.assertTrue(e.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page and they have proper texts
        List<WebElement> iconsTexts = webDriverWait
                .until(webDriver -> webDriver.findElements(
                        By.cssSelector("span.benefit-txt")));
        int expectedNoOfTexts = 4;
        softAssert.assertEquals(iconsTexts.size(), expectedNoOfTexts);
        List<String> expectedTexts = Arrays.asList(
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),"
                        + "\nwish to get more…");
        for (int i = 0; i < iconsTexts.size(); i++) {
            softAssert.assertTrue(iconsTexts.get(i).isDisplayed());
            softAssert.assertEquals(iconsTexts.get(i).getText(),
                    expectedTexts.get(i));
        }

        //additional. Assert texts of the main headers
        WebElement headerText1 = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.cssSelector(("h3.main-title:first-child"))));
        String expectedHeader3 = "EPAM FRAMEWORK WISHES…";
        assertEquals(headerText1.getText(), expectedHeader3);

        WebElement headerText2 = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.name("jdi-text")));
        String expectedP = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "
                + "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. "
                + "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI "
                + "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT "
                + "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        softAssert.assertEquals(headerText2.getText(), expectedP);

        //8. Assert an iframe
        WebElement iframe = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.cssSelector(("div.main-content iframe[id='frame']"))));
        softAssert.assertTrue(iframe.isDisplayed());

        //9. Assert "Frame button" at iframe
        String windowHandler = webDriver.getWindowHandle();
        webDriver.switchTo().frame(iframe);
        softAssert.assertTrue(webDriver.findElement(
                By.id("button-frame")).isDisplayed());

        //10. Assert switch to the original window
        webDriver.switchTo().window(windowHandler);
        softAssert.assertEquals(testPageUrl, webDriver.getCurrentUrl());

        // additional Assert sub  header text
        WebElement jdiHeader = webDriver.findElement(
                By.xpath("//div[@class='main-content']/h3[@class='text-center']/a"));
        String expJdiHeaderText = "JDI GITHUB";
        assertEquals(jdiHeader.getText(), expJdiHeaderText);


        // additional - Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(jdiHeader.getTagName(), "a");
        assertEquals(jdiHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //11. Assert that there is Left Section and elements in it
        WebElement leftSection = webDriverWait
                .until(webDriver -> webDriver.findElement(
                        By.cssSelector(
                                ("div[name='navigation-sidebar'] > div#mCSB_1:first-child"))));
        softAssert.assertTrue(leftSection.isDisplayed());

        List<WebElement> leftMenuItems = webDriverWait
                .until(webDriver -> webDriver.findElements(
                        By.cssSelector("#mCSB_1_container > ul > li")));
        int expectedNoOfMenuItems = 5;
        softAssert.assertEquals(leftMenuItems.size(), expectedNoOfMenuItems);
        List<String> expectedMenuTexts = Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs");
        for (int i = 0; i < leftMenuItems.size(); i++) {
            softAssert.assertTrue(leftMenuItems.get(i).isDisplayed());
            softAssert.assertEquals(leftMenuItems.get(i).getText(),
                    expectedMenuTexts.get(i));
        }

        softAssert.assertAll();

    }

}
