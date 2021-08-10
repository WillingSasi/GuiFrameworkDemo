package com.demo.testWork.page.common;

import com.demo.testWork.base.PageFactoryBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CommonPage extends PageFactoryBase {
    @iOSXCUITFindBy(iOSNsPredicate = "name=='返回")
    @AndroidFindBy(accessibility = "返回")
    private MobileElement btnBack;

    @AndroidFindBy(id = "com.xxxx.xxxx.xxxx:id/linearLayout")
    private List<MobileElement> btnNavigate;



    public CommonPage(){
        super();
    }

    public void clickBtnBack(){
        btnBack.click();
    }

    @Step("clickBtnNavigateMePage")
    public void clickBtnNavigateMePage(){
        btnNavigate.get(3).click();
    }
}
