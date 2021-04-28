package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorMultiplyTest {

    @Test (groups = {"multiplyAndDivideTests", "allTests"},
           dataProviderClass = DataProviders.class, dataProvider = "multiplyData")
    public void calculatorMultiplyTest(long a, long b, long result) {
        Calculator calculator = new Calculator();
        long multiplication = calculator.mult(a, b);
        Assert.assertEquals(result, multiplication);
    }
}