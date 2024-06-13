package com.pages;

import com.constants.ConstantGlobal;
import com.dataprovider.ReadJsonFile;
import com.keywords.WebUI;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.keywords.WebUI.getText;

public class LoginPageDemo {
    public LoginPageDemo() {
    }

    private final By userNameTextBox = By.id("loginusername");
    private final By passwordTextBox = By.id("loginpassword");
    private final By loginInButton = By.id("login2");
    private final By verifyLogin = By.id("nameofuser");
    private final By signInButton = By.xpath("//button[@onclick=\"logIn()\"]");

//    public LoginPageDemo(WebDriver driver) {
//        super(driver);
//    }

    public void setEmail(String username) {
        WebUI.setText(userNameTextBox, username);
    }

    public void clickButtonLogin() {
        WebUI.clickElement(loginInButton);
    }

    public void setPassword(String password) {
        WebUI.setText(passwordTextBox, password);
    }

    public void clickSignIn() {
        WebUI.clickElement(signInButton);
    }

    @Step("Login method")
    public void login(String username, String password) {
        WebUI.openURL(ConstantGlobal.URL);
        clickButtonLogin();
        setEmail(username);
        setPassword(password);
        clickSignIn();
    }

    @Step("Login method by json")
    public void loginByJson() throws IOException, ParseException {
        WebUI.openURL(ConstantGlobal.URL);
        clickButtonLogin();
        setEmail(ReadJsonFile.getJsonData("users").get("username"));
        setPassword(ReadJsonFile.getJsonData("users").get("password"));
        clickSignIn();
    }

    @Step("verify login after click login button")
    public String verifyLogin() {
        return getText(verifyLogin);
    }

}
