package com.wxsdk.bean;

import org.dom4j.Element;

/**
 *
 * User: free anuo
 * Date: 13-5-3
 * Time: 下午10:24
 * 图片消息
 */
public class PicMessage extends Message {

    private String picUrl;

    public PicMessage(Element element_) {
        super(element_);
        this.setPicUrl(element_.elementTextTrim("PicUrl"));
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
