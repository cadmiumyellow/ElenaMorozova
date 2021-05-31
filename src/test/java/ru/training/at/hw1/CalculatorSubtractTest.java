package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorSubtractTest extends BaseCalculatorTest {

    @Test (groups = {"sumAndSubtractTests"},
           dataProviderClass = DataProviders.class, dataProvider = "subtractData")
    public void calculatorSubtractTest(long a, long b, long result) {
        long difference = calculator.sub(a, b);
        Assert.assertEquals(result, difference);
    }
}