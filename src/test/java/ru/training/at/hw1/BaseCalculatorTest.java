package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeGroups(alwaysRun = true)
    @BeforeSuite(alwaysRun = true)
    @BeforeMethod(alwaysRun = true)
    void calcSetUp() {
        calculator = new Calculator();
    }

    @AfterGroups(alwaysRun = true)
    @AfterSuite(alwaysRun = true)
    @AfterMethod(alwaysRun = true)
    void calcDismiss() {
        calculator = null;
    }
}
