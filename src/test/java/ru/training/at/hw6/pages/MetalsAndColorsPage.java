package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.WebElement;
import ru.training.at.hw6.entities.MetalsAndColorsData;
import ru.training.at.hw6.forms.MetalsAndColorsForm;

import java.util.List;

public class MetalsAndColorsPage extends WebPage {

    @Css(".form")
    public MetalsAndColorsForm metalsAndColorsForm;

    @Css(".results > li")
    public List<WebElement> results;

    @Css(".logout")
    public Button logoutButton;

    public boolean resultsContainData(MetalsAndColorsData set, int i) {
        List<String> list = set.setToList();
        return list.get(i).contains(results.get(i).getText());
    }

}

