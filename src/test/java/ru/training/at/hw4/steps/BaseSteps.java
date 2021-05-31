package ru.training.at.hw4.steps;

import org.openqa.selenium.WebDriver;
import ru.training.at.hw4.page.DifferentElementsPage;
import ru.training.at.hw4.page.HomePage;

import java.util.Arrays;
import java.util.List;

public class BaseSteps {
    protected WebDriver webDriver;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    protected static final String testPageUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String diffElementsPageUrl = "https://jdi-testing.github.io/jdi-light/different-elements.html";
    protected static final String browserTitle = "Home Page";
    protected static final String loggedName = "ROMAN IOVLEV";
    protected static final List<String> expectedHeaderFields =
            Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    protected static final List<String> expectedTexts = Arrays.asList(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),"
                    + "\nwish to get more…");
    protected static final List<String> expectedMenuTexts = Arrays.asList(
            "Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs");
    protected static final List<String> expectedLogsTexts = Arrays.asList(
            "Colors: value changed to Yellow",
            "metal: value changed to Selen",
            "Wind: condition changed to true",
            "Water: condition changed to true");
}
