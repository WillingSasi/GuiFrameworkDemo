package com.demo.testWork.service;
import com.demo.testWork.page.home.HomePage;
import com.demo.testWork.page.login.LoginPage;
import com.demo.testWork.page.login.SplashPage;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class LoginService{
    @Resource
    public SplashPage splashPage;
    @Resource
    public HomePage homePage;
    @Resource
    public LoginPage loginPage;
    public void clickSplashPage() {
      splashPage
                .clickBtnAgree()
                .clickBtnSkip()
                .clickBtnIKnow()
                .clickBtnEnterHomePage();
    }

    public void clickLogin() {
        homePage.clickBtnRegisterLogin();
    }

    public void login() {
        loginPage
                .inputPhoneNumber("xxxxxxxxx");
//                .clickBtnNext().sleep(5000)
//                .inputVerifyCode("123098")
//                .clickBtnTermCheck()
//                .clickBtnSubmit();
//        Assert.assertEquals("1", "1");
    }
}
