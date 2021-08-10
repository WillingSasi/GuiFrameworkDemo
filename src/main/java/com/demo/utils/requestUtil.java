package com.demo.utils;

import org.apache.commons.codec.binary.Base64;
import com.demo.utils.Constant.CAPPAuthorization;
import java.nio.charset.Charset;

public class requestUtil {

    public static String getCAPPHeader() {
        String auth = CAPPAuthorization.getAppKey() + ":" + CAPPAuthorization.getSecretKey();
        return createAuthHeader(auth);
    }

    private static String createAuthHeader(String auth){
        String encodedAuth = Base64.encodeBase64String(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        return authHeader;
    }
}
