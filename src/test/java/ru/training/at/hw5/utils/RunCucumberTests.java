package ru.training.at.hw5.utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/resources"})
public class RunCucumberTests extends AbstractTestNGCucumberTests {
}
