package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubtractTest {

    @Test (groups = {"sumAndSubtractTests", "allTests"},
           dataProviderClass = DataProviders.class, dataProvider = "subtractData")
    public void calculatorSubtractTest(long a, long b, long result) {
        Calculator calculator = new Calculator();
        long difference = calculator.sub(a, b);
        Assert.assertEquals(result, difference);
    }
}
