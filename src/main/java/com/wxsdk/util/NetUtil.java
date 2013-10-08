package com.wxsdk.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * User: free anuo
 * Date: 13-5-4
 * Time: 上午9:19
 * To change this template use File | Settings | File Templates.
 */
public class NetUtil {

    /**
     * //接收请求发来的xml消息体
     *
     * @param request
     * @return
     */
    public static String receiveData(HttpServletRequest request) {
        String inputLine = null;
        StringBuilder receivedStr = new StringBuilder();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            while ((inputLine = in.readLine()) != null) {
                receivedStr.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return receivedStr.toString();
    }
}
