package com.wxsdk.bean;

import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-3
 * Time: 下午10:23
 * To change this template use File | Settings | File Templates.
 */
public class Article extends BaseObject {

    private String title;
    private String description;
    private String picUrl;    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80。
    private String url;     //  点击图文消息跳转链接


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
    }
}
