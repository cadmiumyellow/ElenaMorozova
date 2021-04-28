package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDivideTest {

    @Test (groups = {"multiplyAndDivideTests", "allTests"},
           dataProviderClass = DataProviders.class, dataProvider = "divideData")
    public void calculatorDivideTest(long a, long b, long result) {
        Calculator calculator = new Calculator();
        long division = calculator.div(a, b);
        Assert.assertEquals(result, division);
    }
}
