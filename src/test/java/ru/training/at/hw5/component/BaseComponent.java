package ru.training.at.hw5.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseComponent {
    protected final WebDriver driver;
    protected WebDriverWait wait;

    protected BaseComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(this.driver, this);
    }
}
