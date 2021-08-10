package com.demo.testWork.testCase;

import com.demo.dao.mode.PersonInfo;
import com.demo.testWork.api.component.LoginOperation;
import com.demo.utils.Constant;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Features({@Feature("User Login")})
@Severity(SeverityLevel.NORMAL)
public class UserLoginTest2 extends BaseCase{

    @Story("User Login Success")
    @Issue("BUG号：123")
    @Link(value = "https://xxxx", url = "https://xxxx")
    @Test(enabled = true)
    public void userLoginTest2(){
        PersonDAO personDAO = new PersonDAO();
        PersonInfo personInfo= personDAO.selectPersonWithRegisterPhone();
        RegisterDAO registerDAO = new RegisterDAO();
        String phoneNumber = registerDAO.checkRegister(personInfo.getPersonId()).getPhoneNumber();
        LoginOperation login = new LoginOperation();
        login.prepareForLogin(personInfo,false);
        splashPage
                .clickBtnAgree()
                .clickBtnSkip()
                .clickBtnIKnow()
                .clickBtnEnterHomePage();
        homePage.clickBtnRegisterLogin();
        loginPage
                .inputPhoneNumber(phoneNumber)
                .clickBtnNext().sleep(5000)
                .inputVerifyCode(Constant.Login.getVerificationcode())
                .clickBtnTermCheck()
                .clickBtnSubmit()
                .clickBtnKeyOne(1)
                .clickBtnKeyTwo(1)
                .clickBtnKeyOne(1)
                .clickBtnKeyTwo(1)
                .clickBtnKeyOne(1)
                .clickBtnKeyTwo(1);
//                .clickBtnAction();
        homePage.verifyBtnCheckLimitExist(true)
                .verifyBtnUserAvatarExist(true);
        commonPage.clickBtnNavigateMePage();

        logoutService.logoutService();

//        homePage.verifyBtnUserAvatarExist(false);
    }
}
