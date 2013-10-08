package com.wxsdk.bean;

import org.dom4j.Element;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-3
 * Time: 下午10:24
 * To change this template use File | Settings | File Templates.
 */
public class PicMessage extends Message {

    private String picUrl;

    public PicMessage(Element element_) {
        super(element_);
        this.setMessageType(MessageType.PIC);
        this.setPicUrl(element_.elementTextTrim("PicUrl"));
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
