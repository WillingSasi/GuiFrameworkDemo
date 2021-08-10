package com.demo.testWork.page.home;

import com.demo.testWork.base.PageFactoryBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.springframework.stereotype.Service;

@Service
@Story("SplashPage")
public class HomePage extends PageFactoryBase {

    @iOSXCUITFindBy(iOSNsPredicate = "name == '进入首页'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/iv_to_login")
    private MobileElement btnRegisterLogin;

    @iOSXCUITFindBy(iOSNsPredicate = "name == '立即申请'")
    @AndroidFindBy(accessibility = "立即申请")
    @CacheLookup
    private MobileElement btnApplyNow;

    @iOSXCUITFindBy(iOSNsPredicate = "name == '我知道啦!'")
    @AndroidFindBy(accessibility = "我知道啦!")
    private MobileElement btnIKnow;

    @iOSXCUITFindBy(iOSNsPredicate = "name == '进入首页'")
    @AndroidFindBy(accessibility = "进入首页")
    private MobileElement btnEnterHomePage;

    @iOSXCUITFindBy(iOSNsPredicate = "name == '查看额度'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/cta_btn")
    private MobileElement btnCheckLimit;

    @iOSXCUITFindBy(iOSNsPredicate = "name == '查看额度'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/riv_avatar")
    private MobileElement btnUserAvatar;

    public HomePage(){
        super();
    }

    @Step("clickBtnRegisterLogin")
    public HomePage clickBtnRegisterLogin(){
        btnRegisterLogin.click();
        return this;
    }

    @Step("clickBtnApplyNow")
    public HomePage clickBtnApplyNow(){
        btnApplyNow.click();
        return this;
    }

    @Step("clickBtnIKnow")
    public HomePage clickBtnIKnow(){
        btnIKnow.click();
        return this;
    }

    @Step("clickBtnEnterHomePage")
    public HomePage clickBtnEnterHomePage(){
        btnEnterHomePage.click();
        return this;
    }

    @Step("verifyBtnCheckLimit")
    public HomePage verifyBtnCheckLimitExist(Boolean flag){
        if (flag) {
            Assert.assertTrue(btnCheckLimit.isDisplayed());
        } else {
            Assert.assertFalse(btnCheckLimit.isDisplayed());
        }
        return this;
    }

    @Step("verifyBtnUserAvatar")
    public HomePage verifyBtnUserAvatarExist(Boolean flag){
        if (flag) {
            Assert.assertTrue(btnUserAvatar.isDisplayed());
        } else {
            Assert.assertFalse(btnUserAvatar.isDisplayed());
        }
        return this;
    }
}
