package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import ru.training.at.hw6.forms.LoginForm;

public class JdiHomePage extends WebPage {

    @Css("img#user-icon")
    public Link userIcon;

    @Css("login-form")
    public LoginForm loginForm;

    @Css("div[class='logout'] button")
    public Button logoutButton;

    @Css("span#user-name")
    public Button loggedIn;

    @Css(".m-l8")
    public Menu headerMenu;

}
