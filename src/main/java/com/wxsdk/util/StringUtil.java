package com.wxsdk.util;

import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangqisheng
 * Date: 13-5-3
 * Time: 上午12:55
 * To change this template use File | Settings | File Templates.
 */
public class StringUtil {

    public static String encode(String token_, String timeStamp_, String once_) {
        if (StringUtils.isBlank(token_) || StringUtils.isBlank(timeStamp_) || StringUtils.isBlank(once_)) {
            return null;
        }
        List<String> validateStrs = new ArrayList<String>(3);
        StringBuilder stringBuilder = null;
        String encodedStr = null;
        int strLen = 0;
        strLen += (token_ != null ? token_.length() : 0);
        strLen += (timeStamp_ != null ? timeStamp_.length() : 0);
        strLen += (once_ != null ? once_.length() : 0);
        validateStrs.add(token_);
        validateStrs.add(timeStamp_);
        validateStrs.add(once_);
        Collections.sort(validateStrs);
        stringBuilder = new StringBuilder(strLen);
        for (String str : validateStrs) {
            stringBuilder.append(str);
        }
        encodedStr = StringUtil.makeSHA1(stringBuilder.toString());
        return encodedStr;
    }

    public static String makeSHA1(String str_) {
        MessageDigest md = null;
        String encodedStr = null;
        try {
            md = MessageDigest.getInstance("SHA1");
            md.update(str_.getBytes());
            encodedStr = new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            encodedStr = null;
            e.printStackTrace();
        }
        return encodedStr;
    }
}
