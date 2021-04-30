package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorDivideTest extends BaseCalculatorTest {

    @Test (groups = {"multiplyAndDivideTests"},
            dataProviderClass = DataProviders.class, dataProvider = "divideData")
    public void calculatorDivideTest(long a, long b, long result) {
        long division = calculator.div(a, b);
        Assert.assertEquals(result, division);
    }
}