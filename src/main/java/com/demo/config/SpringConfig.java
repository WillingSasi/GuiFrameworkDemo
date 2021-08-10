package com.demo.config;

import com.demo.testWork.page.common.CommonPage;
import com.demo.testWork.page.home.HomePage;
import com.demo.testWork.page.home.MePage;
import com.demo.testWork.page.login.LoginPage;
import com.demo.testWork.page.login.SplashPage;
import com.demo.testWork.service.LoginService;
import com.demo.testWork.service.LogoutService;
import com.demo.testWork.testCase.BaseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.demo.testWork")
@ComponentScan(basePackages = "com.demo.utils")
public class SpringConfig {

//    @Bean
//    public BaseCase baseCase(){
//        return new BaseCase();
//    }
//
//    @Bean
//    public CommonPage commonPage(){
//        return new CommonPage();
//    }
//
//    @Bean
//    public HomePage homePage(){
//        return new HomePage();
//    }
//
//    @Bean
//    public MePage mePage(){
//        return new MePage();
//    }
//
//    @Bean
//    public LoginPage loginPage(){
//        return new LoginPage();
//    }
//
//    @Bean
//    public SplashPage splashPage(){
//        return new SplashPage();
//    }
//
//    @Bean
//    public LoginService loginService(){
//        return new LoginService();
//    }
//
//    @Bean
//    public LogoutService logoutService(){
//        return new LogoutService();
//    }

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(3000);
        return new RestTemplate(requestFactory);
    }

}
