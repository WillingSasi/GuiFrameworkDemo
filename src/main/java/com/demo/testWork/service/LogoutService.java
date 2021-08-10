package com.demo.testWork.service;
import com.demo.testWork.page.home.MePage;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class LogoutService {
    @Resource
    public MePage mePage;
    public void logoutService() {
        mePage
                .clickBtnAppSetting()
                .clickBtnLogout()
                .clickBtnConfirmLogout();
    }
}
