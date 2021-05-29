package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw6.entities.MetalsAndColorsData;

import java.util.ArrayList;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {

    @UI("[name = custom_radio_odd]")
    public RadioButtons oddRadioButtons;

    @UI("[name = custom_radio_even]")
    public RadioButtons evenRadioButtons;

    public void selectSummary(ArrayList<String> summary) {
        oddRadioButtons.select(summary.get(0));
        evenRadioButtons.select(summary.get(1));
    }

    @UI("#elements-checklist > p > input")
    public static Checklist elementCheckboxes;

    public void selectElements(ArrayList<String> element) {
        for (String e : element) {
            elementCheckboxes.select(e);
        }
    }

    @JDropdown(root = "div[id=colors]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colors;

    public void selectColor(String color) {
        colors.select(color);
    }

    @JDropdown(root = "div[id=metals]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown metals;

    public void selectMetal(String metal) {
        metals.select(metal);
    }

    @JDropdown(root = "div[id=vegetables]",
            value = "button",
            list = "li",
            expand = ".caret")
    public Dropdown vegetables;

    @Css("#salad-dropdown > button")
    public Button vegetablesButton;

    @Css("#g7")
    public Checkbox vegetableCheckbox;

    public void uncheckVegetables() {
        vegetablesButton.click();
        vegetableCheckbox.uncheck();
    }

    public void selectVegetables(ArrayList<String> vegets) {
        uncheckVegetables();
        for (String s : vegets) {
            vegetables.select(s);
        }
    }

    @UI("#submit-button")
    public Button submitButton;

    public void submitForm(MetalsAndColorsData set) {
        selectSummary(set.getSummary());
        selectElements(set.getElements());
        selectColor(set.getColor());
        selectMetal(set.getMetals());
        selectVegetables(set.getVegetables());
        submitButton.click();
    }

}
