package com.demo.testWork.testCase;

import com.demo.testWork.service.LogoutService;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class LogoutNormal extends BaseCase {

    @Feature("Logout")
    @Story("Logout")
    @Test(enabled = true,description = "LogoutNormal")
    public void logoutNormalTest(){

        commonPage.clickBtnNavigateMePage();
        logoutService.logoutService();
        mePage.clickBtnConfirmLogout();
    }

}
