package ru.training.at.hw1;

import org.testng.annotations.DataProvider;
import java.lang.Long;

public class DataProviders {

    @DataProvider (name = "sumData")
    public static Object[][] sumData() {
        return new Long[][] {
                {111L, 15L, 126L},
                {-170L, 23L, -147L},
                {0L, 564783L, 564783L},
                {0L, 0L, 0L},
                {-122L, -123L, -245L},
                {546738921L, 567489927L, 1114228848L}};
    }

    @DataProvider (name = "subtractData")
    public static Object[][] subtractData() {
        return new Long[][] {
                {111L, 15L, 96L},
                {-170L, 23L, -193L},
                {0L, 564783L, -564783L},
                {0L, 0L, 0L},
                {-122L, -123L, 1L},
                {546738921L, 567489927L, -20751006L}};
    }

    @DataProvider (name = "multiplyData")
    public static Object[][] multiplyData() {
        return new Long[][] {
                {111L, 15L, 1665L},
                {-170L, 23L, -3910L},
                {0L, 564783L, 0L},
                {0L, 0L, 0L},
                {-122L, -123L, 15006L},
                {5467389L, 5674899L, 31026880368711L}};
    }

    @DataProvider (name = "divideData")
    public static Object[][] divideData() {
        return new Long[][] {
                {111L, 15L, 7L},
                {-170L, 23L, -7L},
                {0L, 564783L, 0L},
                {-123L, -122L, 1L},
                {5467389L, 5674899L, 0L}};
    }
}

