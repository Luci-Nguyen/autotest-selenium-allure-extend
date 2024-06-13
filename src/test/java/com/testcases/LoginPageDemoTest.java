package com.testcases;

import com.common.BaseTest;
import com.constants.ConstantGlobal;
import com.dataprovider.DataProviderManager;
import com.pages.LoginPageDemo;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.testng.Assert.assertEquals;

@Epic("Regression Test v1.0.0")
@Feature("Login Test")
public class LoginPageDemoTest extends BaseTest {
    public LoginPageDemo loginPage;
    @BeforeMethod
    public void loginTest() {
        loginPage = new LoginPageDemo();
    }
//    @Test(priority = 2, dataProvider = "data_provider_login_from_excel_by_row", dataProviderClass = DataProviderManager.class)
//    @Description("Login and verify with data from excel")
//    public void testLoginDataProviderFromExcelByRow(Hashtable<String, String> data) {
//        loginPage.login(data.get("username"), data.get("password"));
//        assertEquals(loginPage.verifyLogin(), "Welcome hoan");
//    }
    @Test(priority = 1, description = "Verify that a valid user can login to the application")
    @Severity(BLOCKER)
    @Description("Verify that a valid user can login to the application")
    @Story("As a user I should be able to login to the application")
    public void testValidLogin() {
        loginPage.login("hoan","123456");
        assertEquals(loginPage.verifyLogin(), ConstantGlobal.VERIFY_LOGIN);
    }

    @Test(priority = 3, description = "Verify that a valid user can login to the application")
    @Severity(BLOCKER)
    @Description("Verify that a valid user can login to the application")
    @Story("As a user I should be able to login to the application")
    public void testLoginByJson() throws IOException, ParseException {
        loginPage.loginByJson();
        assertEquals(loginPage.verifyLogin(), ConstantGlobal.VERIFY_LOGIN);
    }



}
