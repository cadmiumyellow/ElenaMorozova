package ru.training.at.hw5.step;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.page.HomePage;

public class CucumberCommonSteps {

    private final WebDriver driver = TestContext.getInstance()
            .getTestObject(TestContext.WEB_DRIVER);

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        new HomePage(driver).goToHomePage();
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void loginToHomePage() {
        new HomePage(driver).login();
    }

    @Given("I click on \"Service\" button in Header")
    public void clickServiceItemInHeader() {
        new HomePage(driver).clickServiceHeaderElement();
    }

    @Given("I click Different Elements Page")
    public void clickDifferentElementsPage() {
        new HomePage(driver).goToServiceDiffElementsPage();
    }

    @Given("I click on \"User Table\" button in Service dropdown")
    public void clickUserTablePage() {
        new HomePage(driver).goToUserTablePage();
    }

}
