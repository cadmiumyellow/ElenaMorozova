package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorSumTest extends BaseCalculatorTest {

    @Test(groups = {"sumAndSubtractTests"},
            dataProviderClass = DataProviders.class, dataProvider = "sumData")
    public void calculatorSumTest(long a, long b, long result) {
        long sum = calculator.sum(a, b);
        Assert.assertEquals(result, sum);
    }
}
