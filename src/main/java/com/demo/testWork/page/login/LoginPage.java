package com.demo.testWork.page.login;

import com.demo.testWork.base.PageFactoryBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Story("LoginPage")
public class LoginPage extends PageFactoryBase {

    @iOSXCUITFindBy(iOSNsPredicate = "name=='“请用您的常用手机号登录”'")
    @AndroidFindBy(tagName = "“请用您的常用手机号登录”")
    private MobileElement txtTitle;

    @iOSXCUITFindBy(id = "back button'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/ll_back")
    private MobileElement btnBack;

    @iOSXCUITFindBy(id = "back button'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/ed_clear_edit_text")
    private MobileElement boxEditPhoneNumber;

    @iOSXCUITFindBy(id = "back button'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/btn_new_registration_phone_number_next")
    private MobileElement btnNext;

//    @iOSXCUITFindBy(id = "back button'")
//    @AndroidFindBy(id = "com.homecredit.hccn.customerapp:id/view_code_input")
//    private MobileElement boxEditVerifyCode;

    @iOSXCUITFindBy(id = "back button'")
    @AndroidFindBy(className = "android.widget.EditText")
    private List<MobileElement> boxEditVerifyCode;

    @iOSXCUITFindBy(id = "back button'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/btn_sms_submit")
    private MobileElement btnSubmit;

    @iOSXCUITFindBy(id = "back button'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/cb_term_check")
    private MobileElement btnTermCheck;

    @iOSXCUITFindBy(id = "back button'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/btn_key_1")
    private MobileElement btnKeyOne;

    @iOSXCUITFindBy(id = "back button'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/btn_key_2")
    private MobileElement btnKeyTwo;

    @iOSXCUITFindBy(id = "back button'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/btn_close")
    private MobileElement btnClose;

    @iOSXCUITFindBy(id = "back button'")
    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/btn_action")
    private MobileElement btnAction;


    public LoginPage(){
        super();
    }

    @Step("clickBtnBack")
    public LoginPage clickBtnBack(){
        btnBack.click();
        return this;
    }

    @Step("inputPhoneNumber")
    public LoginPage inputPhoneNumber(String phoneNumber){
        boxEditPhoneNumber.setValue(phoneNumber);
        return this;
    }

    @Step("clickBtnNext")
    public LoginPage clickBtnNext(){
        if (Boolean.parseBoolean(btnNext.getAttribute("enabled"))) {
            btnNext.click();
        }
        return this;
    }

    @Step("inputVerifyCode")
    public LoginPage inputVerifyCode(String verifyCode){
        String[] a = verifyCode.split("");
        for (int index = 0; index < a.length; index++) {
            boxEditVerifyCode.get(index).setValue(a[index]);
        }
        return this;
    }

    @Step("clickBtnSubmit")
    public LoginPage clickBtnSubmit(){
        btnSubmit.click();
        return this;
    }

    @Step("clickBtnTermCheck")
    public LoginPage clickBtnTermCheck(){
        btnTermCheck.click();
        return this;
    }

    @Step("clickBtnKeyOne")
    public LoginPage clickBtnKeyOne(){
        btnKeyOne.click();
        return this;
    }

    @Step("clickBtnKeyOne")
    public LoginPage clickBtnKeyOne(int count){
        for (int i = 0; i < count;i++) {
            btnKeyOne.click();
            sleep(500);
        }
        return this;
    }

    @Step("clickBtnKeyTwo")
    public LoginPage clickBtnKeyTwo(int count){
        for (int i = 0; i < count;i++) {
            btnKeyTwo.click();
            sleep(500);
        }
        return this;
    }

    @Step("clickBtnAction")
    public LoginPage clickBtnAction(){
        btnAction.click();
        return this;
    }

    @Step("sleep")
    public LoginPage sleep(long seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
