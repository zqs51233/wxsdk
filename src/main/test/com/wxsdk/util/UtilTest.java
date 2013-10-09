package com.wxsdk.util;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * User: free anuo
 * Date: 13-10-8
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */
public class UtilTest  extends TestCase
{
    @Test
    public void testencode(){
        String token_="a";
        String timeStamp_="1342343";
        String once_="c";
        String encodedStr=StringUtil.encode(token_,timeStamp_,once_);
        Assert.assertNotNull(encodedStr);
        System.out.println(encodedStr);

        token_=null;
        encodedStr=StringUtil.encode(token_,timeStamp_,once_);
        Assert.assertNull(encodedStr);


    }

}
