package ru.training.at.hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.at.hw6.forms.LoginForm;
import ru.training.at.hw6.forms.MetalsAndColorsForm;
import ru.training.at.hw6.pages.JdiHomePage;
import ru.training.at.hw6.pages.MetalsAndColorsPage;


@JSite("https://jdi-testing.github.io/jdi-light")
public class JdiSite {

    @Url("/index.html")  @Title("Home Page")
    public static JdiHomePage jdiHomePage;

    @Url("/metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static LoginForm loginForm;

    public static MetalsAndColorsForm metalsAndColorsForm;


    public static void signOut() {
        jdiHomePage.userIcon.click();
        metalsAndColorsPage.logoutButton.click();
    }

}

