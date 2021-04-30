package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorMultiplyTest extends BaseCalculatorTest {

    @Test (groups = {"multiplyAndDivideTests"},
            dataProviderClass = DataProviders.class, dataProvider = "multiplyData")
    public void calculatorMultiplyTest(long a, long b, long result) {
        long multiplication = calculator.mult(a, b);
        Assert.assertEquals(result, multiplication);
    }
}