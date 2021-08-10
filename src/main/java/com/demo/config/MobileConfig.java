package com.demo.config;

public enum MobileConfig {
    DEVICE_NAME("iphone XsPlus","HuaWei P20"),
    PLATFORM_NAME("iOS","Android"),
    VERSION("12.0","8.0"),
    UDID("xxxx","xxxx"),
//    UDID("00008020-000349A13E90003A","192.168.1.104:5555"),
    AUTOMATION_NAME("XCUITest","UiAutomator2"),
    BUNDLE_ID("com.xxxx.xxxx.xxxx",""),
    APP_PACKAGE("","com.xxxx.xxxx.xxxx"),
    APP_ACTIVITY("","com.xxxx.xxxx.xxxx"),
    XCODE_ORG_ID("xxxx",""),
    XCODE_SIGNING_ID("iPhone Developer",""),
    APP_PATH("xxxx","xxxx");

    private String iOSConfig;
    private String androidConfig;

    MobileConfig(String iOSConfig, String androidConfig){
        this.iOSConfig = iOSConfig;
        this.androidConfig = androidConfig;
    }

    public String getConfig(String mobileName){
        if(mobileName.equals("ios")){
            return iOSConfig;
        }else if(mobileName.equals("android")){
            return androidConfig;
        }else {
            return "";
        }
    }
}
