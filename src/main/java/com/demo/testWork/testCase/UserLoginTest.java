package com.demo.testWork.testCase;

import io.qameta.allure.*;
import org.testng.annotations.*;

@Features({@Feature("User Login")})
@Severity(SeverityLevel.NORMAL)
public class UserLoginTest extends BaseCase{

    @Story("User Login Success")
    @Issue("BUG号：123")
    @Link(value = "https://xxxx", url = "https://xxxx")
    @Test(enabled = true)
    public void userLoginTest(){
        PersonDAO personDAO = new PersonDAO();
        String phoneNumber = personDAO.randomPhoneNumber();

        splashPage
                .clickBtnAgree()
                .clickBtnSkip()
                .clickBtnIKnow()
                .clickBtnEnterHomePage();
        homePage.clickBtnRegisterLogin();
        loginPage
                .inputPhoneNumber(phoneNumber)
                .clickBtnNext().sleep(5000)
                .inputVerifyCode("xxxx")
                .clickBtnTermCheck()
                .clickBtnSubmit()
                .clickBtnKeyOne(3)
                .clickBtnKeyTwo(3)
                .clickBtnKeyOne(3)
                .clickBtnKeyTwo(3)
                .clickBtnAction();
        homePage.verifyBtnCheckLimitExist(true)
                .verifyBtnUserAvatarExist(true);
        commonPage.clickBtnNavigateMePage();

        logoutService.logoutService();

        homePage.verifyBtnUserAvatarExist(false);
    }
}
