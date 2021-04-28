package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSumTest {

    @Test (groups = {"sumAndSubtractTests", "allTests"},
           dataProviderClass = DataProviders.class, dataProvider = "sumData")
    public void calculatorSumTest(long a, long b, long result) {
        Calculator calculator = new Calculator();
        long sum = calculator.sum(a, b);
        Assert.assertEquals(result, sum);
    }
}
