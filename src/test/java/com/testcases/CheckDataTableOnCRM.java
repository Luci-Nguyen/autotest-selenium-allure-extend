package com.testcases;

import com.common.BaseTest;
import com.pages.ClientPageCRM;
import org.testng.annotations.Test;

public class CheckDataTableOnCRM extends BaseTest {
    @Test
    public void checkDataClientPage(){
        ClientPageCRM clientPageCRM = new ClientPageCRM();
        clientPageCRM.signIn();
        clientPageCRM.openClientPage();
        clientPageCRM.selectClientGroup("Gold");
        clientPageCRM.checkSearchTableByColumn(4, "Gold");
    }
}
