package com.demo.testWork.page.home;

import com.demo.testWork.base.PageFactoryBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.springframework.stereotype.Service;
import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

@Service
public class MePage extends PageFactoryBase {

    @iOSXCUITFindBy(iOSNsPredicate = "name == '应用设置'")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"应用设置\")")
    private MobileElement btnAppSetting;

    @iOSXCUITFindBy(iOSNsPredicate = "name == '退出登录'")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"退出登录\")")
    private MobileElement btnLogout;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSNsPredicate = "name == '确认'")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"确认\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"确认\")", priority = 1)
    private MobileElement btnConfirmLogout;

    @Step("clickBtnAppSetting")
    public MePage clickBtnAppSetting(){
        btnAppSetting.click();
        return this;
    }

    @Step("clickBtnLogout")
    public MePage clickBtnLogout(){
        btnLogout.click();
        return this;
    }

    @Step("clickBtnConfirmLogout")
    public MePage clickBtnConfirmLogout(){
        btnConfirmLogout.click();
        return this;
    }
}
